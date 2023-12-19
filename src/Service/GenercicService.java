package Service;

import java.lang.management.LockInfo;
import java.util.List;

public interface GenercicService<T> {
    String add(List<T> t );
    T getById(long id);
    List<T> getAll();
    String remove (long id);
    List<T> sortByName(int i);
    List<T> filterByGender(int i);
    List<T> clear();
}
//// 6) GenericServiceтин ичинде 7 метод болот:
//// String add(List<T>t);
//// T getById(Long id);
//// List<T> getAll();
//// List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
//// List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
////List<T> clear();
