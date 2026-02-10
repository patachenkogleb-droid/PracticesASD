abstract class ReportGenerator {
    public final void generate() {
        System.out.println("Starting report generation.");
        collectData();
        formatReport();
        System.out.println("Report finished.");
    }

    protected abstract void collectData();
    protected abstract void formatReport();
}

class DailyReport extends ReportGenerator {
    @Override
    protected void collectData() {
        System.out.println("Collecting data for today");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting into PDF");
    }
}

public class Task2 {
    public static void main(String[] args) {
        ReportGenerator report = new DailyReport();
        report.generate();
    }
}