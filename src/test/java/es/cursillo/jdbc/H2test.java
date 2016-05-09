package es.cursillo.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class H2test {
	H2 con = new H2();

	@After
	public void tearDown() throws Exception {
		con.close();
	}

	@Test
	public void Connectiontest() {
		con.connect();
		Assert.assertTrue(con.isConnected());
	}

}
