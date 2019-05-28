package com.tencent.p177mm.sandbox.updater;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.plugin.cdndownloader.p1544i.C44726a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.C16395k;
import com.tencent.xweb.p1634b.C44831d;
import java.util.HashMap;

/* renamed from: com.tencent.mm.sandbox.updater.k */
public final class C46612k implements C40606a {

    /* renamed from: com.tencent.mm.sandbox.updater.k$a */
    public static final class C40610a {
        public static final C46612k xxn = new C46612k();

        static {
            AppMethodBeat.m2504i(28996);
            AppMethodBeat.m2505o(28996);
        }
    }

    /* synthetic */ C46612k(byte b) {
        this();
    }

    /* renamed from: aJ */
    public final boolean mo48466aJ(Intent intent) {
        AppMethodBeat.m2504i(28997);
        if (intent == null) {
            AppMethodBeat.m2505o(28997);
            return false;
        }
        C4990ab.m7417i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 4)));
        HashMap hashMap = new HashMap();
        if (intent.getIntExtra("intent_extra_download_type", 4) == 5) {
            hashMap.put("UpdaterCheckType", "1");
        } else {
            hashMap.put("UpdaterCheckType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        C16395k.m25215a(C4996ah.getContext(), hashMap);
        AppMethodBeat.m2505o(28997);
        return true;
    }

    /* renamed from: pc */
    public final void mo48469pc(boolean z) {
    }

    public final boolean isBusy() {
        AppMethodBeat.m2504i(28998);
        boolean isBusy = C16395k.isBusy();
        C4990ab.m7416i("MicroMsg.WCWebDownloadMgr", "bIsBusy = ".concat(String.valueOf(isBusy)));
        AppMethodBeat.m2505o(28998);
        return isBusy;
    }

    public final void onDestroy() {
    }

    private C46612k() {
        AppMethodBeat.m2504i(28999);
        C45287c.m83506iw(C4996ah.getContext());
        C44831d.m82031a(C44726a.bfd());
        AppMethodBeat.m2505o(28999);
    }
}
