import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by IntelliJ IDEA.
 * CompanyTest.CompanyServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 11/23/20|1:48 пп
 * @Version CompanyServiceImpl: 1.0
 */

public class CompanyServiceImpl implements ICompanyService {
    public Company getTopLevelParent(Company child) {
        Company parent = child;
        while (!parent.getParent().equals(parent)) {
            parent = parent.getParent();
        }
        return parent;
    }

    public long getNumberOfEmployees(Company parent, List<Company> companies) {
        long numberOfEmployees;
        Set<Company> companySet = new LinkedHashSet<>();
        companySet.add(parent);

//            for (Company item : companies) {
//                for (Company parentItem : companySet) {
//                    if (item.getParent().equals(parentItem)) {
//                        companySet.add(item);
//                        break;
//                    }
//                }
//            }

            for(int i = 0; i<companySet.size(); i++){
                for (Company item : companies) {
                    List<Company> parentItems = new ArrayList<>(companySet);
                    if(item.getParent().equals(parentItems.get(i))) {
                        companySet.add(item);
                    }
                }
            }


        numberOfEmployees = companySet.stream().mapToLong(item -> item.getEmployeesCount()).sum();

        return numberOfEmployees;
    }
}
