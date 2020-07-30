package Model;

public class Employee {

    private String empId;
    private String password;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private int salary;
    private String department;
    private String address;
    private boolean onHoliday = false;

    public Employee(String empId, String password, String name, String gender, String phone, String email, int salary, String department, String address) {
        this.empId = empId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.address = address;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOnHoliday() {
        return onHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        this.onHoliday = onHoliday;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", password=" + password + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", salary=" + salary + ", department=" + department + ", address=" + address + ", onHoliday=" + onHoliday + '}';
    }

    
}
