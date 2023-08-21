package zad6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sheet {
    private Cell[][] cells;

    public Sheet(int row, int col) {
        cells = new Cell[col][row];

        for (int i = 0; i < col; i++)
            for (int j = 0; j < row; j++)
                cells[i][j] = new Cell();

    }

    public Cell cell(String ref) {
        Cell[] column = cells[ref.charAt(0) - 'A'];
        Cell cell = column[ref.charAt(1) - '1'];

        return cell;
    }

    public void set(String ref, String content) {
        Cell current = cell(ref);
        for (Cell c : getrefs(current)) {
            ReferencedCellObserver o = current.getOtherCellSubscriptions().get(c);
            c.removeObserver(o);
            current.removeOtherCellSubscription(c);

        }

        current.setContent(content);

        for (Cell c : getrefs(current))
            if (getrefs(c).contains(current))
                throw new RuntimeException("Circular dependency detected");

        for (Cell c : getrefs(current)) {
            ReferencedCellObserver o = new ReferencedCellObserver();
            c.registerObserver(o, current);
            current.getOtherCellSubscriptions().put(c, o);

        }

        evaluate(current);
    }

    public List<Cell> getrefs(Cell cell) {
        ArrayList<Cell> refs = new ArrayList<>();

        String regex = "[A-Z][0-9]";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(cell.getExp());

        while (matcher.find()) {
            refs.add(cell(matcher.group()));
        }

        return refs;
    }

    public double evaluate(Cell cell) {
        double sum = 0;

        try {
            for (Cell c : getrefs(cell))
                sum += c.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String regex = "^[0-9]|\\+[0-9]+";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(cell.getExp());

        while (matcher.find()) {
            sum += Double.parseDouble(matcher.group());
        }
        cell.setValue(sum);
        cell.getObservers().keySet().forEach(o -> o.notifyUpdated(cell.getObservers().get(o), this));
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---START---\n");
        for (Cell[] column : cells) {
            for (Cell cell : column)
                sb.append(" " + cell + " ");

            sb.append("\n");

        }
        sb.append("---END---");

        return sb.toString();
    }

    public static void main(String[] args) {
        Sheet s = new Sheet(5, 5);

        System.out.println(s);

        s.set("A3", "A1+A2");
        s.set("A1", "2");
        s.set("A2", "5");
        

        System.out.println(s);

        s.set("A1", "B1+5");
        s.set("A4", "A1+A3");
        s.set("B1", "2");

        System.out.println(s);

        s.set("A1", "A3");

        System.out.println(s);

        try {
            System.out.println(s.getrefs(s.cell("A4")));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}