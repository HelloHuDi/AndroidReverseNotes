package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

@Keep
public class MBCharsetHandler {
    private static final String TAG = "MicroMsg.MBCharsetHandler";

    @Keep
    public static byte[] encode(String str, String str2) {
        byte[] bArr = null;
        AppMethodBeat.i(115896);
        if (str == null) {
            AppMethodBeat.o(115896);
        } else {
            try {
                bArr = str.getBytes(str2);
            } catch (UnsupportedEncodingException e) {
                c.e(TAG, "MBCharsetHandler encode failed. [%s]", e);
            }
            AppMethodBeat.o(115896);
        }
        return bArr;
    }

    @Keep
    static String decode(byte[] bArr, String str) {
        AppMethodBeat.i(115897);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(115897);
            return null;
        }
        String str2;
        try {
            str2 = new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            c.e(TAG, "UnsupportedDecoding [%s] [%s]", str, e);
            str2 = null;
        }
        AppMethodBeat.o(115897);
        return str2;
    }
}
