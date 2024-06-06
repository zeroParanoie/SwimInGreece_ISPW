package engClasses.DAO;

import model.Booking;

import java.io.*;
import java.util.List;

public class LogWriterDAO {
    private File log;
    private final String LOG_NAME = "log.txt";

    public void updateLog(List<Booking> bookings) throws IOException {
        init();
        BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_NAME));
        writer.write("These are the tour you booked: ");
        writer.newLine();
        for(Booking booking : bookings) {
            writer.write("You booked tour: " + booking.getTourName() + " on date: " + booking.getDate());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public void init() throws IOException {
        this.log = new File(LOG_NAME);
        if(log.createNewFile()) {
            System.out.println("Log file created");
        } else {
            System.out.println("Log file already exists");
        }

        new PrintWriter(LOG_NAME).close();
    }
}
