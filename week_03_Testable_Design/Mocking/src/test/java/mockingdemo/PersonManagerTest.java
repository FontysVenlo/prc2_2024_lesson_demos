package mockingdemo;

import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Captor;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author hvd
 */
@ExtendWith(MockitoExtension.class)
public class PersonManagerTest {

    Person frank = new Person("Frank", "Venlo", "Frank@fontys.nl");
    Person martijn = new Person("Martijn", "Horst", "Martijn@fontys.nl");
    Person ibrahim = new Person("Ibrahim", "Venlo", "Ibrahim@gmail.com");
    Person richard = new Person("Richard", "Venlo", "Richard@fontys.nl");

    PersonManager pm;
   
    @Mock
    DatabaseService fakeDbs;
    
    @Mock
    EmailService fakeEms;
    
    @Captor
    ArgumentCaptor<String> emailCaptor;
    
//    DatabaseService fakeDbs = () -> List.of(frank, martijn, ibrahim, richard);
//    EmailService fakeEms = (address, message) -> System.out.println("Fake email service");
    
//    DatabaseService fakeDbs = new DatabaseService() {
//        @Override
//        public List<Person> getPersons() {
//            return List.of(frank, martijn, ibrahim, richard);
//        }
//    };

    @BeforeEach
    public void initialize() {
        pm = new PersonManager(fakeDbs, fakeEms);  // Arrange
    }

    @Test
    public void testGetAllPersons() {

        // Train the mock
        when(fakeDbs.getPersons()).thenReturn( List.of(frank, martijn, ibrahim, richard));
        
        List<Person> actual = pm.getAllPersons();  // Act
        
        verify(fakeDbs, times(1)).getPersons();
        
        assertThat(actual).as("Should be all").containsExactlyInAnyOrder(frank, martijn, ibrahim, richard);  // Assert
        

    }

    @Test
    public void testGet() {
        Predicate<Person> predicate = p -> p.homeTown().equals("Venlo");
        List<Person> actual = pm.get(predicate);
        assertThat(actual).as("Should be Frank, Ibrahim and Richard").containsExactlyInAnyOrder(frank, ibrahim, richard);
    }

    @Test
    public void testSendEmailToFontysStudents() {
        
        // Train the mock
        when(fakeDbs.getPersons()).thenReturn( List.of(frank, martijn, ibrahim, richard));

        Predicate<Person> predicate = p -> p.emailAddres().endsWith("fontys.nl");

        assertThatCode(() -> {
            pm.sendEmailTo(predicate, "Hello Fontys");
        }).doesNotThrowAnyException();
        
        verify(fakeEms, times(3)).sendEmail(emailCaptor.capture(), anyString());
        
        var results = emailCaptor.getAllValues();
        
        assertThat(results).containsExactlyInAnyOrder(frank.emailAddres(), martijn.emailAddres(), richard.emailAddres());

    }
}
