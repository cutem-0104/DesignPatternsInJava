package builder;

class Person {
    public String name;

    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

// 再帰的ジェネリクス
// https://www.casleyconsulting.co.jp/blog/engineer/254/
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

class Demo {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person dmitri = pb
                .withName("Dmitri")
                .worksAt("Developer")
                .build();
        System.out.println(dmitri);
    }
}