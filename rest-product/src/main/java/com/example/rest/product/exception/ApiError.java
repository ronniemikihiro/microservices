package com.example.rest.product.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
