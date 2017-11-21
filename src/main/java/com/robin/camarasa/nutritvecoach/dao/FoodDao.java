package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDao extends JpaRepository<Food, Long>, FoodDaoCustom {
}