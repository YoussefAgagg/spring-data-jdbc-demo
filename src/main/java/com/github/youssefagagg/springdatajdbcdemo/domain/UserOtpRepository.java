package com.github.youssefagagg.springdatajdbcdemo.domain;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserOtpRepository extends CrudRepository<UserOtp,Long> {
    Optional<UserOtp> findFirstByUser(Long userId);
}
