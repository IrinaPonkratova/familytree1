package ru.gb.family_tree.FamilyTree;

import ru.gb.family_tree.FamilyTree.TreeItem;

import java.util.Comparator;

public class FamilyTreeComparatorByGender<E extends TreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}