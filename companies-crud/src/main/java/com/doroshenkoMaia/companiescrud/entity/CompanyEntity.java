package com.doroshenkoMaia.companiescrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String founder;
    private String logo;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate foundation_date;
    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_company",referencedColumnName = "id")
    private List<WebSiteEntity>webSites;
}
