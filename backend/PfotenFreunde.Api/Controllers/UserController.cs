using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class UserController : ControllerBase
{
	private PfotenFreundeContext context;

	public UserController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Gets all users
    /// </summary>
    [HttpGet]
    public IEnumerable<User> GetAll()
    {
        // TODO: Implement this
        return Enumerable.Empty<User>();
    }

    /// <summary>
    /// Gets the specified user
    /// </summary>
    [HttpGet("{id}")]
    public User Get(int id)
    {
        // TODO: Implement this
        return null;
    }

    /// <summary>
    /// Deletes the specified user
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    /// <response code="404">User does not exist</response>
    [HttpDelete("{id}")]
    public User Delete(int id)
    {
        // TODO: Implement this
        return null;
    }

    /// <summary>
    /// Pauses the subscription of the specified user
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    /// <response code="404">User does not exist</response>
    [HttpPost("{id}/pause")]
    public User Pause(int id)
    {
        // TODO: Implement this
        return null;
    }

    /// <summary>
    /// Reports the specified user
    /// </summary>
    /// <response code="404">User does not exist</response>
    [HttpPost("{id}/report")]
    public User Report(Report report)
    {
        // TODO: Implement this
        return null;
    }

    /// <summary>
    /// Locks the user for the specified time in milliseconds
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    /// <response code="404">User does not exist</response>
    [HttpPost("{id}/lock")]
    public User Report(ulong time)
    {
        // TODO: Implement this
        return null;
    }
}
