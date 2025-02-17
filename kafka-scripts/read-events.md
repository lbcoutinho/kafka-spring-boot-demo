Now read the events in the `test-topic` topic from the beginning of the log:

>  ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning

You will see the two strings that you previously produced:
```
hello
world
```

The consumer will continue to run until you exit out of it by entering `Ctrl+C`.