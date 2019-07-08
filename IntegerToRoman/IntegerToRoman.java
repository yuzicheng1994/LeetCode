//https://leetcode-cn.com/problems/integer-to-roman/
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int temp = num % 10;
        int power = 1;

        while (num != 0) {
            if (temp >= 1 && temp <= 9) {
                if (temp == 4)
                    result.insert(0, "IV");
                else if (temp == 9)
                    result.insert(0, "IX");
                else if (temp <= 3) {
                    for (int i = temp; i > 0; i--)
                        result.insert(0, "I");
                } else {
                    for (int i = temp - 5; i > 0; i--)
                        result.insert(0, "I");
                    result.insert(0, "V");
                }
            } else if (temp >= 10 && temp <= 90) {
                if (temp == 40)
                    result.insert(0, "XL");
                else if (temp == 90)
                    result.insert(0, "XC");
                else if (temp <= 30) {
                    for (int i = temp / 10; i > 0; i--)
                        result.insert(0, "X");
                } else {
                    for (int i = (temp - 50) / 10; i > 0; i--)
                        result.insert(0, "X");
                    result.insert(0, "L");
                }
            } else if (temp >= 100 && temp <= 900) {
                if (temp == 400)
                    result.insert(0, "CD");
                else if (temp == 900)
                    result.insert(0, "CM");
                else if (temp <= 300) {
                    for (int i = temp / 100; i > 0; i--)
                        result.insert(0, "C");
                } else {
                    for (int i = (temp - 500) / 100; i > 0; i--)
                        result.insert(0, "C");
                    result.insert(0, "D");
                }
            } else if (temp >= 1000) {
                for (int i = temp / 1000; i > 0; i--)
                    result.insert(0, "M");
            }
            num = num / 10;
            temp = num % 10 * (int) Math.pow(10, power++);
        }

        return result.toString();
    }
}