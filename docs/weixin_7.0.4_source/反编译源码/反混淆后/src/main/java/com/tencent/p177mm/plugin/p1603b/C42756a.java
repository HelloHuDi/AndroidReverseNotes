package com.tencent.p177mm.plugin.p1603b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.b.a */
public final class C42756a {
    /* renamed from: wz */
    public static void m75798wz(String str) {
        AppMethodBeat.m2504i(123480);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putString("reg_last_exit_ui", str).commit();
        AppMethodBeat.m2505o(123480);
    }

    /* renamed from: FP */
    public static String m75794FP() {
        AppMethodBeat.m2504i(123481);
        String string = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getString("reg_last_exit_ui", "");
        AppMethodBeat.m2505o(123481);
        return string;
    }

    /* renamed from: wA */
    public static void m75796wA(String str) {
        AppMethodBeat.m2504i(123482);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putString("reg_next_enter_ui", str).commit();
        AppMethodBeat.m2505o(123482);
    }

    private static String arO() {
        AppMethodBeat.m2504i(123483);
        String string = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getString("reg_next_enter_ui", "");
        AppMethodBeat.m2505o(123483);
        return string;
    }

    /* renamed from: wB */
    public static void m75797wB(String str) {
        AppMethodBeat.m2504i(123484);
        C7053e.pXa.mo8376a(10645, str + "," + C5046bo.anU() + "," + C42756a.m75794FP(), true, true);
        AppMethodBeat.m2505o(123484);
    }

    /* renamed from: f */
    public static void m75795f(boolean z, String str) {
        String str2;
        AppMethodBeat.m2504i(123485);
        if (z) {
            str2 = str + "," + C5046bo.anU() + "," + C42756a.m75794FP();
        } else {
            str2 = str + "," + C5046bo.anU() + "," + C42756a.arO();
        }
        C7053e.pXa.mo8376a(10645, str2, true, true);
        AppMethodBeat.m2505o(123485);
    }
}
