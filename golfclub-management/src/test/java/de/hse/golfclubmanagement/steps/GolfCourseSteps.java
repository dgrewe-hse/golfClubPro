package de.hse.golfclubmanagement.steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.models.Hole;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GolfCourseSteps {
    private String initialCourseName; // Stores the name of the initial course
    private GolfCourse golfCourse; // Currently processed golf course
    private List<GolfCourse> golfCourses; // List of all golf courses
    private List<GolfCourse> resultFirstStep; // Result after the first operation
    private List<GolfCourse> resultSecondStep; // Result after filtering by location
    private GolfCourse resultThirdStep; // Result after modifying a specific course

    // Define Cucumber parameter types
    @ParameterType("Stuttgart")
    public String location(String location) {
        return location;
    }

    @ParameterType("FancyGolfCourse")
    public String courseName(String courseName) {
        return courseName;
    }

    @ParameterType("initialCourseName")
    public String initialCourseName(String initialCourseName) {
        return initialCourseName;
    }

    // Initialize the application with one example course
    @Given("I have the golfClubPro application")
    public void iHaveTheGolfClubProApplication() {
        initialCourseName = "CrazyGolfCourse";

        golfCourse = new GolfCourse();
        golfCourse.setName(initialCourseName);
        golfCourse.setLocation("Stuttgart");

        golfCourses = new ArrayList<>();
        golfCourses.add(golfCourse);
    }

    // Add a new golf course with a specified name and location
    @When("I add the “{courseName}” golf course in “{location}“")
    public void iAddTheGolfCourse(String couseName, String location) {
        golfCourse = new GolfCourse();
        golfCourse.setName(couseName);
        golfCourse.setLocation(location);
        golfCourses.add(golfCourse);

        resultFirstStep = new ArrayList<>(golfCourses); // Save current state for validation
    }

    // Filter golf courses by location
    @When("I enter “{location}“ as a location")
    public void iEnterLocation(String location) {
        resultSecondStep = golfCourses.stream()
                .filter(course -> location.equals(course.getLocation()))
                .collect(Collectors.toList());
    }

    // Update the hole layout for a specific course
    @When("I update the hole layout to “{int}“-holes for the “CrazyGolfCourse”")
    public void iUpdateHoleLayout(int holes) {
        List<GolfCourse> search_result = golfCourses.stream()
                .filter(course -> initialCourseName.equals(course.getName()))
                .collect(Collectors.toList());
        golfCourse = search_result.get(0);

        // Create new holes and assign them to the course
        golfCourse.setHoles(IntStream.rangeClosed(1, holes)
                .mapToObj(i -> new Hole())
                .collect(Collectors.toList()));

        resultThirdStep = golfCourse;
    }

    // Verify if a specific course is displayed
    @Then("the result should be that “{courseName}” will show up")
    public void theResultShouldShowCourse(String expectedCourseName) {
        assertEquals(expectedCourseName, resultFirstStep.get(resultFirstStep.size() - 1).getName());
    }

    // Verify if all golf courses in a specific location are displayed
    @Then("the result should be that I can see all golf courses in “{location}“")
    public void theResultShouldMatchAllGolfCourses(String location) {
        List<GolfCourse> filteredCourses = golfCourses.stream()
                .filter(course -> location.equals(course.getLocation()))
                .collect(Collectors.toList());

        assertEquals(filteredCourses, resultSecondStep);
    }

    // Verify if the hole layout was updated correctly
    @Then("the result should be that the hole layout is changed to “{int}“ holes for the “CrazyGolfCourse” course")
    public void theResultShouldMatchHoleLayout(int expectedHoles) {
        assertEquals(expectedHoles, resultThirdStep.getHoles().size());
    }
}
