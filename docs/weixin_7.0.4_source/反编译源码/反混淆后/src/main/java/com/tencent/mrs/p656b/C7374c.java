package com.tencent.mrs.p656b;

import com.tencent.p177mm.plugin.expt.p396d.C3006b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mrs.b.c */
public final class C7374c implements C5774a {
    public final String get(String str, String str2) {
        return C3006b.brr().mo7215b(str, str2, false, false);
    }

    public final int get(String str, int i) {
        String str2 = get(str, "");
        return C5046bo.isNullOrNil(str2) ? i : C5046bo.getInt(str2, i);
    }

    public final long get(String str, long j) {
        String str2 = get(str, "");
        return C5046bo.isNullOrNil(str2) ? j : C5046bo.getLong(str2, j);
    }

    public final boolean get(String str, boolean z) {
        String str2 = get(str, "");
        if (C5046bo.isNullOrNil(str2)) {
            return z;
        }
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (C5046bo.getInt(str2, i) != 0) {
            return true;
        }
        return false;
    }
}
