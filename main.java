
class MyPerson {

    private String initials;
    private String group;

    MyPerson(String initials, String group) {
        this.initials = initials;
        this.group = group;
    }
    
    public String getInitials() {
        return this.initials;
    }

    public String getGroup() {
        return this.group;
    }

}

class MainClass {

    static public void main(String[] args) {
        MyPerson person = new MyPerson("Басыров С.А.", "ИКБО-07-18");

        System.out.println("Hello World!");
        System.out.println(person.getInitials() + ", " + person.getGroup());
    }

}
