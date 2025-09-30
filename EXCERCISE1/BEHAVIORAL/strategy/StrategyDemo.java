import java.util.Scanner;

interface FilterStrategy {
    void applyFilter();
}

class GrayscaleFilter implements FilterStrategy {
    public void applyFilter() { System.out.println("Applying Grayscale Filter"); }
}

class SepiaFilter implements FilterStrategy {
    public void applyFilter() { System.out.println("Applying Sepia Filter"); }
}

class ImageEditor {
    private FilterStrategy filter;
    void setFilter(FilterStrategy f) { filter = f; }
    void apply() { filter.applyFilter(); }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ImageEditor editor = new ImageEditor();

        while (true) {
            System.out.println("Choose filter: 1-Grayscale 2-Sepia 0-Exit");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) break;

            switch(choice) {
                case 1:
                    editor.setFilter(new GrayscaleFilter());
                    break;
                case 2:
                    editor.setFilter(new SepiaFilter());
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            editor.apply();
        }

        System.out.println("Exiting...");
        sc.close();
    }
}
