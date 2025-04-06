using System;
using System.Net.Http;
using System.Net.Http.Json;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        var client = new HttpClient();
        client.BaseAddress = new Uri("https://localhost:7054/api/Patients"); 

        for (int i = 0; i < 100; i++)
        {
            var patient = new
            {
                id = Guid.NewGuid(),
                family = "Иванов",
                given = new[] { "Иван", "Иванович" },
                gender = "male",
                birthDate = DateTime.Now.AddDays(-i),
                active = true
            };

            var response = await client.PostAsJsonAsync("Patients", patient); 
            if (!response.IsSuccessStatusCode)
            {
                Console.WriteLine($"Failed to create patient {i + 1}. Status code: {response.StatusCode}");
            }
        }
    }
}
