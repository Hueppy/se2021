using System.Reflection;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Identity;
using Microsoft.OpenApi.Models;
using PfotenFreunde.Api.Filters;
using PfotenFreunde.Api.Handlers;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Services;
using PfotenFreunde.Shared.Models;
using PfotenFreunde.Api.Services;
using Microsoft.AspNetCore.Mvc.Authorization;
using Microsoft.AspNetCore.Authorization;
using System.Security.Claims;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddDbContext<PfotenFreundeContext>();
builder.Services.AddScoped<IAuthenticationService, AuthenticationService>();
builder.Services.AddScoped<IPasswordHasher<Login>, PasswordHasher>();
builder.Services.AddScoped<IAuthenticator, Authenticator>();

builder.Services.AddAuthentication("Basic")
	.AddScheme<AuthenticationSchemeOptions, BasicAuthenticationHandler>("Basic", (o) => {});

builder.Services.AddControllers((c) => 
{
	var policy = new AuthorizationPolicyBuilder()
		.RequireClaim(ClaimTypes.Email)
		.Build();
	c.Filters.Add(new AuthorizeFilter(policy));
});
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(c =>
{
	c.SupportNonNullableReferenceTypes();

	c.AddSecurityDefinition("basic", new OpenApiSecurityScheme
	{
		Name = "Basic Authorization",
		Type = SecuritySchemeType.Http,
		Scheme = "basic",
		In = ParameterLocation.Header,
		Description = "Basic authorization header using the bearer scheme"
	});
	c.AddSecurityRequirement(new OpenApiSecurityRequirement()
	{
		{
		    new OpenApiSecurityScheme
		    {
			    Reference = new OpenApiReference
   			    {
   				    Type = ReferenceType.SecurityScheme,
				    Id = "basic"
			    }
		    },
			new string[] {}
		}
	});
    
    // Set the comments path for the Swagger JSON and UI.
    var xmlFile = $"{Assembly.GetExecutingAssembly().GetName().Name}.xml";
    var xmlPath = Path.Combine(AppContext.BaseDirectory, xmlFile);
    c.IncludeXmlComments(xmlPath);

	c.SchemaFilter<EnumMemberSchemaFilter>();
	c.UseInlineDefinitionsForEnums();
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseRouting();

//app.UseAuthorization();
app.UseAuthentication();

app.MapControllers();

app.Run();
