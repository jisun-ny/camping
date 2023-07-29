package com.example.camping.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminMemberDto {
    private int id;
    private String username;
    private String email;
    private String password;

    AdminMemberDto member = AdminMemberDto.builder()
            .id(1)
            .username("admin")
            .email("admin@gmail.com")
            .password("1234")
            .build();
}
