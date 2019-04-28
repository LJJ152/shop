package top.ljjapp.shoppoints.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.ljjapp.shoppoints.model.ShopPoints;

public interface ShopPonintsRepository extends JpaRepository<ShopPoints, String> {
}
