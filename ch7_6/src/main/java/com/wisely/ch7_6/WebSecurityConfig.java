package com.wisely.ch7_6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/5/11 11:46
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/login").permitAll()//设置Spring Security对/和/“login”路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout().permitAll();
    }

    //在内存中配置用户,角色是USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("jzx").password(passwordEncoder().encode("jzx")).roles("USER")
                .and()
                .withUser("wisely").password(passwordEncoder().encode("wisely")).roles("USER")
                .and()
                .withUser("jeffrey").password(passwordEncoder().encode("jeffrey")).roles("USER");
    }

    @Override
    public void configure(WebSecurity web) {
        ///resources/static/目录下的静态资源，Spring Security不拦截
        web.ignoring().antMatchers("/resources/static/**");
    }
}
