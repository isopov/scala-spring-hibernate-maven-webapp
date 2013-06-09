package com.example.scalawebapp.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{ PathVariable, ModelAttribute, RequestMapping, RequestParam }
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.servlet.ModelAndView

import com.example.scalawebapp.data.Customer
import com.example.scalawebapp.repository.CustomerRepository
import reflect.BeanProperty
import javax.validation.constraints.NotNull
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.Valid
import org.springframework.validation.BindingResult
import collection.JavaConversions._

import java.{lang => jl}

@Controller
class CustomerController {

  import ControllerTools._

  @Autowired
  val customerRepository: CustomerRepository = null

  @RequestMapping(value = Array("/customers/new"), method = Array(GET))
  def showNewCustomerForm() = new ModelAndView("customer/customer-new", "customerData", new CustomerPageData)

  @RequestMapping(value = Array("/customers/new"), method = Array(POST))
  def createNewCustomer(
        @Valid @ModelAttribute("customerData") customerData: CustomerPageData,
        bindingResult: BindingResult): String = {
    if (bindingResult.hasErrors) {
      "customer/customer-new"
    } else {
      val newCustomer = new Customer
      customerData.copyTo(newCustomer)
      "redirect:/customers/" + customerRepository.save(newCustomer).id + ".html"
    }
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(GET))
  def viewCustomer(
        @PathVariable customerId: jl.Long,
        @RequestParam(required = false) edit: String) = {
    val customer: Customer = customerRepository.findOne(customerId)
    if (edit == null) {
      new ModelAndView("customer/customer-view", "customer", customer)
    }
    else {
      new ModelAndView("customer/customer-edit", Map("customer" -> customer, "customerData" -> CustomerPageData(customer)))
    }
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(POST))
  def editCustomer(
        @PathVariable customerId: jl.Long,
        @Valid @ModelAttribute("customerData") customerData: CustomerPageData,
        bindingResult: BindingResult): ModelAndView = {
    val customer = customerRepository.findOne(customerId)
    if (bindingResult.hasErrors) {
      new ModelAndView("customer/customer-edit", "customer", customer)
    } else {
      customerData.copyTo(customer)
      customerRepository.save(customer)
      new ModelAndView("redirect:/customers/{customerId}.html")
    }
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(DELETE))
  def deleteCustomer(@PathVariable customerId: Long) = {
    customerRepository.delete(customerId)
    "redirect:/"
  }

  @RequestMapping(value = Array("/customers"), method = Array(DELETE))
  def deleteAllCustomers() = {
    for (c: Customer <- customerRepository.findAll()) {
      customerRepository.delete(c.id)
    }
    "redirect:/"
  }
}

class CustomerPageData {
  @BeanProperty @NotNull @NotEmpty
  var name: String = null;

  override def toString = "[CustomerPageData: name = " + name + "]"

  def copyTo(customer: Customer): Unit = {
    // TODO: Use Dozer to do this automatically
    customer.name = name
  }

  def copyFrom(customer: Customer): Unit = {
    // TODO: Use Dozer to do this automatically
    name = customer.name
  }
}

object CustomerPageData {
  def apply(c: Customer): CustomerPageData = {
    val data = new CustomerPageData
    data.copyFrom(c)
    data
  }
}
