package com.doroshenkoMaia.companiescrud.Service.serviceImpl;

import com.doroshenkoMaia.companiescrud.Service.abstractService.CompanyService;
import com.doroshenkoMaia.companiescrud.entity.CategoryEnum;
import com.doroshenkoMaia.companiescrud.entity.CompanyEntity;
import com.doroshenkoMaia.companiescrud.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public CompanyEntity readByName(String name) {
        return companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("company not found"));
    }
    @Override
    public CompanyEntity createCompany(CompanyEntity company) {
        company.getWebSites().forEach(webSites -> {
            if (Objects.isNull(webSites)) {
                webSites.setCategory(CategoryEnum.NONE);
            }
        });
        return companyRepository.save(company);
    }
    @Override
    public CompanyEntity updateCompany(CompanyEntity company, String name) {
        var companyToUpdate = companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("company not found"));
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundation_date(company.getFoundation_date());
        companyToUpdate.setFounder(company.getFounder());
        return companyRepository.save(companyToUpdate);

    }
    @Override
    public void deleteCompany(String name) {
        var companyToDelete = companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("company not found"));
        companyRepository.delete(companyToDelete);
    }
}
