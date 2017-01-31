package com.allstate;

import com.allstate.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		CarServiceTest.class,
		CityServiceTest.class,
		DriverServiceTest.class,
		PassengerServiceTest.class
})
public class RideSharingApplicationTests {

	@Test
	public void contextLoads() {
	}

}
