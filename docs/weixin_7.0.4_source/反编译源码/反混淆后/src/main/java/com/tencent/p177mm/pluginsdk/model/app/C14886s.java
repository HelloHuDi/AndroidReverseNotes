package com.tencent.p177mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.pluginsdk.model.app.s */
final class C14886s implements Runnable {
    private String appId = null;
    private int fOZ = 0;
    private C7306ak handler = null;
    private String url = null;

    public C14886s(C7306ak c7306ak, String str, int i, String str2) {
        this.handler = c7306ak;
        this.appId = str;
        this.fOZ = i;
        this.url = str2;
    }

    public final void run() {
        AppMethodBeat.m2504i(79362);
        if (this.appId == null || this.appId.length() == 0 || this.url == null || this.url.length() == 0) {
            AppMethodBeat.m2505o(79362);
            return;
        }
        C23247v c23247v = new C23247v(this.appId, this.fOZ, C5046bo.ano(this.url));
        Message obtain = Message.obtain();
        obtain.obj = c23247v;
        this.handler.sendMessage(obtain);
        AppMethodBeat.m2505o(79362);
    }
}
