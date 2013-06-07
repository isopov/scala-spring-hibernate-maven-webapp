package com.example.scalawebapp.controller

import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders._
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders._
import org.springframework.test.web.servlet.result.MockMvcResultMatchers._
import org.junit.Before

@RunWith(classOf[SpringJUnit4ClassRunner])
@WebAppConfiguration
@ContextConfiguration(Array("file:src/main/webapp/WEB-INF/spring-context-data.xml", "file:src/main/webapp/WEB-INF/spring-context-web.xml"))
class HelloWorldControllerTest {

  @Autowired
  val wac: WebApplicationContext = null

  @Autowired
  val helloWorldController: HelloWorldController = null

  var mockMvc: MockMvc = null

  @Before
  def setup() {
    mockMvc = webAppContextSetup(wac).build();
  }

  @Test
  def shouldSayHello() {

    mockMvc.perform(get("/hello"))
      .andExpect(status().isOk())

    assertThat(helloWorldController, notNullValue())
  }
}