package com.tencent.p177mm.opensdk.utils;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.opensdk.utils.a */
public final class C18749a {
    /* renamed from: a */
    public static int m29300a(Bundle bundle, String str) {
        int i = -1;
        AppMethodBeat.m2504i(128072);
        if (bundle == null) {
            AppMethodBeat.m2505o(128072);
        } else {
            try {
                i = bundle.getInt(str, -1);
            } catch (Exception e) {
                Log.m4140e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            }
            AppMethodBeat.m2505o(128072);
        }
        return i;
    }

    /* renamed from: b */
    public static String m29301b(Bundle bundle, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(128073);
        if (bundle == null) {
            AppMethodBeat.m2505o(128073);
        } else {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                Log.m4140e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            }
            AppMethodBeat.m2505o(128073);
        }
        return str2;
    }
}
