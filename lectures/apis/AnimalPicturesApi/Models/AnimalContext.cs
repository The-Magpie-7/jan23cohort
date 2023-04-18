using Microsoft.EntityFrameworkCore;

namespace AnimalPicturesApi.Models;

public class AnimalContext : DbContext
{
    public AnimalContext(DbContextOptions<AnimalContext> options)
        : base(options)
    {
    }

    public DbSet<Animal> Animals { get; set; } = null!;
}