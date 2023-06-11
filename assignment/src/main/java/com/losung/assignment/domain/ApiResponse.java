package com.losung.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ApiResponse {

    private Integer respCode;
    private Contact respMsg;

}
