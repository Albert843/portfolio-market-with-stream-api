package market.food.healthy_foods;

public class Chicken implements HealthyFood {
    /**
     *  Класс Chicken (Курица) является здоровой пищей,
     *  содержащей только proteins (белки).
     */

    //region Методы
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
    //endregion
}
