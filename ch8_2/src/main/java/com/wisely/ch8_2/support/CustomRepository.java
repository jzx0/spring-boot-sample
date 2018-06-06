package com.wisely.ch8_2.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/6/5 11:31
 */
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    Page<T> findByAuto(T example, Pageable pageable);
}
