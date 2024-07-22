package az.atlacademy.springrelationsexample.service;

import java.math.BigDecimal;

public interface TransferService {

    void transfer(String sender, String receiver, BigDecimal amount);

}
