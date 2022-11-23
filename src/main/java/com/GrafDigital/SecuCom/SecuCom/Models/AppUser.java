package com.GrafDigital.SecuCom.SecuCom.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity // Identifier comme une Entié JPA
@Data // pour gerer les Getters and Setters;
@NoArgsConstructor // un constructeur sans argument
@AllArgsConstructor // un constructeur avec tous les arguments
public class AppUser {
    @Id // Identifier le Id;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Identifier notre Primary Key
    private Long id;

    @Column(length = 50)
    private String userName;
    private String password;

    @Column(length = 18)
    @ManyToMany(fetch = FetchType.EAGER) // Pour afficher le user avec son Rôle;
    private Collection<AppRole> appRoles = new ArrayList<>( );
}
