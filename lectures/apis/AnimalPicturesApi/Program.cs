using Microsoft.EntityFrameworkCore;
using AnimalPicturesApi.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddDbContext<AnimalContext>(opt => opt.UseInMemoryDatabase("AnimalList"));

// Add Cors to container
builder.Services.AddCors(options => {
    options.AddDefaultPolicy(builder => {
        builder.AllowAnyOrigin().AllowAnyHeader().AllowAnyMethod();
    });
});

// Add Swagger to container
builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseCors();

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
