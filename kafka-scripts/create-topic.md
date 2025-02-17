A topic is a logical grouping of events in Kafka. From inside the container, create a topic called test-topic:

> ./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test-topic