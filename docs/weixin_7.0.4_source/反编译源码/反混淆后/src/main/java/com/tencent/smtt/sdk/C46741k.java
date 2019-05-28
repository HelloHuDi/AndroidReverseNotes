package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.k */
final class C46741k extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f18018a;
    /* renamed from: b */
    final /* synthetic */ Handler f18019b;

    C46741k(Context context, Handler handler) {
        this.f18018a = context;
        this.f18019b = handler;
    }

    public final void run() {
        AppMethodBeat.m2504i(63988);
        int a = C5813an.m8800a().mo12149a(true, this.f18018a);
        TbsDownloader.setAppContext(this.f18018a);
        TbsLog.m80434i("QbSdk", "QbSdk preinit ver is ".concat(String.valueOf(a)));
        if (a == 0) {
            C5813an.m8800a().mo12161b(this.f18018a, true);
        }
        TbsLog.m80434i("QbSdk", "preInit -- prepare initAndLoadSo");
        C5818o.m8863a(true).mo12196a(this.f18018a, false, false, null);
        C40978bv a2 = C40978bv.m71073a();
        a2.mo64920a(this.f18018a, null);
        boolean b = a2.mo64921b();
        this.f18019b.sendEmptyMessage(3);
        if (b) {
            this.f18019b.sendEmptyMessage(1);
            AppMethodBeat.m2505o(63988);
            return;
        }
        this.f18019b.sendEmptyMessage(2);
        AppMethodBeat.m2505o(63988);
    }
}
