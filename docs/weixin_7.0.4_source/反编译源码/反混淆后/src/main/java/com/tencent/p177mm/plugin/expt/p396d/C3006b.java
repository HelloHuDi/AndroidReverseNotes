package com.tencent.p177mm.plugin.expt.p396d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.expt.d.b */
public final class C3006b {
    private static String TAG = "MicroMsg.ExptManager";
    private static C3006b lOP;
    private C1177f<Integer, C7503a> lNH = new C6294h(50);
    private String name = null;

    public static C3006b brr() {
        AppMethodBeat.m2504i(93274);
        if (lOP == null) {
            lOP = new C3006b();
        }
        C3006b c3006b = lOP;
        AppMethodBeat.m2505o(93274);
        return c3006b;
    }

    protected C3006b() {
        AppMethodBeat.m2504i(93275);
        AppMethodBeat.m2505o(93275);
    }

    /* renamed from: Lb */
    private int m5291Lb(String str) {
        AppMethodBeat.m2504i(138273);
        C5018as brs = brs();
        if (brs == null) {
            AppMethodBeat.m2505o(138273);
            return -1;
        }
        int i = brs.getInt(str, -1);
        AppMethodBeat.m2505o(138273);
        return i;
    }

    /* renamed from: vc */
    private C7503a m5293vc(int i) {
        AppMethodBeat.m2504i(138274);
        if (i <= 0) {
            AppMethodBeat.m2505o(138274);
            return null;
        }
        C5018as brs = brs();
        if (brs == null) {
            AppMethodBeat.m2505o(138274);
            return null;
        }
        String string = brs.getString(String.valueOf(i), "");
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(138274);
            return null;
        }
        C7503a c7503a = (C7503a) this.lNH.get(Integer.valueOf(i));
        if (c7503a != null) {
            if (C5046bo.isEqual(string, c7503a.field_exptContent)) {
                AppMethodBeat.m2505o(138274);
                return c7503a;
            }
            this.lNH.remove(Integer.valueOf(i));
        }
        c7503a = new C7503a();
        if (c7503a.mo16726La(string)) {
            this.lNH.put(Integer.valueOf(i), c7503a);
        } else {
            c7503a = null;
        }
        AppMethodBeat.m2505o(138274);
        return c7503a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final String mo7215b(String str, String str2, boolean z, boolean z2) {
        String str3;
        AppMethodBeat.m2504i(93277);
        int Lb = m5291Lb(str);
        if (Lb > 0) {
            C7503a vc = m5293vc(Lb);
            if (vc != null && vc.isReady()) {
                HashMap brq = vc.brq();
                if (!(brq == null || brq.isEmpty())) {
                    str3 = (String) brq.get(str);
                    if (z) {
                        C3006b.m5292a(vc, str, str3);
                    }
                    if (z2) {
                        C4990ab.m7417i(TAG, "%s get mulit expt result[%s] key[%s] def[%s]", aZm(), str3, str, str2);
                    }
                    AppMethodBeat.m2505o(93277);
                    return str3;
                }
            }
        }
        str3 = str2;
        if (z2) {
        }
        AppMethodBeat.m2505o(93277);
        return str3;
    }

    /* renamed from: a */
    private static void m5292a(C7503a c7503a, String str, String str2) {
        AppMethodBeat.m2504i(138275);
        C7053e.pXa.mo8381e(15452, Integer.valueOf(c7503a.field_exptId), Integer.valueOf(c7503a.field_groupId), Integer.valueOf(c7503a.field_exptSeq), Long.valueOf(c7503a.field_startTime), Long.valueOf(c7503a.field_endTime), str, str2);
        AppMethodBeat.m2505o(138275);
    }

    private String aZm() {
        AppMethodBeat.m2504i(93278);
        String str = hashCode();
        AppMethodBeat.m2505o(93278);
        return str;
    }

    public final C5018as brs() {
        AppMethodBeat.m2504i(93276);
        int i = C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("default_uin", 0);
        if (i == 0) {
            AppMethodBeat.m2505o(93276);
            return null;
        }
        String str = i + "_WxExptmmkv";
        if (!C5046bo.isEqual(this.name, str)) {
            C4990ab.m7417i(TAG, "%s get mmkv change uin old[%s] new[%s]", aZm(), this.name, str);
            this.name = str;
        }
        C5018as amF = C5018as.amF(this.name);
        AppMethodBeat.m2505o(93276);
        return amF;
    }
}
