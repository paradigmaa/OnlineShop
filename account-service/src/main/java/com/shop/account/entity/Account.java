package com.shop.account.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "email")
    private String email;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "date_created", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}
