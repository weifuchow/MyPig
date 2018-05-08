
package com.pig.goods.model;

import com.pig.goods.model.Goods;
import com.pig.utils.entity.BaseQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GoodsQuery extends BaseQuery<Goods>{
    /**
     * 自定义查询字段
     */
    //public String xxx;

    /*
     * 组合where查询条件
     * */
    public Specification<Goods> where() {
        return new Specification<Goods>() {
            @Override
            public Predicate toPredicate(Root<Goods> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                if (!StringUtils.isEmpty(getKeyword())) {
                    where = criteriaBuilder.equal(root.get("goodsType").as(String.class),getKeyword());
                }
                return where == null ? null : criteriaQuery.where(where).getRestriction();
            }
        };
    }
    
}
