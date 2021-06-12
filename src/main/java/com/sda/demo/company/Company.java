package com.sda.demo.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String nip;
    private String regon;
    private String ownerPesel;
    private String phoneNumber;
    private String ownerFirstName;
    private String ownerLastName;

    public Company(CompanyDTO companyDTO) {
        setFromDto(companyDTO);
    }

    public void setFromDto(CompanyDTO companyDTO) {
        this.name = companyDTO.getName();
        this.nip = companyDTO.getNip();
        this.regon = companyDTO.getRegon();
        this.ownerPesel = companyDTO.getOwnerPesel();
        this.phoneNumber = companyDTO.getPhoneNumber();
        this.ownerFirstName = companyDTO.getOwnerFirstName();
        this.ownerLastName = companyDTO.getOwnerLastName();
    }
}
