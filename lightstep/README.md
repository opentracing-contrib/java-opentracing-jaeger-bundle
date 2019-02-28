# LightStep Tracer bundle.

`TracerFactory` implementation is defined as part of this section, and can be configured through the usual `tracer.properties` file:

```properties
ls.accessToken=myaccesstoken
ls.componentName=MyApplication
ls.collectorHost=collector.lightstep.com
ls.collectorProtocol=https
ls.collectorPort=66631
``` 

Parameters can be overriden through System properties, too:

```
java -cp:$MYCLASSPATH:lightstep.jar \
	-Dls.componentName=AnotherService \
	com.mycompany.MyService
```

## Parameters

LightStep Tracer parameters use the prefix `ls.`. The only required parameter is `ls.accessToken`, and no Tracer will be created if this parameter is missing. In case of error, a log showing the error will be shown.

Common parameters are:

|Parameter | Type|
|----------|-----|
|ls.accessToken | String|
|ls.componentName | String|
|ls.collectorHost | String|
|ls.collectorProtocol | http or https|
|ls.collectorPort | Integer larger than 0|
