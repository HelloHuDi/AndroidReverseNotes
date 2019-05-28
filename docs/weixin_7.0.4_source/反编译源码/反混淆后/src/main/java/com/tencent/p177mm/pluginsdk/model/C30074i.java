package com.tencent.p177mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C14887t;
import com.tencent.p177mm.pluginsdk.model.app.C40442x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.model.i */
public final class C30074i implements C14887t {
    public static boolean vbc = false;
    private static C30074i vbd;
    public C14890a vbe;

    /* renamed from: com.tencent.mm.pluginsdk.model.i$a */
    public interface C14890a {
        /* renamed from: a */
        void mo15144a(C44063l c44063l);
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.i$b */
    public static class C30073b {
        public String vbf;
    }

    private C30074i() {
    }

    public static C30074i dgZ() {
        AppMethodBeat.m2504i(27296);
        if (vbd == null) {
            vbd = new C30074i();
        }
        C30074i c30074i = vbd;
        AppMethodBeat.m2505o(27296);
        return c30074i;
    }

    public final void dha() {
        AppMethodBeat.m2504i(27297);
        if (C9638aw.m17179RK()) {
            C14877am.bYM().mo27202a(14, (C14887t) this);
            vbc = true;
            AppMethodBeat.m2505o(27297);
            return;
        }
        AppMethodBeat.m2505o(27297);
    }

    /* renamed from: a */
    public final void mo9876a(int i, int i2, String str, C40442x c40442x) {
        AppMethodBeat.m2504i(27298);
        if (C9638aw.m17179RK()) {
            C4990ab.m7411d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (c40442x == null) {
                C4990ab.m7412e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
                AppMethodBeat.m2505o(27298);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (c40442x.getType()) {
                    case 14:
                        if (C4996ah.getContext() != null && C3753a.bYQ() != null) {
                            C4990ab.m7413e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", Integer.valueOf(i), Integer.valueOf(i2));
                            C44063l c44063l = (C44063l) c40442x;
                            if (this.vbe != null) {
                                this.vbe.mo15144a(c44063l);
                                break;
                            }
                        }
                        C4990ab.m7412e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                        AppMethodBeat.m2505o(27298);
                        return;
                        break;
                }
            }
            AppMethodBeat.m2505o(27298);
            return;
        }
        AppMethodBeat.m2505o(27298);
    }

    public static C30073b aiA(String str) {
        AppMethodBeat.m2504i(27299);
        if (str == null) {
            AppMethodBeat.m2505o(27299);
            return null;
        }
        Map z = C5049br.m7595z(str, "PersonalAppSetting");
        if (z == null) {
            AppMethodBeat.m2505o(27299);
            return null;
        }
        String str2 = (String) z.get(".PersonalAppSetting.OpenID");
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(27299);
            return null;
        }
        C30073b c30073b = new C30073b();
        c30073b.vbf = str2;
        AppMethodBeat.m2505o(27299);
        return c30073b;
    }
}
