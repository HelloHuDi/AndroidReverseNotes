package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

public class ae implements a {
    public final int requestCode = (ae.class.hashCode() & CdnLogic.kBizGeneric);

    public void onReady() {
    }

    public void aHw() {
    }

    protected ae() {
        AppMethodBeat.i(131946);
        AppMethodBeat.o(131946);
    }

    public final void aHx() {
        AppMethodBeat.i(131947);
        if (d.iW(17)) {
            onReady();
        }
        AppMethodBeat.o(131947);
    }

    public final void c(int i, int i2, Intent intent) {
        AppMethodBeat.i(131948);
        if (this.requestCode != i) {
            AppMethodBeat.o(131948);
        } else if (i2 == -1) {
            ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
            h.pN(0);
            onReady();
            AppMethodBeat.o(131948);
        } else if (i2 == 2) {
            ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
            aHw();
            AppMethodBeat.o(131948);
        } else {
            ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", Integer.valueOf(i2), Integer.valueOf(VERSION.SDK_INT));
            com.tencent.mm.plugin.report.service.h.pYm.a(366, 8, 1, false);
            aHx();
            AppMethodBeat.o(131948);
        }
    }
}
