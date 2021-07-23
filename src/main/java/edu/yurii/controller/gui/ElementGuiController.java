package edu.yurii.controller.gui;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementGuiController
  @version  1.0.0 
  @since 20.07.2021 - 17.32
*/

import edu.yurii.form.ElementCreateForm;
import edu.yurii.form.ElementUpdateForm;
import edu.yurii.model.Element;
import edu.yurii.service.element.impls.ElementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gui/element")
public class ElementGuiController {

    @Autowired
    ElementServiceImpl elementService;

    @RequestMapping("/all")
    public String getAll(Model model) {

        List<Element> elements = elementService.getAll();
        model.addAttribute("elements", elements);

        return "elements";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        elementService.delete(id);
//        List<Item> items = service.getAll();
//        model.addAttribute("items", items);
        return "redirect:/gui/element/all";

    }

    @GetMapping("/create")
    public String create(Model model) {
        ElementCreateForm elementCreateFormToCreate = new ElementCreateForm();
        model.addAttribute("form", elementCreateFormToCreate);
        return "element-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("form") ElementCreateForm elementCreateForm) {
        Element element = new Element();
        element.setName(elementCreateForm.getName());
        element.setItem(elementCreateForm.getItem());
        element.setDescription(elementCreateForm.getDescription());
        elementService.create(element);

        return "redirect:/gui/element/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id) {
        Element element = elementService.get(id);
        ElementUpdateForm elementFormToUpdate = new ElementUpdateForm();

        elementFormToUpdate.setId(element.getId());
        elementFormToUpdate.setName(element.getName());
        elementFormToUpdate.setItem(element.getItem());
        elementFormToUpdate.setDescription(element.getDescription());
        elementFormToUpdate.setCreatedAt(element.getCreatedAt());
        elementFormToUpdate.setUpdatedAt(element.getUpdatedAt());

        model.addAttribute("form", elementFormToUpdate);
        return "element-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("form") ElementUpdateForm elementUpdateForm) {
        Element element = new Element();
        element.setId(elementUpdateForm.getId());
        element.setName(elementUpdateForm.getName());
        element.setDescription(elementUpdateForm.getDescription());
        element.setCreatedAt(elementUpdateForm.getCreatedAt());

        elementService.update(element);

        return "redirect:/gui/element/all";
    }
}
