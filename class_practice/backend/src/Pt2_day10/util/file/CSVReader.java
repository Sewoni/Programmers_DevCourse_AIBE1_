package Pt2_day10.util.file;

import Pt2_day10.model.dto.Repo;

import java.io.FileNotFoundException;
import java.util.List;

public interface CSVReader {
    List<Repo> read(String path) throws FileNotFoundException;
}
