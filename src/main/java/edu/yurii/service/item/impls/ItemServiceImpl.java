package edu.yurii.service.item.impls;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemServiceImpl
  @version  1.0.0 
  @since 18.07.2021 - 19.27
*/

import edu.yurii.model.Item;
import edu.yurii.repository.FakeItemRepository;
import edu.yurii.repository.ItemMongoRepository;
import edu.yurii.service.item.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    FakeItemRepository repository;

    @Autowired
    ItemMongoRepository mongoRepository;

    //@PostConstruct
    void init() {
        List<Item> list = repository.getAll();
        mongoRepository.saveAll(list);

    };

    @Override
    public Item create(Item item) {
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(item);
    }

    @Override
    public Item get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Item update(Item item) {
        Item itemToUpdate = this.get(item.getId());
        LocalDateTime creation = itemToUpdate.getCreatedAt();
        item.setCreatedAt(creation);
        item.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(item);
    }

    @Override
    public Item delete(String id) {

        Item item = this.get(id);
        mongoRepository.deleteById(id);

        return item;
    }

    @Override
    public List<Item> getAll() {
        return mongoRepository.findAll();
    }
}
