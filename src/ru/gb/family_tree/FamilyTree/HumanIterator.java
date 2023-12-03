package ru.gb.family_tree.FamilyTree;

import ru.gb.family_tree.Human.Human;

import java.util.Iterator;
import java.util.List;
public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> familytree;



    public HumanIterator(List<Human> familytree) {
        this.familytree = familytree;
    }

    @Override
    public boolean hasNext() {
        return index < familytree.size();
    }

    @Override
    public Human next() {
        return familytree.get(index++);
    }
}
