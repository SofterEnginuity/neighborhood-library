package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class neighborhoodLibrary {

    public static Book[] inventory = new Book[5];  // Array to hold 5 books
//    public static ArrayList<Book> inventory = new ArrayList<>();

    public static void main(String[] args) {

        Book[] books = getBooks();
//        ArrayList<Book> books = getBooks();

        Scanner myScanner = new Scanner(System.in);
        int userSelection = 0;

        while (userSelection != 6) {
        System.out.println("What do you want to do?");
        System.out.println("1- Show all available books");
        System.out.println("2- Show books that are checked out");
        System.out.println("3- Exit the application.");
//
            userSelection = myScanner.nextInt();
            myScanner.nextLine();

            switch(userSelection){

                case 1: {
                    System.out.println("We currently have the following books available:");
                    for (Book b : books) {
                        if (!b.isCheckedOut()) {
                            System.out.println("ID: " + b.getId() + " | ISBN: " + b.getIsbn() + " | Title: " + b.getTitle());
                        }
                    }

                    System.out.print("Please enter the ID of the book you'd like to check out, or 0 to return to the main menu: ");
                    int bookSelection = myScanner.nextInt();
                    myScanner.nextLine();

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
                        System.out.println("What would you like to do with this book?");
                        System.out.println("C - Checkout");
                        System.out.println("X - Exit and return to the main menu.");
                        String readyToCheckout = myScanner.nextLine();

                        if (readyToCheckout.equalsIgnoreCase("c")) {
                            System.out.print("Please enter your name to check out the book: ");
                            String name = myScanner.nextLine();
                            selectedBook.setCheckedOutTo(name);
                            selectedBook.setCheckedOut(true);
                            System.out.println(name + ", you have successfully checked out \"" + selectedBook.getTitle() + "\". Enjoy!");
                        } else {
                            System.out.println("Returning to main menu...");
                        }
                    } else {
                        System.out.println("Invalid selection or book already checked out.");
                    }
                    break;
                }


//                    System.exit(0);




                case 2: {
                    Book selectedBook = null; // Now scoped ONLY to case 2
                    boolean hasCheckedOutBooks = false;



                    for (Book b : books) {
                        if (b.isCheckedOut()) {
                            System.out.println("We have the following books, but they are currently checked out:");
                            System.out.println("ID: " + b.getId() + " | ISBN: " + b.getIsbn() + " | Title: " + b.getTitle() + " | Checked out to: " + b.getCheckedOutTo());

                            hasCheckedOutBooks = true;
                        }
                    }

                    if (!hasCheckedOutBooks) {
                        System.out.println("No books are currently checked out.");
                        break;
                    }

                    System.out.print("Please enter the ID of the book you'd like to return, or 0 to go back: ");
                    int bookSelection = myScanner.nextInt();
                    myScanner.nextLine();

                    if (bookSelection == 0) {
                        break;
                    }


                    for (Book b : books) {
                        if (b.getId() == bookSelection && b.isCheckedOut()) {
                            selectedBook = b; // Assign the book to selectedBook
                            break;
                        }
                    }

                    if (selectedBook != null) {
                        System.out.println("What would you like to do with this book?");
                        System.out.println("C - Check it back into inventory.");
                        System.out.println("X - Exit and return to the main menu.");

                        String readyToReturn = myScanner.nextLine();

                        if (readyToReturn.equalsIgnoreCase("c")) {
                            System.out.print("Please confirm your name to return the book: ");
                            String name = myScanner.nextLine();

                            if (selectedBook.getCheckedOutTo() != null && selectedBook.getCheckedOutTo().equalsIgnoreCase(name)) {
                                selectedBook.setCheckedOut(false);
                                selectedBook.setCheckedOutTo("");
                                System.out.println("Thank you, " + name + "! \"" + selectedBook.getTitle() + "\" has been returned.");
                            } else {
                                System.out.println("That name does not match our records. Book not returned.");
                            }
                        } else {
                            System.out.println("Returning to main menu...");
                        }
                    } else {
                        System.out.println("Invalid selection or book is not currently checked out.");
                    }
                    break;
}


                case 3:
                    System.out.println("Exiting the program. See you soon!");
                    return;
                default:
                    System.out.println("Please make a valid selection.");
            }

        }
//        Scanner.close();
    }

    public static Book[] getBooks() {
        inventory[0] = new Book(1, "25468-349507", "Dune");
        inventory[1] = new Book(2, "59035-395879", "Where the sidewalk ends");
        inventory[2] = new Book(3, "94639-349865", "A Child called It");
        inventory[3] = new Book(4, "45968-304563", "Junie B Jones");
        inventory[4] = new Book(5, "20968-349583", "Of Mice and Men");
        return inventory;
    }


    private static void fullInventory(ArrayList<Book> inventory) {
        for (Book book : inventory) {
            System.out.println(book);
        }
    }
}


