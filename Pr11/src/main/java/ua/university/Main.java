package ua.university;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BookStream bstream = new BookStream();

        System.out.println("\nTask 1");
        System.out.println(bstream.stream1());

        System.out.println("\nTask 2");
        System.out.println(bstream.stream2());
        System.out.println(bstream.tagFrequency());
        int n = 2;
        System.out.println(bstream.topNTags(n));

        System.out.println("\nTask 3");
        SaleStream saleStream = new SaleStream();
        System.out.println(saleStream.getRevenueByProduct());
        System.out.println(saleStream.getTransactionsByCustomer());

        System.out.println("\nTask 4");
        ResultLab resultLab = new ResultLab();
        System.out.println(resultLab.getSuccessCount());
        System.out.println(resultLab.getFailureCount());
        System.out.println(resultLab.getErrorMessages());

        System.out.println("\nTask 5");
        Map<Boolean, List<BookStream.Book>> recentVsOld = bstream.partitionBooks();
        System.out.println(recentVsOld);
        System.out.println(saleStream.getSortedRevenueByProduct());
    }
}