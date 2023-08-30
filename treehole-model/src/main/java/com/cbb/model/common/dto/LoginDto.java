package com.cbb.model.common.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String code;
}
