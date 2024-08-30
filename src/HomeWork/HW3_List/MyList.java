package HomeWork.HW3_List;

import java.util.Collection;

public interface MyList<E> {
    boolean add(E e);
    boolean addAll(int index, Collection<? extends E> c);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    int size();
}