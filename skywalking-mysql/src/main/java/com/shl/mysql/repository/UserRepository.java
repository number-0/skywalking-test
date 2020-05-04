package com.shl.mysql.repository;

import com.shl.mysql.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author songhengliang
 * @date 2020/5/3
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
