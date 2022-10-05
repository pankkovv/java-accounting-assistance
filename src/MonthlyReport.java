import java.util.*;

public class MonthlyReport {
    HashMap<String, Integer> calculationMonth = new HashMap<>();
    HashMap<String, Integer> reportMonthYan = new HashMap<>();
    HashMap<String, Integer> reportMonthFeb = new HashMap<>();
    HashMap<String, Integer> reportMonthMarch = new HashMap<>();

    ReadFile readFile = new ReadFile();

    public String processingMonth(String path) {
        int count = 0;
        String resultReportYan = "";
        String resultReportFeb = "";
        String resultReportMarch = "";
        String result = "";


            readFile.readFileMonthOrNull(path);

            for(Integer i : readFile.months.keySet()){
                String nameMonth = readFile.months.get(i);

                Integer profitMax = 0;
                Integer profitMin = 0;
                String categoryProfitMax = "";
                String categoryProfitMin = "";
                ArrayList<String> month = new ArrayList<>();

                if(i == 1){
                    month = readFile.readMonthYan;
                }else if(i == 2){
                    month = readFile.readMonthFeb;
                }else if(i == 3){
                    month = readFile.readMonthMarch;
                }


                while(count < month.size()){
                    Integer sum = 0;
                    String category = "";

                    category = month.get(count);

                    if(month.get(count+1).equals("TRUE")){
                        sum = -1 * Integer.parseInt(month.get(count+2)) * Integer.parseInt(month.get(count+3));
                        calculationMonth.put(category, sum);
                    } else {
                        sum = Integer.parseInt(month.get(count+2))*Integer.parseInt(month.get(count+3));
                        calculationMonth.put(category, sum);
                    }

                    count += 4;
                }
                count = 0;

                for(String category : calculationMonth.keySet()){
                    int profit = calculationMonth.get(category);

                    if(profit > profitMax){
                        profitMax =  profit;
                        categoryProfitMax = category;
                    }

                    if(profit < profitMin){
                        profitMin = profit;
                        categoryProfitMin = category;
                    }
                }

                if(i == 1){
                    reportMonthYan.put(categoryProfitMax, profitMax);
                    reportMonthYan.put(categoryProfitMin, profitMin);
                    resultReportYan = nameMonth + "\n" + "Самый прибыльный товар: " + categoryProfitMax + " " + Integer.toString(reportMonthYan.get(categoryProfitMax)) + "\n" + "Самая большая трата: " + categoryProfitMin + " " + Integer.toString(-1 * reportMonthYan.get(categoryProfitMin)) + "\n";
                }else if(i == 2){
                    reportMonthFeb.put(categoryProfitMax, profitMax);
                    reportMonthFeb.put(categoryProfitMin, profitMin);
                    resultReportFeb = nameMonth + "\n" + "Самый прибыльный товар: " + categoryProfitMax + " " + Integer.toString(reportMonthFeb.get(categoryProfitMax)) + "\n" + "Самая большая трата: " + categoryProfitMin + " " + Integer.toString(-1 * reportMonthFeb.get(categoryProfitMin)) + "\n";
                }else if(i == 3){
                    reportMonthMarch.put(categoryProfitMax, profitMax);
                    reportMonthMarch.put(categoryProfitMin, profitMin);
                    resultReportMarch = nameMonth + "\n" + "Самый прибыльный товар: " + categoryProfitMax + " " + Integer.toString(reportMonthMarch.get(categoryProfitMax)) + "\n" + "Самая большая трата: " + categoryProfitMin + " " + Integer.toString(-1 * reportMonthMarch.get(categoryProfitMin)) + "\n";
                }

                calculationMonth.clear();
            }
            result = resultReportYan + "\n" + resultReportFeb + "\n" + resultReportMarch + "\n";

        return result;
    }
}
