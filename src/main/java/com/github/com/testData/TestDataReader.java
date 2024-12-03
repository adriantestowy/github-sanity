package com.github.com.testData;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import lombok.Getter;
import lombok.SneakyThrows;

public class TestDataReader {

  ObjectMapper objectMapper = new ObjectMapper();
  String testDataResourcePath = "testData/";

  @Getter private Users users;

  public TestDataReader() {
    setUsers();
  }

  @SneakyThrows
  private void setUsers() {
    InputStream inputStream =
        getClass().getClassLoader().getResourceAsStream(testDataResourcePath + "users.json");
    users = objectMapper.readValue(inputStream, Users.class);
  }
}
