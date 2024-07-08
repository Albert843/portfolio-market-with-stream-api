package market.food.semi_finished_foods;

public class DumplingBeeries implements SemiFinishedFood {
    /**
     *  Класс DumplingBeeries (замороженные ягоды) является полуфабрикатом,
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
        return "Замороженные ягоды";
    }
    //endregion
}
