public abstract class Employee {

    private String id;
    private String name;
    private String address;
    private String phone;
    private String sin;
    private String dob;
    private String dept;

    public Employee() {
    }

    public Employee(String id, String name, String address,
                    String phone, String sin, String dob, String dept) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.sin = sin;
        this.dob = dob;
        this.dept = dept;
    }

    // Each employee type calculates weekly pay differently.
    public abstract double getPay();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\nPhone: " + phone +
                "\nSIN: " + sin +
                "\nDOB: " + dob +
                "\nDepartment: " + dept;
    }
}