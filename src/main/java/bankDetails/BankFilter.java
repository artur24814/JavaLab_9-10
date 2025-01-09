package bankDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BankFilter {
    public final static String BANK_DATA_BASE_URL = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

    public static List<BankDetails> filterBanksByBankCode (String bankCode) throws IOException{
        HttpURLConnection connection = createConnection();

        if (connection != null && connection.getResponseCode() == 200) {
            List<BankDetails> bankDetailsList = appendBankDetailIntoList(connection, bankCode);
            return bankDetailsList;
        } else {
            System.err.println("Failed to download file. HTTP response code: " + connection.getResponseCode());
            return null;
        }
    }

    public static HttpURLConnection createConnection () {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BANK_DATA_BASE_URL).openConnection();
            connection.setRequestMethod("GET");
            return connection;
        } catch (Exception e) {
            System.err.println("Error connection: ");
            e.printStackTrace();
            return null;
        }
    }

    public static List<BankDetails> appendBankDetailIntoList (
        HttpURLConnection connection,
        String bankCode
    ) throws IOException {
        List<BankDetails> bankDetailsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;

            System.out.println("Szukam informacji o banku dla kodu: " + bankCode);
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(bankCode)) {
                    String[] parts = line.split("\t");

                    if (parts.length >= 8) {
                        String bankName = parts[1].trim();
                        String branchDetails = parts[4].trim() + " " + parts[7].trim() + " " + parts[8].trim();

                        bankDetailsList.add(new BankDetails(bankName, branchDetails));
                    }
                }
            }
        }

        return bankDetailsList;
    }
}
