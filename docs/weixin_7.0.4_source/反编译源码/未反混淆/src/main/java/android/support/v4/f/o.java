package android.support.v4.f;

import java.io.PrintWriter;

public final class o {
    private static char[] LA = new char[24];
    private static final Object Lz = new Object();

    private static int a(char[] cArr, int i, char c, int i2, boolean z) {
        if (!z && i <= 0) {
            return i2;
        }
        int i3;
        int i4;
        if (i > 99) {
            i3 = i / 100;
            cArr[i2] = (char) (i3 + 48);
            i4 = i2 + 1;
            i3 = i - (i3 * 100);
        } else {
            i4 = i2;
            i3 = i;
        }
        if (i3 > 9 || i2 != i4) {
            int i5 = i3 / 10;
            cArr[i4] = (char) (i5 + 48);
            i4++;
            i3 -= i5 * 10;
        }
        cArr[i4] = (char) (i3 + 48);
        i4++;
        cArr[i4] = c;
        return i4 + 1;
    }

    private static void a(long j, PrintWriter printWriter) {
        boolean z = true;
        synchronized (Lz) {
            int a;
            if (LA.length < 0) {
                LA = new char[0];
            }
            char[] cArr = LA;
            if (j == 0) {
                cArr[0] = '0';
            } else {
                char c;
                int i;
                int i2;
                int i3;
                int i4;
                boolean z2;
                if (j > 0) {
                    c = '+';
                } else {
                    j = -j;
                    c = '-';
                }
                int i5 = (int) (j % 1000);
                int floor = (int) Math.floor((double) (j / 1000));
                if (floor > 86400) {
                    i = floor / 86400;
                    floor -= i * 86400;
                    i2 = i;
                } else {
                    i2 = 0;
                }
                if (floor > 3600) {
                    i = floor / 3600;
                    floor -= i * 3600;
                    i3 = i;
                } else {
                    i3 = 0;
                }
                if (floor > 60) {
                    i = floor / 60;
                    floor -= i * 60;
                    i4 = i;
                } else {
                    i4 = 0;
                }
                cArr[0] = c;
                i2 = a(cArr, i2, 'd', 1, false);
                i3 = a(cArr, i3, 'h', i2, i2 != 1);
                if (i3 != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i = a(cArr, i4, 'm', i3, z2);
                if (i == 1) {
                    z = false;
                }
                a = a(cArr, i5, 'm', a(cArr, floor, 's', i, z), true);
                cArr[a] = 's';
                a++;
            }
            printWriter.print(new String(LA, 0, a));
        }
    }

    public static void b(long j, PrintWriter printWriter) {
        a(j, printWriter);
    }

    public static void a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            a(j - j2, printWriter);
        }
    }
}
