package userAuth.dao;

import com.project.ripunjoy.entities.UserEntity;
import com.project.ripunjoy.entities.companyEntity;
import com.project.ripunjoy.models.companyModel;
import ipo.entities.ipoDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stockExchange.entities.StockExchangeEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>
{

}
