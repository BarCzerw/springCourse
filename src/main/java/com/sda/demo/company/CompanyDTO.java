package com.sda.demo.company;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.PESEL;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.NotNull;

@Data
public class CompanyDTO {

    @Length(min=3, max = 30, message = "Company name should be between 3 and 30 characters")
    @NotNull
    private String name;
    @NIP
    @NotNull
    private String nip;
    @REGON
    @NotNull
    private String regon;
    @Length(min = 9, max=9)
    @NotNull
    private String phoneNumber;
    @Length(min=2, max = 16, message = "Owner's first name should be between 2 and 16 characters")
    private String ownerFirstName;
    @Length(min=2, max = 30, message = "Owner's last name should be between 2 and 16 characters")
    private String ownerLastName;
    @PESEL
    @NotNull
    private String ownerPesel;

}
