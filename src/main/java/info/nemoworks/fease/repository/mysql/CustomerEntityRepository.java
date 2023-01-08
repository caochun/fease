package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.repository.mysql.model.CustomerEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("mysql")
@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
}
