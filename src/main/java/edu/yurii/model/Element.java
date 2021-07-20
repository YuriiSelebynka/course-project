package edu.yurii.model;
/*
  @author   Yurii Selebynka
  @project   course-project
  @class  Element
  @version  1.0.0 
  @since 18.07.2021 - 20.02
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Element {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Element(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return getId().equals(element.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
