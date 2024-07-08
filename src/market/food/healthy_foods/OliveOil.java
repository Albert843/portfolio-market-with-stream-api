package market.food.healthy_foods;

public class OliveOil implements HealthyFood {
    /**
     *  Класс OliveOil (оливковое масло) является здоровой пищей,
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
        return "Оливковое масло";
    }
    //endregion
}
