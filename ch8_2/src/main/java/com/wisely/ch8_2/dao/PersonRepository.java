package com.wisely.ch8_2.dao;

import com.wisely.ch8_2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/6/1 15:57
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name = :name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    List<Person> withNameAndAddressNamedQuery(String name, String address);
}
