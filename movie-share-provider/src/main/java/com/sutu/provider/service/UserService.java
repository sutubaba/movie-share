package com.sutu.provider.service;

import com.sutu.common.PageResult;
import com.sutu.common.StatusCode;
import com.sutu.example.UserExample;
import com.sutu.expection.CommonException;
import com.sutu.provider.entity.User;
import com.sutu.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增用户
     * @param user
     * @return
     */
    public User addUser(User user) {
        user.setCreateDate(new Date());
        User byUsernameIs = userRepository.findByUsernameIs(user.getUsername());
        if (byUsernameIs != null) {
            throw new CommonException(StatusCode.BAD_REQUEST,"user already exists");
        }
        User u = userRepository.saveAndFlush(user);
        return u;
    }

    /**
     * 根据Id查找用户
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        User u = userRepository.findByIdIs(id);
        return u;
    }

    /**
     * 用户列表
     * @param sort
     * @param page
     * @param size
     * @param example
     * @return
     */
    public PageResult<User> findAll(String sort, Integer page, Integer size, UserExample example) {

        sort = sort == null ? "createDate" : sort;
        page = page == null || page < 2 ? 0 : page - 1;
        size = size == null || size <= 0 ? 10 : size;

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicateList = new ArrayList<>();

                if (example.getUsername() != null) {
                    Predicate username = criteriaBuilder.like(root.get("username"), "%" + example.getUsername() + "%");
                    predicateList.add(username);
                }

                if (example.getPhone() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("phone"), example.getPhone()));
                }

                if (example.getAddress() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("address"), example.getAddress()));
                }

                Predicate[] predicates = new Predicate[predicateList.size()];

                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        };
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC, sort));
        Page<User> all = userRepository.findAll(specification, pageRequest);

        long totalElements = all.getTotalElements();
        int totalPages = all.getTotalPages();
        List<User> content = all.getContent();

        return new PageResult<>(totalElements,totalPages,content);
    }

    /**
     * 验证
     * @param user
     * @return
     */
    public Boolean validateUser(User user) {

//        User u1 = userRepository.findOne(
//                new Specification<User>() {
//                    @Override
//                    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//                        List<Predicate> predicateList = new ArrayList<>();
//
//                        predicateList.add(criteriaBuilder.equal(root.get("username"), user.getUsername()));
//                        predicateList.add(criteriaBuilder.equal(root.get("password"), user.getPassword()));
//
//                        return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
//                    }
//                }
//        ).get();
//        Example<User> example = Example.of(user);
//        Optional<User> one = userRepository.findOne(example);
//        User user1 = one.get();

        List<User> userList = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userList.size() > 0) {
            return true;
        }
        return false;
    }

}
