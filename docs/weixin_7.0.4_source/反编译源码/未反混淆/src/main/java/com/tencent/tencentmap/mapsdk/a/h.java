package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class h {
    public static final double a = Double.longBitsToDouble(4368491638549381120L);
    public static final double b = Double.longBitsToDouble(4503599627370496L);
    private static final long c = Double.doubleToRawLongBits(0.0d);
    private static final long d = Double.doubleToRawLongBits(-0.0d);
    private static final int e = Float.floatToRawIntBits(0.0f);
    private static final int f = Float.floatToRawIntBits(-0.0f);

    public static String a(String str, Object obj) {
        AppMethodBeat.i(101146);
        String str2 = str + "=" + String.valueOf(obj);
        AppMethodBeat.o(101146);
        return str2;
    }

    public static String a(String... strArr) {
        AppMethodBeat.i(101147);
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
        AppMethodBeat.o(101147);
        return stringBuilder2;
    }

    public static int a(Object[] objArr) {
        AppMethodBeat.i(101148);
        int hashCode = Arrays.hashCode(objArr);
        AppMethodBeat.o(101148);
        return hashCode;
    }

    static {
        AppMethodBeat.i(101149);
        AppMethodBeat.o(101149);
    }
}
