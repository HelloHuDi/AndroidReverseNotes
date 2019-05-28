package android.support.p057v4.p065f;

import java.io.PrintWriter;

/* renamed from: android.support.v4.f.o */
public final class C25336o {
    /* renamed from: LA */
    private static char[] f5150LA = new char[24];
    /* renamed from: Lz */
    private static final Object f5151Lz = new Object();

    /* renamed from: a */
    private static int m39981a(char[] cArr, int i, char c, int i2, boolean z) {
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

    /* renamed from: a */
    private static void m39983a(long j, PrintWriter printWriter) {
        boolean z = true;
        synchronized (f5151Lz) {
            int a;
            if (f5150LA.length < 0) {
                f5150LA = new char[0];
            }
            char[] cArr = f5150LA;
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
                i2 = C25336o.m39981a(cArr, i2, 'd', 1, false);
                i3 = C25336o.m39981a(cArr, i3, 'h', i2, i2 != 1);
                if (i3 != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i = C25336o.m39981a(cArr, i4, 'm', i3, z2);
                if (i == 1) {
                    z = false;
                }
                a = C25336o.m39981a(cArr, i5, 'm', C25336o.m39981a(cArr, floor, 's', i, z), true);
                cArr[a] = 's';
                a++;
            }
            printWriter.print(new String(f5150LA, 0, a));
        }
    }

    /* renamed from: b */
    public static void m39984b(long j, PrintWriter printWriter) {
        C25336o.m39983a(j, printWriter);
    }

    /* renamed from: a */
    public static void m39982a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            C25336o.m39983a(j - j2, printWriter);
        }
    }
}
