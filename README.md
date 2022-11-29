# Security Info Application
This application is connected to two APIs to fetch
* General security information news
* Security information videos

## External System Interacitons
<ul>
    <li> System A: https://news-api-78bda.web.app/general-news: to fetch general news</li>
    <li> System B: https://news-api-78bda.web.app/video-news: to fetch video news</li>
</ul>

## Development
### Technology Stack
Java 11, Maven, Spring Boot 2

### Modules
<ul>
    <li>application - Application entry point to fetch information and details</li>
</ul>

### Health-Check
http://localhost:8080/actuator/health

### Required Environment variables
<ul>
    <li><b>NEWS_PWD</b> Password to API Endpoint to fetch general news</li>
</ul>
