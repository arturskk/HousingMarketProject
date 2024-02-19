package com.housing.market;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;
public class MarketRepositoryCustomImpl implements MarketRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public BigDecimal calcAggregatedMarketStats(final Specification<Market> spec) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);
        Root<Market> root = query.from(Market.class);
        if (spec != null) {
            query.where(spec.toPredicate(root, query, criteriaBuilder));

        }
        query.select(criteriaBuilder.sum(root.<BigDecimal>get("price")));
        final TypedQuery<BigDecimal> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}
