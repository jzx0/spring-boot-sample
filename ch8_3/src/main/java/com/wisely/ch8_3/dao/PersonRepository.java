package com.wisely.ch8_3.dao;

import com.wisely.ch8_3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/6/5 15:09
 */
// 默认是实体类类名（首字母小写）后加s
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    List<Person> findByNameStartsWith(@Param("name") String name);
}
