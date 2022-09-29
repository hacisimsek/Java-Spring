package com.springbootapidoc.SpringBootApiDoc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet", description = "Pet model")
public class Pet {
    @ApiModelProperty(value = "Pet id", example = "1")
    private int id;

    @ApiModelProperty(value = "Pet name", example = "Dog")
    private String name;

    @ApiModelProperty(value = "Pet birth date", example = "2019-01-01")
    private Date date;
}
