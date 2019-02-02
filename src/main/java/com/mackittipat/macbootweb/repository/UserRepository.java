package com.mackittipat.macbootweb.repository;

import com.mackittipat.macbootweb.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
