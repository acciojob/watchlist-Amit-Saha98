package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap <String,Movie>movieMap;
    private HashMap<String,Director>directorMap;
    private HashMap<String, List<String>>directorMovieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<String,Movie>();
        this.directorMap = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }
//1
    public void saveMovie(Movie movie){
        this.movieMap.put(movie.getName(),movie);
    }
//2
    public void saveDirector(Director director){
        this.directorMap.put(director.getName(),director);
    }
//3
    public void saveMovieDirector (String movie,String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie,movieMap.get(movie));
            directorMap.put(director,directorMap.get(director));
            List<String>currMovie = new ArrayList<>();
            if(directorMovieMap.containsKey(director))currMovie=directorMovieMap.get(director);
            currMovie.add(movie);
            directorMovieMap.put(director,currMovie);
        }
    }
//4
    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }
//5
    public Director findDirector(String director){
        return directorMap.get(director);
    }
//6
    public List<String>findMovieFromDirector(String director){
        List<String>movieList=new ArrayList<>();
        if(directorMovieMap.containsKey(director))movieList=directorMovieMap.get(director);
        return movieList;
    }
//7
    public List<String>findAllMovies(){
        return  new ArrayList<>(movieMap.keySet());
    }
//8
    public void deleteDirector(String director){
        List<String>movies = new ArrayList<>();
        if(directorMovieMap.containsKey(director)){
            movies=directorMovieMap.get(director);
            for(String mov : movies){
                if (movieMap.containsKey(mov)){
                    movieMap.remove(mov);
                }
            }
        }
        if (directorMap.containsKey(director))directorMap.remove(director);
    }
//9
    public void deleteAllDirector(){
        HashSet<String>movset = new HashSet<>();

        for (String dir : directorMovieMap.keySet()){
            for(String mov:directorMovieMap.get(dir)){
                movset.add(mov);
            }
        }
        for (String mov : movset){
            if(movieMap.containsKey(mov)){
                movieMap.remove(mov);
            }
        }
    }


}
