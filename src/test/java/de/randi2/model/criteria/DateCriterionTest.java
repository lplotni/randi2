package de.randi2.model.criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import de.randi2.model.criteria.constraints.DateConstraint;
import de.randi2.test.utility.AbstractDomainTest;
import de.randi2.unsorted.ContraintViolatedException;

import static junit.framework.Assert.*;

public class DateCriterionTest extends AbstractDomainTest<DateCriterion>{

	
	

	
	public DateCriterionTest(){
		super(DateCriterion.class);
	}
	private DateCriterion criterion;
	private GregorianCalendar firstDate;
	private GregorianCalendar secondDate;
	
	@Before
	public void setUp(){
		super.setUp();
		criterion = new DateCriterion();
		firstDate = new GregorianCalendar(1998,7,1);
		secondDate = new GregorianCalendar(2000,7,1);
	}
	
	@Test
	public void testSimpleCase(){
		assertTrue(criterion.checkValue(firstDate));
		assertTrue(criterion.checkValue(new GregorianCalendar(2001,10,10)));
		assertTrue(criterion.checkValue(new GregorianCalendar(2000,10,22)));
		assertTrue(criterion.checkValue(new GregorianCalendar(2000,12,10)));
		assertTrue(criterion.checkValue(new GregorianCalendar(2003,9,10)));
		assertFalse(criterion.checkValue(null));
		
		assertFalse(criterion.isInclusionCriterion());
	}
	
	@Test
	public void testWithInclusionCriterion() {
		criterion.setDescription("test");
		GregorianCalendar date =new GregorianCalendar(2000,12,10) ;
		try {
			criterion.setInclusionConstraint(new DateConstraint(Arrays.asList(new GregorianCalendar[]{date})));
		} catch (ContraintViolatedException e) {
			fail(e.getMessage());
		}
		GregorianCalendar date1 =new GregorianCalendar(2001,12,10) ;
		assertTrue(criterion.checkValue(date1));
		
		assertTrue(criterion.isInclusionCriterion());

	}
	
	@Test
	public void testConfiguredValue(){
		assertNotNull(criterion.getConfiguredValues());
		assertTrue(criterion.getConfiguredValues().isEmpty());
	}
	
	@Test
	public void testWithStratification() throws ContraintViolatedException {
		criterion.setDescription("test");
		
		assertNull(criterion.stratify(secondDate));
		List<DateConstraint> temp = new ArrayList<DateConstraint>();
		temp.add(new DateConstraint(Arrays.asList(new GregorianCalendar[]{firstDate})));
	

		criterion.setStrata(temp);
		
		assertTrue(criterion.getStrata().containsAll(temp));
		assertTrue(temp.containsAll(criterion.getStrata()));

		assertEquals(temp.get(0), criterion.stratify(firstDate));

		try {
			criterion.stratify(new GregorianCalendar(1993,7,1));
			fail("AGAIN -> WRONG!");
		} catch (ContraintViolatedException e) {
		}

	}
	
	@Test
	@Transactional
	public void databaseIntegrationTest() {
		criterion.setName("name");
		criterion.setDescription("test");
		List<GregorianCalendar> elements = new ArrayList<GregorianCalendar>();
		elements.add(new GregorianCalendar());
		elements.add(new GregorianCalendar());
		try {
			ArrayList<DateConstraint> temp = new ArrayList<DateConstraint>();
			temp.add(new DateConstraint(Arrays.asList(new GregorianCalendar[]{elements.get(0)})));
			temp.add(new DateConstraint(Arrays.asList(new GregorianCalendar[]{elements.get(1)})));
		
			DateConstraint constraint = new DateConstraint(Arrays.asList(elements.get(0)));
			sessionFactory.getCurrentSession().save(constraint);
			assertTrue(constraint.getId()>0);
			criterion.setInclusionConstraint(constraint);


			sessionFactory.getCurrentSession().save(criterion);
			assertTrue(criterion.getId()>0);
			assertEquals(criterion.getInclusionConstraint().getId(), constraint.getId());
			sessionFactory.getCurrentSession().save(temp.get(0));
			sessionFactory.getCurrentSession().save(temp.get(1));
			assertTrue(temp.get(0).getId() > 0);
			assertTrue(temp.get(1).getId() > 0);
			criterion.setStrata(temp);
			sessionFactory.getCurrentSession().update(criterion);
			DateCriterion dbCriterion = (DateCriterion) sessionFactory.getCurrentSession().get(DateCriterion.class,criterion.getId());
			assertEquals(criterion, dbCriterion);
			assertEquals(criterion.getName(), dbCriterion.getName());
			assertEquals(criterion.getDescription(), dbCriterion.getDescription());
			assertEquals(constraint.getId(), dbCriterion.getInclusionConstraint().getId());
			assertEquals(DateConstraint.class, dbCriterion.getContstraintType());

		} catch (ContraintViolatedException e) {
			//fail();
		}
	}
	
}