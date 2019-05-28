package com.tencent.p177mm.plugin.websearch.api;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5510e.C5505l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5141c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.websearch.api.aj */
public class C4510aj {
    private static volatile C4510aj uaG;
    private C5004al fPG;
    private volatile boolean uaB = false;
    private volatile boolean uaC = false;
    private volatile Boolean uaD;
    private C46403l uaE = new C29738ae();
    private Map<Integer, C22750ak> uaF;

    /* renamed from: com.tencent.mm.plugin.websearch.api.aj$2 */
    class C45122 implements Runnable {
        C45122() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124178);
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100344");
            if (ll == null) {
                C4990ab.m7416i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
                AppMethodBeat.m2505o(124178);
                return;
            }
            C4510aj c4510aj = C4510aj.this;
            boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpen"));
            c4510aj.uaB = z;
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload :%b", Boolean.valueOf(C4510aj.this.uaB));
            c42142a = C32718b.eGM;
            ll = C42142a.m74295ll("100346");
            if (ll == null) {
                C4990ab.m7416i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
                AppMethodBeat.m2505o(124178);
                return;
            }
            c4510aj = C4510aj.this;
            if (ll.isValid() && "1".equals(ll.dru().get("isOpen"))) {
                z = true;
            } else {
                z = false;
            }
            c4510aj.uaC = z;
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchPreloadExport", "openRecommendPreload :%b", Boolean.valueOf(C4510aj.this.uaC));
            AppMethodBeat.m2505o(124178);
        }
    }

    private C4510aj() {
        AppMethodBeat.m2504i(124179);
        AppMethodBeat.m2505o(124179);
    }

    public static C4510aj cVp() {
        AppMethodBeat.m2504i(124180);
        if (uaG == null) {
            synchronized (C4510aj.class) {
                try {
                    if (uaG == null) {
                        uaG = new C4510aj();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(124180);
                    }
                }
            }
        }
        C4510aj c4510aj = uaG;
        AppMethodBeat.m2505o(124180);
        return c4510aj;
    }

    /* renamed from: Ih */
    public final C46403l mo9576Ih(int i) {
        AppMethodBeat.m2504i(124181);
        C46403l c46403l;
        if (i <= 0) {
            c46403l = this.uaE;
            AppMethodBeat.m2505o(124181);
            return c46403l;
        }
        if (this.uaF == null) {
            this.uaF = new HashMap();
        }
        c46403l = (C22750ak) this.uaF.get(Integer.valueOf(i));
        if (c46403l == null) {
            c46403l = new C22750ak(i);
            this.uaF.put(Integer.valueOf(i), c46403l);
        }
        AppMethodBeat.m2505o(124181);
        return c46403l;
    }

    /* renamed from: dy */
    public final void mo9581dy(final String str, final int i) {
        AppMethodBeat.m2504i(124182);
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebview 1 %s", C4996ah.getProcessName());
        if (C4996ah.doF()) {
            mo9576Ih(i).adF(str);
            AppMethodBeat.m2505o(124182);
            return;
        }
        if (C4996ah.bqo()) {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    boolean cVr;
                    AppMethodBeat.m2504i(124177);
                    C4510aj c4510aj = C4510aj.this;
                    switch (i) {
                        case 1:
                            cVr = c4510aj.cVr();
                            break;
                        case 2:
                            cVr = c4510aj.cVs();
                            break;
                        case 4:
                            cVr = c4510aj.cVr();
                            break;
                        case 5:
                            cVr = true;
                            break;
                        default:
                            C4990ab.m7421w("MicroMsg.WebSearch.WebSearchPreloadExport", "unknown preload biz %d", Integer.valueOf(i));
                            cVr = false;
                            break;
                    }
                    if (cVr) {
                        C4990ab.m7416i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
                        C4510aj.m6893J("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", str, i);
                        AppMethodBeat.m2505o(124177);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.WebSearch.WebSearchPreloadExport", "preload switch close , biz %d, url %s", Integer.valueOf(i), str);
                    AppMethodBeat.m2505o(124177);
                }
            });
        }
        AppMethodBeat.m2505o(124182);
    }

    /* renamed from: nE */
    public final void mo9582nE(boolean z) {
        AppMethodBeat.m2504i(124183);
        this.uaD = Boolean.valueOf(z);
        AppMethodBeat.m2505o(124183);
    }

    public final void cVq() {
        AppMethodBeat.m2504i(124184);
        if (this.fPG == null) {
            this.fPG = new C5004al();
            this.fPG.mo10302aa(new C45122());
        }
        AppMethodBeat.m2505o(124184);
    }

    public final boolean cVr() {
        AppMethodBeat.m2504i(124185);
        boolean booleanValue;
        if (this.uaD != null) {
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload cmdPreloadSwitch %b", this.uaD);
            booleanValue = this.uaD.booleanValue();
            AppMethodBeat.m2505o(124185);
            return booleanValue;
        } else if (C46400aa.m87305HV(0) < 80007181) {
            C4990ab.m7412e("MicroMsg.WebSearch.WebSearchPreloadExport", "current search template not support preload");
            AppMethodBeat.m2505o(124185);
            return false;
        } else {
            booleanValue = this.uaB;
            AppMethodBeat.m2505o(124185);
            return booleanValue;
        }
    }

    public final boolean cVs() {
        AppMethodBeat.m2504i(124186);
        boolean booleanValue;
        if (this.uaD != null) {
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchPreloadExport", "isOpenRecommendPreload cmdPreloadSwitch %b", this.uaD);
            booleanValue = this.uaD.booleanValue();
            AppMethodBeat.m2505o(124186);
            return booleanValue;
        }
        booleanValue = this.uaC;
        AppMethodBeat.m2505o(124186);
        return booleanValue;
    }

    /* renamed from: Ii */
    public final boolean mo9577Ii(int i) {
        AppMethodBeat.m2504i(124187);
        if (C4996ah.bqo()) {
            boolean cVr;
            switch (i) {
                case 1:
                    cVr = cVr();
                    AppMethodBeat.m2505o(124187);
                    return cVr;
                case 2:
                    cVr = cVs();
                    AppMethodBeat.m2505o(124187);
                    return cVr;
                default:
                    AppMethodBeat.m2505o(124187);
                    return false;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("please call from main process");
        AppMethodBeat.m2505o(124187);
        throw illegalStateException;
    }

    /* renamed from: J */
    static /* synthetic */ void m6893J(String str, String str2, int i) {
        AppMethodBeat.m2504i(124188);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_param_preload_url", str2);
        intent.putExtra("tools_process_action_code_key", str);
        intent.putExtra("tools_param_preload_search_biz", i);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(124188);
    }
}
