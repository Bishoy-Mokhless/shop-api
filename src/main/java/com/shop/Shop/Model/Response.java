package com.shop.Shop.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected String developerMessage;
    protected Object data;

}
