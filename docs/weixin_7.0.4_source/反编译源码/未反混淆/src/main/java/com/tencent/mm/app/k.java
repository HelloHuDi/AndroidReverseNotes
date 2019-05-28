package com.tencent.mm.app;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public final class k {
    static ApplicationLike cdV;
    static String cev = "";
    String cew;
    String cex;
    long cey;
    long cez;

    public k(ApplicationLike applicationLike) {
        cdV = applicationLike;
        b.cdV = applicationLike;
    }

    static void a(ApplicationLike applicationLike) {
        AppMethodBeat.i(115033);
        if (applicationLike == null) {
            AppMethodBeat.o(115033);
        } else if (applicationLike == null || applicationLike.getApplication() == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
            AppMethodBeat.o(115033);
            throw tinkerRuntimeException;
        } else {
            HashMap hashMap;
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            if (tinkerResultIntent == null || ShareIntentUtil.be(tinkerResultIntent) != 0) {
                hashMap = null;
            } else {
                hashMap = ShareIntentUtil.bk(tinkerResultIntent);
            }
            if (hashMap != null) {
                a.eSh = (String) hashMap.get("patch.rev");
                ab.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s", a.eSh);
            }
            AppMethodBeat.o(115033);
        }
    }
}
