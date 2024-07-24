/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

/**
 *
 * @author Admin
 */
public class CheckerBean {
    String name,age,hobby,email,gender,error;
    public void CheckerBean()
    {
    error="";
    }
    public void setName(String n)
    {
     name = n;
    }
     public void setAge(String n)
    {
     age = n;
    }
      public void setHobby(String n)
    {
     hobby = n;
    }
       public void setGender(String n)
    {
     gender = n;
    }
        public void setError(String n)
    {
     error = n;
    }
        
    public String getName()
    {
        return name;
    }
    public String getAge()
    {
       return age;
    }
    public String getHobby()
    {
       return hobby;
    }
    public String getEmail()
    {
       return email;
    }
    public String getGender()
    {
       return gender;
    }
    public String getError()
    {
        return error;
    }
    public boolean validate()
    {
        boolean res = true;
        if(name.trim().equals("")||(name==null))
        {
            error+="<br>Enter first name";
            res = false;
        }
        if(age.length()>2||(age==null))
        { error+="<br>age invalid";
            res = false;
        }
        return res;
    }
   
}

