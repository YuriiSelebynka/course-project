package edu.yurii.controller.gui;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ElementGuiController
  @version  1.0.0 
  @since 20.07.2021 - 17.32
*/

import edu.yurii.model.Element;
import edu.yurii.service.element.impls.ElementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
