package com.housing.market.repository;

import com.housing.market.domain.Market;
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
        final CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        Root<Market> root = query.from(Market.class);
        if (spec != null) {
            query.where(spec.toPredicate(root, query, criteriaBuilder));

        }

        query.select(criteriaBuilder.avg(root.<Double>get("price")));
        final TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult() != null ? BigDecimal.valueOf(typedQuery.getSingleResult()) : BigDecimal.ZERO;
    }
}
