package core.formatting;

import java.text.NumberFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Numbers {
    public static void main(String[] args) {
        System.out.println(NumberFormat.getInstance().format(1234567));//1,234,567
        System.out.println(NumberFormat.getInstance(Locale.US).format(1234567));
        System.out.println(NumberFormat.getCurrencyInstance().format(1234567));//RON1,234,567.00
        Locale locale = new Locale.Builder().setLanguage("fr").setRegion("DE").build();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM_dd mm<ss>a", locale);
        System.out.println(format.format(Instant.now().atZone(ZoneId.systemDefault())));
        System.out.println(NumberFormat.getCompactNumberInstance().format(1234567));//1M
        System.out.println(NumberFormat.getCompactNumberInstance().format(123_456_7.3));//1M
        System.out.println(NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(123_456_7.3));//1M
        System.out.println(NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(123_456.3));//123K
        System.out.println(NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG).format(123_456_7.3));//1 million
        System.out.println(NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG).format(123_456.3));//123 thousand


    }
}
