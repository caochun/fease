package info.nemoworks.fease.repository.mongodb;

import info.nemoworks.fease.repository.mongodb.model.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {
}
