package edu.yurii.service.element.interfaces;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  IElementService
  @version  1.0.0 
  @since 18.07.2021 - 20.04
*/

import edu.yurii.model.Element;

import java.util.List;

public interface IElementService {

    Element create(Element element);
    Element get(String id);
    Element update(Element element);
    Element delete(String id);
    List<Element> getAll();

}
