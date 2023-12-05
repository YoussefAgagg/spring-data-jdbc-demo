package com.github.youssefagagg.springdatajdbcdemo.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
