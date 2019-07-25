package app.common.repositories;

import app.common.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer>, PositionRepositoryCustom {

}
