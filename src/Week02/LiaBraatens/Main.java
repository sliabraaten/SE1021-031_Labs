
package Week02.LiaBraatens;

import java.util.Scanner;

/**
 * A simple test program for SE1021 laboratory assignment 2 in
 * winter 2014-2015.
 * @author schilling with minor edits by taylor
 * @version 1.1-20141205
 */
public class Main {

    /**
     * Provides a menu to obtain book and article references and then
     * display them to the console window.
     * @param args ignored
     */
    public static void main(String[] args) {
        // This variable will hold the references used.
        ReferenceHolder references = new ReferenceHolder();

        // Setup the keyboard as an input.
        Scanner kbd = new Scanner(System.in);

        char entry = '-';
        do {
            // Prompt the user for input.
            printPrompt();

            // Get the entry.
            String input = kbd.nextLine();
            if(input.length()==1) {
                entry = input.charAt(0);
            }

            switch (entry) {
                case '1': // Add a new book.
                    Book book = createBookEntry(kbd);
                    references.addReference(book);
                    break;
                case '2': // Add a new Article.
                    Article article = createArticleEntry(kbd);
                    references.addReference(article);
                    break;
                case '3': // Print everything.
                    references.printAllBibtexEntries();
                    break;
            }
        } while (entry!='0');

    }

    /**
     * Displays main menu to the console.
     */
    public static void printPrompt() {
        System.out.println("Enter 0 to exit the program.");
        System.out.println("Enter 1 to enter a new book into the reference set.");
        System.out.println("Enter 2 to enter a new article into the reference set.");
        System.out.println("Enter 3 to printout the entries in Bibtex format.");
    }

    /**
     * This method will allow the user to enter the information for the book.
     * @param kbd This is the keyboard.
     * @return A book will be returned.
     */
    public static Book createBookEntry(Scanner kbd) {
        System.out.println("Enter the author of the book");
        String author = kbd.nextLine();

        System.out.println("Enter the title of the book");
        String title = kbd.nextLine();

        System.out.println("Enter the publisher for the book.");
        String publisher = kbd.nextLine();

        int copyright = vetInput("Enter the copyright year for the book.");


        return new Book(author, title, copyright, publisher);
    }

    /**
     * This method will allow the user to enter the information for an article.
     * @param kbd This is the keyboard.
     * @return An article will be returned.
     */
    public static Article createArticleEntry(Scanner kbd) {
        System.out.println("Enter the author of the article");
        String author = kbd.nextLine();

        System.out.println("Enter the title of the article");
        String title = kbd.nextLine();

        System.out.println("Enter the title of the journal.");
        String journal = kbd.nextLine();

        int start = vetInput("Enter the first page of the article.");

        int end = vetInput("Enter the last page of the article.");

        int copyright = vetInput("Enter the copyright year for the article.");

        return new Article(author, title, copyright, journal, start, end);
    }

    /**
     * tests an number input given a message, to ensure that the entered value is a number
     * @param message the message to display as a prompt
     * @return the input number
     */
    public static int vetInput(String message)
    {
        int output = 0;
        boolean valid = false;
        String input;
        Scanner in = new Scanner(System.in);
        while (!valid)
        {
            System.out.println(message);
            input = in.nextLine();
            try
            {
                output = Integer.parseInt(input);
                valid = true;
            }
            catch(NumberFormatException nfe)
            {
                System.out.println(input + " is an invalid input");
                valid = false;
            }

        }
        return output;
    }

}