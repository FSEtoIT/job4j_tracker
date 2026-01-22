package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }

    public class FindEl {
        public static int indexOf(String[] value, String key)
                throws ElementNotFoundException {

            for (int index = 0; index < value.length; index++) {
                if (value[index].equals(key)) {
                    return index;
                }
            }
                throw new ElementNotFoundException(
                        "Element '" + key + "' not found"
                );
            }
        }

    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Stepan"};

        try {
            int index = FindEl.indexOf(names, "Andrey");
            System.out.println("Index: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}