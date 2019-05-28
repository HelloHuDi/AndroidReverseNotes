package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C30039i.C23235b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.j */
public final class C23236j {
    private static final int veA = C23235b.DoDelete.bJt;
    private static final int veB = C23235b.DoDecrypt.bJt;
    private static final int vez = C23235b.DoCache.bJt;

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.j$a */
    public enum C23237a {
        SUCC,
        FAIL,
        RETRY_SUCC,
        FILE_LATEST,
        FILE_EXPIRED,
        DEVICE_NOT_MATCH;

        static {
            AppMethodBeat.m2505o(79537);
        }
    }

    /* renamed from: z */
    public static void m35639z(long j, long j2) {
        AppMethodBeat.m2504i(79538);
        if (j > 0 && 197 != j) {
            C7060h.pYm.mo8378a(j, j2, 1, false);
        }
        C7060h.pYm.mo8378a(197, j2, 1, false);
        AppMethodBeat.m2505o(79538);
    }

    /* renamed from: mc */
    public static void m35638mc(long j) {
        AppMethodBeat.m2504i(79539);
        C23236j.m35639z(j, 2);
        AppMethodBeat.m2505o(79539);
    }

    /* renamed from: a */
    public static void m35637a(int i, int i2, String str, int i3, C23237a c23237a, boolean z, boolean z2, boolean z3, String str2) {
        AppMethodBeat.m2504i(79540);
        C23236j.m35636a(i, i2, str, i3, vez, z2 ? 0 : 1, c23237a.ordinal(), z3 ? 0 : 1, 1, z ? 0 : 1, str2);
        AppMethodBeat.m2505o(79540);
    }

    /* renamed from: a */
    public static void m35634a(int i, int i2, int i3, boolean z, String str) {
        AppMethodBeat.m2504i(79541);
        C23236j.m35636a(i, i2, "", i3, veA, z ? 0 : 1, C23237a.FAIL.ordinal(), 1, 1, 1, str);
        AppMethodBeat.m2505o(79541);
    }

    /* renamed from: a */
    public static void m35635a(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        AppMethodBeat.m2504i(79542);
        C23236j.m35636a(i, i2, "", i3, veB, z ? 0 : 1, C23237a.FAIL.ordinal(), z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
        AppMethodBeat.m2505o(79542);
    }

    /* renamed from: a */
    private static void m35636a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        AppMethodBeat.m2504i(79543);
        C7060h.pYm.mo8381e(11906, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        if (!(C5046bo.isNullOrNil(str2) || str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            C7060h.pYm.mo8381e(11907, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str2);
        }
        AppMethodBeat.m2505o(79543);
    }
}
