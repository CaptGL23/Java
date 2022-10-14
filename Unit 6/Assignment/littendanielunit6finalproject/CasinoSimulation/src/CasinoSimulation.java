/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 21, 2022
*/

/*
    This is the main method and main class to
    run the Casino Simulation.  It will call on
    the MainMenu class, which in turn calls on
    the two game simulation classes based on the
    user's game selection.
*/

public class CasinoSimulation
{
    public static void main(String[] args)
    {
        // Create MainMenu object
        MainMenu greetingGameSelection = new MainMenu();

        // Call theMainMenu method
        greetingGameSelection.theMainMenu();
    }
}
