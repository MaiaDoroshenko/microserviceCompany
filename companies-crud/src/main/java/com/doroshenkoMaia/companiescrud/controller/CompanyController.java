package com.doroshenkoMaia.companiescrud.controller;

import com.doroshenkoMaia.companiescrud.Service.abstractService.CompanyService;
import com.doroshenkoMaia.companiescrud.entity.CompanyEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {
    private final CompanyService companyService;

    @Operation(summary = "Get a Company given a company name ")
    @GetMapping(path = "{name}")
    private ResponseEntity<CompanyEntity> getreadByName(@PathVariable String name) {
        log.info("GET: company {}", name);
        return ResponseEntity.ok(companyService.readByName(name));
    }
    @Operation(summary = "Post in DB a Company given a company from body ")
    @PostMapping("/create")
    public ResponseEntity<CompanyEntity> createCompany(@RequestBody CompanyEntity company) {
        log.info("POST: company {}", company.getName());
        // return ResponseEntity.created(URI.create(this.companyService.createCompany(company).getName())).build();

        CompanyEntity createdCompany = this.companyService.createCompany(company);
        String encodedCompanyName;
        encodedCompanyName = URLEncoder.encode(createdCompany.getName(), StandardCharsets.UTF_8);
        URI location = URI.create("/companies/" + encodedCompanyName);
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update in DB a Company given a company from body ")
    @PutMapping(path = "{name}")
    private ResponseEntity<CompanyEntity> updateCompany(@RequestBody CompanyEntity company, @PathVariable String name) {
        log.info("PUT : company {}", name);
        return ResponseEntity.ok(companyService.updateCompany(company, name));

    }
    @Operation(summary = "Delete a Company")
    @DeleteMapping(path = "{name}")
    private ResponseEntity<?> deleteCompany(@PathVariable String name) {
        log.info("DELETE: company {}", name);
        companyService.deleteCompany(name);
        return ResponseEntity.noContent().build();
    }
}
