package market.food;

import market.Thing;

public interface Food extends Thing {
    boolean getProteins();
    boolean getFats();
    boolean getCarbohydrates();
}
