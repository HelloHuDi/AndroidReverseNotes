package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* renamed from: com.tencent.smtt.sdk.ar */
class C46736ar extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f18006a;
    /* renamed from: b */
    final /* synthetic */ Context f18007b;
    /* renamed from: c */
    final /* synthetic */ C5813an f18008c;

    C46736ar(C5813an c5813an, Context context, Context context2) {
        this.f18008c = c5813an;
        this.f18006a = context;
        this.f18007b = context2;
    }

    public void run() {
        AppMethodBeat.m2504i(64401);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
        try {
            File file = this.f18006a == null ? new File(TbsShareManager.getHostCorePathAppDefined()) : TbsShareManager.isThirdPartyApp(this.f18007b) ? (TbsShareManager.m49467c(this.f18007b) == null || !TbsShareManager.m49467c(this.f18007b).contains("decouple")) ? this.f18008c.mo12183r(this.f18006a) : this.f18008c.mo12182q(this.f18006a) : this.f18008c.mo12183r(this.f18006a);
            File r = this.f18008c.mo12183r(this.f18007b);
            int i = VERSION.SDK_INT;
            if (i != 19 && i < 21) {
                C30950k.m49556a(file, r, new C40974as(this));
            }
            C30950k.m49556a(file, r, new C36435at(this));
            TbsLog.m80434i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
            AppMethodBeat.m2505o(64401);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64401);
        }
    }
}
