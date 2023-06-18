class Person implements Cloneable {
     String name;
     Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // @Override
    // protected Object clone() throws CloneNotSupportedException {
    //     return super.clone();
    // }

    @Override
protected Object clone() throws CloneNotSupportedException {
    Person cloned = (Person) super.clone();
    cloned.address = (Address) address.clone();
    return cloned;
}

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }
}

class Address  implements Cloneable {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address [city=" + city + "]";
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John", address);

        // 浅克�?
        Person person2 = (Person) person1.clone();
        System.out.println("浅克隆：");
        System.out.println("Person 1: " + person1);
        System.out.println("Person 2: " + person2);

        // 修改person2的地址
        person2.address.city="Paris";

        System.out.println("��¡��");
        System.out.println("Person 1: " + person1); // 地址未改变，仍为New York
        System.out.println("Person 2: " + person2); // 地址已改变，变为London
    }
}