package EmployeeStats;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
/**
 *Class:               Validation
* File:                Validation.java
* Description:         Validates entered values
* @author:             Niko Culevski
* Environment:         PC, Windows Vista Business, jdk 7.0, NetBeans 7.3.1
* Date:                6/10/2013
* @version             1.2.1
* @see                 java.util.regex.Matcher
* @see                 java.util.regex.Pattern
 */
public class Validation 
{
   
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *   Method         isDouble()
    *   Description    Validates that double value is entered
    *   @return        boolean
    *   @param         fieldValue: String, input
    *   @author        Niko Culevski
    *   @see           java.util.regex.Matcher
    *   @see           java.util.regex.Pattern
    *   Date           6/10/2013
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isDouble(String fieldValue)
    {
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();
    }
   
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *   Method:        isDouble()
    *   Description:   Overloaded, validates that double value is entered
    *                  within the required range
    *   @param         fieldValue: String, input
    *   @param         lower: double, lower bound
    *   @param         upper: double, upper bound
    *   @return:       boolean
    *   @author:       Niko Culevski
    *   @see:          java.util.regex.Matcher
    *   @see:          java.util.regex.Pattern
    *   Date:          6/10/2013
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isDouble(String fieldValue, double lower, double upper)
    {
        boolean result = true;
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher mat = pat.matcher(fieldValue);
        if(mat.matches())
        {
            try
            {
                //check range
                double num = Double.parseDouble(fieldValue);
                if(num < lower || num > upper)
                    result = false;
            }
            catch(NumberFormatException ex)
            {
                //something went wrong
                result = false;
            }
        }
        else
        {
            result = false;
        }
        return result;
        //return mat.matches();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *   Method:         isInteger()
    *   Description:    Validates that entered value is an integer
     * @param value
     * @param maxValue
    *   @return         boolean
    *   @param          fieldValue: String, input
    *   @author         Niko Culevski
    *   @see            java.util.regex.Matcher
    *   @see            java.util.regex.Pattern
    *   Date            6/10/2013
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isInteger(String fieldValue)
    {
        Pattern pat = Pattern.compile("\\d+");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();   
    }
    
     public static boolean isInteger(String fieldValue, int lower, int upper)
    {
        boolean result = true;
        Pattern pat = Pattern.compile("\\d+");
        Matcher mat = pat.matcher(fieldValue);
        
        if(mat.matches())
        {
            try
            {
                int num = Integer.parseInt(fieldValue);
                if(num < lower || num > upper)
                    result = false;
            }
            catch(NumberFormatException ex)
            {
                result = false;
            }
        }
        else
        {
            result = false;
        }
        return result;   
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *   Method:         isEmpty()
    *   Description:    Validates that JTextField is not empty
    *   @return         boolean
    *   @param          fieldValue: JTextField, imput
    *   @author         Niko Culevski
    *   @see            java.util.regex.Matcher
    *   @see            java.util.regex.Pattern
    *   @see            javax.swing.JTextField;
    *   Date:           1/20/2014
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isEmpty(JTextField fieldValue)
    {
        String input = fieldValue.getText();
        if(input.length() <= 0 || input.equals(""))
            return true;
        else
            return false;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *   Method          isValidName()
    *   Description     Validates that JTextField is a valid city name
    *   @return         boolean
    *   @param          input: JTextField, input
    *   @author         Niko Culevski
    *   @see            java.util.regex.Matcher
    *   @see            java.util.regex.Pattern
    *   @see            javax.swing.JTextField;
    *   Date            1/20/2014
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    
    public static boolean isValidName(String input)
    {
        final short MAX_LENGTH = 30;
        final short MIN_LENGTH = 2;
        boolean result = true;
        
        if(input.length() > MAX_LENGTH || input.length() < MIN_LENGTH)
            result = false;
 
        return result;
    }

    static boolean isInt(String employeeHour, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}