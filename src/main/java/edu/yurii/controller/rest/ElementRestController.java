package edu.yurii.controller.rest;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementRestController
  @version  1.0.0 
  @since 19.07.2021 - 16.54
*/

import edu.yurii.model.Element;
import edu.yurii.service.element.impls.ElementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/element")
public class ElementRestController {

    @Autowired
    ElementServiceImpl elementService;

    @RequestMapping("/all")
    public List<Element> getAll() {
        return  elementService.getAll();
    }

    @RequestMapping("/{id}")
    public Element get(@PathVariable("id") String id) {
        return elementService.get(id);
    }

    @RequestMapping("/delete/{id}")
    public Element delete(@PathVariable("id") String id) {
        return elementService.delete(id);
    }

    @PostMapping("/create")
    public Element create(@RequestBody Element element) {
        return elementService.create(element);
    }

    @PostMapping("/update")
    public Element update(@RequestBody Element element) {
        return  elementService.update(element);
    }
}
