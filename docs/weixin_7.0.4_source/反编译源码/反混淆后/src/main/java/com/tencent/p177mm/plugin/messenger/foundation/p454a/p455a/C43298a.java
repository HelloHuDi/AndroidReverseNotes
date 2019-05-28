package com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.a */
public final class C43298a {
    /* renamed from: a */
    public static long m77176a(C7617ak c7617ak, int i, long j) {
        AppMethodBeat.m2504i(60016);
        if (c7617ak == null) {
            AppMethodBeat.m2505o(60016);
            return 0;
        }
        if (j == 0) {
            j = C5046bo.anU();
        }
        long a;
        switch (i) {
            case 2:
                a = C43298a.m77177a(c7617ak, j) | 4611686018427387904L;
                AppMethodBeat.m2505o(60016);
                return a;
            case 3:
                a = C43298a.m77177a(c7617ak, j) & -4611686018427387905L;
                AppMethodBeat.m2505o(60016);
                return a;
            case 4:
                a = C43298a.m77177a(c7617ak, j) & 4611686018427387904L;
                AppMethodBeat.m2505o(60016);
                return a;
            case 5:
                a = C43298a.m77177a(c7617ak, j) | 1152921504606846976L;
                AppMethodBeat.m2505o(60016);
                return a;
            case 6:
                a = C43298a.m77177a(c7617ak, j) & -1152921504606846977L;
                AppMethodBeat.m2505o(60016);
                return a;
            case 7:
                a = C43298a.m77177a(c7617ak, j) & 1152921504606846976L;
                AppMethodBeat.m2505o(60016);
                return a;
            default:
                a = C43298a.m77177a(c7617ak, j);
                AppMethodBeat.m2505o(60016);
                return a;
        }
    }

    /* renamed from: a */
    public static long m77177a(C7617ak c7617ak, long j) {
        return (c7617ak.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }
}
