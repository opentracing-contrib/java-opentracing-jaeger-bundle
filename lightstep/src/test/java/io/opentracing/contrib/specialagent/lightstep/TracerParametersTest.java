package io.opentracing.contrib.specialagent.lightstep;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public final class TracerParametersTest {

  final static String ACCESS_TOKEN = "1234567890";
  final static String COMPONENT_NAME = "mycomponent";
  final static String COLLECTOR_HOST = "127.0.0.1";
  final static String COLLECTOR_PROTOCOL = "http";
  final static String COLLECTOR_PORT = "666";

  @Test
  public void getParameters_fromSystemProperties() {
    System.setProperty(TracerParameters.ACCESS_TOKEN, ACCESS_TOKEN);
    System.setProperty(TracerParameters.COMPONENT_NAME, COMPONENT_NAME);
    System.setProperty(TracerParameters.COLLECTOR_HOST, COLLECTOR_HOST);
    System.setProperty(TracerParameters.COLLECTOR_PROTOCOL, COLLECTOR_PROTOCOL);
    System.setProperty(TracerParameters.COLLECTOR_PORT, COLLECTOR_PORT);

    assertValidParameters(TracerParameters.getParameters());
  }

  @Test
  public void getParameters_fromConfigurationFile() throws Exception {
    Properties props = new Properties();
    props.setProperty(TracerParameters.ACCESS_TOKEN, ACCESS_TOKEN);
    props.setProperty(TracerParameters.COMPONENT_NAME, COMPONENT_NAME);
    props.setProperty(TracerParameters.COLLECTOR_HOST, COLLECTOR_HOST);
    props.setProperty(TracerParameters.COLLECTOR_PROTOCOL, COLLECTOR_PROTOCOL);
    props.setProperty(TracerParameters.COLLECTOR_PORT, COLLECTOR_PORT);

    File file = null;
    try {
      file = File.createTempFile("myconfig", "properties");
      System.setProperty(TracerParameters.CONFIGURATION_FILE_KEY, file.getAbsolutePath());

      try (FileOutputStream stream = new FileOutputStream(file)) {
        props.store(stream, "");
      }

      assertValidParameters(TracerParameters.getParameters());

    } finally {
      if (file != null)
        file.delete();
    }
  }

  static void assertValidParameters(Map<String, String> params) {
    assertNotNull(params);
    assertEquals(ACCESS_TOKEN, params.get(TracerParameters.ACCESS_TOKEN));
    assertEquals(COMPONENT_NAME, params.get(TracerParameters.COMPONENT_NAME));
    assertEquals(COLLECTOR_HOST, params.get(TracerParameters.COLLECTOR_HOST));
    assertEquals(COLLECTOR_PROTOCOL, params.get(TracerParameters.COLLECTOR_PROTOCOL));
    assertEquals(COLLECTOR_PORT, params.get(TracerParameters.COLLECTOR_PORT));
  }
}
