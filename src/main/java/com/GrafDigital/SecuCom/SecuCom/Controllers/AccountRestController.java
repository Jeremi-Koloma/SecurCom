package com.GrafDigital.SecuCom.SecuCom.Controllers;

import com.GrafDigital.SecuCom.SecuCom.Models.AppUser;
import com.GrafDigital.SecuCom.SecuCom.Services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Identifier la classe comme Controllers
@RequestMapping("SecuCom") // Nom de path dans l'URL
@AllArgsConstructor // Pour l'injections des dependances, AccountService;
public class AccountRestController {
    // Injectons la dependance
    public final AccountService accountService;

    // Une méthode qui permet de retourner une liste des Users
    @GetMapping("/users")
    public List<AppUser> appUsers(){
        return accountService.listUsers();
    }
}
