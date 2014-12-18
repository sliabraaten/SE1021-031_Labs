package Week01.LiaBraatens;

/**
 * Project: SE1021-031_Labs
 * Description: to indicate weather a number is 0,1 or 2
 * Objectives: NA
 * Class: SE1021-031 Dennis Lab: 1
 * FHT VERSION: 1.2 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/1/2014 at 9:05 PM.
 */
public class NotZeroOneOrTwoException extends Exception
{

    @Override
    public String getLocalizedMessage()
    {
        return "the input number is not of the value 0,1 or 2";
    }

    public static void main(String[] args)
    {

    }
}
