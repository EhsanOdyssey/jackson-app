package neo.ehsanodyssey.jackson.generals.jsonidentityinfo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Manager {
    private Long id;
    private String name;
    private List<Employee> employees;

    public Manager() {
    }

    public Manager(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
