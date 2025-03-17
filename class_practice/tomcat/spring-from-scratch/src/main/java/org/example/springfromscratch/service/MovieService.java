package org.example.springfromscratch.service;

import org.example.springfromscratch.model.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}