package com.neet.qb.model;

/**
 * Created by Phaninder
 */
public class ResponseMessage {

  private String status;
  private String message;

  public ResponseMessage(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

}
