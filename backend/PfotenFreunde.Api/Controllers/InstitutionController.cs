using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class InstitutionController : ControllerBase
{
	private PfotenFreundeContext context;

	public InstitutionController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Gets information about the institution
    /// </summary>
    [HttpGet]
    public IEnumerable<Institution> Get()
    {
        // TODO: Implement this
        return Enumerable.Empty<Institution>();
    }

    /// <summary>
    /// Creates a new institution
    /// </summary>
    [HttpPost]
    public int Post(Institution institution)
    {
        // TODO: Implement this
        return int.MinValue;
    }

    /// <summary>
    /// Updates information of an institution
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    [HttpPatch("{id}")]
    public void Patch(int id, Institution institution)
    {
        // TODO: Implement this
    }
}
