package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.b */
public final class C42469b extends C38369p {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onDownloadAppStateChange";
    private static HashMap<String, C42469b> hzE = new HashMap();
    private C38244c hzD;

    private C42469b(final C38492q c38492q) {
        AppMethodBeat.m2504i(130646);
        this.hzD = new C38244c() {
            /* renamed from: bk */
            public final void mo22088bk(Object obj) {
                AppMethodBeat.m2504i(130644);
                if (obj instanceof AppbrandDownloadState) {
                    AppbrandDownloadState appbrandDownloadState = (AppbrandDownloadState) obj;
                    if (c38492q != null) {
                        C42469b.this.mo61031i(c38492q).mo61027AL(appbrandDownloadState.aCq().toString()).aCj();
                    }
                }
                AppMethodBeat.m2505o(130644);
            }
        };
        MMToClientEvent.m75199a(c38492q.getAppId(), this.hzD);
        c38492q.getRuntime().gNN.mo21486a(new C10137a() {
            /* renamed from: a */
            public final void mo6006a(String str, C45524b c45524b) {
                AppMethodBeat.m2504i(130645);
                if (c45524b == C45524b.DESTROYED) {
                    C4990ab.m7410d("MicroMsg.DownloadAppStateChangeEvent", "destroyed");
                    MMToClientEvent.m75200b(c38492q.getAppId(), C42469b.this.hzD);
                    C42469b.m75233f(c38492q);
                }
                AppMethodBeat.m2505o(130645);
            }
        });
        AppMethodBeat.m2505o(130646);
    }

    static {
        AppMethodBeat.m2504i(130650);
        AppMethodBeat.m2505o(130650);
    }

    /* renamed from: e */
    public static void m75232e(C38492q c38492q) {
        AppMethodBeat.m2504i(130647);
        if (hzE.containsKey(c38492q.getAppId())) {
            AppMethodBeat.m2505o(130647);
            return;
        }
        hzE.put(c38492q.getAppId(), new C42469b(c38492q));
        AppMethodBeat.m2505o(130647);
    }

    /* renamed from: a */
    public static void m75231a(AppbrandDownloadState appbrandDownloadState) {
        AppMethodBeat.m2504i(130648);
        for (String a : hzE.keySet()) {
            C10276d.m17931a(a, appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130648);
    }

    /* renamed from: f */
    static /* synthetic */ void m75233f(C38492q c38492q) {
        AppMethodBeat.m2504i(130649);
        hzE.remove(c38492q.getAppId());
        AppMethodBeat.m2505o(130649);
    }
}
