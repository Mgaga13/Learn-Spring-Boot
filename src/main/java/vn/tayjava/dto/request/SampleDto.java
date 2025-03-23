package vn.tayjava.dto.request;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.MODULE)
public class SampleDto implements Serializable {

  private Integer id;

  private  String name;
}
