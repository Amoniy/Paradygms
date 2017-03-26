package Paradygms;

//javac Paradygms\Paradygms.Sum.java
//java Paradygms.Paradygms.Sum
public class Sum {
    public static void main(String[] args) {
        String fin = "";
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            fin = args[i] + " ";
            String[] temp = fin.split("\\p{javaWhitespace}");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].length() > 0) {
                    sum += Integer.parseInt(temp[j]);
                }
            }
        }
        System.out.print(sum);
    }
}
