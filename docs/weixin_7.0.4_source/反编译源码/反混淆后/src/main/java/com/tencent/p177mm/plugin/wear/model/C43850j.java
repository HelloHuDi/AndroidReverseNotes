package com.tencent.p177mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.wear.model.p576f.C40186d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.wear.model.j */
public final class C43850j {
    HandlerThread handlerThread;
    C7306ak ilv;

    /* renamed from: com.tencent.mm.plugin.wear.model.j$a */
    class C43849a extends C7306ak {
        public C43849a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(26353);
            C40186d c40186d = (C40186d) message.obj;
            if (c40186d != null) {
                try {
                    c40186d.run();
                    AppMethodBeat.m2505o(26353);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.WearWorker", e.getCause(), "run task %s occur exception", c40186d.getName());
                }
            }
            AppMethodBeat.m2505o(26353);
        }
    }

    public C43850j() {
        AppMethodBeat.m2504i(26354);
        if (C1443d.m3069iX(18)) {
            this.handlerThread = C7305d.anM("WearWorker_worker_thread");
            this.handlerThread.start();
            this.ilv = new C43849a(this.handlerThread.getLooper());
            C4990ab.m7417i("MicroMsg.Wear.WearWorker", "start worker %d", Integer.valueOf(this.handlerThread.getThreadId()));
        }
        AppMethodBeat.m2505o(26354);
    }

    /* renamed from: a */
    public final void mo69532a(C40186d c40186d) {
        AppMethodBeat.m2504i(26355);
        if (this.ilv != null) {
            this.ilv.sendMessage(this.ilv.obtainMessage(0, c40186d));
        }
        AppMethodBeat.m2505o(26355);
    }
}
