[![Build Status](https://travis-ci.org/opentracing-contrib/java-tracers.png)](https://travis-ci.org/opentracing-contrib/java-tracers)

# OpenTracing Java Tracers

OpenTracing-compliant Tracer bundles.

This project builds a fat-jar of each supported Tracer, along with simple configuration, in order to ease deployment, which can then be retrieved using the `TracerResolver` pattern (from [java-tracerresolver](https://github.com/opentracing-contrib/java-tracerresolver) ).

* [Jaeger](./jaeger)
* [LightStep](./lightstep)

## Configuration

In addition to the built-in initialization logic provided by each `TracerFactory` (such as environment variables), Tracer parameters can be specified through a properties file, which defaults to `tracer.properties`:

```properties
-- tracer.properties --
JAEGER_SERVICE_NAME=MyInstrumentedService
```

This file can be explicitly specified through the `tracer.configurationFile` System property:

```sh
java -cp:$MYCLASSPATH:jaeger.jar \
	-Dtracer.configurationFile=configuration/tracer_config.properties \
	com.mycompany.MyService
```

For detailed usage, refer to each Tracer section README.

## Development

To build all the jars:

```sh
mvn package
```

To build only one, specify the Tracer:

```sh
mvn package -pl jaeger -am
```

## License

[Apache 2.0 License](./LICENSE).
