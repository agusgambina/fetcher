package app.common.repositories;

import app.common.models.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

  @Query(
    value = "SELECT * FROM positions p WHERE LOWER(p.name) ILIKE LOWER('%java%') AND LOWER(p.location) LIKE LOWER('%San Francisco%')",
    nativeQuery = true)
  Collection<Position> findAllJavaInSanFrancisco();

  @Query(
    value = "SELECT * FROM positions p WHERE LOWER(p.name) ILIKE LOWER('%data scientist%')",
    nativeQuery = true)
  Collection<Position> findAllDataScientist();

  @Query(
    value = "SELECT * FROM positions p WHERE LOWER(p.type) ILIKE LOWER('%full time%') AND LOWER(p.location) LIKE LOWER('%New York%')",
    nativeQuery = true)
  Collection<Position> findAllFullTimeInNewYork();



}
