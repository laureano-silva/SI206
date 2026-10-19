package ej14;
import java.util.List;

public interface Policy {
    public JobDescription selectNext(List<JobDescription> jobs);
}
