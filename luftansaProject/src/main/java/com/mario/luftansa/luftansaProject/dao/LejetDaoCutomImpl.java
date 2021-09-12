package com.mario.luftansa.luftansaProject.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mario.luftansa.luftansaProject.entity.Leje;

@Repository
public class LejetDaoCutomImpl implements LejetDaoCustom
{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<Leje> findAllLejet(Integer offset)
	{
		offset = Optional.ofNullable(offset).isPresent() ? offset : 0;
		Pageable pageable = PageRequest.of(offset, 10);
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"select l from Lejet l order by dateFillimi desc");
		Query query = em.createQuery(queryString.toString(), Leje.class);
		Integer totalElements = query.getResultList().size();
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		List<Leje> resultList = query.getResultList();
        Page<Leje> page = new PageImpl<>(resultList, pageable, totalElements);

		return page;
	}

	@Override
	public List<Leje> findActive() 
	{
		StringBuilder queryString = new StringBuilder();
		queryString.append(
				"select l from Lejet l  where l.pershkrim = ?1 "
				+ " order by l.updatedAt desc");
		Query query = em.createQuery(queryString.toString(), Leje.class);
		List<Leje> resultList = query.getResultList();
		return resultList;
	}

}
