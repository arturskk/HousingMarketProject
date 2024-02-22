package com.housing.market.repository;

import com.housing.market.domain.Market;
import com.housing.market.dto.Region;
import com.housing.market.form.QueryParamsForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface MarketRepository extends JpaRepository<Market, Long>, JpaSpecificationExecutor<Market>, MarketRepositoryCustom {
    static Specification<Market> search(Region regionId, QueryParamsForm form) {
        return (root, query, cb) -> {
            final List<Predicate> predicates = new ArrayList<>();

            Predicate predicate = cb.isTrue(cb.literal(true));
            if (form.getSize() != null) {
                predicates.add(cb.between(root.get("area"), form.getSize().getRangeMin(), form.getSize().getRangeMax()));
            }
            if (form.getRooms() != null) {
                predicates.add(cb.equal(root.get("rooms"), form.getRooms()));
            }
            if (regionId != null) {
                predicates.add(cb.equal(root.get("regionId"), regionId));
            }
            if (form.getDateSince() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("marketDate"), form.getDateSince()));
            }
            if (form.getDateUntil() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("marketDate"), form.getDateUntil()));
            }
            if (form.getTypes() != null && !form.getTypes().isEmpty()) {
                predicates.add(root.get("type").in(form.getTypes()));
            }
            return predicate;
        };
    }
}
