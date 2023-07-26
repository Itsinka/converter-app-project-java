import java.util.Scanner;

public class ConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        TimeConversionOption timeOption = new TimeConversionOption();
        LengthConversionOption lengthOption = new LengthConversionOption();
        WeightConversionOption weightOption = new WeightConversionOption();
        TemperatureConversionOption temperatureOption = new TemperatureConversionOption();

        while (true) {
            System.out.println("Enter conversion option (time, length, weight, temperature, login, exit) or 'exit' to quit: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            if (input.equals("login")) {
                System.out.println("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();

                if (username.equals("admin") && password.equals("password")) {
                    System.out.println("Login successful!");
                    loggedIn = true;
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            } else if (input.equals("time") || input.equals("length") || input.equals("weight") || input.equals("temperature")) {

                if (!loggedIn) {
                    System.out.println("You must be logged in to access the conversion options. Please try logging in.");
                    continue;
                }

                System.out.println("Enter value to convert: ");
                double value = scanner.nextDouble();
                scanner.nextLine();

                if (input.equals("time")) {
                    timeOption.setSeconds((int) value);
                    int hours = timeOption.getSeconds() / 3600;
                    System.out.println(value + " seconds is equivalent to " + hours + " hours.");
                } else if (input.equals("length")) {
                    lengthOption.setMeters(value);
                    double feet = lengthOption.getMeters() * 3.28084;
                    System.out.println(value + " meters is equivalent to " + feet + " feet.");
                } else if (input.equals("weight")) {
                    weightOption.setKilograms(value);
                    double pounds = weightOption.getKilograms() * 2.20462;
                    System.out.println(value + " kilograms is equivalent to " + pounds + " pounds.");
                } else if (input.equals("temperature")) {
                    temperatureOption.setCelsius(value);
                    double fahrenheit = (temperatureOption.getCelsius() * 9 / 5) + 32;
                    System.out.println(value + " degrees Celsius is equivalent to " + fahrenheit + " degrees Fahrenheit.");
                }
            } else {
                System.out.println("Invalid conversion option.");
            }
        }


        scanner.close();
    }
}