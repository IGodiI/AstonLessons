package HomeWork.HW3_List;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyArrayList<E> implements MyList<E> {
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[10];
    }


    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, size * 2);
        }
        elementData[size++] = e;
        return true;
    }

    /*
    Метод add добавляет указанный элемент в конец этого списка.
    Проверка размера: Проверяет, достаточно ли места в массиве elementData. Если массив заполнен, увеличивает его размер вдвое с помощью Arrays.copyOf.
    Добавление элемента: Вставляет новый элемент e в позицию size массива elementData.
    Увеличение размера: Увеличивает значение size на 1, отражая добавление нового элемента.
    Возврат: Возвращает true, указывающий на успешное добавление.
     */

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew + size > elementData.length) {
            elementData = Arrays.copyOf(elementData, Math.max(size + numNew, size * 2));
        }
        System.arraycopy(elementData, index, elementData, index + numNew, size - index);
        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    /*
    Метод addAll вставляет все элементы указанной коллекции в этот список, начиная с указанной позиции.
    Проверка индекса: Проверяет, является ли index допустимым (не отрицательным и не больше size). Если нет, выбрасывает IndexOutOfBoundsException.
    Преобразование в массив: Преобразует указанную коллекцию c в массив объектов a с помощью c.toArray().
    Проверка размера: Проверяет, достаточно ли места в массиве elementData для новых элементов. Если нет, увеличивает его размер с помощью Arrays.copyOf.
    Сдвиг элементов: Сдвигает существующие элементы в массиве elementData вправо, начиная с позиции index, чтобы освободить место для новых элементов.
    Копирование новых элементов: Копирует элементы из массива a в массив elementData, начиная с позиции index.
    Обновление размера: Увеличивает значение size на количество добавленных элементов.
    Возврат: Возвращает true, если коллекция c не пуста, и false в противном случае.
     */

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elementData[index];
    }
    /*
    Метод get возвращает элемент по указанной позиции в этом списке.
    Проверка индекса: Проверяет, является ли index допустимым (не отрицательным и меньше size). Если нет, выбрасывает IndexOutOfBoundsException.
    Возврат элемента: Возвращает элемент, расположенный в массиве elementData по индексу index. Используется приведение типа (E), чтобы вернуть элемент нужного типа.
     */

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /*
    Метод set заменяет элемент по указанной позиции в этом списке на указанный элемент.
    Проверка индекса: Проверяет, является ли index допустимым (не отрицательным и меньше size). Если нет, выбрасывает IndexOutOfBoundsException.
    Сохранение старого значения: Сохраняет текущий элемент по индексу index в переменную oldValue.
    Замена элемента: Заменяет элемент в массиве elementData по индексу index на новый элемент element.
    Возврат старого значения: Возвращает сохраненное старое значение oldValue.
     */

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }
    /*
    Метод remove удаляет элемент по указанной позиции в этом списке.
    Проверка индекса: Проверяет, является ли index допустимым (не отрицательным и меньше size). Если нет, выбрасывает IndexOutOfBoundsException.
    Сохранение удаляемого значения: Сохраняет элемент, который будет удален, в переменную oldValue.
    Сдвиг элементов: Сдвигает все элементы в массиве elementData после удаляемого элемента на одну позицию влево, используя System.arraycopy.
    Уменьшение размера: Уменьшает значение size на 1, отражая удаление элемента.
    Очистка последнего элемента: Устанавливает последний элемент в массиве elementData (который теперь дублируется) в null, чтобы помочь сборщику мусора.
    Возврат удаленного значения: Возвращает сохраненное удаленное значение oldValue.
     */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}