
FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY ["PatientApi/PatientApi.csproj", "PatientApi/"]
RUN dotnet restore "PatientApi/PatientApi.csproj"
COPY . .
WORKDIR "/src/PatientApi"
RUN dotnet build "PatientApi.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "PatientApi.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "PatientApi.dll"]

FROM mcr.microsoft.com/mssql/server:2019-latest
ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=Your_password123
EXPOSE 1433