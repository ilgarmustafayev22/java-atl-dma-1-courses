package az.atlacademy.springrelationsexample.service.impl;

import az.atlacademy.springrelationsexample.entity.Account;
import az.atlacademy.springrelationsexample.repository.TransferRepository;
import az.atlacademy.springrelationsexample.service.TransferService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    @Override
    @Transactional
    public void transfer(String senderTransferNumber, String receiverTransferNumber, BigDecimal amount) {
        Account account = transferRepository.findByTransferNumber(senderTransferNumber);
        transferRepository.save(Account.builder()
                        .id(account.getId())
                        .transferNumber(senderTransferNumber)
                .amount(account.getAmount().subtract(amount))
                .build());

        //if (true){
        //    throw new RuntimeException("Invalid operation!!");
        //}

        Account account2 = transferRepository.findByTransferNumber(receiverTransferNumber);
        transferRepository.save(Account.builder()
                        .id(account2.getId())
                        .transferNumber(receiverTransferNumber)
                .amount(account2.getAmount().add(amount))
                .build());
    }

}
