import java.util.List;

public interface ICompanyService {

    Company getTopLevelParent(Company child);

    long  getNumberOfEmployees(Company parent, List<Company> companies);
}
