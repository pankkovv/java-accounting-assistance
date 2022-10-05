import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReadFile readFile = new ReadFile();

        DataReconciliation dataReconciliation = new DataReconciliation();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        boolean chekingMonth = false;
        boolean chekingYear = false;

        System.out.println("Здравствуйте! Введите путь до папки, где хранятся месячные и годовые отчеты:");
        String path =  scanner.next();
        System.out.println("Выберете команду:");
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0){
            int command = userInput;
            switch (command) {
            case 1:
                System.out.println(readFile.readFileMonthOrNull(path));
                chekingMonth = readFile.chekingExecutionMonth;
                System.out.println();
                break;
            case 2:
                System.out.println(readFile.readFileYearOrNull(path));
                chekingYear = readFile.chekingExecutionYear;
                System.out.println();
                break;
            case 3:
                if(chekingMonth && chekingYear) {
                    System.out.println(dataReconciliation.reconciliation(path));
                }else{
                    System.out.println("Сначала необходимо считать месячные и годовые отчеты." + "\n");
                }
                break;
            case 4:
                if(chekingMonth) {
                    System.out.println(monthlyReport.processingMonth(path));
                }else{
                    System.out.println("Сначала необходимо считать месячные отчеты." + "\n");
                }
                break;
            case 5:
                if(chekingYear) {
                    System.out.println(yearlyReport.processingYear(path));
                }else{
                    System.out.println("Сначала необходимо считать годовой отчет." + "\n");
                }
                break;
            case 0000:
                return;
            default:
                System.out.println("Такого значние не существует, попробуйте еще раз.");
                break;
        }
        printMenu();
        userInput = scanner.nextInt();
    }

    }

    public static void printMenu() {
        while(true) {
            System.out.println("1- Считать все месячные отчёты");
            System.out.println("2- Считать годовой отчёт");
            System.out.println("3 -Сверить отчёты");
            System.out.println("4- Вывести информацию о всех месячных отчётах");
            System.out.println("5- Вывести информацию о годовом отчёте");
            System.out.println("0000- Выход");
            break;
        }
    }
}


