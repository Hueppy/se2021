using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Shared.Controllers;

[ApiController]
[Route("[controller]")]
public class ChronicleController : ControllerBase
{
    private PfotenFreundeContext context;

    public ChronicleController(PfotenFreundeContext context)
    {
        this.context = context;
    }

    /// <summary>
    /// Gets information of the chronicle
    /// </summary>
    [HttpGet("{id}")]
    public Chronicle Get(int id)
    {
        // TODO: Implement this
        return null;
    }

    /// <summary>
    /// Adds a new post to the chronicle
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    [HttpPost("{id}/post")]
    public void Post(int id, Post post)
    {
        // TODO: Implement this
    }
}
