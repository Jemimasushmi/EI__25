import java.util.*;

interface Content {
    void show();
}

class Lesson implements Content {
    String title;
    Lesson(String t) { title = t; }
    public void show() { System.out.println("Lesson: " + title); }
}

class Module implements Content {
    String name;
    List<Content> contents = new ArrayList<>();
    Module(String n) { name = n; }
    void add(Content c) { contents.add(c); }
    public void show() {
        System.out.println("Module: " + name);
        for (Content c : contents) c.show();
    }
}

public class compositeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter module name: ");
        String moduleName = sc.nextLine();

        Module module = new Module(moduleName);

        System.out.print("How many lessons? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter lesson " + (i + 1) + " title: ");
            String lessonTitle = sc.nextLine();
            module.add(new Lesson(lessonTitle));
        }

        System.out.println("\nShowing course content:");
        module.show();
    }
}
