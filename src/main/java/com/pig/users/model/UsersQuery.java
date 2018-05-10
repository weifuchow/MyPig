
package com.pig.users.model;

import com.pig.users.model.Users;
import com.pig.utils.entity.BaseQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UsersQuery extends BaseQuery<Users>{
    /**
     * 自定义查询字段
     */
    public Long id;

    
    //组合where查询条件
    public Specification<Users> where() {
        return new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                if (getId() != null) {
                    where = criteriaBuilder.equal(root.get("id").as(Long.class), getId());
                }
                return where == null ? null : criteriaQuery.where(where).getRestriction();
            }
        };
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
    
}
