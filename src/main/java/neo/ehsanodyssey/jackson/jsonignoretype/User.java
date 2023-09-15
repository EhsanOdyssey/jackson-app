package neo.ehsanodyssey.jackson.jsonignoretype;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String password;
    private Address address;

    public User() {
    }

    public User(Long id, String name, String password, Address address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    @Getter
    @Setter
    @JsonIgnoreType
    public static class Address {
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
