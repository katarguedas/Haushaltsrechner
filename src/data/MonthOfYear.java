package data;

public enum MonthOfYear {

	Januar(1), Februar(2), März(3), April(4), Mai(5), Juni(6), Juli(7), August(8), September(9), Oktober(10), November(11), Dezember(12);

	private int value;

    private MonthOfYear(int value) {
    	this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
