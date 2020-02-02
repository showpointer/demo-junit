package me.study.demojunit;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

	@DisplayName("Study 생성 테스트")
	@EnabledOnOs(OS.MAC)
	@Test
	void create() {
		Study study = new Study(10);
		
		assertAll ( 
			() -> assertNotNull(study),
			() -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRATF여야 한다."),
			() -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다")
		);
		
		System.out.println("created");
	}

	@DisplayName("Exception 테스트")
	@EnabledOnOs(OS.WINDOWS)
	@Test
	void limitTest() {
		IllegalArgumentException exception =
				assertThrows(IllegalArgumentException.class, () -> new Study(-10));
		assertEquals("limit은 0보다 커야 한다.",exception.getMessage());
		
	}
	
	@DisplayName("timeout 테스트 - 100ms 이상이면 실패")
	@Test
	void timeOutTest() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Study study = new Study(10);
			Thread.sleep(50);
		});
	}
	
	@DisplayName("timeoutPreemptivley - 100ms 넘어가면 실패 후 중지")
	@Test
	void timeOutPreempivelyTest() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Study study = new Study(10);
			Thread.sleep(300);
		});
	}
	
	@DisplayName("assume 테스트")
	@Test
	void assumeTest() {
		assumeTrue(false);
		
		System.out.println("실행 되지 않음");
	}
			
	@Test
	void create_new_study() {
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
}
