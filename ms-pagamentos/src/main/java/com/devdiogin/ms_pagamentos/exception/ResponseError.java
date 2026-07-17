package com.devdiogin.ms_pagamentos.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(LocalDateTime time, HttpStatus httpStatus, Object message) {
}
