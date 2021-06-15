# Build and run locally
mvn clean compile quarkus:dev

# Build and run on OpenShift (without Kafka)
1.) Install kogito operator into a particular namespace
2.) Deploy the kogito build and runtime from the deploy folder
- change git url if necessary in build file

# Test
curl -X POST http://localhost:8080/incomingOrder -H 'content-type: application/json' -H 'accept: application/json' -d @src/test/data/incomingOrder_post1.json | jq .

curl -X POST http://orders-kogito-rhi.apps.ocp4.home.glroland.com/incomingOrder -H 'content-type: application/json' -H 'accept: application/json' -d @src/test/data/incomingOrder_post1.json | jq . 
