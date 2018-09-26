package decorator;

class Bird {
    public int age;

    public String fly() {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard {
    public int age;

    public String crawl() {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon {
    private int age;

    public void setAge(int age) {
        // todo
        this.age = age;
    }

    public String fly() {
        // todo
        Bird bird = new Bird();
        bird.age = age;
        return bird.fly();
    }

    public String crawl() {
        // todo
        Lizard lizard = new Lizard();
        lizard.age = age;
        return lizard.crawl();
    }
}