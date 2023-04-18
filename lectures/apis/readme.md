# C# API NOTES

## Add the following packages
dotnet add package Microsoft.VisualStudio.Web.CodeGeneration.Design -v 6.0.0
dotnet add package Microsoft.EntityFrameworkCore.Design -v 6.0.0
dotnet add package Microsoft.EntityFrameworkCore.SqlServer -v 6.0.0
dotnet add package Microsoft.AspNetCore.Cors


## Upates tools
dotnet tool uninstall -g dotnet-aspnet-codegenerator
dotnet tool install -g dotnet-aspnet-codegenerator --version 6.0.13

## Auto create controller
dotnet-aspnet-codegenerator controller -name AnimalController -async -api -m Animal -dc AnimalContext -outDir Controllers

