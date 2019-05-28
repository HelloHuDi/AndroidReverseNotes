package com.tencent.p177mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.app.NoSpaceProfile */
public class NoSpaceProfile extends C1439e {
    public static final String ceo = (C4996ah.getPackageName() + ":nospace");

    static {
        AppMethodBeat.m2504i(15389);
        AppMethodBeat.m2505o(15389);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(15388);
        C25794l.m41016cT(ceo);
        C4988aa.initLanguage(C4996ah.getContext());
        C1266q.m2719Bz();
        AppMethodBeat.m2505o(15388);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
