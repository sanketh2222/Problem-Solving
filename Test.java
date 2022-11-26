import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.lang.Math;

public class Test {
    private static Identifiers Identifier;
    private static Identifiers Identifier2;
    private static boolean matches;
    private static List<String> collect;

    private static void changeValue(int a){
        a= 10;
    }

    public static int fun(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return fun(x * x, n / 2);
        else
            return x * fun(x * x, (n - 1) / 2);
    }

    public static void main(String[] args) {
        // List<String> list = Arrays.asList("a", "b", "c", "d", "d");
        // var a =list.stream().distinct().count();
        // var b = list.size();
        // System.out.println(a==b);
        ExcelRow row = new ExcelRow("5f520d3b421eed3bc39e50ad", "U74900MH2001PTC133206", "123", null,10);
        ExcelRow row1 = new ExcelRow("5f520d3b421eed3bc39e50ad", "U27109TZ1991PTC003510", "123", "AARCA8862A",20);
        ExcelRow row2 = new ExcelRow("5f520d3b421eed3bc39e50ad", "U21029PB2014PTC038595", "", "AARCA8862A",30);
        List<ExcelRow> list = Arrays.asList(row, row1, row2);
        // System.out.println("result is "+row.equals(row1));

        Collections.sort(list, (d1, d2) -> {
            return d1.getCinNo().compareTo(d2.getCinNo());
        });

        StringBuffer buffer = new StringBuffer();
        buffer.append("sanketh");
        buffer.append(row.getPanNo() != null? row.getPanNo():"");
        buffer.append(row.getPanNo() != null? row.getGstNo():"");
        buffer.append("S");
        System.out.println(buffer.toString());
        String str = "3078ASEEN POWER PRIVATE LIMITEDAAMCA7525R27AAMCA7525R1ZV16013600000152PJSB0000017";
        String str1 = str.replaceAll("\\s+","");
        System.out.println(str1);
        //try for integers

        int[] arr = {2, 3};
        for(int a : arr){
            System.out.println(a);
        }

        // String data = "https://d1dypnimfb21ic.cloudfront.net/62e366129caba67ec8d8ffd6/AADHAAR.png";
        // //extract the png  from the url
        // String png = data.substring(data.lastIndexOf("/") + 1);
        // //extract the data after .net from the url
        // String data1 = data.substring(data.lastIndexOf(".") + 1);
        // System.out.println(data1);
        // var a  = data.lastIndexOf("62e366129caba67ec8d8ffd6");
        // System.out.println(a);
        // var result = data.substring(a);
        // System.out.println(png);

        Node node = new Node();
        node.data = 1;

        Node node2 = new Node();
        node2.data = 2;
        node.next = node2;

        //node3
        Node node3 = new Node();
        node3.data = 3;

        node2.next = node3;

        //iterate through the linked list
        Node current = node;
        while (current != null) {
            // System.out.println(current.data);
            current = current.next;
        }

        // int[] fibCache = {0};
        // // int fib[2] = {0};
        // System.out.println(fibCache.length);
        // fibCache[0] = 10;
        // fibCache[1] = 20;
        // fibCache[2] = 30;

        // for (int i : fibCache) {
        //     System.out.println(i);
        // }

        // int fibArray[] = new int[5];

        // char[] c ={'a','b'};
        // char[] a  = "jack".toCharArray();

        int a = 99;
        changeValue(a);
        // System.out.println(a);
        String dateFormatRegex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(dateFormatRegex);
        matches = pattern.matches(dateFormatRegex, "1996-08-28");
        // System.out.println(matches);
        int score = 755;
        // System.out.println(String.valueOf(score));
        String data = "Hello World";
        // System.out.println(String.valueOf(data));
    //    if (pattern.matcher(requestInfoDto.getDateOfBirth()))

        List<String> dates = new ArrayList<String>();
        collect = dates.stream().collect(Collectors.toList());

        Long b = 84630800L;
        // int a =  2147483647;
        // System.out.println(b == (38187812 * 38187812));
        // System.out.println(38187812 * 38187812);

        // System.out.println(Math.sqrt(84630800));

        double sum = 9199.499986412306 * 9199.499986412306;
        // System.out.println(sum);

        var n = list.stream().max(Comparator.comparing(ExcelRow::getValue)).get();
        // System.out.println(n.toString());

        Map<String,String> map = new HashMap<String,String>();
        map.put("Stock_Image", "Stock_Image");
        map.put("Company_Image", "Company_Image");
        map.put("Shop_Est_Certificate", "Shop_Est_Certificate");
        map.put(null,"key");
        map.put(null, "key2");

        System.out.println(map.entrySet());
        
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("Memory: Used=" + (totalMemory - freeMemory) + " Total=" + totalMemory + " Free=" + freeMemory);
      
        //
        Map<String,String> mappings = list.stream().collect(Collectors.toMap(ExcelRow::getCinNo, ExcelRow::getGstNo));
        System.out.println(mappings.entrySet());

        
        System.out.println("Memory: Used=" + (totalMemory - freeMemory) + " Total=" + totalMemory + " Free=" + freeMemory);
            
        System.out.println(2/3);

        int ans = fun(2, 10);
        System.out.println(ans);

        System.out.println(1/2);
    }
}