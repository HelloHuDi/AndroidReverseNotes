package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d {
    private static boolean aEz() {
        return VERSION.SDK_INT >= 21;
    }

    @TargetApi(21)
    public static boolean aEA() {
        AppMethodBeat.i(137936);
        if (aEz()) {
            boolean hasSystemFeature = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            AppMethodBeat.o(137936);
            return hasSystemFeature;
        }
        AppMethodBeat.o(137936);
        return false;
    }

    public static boolean aEB() {
        AppMethodBeat.i(137937);
        Context context = ah.getContext();
        if (!context.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
            AppMethodBeat.o(137937);
            return false;
        } else if (NfcAdapter.getDefaultAdapter(context) == null) {
            AppMethodBeat.o(137937);
            return false;
        } else {
            AppMethodBeat.o(137937);
            return true;
        }
    }

    public static boolean aEC() {
        AppMethodBeat.i(137938);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(ah.getContext());
        if (defaultAdapter == null) {
            ab.i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
            AppMethodBeat.o(137938);
            return false;
        } else if (defaultAdapter.isEnabled()) {
            AppMethodBeat.o(137938);
            return true;
        } else {
            AppMethodBeat.o(137938);
            return false;
        }
    }
}
