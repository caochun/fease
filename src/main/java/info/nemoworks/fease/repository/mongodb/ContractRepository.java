package info.nemoworks.fease.repository.mongodb;

import info.nemoworks.fease.repository.mongodb.model.ContractDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<ContractDocument, String> {
}
