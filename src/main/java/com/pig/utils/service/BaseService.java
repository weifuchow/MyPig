
package com.pig.utils.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pig.utils.BeanUtilsExt;
import com.pig.utils.entity.BaseQuery;
import com.pig.utils.entity.PageResult;
import com.pig.utils.entity.WeifuResult;



/**
 * Created by chuangang.li on 2017/1/19.
 */
public class BaseService<T extends JpaRepository & JpaSpecificationExecutor, Q extends BaseQuery> {
    @Autowired
    protected T repository;
    protected EntityManager entityManager = null;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /***
     * 通用分页查询
     */
    public <S> WeifuResult getPage(Q query) {
        PageResult<S> pageResult =new PageResult<S>();

        Page<S> page = null;
        if (query.where() == null) {
            page = repository.findAll(query.getPageReq());
        }else {
            page = repository.findAll(query.where(), query.getPageReq());
        }

        pageResult.setPageCount(page.getTotalPages());
        pageResult.setTotal(page.getTotalElements());
        pageResult.setPageList(page.getContent());

        WeifuResult result = new WeifuResult();
        result.setData(pageResult);

        return result;
    }

    public <S> List<S> getAll() {
        return repository.findAll();
    }

    public <S> S findById(Serializable id) {
        Optional<S> obj  = repository.findById(id) ;
        if(obj.isPresent())
        	return obj.get();
        return null;
    }

    public void delete(Serializable id) {
        repository.delete(id);
    }

    public <S> void deleteById(S entity) {
        repository.deleteById(entity);
    }

    public <S> S save(S entity) {
        return (S) repository.save(entity);
    }

    public <S> S saveAndFlush(S entity) {
    	return (S) repository.saveAndFlush(entity);
    }
    public <S> S modify(S entity,Serializable id) {
    	S old = findById(id);
    	BeanUtils.copyProperties(entity,old, BeanUtilsExt.getNullPropertyNames(entity));  
    	return (S) repository.saveAndFlush(old);
    }
    
    public boolean exist(Serializable id) {
        return repository.existsById(id);
    }
}
