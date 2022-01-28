package com.example.PROJECT2;

import java.io.IOException;
import java.util.*;

import static com.example.PROJECT2.Tools.countrySize;

public class Main {

    private static final String OUTPUTFILE = "3SmallAnd3BigRates.txt";
    public static final String GAP = "\n=========================================";





    public static void main(String[] args) {
        // wytworze sobie instancje klasy CallApi żeby zawołać metode callApi
        CallApi callApi = new CallApi();
        //wytworze instancje klasy Tools do mapowania na obiekt
        Tools tools = new Tools();

        TaxResponse tax = null;
        try {
           String body = callApi.callApi();
            tax = tools.mapToObject(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        List<TaxRecord> poleZaznamu = new ArrayList<>();
        tax.getRates().entrySet().forEach(stringObjectEntry -> {
            Map.Entry<String, Object> entry = stringObjectEntry;

            Map<String, Object> data = (Map<String, Object>) entry.getValue();

            System.out.println(entry.getKey() + " --> " +data.get("standard_rate"));
            TaxRecord r = new TaxRecord(entry.getKey(), (String) data.get("country"), (Double) data.get("standard_rate"));
            poleZaznamu.add(r);

        } );

        poleZaznamu.sort(Comparator.comparing(TaxRecord::getStandartRate));
        List<TaxRecord> top3 = new ArrayList<>(poleZaznamu.subList(0, 3));

        poleZaznamu.sort(Comparator.comparing(TaxRecord::getStandartRate).reversed());
        List<TaxRecord> bottom3 = new ArrayList<>(poleZaznamu.subList(0, 3));


        System.out.println("Kod zeme:");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String v = scanner.next();
            Optional<TaxRecord> hledanaZeme = poleZaznamu.stream().filter(taxRecord -> Objects.equals(taxRecord.getCountryCode(), v)).findAny();
            if (hledanaZeme.isPresent()){
                System.out.println(hledanaZeme.get().getCountryCode() + " ---" +hledanaZeme.get().getStandartRate());
            }else {
                System.out.println("Country not found");
            }
        }
        //export do pliku
//        try {
//            tools.exportToFile(OUTPUTFILE);
//                } catch (TaxException e) {
//            System.err.println(e.getMessage());
//        }
        // end region

            //wypis wszystkich krajów
        for (int i = 0; i < countrySize();i++){
            System.out.println(tools.listSort());}
        //end region

        // metoda dla użytkownika
        System.out.println(tools.getInfoOfCountriesByAbbreviation());
        // end region

    }


}
