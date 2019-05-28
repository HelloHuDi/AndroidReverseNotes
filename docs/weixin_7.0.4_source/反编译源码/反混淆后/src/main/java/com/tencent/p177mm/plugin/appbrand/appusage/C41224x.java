package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.C33134c;
import com.tencent.p177mm.plugin.appbrand.p911q.C19676a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.protocal.protobuf.anx;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.x */
public final class C41224x extends C37440a<anx> {
    private static final long has = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.x$a */
    public enum C41225a {
        DAILY,
        SEARCH;

        static {
            AppMethodBeat.m2505o(129701);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
        AppMethodBeat.m2504i(129704);
        anx anx = (anx) btd;
        super.mo21469a(i, i2, str, anx, c1207m);
        C33134c xH = C42340f.m74880xH();
        C19676a auZ = C42340f.auZ();
        if (xH == null || auZ == null) {
            C4990ab.m7413e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", xH, auZ);
            AppMethodBeat.m2505o(129704);
            return;
        }
        long j = (i == 0 && i2 == 0 && anx != null) ? (long) anx.wsu : has;
        xH.mo53682bG("GetSearchShowOutWxaApp_interval", String.valueOf(j));
        if (i == 0 && i2 == 0 && anx != null) {
            try {
                auZ.mo34914s("GetSearchShowOutWxaApp_resp", anx.toByteArray());
                AppMethodBeat.m2505o(129704);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", e);
            }
        }
        AppMethodBeat.m2505o(129704);
    }

    public static void axL() {
        AppMethodBeat.m2504i(129702);
        if (C1720g.m3534RN().eJb) {
            C1720g.m3528K(C11048d.class);
            AppMethodBeat.m2505o(129702);
            return;
        }
        AppMethodBeat.m2505o(129702);
    }

    static anx axM() {
        AppMethodBeat.m2504i(129703);
        anx anx = (anx) C42340f.auZ().mo34913e("GetSearchShowOutWxaApp_resp", anx.class);
        AppMethodBeat.m2505o(129703);
        return anx;
    }

    static {
        AppMethodBeat.m2504i(129705);
        AppMethodBeat.m2505o(129705);
    }
}
