package edu.yurii.repository;

/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemMongoRepository
  @version  1.0.0 
  @since 23.07.21 - 09.52
*/

import edu.yurii.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMongoRepository extends MongoRepository<Item, String> {
}
