# Setup
Install infinispan
- add user "developer" and "password1"
- infinispan-server-12.1.4.Final % bin/cli.sh user create developer -p password1 -g admin
- server must be running before running kogito applications
- infinispan-server-12.1.4.Final % bin/server.sh
Install Kafka
- kafka_2.13-2.8.0 % bin/zookeeper-server-start.sh config/zookeeper.properties
- Edit server.properties to enable PLAIN 9092
- kafka_2.13-2.8.0 % bin/kafka-server-start.sh config/server.properties
- Create inbound and outbound topics (optional - kogito seems to do this automatically when allowed to)
- kafka_2.13-2.8.0 % bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic orders_kogito_inbound --create
- kafka_2.13-2.8.0 % bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic orders_kogito_outbound --create

# Build and run locally
mvn clean compile quarkus:dev

# Build and run on OpenShift (without Kafka)
1.) Install kogito operator into a particular namespace
2.) Deploy the kogito build and runtime from the deploy folder
- change git url if necessary in build file

# Test
curl -X POST http://localhost:8080/incomingOrder -H 'content-type: application/json' -H 'accept: application/json' -d @src/test/data/incomingOrder_post1.json | jq .

curl -X POST http://orders-kogito-rhi.apps.ocp4.home.glroland.com/incomingOrder -H 'content-type: application/json' -H 'accept: application/json' -d @src/test/data/incomingOrder_post1.json | jq . 

# Supporting Services

# Indexer run locally
java  -Dquarkus.infinispan-client.auth-username=developer -Dquarkus.infinispan-client.auth-password=password1 -jar data-index-service-infinispan-1.7.0.Final-runner.jar

