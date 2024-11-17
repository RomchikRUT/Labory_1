package Labory_1;

/**
 * Класс для представления узла связанного списка.
 */
class Node {
    Object data; // Данные, хранящиеся в узле
    Node next;   // Ссылка на следующий узел

    /**
     * Конструктор для создания узла с заданными данными.
     *
     * @param data Данные, которые будут храниться в узле.
     */
    Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Класс контейнера, представляющий собой связанный список.
 */
public class Container {
    private Node head; // Голова связанного списка
    private int size;  // Размер контейнера

    /**
     * Конструктор для инициализации пустого контейнера.
     */
    public Container() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Метод для добавления элемента в контейнер.
     *
     * @param item Элемент, который нужно добавить в контейнер.
     */
    public void add(Object item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode; // Если список пуст, новый узел становится головой
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Переход к последнему узлу
            }
            current.next = newNode; // Добавление нового узла в конец списка
        }
        size++;
    }

    /**
     * Метод для извлечения элемента по индексу.
     *
     * @param index Индекс элемента, который нужно извлечь.
     * @return Данные узла по указанному индексу.
     * @throws IndexOutOfBoundsException Если индекс вне диапазона.
     */
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Переход к нужному узлу
        }
        return current.data; // Возвращаем данные узла
    }

    /**
     * Метод для удаления элемента по индексу.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс вне диапазона.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }

        if (index == 0) {
            head = head.next; // Удаление головы списка
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Переход к узлу перед удаляемым
            }
            current.next = current.next.next; // Удаление узла
        }
        size--;
    }

    /**
     * Метод для получения размера контейнера.
     *
     * @return Размер контейнера.
     */
    public int size() {
        return size;
    }

    /**
     * Пример использования контейнера.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        Container container = new Container();

        container.add("Первый элемент");
        container.add("Второй элемент");
        container.add(3);
        container.add("Четвёртый элемент");
        container.add("Пятый элемент");
        container.add(6);

        System.out.println("Размер контейнера: " + container.size());

        for (int i = 0; i < container.size(); i++) {
            System.out.println("Элемент " + i + ": " + container.get(i));
        }

        container.remove(1); // Удаляем второй элемент

        System.out.println("Размер контейнера после удаления: " + container.size());

        for (int i = 0; i < container.size(); i++) {
            System.out.println("Элемент " + i + ": " + container.get(i));
        }
    }
}
