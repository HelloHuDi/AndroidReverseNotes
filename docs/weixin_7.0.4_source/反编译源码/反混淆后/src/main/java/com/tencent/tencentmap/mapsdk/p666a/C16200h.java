package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.a.h */
public class C16200h {
    /* renamed from: a */
    public static final double f3107a = Double.longBitsToDouble(4368491638549381120L);
    /* renamed from: b */
    public static final double f3108b = Double.longBitsToDouble(4503599627370496L);
    /* renamed from: c */
    private static final long f3109c = Double.doubleToRawLongBits(0.0d);
    /* renamed from: d */
    private static final long f3110d = Double.doubleToRawLongBits(-0.0d);
    /* renamed from: e */
    private static final int f3111e = Float.floatToRawIntBits(0.0f);
    /* renamed from: f */
    private static final int f3112f = Float.floatToRawIntBits(-0.0f);

    /* renamed from: a */
    public static String m24668a(String str, Object obj) {
        AppMethodBeat.m2504i(101146);
        String str2 = str + "=" + String.valueOf(obj);
        AppMethodBeat.m2505o(101146);
        return str2;
    }

    /* renamed from: a */
    public static String m24669a(String... strArr) {
        AppMethodBeat.m2504i(101147);
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i++;
            i2++;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(101147);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static int m24667a(Object[] objArr) {
        AppMethodBeat.m2504i(101148);
        int hashCode = Arrays.hashCode(objArr);
        AppMethodBeat.m2505o(101148);
        return hashCode;
    }

    static {
        AppMethodBeat.m2504i(101149);
        AppMethodBeat.m2505o(101149);
    }
}
