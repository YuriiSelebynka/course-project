package edu.yurii.form;

/*
  @author   Yurii Selebynka
  @project   course-project
  @class  ItemUpdateForm
  @version  1.0.0 
  @since 22.07.21 - 11.20
*/

import edu.yurii.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementUpdateForm {
    private String id;
    private String name;
    private Item item;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
