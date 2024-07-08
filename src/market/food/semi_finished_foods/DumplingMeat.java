package market.food.semi_finished_foods;

public class DumplingMeat implements SemiFinishedFood {
    /**
     *  Класс DumplingMeat (пельмени) является полуфабрикатом,
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
        return "Пельмени";
    }
    //endregion
}
