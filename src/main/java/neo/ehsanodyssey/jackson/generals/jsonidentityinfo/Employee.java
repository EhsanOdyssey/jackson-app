package neo.ehsanodyssey.jackson.generals.jsonidentityinfo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {
    private Long id;
    private String item;
    private Manager manager;

    public Employee() {
    }

    public Employee(Long id, String item, Manager manager) {
        this.id = id;
        this.item = item;
        this.manager = manager;
    }
}
