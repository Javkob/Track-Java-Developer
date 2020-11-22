import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> arrayList = new ArrayList<>();

        while (true) {
            String input = scanner.next();
            try {
                if(!input.equals("0") ){
                    arrayList.add(Integer.parseInt(input) * 10);
                }
            } catch (NumberFormatException e) {
                arrayList.add("Invalid user input: " + input);
            }
            if(input.equals("0")){
                break;
            }
        }
        for (Object a:arrayList) {
            System.out.println(a);
        }
    }
}