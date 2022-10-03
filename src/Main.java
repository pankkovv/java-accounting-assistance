import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReadFile readFile = new ReadFile();

        DataReconciliation dataReconciliation = new DataReconciliation();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        System.out.println("Здравствуйте! Выберете команду:");
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0){
            int command = userInput;

            switch (command) {
            case (1):
                  System.out.println(readFile.readFileMonthOrNull());
                  System.out.println();
                break;
            case (2):
                System.out.println(readFile.readFileYearOrNull());
                System.out.println();
                break;
            case (3):
                dataReconciliation.reconciliation();
                break;
            case (4):
                System.out.println(monthlyReport.processingMonth());
                break;
            case (5):
                System.out.println(yearlyReport.processingYear());
                break;
            case (0000):
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


