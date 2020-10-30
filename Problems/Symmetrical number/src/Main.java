import java.util.Scanner;

class Main {
    static boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {

            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);

        String str = s.next();
        if (isPalindrome(str))
            System.out.print(1);
        else
            System.out.print(37);
    }
}