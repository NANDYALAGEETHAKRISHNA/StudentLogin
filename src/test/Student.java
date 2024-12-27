package test;
public class Student
{
    public String name,branch,rollno,result;
    public int totMarks;
    public float per;
    public String toString()
    {
        return(name+"\t"+branch+"\t"+rollno+"\t"+totMarks+"\t"+per+"\t"+result);
    }
}