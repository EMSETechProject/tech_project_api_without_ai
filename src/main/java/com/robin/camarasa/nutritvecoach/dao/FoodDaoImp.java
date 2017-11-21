package com.robin.camarasa.nutritvecoach.dao;

import com.robin.camarasa.nutritvecoach.model.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImp implements FoodDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> getCategories() {
        String jpql = "SELECT fd.categorie FROM Food fd";
        List<String> result = (ArrayList<String>)em.createQuery(jpql).getResultList();
        return result;
    }
}
