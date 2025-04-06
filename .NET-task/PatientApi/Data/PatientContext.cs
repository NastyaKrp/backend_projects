namespace PatientApi.Data
{
    using Microsoft.EntityFrameworkCore;
    using PatientApi.Models;

    public class PatientContext : DbContext
    {
        public PatientContext(DbContextOptions<PatientContext> options) : base(options) { }

        public DbSet<Patient> Patients { get; set; }
    }
}
