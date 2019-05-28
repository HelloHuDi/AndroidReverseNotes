package com.tencent.p177mm.p612ui.conversation;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.conversation.b */
public final class C5481b {
    private static final String[] zqT = new String[]{"M3X", "M5s", "M5", "MX6", "U10", "U20", "M2 E", "M A5", "DIG-AL00", "DIG-TL10", "NCE-AL00", "NCE-TL10", "MYA-TL10", "MYA-AL10", "NEM-AL10"};

    public static boolean dIo() {
        AppMethodBeat.m2504i(34154);
        if (VERSION.SDK_INT == 23 && Build.MODEL != null) {
            for (String equalsIgnoreCase : zqT) {
                if (equalsIgnoreCase.equalsIgnoreCase(Build.MODEL)) {
                    C4990ab.m7417i("CompatSupportV27", "for weird crash, %s", Build.MODEL);
                    AppMethodBeat.m2505o(34154);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(34154);
        return false;
    }
}
