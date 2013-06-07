/*
 * This code is in the public domain and may be used in any way you see fit, with the following conditions:
 *
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *     THE SOFTWARE.
 */

package com.example.scalawebapp.repository

import com.example.scalawebapp.data.Customer
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import org.springframework.data.repository.CrudRepository

trait CustomerRepository extends CrudRepository[Customer, java.lang.Long]{
//  def getAll: java.util.List[Customer]
//  def save(customer: Customer): Long
//  def update(customer: Customer)
//  def get(customerId: Long): Customer
//  def delete(customerId: Long)
}

//@Repository
//class CustomerRepositoryImpl extends CustomerRepository {
//  @PersistenceContext
//  var entityManager : EntityManager = null
//
//  @Transactional
//  def save(customer: Customer): Long = {
//    val customerId = getCurrentSession.save(customer);
//    return  customerId.asInstanceOf[Long]
//  }
//
//  @Transactional
//  def update(customer: Customer) = entityManager.persist(customer)
//
//  @Transactional
//  def delete(customerId: Long) = entityManager.remove(get(customerId))
//
//  @Transactional(readOnly = true)
//  def get(customerId: Long): Customer = entityManager.find(classOf[Customer], Long.box(customerId)).asInstanceOf[Customer]
//
//  @Transactional(readOnly = true)
//  def getAll: java.util.List[Customer] = {
//    entityManager.
//    entityManager.createQuery(criteriaQuery)
//    
//  }entityManager.createCriteria(classOf[Customer]).list().asInstanceOf[java.util.List[Customer]]

//  def setSessionFactory(sessionFactory: SessionFactory): Unit = {
//    this.sessionFactory = sessionFactory
//  }
//
//  def getCurrentSession = sessionFactory.getCurrentSession
//}