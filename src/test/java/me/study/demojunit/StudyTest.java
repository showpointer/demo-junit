package me.study.demojunit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudyTest {

	@Test
	void create() {
		Study study = new Study();
		
		assertNotNull(study);
		System.out.println("created");
	}
	
	@Test
	void create1() {
		System.out.println("created1");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("beforeEach");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("afterEach");
	}
}
