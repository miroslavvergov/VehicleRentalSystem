package miro.task.utils.collectors;

/**
 * Interface for data collectors.
 *
 * @param <T> the type of data collected by the implementing class
 */
public interface DataCollector<T> {

    /**
     * Collects and returns data of type T.
     *
     * @return the collected data
     */
    T collect();
}
