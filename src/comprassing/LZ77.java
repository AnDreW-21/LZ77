package comprassing;
import java.lang.*;
import java.util.ArrayList;
import static java.lang.Math.abs;
public class LZ77 {
    protected String statement;
    protected ArrayList<Character> chars = new ArrayList<Character>();
    protected StringBuilder str = new StringBuilder();
    protected ArrayList<Integer> positions = new ArrayList<Integer>();
    protected ArrayList<Integer> lengths = new ArrayList<Integer>();
    private int len;
    public void setStatement(String statement) {
        this.statement = statement;
        this.len = statement.length();
    }
    public String getStatement() {
        return statement;
    }
    public void compressing() {
        for (int j = 0; j < len - 1; j++) {
            boolean check = false;
            StringBuilder sub = new StringBuilder();
            int length = 0, position = 0, index = 0;
            for (int i = 0; i <= j; i++) {
               if (!(j < len)) {
                    chars.add((' '));
                   position = (abs(j - length) - (index));
                    positions.add(position);
                    lengths.add(length);
                    check = true;
                    break;
                } else {
                    sub.append(statement.charAt(j));
                    String cont = statement.substring(0, (j));
                    if (cont.contains(sub)) {
                        length++;
                        index = statement.indexOf(String.valueOf(sub));
                        j++;

                    } else {
                        if(length!=0){
                            position = (abs(j - length) - (index));
                        }
                        chars.add(statement.charAt(j));
                        positions.add(position);
                        lengths.add(length);
                        break;

                    }
                }
            }
            if (check) {
                break;
            }
        }
    }
    public void decompressing() {
        for (int i = 0; i < chars.size(); i++) {
            int y = positions.get(i), count=0;
            for (int x = lengths.get(i); x >= 0; x--) {
                count = str.length();
                if (x == 0) {
                     str.append(chars.get(i));
                } else {
                        str.append(str.charAt(abs(count - y)));
                }
            }
        }
        System.out.println(str);
    }
    public void printCompressing() {
        for (int i = 0; i < chars.size(); i++) {
            System.out.println("tag" + (i + 1) + ":");
            System.out.print("< " + positions.get(i));
            System.out.print(", " + lengths.get(i));
            System.out.println(", " + chars.get(i) + ">");
        }
    }
}
