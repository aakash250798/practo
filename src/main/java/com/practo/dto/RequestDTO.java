package com.my.practo.practo.dto;

import lombok.Getter;

@Getter
public class RequestDTO {
    String sort;
    String direction;
    String query;
    Integer size;
    Integer page;

}
