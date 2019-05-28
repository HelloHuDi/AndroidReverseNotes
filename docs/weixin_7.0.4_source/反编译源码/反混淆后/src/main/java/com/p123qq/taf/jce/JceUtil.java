package com.p123qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qq.taf.jce.JceUtil */
public final class JceUtil {
    private static final byte[] highDigits;
    private static final int iConstant = 37;
    private static final int iTotal = 17;
    private static final byte[] lowDigits;

    public static boolean equals(boolean z, boolean z2) {
        return z == z2;
    }

    public static boolean equals(byte b, byte b2) {
        return b == b2;
    }

    public static boolean equals(char c, char c2) {
        return c == c2;
    }

    public static boolean equals(short s, short s2) {
        return s == s2;
    }

    public static boolean equals(int i, int i2) {
        return i == i2;
    }

    public static boolean equals(long j, long j2) {
        return j == j2;
    }

    public static boolean equals(float f, float f2) {
        return f == f2;
    }

    public static boolean equals(double d, double d2) {
        return d == d2;
    }

    public static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.m2504i(117086);
        boolean equals = obj.equals(obj2);
        AppMethodBeat.m2505o(117086);
        return equals;
    }

    public static int compareTo(boolean z, boolean z2) {
        int i = 1;
        int i2 = z ? 1 : 0;
        if (!z2) {
            i = 0;
        }
        return i2 - i;
    }

    public static int compareTo(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b > b2 ? 1 : 0;
    }

    public static int compareTo(char c, char c2) {
        if (c < c2) {
            return -1;
        }
        return c > c2 ? 1 : 0;
    }

    public static int compareTo(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s > s2 ? 1 : 0;
    }

    public static int compareTo(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int compareTo(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static int compareTo(float f, float f2) {
        if (f < f2) {
            return -1;
        }
        return f > f2 ? 1 : 0;
    }

    public static int compareTo(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        return d > d2 ? 1 : 0;
    }

    public static <T extends Comparable<T>> int compareTo(T t, T t2) {
        AppMethodBeat.m2504i(117087);
        int compareTo = t.compareTo(t2);
        AppMethodBeat.m2505o(117087);
        return compareTo;
    }

    public static <T extends Comparable<T>> int compareTo(List<T> list, List<T> list2) {
        int compareTo;
        AppMethodBeat.m2504i(117088);
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            compareTo = ((Comparable) it.next()).compareTo((Comparable) it2.next());
            if (compareTo != 0) {
                AppMethodBeat.m2505o(117088);
                return compareTo;
            }
        }
        compareTo = JceUtil.compareTo(it.hasNext(), it2.hasNext());
        AppMethodBeat.m2505o(117088);
        return compareTo;
    }

    public static <T extends Comparable<T>> int compareTo(T[] tArr, T[] tArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117089);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= tArr.length || i2 >= tArr2.length) {
                i2 = JceUtil.compareTo(tArr.length, tArr2.length);
                AppMethodBeat.m2505o(117089);
            } else {
                i = tArr[i3].compareTo(tArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117089);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(tArr.length, tArr2.length);
        AppMethodBeat.m2505o(117089);
        return i2;
    }

    public static int compareTo(boolean[] zArr, boolean[] zArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117090);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= zArr.length || i2 >= zArr2.length) {
                i2 = JceUtil.compareTo(zArr.length, zArr2.length);
                AppMethodBeat.m2505o(117090);
            } else {
                i = JceUtil.compareTo(zArr[i3], zArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117090);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(zArr.length, zArr2.length);
        AppMethodBeat.m2505o(117090);
        return i2;
    }

    public static int compareTo(byte[] bArr, byte[] bArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117091);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= bArr.length || i2 >= bArr2.length) {
                i2 = JceUtil.compareTo(bArr.length, bArr2.length);
                AppMethodBeat.m2505o(117091);
            } else {
                i = JceUtil.compareTo(bArr[i3], bArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117091);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(bArr.length, bArr2.length);
        AppMethodBeat.m2505o(117091);
        return i2;
    }

    public static int compareTo(char[] cArr, char[] cArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117092);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= cArr.length || i2 >= cArr2.length) {
                i2 = JceUtil.compareTo(cArr.length, cArr2.length);
                AppMethodBeat.m2505o(117092);
            } else {
                i = JceUtil.compareTo(cArr[i3], cArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117092);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(cArr.length, cArr2.length);
        AppMethodBeat.m2505o(117092);
        return i2;
    }

    public static int compareTo(short[] sArr, short[] sArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117093);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= sArr.length || i2 >= sArr2.length) {
                i2 = JceUtil.compareTo(sArr.length, sArr2.length);
                AppMethodBeat.m2505o(117093);
            } else {
                i = JceUtil.compareTo(sArr[i3], sArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117093);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(sArr.length, sArr2.length);
        AppMethodBeat.m2505o(117093);
        return i2;
    }

    public static int compareTo(int[] iArr, int[] iArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117094);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= iArr.length || i2 >= iArr2.length) {
                i2 = JceUtil.compareTo(iArr.length, iArr2.length);
                AppMethodBeat.m2505o(117094);
            } else {
                i = JceUtil.compareTo(iArr[i3], iArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117094);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(iArr.length, iArr2.length);
        AppMethodBeat.m2505o(117094);
        return i2;
    }

    public static int compareTo(long[] jArr, long[] jArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117095);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= jArr.length || i2 >= jArr2.length) {
                i2 = JceUtil.compareTo(jArr.length, jArr2.length);
                AppMethodBeat.m2505o(117095);
            } else {
                i = JceUtil.compareTo(jArr[i3], jArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117095);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(jArr.length, jArr2.length);
        AppMethodBeat.m2505o(117095);
        return i2;
    }

    public static int compareTo(float[] fArr, float[] fArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117096);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= fArr.length || i2 >= fArr2.length) {
                i2 = JceUtil.compareTo(fArr.length, fArr2.length);
                AppMethodBeat.m2505o(117096);
            } else {
                i = JceUtil.compareTo(fArr[i3], fArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117096);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(fArr.length, fArr2.length);
        AppMethodBeat.m2505o(117096);
        return i2;
    }

    public static int compareTo(double[] dArr, double[] dArr2) {
        int i = 0;
        AppMethodBeat.m2504i(117097);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= dArr.length || i2 >= dArr2.length) {
                i2 = JceUtil.compareTo(dArr.length, dArr2.length);
                AppMethodBeat.m2505o(117097);
            } else {
                i = JceUtil.compareTo(dArr[i3], dArr2[i2]);
                if (i != 0) {
                    AppMethodBeat.m2505o(117097);
                    return i;
                }
                i = i3 + 1;
                i2++;
            }
        }
        i2 = JceUtil.compareTo(dArr.length, dArr2.length);
        AppMethodBeat.m2505o(117097);
        return i2;
    }

    public static int hashCode(boolean z) {
        return (z ? 0 : 1) + 629;
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr == null) {
            return 629;
        }
        int i = 17;
        for (boolean z : zArr) {
            i = (z ? 0 : 1) + (i * 37);
        }
        return i;
    }

    public static int hashCode(byte b) {
        return b + 629;
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 629;
        }
        int i = 17;
        for (byte b : bArr) {
            i = (i * 37) + b;
        }
        return i;
    }

    public static int hashCode(char c) {
        return c + 629;
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 629;
        }
        int i = 17;
        for (char c : cArr) {
            i = (i * 37) + c;
        }
        return i;
    }

    public static int hashCode(double d) {
        AppMethodBeat.m2504i(117098);
        int hashCode = JceUtil.hashCode(Double.doubleToLongBits(d));
        AppMethodBeat.m2505o(117098);
        return hashCode;
    }

    public static int hashCode(double[] dArr) {
        AppMethodBeat.m2504i(117099);
        if (dArr == null) {
            AppMethodBeat.m2505o(117099);
            return 629;
        }
        int i = 17;
        for (int i2 = 0; i2 < dArr.length; i2++) {
            i = (i * 37) + ((int) (Double.doubleToLongBits(dArr[i2]) ^ (Double.doubleToLongBits(dArr[i2]) >> 32)));
        }
        AppMethodBeat.m2505o(117099);
        return i;
    }

    public static int hashCode(float f) {
        AppMethodBeat.m2504i(117100);
        int floatToIntBits = Float.floatToIntBits(f) + 629;
        AppMethodBeat.m2505o(117100);
        return floatToIntBits;
    }

    public static int hashCode(float[] fArr) {
        AppMethodBeat.m2504i(117101);
        if (fArr == null) {
            AppMethodBeat.m2505o(117101);
            return 629;
        }
        int i = 17;
        for (float floatToIntBits : fArr) {
            i = (i * 37) + Float.floatToIntBits(floatToIntBits);
        }
        AppMethodBeat.m2505o(117101);
        return i;
    }

    public static int hashCode(short s) {
        return s + 629;
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 629;
        }
        int i = 17;
        for (short s : sArr) {
            i = (i * 37) + s;
        }
        return i;
    }

    public static int hashCode(int i) {
        return i + 629;
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 : iArr) {
            i = (i * 37) + i2;
        }
        return i;
    }

    public static int hashCode(long j) {
        return ((int) ((j >> 32) ^ j)) + 629;
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null) {
            return 629;
        }
        int i = 17;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            i = (i * 37) + ((int) (jArr[i2] ^ (jArr[i2] >> 32)));
        }
        return i;
    }

    public static int hashCode(JceStruct[] jceStructArr) {
        AppMethodBeat.m2504i(117102);
        if (jceStructArr == null) {
            AppMethodBeat.m2505o(117102);
            return 629;
        }
        int i = 17;
        for (Object hashCode : jceStructArr) {
            i = (i * 37) + hashCode.hashCode();
        }
        AppMethodBeat.m2505o(117102);
        return i;
    }

    public static int hashCode(Object obj) {
        AppMethodBeat.m2504i(117103);
        Object obj2 = obj;
        while (obj2 != null) {
            int hashCode;
            if (obj2.getClass().isArray()) {
                if (obj2 instanceof long[]) {
                    hashCode = JceUtil.hashCode((long[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof int[]) {
                    hashCode = JceUtil.hashCode((int[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof short[]) {
                    hashCode = JceUtil.hashCode((short[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof char[]) {
                    hashCode = JceUtil.hashCode((char[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof byte[]) {
                    hashCode = JceUtil.hashCode((byte[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof double[]) {
                    hashCode = JceUtil.hashCode((double[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof float[]) {
                    hashCode = JceUtil.hashCode((float[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof boolean[]) {
                    hashCode = JceUtil.hashCode((boolean[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else if (obj2 instanceof JceStruct[]) {
                    hashCode = JceUtil.hashCode((JceStruct[]) obj2);
                    AppMethodBeat.m2505o(117103);
                    return hashCode;
                } else {
                    Object[] obj22 = (Object[]) obj22;
                }
            } else if (obj22 instanceof JceStruct) {
                hashCode = obj22.hashCode();
                AppMethodBeat.m2505o(117103);
                return hashCode;
            } else {
                hashCode = obj22.hashCode() + 629;
                AppMethodBeat.m2505o(117103);
                return hashCode;
            }
        }
        AppMethodBeat.m2505o(117103);
        return 629;
    }

    public static byte[] getJceBufArray(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(117104);
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        AppMethodBeat.m2505o(117104);
        return bArr;
    }

    static {
        byte[] bArr = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        highDigits = bArr2;
        lowDigits = bArr3;
    }

    public static String getHexdump(byte[] bArr) {
        AppMethodBeat.m2504i(117105);
        String hexdump = JceUtil.getHexdump(ByteBuffer.wrap(bArr));
        AppMethodBeat.m2505o(117105);
        return hexdump;
    }

    public static String getHexdump(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(117106);
        int remaining = byteBuffer.remaining();
        String str;
        if (remaining == 0) {
            str = "empty";
            AppMethodBeat.m2505o(117106);
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer((byteBuffer.remaining() * 3) - 1);
        int position = byteBuffer.position();
        int i = byteBuffer.get() & 255;
        stringBuffer.append((char) highDigits[i]);
        stringBuffer.append((char) lowDigits[i]);
        for (remaining--; remaining > 0; remaining--) {
            stringBuffer.append(' ');
            i = byteBuffer.get() & 255;
            stringBuffer.append((char) highDigits[i]);
            stringBuffer.append((char) lowDigits[i]);
        }
        byteBuffer.position(position);
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(117106);
        return str;
    }
}
