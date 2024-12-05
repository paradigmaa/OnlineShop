package com.shop.account.mapper;

import com.shop.account.dto.accountRequestDTO;
import com.shop.account.dto.accountResponseDTO;
import com.shop.account.entity.Account;

public class accountMapper {

    public static accountResponseDTO mapRequestAccountDTOTOResponseAccountDTO(accountRequestDTO accountRequestDTO){
        accountResponseDTO accountResponseDTO = new accountResponseDTO();
        accountResponseDTO.setAccountName(accountRequestDTO.getAccountName());
        accountResponseDTO.setBalance(accountRequestDTO.getBalance());
        accountResponseDTO.setEmail(accountRequestDTO.getEmail());
        return accountResponseDTO;
    }

    public static accountResponseDTO mapAccountToAccountResponseDTO(Account account){
        accountResponseDTO accountResponseDTO = new accountResponseDTO();
        accountResponseDTO.setId(account.getId());
        accountResponseDTO.setAccountName(account.getAccountName());
        accountResponseDTO.setEmail(account.getEmail());
        accountResponseDTO.setBalance(account.getBalance());
        accountResponseDTO.setCreatedAt(account.getCreatedAt());
        accountResponseDTO.setLastUpdate(account.getLastUpdate());
        return accountResponseDTO;
    }

    public static accountRequestDTO mapAccountResponseDTOTORequestAccountDTO(accountResponseDTO accountResponseDTO){
        accountRequestDTO accountRequestDTO = new accountRequestDTO();
        accountRequestDTO.setAccountName(accountResponseDTO.getAccountName());
        accountRequestDTO.setBalance(accountResponseDTO.getBalance());
        accountRequestDTO.setEmail(accountResponseDTO.getEmail());
        return accountRequestDTO;
    }

    public static Account mapAccountRequestDTOtoAccount(accountRequestDTO accountRequestDTO){
        Account account = new Account();
        account.setAccountName(accountRequestDTO.getAccountName());
        account.setEmail(accountRequestDTO.getEmail());
        account.setBalance(accountRequestDTO.getBalance());
        return account;
    }


}
