package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.repository.mysql.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractEntityRepository extends JpaRepository<ContractEntity, Long> {
}
