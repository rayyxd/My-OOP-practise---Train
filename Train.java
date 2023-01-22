import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
class Train {
    public String trainName;
    public String departurePlace;
    public String departureTime;
    public String arrivalPlace;
    public String arrivalTime;
    ArrayList<Wagon> wagons;
    ArrayList<Passenger> passengers;
    public Train(String trainName, String departurePlace,  String departureTime, String arrivalPlace, String arrivalTime) {
        this.trainName = trainName;
        this.departurePlace = departurePlace;
        this.departureTime = departureTime;
        this.arrivalPlace = arrivalPlace;
        this.arrivalTime = arrivalTime;
        wagons = new ArrayList<>();
        passengers = new ArrayList<>();
    }
    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
    }
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
    public String toString(){
        return "Train1 - " + trainName + ":" + departurePlace + " -> " + arrivalPlace + " - " + departureTime + " -> " + arrivalTime;
    }
}
class Wagon {
    String classType;
    int capacity;
    double priceForSit;

    public Wagon(String classType, int capacity, double priceForSit) {
        this.classType = classType;
        this.capacity = capacity;
        this.priceForSit = priceForSit;
    }

    public Wagon() {}

    public String getClassType() {
        return classType;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPriceForSit() {
        return priceForSit;
    }

}

class Passenger{
    String name;
    int age;
    boolean disability;
    String typeOfWagon;

    public Passenger(String name, int age, boolean disability, String typeOfWagon) {
        super();
        this.name = name;
        this.age = age;
        this.disability = disability;
        this.typeOfWagon = typeOfWagon;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public String getTypeOfWagon() {return typeOfWagon;}

    public void setTypeOfWagon(String typeOfWagon) {this.typeOfWagon = typeOfWagon;}
}

class Main{
    //If you need to find passenger by name
    public static void findPassengerToOutput(Train tr, String name) {
        for(Passenger p : tr.passengers){
            if(Objects.equals(name, p.name)){
                System.out.println("Name: " + p.getName());
                System.out.println("Age: " + p.getAge());
                System.out.println("Disability: " + p.getDisability());
                System.out.println("Type of wagon: " + p.getTypeOfWagon());
                break;
            }
        }
    }
    //remove passenger
/*
    public static void findPassengerToRemove(Train tr, String nameDel) {
        boolean removed = false;
        for (Iterator<Passenger> iterator = tr.passengers.iterator(); iterator.hasNext();) {
            Passenger p = iterator.next();
            if (Objects.equals(nameDel, p.name)) {
                iterator.remove();
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Removed!");
        }
    }
 */

    public static void findPassengerToRemove(Train tr, String nameDel) {
        boolean remove = false;
        for(Passenger p: tr.passengers){
            if(Objects.equals(nameDel, p.name)){
                p.name = "null";
                remove = true;
            }
        }
        if(remove){
            System.out.println("Removed");
        }
    }
    //Update
    public static void findPassengerToUpdate(Train tr, String name, String newName, int newAge, boolean newDisability) {
        boolean updated = false;
        for (Passenger p : tr.passengers) {
            if (Objects.equals(name, p.name)) {
                p.setName(newName);
                p.setAge(newAge);
                p.setDisability(newDisability);
                updated = true;
            }
        }
        if (updated) {
            System.out.println("Updated!");
        }
    }

    //Output information about allPassengers
    public static void printPassengerList(Train tr) {
        for (Passenger p : tr.passengers) {
            if(p.name.equals("null")) {
                continue;
            }
            else{
                System.out.println("Name: " + p.getName() + ", Age: " + p.getAge() + ", Disability: " + p.getDisability()  + ", Wagon class: " + p.getTypeOfWagon());
            }
        }
    }

    //output wagon's inforamtion
    public static void outputWagons(Train tr){
        for(Wagon w : tr.wagons){
            System.out.print("Class Type: " + w.getClassType());
            System.out.print(", Capacity: " + w.getCapacity());
            System.out.println(", Price per seat: " + w.getPriceForSit());
        }
    }

    //When you are creating a passenger (Method)
    public static void selectTrain(Train tr, Scanner sc) {
        System.out.println("Input your name: ");
        String name = sc.next();

        System.out.println("Input your age: ");
        int age = sc.nextInt();

        System.out.println("Disability true/false: ");
        boolean disability = sc.nextBoolean();

        System.out.println("Choose class:");
        int i=1;
        for (Wagon w : tr.wagons)
        {
            System.out.println(i+" - "+ w.getClassType()+" - "+w.getPriceForSit());
            i++;
        }
        String typeOfWagon = null;
        int ch = sc.nextInt();
        switch (ch){
            case 1 -> {
                typeOfWagon = "Economy class";
            }
            case 2 -> {
                typeOfWagon = "Business class";
            }
            case 3 -> {
                typeOfWagon = "First class";
            }
        }

        tr.addPassenger(new Passenger(name, age, disability, typeOfWagon));
    }
    public static void main(String[] args) {
        Train tr1 = new Train("Baiterek", "Astana", "12:30", "Almaty", "20:00");
        tr1.addWagon(new Wagon("Economy", 40, 5000));
        tr1.addWagon(new Wagon("Business", 30, 7000));
        tr1.addWagon(new Wagon("First", 20, 10000));

        Train tr2 = new Train("Talgo", "Astana", "8:00", "Pavlodar", "15:00");
        tr2.addWagon(new Wagon("Economy", 30, 7000));
        tr2.addWagon(new Wagon("Business", 20, 8500));
        tr2.addWagon(new Wagon("First", 10, 12000));

        Train tr3 = new Train("Viper", "Astana", "01:00", "Kostanay", "10:30");
        tr3.addWagon(new Wagon("Economy", 30, 8000));
        tr3.addWagon(new Wagon("Business", 15, 10000));
        tr3.addWagon(new Wagon("First", 15, 13000));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    1: Create
                    2: Read
                    3: Update
                    4: Delete
                    5: Info
                    """);
            int choice1 = sc.nextInt();
            if(choice1 < 1 || choice1 > 5){break;}
            switch (choice1) {
                case 1 -> {
                    System.out.print("""
                            Chose the train
                            1: Astana -> Almaty
                            2: Astana -> Pavlodar
                            3: Astana -> Kostanay
                            """);
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        selectTrain(tr1, sc);
                    }
                    else if (ch == 2) {
                        selectTrain(tr2, sc);
                    }
                    else if (ch == 3) {
                        selectTrain(tr3, sc);
                    }
                }
                case 2 -> {
                    System.out.println("Input your name: ");
                    String name = sc.next();
                    findPassengerToOutput(tr1, name);
                    findPassengerToOutput(tr2, name);
                    findPassengerToOutput(tr3, name);
                }
                case 3 -> {
                    System.out.println("Input the name of passenger you want to update: ");
                    String name = sc.next();
                    System.out.println("Input the new name of passenger: ");
                    String newName = sc.next();
                    System.out.println("Input the new age of passenger: ");
                    int newAge = sc.nextInt();
                    System.out.println("Disability true/false: ");
                    boolean newDisability = sc.nextBoolean();

                    findPassengerToUpdate(tr1, name, newName, newAge, newDisability);
                    findPassengerToUpdate(tr2, name, newName, newAge, newDisability);
                    findPassengerToUpdate(tr3, name, newName, newAge, newDisability);
                }
                case 4 -> {
                    System.out.println("Input the name of passenger you want to remove: ");
                    String nameDel = sc.next();
                    findPassengerToRemove(tr1, nameDel);
                    findPassengerToRemove(tr2, nameDel);
                    findPassengerToRemove(tr3, nameDel);
                }
                case 5 -> {
                    System.out.print("""
                            1: Info about Train1
                            2: Info about Passengers
                            """);
                    int ch = sc.nextInt();
                    if(ch==2) {
                        System.out.println("Passenger List of Train 1:");
                        printPassengerList(tr1);
                        System.out.println();

                        System.out.println("Passenger List of Train 2:");
                        printPassengerList(tr2);
                        System.out.println();

                        System.out.println("Passenger List of Train 3:");
                        printPassengerList(tr3);
                    }
                    else if(ch==1){
                        System.out.println(tr1);
                        outputWagons(tr1);
                        System.out.println();

                        System.out.println(tr2);
                        outputWagons(tr2);
                        System.out.println();

                        System.out.println(tr3);
                        outputWagons(tr3);
                        System.out.println();
                    }
                }
            }
        }
    }
}