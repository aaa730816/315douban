package main.util;

import main.entities.Film;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Tony on 2017/7/3.
 */
public class CountFilmTypeTask extends RecursiveTask<Set<String>> {
    private static final int THRESHOLD=2;
    private List<Film> films;
    private int start,end;
    public CountFilmTypeTask(List<Film> films,int start,int end){
        this.films=films;
        this.start=start;
        this.end=end;
    }
    protected Set<String> compute() {
        Set<String> types=new HashSet<>();
        int filmSize=end-start;
        if (filmSize<=THRESHOLD)
        {
            for (int i=start;i<end;i++){
                String[] typeArr=films.get(i).getFilmType().replace(" ","").split("/");
                for (int j=0;j<typeArr.length;j++){
                    types.add(typeArr[j]);
                }
            }
            return types;
        }
        else {
            int middle=(end+start)/2;
            CountFilmTypeTask leftTask=new CountFilmTypeTask(films,start,middle);
            CountFilmTypeTask rightTask=new CountFilmTypeTask(films,middle,end);
            leftTask.fork();
            rightTask.fork();
            Set<String> leftResult=leftTask.join();
            Set<String> rightResult=rightTask.join();
            types.addAll(leftResult);
            types.addAll(rightResult);
            return types;
        }
    }
}
