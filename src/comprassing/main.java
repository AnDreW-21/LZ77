package comprassing;
public class main {
    public static void main(String[] args) {
        System.out.println();
        LZ77 obj = new LZ77();
        obj.setStatement("ABAABABABBBBBA");
        System.out.println("compressing: ");
        obj.compressing();
        obj.printCompressing();
        System.out.println("Decompressing: ");
        obj.decompressing();
    }
}
