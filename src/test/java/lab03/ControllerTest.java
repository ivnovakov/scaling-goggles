package lab03;

import lab03.model.Date;
import lab03.model.DateStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ControllerTest {

    private View view;
    private DateStorage dateStorage;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);

        view = Mockito.mock(View.class);
        dateStorage = Mockito.mock(DateStorage.class);
    }

    @Test
    void testAddComputer() {
        Controller controller = new Controller(view, dateStorage);
        Mockito.when(view.requestAction()).thenReturn(1, 4);
        Mockito.when(view.requestProperty("Year")).thenReturn("1999");
        Mockito.when(view.requestProperty("Month")).thenReturn("6");
        Mockito.when(view.requestProperty("Day")).thenReturn("3");

        controller.run();

        Date date = new Date();
        date.setYear(1999);
        date.setMonth(6);
        date.setDay(3);

        Mockito.verify(dateStorage).add(date);
    }

    @Test
    void testRemoveComputer() {
        Controller controller = new Controller(view, dateStorage);
        Mockito.when(dateStorage.size()).thenReturn(5, 5);
        Mockito.when(view.requestIndex()).thenReturn(1, 7);
        Mockito.when(view.requestAction()).thenReturn(2, 2, 4);

        controller.run();

        Mockito.verify(dateStorage).remove(1);
        Mockito.verify(view).showMessage("Invalid index!");
    }

    @Test
    void testListComputers() {
        List<Date> computers = new ArrayList<>();

        Controller controller = new Controller(view, dateStorage);
        Mockito.when(view.requestAction()).thenReturn(3, 4);
        Mockito.when(dateStorage.fetchList()).thenReturn(computers);

        controller.run();

        Mockito.verify(dateStorage).fetchList();
        Mockito.verify(view).showList(computers);
    }

}
