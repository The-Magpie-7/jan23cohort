namespace AnimalPicturesApi.Models;

public class Animal
{
    public long Id { get; set; }
    public string Url {get; set;}
    public string Species {get; set;}
    public string? Gender {get; set;}
    public long AppendageCount {get;set;}
    public bool WillToLive {get; set;}
    public string Climate {get;set;}
    public bool Extinct {get; set;}
}