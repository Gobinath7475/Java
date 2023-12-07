import java.util.Optional;

public class housemain {
    public static void main(String[] args) {
        House house = new House();

        Optional<House> house1 = Optional.empty();

        Optional<House> house2 = Optional.of(new House());

        Optional<House> optionalHouse = Optional.ofNullable(house);

        optionalHouse.get();
    }
}

class Person {

    Optional<House> house;

    public Optional<House> getHouse() {
        return house;
    }
}

class House {

    Optional<HouseLoan> houseLoan;

    public Optional<HouseLoan> getHouseLoan() {
        return houseLoan;
    }
}

class HouseLoan {
    String houseLoanDetails;

    public String getHouseLoanDetails() {
        return houseLoanDetails;
    }
}