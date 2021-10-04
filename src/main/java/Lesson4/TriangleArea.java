package Lesson4;

import java.sql.SQLOutput;

public class TriangleArea {
    public static void main(String[] args) throws Exception {
        triangleCheck(3, 4, 5);

    }

    public static boolean triangleCheck(int a, int b, int c) {

            if ((a + b > c) && (a + c > c) && (b + c > a) && a > 0 && b > 0 && c > 0) {
                int p = (a + b + c) / 2;
                double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                return true;
            } else {
                return false;
            }

        }

}