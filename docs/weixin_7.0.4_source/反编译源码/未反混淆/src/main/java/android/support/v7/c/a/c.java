package android.support.v7.c.a;

import java.lang.reflect.Array;

final class c {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());

    public static <T> T[] a(T[] tArr, int i, T t) {
        if ($assertionsDisabled || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bl(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static int[] c(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[bl(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    private static int bl(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    private c() {
    }
}
