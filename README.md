Сервис запускается на порте: 8080

Примеры POST запросов и ответов:
Запрос:
{
"url": "https://spring.io/projects/spring-boot"
}
Ответ:
{
"originalUrl": "https://spring.io/projects/spring-boot",
"shortUrl": "http://localhost:8080/jbwPB9d",
"shortCode": "jbwPB9d",
"visitCount": 0,
"lastVisitedAt": null,
"createdAt": "2026-10-20T08:22:25.140099821"
}

Запрос:
{
"url": "not-url"
}

Ответ: 400 Bad Request

Запрос:
{
"url": ""
}
Ответ:
{
"timestamp": "2026-10-20T08:26:49.548+00:00",
"status": 400,
"error": "Bad Request",
"path": "/api/shorten"
}

Пример GET запроса в Postman при выключенной автоматической переадресации:
Запрос: http://localhost:8080/jbwPB9d

Ответ: 302 Found