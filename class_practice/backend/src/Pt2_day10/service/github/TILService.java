package Pt2_day10.service.github;

import Pt2_day10.model.dto.Repo;
import Pt2_day10.model.dto.TIL;

import java.util.List;

public interface TILService {
    List<TIL> getTIL(List<Repo> repo) ;
}