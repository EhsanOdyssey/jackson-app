package neo.ehsanodyssey.jackson.generals.jsonview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @JsonView(Views.Friend.class)
    private Long id;
    @JsonView({Views.Public.class, Views.Friend.class})
    private String name;
    @JsonView(Views.Friend.class)
    private Address address;

    public User() {
    }

    public User(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Getter
    @Setter
    public static class Address {
        @JsonProperty("address_id")
        private Long id;
        @JsonView(Views.Friend.class)
        private String country;
        @JsonView(Views.Friend.class)
        private String city;
        @JsonView(Views.Friend.class)
        private String street;

        public Address() {
        }

        public Address(Long id, String country, String city, String street) {
            this.id = id;
            this.country = country;
            this.city = city;
            this.street = street;
        }
    }
}
