import exceptionsGen.NullPointerExceptionGenerator;

public class App {
    public static void main(String[] args) {
        try {
            NullPointerExceptionGenerator.raiseNullPointerException();
        } catch (NullPointerException e){
            System.out.println("Złapano NullPointerException");
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
