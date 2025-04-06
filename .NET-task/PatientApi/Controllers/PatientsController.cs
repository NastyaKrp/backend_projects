using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using PatientApi.Data;
using PatientApi.Models;

namespace PatientApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PatientsController : Controller
    {
        private readonly PatientContext _context;

        public PatientsController(PatientContext context)
        {
            _context = context;
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Patient>> GetPatient(Guid id)
        {
            var patient = await _context.Patients.FindAsync(id);
            if (patient == null)
            {
                return NotFound();
            }
            return patient;
        }

        [HttpPost]
        public async Task<ActionResult<Patient>> PostPatient(Patient patient)
        {
            _context.Patients.Add(patient);
            await _context.SaveChangesAsync();
            return CreatedAtAction(nameof(GetPatient), new { id = patient.Id }, patient);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutPatient(Guid id, Patient patient)
        {
            if (id != patient.Id)
            {
                return BadRequest();
            }
            _context.Entry(patient).State = EntityState.Modified;
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_context.Patients.Any(e => e.Id == id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeletePatient(Guid id)
        {
            var patient = await _context.Patients.FindAsync(id);
            if (patient == null)
            {
                return NotFound();
            }
            _context.Patients.Remove(patient);
            await _context.SaveChangesAsync();
            return NoContent();
        }

        [HttpGet("search")]
        public async Task<ActionResult<IEnumerable<Patient>>> SearchPatients([FromQuery] DateTime birthDate)
        {
            return await _context.Patients.Where(p => p.BirthDate.Date == birthDate.Date).ToListAsync();
        }
    }
}
