package com.tencent.p177mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.p229f.C1523a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.app.TMAssistantProfile */
public class TMAssistantProfile extends C1439e {
    public static final String ceo = (C4996ah.getPackageName() + ":TMAssistantDownloadSDKService");

    static {
        AppMethodBeat.m2504i(15404);
        AppMethodBeat.m2505o(15404);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(15403);
        C1523a.m3164bk(C4996ah.getContext());
        C25794l.m41016cT(ceo);
        C1266q.m2719Bz();
        AppMethodBeat.m2505o(15403);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return ceo;
    }
}
