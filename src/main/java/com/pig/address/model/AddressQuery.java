
package com.pig.address.model;

import com.pig.address.model.Address;
import com.pig.utils.entity.BaseQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AddressQuery extends BaseQuery<Address>{
    /**
     * 自定义查询字段
     */
    //public String xxx;

    
    public Specification<Address> where() {
        return new Specification<Address>() {
            @Override
            public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                if (!StringUtils.isEmpty(getKeyword())) {
                    where = criteriaBuilder.equal(root.get("addressUserId").as(Integer.class),getKeyword());
                }
                return where == null ? null : criteriaQuery.where(where).getRestriction();
            }
        };
    }
    
}
