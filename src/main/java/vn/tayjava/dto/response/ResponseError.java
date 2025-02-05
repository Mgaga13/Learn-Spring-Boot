package vn.tayjava.dto.response;

import vn.tayjava.dto.response.ResponseData;

public class ResponseError extends ResponseData {

  public ResponseError(int status, String message) {
    super(status, message);
  }
}