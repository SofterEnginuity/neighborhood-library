package com.pluralsight;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String title, String author, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }



    public void setCheckedOut(boolean checkedOut) {

        this.isCheckedOut = checkedOut;
    }
    public String getCheckedOutTo() {
        return checkedOutTo;
    }
    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
//    public static void getInventory(){
//
//    }

    @Override
    public String toString() {
        return "Product{" +
//                "id=" + id +
                ", Title:'" + title + '\'' +
                ", Author:" + author + '\'' +
                ", checkedOut:" + isCheckedOut + '\'' +
                ", Checked out to: '" + checkedOutTo + '\'' +
//                ", Expected return date:" + returnDate + '\'' +
                '}';
    }
}
