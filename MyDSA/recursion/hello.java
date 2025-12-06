package MyDSA.recursion;
//
//public class hello {
//
//    public static void main(String[] args) {
//        byte b=127;
//        int a=b;
//        System.out.println(b);
//        System.out.println(a);
//
//        byte b1=125;
//        int a0=b1;
//        System.out.println(b1);
//        System.out.println(a0);
//
//        int aa=257;
//        byte k=(byte)aa;
//
//        float f=5.6f;
//        int t=(int)f;
//
//        int a2=2567;
//        byte b2=(byte)a;
//        System.out.println(k);
//
//        byte a3=10;
//        byte b4=20;
//        t=a*b;
//        System.out.println(t);
//
//    }
//double f = Math. random()/ Math. nextDown(1.0); double x = x1*(1.0 - f) + x2*f;
//}
class Student
{
    int rollno;
    String name;
    int marks;
}
class Demo {
    public static void main(String[] args)
    {
        Student s1=new Student();
        s1.rollno=1;
        s1.name="Navin";
        s1.marks=88;

        Student s2=new Student();
        s2.rollno=2;
        s2.name="Harsh";
        s2.marks=67;

        Student s3=new Student();
        s3.rollno=3;
        s3.name="Kiran";
        s3.marks=97;

        System.out.println(s1.name + ":"+ s1.marks);

        Student students[]=new Student[3];
        students[0]=s1;
        students[1]=s2;
        students[2]=s3;

//		for(int i=0;i<students.length;i++)
//		{
//			System.out.println(students[i].name+":"+students[i].marks);
//		}

        for(Student stud: students)
        {
            System.out.println(stud.name +":"+stud);
        }




        int nums[]=new int[4];
        nums[0]=4;
        nums[1]=8;
        nums[2]=3;
        nums[3]=9;

//		for (int i=0;i<nums/length;i++)
//		{
//			System.out.println(nums[i]);
//		}

        for(int n: nums)
        {
            System.out.println(n);
        }

    }
}