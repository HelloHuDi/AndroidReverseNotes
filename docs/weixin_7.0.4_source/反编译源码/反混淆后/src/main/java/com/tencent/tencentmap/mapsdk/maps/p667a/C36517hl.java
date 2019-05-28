package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hl */
public class C36517hl {
    /* renamed from: a */
    public static byte[] m60438a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    /* renamed from: a */
    public static int m60436a(byte[] bArr) {
        return (((bArr[0] & 255) | (65280 & (bArr[1] << 8))) | (16711680 & (bArr[2] << 16))) | (WebView.NIGHT_MODE_COLOR & (bArr[3] << 24));
    }

    /* renamed from: b */
    public static boolean m60440b(byte[] bArr) {
        return bArr[0] > (byte) 0;
    }

    /* renamed from: c */
    public static float m60441c(byte[] bArr) {
        AppMethodBeat.m2504i(99551);
        float intBitsToFloat = Float.intBitsToFloat(C36517hl.m60436a(bArr));
        AppMethodBeat.m2505o(99551);
        return intBitsToFloat;
    }

    /* renamed from: a */
    public static byte[] m60439a(String str) {
        byte[] bytes;
        AppMethodBeat.m2504i(99552);
        if (str != null) {
            try {
                bytes = str.getBytes("UTF-16LE");
                AppMethodBeat.m2505o(99552);
                return bytes;
            } catch (Exception e) {
            }
        }
        bytes = new byte[0];
        AppMethodBeat.m2505o(99552);
        return bytes;
    }

    /* renamed from: d */
    public static String m60442d(byte[] bArr) {
        AppMethodBeat.m2504i(99553);
        try {
            String trim = new String(bArr, "UTF-16LE").trim();
            AppMethodBeat.m2505o(99553);
            return trim;
        } catch (Exception e) {
            AppMethodBeat.m2505o(99553);
            return null;
        }
    }

    /* renamed from: a */
    public static String m60437a(byte[] bArr, String str) {
        AppMethodBeat.m2504i(99554);
        try {
            String trim = new String(bArr, str).trim();
            AppMethodBeat.m2505o(99554);
            return trim;
        } catch (Exception e) {
            AppMethodBeat.m2505o(99554);
            return null;
        }
    }
}
