package hu.bfo.web;

public class AProxy implements IA {

	A a = new A();
	
	public void mustLogToSysOut() {
		
		System.out.println("In mustLogToSysOut method");
		a.mustLogToSysOut();
		System.out.println("mustLogToSysOut finished: "+a.myVar);
		
	}


	public void mustLogToSysOut2() {
		
		System.out.println("In mustLogToSysOut method");
		a.mustLogToSysOut2();
		System.out.println("mustLogToSysOut finished: "+a.myVar);
		
	}
	
	
	public static void main(String[]args){
		
		IA a = new AProxy();
		a.mustLogToSysOut();
	}



}
