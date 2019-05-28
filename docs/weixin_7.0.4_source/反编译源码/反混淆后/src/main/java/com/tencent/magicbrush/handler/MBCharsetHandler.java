package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

@Keep
public class MBCharsetHandler {
    private static final String TAG = "MicroMsg.MBCharsetHandler";

    @Keep
    public static byte[] encode(String str, String str2) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(115896);
        if (str == null) {
            AppMethodBeat.m2505o(115896);
        } else {
            try {
                bArr = str.getBytes(str2);
            } catch (UnsupportedEncodingException e) {
                C17837c.m27915e(TAG, "MBCharsetHandler encode failed. [%s]", e);
            }
            AppMethodBeat.m2505o(115896);
        }
        return bArr;
    }

    @Keep
    static String decode(byte[] bArr, String str) {
        AppMethodBeat.m2504i(115897);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(115897);
            return null;
        }
        String str2;
        try {
            str2 = new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            C17837c.m27915e(TAG, "UnsupportedDecoding [%s] [%s]", str, e);
            str2 = null;
        }
        AppMethodBeat.m2505o(115897);
        return str2;
    }
}
