package com.tencent.p177mm.plugin.wear.p1624a;

import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wear.a.b */
public final class C43840b {
    public static final boolean adz(String str) {
        AppMethodBeat.m2504i(26460);
        try {
            boolean equals = str.split("/")[2].equals(PutDataRequest.WEAR_URI_SCHEME);
            AppMethodBeat.m2505o(26460);
            return equals;
        } catch (Exception e) {
            AppMethodBeat.m2505o(26460);
            return false;
        }
    }

    public static final int adA(String str) {
        AppMethodBeat.m2504i(26461);
        try {
            int intValue = Integer.valueOf(str.split("/")[4]).intValue();
            AppMethodBeat.m2505o(26461);
            return intValue;
        } catch (Exception e) {
            AppMethodBeat.m2505o(26461);
            return 0;
        }
    }
}
