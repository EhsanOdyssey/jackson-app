package neo.ehsanodyssey.jackson.generals.jsonmanagedreference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Master {
    private Long id;
    private String product;
    @JsonBackReference
    private List<Detail> details;

    public Master() {
    }

    public Master(Long id, String product) {
        this.id = id;
        this.product = product;
    }
}
