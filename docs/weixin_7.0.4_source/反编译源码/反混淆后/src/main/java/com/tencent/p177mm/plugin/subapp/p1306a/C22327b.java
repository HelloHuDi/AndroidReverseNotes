package com.tencent.p177mm.plugin.subapp.p1306a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26413c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.subapp.a.b */
public final class C22327b implements C26413c {

    /* renamed from: com.tencent.mm.plugin.subapp.a.b$a */
    static class C22328a implements C1202f {
        public C22328a() {
            AppMethodBeat.m2504i(25225);
            C9638aw.m17182Rg().mo14539a((int) ErrorCode.STARTDOWNLOAD_8, (C1202f) this);
            C9638aw.m17182Rg().mo14541a(new C43666a(), 0);
            AppMethodBeat.m2505o(25225);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(25226);
            C9638aw.m17182Rg().mo14546b((int) ErrorCode.STARTDOWNLOAD_8, (C1202f) this);
            AppMethodBeat.m2505o(25226);
        }
    }

    /* renamed from: ky */
    public final String mo37872ky(int i) {
        AppMethodBeat.m2504i(25227);
        String aj = m34008aj(i, true);
        AppMethodBeat.m2505o(25227);
        return aj;
    }

    /* renamed from: kz */
    public final String mo37873kz(int i) {
        AppMethodBeat.m2504i(25228);
        String aj = m34008aj(i, false);
        AppMethodBeat.m2505o(25228);
        return aj;
    }

    /* renamed from: aj */
    private String m34008aj(int i, boolean z) {
        AppMethodBeat.m2504i(25229);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            String ak = m34009ak(i, z);
            if (C1173e.m2561ct(ak)) {
                AppMethodBeat.m2505o(25229);
                return ak;
            }
            mo37870Zv();
            AppMethodBeat.m2505o(25229);
            return null;
        }
        AppMethodBeat.m2505o(25229);
        return null;
    }

    /* renamed from: Zv */
    public final void mo37870Zv() {
        AppMethodBeat.m2504i(25230);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            C9638aw.m17190ZK();
            long a = C5046bo.m7514a((Long) C18628c.m29072Ry().get(66051, null), 0);
            long anU = C5046bo.anU();
            if (432000000 > anU - a) {
                AppMethodBeat.m2505o(25230);
                return;
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(66051, Long.valueOf(anU));
            C22328a c22328a = new C22328a();
            AppMethodBeat.m2505o(25230);
            return;
        }
        AppMethodBeat.m2505o(25230);
    }

    /* renamed from: kA */
    public final boolean mo37871kA(int i) {
        AppMethodBeat.m2504i(25231);
        if (i == 0) {
            AppMethodBeat.m2505o(25231);
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (C1173e.m2561ct(mo37869B((1 << i2) & i, false)) && C1173e.m2561ct(mo37869B((1 << i2) & i, true))) {
                i2++;
            } else {
                AppMethodBeat.m2505o(25231);
                return false;
            }
        }
        AppMethodBeat.m2505o(25231);
        return true;
    }

    /* renamed from: ak */
    private String m34009ak(int i, boolean z) {
        AppMethodBeat.m2504i(25232);
        int Fn = C22327b.m34007Fn(i);
        if (Fn == 0) {
            AppMethodBeat.m2505o(25232);
            return null;
        }
        String B = mo37869B(Fn, z);
        AppMethodBeat.m2505o(25232);
        return B;
    }

    /* renamed from: B */
    public final String mo37869B(int i, boolean z) {
        AppMethodBeat.m2504i(25233);
        if (i == 0) {
            AppMethodBeat.m2505o(25233);
            return null;
        }
        String str = C6457e.euS + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : "") + ".png";
        AppMethodBeat.m2505o(25233);
        return str;
    }

    /* renamed from: Fm */
    private static int m34006Fm(int i) {
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        while (i2 < 32) {
            i = (i >> 1) & BaseClientBuilder.API_PRIORITY_OTHER;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    /* renamed from: Fn */
    private static int m34007Fn(int i) {
        AppMethodBeat.m2504i(25234);
        int Fm = C22327b.m34006Fm(i);
        if (Fm == -1) {
            AppMethodBeat.m2505o(25234);
            return 0;
        }
        Fm = 1 << Fm;
        AppMethodBeat.m2505o(25234);
        return Fm;
    }
}
