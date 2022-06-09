package com.desafio.movement.manual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;


@SpringBootTest
class ManualMovementApplicationTests {

	@Autowired private DataSource db;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(db);
	}

}
