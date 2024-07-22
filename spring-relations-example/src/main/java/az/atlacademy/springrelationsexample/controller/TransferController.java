package az.atlacademy.springrelationsexample.controller;

import az.atlacademy.springrelationsexample.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.logging.Level;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transfer")
public class TransferController {

    //Logger logger = Logger.getLogger(TransferController.class.getName());

    //Logger logger = LoggerFactory.getLogger(TransferController.class);


    private final TransferService transferService;

    @PutMapping
    public ResponseEntity<Void> transfer(@RequestParam String senderTransferNumber,
                                         @RequestParam String receiverTransferNumber,
                                         @RequestParam BigDecimal amount) {
        transferService.transfer(senderTransferNumber, receiverTransferNumber, amount);
        // logger.log(Level.WARNING,"Proccess succesfuly");
       //logger.info("Transfer successfully with amount:{}", amount);
       //logger.error("Transfer successfully with amount:{}", amount);
       //logger.warn("Transfer successfully with amount:{}", amount);
       //logger.debug("Transfer successfully with amount:{}", amount);
       //logger.trace("Transfer successfully with amount:{}", amount);
        log.debug("Transfer successfully with amount:{}", amount);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
