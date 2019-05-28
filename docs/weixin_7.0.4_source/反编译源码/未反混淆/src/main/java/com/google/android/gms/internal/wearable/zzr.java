package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzr {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Object zzhk = new Object();

    static {
        AppMethodBeat.i(70775);
        AppMethodBeat.o(70775);
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(70769);
        if (fArr != null && fArr.length != 0) {
            boolean equals = Arrays.equals(fArr, fArr2);
            AppMethodBeat.o(70769);
            return equals;
        } else if (fArr2 == null || fArr2.length == 0) {
            AppMethodBeat.o(70769);
            return true;
        } else {
            AppMethodBeat.o(70769);
            return false;
        }
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        AppMethodBeat.i(70768);
        if (jArr != null && jArr.length != 0) {
            boolean equals = Arrays.equals(jArr, jArr2);
            AppMethodBeat.o(70768);
            return equals;
        } else if (jArr2 == null || jArr2.length == 0) {
            AppMethodBeat.o(70768);
            return true;
        } else {
            AppMethodBeat.o(70768);
            return false;
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        AppMethodBeat.i(70770);
        boolean length = objArr == null ? false : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (z >= length || objArr[z] != null) {
                int i2 = i;
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z2 = z >= length;
                boolean z3 = i2 >= length2;
                if (z2 && z3) {
                    AppMethodBeat.o(70770);
                    return true;
                } else if (z2 != z3) {
                    AppMethodBeat.o(70770);
                    return false;
                } else if (objArr[z].equals(objArr2[i2])) {
                    i = i2 + 1;
                    z++;
                } else {
                    AppMethodBeat.o(70770);
                    return false;
                }
            }
            z++;
        }
    }

    public static int hashCode(float[] fArr) {
        AppMethodBeat.i(70772);
        if (fArr == null || fArr.length == 0) {
            AppMethodBeat.o(70772);
            return 0;
        }
        int hashCode = Arrays.hashCode(fArr);
        AppMethodBeat.o(70772);
        return hashCode;
    }

    public static int hashCode(long[] jArr) {
        AppMethodBeat.i(70771);
        if (jArr == null || jArr.length == 0) {
            AppMethodBeat.o(70771);
            return 0;
        }
        int hashCode = Arrays.hashCode(jArr);
        AppMethodBeat.o(70771);
        return hashCode;
    }

    public static int hashCode(Object[] objArr) {
        AppMethodBeat.i(70773);
        int length = objArr == null ? 0 : objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            i2 = obj != null ? obj.hashCode() + (i2 * 31) : i2;
        }
        AppMethodBeat.o(70773);
        return i2;
    }

    public static void zza(zzn zzn, zzn zzn2) {
        AppMethodBeat.i(70774);
        if (zzn.zzhc != null) {
            zzn2.zzhc = (zzp) zzn.zzhc.clone();
        }
        AppMethodBeat.o(70774);
    }
}
