package ej25;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {

    private Map<T, Integer> elements;

    public BagImpl() {
        this.elements = new HashMap<>();
    }

    @Override
    public boolean add(T element) {
        // elements.merge(element, 1, Integer::sum);
        elements.put(element, elements.get(element) == null ? 1 : elements.get(element) + 1 );
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        return elements.getOrDefault(element, 0);
    }

    @Override
    public void removeOccurrence(T element) {
        // elements.computeIfPresent(element, (k, v) -> v > 1 ? v - 1 : null);
        int occurrences = elements.getOrDefault(element, 0);
        if (occurrences == 0){
            return;
        }
        if (occurrences == 1){
            elements.remove(element);
            return;
        }
        elements.put(element, occurrences-1);
    }

    @Override
    public void removeAll(T element) {
        elements.remove(element);
    }

    @Override
    public int size() {
       return elements.values().stream()
               .mapToInt(Integer::intValue)
               .sum();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
