package ua.university;

public class Library {
    private String name;

    public Library (String name){
        this.name = name;
    }

    public class Book {
        private String title;
        private String author;

        public Book (String title, String author){
            this.title = title;
            this.author = author;
        }

        public void bookLabel(){
            System.out.println("Author: " + author
            + "Title: " + title
            + "Library: " + name);
        }
    }
}
