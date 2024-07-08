package market.food.snacks;

public class BalykCheese implements Snack {
    /**
     *  Класс BalykCheese (сыр (Балык)) является снеком,
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
        return "Сыр (Балык)";
    }
    //endregion
}
