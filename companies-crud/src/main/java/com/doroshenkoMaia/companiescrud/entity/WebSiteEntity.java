package com.doroshenkoMaia.companiescrud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "web_site")
public class WebSiteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigInteger id_company;
    private String name;
    @Column(columnDefinition = "category")
    @Enumerated(value =EnumType.STRING)
    private CategoryEnum category;
    private String description;
}
