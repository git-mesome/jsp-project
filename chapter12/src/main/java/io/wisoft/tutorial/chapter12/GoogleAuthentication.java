package io.wisoft.tutorial.chapter12;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
  PasswordAuthentication passwordAuth;

  public GoogleAuthentication() {
    passwordAuth = new PasswordAuthentication("kjydev1234@gmail.com", "Dev1234!");
  }

  public PasswordAuthentication getPasswordAuth() {
    return passwordAuth;
  }
}
