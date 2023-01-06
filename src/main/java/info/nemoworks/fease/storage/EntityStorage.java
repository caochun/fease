package info.nemoworks.fease.storage;

import info.nemoworks.fease.model.Entity;

public interface EntityStorage {

    Entity get(String id);

    void delete(Entity entity);

    Entity save(Entity entity);

}
