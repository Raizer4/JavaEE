package com.dmdev.spring.service;

import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.dto.CompanyReadDto;
import com.dmdev.spring.listener.entity.AccessType;
import com.dmdev.spring.listener.entity.EntityEvent;
import com.dmdev.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyReadMapper companyReadMapper;

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id).map(entity -> {
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return new CompanyReadDto(entity.getId(),null);
        });
    }

    public List<CompanyReadDto> findAll(){
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }

}
