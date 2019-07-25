package app.common.repositories.impl;

import app.common.models.Position;
import app.common.repositories.PositionRepository;
import app.common.repositories.PositionRepositoryCustom;
import app.common.repositories.utils.PositionSearchQueryCriteriaConsumer;
import app.common.repositories.utils.SearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

@Repository
public class PositionRepositoryImpl implements PositionRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Position> search(List<SearchCriteria> params) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Position> query = builder.createQuery(Position.class);
    Root r = query.from(Position.class);

    Predicate predicate = builder.conjunction();

    PositionSearchQueryCriteriaConsumer searchConsumer =
      new PositionSearchQueryCriteriaConsumer(predicate, builder, r);
    params.stream().forEach(searchConsumer);
    predicate = searchConsumer.getPredicate();
    query.where(predicate);

    List<Position> result = entityManager.createQuery(query).getResultList();
    return result;


  }

}
