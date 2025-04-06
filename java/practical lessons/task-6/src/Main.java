import java.io.*;
import java.util.*;


class Line
{
    Integer x = 0;
    Integer y = 0;
    Integer x1 = 0;
    Integer y1= 0;
    double k = Double.valueOf(1);
    double b = Double.valueOf(0);
    Line(Integer X, Integer Y, Integer X1, Integer Y1)
    {
        x = X;
        y = Y;
        x1 = X1;
        y1 = Y1;
        k = (double)(Y1 - Y)/(X1 - X);
        b = Y - X * k;
    }
    public static void Sol(Line d1, Line d2)
    {
        if(d1.k == d2.k && d1.b != d2.b)
        {
            System.out.println("line 1: y = " + d1.k + "x + " + d1.b + "; line 2: y = " + d2.k + "x + " + d2.b + "; are ||");
        }
        else if(d1.k == d2.k && d1.b == d2.b)
        {
            System.out.println("line 1: y = " + d1.k + "x + " + d1.b + "; line 2: y = " + d2.k + "x + " + d2.b + "; are equal");
        }
        else
        {
            double x = (d2.b - d1.b)/(d1.k - d2.k);
            double y = x * d1.k + d1.b;
            System.out.println("line 1: y = " + d1.k + "x + " + d1.b + "; line 2: y = " + d2.k + "x + " + d2.b + "; (" + x + "; " + y + ")");
        }
        return;
    }
}

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer, Line> map = new TreeMap<>();
        ArrayList<Line> Lines = new ArrayList<Line>();
        Integer x1, y1, x2, y2;
        int i = 0;
        try(FileReader reader = new FileReader("file.txt"))
        {
            Scanner scan = new Scanner(reader);
            while(scan.hasNextLine())
            {
                x1 = scan.nextInt();
                y1 = scan.nextInt();
                x2 = scan.nextInt();
                y2 = scan.nextInt();
                Lines.add(new Line(x1, y1, x2, y2));
                i++;
                map.put(i, Lines.get(i - 1));
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        /*for(int k = 0; k < Lines.size() - 1; k++)
        {
            for(int m = k + 1; m < Lines.size(); m++)
            {
                Lines.get(k).Sol(Lines.get(k), Lines.get(m));
            }
        }*/
        for(int k = 1; k < map.size(); k++)
        {
            for(int m = k + 1; m <= map.size(); m++)
            {
                map.get(k).Sol(map.get(k), map.get(m));
            }
        }
    }
}
