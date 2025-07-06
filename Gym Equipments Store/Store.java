import java.io.*;
import java.util.*;

public class Store {
    private List<Equipment> equipmentList = new ArrayList<>();

    public Store() {
        loadFromFile();
    }

    // ✅ Load equipment from equipment.txt
    private void loadFromFile() {
        File file = new File("equipment.txt");

        if (!file.exists()) {
            System.out.println("❌ File does not exist at: " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("✅ Found equipment.txt. Reading contents...");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("📦 Reading line: " + line);
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    equipmentList.add(new Equipment(name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid price format in file.");
        }
    }

    // ✅ Save equipment list to file
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipment.txt"))) {
            for (Equipment e : equipmentList) {
                writer.write(e.getName() + "," + e.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // ✅ Display equipment in console
    public void displayEquipment() {
        System.out.println("\n--- Available Equipment ---");
        if (equipmentList.isEmpty()) {
            System.out.println("No equipment available.");
        } else {
            for (int i = 0; i < equipmentList.size(); i++) {
                System.out.println((i + 1) + ". " + equipmentList.get(i));
            }
        }
    }

    // ✅ Return equipment by index
    public Equipment getEquipment(int index) {
        if (index >= 0 && index < equipmentList.size()) {
            return equipmentList.get(index);
        }
        return null;
    }

    // ✅ Add new equipment and save
    public void addEquipment(String name, double price) {
        equipmentList.add(new Equipment(name, price));
        saveToFile();
        System.out.println("✅ Added successfully!");
    }

    // ✅ Get total number of items
    public int totalItems() {
        return equipmentList.size();
    }
}
