package spring.service;

import org.springframework.stereotype.Service;
import spring.database.entity.Company;
import spring.database.repository.CompanyRepository;
import spring.dto.CompanyReadDto;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public Optional<CompanyReadDto> findById(Integer id){
      return companyRepository.findById(id).map(entity -> new CompanyReadDto(entity.getId()));
    }


}
