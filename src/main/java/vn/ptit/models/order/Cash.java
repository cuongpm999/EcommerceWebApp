package vn.ptit.models.order;

public class Cash extends Payment {
	private double CashTendered;

	public Cash() {
		// TODO Auto-generated constructor stub
	}

	public Cash(double totalMoney, double cashTendered) {
		super(totalMoney);
		CashTendered = cashTendered;
	}

	public double getCashTendered() {
		return CashTendered;
	}

	public void setCashTendered(double cashTendered) {
		CashTendered = cashTendered;
	}

}
