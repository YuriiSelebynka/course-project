package edu.yurii.service.element.impls;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementServiceImpl
  @version  1.0.0 
  @since 19.07.2021 - 16.56
*/

import edu.yurii.model.Element;
import edu.yurii.repository.FakeElementRepository;
import edu.yurii.service.element.interfaces.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceImpl implements IElementService {

    @Autowired
    FakeElementRepository fakeElementRepository;

    @Override
    public Element create(Element element) {
        return fakeElementRepository.create(element);
    }

    @Override
    public Element get(String id) {
        return fakeElementRepository.get(id);
    }

    @Override
    public Element update(Element element) {
        return fakeElementRepository.update(element);
    }

    @Override
    public Element delete(String id) {
        return fakeElementRepository.delete(id);
    }

    @Override
    public List<Element> getAll() {
        return fakeElementRepository.getAll();
    }
}
