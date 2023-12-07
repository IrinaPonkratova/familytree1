package ru.gb.family_tree.FamilyTree;

import ru.gb.family_tree.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> familytree;
    private long humansId;


    public FamilyTree(List<E> familytree) {
        this.familytree = familytree;
    }


    public FamilyTree() {
        this(new ArrayList<E>());
    }

    public boolean addRalative(E human){
        if (!familytree.contains(human)){
            familytree.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public void addToParents(E human) {
        for (E parent: human.getParents()) {
            parent.addChildren(human);
        }
    }

    public void addToChildren(E human) {
        for (E children: human.getChildren()) {
            children.addParents(human);
        }
    }



    public List<E> getByName(String name) {
        List <E> rez = new ArrayList<E>();
        for(E human : familytree) {
            if(human.getName().equals(name)) {
                rez.add(human);
            }
        }
        return rez;
    }
    private boolean checkId(long id){
        return id < humansId && id >= 0;

    }

    public E getById(long id) {
        for(E human : familytree) {
            if(human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди в дереве: \n");
        for(E human: familytree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setWedding(Human human1, Human human2) {
        if  (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    public void sortByName() {
        familytree.sort(new FamilyTreeComparatorByName());
    }
    public void sortByAge() {
        familytree.sort(new FamilyTreeComparatorByAge<>());
    }

    public void sortByGenger() {
        familytree.sort(new FamilyTreeComparatorByGender<>());
    }


    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familytree);
    }
}
