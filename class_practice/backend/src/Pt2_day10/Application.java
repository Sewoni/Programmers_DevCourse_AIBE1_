package Pt2_day10;

import Pt2_day10.model.dto.Repo;
import Pt2_day10.util.file.CSVReader;
import Pt2_day10.util.file.CSVReaderImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();
        try {
            List<Repo> repos = reader.read("class_practice/backend/src/Pt2_day10/  til.csv");
            logger.info(repos.toString());
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }
    }
}
