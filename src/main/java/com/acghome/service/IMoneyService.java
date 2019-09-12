package com.acghome.service;

import com.acghome.entity.db2.Money;

public interface IMoneyService {

    Money getMoneyById(int id);

    int AddMoney(Money money);


}
