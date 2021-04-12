public class homeWork5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Savannah Amie Norris", "Archivist", "vaxossiddott-6258@yopmail.com", "+ 1(317)200-68-78569", 36000, (byte) 35);
        employees[1] = new Employee("Mollie Angelle Johnson", "Flight mechanic", "fammososso-7580@yopmail.com", "+ 1(7571)530-05-94377", 124000, (byte) 41);
        employees[2] = new Employee("Pearl Jocelyn Hart", "Geneticist", "fuzammottoff-8263@yopmail.com", "+ 1(8935)620-52-34946", 118000, (byte) 51);
        employees[3] = new Employee("Alfie Jasmin Owens", "Bibliographer", "ollassoffy-6350@yopmail.com", "+ 1(7365)243-05-31987", 69000, (byte) 62);
        employees[4] = new Employee("Ava Joan Hansen", "Warehouse Manager", "olacoge-9253@yopmail.com", "+ 1(8651)409-39-19931", 58000, (byte) 31);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}

class Employee {
    private final String fullName;
    private String position;
    private String mail;
    private String phone;
    private int salary;
    private byte age;

    public Employee(String fullName, String position, String mail, String phone, int salary, byte age) {
        this.fullName = fullName;
        this.position = position;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void printInfo() {
        String string = String.format("Full name: %s, position: %s, mail: %s, phone: %s, salary: %d, age: %d",
                fullName, position, mail, phone, salary, age);
        System.out.println(string);
    }
}