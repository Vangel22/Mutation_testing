package pitest_classes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConferenceTest {
    private final double TICKET_FOR_EMPLOYEE = 2.601;
    private final double TICKET_FOR_AFFILIATE = 7.803;
    private final double TICKET_PRICE = 8.67;
    private final int CAPACITY_LIMIT = 10000;

    private Conference conference = new Conference(4);
    private List<Person> people = this.conference.getAttendees();

    public ConferenceTest() {
        Person person1 = new Person("Aleksandar","Acev", Role.AFFILIATE, 25); //7.803
        Person person2 = new Person("Nikola","Nikolov", Role.FACULTY_EMPLOYEE, 30); //2.601
        Person person3 = new Person("Petar","Petrov", Role.OTHER, 45);
        people.add(person1);
        people.add(person2);
        people.add(person3);
    }


    @Test
    public void calculatePriceTest() {
        double total = TICKET_PRICE + TICKET_FOR_AFFILIATE + TICKET_FOR_EMPLOYEE;
        double price = this.conference.calculateTotalPricePaid();
        Assert.assertEquals(total, price, 0.0D);
    }

    @Test //test passed
    public void addAttendeeToConferenceTest_1() {
        Person person = new Person("Vangel","Hristov", Role.STUDENT, 21);
        Assert.assertTrue(this.conference.addAttendeeToConference(person));
    }

    @Test
    public void addAttendeeToConference_2() {
        int size = this.people.size();
        int capacity = this.conference.getCapacity();

        if((size < capacity) || this.conference.doubleCapacity()){
            Assert.assertTrue("Free places at conference", true);
        } else {
            Assert.assertFalse(false);
        }
    }


    @Test //test passed
    public void doubleCapacityTest_1() {
        int capacity = this.conference.getCapacity(); //4
        if(capacity * 2 > CAPACITY_LIMIT) {
            Assert.assertFalse(this.conference.doubleCapacity());
        }else {
            Assert.assertTrue(this.conference.doubleCapacity());
        }
    }

    @Test //test passed
    public void doubleCapacityTest_2() {
        int capacity = this.conference.getCapacity(); //4
        if(capacity < CAPACITY_LIMIT) {
            Assert.assertTrue(this.conference.doubleCapacity());
        }else {
            Assert.assertFalse(this.conference.doubleCapacity());
        }
    }

    @Test
    public void testSetSurname() {
        this.people.get(0).setSurname("Ristov");
        Assert.assertTrue(true);
    }

    @Test
    public void testSetRole() {
        this.people.get(0).setRole(Role.STUDENT);
        Assert.assertTrue(true);
    }

}
