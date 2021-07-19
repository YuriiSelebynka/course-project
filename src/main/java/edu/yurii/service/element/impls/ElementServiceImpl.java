package edu.yurii.service.element.impls;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementServiceImpl
  @version  1.0.0 
  @since 19.07.2021 - 16.56
*/

import edu.yurii.model.Element;
import edu.yurii.service.element.interfaces.IElementService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ElementServiceImpl implements IElementService {
    private LocalDateTime time = LocalDateTime.now();
    private List<Element> elementList = new ArrayList<>(
            Arrays.asList(
                    new Element("0", "Homer", "Springfield", time, time),
                    new Element("1", "Marjorie", "Springfield", time, time),
                    new Element("2", "Bartholomew", "Springfield", time, time),
                    new Element("3", "Lisa", "Springfield", time, time),
                    new Element("4", "Margaret", "Springfield", time, time)
            )
    );
    @Override
    public Element create(Element element) {
        return null;
    }

    @Override
    public Element get(String id) {
        Element element = elementList.stream().filter(element1 -> element1.getId().equals(id))
                .findAny().get();
        return element;
    }

    @Override
    public Element update(Element element) {
        return null;
    }

    @Override
    public Element delete(String id) {

        Element element = this.get(id);
        elementList.remove(element);

        return element;
    }

    @Override
    public List<Element> getAll() {
        return elementList;
    }
}
