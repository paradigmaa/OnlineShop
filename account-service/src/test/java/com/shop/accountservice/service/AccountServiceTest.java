package com.shop.accountservice.service;

import com.shop.account.entity.Account;
import com.shop.account.repositories.AccountRepository;
import com.shop.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountService accountService;

    @Test
    public void accountServiceTest_create() {
        Account account = createAccount();
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Account savedAccount = accountService.saveAccount(account);
        assertNotNull(savedAccount);
        assertEquals(1L, savedAccount.getId());
        assertEquals("accountName", savedAccount.getAccountName());
        assertEquals(new BigDecimal("0.00"), savedAccount.getBalance());
        assertEquals("Test@test.com", savedAccount.getEmail());
        Mockito.verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void accountServiceTest_findAccountById() {
        Account account = createAccount();
        Mockito.when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        Account finedByIdAccount = accountService.getAccountById(account.getId());
        assertNotNull(finedByIdAccount);
        assertEquals("accountName", finedByIdAccount.getAccountName());
        assertEquals(new BigDecimal("100.00"), finedByIdAccount.getBalance());
        assertEquals("Test@test.com", finedByIdAccount.getEmail());
        Mockito.verify(accountRepository, times(1)).findById(account.getId());
    }

    @Test
    public void accountServiceTest_delete() {
        Account account = createAccount();
        Mockito.when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        accountService.deleteAccount(account.getId());
        Mockito.verify(accountRepository, Mockito.times(1)).deleteById(account.getId());
        Mockito.when(accountRepository.existsById(account.getId())).thenReturn(false);
        assertFalse(accountRepository.existsById(account.getId()));
    }

    @Test
    public void accountServiceTest_update() {
        Account account = createAccount();
        Account updateAccount = createAccount();
        Mockito.when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        Mockito.when(accountRepository.save(account)).thenReturn(updateAccount);
        Account resultUpdateAccount = accountService.updateAccount(account.getId(), updateAccount);

        assertNotNull(resultUpdateAccount);
        assertEquals(account.getAccountName(), resultUpdateAccount.getAccountName());
        assertEquals(account.getBalance(), resultUpdateAccount.getBalance());
        assertEquals(account.getEmail(), resultUpdateAccount.getEmail());

        Mockito.verify(accountRepository, Mockito.times(1)).findById(account.getId());
        Mockito.verify(accountRepository, Mockito.times(1)).save(account);
    }

    @Test
    public void accountServiceTest_deposit(){;
        Account depositAccount = createAccount();
        BigDecimal depositAmount = depositAccount.getBalance().add(new BigDecimal("1000.00"));

        Mockito.when(accountRepository.findById(depositAccount.getId())).thenReturn(Optional.of(depositAccount));
        Mockito.when(accountRepository.save(depositAccount)).thenReturn(depositAccount);

        Account newDeposit = accountService.depositBalance(depositAccount.getId(), depositAmount);

        assertNotNull(newDeposit);
        assertEquals(depositAmount,newDeposit.getBalance());
        Mockito.verify(accountRepository, Mockito.times(1)).findById(depositAccount.getId());
        Mockito.verify(accountRepository, Mockito.times(1)).save(depositAccount);
    }

    private Account createAccount() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("accountName");
        account.setBalance(new BigDecimal("00.00"));
        account.setEmail("Test@test.com");
        return account;
    }
}
