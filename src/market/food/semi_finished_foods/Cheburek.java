package market.food.semi_finished_foods;

public class Cheburek implements SemiFinishedFood {
    /**
     *  Класс Cheburek (чебурек) является полуфабрикатом,
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
        return "Чебурек";
    }
    //endregion
}
