public class Stock {
    private String name = "";
    private Integer value = 50;
    private Integer totalUnits = 5000;
    private Integer netWorth = value * totalUnits;
    private Integer unitsSold = 0;

    public Stock(String name, Integer value){
        this.name= name;
        this.value = value;
    }

    public String getName(){return this.name;}
    public Integer getNetWorth(){return this.netWorth;}

    public void buy(Portfolio user, Integer units){
        if (user.debit(this.value * units)){
            this.unitsSold += units;
            value = value + (unitsSold / totalUnits);
            netWorth = value*totalUnits;
        }
    }

    public void sell(Portfolio user, Integer units){
        if (user.remove(this.name, units)){
            user.credit(this.value*units);
            this.unitsSold -= units;
            value = value - (unitsSold / totalUnits);
            netWorth = value*totalUnits;
        }
    }
}
