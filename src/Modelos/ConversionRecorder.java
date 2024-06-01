package Modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConversionRecorder {
    public List<CurrencyConversion> conversions = new ArrayList<>();

    public void addNewConversionRecord(CurrencyConversion conversion) {
        this.conversions.add(conversion);
    }

    public void recordConversions() throws IOException  {
        File file = new File("conversions.json");
        List<CurrencyConversion> allConversions = new ArrayList<>();

        if (file.exists()) {
            Gson gson = new Gson();
            try (JsonReader reader = new JsonReader(new FileReader(file))) {
                CurrencyConversion[] existingConversions = gson.fromJson(reader, CurrencyConversion[].class);
                if (existingConversions != null) {
                    for (CurrencyConversion conversion : existingConversions) {
                        allConversions.add(conversion);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado: " + e.getMessage());
            }
        }

        allConversions.addAll(conversions);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(gson.toJson(allConversions));
        }

    }

    public void readConversionHistory() {
        Gson gson = new Gson();
        try {
        JsonReader reader = new JsonReader(new FileReader("conversions.json"));
        CurrencyConversion[] conversionHistory = gson.fromJson(reader, CurrencyConversion[].class);
            System.out.println("Conversion history");
        for (CurrencyConversion conversion : conversionHistory) {
            System.out.println(conversion.listRecord());
        }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

    }
}
