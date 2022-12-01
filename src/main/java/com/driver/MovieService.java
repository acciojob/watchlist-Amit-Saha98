package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
//1
    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
//2
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
//3
    public void createMovieDirectorPair(String movie,String director){
        movieRepository.saveMovieDirector(movie,director);
    }
//4
    public Movie findMovie(String mName) {
        return movieRepository.findMovie(mName);
    }
//5
    public Director findDirector(String dName){
        return movieRepository.findDirector(dName);
    }
//6
    public List<String>findMoviesFromDirector(String director){
        return movieRepository.findMovieFromDirector(director);
    }
//7
    public List<String>findAllMovies(){
        return movieRepository.findAllMovies();
    }
//8
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
//9
    public void deleteAllDirector(){
        movieRepository.deleteAllDirector();
    }
}
