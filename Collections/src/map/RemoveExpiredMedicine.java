package map;

import java.time.LocalDate;
import java.util.HashMap;

public class RemoveExpiredMedicine {
	public static void main(String[] args) 
    {
        //Creating an empty medicinesExpDateMap
        HashMap<String, LocalDate> medicinesExpDateMap = new HashMap<String, LocalDate>();
         
        //Inserting medicines with their exp date as values into medicinesExpDateMap
        medicinesExpDateMap.put("Amoxicillin Tabs", LocalDate.of(2024, 8, 27));
        medicinesExpDateMap.put("Paracetamol Tabs", LocalDate.of(2025, 1, 23));
        medicinesExpDateMap.put("Vitamin D Capsules", LocalDate.of(2026, 12, 06));
        medicinesExpDateMap.put("Accelofenac Tabs", LocalDate.of(2025, 6, 10));
        medicinesExpDateMap.put("Azithromycin Tabs", LocalDate.of(2027, 1, 30));
        medicinesExpDateMap.put("Citirizine Tabs", LocalDate.of(2023, 9, 21));
        medicinesExpDateMap.put("Folic Acid Tabs", LocalDate.of(2028, 11, 17));
         
        System.out.println("Before Remove");         
        medicinesExpDateMap.forEach((key, value) -> System.out.println(key+" : "+value));
         
        //Removing medicines those have gone past their expiry date
medicinesExpDateMap.entrySet().removeIf(entry -> entry.getValue().isBefore(LocalDate.now()));
         
        System.out.println("After Remove");
        medicinesExpDateMap.forEach((key, value) -> System.out.println(key+" : "+value));    
    }
}
