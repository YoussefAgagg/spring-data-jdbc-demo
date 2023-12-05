package com.github.youssefagagg.springdatajdbcdemo.domain;


import org.springframework.data.relational.core.mapping.Table;

@Table("user_authority")
public record Authority(String name) {

}
