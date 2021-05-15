package  com.antonio.TrvlAssist.security;

import  com.antonio.TrvlAssist.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    private final MyUserDetailsService myUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                    .antMatchers("/login", "/register").permitAll()
                .antMatchers("/insurances/**", "/greeting/**", "/").hasAnyRole(USER, ADMIN)
                .antMatchers("/shop/**").hasAnyRole(USER, ADMIN)

                .antMatchers("/greeting").hasAnyRole(USER, ADMIN)
                .and()
                    .formLogin()
                        .loginPage("/login").permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/insurances", true) // Default URL login
                        .failureUrl("/login?error=true")


                .and()
                    .logout()
                        .logoutSuccessHandler(new MyLogoutSuccessHandler())
                        .invalidateHttpSession(true)
                .and()
                    .csrf()
                        .disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}