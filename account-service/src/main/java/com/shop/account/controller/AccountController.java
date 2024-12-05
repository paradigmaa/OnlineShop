package com.shop.account.controller;

import com.shop.account.dto.accountRequestDTO;
import com.shop.account.dto.accountResponseDTO;
import com.shop.account.entity.Account;
import com.shop.account.mapper.accountMapper;
import com.shop.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<accountResponseDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountMapper.mapAccountToAccountResponseDTO(accountService.getAccountById(id)));
    }
    @PostMapping("/create")
    public ResponseEntity<accountResponseDTO> createAccount(@RequestBody accountRequestDTO accountRequestDTO) {
        Account save = accountService.saveAccount(accountMapper.mapAccountRequestDTOtoAccount(accountRequestDTO));
        accountResponseDTO result = accountMapper.mapAccountToAccountResponseDTO(save);
           return new ResponseEntity<accountResponseDTO>(result, HttpStatus.CREATED);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<accountResponseDTO> updateAccount(@PathVariable Long id, @RequestBody accountRequestDTO accountRequestDTO) {
        Account account = accountMapper.mapAccountRequestDTOtoAccount(accountRequestDTO);
        Account updateAccount = accountService.updateAccount(id, account);
        accountResponseDTO result = accountMapper.mapAccountToAccountResponseDTO(updateAccount);
        return new ResponseEntity<accountResponseDTO>(result, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Account>> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @PostMapping("/deposit/{accountId}")
    public ResponseEntity<accountResponseDTO>DepositBalance(@PathVariable Long accountId, BigDecimal deposit){
        return new  ResponseEntity<accountResponseDTO>
                (accountMapper.mapAccountToAccountResponseDTO(accountService.depositBalance(accountId,deposit)), HttpStatus.OK);
    }
}
