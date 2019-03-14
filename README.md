[![Build Status](https://travis-ci.org/opentracing-contrib/java-opentracing-jaeger.png)](https://travis-ci.org/opentracing-contrib/java-opentracing-jaeger)

# OpenTracing Jaeger Tracer Bundle

OpenTracing [Jaeger Client](https://github.com/jaegertracing/jaeger-client-java) Bundle. It builds on top of the [java-client](https://github.com/jaegertracing/jaeger-client-java/tree/master/jaeger-client) artifact, which uses `Thrift`.

This project builds a fat-jar with all its dependencies, along with simple configuration, in order to ease deployment, which can then be retrieved using the `TracerFactory` pattern (from [java-tracerresolver](https://github.com/opentracing-contrib/java-tracerresolver) ). It can be used with any OpenTracing instrumentation library.

```sh
java -cp:$MYCLASSPATH:jaeger-client-bundle-SNAPSHOT.jar com.mycompany.MyService
```

## Development

```sh
mvn package
```

## License

[Apache 2.0 License](./LICENSE).
