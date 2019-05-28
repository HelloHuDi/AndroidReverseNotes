package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.n */
public final class C41080n {
    /* renamed from: a */
    private static final byte[] f16552a;
    /* renamed from: b */
    private static final byte[] f16553b;

    /* renamed from: a */
    public static boolean m71484a(short s, short s2) {
        return s == s2;
    }

    /* renamed from: a */
    public static boolean m71482a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m71483a(Object obj, Object obj2) {
        AppMethodBeat.m2504i(100520);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.m2505o(100520);
            return equals;
        } else if (obj == obj2) {
            AppMethodBeat.m2505o(100520);
            return true;
        } else {
            AppMethodBeat.m2505o(100520);
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m71485a(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(100521);
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        AppMethodBeat.m2505o(100521);
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
        f16552a = bArr2;
        f16553b = bArr3;
    }
}
