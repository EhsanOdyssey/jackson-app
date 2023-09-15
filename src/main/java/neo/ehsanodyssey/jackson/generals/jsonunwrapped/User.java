package neo.ehsanodyssey.jackson.generals.jsonunwrapped;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    @JsonUnwrapped
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
        private String country;
        private String city;
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
