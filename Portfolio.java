import java.util.*;

public class Portfolio {
    private ArrayList<Stock> stocks = new ArrayList<Stock>();
    private ArrayList<Integer> units = new ArrayList<Integer>();
    private Integer cash = 1000;


    public void add(Stock newStock, Integer numUnits){
        stocks.add(newStock);
        units.add(numUnits);
    }


    public Boolean remove(String target, Integer numUnits){
        for (int i=0; i < stocks.size(); i++){
            if (stocks.get(i).getName() == target){                
                if (numUnits == 0){
                    // Removing the entire entry for that stock
                    stocks.remove(i);
                    units.remove(i);
                    return true;
                } else if (numUnits < units.get(i)){
                    // removing units specified
                    units.set(i, units.get(i)-numUnits);
                    return true;
                }
            }
        }
        return false;
    }


    public Boolean debit(Integer amount){
        if (this.cash > amount){
            this.cash -= amount;
            return true;
        } else{
            return false;
        }
    }


    public void credit(Integer amount){
        this.cash += amount;
    }
}
