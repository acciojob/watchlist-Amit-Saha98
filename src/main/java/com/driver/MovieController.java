package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    //1
    @PostMapping("/add-movie")
    public ResponseEntity<String>addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Added", HttpStatus.CREATED);
    }
    //2
    @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director Added",HttpStatus.CREATED);
    }
    //3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("pair created",HttpStatus.CREATED);
    }
    //4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable String name){
        Movie movie = movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable String name){
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }
    //6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String>movies = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    //7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>findAllMovies(){
        List<String>movies= movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    //8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director+"Removed",HttpStatus.CREATED);
    }
    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>deleteAllDirector(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All Directors Removed",HttpStatus.CREATED);
    }
}
