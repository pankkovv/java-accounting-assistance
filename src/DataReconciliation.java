import java.util.ArrayList;
import java.util.HashMap;

public class DataReconciliation {

    HashMap<String, Double> profitMonth = new HashMap<>();
    ArrayList<String> errorMonth = new ArrayList<>();

    ReadFile readFile = new ReadFile();
    YearlyReport yearlyReport = new YearlyReport();


    public String reconciliation(String path) {

        int count = 0;
        double profit = 0.0;
        Double profitMax;
        Double profitMin;
        String result = "";

        readFile.readFileMonthOrNull(path);
        yearlyReport.processingYear(path);

        HashMap<Integer, String> months = readFile.months;

        for(Integer i : months.keySet()){
            String nameMonth = months.get(i);

                profitMax = 0.0;
                profitMin = 0.0;

                ArrayList<String> month = new ArrayList<>();

                if(i == 1){
                    month = readFile.readMonthYan;
                }else if(i == 2){
                    month = readFile.readMonthFeb;
                }else if(i == 3){
                    month = readFile.readMonthMarch;
                }

            double sum = 0.0;
                while(count < month.size()){
                    if(month.get(count+1).equals("TRUE")){
                        sum += -1 * Double.parseDouble(month.get(count+2)) * Double.parseDouble(month.get(count+3));
                    } else {
                        sum += Double.parseDouble(month.get(count+2)) * Double.parseDouble(month.get(count+3));
                    }
                    count += 4;
                }
                profitMonth.put(nameMonth, sum);
                count = 0;
                profit = 0.0;
        }

        HashMap<String, Double> year = yearlyReport.year;

        for(String category : profitMonth.keySet()){

            double valueProfitMonth = profitMonth.get(category);
            double valueProfitYear = year.get(category);

            if(valueProfitMonth != valueProfitYear){
                errorMonth.add(category);
            }
        }

        if(errorMonth.size() != 0){
            result = "В месяцах "  + errorMonth.toString() + " обнаружено несоответствие." + "\n";
        }else{
            result = "Ошибок не обнаружено, операция успешно завершена." + "\n";
        }

        return result;

    }
}
