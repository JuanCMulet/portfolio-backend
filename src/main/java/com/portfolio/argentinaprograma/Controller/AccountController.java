package com.portfolio.argentinaprograma.Controller;

import com.portfolio.argentinaprograma.model.Account;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.argentinaprograma.service.IAccountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class AccountController {
    
    @Autowired
    private IAccountService accountServ;
    
    @PostMapping ("/new/user")
    public void crearUser(@RequestBody Account user) {
        accountServ.crearUser(user);
    }
    
    @GetMapping ("/ver/user")
    @ResponseBody
    public List<Account> verUser() {
        return accountServ.verUser();
    }
    
    @DeleteMapping ("/delete/user/{id}")
    public void borrarUser(@PathVariable Long id) {
        accountServ.borrarUser(id);
    }
    
    @PutMapping ("/cambiar/user/{id}")
    public void cambiarUser(@RequestBody Account user, @PathVariable Long id) {
        accountServ.cambiarUser(user, id);
    }
}
