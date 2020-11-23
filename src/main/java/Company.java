/**
 * Created by IntelliJ IDEA.
 * CompanyTest.Company
 *
 * @Autor: vovamv
 * @DateTime: 11/23/20|1:41 пп
 * @Version Company: 1.0
 */

public class Company {
    private Company parent;
    private long employeesCount;

    public Company() {
    }

    public Company(Company parent, long employeesCount) {
        this.parent = parent;
        this.employeesCount = employeesCount;
    }

    public Company getParent() {
        if(parent == null) {
            return this;
        } else {
            return parent;
        }
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }
}
