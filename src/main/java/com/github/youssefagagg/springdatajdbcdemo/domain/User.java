package com.github.youssefagagg.springdatajdbcdemo.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table("users")
@Builder
public record User(@Id Long id,
                   String name,
                   @Column("user_id")
                   Set<Authority> authorities,
                   @Column("file_extensions")
                   List<FileExtension> fileExtensions) {

}
