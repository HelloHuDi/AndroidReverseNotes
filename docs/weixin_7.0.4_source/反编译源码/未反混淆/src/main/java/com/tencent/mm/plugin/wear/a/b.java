package com.tencent.mm.plugin.wear.a;

import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final boolean adz(String str) {
        AppMethodBeat.i(26460);
        try {
            boolean equals = str.split("/")[2].equals(PutDataRequest.WEAR_URI_SCHEME);
            AppMethodBeat.o(26460);
            return equals;
        } catch (Exception e) {
            AppMethodBeat.o(26460);
            return false;
        }
    }

    public static final int adA(String str) {
        AppMethodBeat.i(26461);
        try {
            int intValue = Integer.valueOf(str.split("/")[4]).intValue();
            AppMethodBeat.o(26461);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.o(26461);
            return 0;
        }
    }
}
