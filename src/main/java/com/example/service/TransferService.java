package com.example.service;

import com.example.domain.Account;
import com.example.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;

    //    @SneakyThrows
    @Transactional
    public void transfer(Account source, Account target, Double amount) throws Exception {

        if (source.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);
        Thread.sleep(2000);

        accountRepository.save(source);

        if (true) {
            throw new Exception("Database connection failed");
        }
        accountRepository.save(target);
    }
}
