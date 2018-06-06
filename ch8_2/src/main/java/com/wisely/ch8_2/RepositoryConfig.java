package com.wisely.ch8_2;

import com.wisely.ch8_2.support.CustomRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/6/5 14:42
 */
@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class RepositoryConfig {
}
