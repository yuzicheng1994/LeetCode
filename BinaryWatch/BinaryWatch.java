import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-watch/
public class BinaryWatch {
    private List<String> result;

    private int[] hours = {1, 2, 4, 8};

    private int[] minutes = {1, 2, 4, 8, 16, 32};

    private int[] lights;

    // 暴力解法
    public List<String> readBinaryWatch1(int num) {
        result = new ArrayList<>();

        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++)
                if (Integer.bitCount(i) + Integer.bitCount(j) == num)
                    result.add(String.format("%d:%02d", i, j));
        }

        return result;
    }

    // 回溯法
    public List<String> readBinaryWatch2(int num) {
        result = new ArrayList<>();
        lights = new int[hours.length + minutes.length];

        generate(0, num, lights);

        return result;
    }

    /**
     * @param start           开始回溯的位置
     * @param remainingNumber 剩余亮灯数量
     * @param lights          存放灯的开关状况 1代表开 0代表关
     */
    private void generate(int start, int remainingNumber, int[] lights) {
        if (remainingNumber == 0) {
            int hour = hours[0] * lights[0] + hours[1] * lights[1] + hours[2] * lights[2] + hours[3] * lights[3];
            int minute = minutes[0] * lights[4] + minutes[1] * lights[5] + minutes[2] * lights[6] + minutes[3] * lights[7] +
                    minutes[4] * lights[8] + minutes[5] * lights[9];

            if (hour <= 11 && minute <= 59)
                result.add(String.format("%d:%02d", hour, minute));

            return;
        }

        for (int i = start; i < lights.length; i++) {
            lights[i] = 1;
            generate(i + 1, remainingNumber - 1, lights);
            lights[i] = 0;
        }
    }
}