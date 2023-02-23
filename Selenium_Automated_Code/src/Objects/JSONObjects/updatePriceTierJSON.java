package Objects.JSONObjects;

public class updatePriceTierJSON {
    private int[] measurement;
    private int[] initial_price;
    private int[] recurring_price;

    public updatePriceTierJSON(int[] measurement, int[] initial_price, int[] recurring_price) {
        this.measurement = measurement;
        this.initial_price = initial_price;
        this.recurring_price = recurring_price;
    }
}
