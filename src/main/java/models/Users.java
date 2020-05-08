package models;

public class Users {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    protected class Address {

        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Address() {
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo +
                    '}';
        }
    }

    protected class Geo {
        private String lat;
        private String lng;

        public Geo() {
        }

        @Override
        public String toString() {
            return "Geo{" +
                    "lat='" + lat + '\'' +
                    ", lng='" + lng + '\'' +
                    '}';
        }
    }

    protected class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        public Company() {
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}