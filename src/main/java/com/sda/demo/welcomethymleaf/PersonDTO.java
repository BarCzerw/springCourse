package com.sda.demo.welcomethymleaf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long personId;
    @NotNull
    @Size(min = 3, max = 16)
    private String firstName;
    @NotNull
    @Size(min = 3, max = 40)
    private String lastName;
    @NotNull
    @Min(0)
    private int age;
}
