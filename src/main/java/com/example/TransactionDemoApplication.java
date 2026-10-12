package com.example;

import com.example.domain.Account;
import com.example.repository.AccountRepository;
import com.example.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionDemoApplication implements CommandLineRunner {

    private final TransferService transferService;
    private final AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        Account hafiz = new Account();
        hafiz.setName("Hafiz");
        hafiz.setBalance(1000.0);
        accountRepository.save(hafiz);

        Account ilkin = new Account();
        ilkin.setName("Ilkin");
        ilkin.setBalance(2000.0);
        accountRepository.save(ilkin);

        Account hafiz1 = accountRepository.findByName(hafiz.getName()).get();
        Account ilkin1 = accountRepository.findByName(ilkin.getName()).get();

        transferService.transfer(hafiz1, ilkin1, 50.0);
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionDemoApplication.class, args);
    }
}
