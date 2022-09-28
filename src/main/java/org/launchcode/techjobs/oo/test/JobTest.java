package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job aJob = new Job();
        Job anotherJob = new Job();
        assertNotEquals(aJob.getId(), anotherJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(aJob.getName() instanceof String);
        assertEquals("Product tester", aJob.getName());

        assertTrue(aJob.getEmployer() instanceof Employer);
        assertEquals("ACME", aJob.getEmployer().getValue());

        assertTrue(aJob.getLocation() instanceof Location);
        assertEquals("Desert", aJob.getLocation().getValue());

        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", aJob.getPositionType().getValue());

        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", aJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));

        assertEquals(job.toString().charAt(0), '\n');
        assertEquals(job.toString().charAt(job.toString().length() -1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));

        assertEquals("\nID:" + job.getId() + "\nName: Web Developer" +
                "\nEmployer: LaunchCode" +
                "\nLocation: StL" +
                "\nPosition Type: Back-end developer" +
                "\nCore Competency: Java" + "\n", job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        assertEquals("\nID:" + job.getId() + "\nName: Web Developer" +
                "\nEmployer: Data not available" +
                "\nLocation: StL" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Java" + "\n", job.toString());
    }
}
