import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);

	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			double eachCharge = 0;
			int eachPoint = 0 ;
			int daysRented = 0;

            daysRented = getDaysRented(each);
            eachCharge = calculateCharge(each, eachCharge, daysRented);
            eachPoint = calculatePoint(each, eachPoint, daysRented);

			result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
					+ "\tPoint: " + eachPoint + "\n";

			totalCharge += eachCharge;
			totalPoint += eachPoint ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result ;
	}


	private int calculatePoint(Rental each, int eachPoint, int daysRented) {

		eachPoint++;

		if ((each.getVideo().getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > each.getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, each.getVideo().getLateReturnPointPenalty()) ;
		return eachPoint;
	}

    private double calculateCharge(Rental each, double eachCharge, int daysRented) {
        switch (each.getVideo().getPriceCode()) {
            case Video.REGULAR:
                eachCharge += 2;
                if (daysRented > 2)
                    eachCharge += (daysRented - 2) * 1.5;
                break;
            case Video.NEW_RELEASE:
                eachCharge = daysRented * 3;
                break;
        }
        return eachCharge;
    }

    private int getDaysRented(Rental each) {
        int daysRented;
        long diff;
        if (each.getStatus() == 1) { // returned Video
            diff = each.getReturnDate().getTime() - each.getRentDate().getTime();
        } else { // not yet returned
            diff = new Date().getTime() - each.getRentDate().getTime();
        }
        daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        return daysRented;
    }



}
