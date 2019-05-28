package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

public class NoSpaceProfile extends e {
    public static final String ceo = (ah.getPackageName() + ":nospace");

    static {
        AppMethodBeat.i(15389);
        AppMethodBeat.o(15389);
    }

    public final void onCreate() {
        AppMethodBeat.i(15388);
        l.cT(ceo);
        aa.initLanguage(ah.getContext());
        q.Bz();
        AppMethodBeat.o(15388);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
