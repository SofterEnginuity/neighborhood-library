package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class neighborhoodLibrary {

    public static ArrayList<Book> inventory = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Book> books = getBooks();

        Scanner myScanner = new Scanner(System.in);
        int userSelection = 0;

        while (userSelection != 6) {
        System.out.println("What do you want to do?");
        System.out.println("1- List all books");
        System.out.println("2- Search by Title");
        System.out.println("3- Search by Author");
        System.out.println("4- Show all books on hand");
        System.out.println("5- Return a book");
        System.out.println("6- Exit the application.");
//
            userSelection = myScanner.nextInt();
            myScanner.nextLine();

            switch(userSelection){
                case 1:
                    System.out.println("We have the following books at our library:");
                    for (Book b : books) {
                        System.out.println("ID: " + b.getId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor());
                    }
                    System.exit(0);

                case 2:
                    System.out.println("Please enter the title of the book you'd like to search for.");
                    String userTitle = myScanner.nextLine();
                    boolean titleFound = false;
                    for (Book b : books) {
                        if (b.getTitle().equalsIgnoreCase(userTitle)) {
                            System.out.println("We do have " + b.getTitle() + " in our library.");
                            titleFound = true;
                            break;  // Exit loop after finding the book
                        }
                    }if(!titleFound){
                            System.out.println("We do not have " + userTitle + " in our inventory at this time.");
                    }
                    System.exit(0);


                case 3:
                    System.out.println("Please enter the author of the book you'd like to search for.");
                    String userAuthor = myScanner.nextLine();
                    boolean authorFound = false;
                    for (Book b : books) {
                        if (b.getAuthor().equalsIgnoreCase(userAuthor)) {
                            System.out.println("We do have at least 1 book by " + b.getAuthor() + " in our library.");
                            authorFound = true;
                            break;  // Exit loop after finding the book
                        }
                    }if(!authorFound){
                    System.out.println("We do not have a book written by " + userAuthor + " in our inventory at this time.");
                }
                    System.exit(0);

                case 4:
                    System.out.println("Here is a list of all books that we have on hand currently:");
                    boolean available = false;

                    for (Book b : books) {
                        if (!b.isCheckedOut()) {
                            System.out.println("ID: " + b.getId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor());
                            available = true;
                        }
                    }

                    if (!available) {
                        System.out.println("No books are currently available.");
                        break;
                    }

                    System.out.println();
                    System.out.print("Please enter the ID of the book you'd like to check out, or 0 to return to the main menu: ");
                    int bookSelection = myScanner.nextInt();
                    myScanner.nextLine(); // Consume leftover newline

                    if (bookSelection == 0) {
                        break;
                    }

                    Book selectedBook = null;
                    for (Book b : books) {
                        if (b.getId() == bookSelection && !b.isCheckedOut()) {
                            selectedBook = b;
                            break;
                        }
                    }

                    if (selectedBook != null) {
                        myScanner.nextLine();
                        System.out.print("Please enter your name to check out the book: ");
                        String userName = myScanner.nextLine();
                        selectedBook.setCheckedOut(true);
                        selectedBook.setCheckedOutTo(userName);
                        System.out.println(userName + ", you have successfully checked out \"" + selectedBook.getTitle() + "\". Enjoy!");
                    } else {
                        System.out.println("Invalid selection or book already checked out.");
                    }

                    break;


                case 5:
                    System.out.println("Please enter your name to return a book.");
                    String userNameReturn = myScanner.nextLine();


                    boolean hasBooks = false;
                    for (Book b : books) {
                        if (b.isCheckedOut() && b.getCheckedOutTo().equalsIgnoreCase(userNameReturn)) {
                            System.out.println("ID: " + b.getId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor());
                            hasBooks = true;
                        }
                    }

                    if (!hasBooks) {
                        System.out.println("No books are currently checked out under the name \"" + userNameReturn + "\".");
                        break;
                    }

                    System.out.print("Please enter the ID of the book you'd like to return: ");
                    int returnBookId = myScanner.nextInt();
                    myScanner.nextLine(); // consume newline

                    boolean foundAndReturned = false;

                    for (Book b : books) {
                        if (b.getId() == returnBookId && b.isCheckedOut() && b.getCheckedOutTo().equalsIgnoreCase(userNameReturn)) {
                            b.setCheckedOut(false);
                            b.setCheckedOutTo(""); // Clear the name
                            System.out.println("Thank you, \"" + b.getTitle() + "\" has been successfully returned!");
                            foundAndReturned = true;
                            break;
                        }
                    }

                    if (!foundAndReturned) {
                        System.out.println("Sorry, we couldn’t find a book with that ID checked out under your name.");
                    }

                case 6:
                    System.out.println("Exiting the program. See you soon!");
                    return;
                default:
                    System.out.println("Please make a valid selection.");
            }



        }
//        Scanner.close();
    }

    // Define getBooks OUTSIDE of main()
    public static ArrayList<Book> getBooks() {
        inventory.add(new Book(1, "Dune", "Frank Herbert", false, ""));
        inventory.add(new Book(2, "Where the sidewalk ends", "Shell Silverstein", true, "Alice"));
        inventory.add(new Book(3, "A Child called It", "Dave Pelzer", false, "Alice"));
        inventory.add(new Book(4, "Junie B Jones", "Barbara Park", true, "Alice"));
        inventory.add(new Book(5, "Of Mice and Men", "John Steinbeck", false, "Alice"));
        return inventory;
    }

    private static void fullInventory(ArrayList<Book> inventory) {
        for (Book book : inventory) {
            System.out.println(book);
        }
    }
}