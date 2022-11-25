package com.GrafDigital.SecuCom.SecuCom.Controllers;

import com.GrafDigital.SecuCom.SecuCom.Models.AppRole;
import com.GrafDigital.SecuCom.SecuCom.Models.AppUser;
import com.GrafDigital.SecuCom.SecuCom.Services.AccountService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;


@RestController // Identifier la classe comme Controllers
@AllArgsConstructor // Pour l'injections des dependances, AccountService;
@RequestMapping("/SecuCom")
public class AccountRestController {
    // Injectons la dependance
    public final AccountService accountService;


    // Une méthode qui permet de retourner une liste des Users
    @GetMapping("/users")
    //@PostAuthorize("hasAuthority('USER')")
    public List<AppUser> appUsers(){
        return accountService.listUsers();
    }

    // Une méthode qui permet d'ajouter un User
    @PostMapping("/AddUser")
    //@PostAuthorize("hasAuthority('ADMIN')")
    public AppUser saveUser(@RequestBody AppUser appUser){ // @RequestBody pour prendre les données de qui se trouve dans le Body
        return accountService.addNewUser(appUser);
    }

    // Une méthode qui permet d'ajouter un Rôle
    @PostMapping("/addRole")
    //@PostAuthorize("hasAuthority('ADMIN')")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    // Une méthode qui permet d'Affecter un rôle à un User
    @PostMapping("/addRoleToUser")
    //@PostAuthorize("hasAuthority('ADMIN')")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
         accountService.addRoleToUser(roleUserForm.getUserName(), roleUserForm.getRoleName());
    }




    /*@RequestMapping("/*")
    public String getUserInfo(Principal user) {
        StringBuffer userInfo= new StringBuffer();
        if(user instanceof UsernamePasswordAuthenticationToken){
            userInfo.append(getUsernamePasswordLoginInfo(user));
        }
        else if(user instanceof OAuth2AuthenticationToken){
            userInfo.append(getOauth2LoginInfo(user));
        }
        return userInfo.toString();
    }*/


   /* private StringBuffer getUsernamePasswordLoginInfo(Principal user)
    {
        StringBuffer usernameInfo = new StringBuffer();

        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
        if(token.isAuthenticated()){
            User u = (User) token.getPrincipal();
            usernameInfo.append("Welcome, " + u.getUsername());
        }
        else{
            usernameInfo.append("NA");
        }
        return usernameInfo;
    }*/








}

@Getter
@Setter
class RoleUserForm{
    private String userName;
    private String roleName;
}
