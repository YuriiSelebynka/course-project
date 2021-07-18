package edu.yurii.controller.rest;

/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemRestController
  @version  1.0.0
  @since 18.07.2021 - 18.13
*/

import edu.yurii.model.Item;
import edu.yurii.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {

     @Autowired
    ItemServiceImpl service;


     // CRUD   -   create   read   update   delete  - get all

     @RequestMapping("/all")
    public List<Item> getAll() {
         return service.getAll();
     }

     @RequestMapping("/{id}")
    public Item get(@PathVariable("id") String id) {

         return service.get(id);
     }

     @RequestMapping("/delete/{id}")
    public Item delete(@PathVariable("id") String id) {
         return service.delete(id);
     }

}
