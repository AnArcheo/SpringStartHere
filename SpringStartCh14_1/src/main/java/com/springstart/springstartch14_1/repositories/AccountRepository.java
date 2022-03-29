package com.springstart.springstartch14_1.repositories;

import com.springstart.springstartch14_1.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
