package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class n {
    private static final byte[] a;
    private static final byte[] b;

    public static boolean a(short s, short s2) {
        return s == s2;
    }

    public static boolean a(int i, int i2) {
        return i == i2;
    }

    public static boolean a(Object obj, Object obj2) {
        AppMethodBeat.i(100520);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(100520);
            return equals;
        } else if (obj == obj2) {
            AppMethodBeat.o(100520);
            return true;
        } else {
            AppMethodBeat.o(100520);
            return false;
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        AppMethodBeat.i(100521);
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        AppMethodBeat.o(100521);
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
        a = bArr2;
        b = bArr3;
    }
}
