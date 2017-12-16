package com.ennovate;

import com.ennovate.service.ConditionalBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"A"})
public class DefaultSpringProfileBehaviorTests {

	@Autowired
	Environment environment;

	@Autowired
	ConditionalBean conditionalBean;

	@Test
	public void generatesConditionalBeanA_whenOnlyProfileAIsActive() {
		assertThat(conditionalBean.getValue(), equalTo("A"));
	}

}