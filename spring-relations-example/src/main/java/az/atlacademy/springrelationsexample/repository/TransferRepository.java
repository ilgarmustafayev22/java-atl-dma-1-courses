package az.atlacademy.springrelationsexample.repository;

import az.atlacademy.springrelationsexample.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Account, Long> {

    Account findByTransferNumber(String name);

}
