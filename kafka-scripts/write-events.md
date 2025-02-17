Write two string events into the test-topic topic using the console producer that ships with Kafka:

> ./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test-topic

This command will wait for input at a `>` prompt.   
Enter `hello`, press `Enter`, then `world`, and press `Enter` again.  
Enter `Ctrl+C` to exit the console producer.