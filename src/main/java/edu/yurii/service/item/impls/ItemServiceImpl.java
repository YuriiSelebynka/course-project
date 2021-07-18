package edu.yurii.service.item.impls;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemServiceImpl
  @version  1.0.0 
  @since 18.07.2021 - 19.27
*/

import edu.yurii.model.Item;
import edu.yurii.service.item.interfaces.IItemService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    private LocalDateTime time = LocalDateTime.now();
    private List<Item> list = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "name0", "desc0", time, time),
                    new Item("1", "name1", "desc1", time, time),
                    new Item("2", "name2", "desc2", time, time),
                    new Item("3", "name3", "desc3", time, time)
            )
    );
    @Override
    public Item create(Item item) {
        return null;
    }

    @Override
    public Item get(String id) {
        Item item = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return item;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public Item delete(String id) {

        Item item = this.get(id);
        list.remove(item);

        return item;
    }

    @Override
    public List<Item> getAll() {
        return list;
    }
}
