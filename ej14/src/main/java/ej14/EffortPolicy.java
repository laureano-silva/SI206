package ej14;

import java.util.Comparator;
import java.util.List;

public class EffortPolicy implements Policy{
    public JobDescription selectNext(List<JobDescription> jobs){
        return jobs.stream()
                .max(Comparator.comparingDouble(JobDescription::getEffort))
                .orElse(null);
    }
}
