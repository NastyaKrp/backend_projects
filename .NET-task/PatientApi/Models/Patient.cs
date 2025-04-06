namespace PatientApi.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class Patient
    {
        [Key]
        public Guid Id { get; set; }
        [Required]
        public string Family { get; set; }
        public string[] Given { get; set; }
        public string Gender { get; set; }
        [Required]
        public DateTime BirthDate { get; set; }
        public bool Active { get; set; }
    }
}