package ru.gb.family_tree.Main;

import ru.gb.family_tree.FamilyTree.FamilyTree;
import ru.gb.family_tree.Human.Gender;
import ru.gb.family_tree.Human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FamilyTree familytree = makeFamilyTree();
        System.out.println(familytree);
        save(familytree);
/*
        FamilyTree familytree = load();
        System.out.print(familytree);

 */
        familytree.sortByName();
        System.out.println(familytree);

        familytree.sortByAge();
        System.out.println(familytree);

        familytree.sortByGenger();
        System.out.println(familytree);



    }

    public static void save(FamilyTree familyTree) {
        String path = "test.txt";
        ru.gb.family_tree.writer.FileHandler fileHandler = new ru.gb.family_tree.writer.FileHandler();
        fileHandler.save(familyTree, path);

    }

    public  static FamilyTree load() {
        String path = "test.txt";
        ru.gb.family_tree.writer.FileHandler fileHandler = new ru.gb.family_tree.writer.FileHandler();
        return (FamilyTree) fileHandler.read(path);
    }

    public static FamilyTree makeFamilyTree() {
        FamilyTree familytree = new FamilyTree();
        Human Maria = new Human("Maria", Gender.Female, LocalDate.of(1950, 7, 24));
        Human Ivan = new Human("Ivan", Gender.Male, LocalDate.of(1952, 2, 24));
        Human Galina = new Human("Galina", Gender.Female, LocalDate.of(1943, 6, 17));
        familytree.addRalative(Maria);
        familytree.addRalative(Ivan);
        familytree.addRalative(Galina);
        Maria.setSpouse(Ivan);
        Ivan.setSpouse(Maria);

        Human Marina = new Human("Marina", Gender.Female, LocalDate.of(1974, 11, 13), Galina, null);
        Human Anatoly = new Human("Anatoly", Gender.Male, LocalDate.of(1977, 12, 3), Maria, Ivan);
        familytree.addRalative(Marina);
        familytree.addRalative(Anatoly);
        Marina.setSpouse(Anatoly);
        Anatoly.setSpouse(Marina);
        Maria.addChildren(Anatoly);
        Human Nastya = new Human("Nastya", Gender.Female, LocalDate.of(1999, 4,10), Marina, Anatoly);

        familytree.addRalative(Nastya);
        return familytree;

    }



}