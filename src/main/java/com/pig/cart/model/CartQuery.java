
package com.pig.cart.model;

import com.pig.cart.model.Cart;
import com.pig.utils.entity.BaseQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CartQuery extends BaseQuery<Cart>{
    /**
     * 自定义查询字段
     */
    //public String xxx;


    public Specification<Cart> where() {
        return new Specification<Cart>() {
            @Override
            public Predicate toPredicate(Root<Cart> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                Predicate where1 = null;
                if (!StringUtils.isEmpty(getKeyword())) {
                    where = criteriaBuilder.equal(root.get("userId").as(Integer.class),getKeyword());
                    where1 = criteriaBuilder.equal(root.get("status").as(Integer.class),0);                    		
                }
                return where == null ? null : criteriaQuery.where(criteriaBuilder.and(where,where1)).getRestriction();
            }
        };
    }
    
}
