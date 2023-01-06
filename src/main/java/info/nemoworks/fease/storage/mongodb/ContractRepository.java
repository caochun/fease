package info.nemoworks.fease.storage.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<ContractDocument, String> {
}
