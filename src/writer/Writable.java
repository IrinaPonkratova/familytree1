package ru.gb.family_tree.writer;

import ru.gb.family_tree.Human;


import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String path);

    Object read(String path);
}