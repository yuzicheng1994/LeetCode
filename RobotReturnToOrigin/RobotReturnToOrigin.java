//https://leetcode-cn.com/problems/robot-return-to-origin/
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int landscape = 0;
        int portrait = 0;
        for (int i = 0; i < moves.length(); i++) {
            char cur = moves.charAt(i);
            if (cur == 'U') {
                landscape++;
            } else if (cur == 'D') {
                landscape--;
            } else if (cur == 'R') {
                portrait++;
            } else {
                portrait--;
            }
        }

        if (landscape == 0 && portrait == 0)
            return true;
        return false;
    }
}
