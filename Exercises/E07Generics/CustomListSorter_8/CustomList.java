package Exercises.E07Generics.CustomListSorter_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);

    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {

        T firstIndexElement = this.elements.get(firstIndex);
        T secondIndexElement = this.elements.get(secondIndex);

        this.elements.set(firstIndex, secondIndexElement);
        this.elements.set(secondIndex, firstIndexElement);

    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T elementInList : this.elements) {

            if (elementInList.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return this.elements.stream().max(Comparator.naturalOrder()).get();

    }

    public T getMin() {

        return this.elements.stream().min((e1, e2) -> e1.compareTo(e2)).get();
    }

    public void print() {
        for (T element : this.elements) {
            System.out.println(element);
        }
    }

    public void sort() {
        this.elements.sort((e1, e2) -> e1.compareTo(e2));

    }
}
