package edu.yurii.repository;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  FakeElementRepository
  @version  1.0.0 
  @since 20.07.2021 - 17.32
*/

import edu.yurii.model.Element;
import edu.yurii.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeElementRepository {

    @Autowired
    ItemMongoRepository itemMongoRepository;

    private LocalDateTime time = LocalDateTime.now();
    private List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "name0", "desc0", time, time),
                    new Item("1", "name1", "desc1", time, time),
                    new Item("2", "name2", "desc2", time, time),
                    new Item("3", "name3", "desc3", time, time)
            )
    );


    private List<Element> elementList = new ArrayList<>(
            Arrays.asList(
                    new Element("0", "Homer", items.get(2), "Springfield", time, time),
                    new Element("1", "Marjorie", items.get(2),"Springfield", time, time),
                    new Element("2", "Bartholomew", items.get(2),"Springfield", time, time),
                    new Element("3", "Lisa", items.get(2),"Springfield", time, time),
                    new Element("4", "Margaret", items.get(2),"Springfield", time, time)
            )
    );


    public Element create(Element element) {
        String id = UUID.randomUUID().toString();
        element.setId(id);
        element.setItem(element.getItem());
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
        element.setItem(elementToUpdate.getItem());
        element.setCreatedAt(elementToUpdate.getCreatedAt());
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
