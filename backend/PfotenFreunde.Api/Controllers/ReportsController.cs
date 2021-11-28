using Microsoft.AspNetCore.Mvc;
using PfotenFreunde.Shared.Contexts;
using PfotenFreunde.Shared.Models;

namespace PfotenFreunde.Api.Controllers;

[ApiController]
[Route("[controller]")]
public class ReportsController : ControllerBase
{
	private PfotenFreundeContext context;

	public ReportsController(PfotenFreundeContext context)
	{
		this.context = context;
	}
	
    /// <summary>
    /// Gets all open reports
    /// </summary>
    /// <response code="403">Insufficient permissions</response>
    [HttpGet]
    public IEnumerable<Report> GetAll()
    {
        // TODO: Implement this
        return Enumerable.Empty<Report>();
    }

    /// <summary>
    /// Deletes a report
    /// </summary>
    [HttpDelete("{id}")]
    public void Get(int id)
    {
        // TODO: Implement this
    }
}
