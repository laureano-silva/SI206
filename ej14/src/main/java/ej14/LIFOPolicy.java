package ej14;

import java.util.List;

public class LIFOPolicy implements Policy{
    public JobDescription selectNext(List<JobDescription> jobs){
        return jobs.get(jobs.size() - 1);
    }
}
