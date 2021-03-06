using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class LoginController : ControllerBase
{
	private PfotenFreundeContext context;
    private IPasswordHasher<Login> hasher;

	public LoginController(
        PfotenFreundeContext context,
        IPasswordHasher<Login> hasher)
	{
		this.context = context;
        this.hasher = hasher;
	}

    /// <summary>
    /// Creates a new login
    /// </summary>
    /// <response code="403">Login already exists</response>
    [AllowAnonymous]
    [HttpPost]
    public async Task<ActionResult> Post(string email, string password)
    {
        if (context.Logins.Any((x) => x.Email == email))
        {
            return Forbid();
        }
        
        var login = new Login()
        {
            Email = email,
            Role = Role.User
        };
        login.PasswordHash = this.hasher.HashPassword(login, password);

        await context.Logins.AddAsync(login);
        await context.SaveChangesAsync();
        
        return Ok();
    }
}
