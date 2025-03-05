package Pt2_day10;

import Pt2_day10.model.dto.Repo;
import Pt2_day10.model.dto.TIL;
import Pt2_day10.service.github.TILService;
import Pt2_day10.service.github.TILServiceImpl;
import Pt2_day10.util.file.CSVReader;
import Pt2_day10.util.file.CSVReaderImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    static List<Repo> repos;
    static List<TIL> tils;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();

        try {
            repos = reader.read("til.csv");
            logger.info(repos.toString());
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }

        TILService service = new TILServiceImpl();
        tils = service.getTIL(repos);
        logger.info(tils.toString());
    }
}