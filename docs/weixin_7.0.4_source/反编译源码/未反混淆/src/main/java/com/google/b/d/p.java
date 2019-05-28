package com.google.b.d;

import com.facebook.appevents.AppEventsConstants;
import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class p implements g {
    private final j bAB = new j();

    public p() {
        AppMethodBeat.i(57328);
        AppMethodBeat.o(57328);
    }

    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57329);
        if (aVar != a.UPC_A) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57329);
            throw illegalArgumentException;
        }
        b a = this.bAB.a(bk(str), a.EAN_13, i, i2, map);
        AppMethodBeat.o(57329);
        return a;
    }

    private static String bk(String str) {
        Object str2;
        AppMethodBeat.i(57330);
        int length = str2.length();
        if (length == 11) {
            int i = 0;
            for (length = 0; length < 11; length++) {
                i += (length % 2 == 0 ? 3 : 1) * (str2.charAt(length) - 48);
            }
            str2 = str2 + ((1000 - i) % 10);
        } else if (length != 12) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str2.length());
            AppMethodBeat.o(57330);
            throw illegalArgumentException;
        }
        String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str2));
        AppMethodBeat.o(57330);
        return concat;
    }
}
