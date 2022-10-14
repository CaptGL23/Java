/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 3, 2022
*/

/*
    This class stores all of the graded activity
    and displays it to the user when called on by the
    CourseGradesDemo.
 */

import java.text.DecimalFormat;


class CourseGrades implements Analyzable
{
    DecimalFormat f = new DecimalFormat("###.##");
    private double average;

    private GradedActivity[] grades = new GradedActivity[5];

    /**
     * setLab method
     * @param l The lab activity
     */
    public void setLab(GradedActivity l)
    {
        grades[0] = l;
    }

    /**
     * setPassFailExam method
     * @param p The pass/fail exam
     */
    public void setPassFailExam(PassFailExam p)
    {
        grades[1] = p;
    }

    /**
     * setEssay method
     * @param e The essay assignment
     */
    public void setEssay(Essay e)
    {
        grades[2] = e;
        e.doTotal();
    }

    /**
     * setFinalExam method
     * @param f The final exam
     */
    public void setFinalExam(FinalExam f)
    {
        grades[3] = f;
    }

    /**
     * toString method to display information to user
     * @return The string
     */
    public String toString()
    {
        String str;
        str = "Lab Activity: "+f.format(grades[0].getScore())+"% ("+grades[0].getGrade()+")\n"
                + "Pass/Fail exam: "+f.format(grades[1].getScore())+"% ("+grades[1].getGrade()+")\n"
                + "Essay: "+f.format(grades[2].getScore())+"% ("+grades[2].getGrade()+")\n"
                + "Final exam: "+f.format(grades[3].getScore())+"% ("+grades[3].getGrade()+")\n"
                + "Average: "+f.format(getAverage())+"% ("+grades[4].getGrade()+")\n"
                + "Highest grade: "+f.format(getHighest().getScore())+"% ("+getHighest().getGrade()+")\n"
                + "Lowest grade: "+f.format(getLowest().getScore())+"% ("+getLowest().getGrade()+")";
        return str;
    }

    /**
     * getAverage method
     * @return The average score
     */
    public double getAverage()
    {
        double total=0;
        for(int i=0; i<4; i++){
            total+=grades[i].getScore();
        }
        grades[4] = new GradedActivity(total/4);
        return grades[4].getScore();
    }

    /**
     * getHighest method
     * @return The highest score
     */
    public GradedActivity getHighest()
    {
        int highest = 0;
        for(int i=0; i<(grades.length-1); i++)
        {
            if(grades[i].getScore() > grades[highest].getScore())
                highest=i;
        }
        return grades[highest];
    }

    /**
     * getLowest method
     * @return The lowest score
     */
    public GradedActivity getLowest()
    {
        int lowest=0;
        for(int i=0; i<(grades.length-1); i++){
            if(grades[i].getScore() < grades[lowest].getScore())
                lowest = i;
        }
        return grades[lowest];
    }
}
