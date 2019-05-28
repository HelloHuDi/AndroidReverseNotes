package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class s implements Runnable {
    private String appId = null;
    private int fOZ = 0;
    private ak handler = null;
    private String url = null;

    public s(ak akVar, String str, int i, String str2) {
        this.handler = akVar;
        this.appId = str;
        this.fOZ = i;
        this.url = str2;
    }

    public final void run() {
        AppMethodBeat.i(79362);
        if (this.appId == null || this.appId.length() == 0 || this.url == null || this.url.length() == 0) {
            AppMethodBeat.o(79362);
            return;
        }
        v vVar = new v(this.appId, this.fOZ, bo.ano(this.url));
        Message obtain = Message.obtain();
        obtain.obj = vVar;
        this.handler.sendMessage(obtain);
        AppMethodBeat.o(79362);
    }
}
