package org.example.springfromscratch.model.repository;

import org.example.springfromscratch.model.dto.MovieDTO;
import org.example.springfromscratch.model.dto.MovieParam;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    final String url="https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

    public MovieDTO getMovie(MovieParam param) {
        return new MovieDTO();
    }
}

