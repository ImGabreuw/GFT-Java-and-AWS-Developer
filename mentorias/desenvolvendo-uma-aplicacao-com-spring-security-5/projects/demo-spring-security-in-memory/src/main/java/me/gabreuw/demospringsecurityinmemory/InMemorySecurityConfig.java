package me.gabreuw.demospringsecurityinmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // a autenticação em memória é utilizada apenas para fins de teste/estudo, NUNCA em produção
        auth
                .inMemoryAuthentication()
                .withUser("ronaldinho").password("gaucho").roles("USER")
                .and()
                .withUser("lionel").password("messi").roles("USER", "ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").permitAll() // qualquer pessoa pode acessar "/home"
                .antMatchers("/todo/**").authenticated() // apenas pessoas autenticadas podem acessar qualquer recurso em "/todo" ("/todo/listar", "/todo/novo", "/todo/buscar/1")
                .antMatchers("/admin/**").hasRole("ADMIN") // apenas pessoas com um determinado cargo (no caso "admin") podem acessar qualquer recurso em "/admin" ("/admin/dashboard", "admin/usuarios")
                .and()
                .formLogin() // Habilitar o template de tela de login fornecido pelo Spring Security
                .and()
                .logout(); // Habilitar a geração do link de logout
    }


}
