package Week01.LiaBraatens;

import com.t00ter.T00t;
import com.t00ter.T00ter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Project: SE1021-031_Labs
 * Description:
 * Assignment Name: T00ter
 * Objectives: to review ArrayLists and their uses, as well as learning the usage of .jar libraries
 * Class: SE1021-031 Dennis  Lab: 1
 * FHT VERSION: 1.3 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/1/2014 at 8:58 PM.
 */
public class Lab1
{
    /**
     * the longest t00t in number of characters
     */
    private int longestT00t = Integer.MIN_VALUE;
    /**
     * the shortest t00t in number of characters
     */
    private int shortestT00t = Integer.MAX_VALUE;
    /**
     * the longest time between two consecutive t00ts
     */
    private double longestTimeBetweenT00ts = Double.MIN_VALUE;
    /**
     * the shortest time between two consecutive t00ts
     */
    private double shortestTimeBetweenT00ts = Double.MAX_VALUE;
    /**
     * the previous date of the two dates being compared
     */
    private Date previousDate = null;

    /**
     * the primary sequence of events are called and initiated from here
     * @param args unused argument
     */
    public static void main(String[] args)
    {
        Lab1 lab1 = new Lab1();
        int selection;
        do
        {
            selection = lab1.initialPrompt();
            if (selection == 1)
                lab1.getStats();
            else if (selection == 2)
                lab1.promptUsername();
        } while (selection != 0);

    }

    /**
     * provides the initial prompt to the user with three options for the user to choose from:
     *      Exit(0), Display Stats(1) and Get t00ts for user(1)
     * @return the user's choice of the three
     */
    private int initialPrompt()
    {
        ArrayList<String> userOptionsList = new ArrayList<String>() {{add("Exit"); add("Display Stats"); add("Get T00ts For User");}};
        String [] userOptionsArr = new String[userOptionsList.size()];
        userOptionsList.toArray(userOptionsArr);

        String userChoice = (String) JOptionPane.showInputDialog(null,"Select your course of action:", "Home", JOptionPane.PLAIN_MESSAGE, null, userOptionsArr, "0 (Exit)");

        return userOptionsList.indexOf(userChoice);
    }

    /**
     * provides the statistics of the most recent t00ts by all users
     */
    private void getStats()
    {
        this.getStats(new T00ter());
    }

    /**
     * obtains the username of a member of t00ter from the user, outputs their most recent t00ts, and their statistics
     */
    private void promptUsername()
    {
        T00ter temp;
        String userInput;
        do
        {
            userInput = JOptionPane.showInputDialog(null,"Enter the user that you would like T00ts of", "T00ter User Retrieval", JOptionPane.PLAIN_MESSAGE);
            temp = new T00ter(userInput);
            if (!temp.isValid())
                JOptionPane.showMessageDialog(null,"User " + userInput + " does not exist, try again", "Error", JOptionPane.ERROR_MESSAGE);

        } while (!temp.isValid());

        String t00tOutput = "";
        while (temp.hasNext())
            t00tOutput += temp.next();

        JOptionPane.showMessageDialog(null, t00tOutput, userInput + "'s T00ts", JOptionPane.PLAIN_MESSAGE);
        temp = new T00ter(userInput);
        getStats(temp);
    }

    /**
     * outputs the statistics such as:
     * Total t00ts, t00ts containing t00t, the number of characters in the longest t00t, the number of characters in the shortest t00t,
     * average length in characters of all the t00ts polled, the maximum time between any two consecutive t00ts and
     * the minimum time between any two consecutive t00ts
     *
     * these statistics are obtained from the t00ter object that is input, so they could apply to the most recent t00ts for all users
     * or for a specific user
     * @param input the input t00ter to obtain statistics of
     */
    private void getStats(T00ter input)
    {
        int t00tsWithToot, t00ts, totalT00tLength;
        t00tsWithToot = t00ts = totalT00tLength = 0;

        while (input.hasNext())
        {
            T00t temp = input.next();
            if (hasToot(temp))
                t00tsWithToot++;
            updateLengthOfT00ts(temp);
            updateMaxMinTime(temp);
            totalT00tLength += temp.getMessage().length();
            t00ts++;
        }
        double averageT00tLength = (totalT00tLength + 0.0)/t00ts;

        JOptionPane.showMessageDialog(null,"Total T00ts: " + t00ts + "\nT00ts That Contain Toot (or variation): " + t00tsWithToot + "\nLongest T00t: " + longestT00t + "\nShortest T00t: " + shortestT00t
                + "\nAverage T00t Length: " + averageT00tLength + "\nMinimum Time Between T00ts: " + formatTime(shortestTimeBetweenT00ts) + "\nMaximum Time Between T00ts: " + formatTime(longestTimeBetweenT00ts),"Stats",JOptionPane.PLAIN_MESSAGE);

    }

    /**
     * to output a clean and user friendly string from the number of milliseconds input
     * @param timeInMS the time to be formatted in milliseconds
     * @return a string of appropriate time measurements (days, hours, etc.) that are labeled
     */
    private String formatTime (double timeInMS)
    {
        double timeInSec = timeInMS / 1000.0;
        System.out.println("the time measured in seconds is: " + timeInSec);
        ArrayList<Integer> times = new ArrayList<Integer>();
        ArrayList<Integer> multipliers = new ArrayList<Integer>(){{add(365); add(24); add(60); add(60);}};

        double temp = timeInSec / 31557600.0;
        for (int i = 0; i < multipliers.size(); i++)
        {
            times.add((int)temp);
            temp -= times.get(i);
            temp *= multipliers.get(i);

        }
        times.add((int) (temp + 0.5));

        ArrayList<String> timeAnnotations = new ArrayList<String>() {{add(" Years, "); add(" Days, "); add(" Hours, "); add(" Minutes, "); add(" Seconds");}};
        String output = "";
        for(int i = 0; i < times.size(); i++)
            if (times.get(i) != 0)
                output += "" + times.get(i) + timeAnnotations.get(i);


        return output;
    }

    /**
     * updates the global variables: @longestT00t and @shortestT00t from the input t00t, if the input t00t is longer or shorter respectively
     * @param temp the t00t to compare to the longest and shortest t00t
     */
    private void updateLengthOfT00ts(T00t temp)
    {
        int tempLength = temp.getMessage().length();
        if (tempLength > longestT00t)
            longestT00t = tempLength;

        if (tempLength < shortestT00t)
            shortestT00t = tempLength;
    }

    /**
     * to update the maximum and minimum times between two t00ts
     * @param temp the next t00t to be compared with the previous
     */
    private void updateMaxMinTime(T00t temp)
    {
        Date currentDate = temp.getDate();
        if (previousDate != null)
        {
            double difference = Math.abs(previousDate.getTime() - currentDate.getTime());
            if (difference > longestTimeBetweenT00ts)
                longestTimeBetweenT00ts = difference;

            if (difference < shortestTimeBetweenT00ts)
                shortestTimeBetweenT00ts = difference;
            previousDate = currentDate;
        }
        else
            previousDate = currentDate;
    }

    /**
     * checks the contents of a t00t for the word toot in upper or lower case and variations: t0ot, t00t, to0t
     * @param temp the t00t to be checked
     * @return the number of toots or variations that are contained in the message of the t00t
     */
    private boolean hasToot(T00t temp)
    {
        String message = temp.getMessage();
        ArrayList<String> matchWords = new ArrayList<String>() {{add("toot"); add("t00t"); add("to0t"); add("t0ot");}};
        for (String word : matchWords)
        {
            word = ".*\\b" + word + "\\b.*";
            Pattern matchWord = Pattern.compile(word);
            if (matchWord.matcher(message).matches())
                return true;
        }
        return false;
    }

}
