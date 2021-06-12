package com.sda.demo.databaseClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    //@Min(value = 3, message = "First name cannot be shorter than 3 characters")
    //@Max(value = 16, message = "First name cannot be longer than 16 characters")
    @Length(min=3, message = "First name cannot be shorter than 3 characters")
    @Length(max = 16, message = "First name cannot be longer than 16 characters")
    @NotNull
    private String firstName;
    //@Min(value = 3, message = "Last name cannot be shorter than 3 characters")
    //@Max(value = 16, message = "Last name cannot be longer than 16 characters")
    @Length(min=3, message = "Last name cannot be shorter than 3 characters")
    @Length(max = 16, message = "Last name cannot be longer than 16 characters")
    private String lastName;
    @Email
    @NotNull
    private String email;
    @PESEL
    @NotNull
    private String pesel;
    @DecimalMin(value = "2.0")
    @DecimalMax(value = "5.0")
    @Digits(integer=1, fraction = 2)
    @NotNull
    private double grade;
    @Length(max = 3)
    @NotNull
    private String universityName;

}
