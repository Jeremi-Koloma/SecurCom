package com.GrafDigital.SecuCom.SecuCom.Services;

// cette classe va Implementer notre interface AccountService pour les méthodes

import com.GrafDigital.SecuCom.SecuCom.Models.AppRole;
import com.GrafDigital.SecuCom.SecuCom.Models.AppUser;
import com.GrafDigital.SecuCom.SecuCom.Repositories.AppRoleRepository;
import com.GrafDigital.SecuCom.SecuCom.Repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service // Identifions la classe comme service
@Transactional
@AllArgsConstructor // Pour l'injections des dépendances de nos Respository;
public class AccountServiceImpl implements AccountService {
    // Injectons maintenant les dependances Repositories;
    public final AppUserRepository appUserRepository;
    public final AppRoleRepository appRoleRepository;

    // On implemente nos méthodes
    @Override
    public AppUser addNewUser(AppUser appUser) {
        return null;
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return null;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return null;
    }

    @Override
    public List<AppUser> listUsers() {
        return null;
    }
}
