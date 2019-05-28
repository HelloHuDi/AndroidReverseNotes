package com.tencent.mm.pluginsdk.g.a.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class j {
    private static final int veA = b.DoDelete.bJt;
    private static final int veB = b.DoDecrypt.bJt;
    private static final int vez = b.DoCache.bJt;

    public enum a {
        SUCC,
        FAIL,
        RETRY_SUCC,
        FILE_LATEST,
        FILE_EXPIRED,
        DEVICE_NOT_MATCH;

        static {
            AppMethodBeat.o(79537);
        }
    }

    public static void z(long j, long j2) {
        AppMethodBeat.i(79538);
        if (j > 0 && 197 != j) {
            h.pYm.a(j, j2, 1, false);
        }
        h.pYm.a(197, j2, 1, false);
        AppMethodBeat.o(79538);
    }

    public static void mc(long j) {
        AppMethodBeat.i(79539);
        z(j, 2);
        AppMethodBeat.o(79539);
    }

    public static void a(int i, int i2, String str, int i3, a aVar, boolean z, boolean z2, boolean z3, String str2) {
        AppMethodBeat.i(79540);
        a(i, i2, str, i3, vez, z2 ? 0 : 1, aVar.ordinal(), z3 ? 0 : 1, 1, z ? 0 : 1, str2);
        AppMethodBeat.o(79540);
    }

    public static void a(int i, int i2, int i3, boolean z, String str) {
        AppMethodBeat.i(79541);
        a(i, i2, "", i3, veA, z ? 0 : 1, a.FAIL.ordinal(), 1, 1, 1, str);
        AppMethodBeat.o(79541);
    }

    public static void a(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        AppMethodBeat.i(79542);
        a(i, i2, "", i3, veB, z ? 0 : 1, a.FAIL.ordinal(), z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
        AppMethodBeat.o(79542);
    }

    private static void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        AppMethodBeat.i(79543);
        h.pYm.e(11906, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        if (!(bo.isNullOrNil(str2) || str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            h.pYm.e(11907, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str2);
        }
        AppMethodBeat.o(79543);
    }
}
