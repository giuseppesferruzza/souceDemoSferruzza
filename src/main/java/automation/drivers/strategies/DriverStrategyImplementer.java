package automation.drivers.strategies;

import automation.utils.Constants;

public class DriverStrategyImplementer{
    public static DriverStrategy setStrategy(String strategy){
        switch(strategy){
            case Constants.CHROME:
                return new Chrome();
            case Constants.FIREFOX:
                return new Firefox();
            default:
                return null;
        }

    }

}
