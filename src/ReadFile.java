import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadFile {

    HashMap<Integer, String> months = new HashMap<>();
    ArrayList<String> readMonthYan = new ArrayList<>();
    ArrayList<String> readMonthFeb = new ArrayList<>();
    ArrayList<String> readMonthMarch = new ArrayList<>();
    ArrayList<String> readYear = new ArrayList<>();

    boolean chekingExecutionMonth;
    boolean chekingExecutionYear;

    public String readFileMonthOrNull(String path) {

        for(int i = 1; i < 4; i++){
            switch (i) {
                case 1:
                    months.put(i, "Январь");
                    break;
                case 2:
                    months.put(i, "Февраль");
                    break;
                case 3:
                    months.put(i, "Март");
                    break;
            }
        }

        try {
            String check = "";
            for(Integer i : months.keySet()) {
                if(Files.exists(Path.of(path + File.separator + "m.20210" + i + ".csv"))){
                    List<String> list;
                    list = Files.readAllLines(Path.of(path + File.separator + "m.20210" + i + ".csv"));
                    for (int j = 1; j < list.size(); j++) {
                        String[] lines = list.get(j).split(System.lineSeparator());
                        for (String line : lines) {
                            String[] lineContents = line.split(",");
                            for (String contents : lineContents) {
                                if(i == 1){
                                    readMonthYan.add(contents);
                                }else if(i == 2){
                                    readMonthFeb.add(contents);
                                } else if(i == 3){
                                    readMonthMarch.add(contents);
                                }
                            }
                        }
                    }
                    list.clear();
                    check =  "Считывание месячных отчетов прошло успешно.";
                    chekingExecutionMonth = true;
                } else {
                    check = "Файл не находится в нужной директории.";
                    chekingExecutionMonth = false;
                }
            }
            return check;
        } catch (IOException e) {
            return "Невозможно прочитать файл с месячным отчётом.";
        }
    }

    public String readFileYearOrNull(String path) {
        try {
            String check = "";
            if(Files.exists(Path.of(path + File.separator + "y.2021.csv"))){
                List<String> list = Files.readAllLines(Path.of(path + File.separator + "y.2021.csv"));
                for(int i = 1; i < list.size(); i++){
                    String[] lines = list.get(i).split(System.lineSeparator());
                    for (String line : lines){
                        readYear.add(line);
                    }
                }
                check = "Считывание годового отчета прошло успешно.";
                chekingExecutionYear = true;
            }else {
                check = "Файл не находится в нужной директории.";
            }
        return check;
    } catch (IOException e) {
        return "Невозможно прочитать файл с годовым отчётом.";
    }
    }

}
