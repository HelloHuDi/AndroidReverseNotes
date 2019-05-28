package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static String ak(byte[] bArr) {
        AppMethodBeat.i(137934);
        String str = "";
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(137934);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i;
            int i2 = b & 15;
            if (i2 < 10) {
                i = 48;
            } else {
                i = 55;
            }
            i2 += i;
            int i3 = (b & 240) >> 4;
            if (i3 < 10) {
                i = 48;
            } else {
                i = 55;
            }
            stringBuilder.append(i + i3);
            stringBuilder.append(i2);
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(137934);
        return str;
    }
}
