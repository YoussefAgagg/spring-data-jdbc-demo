package com.github.youssefagagg.springdatajdbcdemo.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@Getter
@Setter
public abstract class AbstractAuditingEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @CreatedDate
    @Column("created_date")
    private Instant createdDate;

    @LastModifiedDate
    @Column("last_modified_date")
    private Instant lastModifiedDate;


    @Version
    @Column("version")
    private int version;


}
