package com.example.scalawebapp.controller

import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext

@RunWith(classOf[SpringJUnit4ClassRunner])
@WebAppConfiguration
@ContextConfiguration(Array("file:src/main/webapp/WEB-INF/spring-context-data.xml", "file:src/main/webapp/WEB-INF/spring-context-web.xml"))
//TODO Transactional CustomerControllerTest does not work 
//@Transactional
abstract class AbstractControllerTest {

  @Autowired
  val wac: WebApplicationContext = null

  var mockMvc: MockMvc = null

  @Before
  def setup() {
    mockMvc = webAppContextSetup(wac).build();
  }

}