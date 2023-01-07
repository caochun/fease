package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.repository.mysql.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
}
