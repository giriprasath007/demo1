package framework_test;

import org.testng.annotations.Test;

public class Amazoncheckout extends Com_driver{
	AmazonMethods chk = new AmazonMethods();
@Test
public void checkout(){
	
	//chk.launch();
	chk.signin();
	chk.chkNclrcart();
	chk.searchNbuy();
	
}
}

