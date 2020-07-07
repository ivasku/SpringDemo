package com.demo.controller;

import com.demo.entities.Account;
import com.demo.entities.Customer;
import com.demo.entities.Farms;
import com.demo.entities.User;
import com.demo.repository.AccountRepository;
import com.demo.repository.CustomerRepository;
import com.demo.repository.FarmsRepository;
import com.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	
    private final UserRepository userRepository;
    
    
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Autowired
    private FarmsRepository farmRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    
    @GetMapping("/public")
    public String openPublic() {
        return "public";
    }
    
    @GetMapping("/farms")
    @ResponseBody
    public List<Farms> openFarms() {	
    	return farmRepository.findAll();
    }
    
    @GetMapping("/users")
    @ResponseBody
    public List<User> openUsers() {	
    	return userRepository.findAll();
    }
    
    @GetMapping("/accounts")
    @ResponseBody
    public List<Account> openAccounts() {	
    	return accountRepository.findAll();
    }
    
    @GetMapping("/customer")
    @ResponseBody
    public List<Customer> openCustomer() {	
    	return customerRepository.findAll();
    }



    @GetMapping("/query")
    public String query(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        List<Account> accounts = user.getAccounts();
        List<Farms> farms = user.getFarms();
        model.addAttribute("username", username);
        model.addAttribute("accounts", accounts);
        model.addAttribute("farms", farms);
        return "welcome";
    }
}
