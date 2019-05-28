package com.tencent.p177mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.freewifi.model.c */
public final class C3145c {
    private HandlerThread mvH;
    private C7306ak mvI;

    public final C7306ak byI() {
        AppMethodBeat.m2504i(20696);
        if (this.mvH == null) {
            this.mvH = C7305d.anM("FreeWifiHandlerThread_handlerThread");
            this.mvH.start();
        }
        if (this.mvI == null) {
            this.mvI = new C7306ak(this.mvH.getLooper());
        }
        C7306ak c7306ak = this.mvI;
        AppMethodBeat.m2505o(20696);
        return c7306ak;
    }

    public final void release() {
        AppMethodBeat.m2504i(20697);
        if (this.mvH != null) {
            this.mvH.quit();
            this.mvH = null;
        }
        this.mvI = null;
        AppMethodBeat.m2505o(20697);
    }
}
