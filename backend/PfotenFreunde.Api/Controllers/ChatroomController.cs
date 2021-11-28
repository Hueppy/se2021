using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class ChatroomController : ControllerBase
{
	private PfotenFreundeContext context;

	public ChatroomController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Get information of the specified chatroom
    /// </summary>
    /// <param name="id">Id of the chatroom</param>
    /// <response code="403">Insufficient permissions</response>
    [HttpGet("{id}")]
    public Chatroom Get(int id)
    {
        // TODO: Implement this
        return null;
    }

    /// <summary>
    /// Creates a new Chatroom
    /// </summary>
    [HttpPost]
    public void Get(Chatroom chatroom)
    {
        // TODO: Implement this
    }

    /// <summary>
    /// Updates information of a chatroom
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    [HttpPatch]
    public void Patch(Chatroom chatroom)
    {
        // TODO: Implement this
    }

    /// <summary>
    /// Adds a new message to the chatroom
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    [HttpPost("{id}/messages")]
    public void PostMessage(int id, Message message)
    {
        // TODO: Implement this
    }
}
