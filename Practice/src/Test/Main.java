package Test;


import java.util.HashMap;
import java.util.WeakHashMap;

public class Main {
	 public static void main(String[] args) throws InterruptedException
     {
		WeakHashMap<Student,String>  w=new WeakHashMap<>();
		
		Student st=new Student(101,"abc");
		w.put(st, "pass");
		System.out.println(w);
		st=null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(w);
		System.out.println("==========================");
		
        HashMap<Student,String>  h=new HashMap<>();
		
		Student st1=new Student(101,"abc");
		h.put(st1, "pass");
		System.out.println(h);
		st1=null;
		System.gc();
		Thread.sleep(3000);
		System.out.println(h);
		
     }
}

record Student(int id, String name) {
	
}

