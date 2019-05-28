package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C33299l.C19358a;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.f */
public class C46892f extends C45593d<C38492q> {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    private volatile C10137a hKL;
    C33297k hKM;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.f$1 */
    class C103751 implements C10137a {
        C103751() {
        }

        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            AppMethodBeat.m2504i(74740);
            if (c45524b == C45524b.DESTROYED) {
                C46892f.this.hKK.quit();
                AppMethodBeat.m2505o(74740);
            } else if (c45524b == C45524b.SUSPEND) {
                C46892f.this.hKK.sendMessage(3);
                AppMethodBeat.m2505o(74740);
            } else {
                if (c45524b == C45524b.FOREGROUND) {
                    C46892f.this.hKK.sendMessage(4);
                }
                AppMethodBeat.m2505o(74740);
            }
        }
    }

    /* renamed from: c */
    public final /* synthetic */ void mo6150c(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74742);
        final C38492q c38492q = (C38492q) c2241c;
        super.mo6150c(c38492q, jSONObject, i);
        synchronized (this) {
            try {
                if (this.hKL == null) {
                    this.hKL = new C103751();
                    c38492q.getRuntime().gNN.mo21486a(this.hKL);
                    this.hKM = new C33297k();
                    this.hKK.hKV = new C19358a() {
                        /* renamed from: Bb */
                        public final void mo6148Bb(String str) {
                            AppMethodBeat.m2504i(74741);
                            Object obj = -1;
                            switch (str.hashCode()) {
                                case -1562453447:
                                    if (str.equals("StateNotListening")) {
                                        obj = 1;
                                        break;
                                    }
                                    break;
                                case -1514425717:
                                    if (str.equals("StateSuspend")) {
                                        obj = 2;
                                        break;
                                    }
                                    break;
                                case 1073716042:
                                    if (str.equals("StateListening")) {
                                        obj = null;
                                        break;
                                    }
                                    break;
                            }
                            switch (obj) {
                                case null:
                                    C46892f.this.hKM.mo53817w(c38492q.getRuntime());
                                    AppMethodBeat.m2505o(74741);
                                    return;
                                case 1:
                                    C46892f.this.hKM.aDE();
                                    break;
                            }
                            AppMethodBeat.m2505o(74741);
                        }
                    };
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(74742);
            }
        }
    }
}
