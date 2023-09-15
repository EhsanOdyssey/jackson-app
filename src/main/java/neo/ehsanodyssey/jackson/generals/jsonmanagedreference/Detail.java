package neo.ehsanodyssey.jackson.generals.jsonmanagedreference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Detail {
    private Long id;
    private String item;
    @JsonManagedReference
    private Master master;

    public Detail() {
    }

    public Detail(Long id, String item, Master master) {
        this.id = id;
        this.item = item;
        this.master = master;
    }
}
