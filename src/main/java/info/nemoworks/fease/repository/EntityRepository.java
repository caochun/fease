package info.nemoworks.fease.repository;

import info.nemoworks.fease.model.Entity;

import java.util.List;

public interface EntityRepository {

    Entity get(String id);

    void delete(Entity entity);

    Entity save(Entity entity);

     List<Entity> findAll();

}
