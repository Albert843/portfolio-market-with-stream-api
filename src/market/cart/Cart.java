package market.cart;

import market.food.Food;
import market.UMarket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Класс корзина для пищевых продуктов
 * @param <T> наследники класса Food
 */
public class Cart<T extends Food> {

    //region Поля

    private final UMarket market;
    private final ArrayList<T> foodStaffs;
    private final Class<T> clazz;

    //endregion


    //region Конструктор

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodStaffs = new ArrayList<>();
    }

    //endregion


    //region Методы

    /**
     * Метод получения коллекции
     * @return коллекцию
     */
    public Collection<T> getFoodStaffs() {
        return foodStaffs;
    }

    /**
     * Метод для вывода в консоль корзины
     */
    public void printFoodStaffs() {

        //  с помощью цикла foreach
//        int index = 1;
//        for (var food:foodStaffs) {
//            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(),
//                    food.getProteins() ? "Да" : "Нет",
//                    food.getFats() ? "Да" : "Нет",
//                    food.getCarbohydrates() ? "Да" : "Нет");
//        }

        //  с помощью stream api
        AtomicInteger index = new AtomicInteger(1);
        foodStaffs.stream().forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Метод балансировки корзины, в котором покупатель, начавший заполнять корзину,
     * получит полный набор продуктов, при выходе из маркета корзина будет состоять
     * из белков, жиров и углеводов
     * с помощью цикла foreach
     */
    public void cartBalancing() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food:foodStaffs) {
            if (!proteins && food.getProteins())
                proteins = true;
            else if (!fats && food.getFats())
                fats = true;
            else if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }
        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ");
            return;
        }
        for (var thing:market.getThings(clazz)) {
            if (!proteins && thing.getProteins()) {
                proteins = true;
                foodStaffs.add(thing);
            } else if (!fats && thing.getFats()) {
                fats = true;
                foodStaffs.add(thing);
            } else if (!carbohydrates && thing.getCarbohydrates()) {
                carbohydrates = true;
                foodStaffs.add(thing);
            }
            if (proteins && fats && carbohydrates) {
                break;
            }
        }
        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина сбалансирована по БЖУ");
        } else
            System.out.println("Невозможно сбалансировать корзину по БЖУ");
    }

    /**
     * Метод балансировки корзины, в котором покупатель, начавший заполнять корзину,
     * получит полный набор продуктов, при выходе из маркета корзина будет состоять
     * из белков, жиров и углеводов
     * с помощью stream api
     */
    public void cartBalancingV2() {
        Optional<T> proteins = foodStaffs.stream().filter(Food::getProteins).findFirst();
        Optional<T> fats = foodStaffs.stream().filter(food -> food.getFats()).findFirst();
        Optional<T> carbohydrates = foodStaffs.stream().filter(Food::getCarbohydrates).findFirst();

        if (proteins.isPresent() && fats.isPresent() && carbohydrates.isPresent()) {
            System.out.println("Корзина уже сбалансирована по БЖУ");
            return;
        }

        if (proteins.isEmpty()) {
            proteins = market.getThings(clazz).stream().filter(Food::getProteins).findFirst();
            proteins.ifPresent(foodStaffs::add);
        }

        if (fats.isEmpty()) {
            fats = market.getThings(clazz).stream().filter(Food::getFats).findFirst();
            fats.ifPresent(foodStaffs::add);
        }

        if (carbohydrates.isEmpty()) {
            carbohydrates = market.getThings(clazz).stream().filter(Food::getCarbohydrates).findFirst();
            carbohydrates.ifPresent(foodStaffs::add);
        }

        if (proteins.isPresent() && fats.isPresent() && carbohydrates.isPresent()) {
            System.out.println("Корзина сбалансирована по БЖУ");
        } else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ");
        }
    }

    //endregion
}
