package com.example.scalawebapp.controller

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.context.ContextConfiguration
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.junit.Assert._
import org.hamcrest.CoreMatchers._

@RunWith(classOf[SpringJUnit4ClassRunner])
@WebAppConfiguration
@ContextConfiguration(Array("file:src/main/webapp/WEB-INF/spring-context-data.xml", "file:src/main/webapp/WEB-INF/spring-context-web.xml"))
class HelloWorldControllerTest {

  @Autowired
  val helloWorldController : HelloWorldController = null
  
  @Test
  def shouldSayHelllo() {
	  assertThat(helloWorldController, notNullValue())
  }
}