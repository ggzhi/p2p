package com.xmg.p2p.base.mapper;


import java.util.List;

import com.xmg.p2p.base.domain.Account;



public interface AccountMapper {

    int insert(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Account record);
    
    List<Account> selectAll();
}