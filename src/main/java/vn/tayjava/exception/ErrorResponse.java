package vn.tayjava.exception;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse implements Serializable {
  private Date timeStamp;
  private int status;
  private String path;
  private String error;
  private String message;


}
