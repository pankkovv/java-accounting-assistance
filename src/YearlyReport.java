import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    HashMap<String, Double> year = new HashMap<>();

    ReadFile readFile = new ReadFile();

    public String processingYear(String path){

        readFile.readFileMonthOrNull(path);
        readFile.readFileYearOrNull(path);

        HashMap<Integer, String> reportMonth = readFile.months;
        ArrayList<String> reportYear = readFile.readYear;

        ArrayList<Double> averageExpenseMin = new ArrayList<>();
        ArrayList<Double> averageExpenseMax = new ArrayList<>();

        String nameYear = "Год 2021";
        Double averageMin = 0.0;
        Double averageMax = 0.0;

        int count = 0;

        while(count < reportYear.size()) {
            Double profitMonth = 0.0;
            String category = "";



            if (reportYear.get(count).split(",")[0].equals("01")) {
                category = "Январь";
            } else if (reportYear.get(count).split(",")[0].equals("02")) {
                category = "Февраль";
            } else if (reportYear.get(count).split(",")[0].equals("03")) {
                category = "Март";
            }

            int meter = 0;
            while(meter < reportYear.size()/reportMonth.size()) {
                if (reportYear.get(count).split(",")[2].equals("false")) {
                    profitMonth += Double.parseDouble(reportYear.get(count).split(",")[1]);
                } else if (reportYear.get(count).split(",")[2].equals("true")) {
                    profitMonth += -1 * Double.parseDouble(reportYear.get(count).split(",")[1]);
                }
                meter += 1;
                count += 1;
            }
                count -= meter;
            year.put(category, profitMonth);

            meter = 0;
            while(meter < reportYear.size()/reportMonth.size()) {
                if (reportYear.get(count).split(",")[2].equals("true")) {
                    averageMin += -1 * Double.parseDouble(reportYear.get(count).split(",")[1]);
                } else if (reportYear.get(count).split(",")[2].equals("false")){
                    averageMax += Double.parseDouble(reportYear.get(count).split(",")[1]);
                }
                meter += 1;
                count += 1;
            }
            count -= meter;
            count += 2;

        }
        year.put("Средний расход за все месяцы в году", (-1 * averageMin)/reportMonth.size());
        year.put("Средний доход за все месяцы в году", averageMax/reportMonth.size());
        reportYear.clear();

        String resultYan = "";
        String resultFeb = "";
        String resultMarch = "";
        String resultExpense = "";
        String resultIncome = "";

        for (String category : year.keySet()){
            if (category.equals("Январь")) {
                resultYan = category + ", прибыль составила: " + Double.toString(year.get(category));
            } else if (category.equals("Февраль")) {
                resultFeb = category + ", прибыль составила: " + Double.toString(year.get(category));
            } else if (category.equals("Март")) {
                resultMarch = category + ", прибыль составила: " + Double.toString(year.get(category));
            }
        }

        resultExpense = "Средний расход за все месяцы в году: " + Double.toString(year.get("Средний расход за все месяцы в году"));

        resultIncome = "Средний доход за все месяцы в году: " + Double.toString(year.get("Средний доход за все месяцы в году"));


        String result = nameYear  + "\n" + resultYan  + "\n" + resultFeb  + "\n" + resultMarch  + "\n" + resultExpense + "\n" + resultIncome + "\n";
        return result;
    }
}
