package com.dmdev.spring.dto;

import com.dmdev.spring.database.entity.Role;
import com.dmdev.spring.validator.UserInfo;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;

    LocalDate birthDate;

    @Size(min = 3, max = 30)
    String firstname;

    String lastname;
    Role role;
    Integer companyId;
}
