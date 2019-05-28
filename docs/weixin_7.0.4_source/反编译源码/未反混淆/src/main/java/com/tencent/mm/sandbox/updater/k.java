package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.b.d;
import java.util.HashMap;

public final class k implements a {

    public static final class a {
        public static final k xxn = new k();

        static {
            AppMethodBeat.i(28996);
            AppMethodBeat.o(28996);
        }
    }

    /* synthetic */ k(byte b) {
        this();
    }

    public final boolean aJ(Intent intent) {
        AppMethodBeat.i(28997);
        if (intent == null) {
            AppMethodBeat.o(28997);
            return false;
        }
        ab.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 4)));
        HashMap hashMap = new HashMap();
        if (intent.getIntExtra("intent_extra_download_type", 4) == 5) {
            hashMap.put("UpdaterCheckType", "1");
        } else {
            hashMap.put("UpdaterCheckType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        com.tencent.xweb.k.a(ah.getContext(), hashMap);
        AppMethodBeat.o(28997);
        return true;
    }

    public final void pc(boolean z) {
    }

    public final boolean isBusy() {
        AppMethodBeat.i(28998);
        boolean isBusy = com.tencent.xweb.k.isBusy();
        ab.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = ".concat(String.valueOf(isBusy)));
        AppMethodBeat.o(28998);
        return isBusy;
    }

    public final void onDestroy() {
    }

    private k() {
        AppMethodBeat.i(28999);
        c.iw(ah.getContext());
        d.a(com.tencent.mm.plugin.cdndownloader.i.a.bfd());
        AppMethodBeat.o(28999);
    }
}
