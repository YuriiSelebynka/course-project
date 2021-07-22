package edu.yurii.form;

/*
  @author   Yurii Selebynka
  @project   ${PROJECT_NAME}
  @class  ${NAME}
  @version  1.0.0
  @since ${DATE} - ${HOUR}.${MINUTE}
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemCreateForm {
    private String name;
    private String desc;

    public ItemCreateForm() {

    }
}
