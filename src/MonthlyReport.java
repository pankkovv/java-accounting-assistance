import java.util.*;

public class MonthlyReport {
    HashMap<String, Integer> month = new HashMap<>();
    HashMap<String, Integer> reportMonthYan = new HashMap<>();
    HashMap<String, Integer> reportMonthFeb = new HashMap<>();
    HashMap<String, Integer> reportMonthMarch = new HashMap<>();

    ReadFile readFile = new ReadFile();

    public String processingMonth() {
        int c = 0;
        Integer profitMax;
        Integer profitMin;
        String nameMonth = "";
        String resultReportYan = "";
        String resultReportFeb = "";
        String resultReportMarch = "";
        String categoryProfitMax;
        String categoryProfitMin;

        readFile.readFileMonthOrNull();

        for (int i = 1; i < 4; i++) {
            if(i == 1){
                nameMonth = "Январь";
            } else if(i == 2){
                nameMonth = "Февраль";
            } else if(i == 3){
                nameMonth = "Март";
            }

            switch (i) {
                case (1):
                    profitMax = 0;
                    profitMin = 0;
                    categoryProfitMax = "";
                    categoryProfitMin = "";


                    ArrayList<String> yan = readFile.readMonthYan;

                    while(c < yan.size()){
                        Integer sum = 0;
                        String category = "";

                        category = yan.get(c);

                        if(yan.get(c+1).equals("TRUE")){
                            sum = -1 * Integer.parseInt(yan.get(c+2)) * Integer.parseInt(yan.get(c+3));
                            month.put(category, sum);
                            sum = 0;
                        } else {
                            sum = Integer.parseInt(yan.get(c+2))*Integer.parseInt(yan.get(c+3));
                            month.put(category, sum);
                            sum = 0;
                        }

                        c += 4;
                    }
                    c = 0;

                    for(String category : month.keySet()){

                        int profit = month.get(category);

                        if(profit > profitMax){
                            profitMax =  profit;
                            categoryProfitMax = category;
                        }

                        if(profit < profitMin){
                            profitMin = profit;
                            categoryProfitMin = category;
                        }

                    }
                    reportMonthYan.put(categoryProfitMax, profitMax);
                    reportMonthYan.put(categoryProfitMin, profitMin);

                    month.clear();
                    resultReportYan = nameMonth + "\n" + "Самый прибыльный товар: " + categoryProfitMax + " " + Integer.toString(reportMonthYan.get(categoryProfitMax)) + "\n" + "Самая большая трата: " + categoryProfitMin + " " + Integer.toString(-1 * reportMonthYan.get(categoryProfitMin)) + "\n";
                    break;

                case(2):
                    profitMax = 0;
                    profitMin = 0;
                    categoryProfitMax = "";
                    categoryProfitMin = "";
                    ArrayList<String> feb = readFile.readMonthFeb;
                    while(c < feb.size()){
                        int sum = 0;
                        String category = "";

                        category = feb.get(c);

                        if(feb.get(c+1).equals("TRUE")){
                            sum = -1 * Integer.parseInt(feb.get(c+2)) * Integer.parseInt(feb.get(c+3));
                            month.put(category, sum);
                            sum = 0;
                        } else {
                            sum = Integer.parseInt(feb.get(c+2))*Integer.parseInt(feb.get(c+3));
                            month.put(category, sum);
                            sum = 0;
                        }

                        c += 4;
                    }
                    c = 0;

                    for(String category : month.keySet()){

                        int profit = month.get(category);

                        if(profit > profitMax){
                            profitMax =  profit;
                            categoryProfitMax = category;
                        }

                        if(profit < profitMin){
                            profitMin = profit;
                            categoryProfitMin = category;
                        }

                    }
                    reportMonthFeb.put(categoryProfitMax, profitMax);
                    reportMonthFeb.put(categoryProfitMin, profitMin);

                    month.clear();
                    resultReportFeb = nameMonth + "\n" + "Самый прибыльный товар: " + categoryProfitMax + " " + Integer.toString(reportMonthFeb.get(categoryProfitMax)) + "\n" + "Самая большая трата: " + " " + categoryProfitMin + Integer.toString(-1 * reportMonthFeb.get(categoryProfitMin)) + "\n";
                    break;

                case(3):
                    profitMax = 0;
                    profitMin = 0;
                    categoryProfitMax = "";
                    categoryProfitMin = "";
                    ArrayList<String> march = readFile.readMonthMarch;

                    while(c < march.size()){
                        int sum = 0;
                        String category = "";

                        category = march.get(c);

                        if(march.get(c+1).equals("TRUE")){
                            sum = -1 * Integer.parseInt(march.get(c+2)) * Integer.parseInt(march.get(c+3));
                            month.put(category, sum);
                            sum = 0;
                        } else {
                            sum = Integer.parseInt(march.get(c+2))*Integer.parseInt(march.get(c+3));
                            month.put(category, sum);
                            sum = 0;
                        }

                        c += 4;
                    }
                    c = 0;

                    for(String category : month.keySet()){

                        int profit = month.get(category);

                        if(profit > profitMax){
                            profitMax =  profit;
                            categoryProfitMax = category;
                        }

                        if(profit < profitMin){
                            profitMin = profit;
                            categoryProfitMin = category;
                        }

                    }
                    reportMonthMarch.put(categoryProfitMax, profitMax);
                    reportMonthMarch.put(categoryProfitMin, profitMin);

                    month.clear();
                    resultReportMarch = nameMonth + "\n" + "Самый прибыльный товар: " + categoryProfitMax + " " + Integer.toString(reportMonthMarch.get(categoryProfitMax)) + "\n" + "Самая большая трата: " + categoryProfitMin + " " + Integer.toString(-1 * reportMonthMarch.get(categoryProfitMin)) + "\n";
                    break;
            }
        }
        String result = resultReportYan + "\n" + resultReportFeb + "\n" + resultReportMarch;
        return result;
    }
}
