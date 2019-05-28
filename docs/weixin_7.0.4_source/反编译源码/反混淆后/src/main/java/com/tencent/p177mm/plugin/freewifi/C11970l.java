package com.tencent.p177mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.freewifi.l */
public final class C11970l {
    /* renamed from: v */
    public static void m19874v(String str, String str2, int i) {
        AppMethodBeat.m2504i(20617);
        C7060h.pYm.mo8381e(12651, Integer.valueOf(1), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.m2505o(20617);
    }

    /* renamed from: w */
    public static void m19875w(String str, String str2, int i) {
        AppMethodBeat.m2504i(20618);
        C7060h.pYm.mo8381e(12651, Integer.valueOf(2), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.m2505o(20618);
    }

    /* renamed from: x */
    public static void m19876x(String str, String str2, int i) {
        AppMethodBeat.m2504i(20619);
        C7060h.pYm.mo8381e(12651, Integer.valueOf(3), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.m2505o(20619);
    }

    /* renamed from: a */
    public static void m19872a(String str, String str2, int i, boolean z) {
        AppMethodBeat.m2504i(20620);
        if (z) {
            C7060h.pYm.mo8381e(12651, Integer.valueOf(4), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
            AppMethodBeat.m2505o(20620);
            return;
        }
        C7060h.pYm.mo8381e(12651, Integer.valueOf(4), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.m2505o(20620);
    }

    /* renamed from: b */
    public static void m19873b(String str, String str2, int i, boolean z) {
        AppMethodBeat.m2504i(20621);
        if (z) {
            C7060h.pYm.mo8381e(12651, Integer.valueOf(5), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
            AppMethodBeat.m2505o(20621);
            return;
        }
        C7060h.pYm.mo8381e(12651, Integer.valueOf(5), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.m2505o(20621);
    }
}
