package com.shop.account.service;

import com.shop.account.dto.accountRequestDTO;
import com.shop.account.dto.accountResponseDTO;
import com.shop.account.entity.Account;
import com.shop.account.exception.AccountNotFoundException;
import com.shop.account.mapper.accountMapper;
import com.shop.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
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
        account.setCreatedAt(new Date());
        account.setLastUpdate(new Date());
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
        if(account.getAccountName() != null) {
            oldAccount.setAccountName(account.getAccountName());
        }if (account.getEmail() != null) {
            oldAccount.setEmail(account.getEmail());
        }if(account.getBalance() != null) {
            oldAccount.setBalance(account.getBalance());
        }
        oldAccount.setLastUpdate(new Date());
        return saveAccount(oldAccount);
    }

    public void deleteAccount(Long accountId){
        accountRepository.deleteById(accountId);
    }

    public Account depositBalance(Long accountID, BigDecimal deposit){
        Account account = getAccountById(accountID);
        BigDecimal bigDecimal = account.getBalance().add(deposit);
        account.setBalance(bigDecimal);
        return accountRepository.save(account);
    }
}
