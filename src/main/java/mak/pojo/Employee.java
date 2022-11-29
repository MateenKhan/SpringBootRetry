package mak.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@ApiModel(value = "Employee Object")
public class Employee {

    public Employee() {
    }


    @ApiModelProperty(hidden = true, notes = "do not give this property as this is auto generated", example = "delete this filed")
    Integer id;
    @ApiModelProperty(example = "Mateen")
    String name;
    @ApiModelProperty(example = "32")
    Integer age;

}
