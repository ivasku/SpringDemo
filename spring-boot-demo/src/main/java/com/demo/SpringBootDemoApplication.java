package com.demo;

import com.demo.entities.Account;
import com.demo.entities.Customer;
import com.demo.entities.Farms;
import com.demo.entities.User;
import com.demo.repository.CustomerRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    	userRepository.deleteAll();
    	customerRepository.deleteAll();
    	
        User user1 = new User("user1", bCryptPasswordEncoder.encode("1234"));
        User user2 = new User("user2", bCryptPasswordEncoder.encode("1234"));
        User user3 = new User("user3", bCryptPasswordEncoder.encode("1234"));
     
        List<Account> userAccount1 = Arrays.asList(new Account("account1"), new Account("account2"), new Account("account3"));
        List<Account> userAccount2 = Arrays.asList(new Account("account4"), new Account("account5"), new Account("account6"));
        List<Account> userAccount3 = Arrays.asList(new Account("account7"), new Account("account8"), new Account("account9"));

        List<Farms> userFarms1 = Arrays.asList(new Farms("farms1"), new Farms("farms2"), new Farms("farms3"));
        List<Farms> userFarms2 = Arrays.asList(new Farms("farms4"), new Farms("farms5"), new Farms("farms6"));
        List<Farms> userFarms3 = Arrays.asList(new Farms("farms7"), new Farms("farms8"), new Farms("farms9"));

        userAccount1.forEach(account -> {
            account.setCustomer(new Customer("customer1"));
            account.setUser(user1);
        });
        userAccount2.forEach(account -> {
            account.setCustomer(new Customer("customer2"));
            account.setUser(user2);
        });
        userAccount3.forEach(account -> {
            account.setCustomer(new Customer("customer3"));
            account.setUser(user3);
        });

        userFarms1.forEach(farms -> farms.setUser(user1));
        userFarms2.forEach(farms -> farms.setUser(user2));
        userFarms3.forEach(farms -> farms.setUser(user3));

        user1.setAccounts(userAccount1);
        user2.setAccounts(userAccount2);
        user3.setAccounts(userAccount3);

        user1.setFarms(userFarms1);
        user2.setFarms(userFarms2);
        user3.setFarms(userFarms3);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        

    }
}

