package com.yiyego.databaseuntil;

import static org.junit.Assert.*;

import org.junit.Test;

public class dbTest {

	@Test
	public void test() {
		UserDaoimpl all = new UserDaoimpl();
		all.findall();
	}

}
