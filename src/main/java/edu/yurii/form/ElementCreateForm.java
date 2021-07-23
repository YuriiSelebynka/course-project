package edu.yurii.form;

/*
  @author   Yurii Selebynka
  @project   ${PROJECT_NAME}
  @class  ${NAME}
  @version  1.0.0
  @since ${DATE} - ${HOUR}.${MINUTE}
*/

import edu.yurii.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElementCreateForm {
    private String name;
    public Item item;
    private String description;

    public ElementCreateForm() {

    }
}
