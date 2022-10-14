/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 3, 2022
*/

/*
    This program demonstrates all of the classes and interface.
 */

public class CourseGradesDemo {

    public static void main(String[] args)
    {
        // Lab activity observed by teacher and assigned a numeric score
        // Create GradedActivity object
        GradedActivity labActivity = new GradedActivity(75);

        // Pass/fail exam that has 10 questions with a minimum passing score of 70.
        // Create PassFailExam onject
        PassFailExam pfExam = new PassFailExam(10, 3, 7);

        // An essay that is assigned a numeric score
        // Create Essay object
        Essay essay = new Essay(25, 15, 13, 27);

        // A final exam that has 50 questions
        // Create FinalExam object
        FinalExam fExam = new FinalExam(50, 4);

        // Create a CourseGrades object
        CourseGrades c = new CourseGrades();

        // Call Superclass and subclasses methods and set with the above values
        c.setLab(labActivity);
        c.setPassFailExam(pfExam);
        c.setEssay(essay);
        c.setFinalExam(fExam);

        // Display the toString method from the CourseGrades class
        // Display the information to the user
        System.out.println(c);
    }
}
