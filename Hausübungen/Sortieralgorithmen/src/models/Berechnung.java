package models;

import java.util.ArrayList;
import java.util.List;

public class Berechnung {

    private static final int nameFormatWidth = -15;
    private static final int solutionFormatWidth = 30;
    public static String compare(int minRange, int maxRange, int rounds, int elements, ISortierung... sorts) throws ClassNotFoundException
    {
        StringBuffer solutions = new StringBuffer();
        for(ISortierung sort : sorts)
        {
            solutions.append(compare(minRange, maxRange, rounds, elements, sort));
        }
        return solutions.toString();
    }
    private static String compare(int minRange, int maxRange, int rounds, int elements, ISortierung sort) throws ClassNotFoundException {
        StringBuffer solution = new StringBuffer();

        long[] vergleiche = new long[rounds];
        long[] vertauschungen = new long[rounds];
        long[] zeit = new long[rounds];
        final long startTime = System.nanoTime();
        List<Integer> values;
        for (int i = 0; i < rounds; i++) {
            values = new ArrayList<Integer>();
            for (int j = 0; j < elements; j++) {
                values.add((int) (Math.random() * (maxRange - minRange) + minRange));
            }
            sort.Sortierung(values);
            vergleiche[i] = (long) sort.getVergleiche().getZaehler();
            vertauschungen[i] = (long) sort.getVertauschungen().getZaehler();
            zeit[i] = (long) sort.getZeit().getZaehler();
        }
        solution.append(sort.getName() + '\n');
        solution.append(format("Compare-average","" + format(average(vergleiche))) + " processes\n");
        solution.append(format("Compare-median","" + format(median(vergleiche))) + " processes\n");
        solution.append(format("Swap-average","" + format(average(vertauschungen))) + " processes\n");
        solution.append(format("Swap-median","" + format(median(vertauschungen))) + " processes\n");
        solution.append(format("Time-average","" + format(average(zeit))) + " nanoseconds\n");
        solution.append(format("Time-median","" + format(median(zeit))) + " nanoseconds\n");
        return solution.toString() + '\n';

    }

    public static double average(long[] values)
    {
        double solution= 0;
        for(long value:values)
        {
            solution = solution + value;
        }
        return solution/values.length;
    }
    public static double median(long[] values)
    {
        if(values.length <= 0)
        {
            return  0;
        }
        double solution = values.length % 2 == 0 ?
                (double) (values[values.length/ 2-1] + values[values.length/2])/2 :values [values.length/2];
        return solution;
    }
    private static String format(double value){
        return String.format("%,.2f", value);
    }

    private static String format(String text, int width, boolean direction){
        return String.format("%" + width + "s", text);
    }

    private static String format(String name, String solution){
        return format(name, nameFormatWidth,false) + format(solution, solutionFormatWidth,true);
    }

}
