package com.shop.account.service;

import com.shop.account.entity.Account;
import com.shop.account.exception.AccountNotFoundException;
import com.shop.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public Account getAccountById(Long id){
       return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("No account by" + id));
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account updateAccount(Long id, Account account){
        Account oldAccount = getAccountById(id);
        oldAccount.setAccountName(account.getAccountName());
        return saveAccount(oldAccount);
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
