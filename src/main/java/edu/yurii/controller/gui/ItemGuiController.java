package edu.yurii.controller.gui;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemGuiController
  @version  1.0.0 
  @since 20.07.2021 - 11.34
*/

import edu.yurii.form.ItemCreateForm;
import edu.yurii.form.ItemUpdateForm;
import edu.yurii.model.Item;
import edu.yurii.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
//        List<Item> items = service.getAll();
//        model.addAttribute("items", items);
        return "redirect:/gui/item/all";

    }

    @GetMapping("/create")
    public String create(Model model) {
        ItemCreateForm formToCreate = new ItemCreateForm();
        model.addAttribute("form", formToCreate);
        return "item-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("form") ItemCreateForm form) {
        Item item = new Item();
        item.setName(form.getName());
        item.setDesc(form.getDesc());
        service.create(item);

        return "redirect:/gui/item/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id) {
        Item item = service.get(id);
        ItemUpdateForm formToUpdate = new ItemUpdateForm();

        formToUpdate.setId(item.getId());
        formToUpdate.setName(item.getName());
        formToUpdate.setDesc(item.getDesc());
        formToUpdate.setCreatedAt(item.getCreatedAt());
        formToUpdate.setUpdatedAt(item.getUpdatedAt());

        model.addAttribute("form", formToUpdate);
        return "item-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("form") ItemUpdateForm form) {
        Item item = new Item();
        item.setId(form.getId());
        item.setName(form.getName());
        item.setDesc(form.getDesc());
        item.setCreatedAt(form.getCreatedAt());

        service.update(item);

        return "redirect:/gui/item/all";
    }

}
