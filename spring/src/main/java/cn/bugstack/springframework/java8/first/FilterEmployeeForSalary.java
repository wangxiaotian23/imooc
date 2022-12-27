package cn.bugstack.springframework.java8.first;

/**
 * @Auther: 李清依
 * @Date: 2022/12/4 21:56
 * @Description:
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getSalary() >= 5000;
    }

}
