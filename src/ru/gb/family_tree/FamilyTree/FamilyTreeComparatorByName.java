package ru.gb.family_tree.FamilyTree;

import ru.gb.family_tree.FamilyTree.TreeItem;

import java.util.Comparator;

public class FamilyTreeComparatorByName<E extends TreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
