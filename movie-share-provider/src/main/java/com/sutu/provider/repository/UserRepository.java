package com.sutu.provider.repository;

import com.sutu.provider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    User findByIdIs(Integer id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsernameIs(String username);

    /**
     * 验证用户
     * @return
     */
    List<User> findByUsernameAndPassword(String username, String password);
}
