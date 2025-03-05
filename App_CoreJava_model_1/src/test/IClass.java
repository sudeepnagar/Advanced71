package test;

public class IClass  implements ITest {

	@Override
	public void m1(int x) {
		  System.out.println("********Implemented method m1********");
		System.out.println("The value x= "+x);
	}
       
}
