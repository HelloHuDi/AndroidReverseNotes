package com.tencent.p177mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ae */
public class C45635ae implements C5186a {
    public final int requestCode = (C45635ae.class.hashCode() & CdnLogic.kBizGeneric);

    public void onReady() {
    }

    public void aHw() {
    }

    protected C45635ae() {
        AppMethodBeat.m2504i(131946);
        AppMethodBeat.m2505o(131946);
    }

    public final void aHx() {
        AppMethodBeat.m2504i(131947);
        if (C1443d.m3068iW(17)) {
            onReady();
        }
        AppMethodBeat.m2505o(131947);
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(131948);
        if (this.requestCode != i) {
            AppMethodBeat.m2505o(131948);
        } else if (i2 == -1) {
            C4990ab.m7416i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
            C45694h.m84430pN(0);
            onReady();
            AppMethodBeat.m2505o(131948);
        } else if (i2 == 2) {
            C4990ab.m7416i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
            aHw();
            AppMethodBeat.m2505o(131948);
        } else {
            C4990ab.m7417i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", Integer.valueOf(i2), Integer.valueOf(VERSION.SDK_INT));
            C7060h.pYm.mo8378a(366, 8, 1, false);
            aHx();
            AppMethodBeat.m2505o(131948);
        }
    }
}
