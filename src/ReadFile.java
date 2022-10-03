import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    ArrayList<String> readMonthYan = new ArrayList<>();
    ArrayList<String> readMonthFeb = new ArrayList<>();
    ArrayList<String> readMonthMarch = new ArrayList<>();
    ArrayList<String> readYear = new ArrayList<>();

    public String readFileMonthOrNull() {

        try {
            for(int i = 1; i < 4; i++) {
                List<String> list;
                switch (i){
                    case(1):
                        list = (ArrayList<String>) Files.readAllLines(Path.of("resources\\m.20210" + i + ".csv"));
                        for(int j = 1; j < list.size(); j++){
                            String[] lines = list.get(j).split(System.lineSeparator());
                            for(String line : lines){
                                String[] lineContents = line.split(",");
                                for(String contents : lineContents){
                                    readMonthYan.add(contents);
                                }
                            }
                        }
                        list.clear();
                        break;
                    case(2):
                        list = (ArrayList<String>) Files.readAllLines(Path.of("resources\\m.20210" + i + ".csv"));
                        for(int j = 1; j < list.size(); j++){
                            String[] lines = list.get(j).split(System.lineSeparator());
                            for(String line : lines){
                                String[] lineContents = line.split(",");
                                for(String contents : lineContents){
                                    readMonthFeb.add(contents);
                                }
                            }
                        }
                        list.clear();
                        break;
                    case(3):
                        list = (ArrayList<String>) Files.readAllLines(Path.of("resources\\m.20210" + i + ".csv"));
                        for(int j = 1; j < list.size(); j++){
                            String[] lines = list.get(j).split(System.lineSeparator());
                            for(String line : lines){
                                String[] lineContents = line.split(",");
                                for(String contents : lineContents){
                                    readMonthMarch.add(contents);
                                }
                            }
                        }
                        list.clear();
                        break;
                    }
                }
            return "Считывание месячных отчетов прошло успешно.";
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public String readFileYearOrNull()
    {
        try {
        List<String> list = (ArrayList<String>) Files.readAllLines(Path.of("resources\\y.2021.csv"));
        for(int i = 1; i < list.size(); i++){
            String[] lines = list.get(i).split(System.lineSeparator());
            for(String line : lines){
                String[] lineContents = line.split(",");
                for(String contents : lineContents){
                    readYear.add(contents);
                }
            }
        }
        return "Считывание годового отчета прошло успешно.";
    } catch (IOException e) {
        System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
        return null;
    }
    }
}
