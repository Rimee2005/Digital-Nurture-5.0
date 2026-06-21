public class LibraryManagement {

    // Linear Search
    public static Book linearSearch(Book[] books, String targetTitle) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String targetTitle) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int comparison =
                    books[mid].title.compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Sorted by title for Binary Search
        Book[] books = {
            new Book(101, "Data Structures", "Mark Allen"),
            new Book(102, "Java Programming", "James Gosling"),
            new Book(103, "Operating Systems", "Galvin"),
            new Book(104, "Python Basics", "Guido Van Rossum"),
            new Book(105, "Web Development", "John Smith")
        };

        String searchTitle = "Python Basics";

        System.out.println("Linear Search Result:");

        Book linearResult = linearSearch(books, searchTitle);

        if (linearResult != null) {
            System.out.println(linearResult);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nBinary Search Result:");

        Book binaryResult = binarySearch(books, searchTitle);

        if (binaryResult != null) {
            System.out.println(binaryResult);
        } else {
            System.out.println("Book not found.");
        }
    }
}