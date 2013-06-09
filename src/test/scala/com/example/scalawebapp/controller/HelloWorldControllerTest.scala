package com.example.scalawebapp.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional

class HelloWorldControllerTest extends AbstractControllerTest {

  @Test
  def shouldSayHello() {
    mockMvc.perform(get("/hello")).andExpect(status().isOk())
  }
}