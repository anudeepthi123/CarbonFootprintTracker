 import java.util.Scanner;

public class CarbonFootprintTracker {

    // Emission factors (kg CO2)
    private static final double CAR_EMISSION = 0.21;       // per km
    private static final double BUS_EMISSION = 0.05;       // per km
    private static final double BIKE_EMISSION = 0.0;       // per km
    private static final double ELECTRICITY_EMISSION = 0.82; // per kWh
    private static final double VEG_DIET = 1.7;            // per day
    private static final double NONVEG_DIET = 3.0;         // per day
    private static final double LOW_SHOPPING = 20;         // per month
    private static final double MEDIUM_SHOPPING = 50;
    private static final double HIGH_SHOPPING = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Travel
        System.out.print("Enter weekly travel distance (in km): ");
        double travelDistance = sc.nextDouble();
        System.out.print("Enter travel mode (car/bus/bike): ");
        String mode = sc.next().toLowerCase();

        // Electricity
        System.out.print("Enter monthly electricity usage (in kWh): ");
        double electricity = sc.nextDouble();

        // Diet
        System.out.print("Enter your diet type (veg/nonveg): ");
        String dietType = sc.next().toLowerCase();

        // Shopping
        System.out.print("Enter your shopping level (low/medium/high): ");
        String shoppingLevel = sc.next().toLowerCase();

        sc.close();

        // Travel emission
        double travelEmissionFactor = (mode.equals("car")) ? CAR_EMISSION : 
                                      (mode.equals("bus")) ? BUS_EMISSION : BIKE_EMISSION;
        double travelEmission = travelDistance * travelEmissionFactor * 4; // 4 weeks in a month

        // Electricity emission
        double electricityEmission = electricity * ELECTRICITY_EMISSION;

        // Diet emission
        double dietEmission = (dietType.equals("veg")) ? VEG_DIET * 30 : NONVEG_DIET * 30;

        // Shopping emission
        double shoppingEmission;
        switch (shoppingLevel) {
            case "low": shoppingEmission = LOW_SHOPPING; break;
            case "medium": shoppingEmission = MEDIUM_SHOPPING; break;
            case "high": shoppingEmission = HIGH_SHOPPING; break;
            default: shoppingEmission = MEDIUM_SHOPPING; break;
        }

        // Total emission
        double totalEmission = travelEmission + electricityEmission + dietEmission + shoppingEmission;

        // Display results
        System.out.println("\n===== Your Monthly Carbon Footprint =====");
        System.out.printf("Travel: %.2f kg CO2\n", travelEmission);
        System.out.printf("Electricity: %.2f kg CO2\n", electricityEmission);
        System.out.printf("Diet: %.2f kg CO2\n", dietEmission);
        System.out.printf("Shopping: %.2f kg CO2\n", shoppingEmission);
        System.out.printf("TOTAL: %.2f kg CO2\n", totalEmission);

        // Suggestions
        System.out.println("\n===== Suggestions to Reduce Your Footprint =====");
        if (mode.equals("car")) System.out.println("- Try using public transport or carpooling for some trips.");
        if (electricity > 200) System.out.println("- Switch to energy-efficient appliances or solar energy.");
        if (dietType.equals("nonveg")) System.out.println("- Try including more plant-based meals.");
        if (shoppingLevel.equals("high")) System.out.println("- Reduce shopping frequency or buy sustainable products.");

        System.out.println("Track your footprint monthly and aim for gradual reduction!");
    }
}
