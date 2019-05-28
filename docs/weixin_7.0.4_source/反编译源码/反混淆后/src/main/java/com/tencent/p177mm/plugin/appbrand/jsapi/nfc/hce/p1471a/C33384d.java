package com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a;

import android.annotation.TargetApi;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d */
public final class C33384d {
    private static boolean aEz() {
        return VERSION.SDK_INT >= 21;
    }

    @TargetApi(21)
    public static boolean aEA() {
        AppMethodBeat.m2504i(137936);
        if (C33384d.aEz()) {
            boolean hasSystemFeature = C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            AppMethodBeat.m2505o(137936);
            return hasSystemFeature;
        }
        AppMethodBeat.m2505o(137936);
        return false;
    }

    public static boolean aEB() {
        AppMethodBeat.m2504i(137937);
        Context context = C4996ah.getContext();
        if (!context.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
            AppMethodBeat.m2505o(137937);
            return false;
        } else if (NfcAdapter.getDefaultAdapter(context) == null) {
            AppMethodBeat.m2505o(137937);
            return false;
        } else {
            AppMethodBeat.m2505o(137937);
            return true;
        }
    }

    public static boolean aEC() {
        AppMethodBeat.m2504i(137938);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(C4996ah.getContext());
        if (defaultAdapter == null) {
            C4990ab.m7416i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
            AppMethodBeat.m2505o(137938);
            return false;
        } else if (defaultAdapter.isEnabled()) {
            AppMethodBeat.m2505o(137938);
            return true;
        } else {
            AppMethodBeat.m2505o(137938);
            return false;
        }
    }
}
