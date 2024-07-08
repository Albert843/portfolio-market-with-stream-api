package market.officce.office_supplies;

import market.Thing;

public class Pen implements Thing {
    /**
     *  Класс Pen (ручка) является канцтоваром.
     */

    //region Методы
    @Override
    public String getName() {
        return "Ручка";
    }
    //endregion
}
