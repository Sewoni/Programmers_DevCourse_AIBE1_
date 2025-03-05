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
    static List<Repo> repos;;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();

        try {
            repos = reader.read("class_practice/backend/src/Pt2_day10/model/dto/TIL.java");
            logger.info(repos.toString());
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }

        TILService service = new TILServiceImpl();
        // 유저별-TIL csv를 만들 것
//        for (Repo repo : repos) {
//            List<TIL> tils = service.getTIL(repo);
//            logger.info(tils.toString());
//            // 파일로 나올 예정
//        }
        repos.stream().map(service::getTIL).map(Object::toString).forEach(logger::info);
    }
}