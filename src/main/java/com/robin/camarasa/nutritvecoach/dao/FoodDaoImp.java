package com.robin.camarasa.nutritvecoach.dao;

import com.robin.camarasa.nutritvecoach.model.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class FoodDaoImp implements FoodDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Food> getCategories() {
        String jpql = "select fd from Food fd";
        TypedQuery<Food> query = em.createQuery(jpql, Food.class);
        return query.getResultList();
    }
}
