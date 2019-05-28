package android.support.p069v7.p071c.p072a;

import java.lang.reflect.Array;

/* renamed from: android.support.v7.c.a.c */
final class C0590c {
    static final /* synthetic */ boolean $assertionsDisabled = (!C0590c.class.desiredAssertionStatus());

    /* renamed from: a */
    public static <T> T[] m1279a(T[] tArr, int i, T t) {
        if ($assertionsDisabled || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), C0590c.m1280bl(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static int[] m1281c(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[C0590c.m1280bl(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    /* renamed from: bl */
    private static int m1280bl(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    private C0590c() {
    }
}
