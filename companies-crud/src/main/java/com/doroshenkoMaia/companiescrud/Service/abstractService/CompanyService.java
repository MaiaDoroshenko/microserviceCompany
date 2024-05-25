package com.doroshenkoMaia.companiescrud.Service.abstractService;

import com.doroshenkoMaia.companiescrud.entity.CompanyEntity;
import org.springframework.stereotype.Service;


public interface CompanyService {
    CompanyEntity readByName(String name);
    CompanyEntity createCompany(CompanyEntity company);
    CompanyEntity updateCompany(CompanyEntity company,String name);
    void deleteCompany(String name);



}
