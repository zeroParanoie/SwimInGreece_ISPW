package engClasses.DAO;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import engClasses.exceptions.DupSwimmerException;
import engClasses.exceptions.WrongCredsException;
import model.Swimmer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVSwimmerDAO {

    private File file;
    private String CSV_FILE_NAME = "swimmers.csv";

    public CSVSwimmerDAO() throws IOException {
        this.file = new File(CSV_FILE_NAME);

        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public static void addSwimmer(Swimmer swimmer, String pw, File fd) throws DupSwimmerException, CsvValidationException, IOException, WrongCredsException {
        boolean duplicateRecord = false;
        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(fd, true)));
        String[] record = new String[3];

        duplicateRecord = (selectSwimmer(swimmer.getUsername(), fd) != null);
        if(!duplicateRecord) {
            record[0] = swimmer.getUsername();
            record[1] = pw;
            record[2] = swimmer.getFullName();

            csvWriter.writeNext(record);
            csvWriter.flush();
            csvWriter.close();
        }

    }

    public static synchronized Swimmer selectSwimmer(String usr, String pw, File fd) throws IOException, CsvValidationException, WrongCredsException, DupSwimmerException {
        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));
        String[] record;

        List<Swimmer> swimmers = new ArrayList<Swimmer>();

        while((record = csvReader.readNext()) != null) {
            if(record[0].equals(usr) && record[1].equals(pw)) {
                String fullname = record[2];
                Swimmer swimmer = new Swimmer(usr, fullname);
                swimmers.add(swimmer);
            }
        }

        if(swimmers.isEmpty()) {
            throw new WrongCredsException("credentials are wrong!");
        } else if(swimmers.size() > 1) {
            throw new DupSwimmerException("Found duplicate in csv file!");
        }

        csvReader.close();
        return swimmers.get(0);
    }

    public static Swimmer selectSwimmer(String usr, File fd) throws IOException, CsvValidationException, WrongCredsException, DupSwimmerException {
        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));
        String[] record;

        List<Swimmer> swimmers = new ArrayList<Swimmer>();

        while((record = csvReader.readNext()) != null) {
            if(record[0].equals(usr)) {
                String fullname = record[2];
                Swimmer swimmer = new Swimmer(usr, fullname);
                swimmers.add(swimmer);
            }
        }

        if(swimmers.isEmpty()) {
            throw new WrongCredsException("credentials are wrong!");
        } else if(swimmers.size() > 1) {
            throw new DupSwimmerException("Found duplicate in csv file!");
        }

        csvReader.close();
        return swimmers.get(0);
    }
}
