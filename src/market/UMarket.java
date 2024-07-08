package market;

import market.food.Food;
import market.food.healthy_foods.Chicken;
import market.food.healthy_foods.Fruit;
import market.food.healthy_foods.OliveOil;
import market.food.semi_finished_foods.Cheburek;
import market.food.semi_finished_foods.DumplingBeeries;
import market.food.semi_finished_foods.DumplingMeat;
import market.food.snacks.BalykCheese;
import market.food.snacks.ChocolateBar;
import market.food.snacks.Crisps;
import market.officce.office_supplies.Notebook;
import market.officce.office_supplies.Pen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class UMarket {

    //region Поля

    // Коллекция маркета, хранилище вещей.
    private final Collection<Thing> things;

    //endregion


    //region Конструкторы

    public UMarket() {
        things = new ArrayList<>();
        initializeThings();
    }

    //endregion


    //region Методы

    /**
     * Метод заполнения коллекции маркета при создании объекта маркета.
     */
    private void initializeThings() {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingBeeries());
        things.add(new DumplingMeat());
        things.add(new Cheburek());
    }

    /**
     * Метод вывода в консоль коллекции маркета.
     * @param clazz тип товара
     * @param <T> наследники интерфейса Thing
     */
    public <T extends Thing>void printThings(Class<T> clazz) {
        AtomicInteger index = new AtomicInteger(1);
        // в цикле foreach

//        for (var thing:things) {
//            if (clazz.isInstance(thing)) {
//                if (Food.class.isAssignableFrom(thing.getClass())) {
//                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, thing.getName(),
//                            ((Food)thing).getProteins() ? "Да" : "Нет",
//                            ((Food)thing).getFats() ? "Да" : "Нет",
//                            ((Food)thing).getCarbohydrates() ? "Да" : "Нет");
//                } else {
//                    System.out.printf("[%d] %s\n", index++, thing.getName());
//                }
//            }
//        }

        // с помощью stream api
        things.stream().filter(clazz::isInstance)
                .forEach(thing -> {
                    if (Food.class.isAssignableFrom(thing.getClass())) {
                        System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index.getAndIncrement(), thing.getName(),
                                ((Food)thing).getProteins() ? "Да" : "Нет",
                                ((Food)thing).getFats() ? "Да" : "Нет",
                                ((Food)thing).getCarbohydrates() ? "Да" : "Нет");
                    } else {
                        System.out.printf("[%d] %s\n", index.getAndIncrement(), thing.getName());
                    }
                });
    }

    /**
     * Метод получения элемента коллекции маркета по индексу.
     * @param clazz тип товара
     * @param index
     * @return
     * @param <T> наследники интерфейса Thing
     */
    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {

        // в цикле foreach
//        int counter = 1;
//        for (var thing:things) {
//            if (clazz.isAssignableFrom(thing.getClass())) {
//                if (index == counter++) {
//                    return (T)thing;
//                }
//            }
//        }
//        return null;

        // с помощью stream api
        int[] counter = {1};
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == counter[0]++)
                .map(thing -> clazz.cast(thing))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод получения коллекции маркета.
     * @param clazz тип товара
     * @return
     * @param <T> наследники интерфейса Thing
     */
    public  <T extends Thing> Collection<T> getThings(Class<T> clazz) {

        // в цикле foreach
//        Collection<T> list = new ArrayList<>();
//        for (var thing:things) {
//            if (clazz.isAssignableFrom(thing.getClass())) {
//                list.add((T) thing);
//            }
//        }
//        return list;

        // с помощью stream api
        return things.stream()
                .filter(thing -> clazz.isInstance(thing))
                .map(thing -> clazz.cast(thing))
                .toList();
    }

    //endregion
}
