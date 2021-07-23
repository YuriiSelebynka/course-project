package edu.yurii.repository;

import edu.yurii.model.Element;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementMongoRepository
  @version  1.0.0 
  @since 23.07.21 - 11.22
*/

@Repository
public interface ElementMongoRepository extends MongoRepository<Element, String> {
}
