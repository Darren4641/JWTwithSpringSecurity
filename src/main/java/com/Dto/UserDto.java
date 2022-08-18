package com.Dto;

import com.Model.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String email;
    private String gender;
    private String phone;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Users toEntity() {
        return Users.builder()
                .id(id)
                .password(password)
                .email(email)
                .gender(gender)
                .build();
    }

    @Builder
    public UserDto(String id, String password, String email, String gender) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }
}

