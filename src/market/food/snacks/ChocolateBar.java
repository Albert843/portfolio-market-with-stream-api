package market.food.snacks;

public class ChocolateBar implements Snack {
    /**
     *  Класс Chocolate (шоколадка) является снеком,
     *  содержащей только carbohydrates (углеводы).
     */

    //region Методы
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Шоколадка";
    }
    //endregion
}
