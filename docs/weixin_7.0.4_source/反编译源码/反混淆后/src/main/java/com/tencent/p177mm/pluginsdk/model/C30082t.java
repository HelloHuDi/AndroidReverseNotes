package com.tencent.p177mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.model.t */
public final class C30082t extends FileObserver {
    private String qlC;
    private C30083a vbH;

    /* renamed from: com.tencent.mm.pluginsdk.model.t$a */
    public interface C30083a {
        void csU();
    }

    public C30082t(String str, C30083a c30083a) {
        super(str);
        AppMethodBeat.m2504i(79226);
        C4990ab.m7416i("MicroMsg.ScreenshotObserver", "observer  ".concat(String.valueOf(str)));
        this.vbH = c30083a;
        AppMethodBeat.m2505o(79226);
    }

    public final void onEvent(int i, String str) {
        AppMethodBeat.m2504i(79227);
        if (str != null && i == 8 && (this.qlC == null || !str.equalsIgnoreCase(this.qlC))) {
            this.qlC = str;
            this.vbH.csU();
            C4990ab.m7416i("MicroMsg.ScreenshotObserver", "Send event to listener. ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(79227);
    }

    public final void start() {
        AppMethodBeat.m2504i(79228);
        super.startWatching();
        AppMethodBeat.m2505o(79228);
    }

    public final void stop() {
        AppMethodBeat.m2504i(79229);
        super.stopWatching();
        AppMethodBeat.m2505o(79229);
    }
}
