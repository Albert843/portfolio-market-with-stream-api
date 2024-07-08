package market.food.healthy_foods;

public class Fruit implements HealthyFood {
    /**
     *  Класс Fruit (фрукт) является здоровой пищей,
     *  содержащей только carbonHydrates (углеводы).
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
        return "Фрукты";
    }
    //endregion
}
