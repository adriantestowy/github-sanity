package com.github.com.testData;

import lombok.Data;

@Data
public class Users {

  private User basicUser;

  @Data
  public static class User implements UserInterface {

    protected String username;
    protected String password;
    protected String token;
  }
}
