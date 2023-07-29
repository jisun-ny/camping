package com.example.camping.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NormalMemberDto {
    private int id;
    private String username;
    private String email;
    private String password;
}
