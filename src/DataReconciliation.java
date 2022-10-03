import java.util.ArrayList;
import java.util.HashMap;

public class DataReconciliation {
    HashMap<String, Double> profitMonth = new HashMap<>();
    HashMap<String, Double> profitMonthYan = new HashMap<>();
    HashMap<String, Double> profitMonthFeb = new HashMap<>();
    HashMap<String, Double> profitMonthMarch = new HashMap<>();


    ReadFile readFile = new ReadFile();
    YearlyReport yearlyReport = new YearlyReport();


    public void reconciliation() {

        int c = 0;
        Double profitMax;
        Double profitMin;
        String nameMonth = "";

        readFile.readFileMonthOrNull();
        yearlyReport.processingYear();

        for (int i = 1; i < 4; i++) {
            if (i == 1) {
                nameMonth = "Январь";
            } else if (i == 2) {
                nameMonth = "Февраль";
            } else if (i == 3) {
                nameMonth = "Март";
            }
            switch (i) {
                case (1):
                    profitMax = 0.0;
                    profitMin = 0.0;

                   ArrayList<String> yan = readFile.readMonthYan;

                    while(c < yan.size()){
                        double sum = 0.0;
                        String category = "";

                        category = yan.get(c);

                        if(yan.get(c+1).equals("TRUE")){
                            sum = -1 * Double.parseDouble(yan.get(c+2)) * Double.parseDouble(yan.get(c+3));
                            profitMonth.put(category, sum);
                        } else {
                            sum = Double.parseDouble(yan.get(c+2)) * Double.parseDouble(yan.get(c+3));
                            profitMonth.put(category, sum);
                        }
                        c += 4;
                    }
                    c = 0;


                    for(String category : profitMonth.keySet()){
                        double profit = profitMonth.get(category);

                        if(profit < 0){
                            profitMin += profit;
                        }else if(profit > 0){
                            profitMax += profit;
                        }
                    }

                    profitMonthYan.put("Общие доходы", profitMax);
                    profitMonthYan.put("Общие расходы", profitMin);
                    profitMonth.clear();
                    break;

                case (2):
                    profitMax = 0.0;
                    profitMin = 0.0;

                    ArrayList<String> feb = readFile.readMonthFeb;

                    while(c < feb.size()){
                        double sum = 0.0;
                        String category = "";

                        category = feb.get(c);

                        if(feb.get(c+1).equals("TRUE")){
                            sum = -1 * Double.parseDouble(feb.get(c+2)) * Double.parseDouble(feb.get(c+3));
                            profitMonth.put(category, sum);
                        } else {
                            sum = Double.parseDouble(feb.get(c+2)) * Double.parseDouble(feb.get(c+3));
                            profitMonth.put(category, sum);
                        }
                        c += 4;
                    }
                    c = 0;

                    for(String category : profitMonth.keySet()){
                        double profit = profitMonth.get(category);

                        if(profit < 0){
                            profitMin += profit;
                        }else if(profit > 0){
                            profitMax += profit;
                        }
                    }

                    profitMonthFeb.put("Общие доходы", profitMax);
                    profitMonthFeb.put("Общие расходы", profitMin);
                    profitMonth.clear();
                    break;

                case (3):
                    profitMax = 0.0;
                    profitMin = 0.0;

                    ArrayList<String> march = readFile.readMonthMarch;

                    while(c < march.size()){
                        double sum = 0.0;
                        String category = "";

                        category = march.get(c);

                        if(march.get(c+1).equals("TRUE")){
                            sum = -1 * Double.parseDouble(march.get(c+2)) * Double.parseDouble(march.get(c+3));
                            profitMonth.put(category, sum);
                        } else {
                            sum = Double.parseDouble(march.get(c+2)) * Double.parseDouble(march.get(c+3));
                            profitMonth.put(category, sum);
                        }
                        c += 4;
                    }
                    c = 0;

                    for(String category : profitMonth.keySet()){

                        double profit = profitMonth.get(category);

                        if(profit < 0){
                            profitMin += profit;
                        }else if(profit > 0){
                            profitMax += profit;
                        }
                    }

                    profitMonthMarch.put("Общие доходы", profitMax);
                    profitMonthMarch.put("Общие расходы", profitMin);
                    profitMonth.clear();
                    break;

            }
        }

        double profit = 0.0;

        for(String category : profitMonthYan.keySet()){
            double compare = profitMonthYan.get(category);
            profit += compare;
        }
        profitMonth.put("Январь", profit);

        profit = 0.0;
        for(String category : profitMonthFeb.keySet()){
            double compare = profitMonthFeb.get(category);
            profit += compare;
        }
        profitMonth.put("Февраль", profit);

        profit = 0.0;
        for(String category : profitMonthMarch.keySet()){
            double compare = profitMonthMarch.get(category);
            profit += compare;
        }
        profitMonth.put("Март", profit);

        HashMap<String, Double> year = yearlyReport.year;

        for(String category : profitMonth.keySet()){

            double valueProfitMonth = profitMonth.get(category);
            double valueProfitYear = year.get(category);

            if(valueProfitMonth != valueProfitYear){
                System.out.println("В месяце " + "\"" + category + "\"" + " обнаружено несоответствие.");
                System.out.println();
            }
        }
        System.out.println("Ошибок не обнаружено, операция успешно завершена.");
        System.out.println();
    }
}
