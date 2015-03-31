package hu.bfo.web;

public class A implements IA {

	public String myVar = null;

	public void mustLogToSysOut() {
		myVar = "Value";
		this.mustLogToSysOut2();
	}


	public void mustLogToSysOut2() {
		// TODO Auto-generated method stub
		
	}

	
}
