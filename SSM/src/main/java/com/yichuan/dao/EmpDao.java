package com.yichuan.dao;

import java.util.List;

import com.yichuan.entity.Emp;

/**
 * emp员工类 接口
 */
public interface EmpDao {
	
	/**
	 * 根据id查询员工信息以及部门信息
	 * @param id 员工id
	 * @return emp对象
	 */
	public Emp queryWithDept(int id);
	
	/**
	 * 根据id查询员工信息以及部门信息
	 * @param id 员工id
	 * @return emp对象
	 */
	public Emp queryEmp(int id);
	
	/**
	 * 分页查询员工信息<br>
	 * 联合查询部门信息
	 * @param id 员工id
	 * @return list 对象
	 */
	public List<Emp> queryEmpWithDept();
	
	
	/**
	 * 批量新增
	 * @param eList
	 * @return 新增结果
	 */
	public int addEmps(List<Emp> eList);
	
	/**
	 * 新增员工信息
	 * @param emp emp员工对象
	 * @return 1 新增成功 ; 0 新增失败
	 */
	public int saveEmp(Emp emp);
	
	/**
	 * 查询指定姓名的人数
	 * @param name 员工名称
	 * @return 人数
	 */
	public int countEmp(String name);
	
	/**
	 * 修改员工信息
	 * @param emp 员工对象
	 * @return int  0 修改失败；非0 修改成功
	 */
	public int updateEmp(Emp emp);

}
