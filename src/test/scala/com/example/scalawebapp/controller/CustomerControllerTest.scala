package com.example.scalawebapp.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders._
import org.springframework.test.web.servlet.result.MockMvcResultMatchers._
import org.springframework.transaction.annotation.Transactional
import org.hamcrest.core.StringStartsWith.startsWith
import org.hamcrest.core.StringEndsWith.endsWith
import java.{ lang => jl }
import org.hamcrest.CustomMatcher
import org.junit.Assert._
import com.example.scalawebapp.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired

class CustomerControllerTest extends AbstractControllerTest {

  @Autowired
  val customerRepository: CustomerRepository = null

  @Test
  def shouldShowNewCustomerForm() {
    mockMvc.perform(get("/customers/new.html")).andExpect(status().isOk())
  }

  @Test
  def shouldCreateNewCustomer() {

    var customerId: jl.Long = null

    mockMvc.perform(post("/customers/new.html")
      .param("name", "James Bond"))
      .andExpect(status().isFound())
      .andExpect(header().string("Location", startsWith("/customers/")))
      .andExpect(header().string("Location", new CustomMatcher[String]("Storing customerid") {

        def matches(item: Any): Boolean = {
          val itemString = item.asInstanceOf[String]
          customerId = jl.Long.valueOf(itemString
            .drop("/customers/".length)
            .dropRight(".html".length))
          return true
        }

      }))
      .andExpect(header().string("Location", endsWith(".html")))

    assertNotNull(customerId);

    val customer = customerRepository.findOne(customerId);
    assertEquals("James Bond", customer.name)
  }

  @Test
  def shouldDeleteCustomers() {
    mockMvc.perform(delete("/customers"))
      .andExpect(status().isFound())
      .andExpect(header().string("Location", startsWith("/")))
  }

}