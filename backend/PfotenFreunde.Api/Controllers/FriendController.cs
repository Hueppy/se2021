using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class FriendController : ControllerBase
{
	private PfotenFreundeContext context;

	public FriendController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Retrieves friend list of user
    /// </summary>
    [HttpGet("{userId}")]
    public IEnumerable<User> GetAll(int userId)
    {
        // TODO: Implement this
        return Enumerable.Empty<User>();
    }

    /// <summary>
    /// Sends a friend request to the specified user
    /// </summary>
    /// <response code="400">User is already befriended</response>
    [HttpPost("{userId}")]
    public void Create(int userId)
    {
        // TODO: Implement this
    }

    /// <summary>
    /// Removes a friendship
    /// </summary>
    /// <response code="400">User is not befriended</response>
    [HttpDelete("{userId}")]
    public void Destroy(int userId)
    {
        // TODO: Implement this
    }
}
