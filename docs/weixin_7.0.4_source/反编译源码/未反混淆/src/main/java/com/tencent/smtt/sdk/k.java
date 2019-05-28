package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class k extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Handler b;

    k(Context context, Handler handler) {
        this.a = context;
        this.b = handler;
    }

    public final void run() {
        AppMethodBeat.i(63988);
        int a = an.a().a(true, this.a);
        TbsDownloader.setAppContext(this.a);
        TbsLog.i("QbSdk", "QbSdk preinit ver is ".concat(String.valueOf(a)));
        if (a == 0) {
            an.a().b(this.a, true);
        }
        TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
        o.a(true).a(this.a, false, false, null);
        bv a2 = bv.a();
        a2.a(this.a, null);
        boolean b = a2.b();
        this.b.sendEmptyMessage(3);
        if (b) {
            this.b.sendEmptyMessage(1);
            AppMethodBeat.o(63988);
            return;
        }
        this.b.sendEmptyMessage(2);
        AppMethodBeat.o(63988);
    }
}
