package edu.yurii.repository;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  FakeItemRepository
  @version  1.0.0 
  @since 20.07.2021 - 09.56
*/

import edu.yurii.model.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeItemRepository {
    private LocalDateTime time = LocalDateTime.now();
    private List<Item> list = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "name0", "desc0", time, time),
                    new Item("1", "name1", "desc1", time, time),
                    new Item("2", "name2", "desc2", time, time),
                    new Item("3", "name3", "desc3", time, time)
            )
    );

    public Item create(Item item) {
        String id = UUID.randomUUID().toString();
        item.setId(id);
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        System.out.println("item has been accepted - " + item.toString());
        list.add(item);

        return item;
    }

    public Item get(String id) {
        Item item = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();

        return item;
    }

    public Item update(Item item) {
        String id = item.getId();
        Item itemToUpdate = this.get(id);
        int index = list.indexOf(itemToUpdate);
        item.setUpdatedAt(LocalDateTime.now());
        list.remove(itemToUpdate);
        list.add(index, item);

        return item;
    }

    public Item delete(String id) {
        Item item = this.get(id);
        list.remove(item);

        return item;
    }


    public List<Item> getAll() {
        return list;
    }
}
