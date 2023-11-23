import org.example.Book;
import org.example.BookRepository;
import org.example.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    private BookService bookService;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository);

        book1 = new Book("1", "Book 1","Tom");
        book2 = new Book("2", "Book 2","Samanta");
        book3 = new Book("3", "Book 3","Igor");
    }

    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findBookById() {
        when(bookRepository.findById("1")).thenReturn(book1);
        Book result = bookService.findBookById("1");
        assertEquals(book1, result);
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    void findAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2, book3));

        List<Book> actualBooks = bookService.findAllBooks();

        assertEquals(3, actualBooks.size());
        assertEquals("Book 1", actualBooks.get(0).getTitle());
        assertEquals("Tom", actualBooks.get(0).getAuthor());
        assertEquals("Book 3", actualBooks.get(2).getTitle());
        assertEquals("Igor", actualBooks.get(2).getAuthor());

        verify(bookRepository, times(1)).findAll();
    }
}