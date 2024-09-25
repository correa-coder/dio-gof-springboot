package one.digitalinovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Uses the strategy design pattern
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}