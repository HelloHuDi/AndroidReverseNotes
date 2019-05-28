package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class hl {
    public static byte[] a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int a(byte[] bArr) {
        return (((bArr[0] & 255) | (65280 & (bArr[1] << 8))) | (16711680 & (bArr[2] << 16))) | (WebView.NIGHT_MODE_COLOR & (bArr[3] << 24));
    }

    public static boolean b(byte[] bArr) {
        return bArr[0] > (byte) 0;
    }

    public static float c(byte[] bArr) {
        AppMethodBeat.i(99551);
        float intBitsToFloat = Float.intBitsToFloat(a(bArr));
        AppMethodBeat.o(99551);
        return intBitsToFloat;
    }

    public static byte[] a(String str) {
        byte[] bytes;
        AppMethodBeat.i(99552);
        if (str != null) {
            try {
                bytes = str.getBytes("UTF-16LE");
                AppMethodBeat.o(99552);
                return bytes;
            } catch (Exception e) {
            }
        }
        bytes = new byte[0];
        AppMethodBeat.o(99552);
        return bytes;
    }

    public static String d(byte[] bArr) {
        AppMethodBeat.i(99553);
        try {
            String trim = new String(bArr, "UTF-16LE").trim();
            AppMethodBeat.o(99553);
            return trim;
        } catch (Exception e) {
            AppMethodBeat.o(99553);
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        AppMethodBeat.i(99554);
        try {
            String trim = new String(bArr, str).trim();
            AppMethodBeat.o(99554);
            return trim;
        } catch (Exception e) {
            AppMethodBeat.o(99554);
            return null;
        }
    }
}
