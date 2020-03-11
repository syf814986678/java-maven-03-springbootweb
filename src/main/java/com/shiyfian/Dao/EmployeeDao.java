package com.shiyfian.Dao;

import com.shiyfian.pojo.Department;
import com.shiyfian.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {

    //模拟数据库中数据
    private static Map<Integer, Employee> employees=null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees=new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"AA","814986678@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","123456789@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","987654321@qq.com",0,new Department(103,"研发部")));
        employees.put(1004,new Employee(1004,"DD","245676785@qq.com",1,new Department(104,"后勤部")));
        employees.put(1005,new Employee(1005,"EE","542567896@qq.com",0,new Department(105,"运营部")));
    }
    //增加一个员工
    private static Integer initEID=1006;
    public void addEmployee(Employee employee){
        if(employee.getEID()==null){
            employee.setEID(initEID++);
        }
        employee.setDepartment(departmentDao.getDepartmentsByDID(employee.getDepartment().getDID()));
        employees.put(employee.getEID(),employee);
    }
    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过ID查询员工
    public Employee getEmployeesByDID(Integer EID){
        return employees.get(EID);
    }
    //通过ID删除员工
    public void delete(Integer EID){
        employees.remove(EID);

    }
}
