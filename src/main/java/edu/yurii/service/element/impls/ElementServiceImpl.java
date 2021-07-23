package edu.yurii.service.element.impls;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementServiceImpl
  @version  1.0.0 
  @since 19.07.2021 - 16.56
*/

import edu.yurii.model.Element;
import edu.yurii.repository.ElementMongoRepository;
import edu.yurii.repository.FakeElementRepository;
import edu.yurii.service.element.interfaces.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ElementServiceImpl implements IElementService {

    @Autowired
    FakeElementRepository fakeElementRepository;

    @Autowired
    ElementMongoRepository mongoRepository;

    //@PostConstruct
    void init() {
        List<Element> list = fakeElementRepository.getAll();
        mongoRepository.saveAll(list);
    }

    @Override
    public Element create(Element element) {
        element.setCreatedAt(LocalDateTime.now());
        element.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(element);
    }

    @Override
    public Element get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Element update(Element element) {
        Element elementToUpdate = this.get(element.getId());
        LocalDateTime creation = elementToUpdate.getCreatedAt();
        element.setCreatedAt(creation);
        element.setUpdatedAt(LocalDateTime.now());

        return mongoRepository.save(element);
    }

    @Override
    public Element delete(String id) {

        Element element = this.get(id);
        mongoRepository.deleteById(id);

        return element;
    }

    @Override
    public List<Element> getAll() {
        return mongoRepository.findAll();
    }
}
