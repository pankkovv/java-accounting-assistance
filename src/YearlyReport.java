import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    HashMap<String, Double> year = new HashMap<>();

    ReadFile readFile = new ReadFile();

    public String processingYear(){
        readFile.readFileYearOrNull();
        ArrayList<String> reportYear = readFile.readYear;
        ArrayList<Double> averageExpenseMin = new ArrayList<>();
        ArrayList<Double> averageExpenseMax = new ArrayList<>();
        String nameYear = "Год 2021";
        Double profitMin = 0.0;
        Double profitMax = 0.0;

        int c = 0;

        while(c < reportYear.size()) {
            Double profitCount = 0.0;
            String category = "";

            if (reportYear.get(c).equals("01")) {
                category = "Январь";
            } else if (reportYear.get(c).equals("02")) {
                category = "Февраль";
            } else if (reportYear.get(c).equals("03")) {
                category = "Март";
            }

            ArrayList<Double> count = new ArrayList<>();
            Double profitMonth = 0.0;
            int m = 0;
            while(m < 6) {
                if (reportYear.get(c + m + 2).equals("false")) {
                    profitMonth = Double.parseDouble(reportYear.get(c + m + 1));
                    count.add(profitMonth);
                } else if (reportYear.get(c + m + 2).equals("true")) {
                    profitMonth = -1 * Double.parseDouble(reportYear.get(c+ m + 1));
                    count.add(profitMonth);
                }
                m += 3;
            }


            for(Double profit : count){
                profitCount += profit;
                year.put(category, profitCount);
            }

            count.clear();

            Double average = 0.0;
            m = 0;
            while(m < 6) {
                if (reportYear.get(c + m + 2).equals("true")) {
                    average = -1 * Double.parseDouble(reportYear.get(c+ m + 1));
                    averageExpenseMin.add(average);
                }
                m += 3;
            }

            average = 0.0;
            m = 0;
            while(m < 6) {
                if (reportYear.get(c + m + 2).equals("false")) {
                    average = Double.parseDouble(reportYear.get(c+ m + 1));
                    averageExpenseMax.add(average);
                }
                m += 3;
            }

            c += 6;
        }

        for(Double profit : averageExpenseMin){
            profitMin += profit;
        }
        year.put("Средний расход за все месяцы в году", (-1 * profitMin)/3);

        for(Double profit : averageExpenseMax){
            profitMax += profit;
        }
        year.put("Средний доход за все месяцы в году", profitMax/3);


        String category = "";
        String resultYan = "";
        String resultFeb = "";
        String resultMarch = "";
        for (int i = 0; i < 3; i++)
        if (i == 0) {
            category = "Январь";
            resultYan = category + ", прибыль составила: " + Double.toString(year.get(category));
        } else if (i == 1) {
            category = "Февраль";
            resultFeb = category + ", прибыль составила: " + Double.toString(year.get(category));
        } else if (i == 2) {
            category = "Март";
            resultMarch = category + ", прибыль составила: " + Double.toString(year.get(category));
        }


        String result = nameYear  + "\n" + resultYan  + "\n" + resultFeb  + "\n" + resultMarch  + "\n" + "Средний расход за все месяцы в году: " + Double.toString(year.get("Средний расход за все месяцы в году")) + "\n" +"Средний доход за все месяцы в году: " + Double.toString(year.get("Средний доход за все месяцы в году")) + "\n";
        return result;
    }
}
