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

### Api Documentation
The provided REST API is documented via OpenAPI 3.0
and JSON can be reached with url:
http://localhost:8080/v3/api-docs/

reach it with swagger-ui:
http://localhost:8080/swagger-ui/index.html

### Health-Check
http://localhost:8080/actuator/health

### Database
For local development H2 is used;
Start application and connect to H2 via http://localhost:8080/h2-console/

### Required Environment variables
<ul>
    <li><b>NEWS_PWD</b> Password to API Endpoint to fetch general news</li>
</ul>
