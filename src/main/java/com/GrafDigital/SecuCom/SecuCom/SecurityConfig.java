package com.GrafDigital.SecuCom.SecuCom;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Cette classe va étendre de la classe WebSecurityConfigurerAdapter;
@Configuration // une classe de configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Définissons des méthodes;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Ici on Idenfitie les Users qui ont le Droit d'accéder;

        //super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Ici on spéficie les Droits d'Accès;

        // Autorisé l'Accès à toutes les fonctionnalités;
        http.authorizeRequests().anyRequest().permitAll(); // No Authentifaction any Request;

    }
}
