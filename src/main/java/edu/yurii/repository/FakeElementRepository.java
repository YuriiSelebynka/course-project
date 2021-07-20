package edu.yurii.repository;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  FakeElementRepository
  @version  1.0.0 
  @since 20.07.2021 - 17.32
*/

import edu.yurii.model.Element;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeElementRepository {

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

    public Element create(Element element) {
        String id = UUID.randomUUID().toString();
        element.setId(id);
        element.setCreatedAt(LocalDateTime.now());
        element.setUpdatedAt(LocalDateTime.now());
        System.out.println("Element has been accepted - " + element.toString());
        elementList.add(element);

        return element;
    }

    public Element get(String id) {
        Element element = elementList.stream().filter(element1 -> element1.getId().equals(id))
                .findAny().get();

        return element;
    }

    public Element update(Element element) {
        String id = element.getId();
        Element elementToUpdate = this.get(id);
        int index = elementList.indexOf(elementToUpdate);
        element.setUpdatedAt(LocalDateTime.now());
        elementList.remove(elementToUpdate);
        elementList.add(index, element);

        return element;
    }

    public Element delete(String id) {
        Element element = this.get(id);
        elementList.remove(element);

        return element;
    }

    public List<Element> getAll() {
        return elementList;
    }
}
