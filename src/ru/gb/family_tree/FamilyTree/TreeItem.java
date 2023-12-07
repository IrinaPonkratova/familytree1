package ru.gb.family_tree.FamilyTree;

import ru.gb.family_tree.Human.Gender;

import java.io.Serializable;
import java.util.List;

public interface TreeItem<E> extends Serializable {
    String getName();
    int getAge();
    Gender getGender();
    long getId();
    E getFather();
    E getMother();

    void setId(long id);

    List<E> getChildren();

    List<E> getParents();

    void addChildren(E obj);

    void addParents(E obj);
    E getSpouse();
}
