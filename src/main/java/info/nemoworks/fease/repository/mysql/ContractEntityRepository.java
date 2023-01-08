package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.repository.mysql.model.ContractEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public interface ContractEntityRepository extends JpaRepository<ContractEntity, Long> {

    ContractEntity getContractEntityByCode(String code);

}
