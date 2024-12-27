package maccess;
import test.*;
import java.util.*;
public class Demoarray {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Students");
		int n = Integer.parseInt(s.nextLine());
		Student ob[] = new Student[n];
		System.out.println("Enter "+n+" Student details...");
		for(int i=0;i<ob.length;i++)
		{
		System.out.println("***Student-"+(i+1)+ "details****");
		ob[i] = new Student();
		System.out.println("Enter the Name:");
		ob[i].name = s.nextLine();
		System.out.println("Enter the branch(CIVIL/EEE/MECH/ECE/CSE):");
		ob[i].branch = s.nextLine().toUpperCase();
		CheckBranch cb = new CheckBranch();
		boolean k = cb.Verify(ob[i].branch);
		if(k)
		{
		System.out.println("Enter the rollNO:");
		ob[i].rollno = s.nextLine();
		if(ob[i].rollno.length()==10) {
		GenerateBranchByCode gc = new GenerateBranchByCode();
		String gBr = gc.generate(ob[i].rollno.substring(6,8));
		if(gBr==null) {
		System.out.println("RollNo holding invalid branch code..");
		i--;
		}else {
		if(gBr.equals(ob[i].branch)) {
		System.out.println("===Enter 6 Sub marks===");
		int j=1,totM=0;
		boolean p=false;
		while(j<=6)
		{
		System.out.println("Enter the marks of sub-"+j);
		int sub = Integer.parseInt(s.nextLine());
		if(sub<=0 || sub>=100)
		{
		System.out.println("Invalid marks..");
		continue;
		}
		if(sub>=0&&sub<=34)
		{
		p=true;
		}
		j++;

		totM=totM+sub;
		}//end of loop
		ob[i].totMarks=totM;
		ob[i].per=(float)ob[i].totMarks/6;
		StudentResult sr = new StudentResult();
		ob[i].result = sr.result(ob[i].per, p);
		}else {
		System.out.println("RollNo not matched with branch..");
		i--;
		}
		}
		}//end of if
		else {
		System.out.println("Invalid rollNo..");
		i--;
		}

		}//end of if
		else
		{
		System.out.println("Invalid branch...");
		i--;
		}
		}//end of loop

		System.out.println("=====Student details=====");
		for(Student c : ob)
		{
		System.out.println(c.toString());
		}//end of loop
		System.out.println("Enter the rollNo to display 6 SubMarks:");
	

	}
}