package market.food.snacks;

public class Crisps implements Snack {
    /**
     *  Класс Crisps (чипсы) является снеком,
     *  содержащей только fats (жиры).
     */

    //region Методы
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чипсы";
    }
    //endregion
}
