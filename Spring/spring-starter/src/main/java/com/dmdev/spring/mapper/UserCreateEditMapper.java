package com.dmdev.spring.mapper;

import com.dmdev.spring.database.entity.Company;
import com.dmdev.spring.database.entity.User;
import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static java.util.function.Predicate.not;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    private final CompanyRepository companyRepository;

    @Override
    public User map(UserCreateEditDto fromObject, User toObject){
        copy(fromObject,toObject);
        return toObject;
    }

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object,user);
        return user;
    }

    public void copy(UserCreateEditDto object, User user){
        user.setUsername(object.getUsername());
        user.setFirstname(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setBirthDate(object.getBirthDate());
        user.setRole(object.getRole());
        user.setCompany(getCompany(object.getCompanyId()));


        Optional.ofNullable(object.getImage())
                .filter(not(MultipartFile::isEmpty))
                .ifPresent(image -> user.setImage(image.getOriginalFilename()));

    }


    private Company getCompany(Integer companyId){
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }

}
