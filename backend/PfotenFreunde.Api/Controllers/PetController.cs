using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class PetController : ControllerBase
{
	private PfotenFreundeContext context;

	public PetController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Gets information about the specified pet
    /// </summary>
    [HttpGet("{id}")]
    public Pet Get(int id)
    {
        // TODO: implement this
        return null;
    }

    /// <summary>
    /// Adds a new pet
    /// </summary>
    [HttpPost]
    public void Post(Pet pet)
    {
        // TODO: implement this
    }

    /// <summary>
    /// Updates information about the specified pet
    /// </summary>
    [HttpPatch("{id}")]
    public void Patch(int id, Pet pet)
    {
        // TODO: implement this
    }

    /// <summary>
    /// Deletes the specified pet
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    /// <response code="404">Pet does not exist</response>
    [HttpDelete("{id}")]
    public void Delete(int id, Pet pet)
    {
        // TODO: implement this
    }
}
