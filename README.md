# Build and run locally
mvn clean compile quarkus:dev

# Test
curl -X POST http://localhost:8080/incomingOrder -H 'content-type: application/json' -H 'accept: application/json' -d @src/test/data/incomingOrder_post1.json | jq .

