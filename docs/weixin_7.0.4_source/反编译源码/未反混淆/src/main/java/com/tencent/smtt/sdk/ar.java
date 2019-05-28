package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;

class ar extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Context b;
    final /* synthetic */ an c;

    ar(an anVar, Context context, Context context2) {
        this.c = anVar;
        this.a = context;
        this.b = context2;
    }

    public void run() {
        AppMethodBeat.i(64401);
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
        try {
            File file = this.a == null ? new File(TbsShareManager.getHostCorePathAppDefined()) : TbsShareManager.isThirdPartyApp(this.b) ? (TbsShareManager.c(this.b) == null || !TbsShareManager.c(this.b).contains("decouple")) ? this.c.r(this.a) : this.c.q(this.a) : this.c.r(this.a);
            File r = this.c.r(this.b);
            int i = VERSION.SDK_INT;
            if (i != 19 && i < 21) {
                k.a(file, r, new as(this));
            }
            k.a(file, r, new at(this));
            TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
            AppMethodBeat.o(64401);
        } catch (Exception e) {
            AppMethodBeat.o(64401);
        }
    }
}
