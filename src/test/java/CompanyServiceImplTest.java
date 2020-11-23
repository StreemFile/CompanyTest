import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyServiceImplTest {
    Company company = new Company(null, 5);
    Company company2 = new Company(company, 10);
    Company company3 = new Company(company2, 4);
    CompanyServiceImpl service = new CompanyServiceImpl();

    Company companyWithoutChild = new Company(null, 7);
    List<Company> withoutChildList = new ArrayList<>(Arrays.asList(companyWithoutChild));

    Company hasOnlyOneChild = new Company(null, 4);
    Company child = new Company(hasOnlyOneChild, 5);
    List<Company> onlyOneChildList = new ArrayList<>(Arrays.asList(hasOnlyOneChild,child));

    Company hasMoreThanOneChild = new Company(null, 5);
    Company childOne = new Company(hasMoreThanOneChild, 3);
    Company childTwo = new Company(hasMoreThanOneChild, 7);
    List<Company> moreThanOneChildList =
            new ArrayList<>(Arrays.asList(hasMoreThanOneChild, childOne, childTwo));

    Company hasGrandchildren = new Company(null, 2);
    Company child1 = new Company(hasGrandchildren,2);
    Company child2 = new Company(hasGrandchildren,4);
    Company child3 = new Company(hasGrandchildren,5);
    Company grandchild1 = new Company(child1, 1);
    Company grandchild2 = new Company(child1, 3);
    Company grandchild3 = new Company(child2, 3);
    Company grandchild4 = new Company(child2, 5);
    Company greatGrandchild1 = new Company(grandchild3, 5);
    Company greatGrandchild2 = new Company(grandchild1, 7);
    List<Company> hasGrandchildrenList =
            new ArrayList<>(Arrays.asList(
                    greatGrandchild2,greatGrandchild1, grandchild2,
                    grandchild1, grandchild3, grandchild4, child1,
                    child2, child3, hasGrandchildren
            ));

    Company notDescendant = new Company(null, 10);
    Company notDescendant2 = new Company(null, 10);
    Company notDescendant3 = new Company(notDescendant, 10);
    Company notDescendant4 = new Company(notDescendant3, 10);
    List<Company> hasNotDescendantList =
            new ArrayList<>(Arrays.asList(
                    hasGrandchildren, child1, child2,
                    child3, grandchild1, grandchild2,
                    grandchild3, grandchild4, greatGrandchild1,
                    greatGrandchild2, notDescendant, notDescendant2,
                    notDescendant3,notDescendant4
            ));

    @org.junit.Test
    public void companyDoesntHaveAnyParent() {
        Assert.assertEquals(company,service.getTopLevelParent(company));
    }

    @org.junit.Test
    public void companyHasOneParent(){
        Assert.assertEquals(company,service.getTopLevelParent(company2));
    }

    @org.junit.Test
    public void companiesParentHasParent(){
        Assert.assertEquals(company,service.getTopLevelParent(company3));
    }

    @org.junit.Test
    public void companyDoesntHaveChild(){
        Assert.assertEquals(7, service.getNumberOfEmployees(companyWithoutChild, withoutChildList));
    }

    @org.junit.Test
    public void companyHasOnlyOneChild(){
        Assert.assertEquals(9, service.getNumberOfEmployees(hasOnlyOneChild, onlyOneChildList));
    }

    @org.junit.Test
    public void companyHasMoreThanOneChild(){
        Assert.assertEquals(15, service.getNumberOfEmployees(hasMoreThanOneChild, moreThanOneChildList));
    }

    @org.junit.Test
    public void companyHasGrandchildren(){
        Assert.assertEquals(37, service.getNumberOfEmployees(hasGrandchildren, hasGrandchildrenList));
    }

    @org.junit.Test
    public void companyNotDescendant(){
        Assert.assertEquals(37, service.getNumberOfEmployees(hasGrandchildren, hasNotDescendantList ));
    }

}