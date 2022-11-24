package com.GrafDigital.SecuCom.SecuCom.Filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// Cette classe va étendre de la classe OncePerRequestFilter;
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    // on implement la méthode
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationToken = request.getHeader("Authorization");

        // vérifions si le Header n'est pas null
        if (authorizationToken != null && authorizationToken.startsWith("Bearer ")){
            try {
                String jwt = authorizationToken.substring(7); // Pour ignorer le Bearer nombre de caractère
                Algorithm algorithm = Algorithm.HMAC256("myScret2121"); // le même secret pour la signature
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt); // Vérifier l'algorithm qui  créer le Token
                String userName = decodedJWT.getSubject(); // Pour recupérer le userName
                String[] roles = decodedJWT.getClaim("roles ").asArray(String.class); // Pour recupérer les roles
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                for (String r:roles){
                    authorities.add( new SimpleGrantedAuthority(r));
                }
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userName,null, authorities);
                // Maintenant on authentifie le user s'il a le droit ou pas
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // On le laisse passer maintent
                filterChain.doFilter(request, response);
            }
            catch (Exception e){
                 response.setHeader("error-message",e.getMessage());
                 response.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            filterChain.doFilter(request, response );
        }
    }
}
