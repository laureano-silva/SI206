package ej14;
import java.util.List;

public class FIFOPolicy implements Policy{
    public JobDescription selectNext(List<JobDescription> jobs){
        return jobs.get(0);
    }
}
