package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ah;

public class TMAssistantProfile extends e {
    public static final String ceo = (ah.getPackageName() + ":TMAssistantDownloadSDKService");

    static {
        AppMethodBeat.i(15404);
        AppMethodBeat.o(15404);
    }

    public final void onCreate() {
        AppMethodBeat.i(15403);
        a.bk(ah.getContext());
        l.cT(ceo);
        q.Bz();
        AppMethodBeat.o(15403);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return ceo;
    }
}
