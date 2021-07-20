package edu.yurii.controller.gui;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemGuiController
  @version  1.0.0 
  @since 20.07.2021 - 11.34
*/

import edu.yurii.model.Item;
import edu.yurii.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gui/item")
public class ItemGuiController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model) {

        List<Item> items = service.getAll();
        model.addAttribute("items", items);

        return "items";
    }

//    @RequestMapping("/{id}")
//    public Item get(@PathVariable("id") String id) {
//
//        return service.get(id);
//    }
//
//    @RequestMapping("/delete/{id}")
//    public Item delete(@PathVariable("id") String id) {
//        return service.delete(id);
//    }
//
//    @PostMapping("/create")
//    public Item create(@RequestBody Item item) {
//        return service.create(item);
//    }
//
//    @PostMapping("/update")
//    public Item update(@RequestBody Item item) {
//        return service.update(item);
//    }
}
