package com.greenfoxacademy.metrics;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class Metrics {

  /**
   * @author Greenfoxacademy
   */

  public static void send(String template, String serviceName) {
    JSONObject json = new JSONObject();
    json.put("time", System.currentTimeMillis());
    json.put("level", template);
    json.put("service_name", serviceName);

    CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    try {
      HttpPost request = new HttpPost("http://52.47.59.43/event");
      StringEntity params = new StringEntity(json.toString());
      request.addHeader("content-type", "application/json");
      request.setEntity(params);
      httpClient.execute(request);
      httpClient.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
