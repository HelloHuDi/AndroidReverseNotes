package com.tencent.mrs.b;

import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class c implements a {
    public final String get(String str, String str2) {
        return b.brr().b(str, str2, false, false);
    }

    public final int get(String str, int i) {
        String str2 = get(str, "");
        return bo.isNullOrNil(str2) ? i : bo.getInt(str2, i);
    }

    public final long get(String str, long j) {
        String str2 = get(str, "");
        return bo.isNullOrNil(str2) ? j : bo.getLong(str2, j);
    }

    public final boolean get(String str, boolean z) {
        String str2 = get(str, "");
        if (bo.isNullOrNil(str2)) {
            return z;
        }
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (bo.getInt(str2, i) != 0) {
            return true;
        }
        return false;
    }
}
