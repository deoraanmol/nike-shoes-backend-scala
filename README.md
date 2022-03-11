### Nike Interview Backend Code Challenge [Scala]

_The provided code document should contain more details._

Start server (Port 8081): `sbt run` (You will need to install `sbt` & you can use `Intellij` to build/run this project)

APIs:

1. Get original price (randomly fetched) for a supplied shoe id:
```
URL (GET) - http://localhost:8081/api/shoe-price/1

Response:
{
    "shoePrice": 147
}
```