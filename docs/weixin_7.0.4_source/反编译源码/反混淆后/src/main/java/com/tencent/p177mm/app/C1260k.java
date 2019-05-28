package com.tencent.p177mm.app;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

/* renamed from: com.tencent.mm.app.k */
public final class C1260k {
    static ApplicationLike cdV;
    static String cev = "";
    String cew;
    String cex;
    long cey;
    long cez;

    public C1260k(ApplicationLike applicationLike) {
        cdV = applicationLike;
        C1244b.cdV = applicationLike;
    }

    /* renamed from: a */
    static void m2699a(ApplicationLike applicationLike) {
        AppMethodBeat.m2504i(115033);
        if (applicationLike == null) {
            AppMethodBeat.m2505o(115033);
        } else if (applicationLike == null || applicationLike.getApplication() == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
            AppMethodBeat.m2505o(115033);
            throw tinkerRuntimeException;
        } else {
            HashMap hashMap;
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            if (tinkerResultIntent == null || ShareIntentUtil.m9355be(tinkerResultIntent) != 0) {
                hashMap = null;
            } else {
                hashMap = ShareIntentUtil.m9361bk(tinkerResultIntent);
            }
            if (hashMap != null) {
                C1760a.eSh = (String) hashMap.get("patch.rev");
                C4990ab.m7421w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s", C1760a.eSh);
            }
            AppMethodBeat.m2505o(115033);
        }
    }
}
