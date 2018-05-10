
package com.pig.orders.model;

import com.pig.orders.model.Orders;
import com.pig.utils.entity.BaseQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OrdersQuery extends BaseQuery<Orders>{
    /**
     * 自定义查询字段
     */
    public String status;
    

    
    public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Specification<Orders> where() {
        return new Specification<Orders>() {
            @Override
            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                Predicate where1 = null;
                if (!StringUtils.isEmpty(getKeyword())) {
                    where = criteriaBuilder.equal(root.get("userId").as(Integer.class),getKeyword());
                    where1 = criteriaBuilder.greaterThan(root.get("addressId").as(Integer.class),0);
                    //
                    if (!StringUtils.isEmpty(getStatus())) {
                    	where = criteriaBuilder.and(where,where1);
                    	where1 = criteriaBuilder.equal(root.get("status").as(Integer.class),getStatus());
                    }
                }
                return where == null ? null : criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createDate")))
                		.where(criteriaBuilder.and(where,where1)).getRestriction();
            }
        };
    }
    
}
