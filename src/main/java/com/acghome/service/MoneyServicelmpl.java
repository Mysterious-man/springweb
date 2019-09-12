package com.acghome.service;

import com.acghome.entity.db2.Money;
import com.acghome.mapper.db2.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "moneyService")
public class MoneyServicelmpl  implements IMoneyService{


    @Autowired
    private MoneyMapper moneyMapper;


    @Override
    public Money getMoneyById(int id) {
        return moneyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int AddMoney(Money money) {
        return moneyMapper.insertSelective(money);
    }
}
