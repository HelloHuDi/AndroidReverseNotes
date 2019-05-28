package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzacc {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Object zzbxg = new Object();

    static {
        AppMethodBeat.m2504i(3511);
        AppMethodBeat.m2505o(3511);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        AppMethodBeat.m2504i(3504);
        if (iArr != null && iArr.length != 0) {
            boolean equals = Arrays.equals(iArr, iArr2);
            AppMethodBeat.m2505o(3504);
            return equals;
        } else if (iArr2 == null || iArr2.length == 0) {
            AppMethodBeat.m2505o(3504);
            return true;
        } else {
            AppMethodBeat.m2505o(3504);
            return false;
        }
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        AppMethodBeat.m2504i(3505);
        if (jArr != null && jArr.length != 0) {
            boolean equals = Arrays.equals(jArr, jArr2);
            AppMethodBeat.m2505o(3505);
            return equals;
        } else if (jArr2 == null || jArr2.length == 0) {
            AppMethodBeat.m2505o(3505);
            return true;
        } else {
            AppMethodBeat.m2505o(3505);
            return false;
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        AppMethodBeat.m2504i(3506);
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
                    AppMethodBeat.m2505o(3506);
                    return true;
                } else if (z2 != z3) {
                    AppMethodBeat.m2505o(3506);
                    return false;
                } else if (objArr[z].equals(objArr2[i2])) {
                    i = i2 + 1;
                    z++;
                } else {
                    AppMethodBeat.m2505o(3506);
                    return false;
                }
            }
            z++;
        }
    }

    public static int hashCode(int[] iArr) {
        AppMethodBeat.m2504i(3507);
        if (iArr == null || iArr.length == 0) {
            AppMethodBeat.m2505o(3507);
            return 0;
        }
        int hashCode = Arrays.hashCode(iArr);
        AppMethodBeat.m2505o(3507);
        return hashCode;
    }

    public static int hashCode(long[] jArr) {
        AppMethodBeat.m2504i(3508);
        if (jArr == null || jArr.length == 0) {
            AppMethodBeat.m2505o(3508);
            return 0;
        }
        int hashCode = Arrays.hashCode(jArr);
        AppMethodBeat.m2505o(3508);
        return hashCode;
    }

    public static int hashCode(Object[] objArr) {
        AppMethodBeat.m2504i(3509);
        int length = objArr == null ? 0 : objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            i2 = obj != null ? obj.hashCode() + (i2 * 31) : i2;
        }
        AppMethodBeat.m2505o(3509);
        return i2;
    }

    public static void zza(zzaby zzaby, zzaby zzaby2) {
        AppMethodBeat.m2504i(3510);
        if (zzaby.zzbww != null) {
            zzaby2.zzbww = (zzaca) zzaby.zzbww.clone();
        }
        AppMethodBeat.m2505o(3510);
    }
}
