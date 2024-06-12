package engClasses.DAO;

import engClasses.pattern.Facade;
import model.Booking;
import model.Swimmer;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LogWriterDAOTest {

    private String LOG_NAME = "log.txt";

    @Test
    void updateLog() {
        int startFlag = 0;
        int checkFlag = 0;
        String buffer;
        LogWriterDAO logWriterDAO = new LogWriterDAO();

        Swimmer swimmer = Facade.getInstance().getSwimmerFromFacade("Sw1");
        List<Booking> bookings = new ArrayList<Booking>(swimmer.getBookedTours());

        try {
            logWriterDAO.updateLog(bookings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(LOG_NAME));
            buffer = reader.readLine();
            if(!buffer.equals("These are the tour you booked: ")) {
                startFlag = 1;
            }

            int i = 0;
            buffer = reader.readLine();
            while(buffer != null) {
                if(!buffer.contains(bookings.get(i).getTourName())) {
                    checkFlag = 1;
                }
                buffer = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        assertEquals(0, startFlag + checkFlag);
    }
}