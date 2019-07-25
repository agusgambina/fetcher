package app.common.repositories;

import app.common.models.Position;
import app.common.repositories.utils.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepositoryCustom {

  List<Position> search(List<SearchCriteria> params);

}
