# Jaeger Tracer bundle.

This section uses the `TracerResolver` support defined as part of Jaeger, which means that on top of specifying parameters through a configutation file, they can specified as environment variables and system properties.

If a `tracer.properties` file is defined, the listed parameters will exported as System properties (as long as they are not **already** defined).

`JAEGER_SERVICE_NAME` is the only required parameter.

## Implementation

The `jaeger-thrift` artifact is bundled as the selected component to send Spans to the backend.
