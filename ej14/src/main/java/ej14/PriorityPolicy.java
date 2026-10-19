package ej14;

import java.util.Comparator;
import java.util.List;

public class PriorityPolicy implements Policy{
    public JobDescription selectNext(List<JobDescription> jobs){
        return jobs.stream()
                .max(Comparator.comparingInt(JobDescription::getPriority))
                .orElse(null);
    }
}