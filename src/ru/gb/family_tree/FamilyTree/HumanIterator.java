package ru.gb.family_tree.FamilyTree;

import ru.gb.family_tree.Human.Human;

import java.util.Iterator;
import java.util.List;
public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> familytree;



    public HumanIterator(List<E> familytree) {
        this.familytree = familytree;
    }

    @Override
    public boolean hasNext() {
        return index < familytree.size();
    }

    @Override
    public E next() {
        return familytree.get(index++);
    }
}
