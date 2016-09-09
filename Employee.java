package EmployeeStats;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	<b>Employee</b>
*  File:	Employee.java
* <pre>
*  Description:	Set of mehtods required to access and utilize
*               the information about an employee
* gross pay.
*  @author:	Aigerim Shintemirova
*  Environment:	PC, Windows 8, jdk1.7, NetBeans 8.0
*  Date:	4/23/2014
*  @version	1.0
*  </pre>
*  History Log:	Created on April 1, 2014, 1:12:19 AM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Employee 
{
    private String name;
    private int hours;
    private float rate;
/**
 * Sets initial values of the parameters
 * @param name
 * @param hours
 * @param rate
 */   
public Employee() 
{
    name = "";
    hours = 0;
    rate = 0;
}

public Employee(String employee, int hours, float rate) 
{
    name = employee;
    this.hours = hours;
    this.rate = rate;
}
/**
 * Overloaded constructor
 * Assigns values to the parameters
 * @param employee: String
 * @param hours: int
 * @param rate: float
 */
public Employee(Employee anotherEmployee) 
{
    name = anotherEmployee.name;
    hours = anotherEmployee.hours;
    rate = anotherEmployee.rate;
}

public void setName(String employeeName)
{
    name = employeeName;
}

public String getName()
{
    return name;
}

public void setHours(int hours)
{
    this.hours = hours;
}

public int getHours()
{
    return hours;
}

public void setRate(float rate)
{
    this.rate = rate;
}

public float getRate()
{
    return rate;
}

@Override
public String toString()
{
    return this.getClass().getSimpleName()+"\nName: " + name + "\nHours worked in a week: "
                + hours + "\nPay rate: " + rate;
}
}