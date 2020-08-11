package services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarRental {
	private String model;
	private Date initialInstant;
	private Date finalInstant;
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	public CarRental() {
	}

	public CarRental(String model, Date initialInstant, Date finalInstant, Double pricePerHour, Double pricePerDay) {
		this.model = model;
		this.initialInstant = initialInstant;
		this.finalInstant = finalInstant;
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getInitialInstant() {
		return initialInstant;
	}

	public void setInitialInstant(Date initialInstant) {
		this.initialInstant = initialInstant;
	}

	public Date getFinalInstant() {
		return finalInstant;
	}

	public void setFinalInstant(Date finalInstant) {
		this.finalInstant = finalInstant;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}
	
	
	public double basicPayment() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		long dt = (finalInstant.getTime() - initialInstant.getTime() ) + 3600000;
		long days = (dt / 86400000L);
		long hours = (finalInstant.getTime() - initialInstant.getTime())/(1000*60*60);
		
		
		String ii = sdf.format(initialInstant);
		String fi = sdf.format(finalInstant);
		
		
		if(fi.charAt(0) > ii.charAt(0) || fi.charAt(1) > ii.charAt(1)) {
			return pricePerDay * days + pricePerDay;
		} else {
			return pricePerHour * hours + pricePerHour;
		}
		
	}
	
		public double tax() {
			if(basicPayment() < 100.0) {
				return basicPayment() * 0.2;
			} else {
				return basicPayment() * 0.15;
			}
		}
		
		public double totalPayment() {
			return basicPayment() + tax();
		}

		@Override
		public String toString() {
			return "INVOICE:\nBasic payment: $"+ String.format("%.2f", basicPayment())+
					"\nTax: $"+ String.format("%.2f", tax()) + "\nTotal payment: $"+
					String.format("%.2f", totalPayment());
		}

		
}
