using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class PersonController : ControllerBase
{
	private PfotenFreundeContext context;

	public PersonController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Gets information about the specified person
    /// </summary>
    [HttpGet("{id}")]
    public IEnumerable<Person> Get(int id)
    {
        // TODO: Implement this
        return Enumerable.Empty<Person>();
    }

    /// <summary>
    /// Adds a new person
    /// </summary>
    [HttpPost]
    public void Post(Person institution)
    {
        // TODO: Implement this
    }

    /// <summary>
    /// Updates information of the specified person
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    [HttpPatch("{id}")]
    public void Patch(int id, Person institution)
    {
        // TODO: Implement this
    }

    /// <summary>
    /// Gets the list of pets of the specified person
    /// </summary>
    [HttpGet("{id}/Pets")]
    public IEnumerable<int> GetPets(int id)
    {
        // TODO: Implement this
        return null;
    }
}
