package com.tencent.mm.plugin.websearch.api;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.e.l;
import java.util.HashMap;
import java.util.Map;

public class aj {
    private static volatile aj uaG;
    private al fPG;
    private volatile boolean uaB = false;
    private volatile boolean uaC = false;
    private volatile Boolean uaD;
    private l uaE = new ae();
    private Map<Integer, ak> uaF;

    private aj() {
        AppMethodBeat.i(124179);
        AppMethodBeat.o(124179);
    }

    public static aj cVp() {
        AppMethodBeat.i(124180);
        if (uaG == null) {
            synchronized (aj.class) {
                try {
                    if (uaG == null) {
                        uaG = new aj();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(124180);
                    }
                }
            }
        }
        aj ajVar = uaG;
        AppMethodBeat.o(124180);
        return ajVar;
    }

    public final l Ih(int i) {
        AppMethodBeat.i(124181);
        l lVar;
        if (i <= 0) {
            lVar = this.uaE;
            AppMethodBeat.o(124181);
            return lVar;
        }
        if (this.uaF == null) {
            this.uaF = new HashMap();
        }
        lVar = (ak) this.uaF.get(Integer.valueOf(i));
        if (lVar == null) {
            lVar = new ak(i);
            this.uaF.put(Integer.valueOf(i), lVar);
        }
        AppMethodBeat.o(124181);
        return lVar;
    }

    public final void dy(final String str, final int i) {
        AppMethodBeat.i(124182);
        ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebview 1 %s", ah.getProcessName());
        if (ah.doF()) {
            Ih(i).adF(str);
            AppMethodBeat.o(124182);
            return;
        }
        if (ah.bqo()) {
            g.RS().aa(new Runnable() {
                public final void run() {
                    boolean cVr;
                    AppMethodBeat.i(124177);
                    aj ajVar = aj.this;
                    switch (i) {
                        case 1:
                            cVr = ajVar.cVr();
                            break;
                        case 2:
                            cVr = ajVar.cVs();
                            break;
                        case 4:
                            cVr = ajVar.cVr();
                            break;
                        case 5:
                            cVr = true;
                            break;
                        default:
                            ab.w("MicroMsg.WebSearch.WebSearchPreloadExport", "unknown preload biz %d", Integer.valueOf(i));
                            cVr = false;
                            break;
                    }
                    if (cVr) {
                        ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
                        aj.J("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", str, i);
                        AppMethodBeat.o(124177);
                        return;
                    }
                    ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preload switch close , biz %d, url %s", Integer.valueOf(i), str);
                    AppMethodBeat.o(124177);
                }
            });
        }
        AppMethodBeat.o(124182);
    }

    public final void nE(boolean z) {
        AppMethodBeat.i(124183);
        this.uaD = Boolean.valueOf(z);
        AppMethodBeat.o(124183);
    }

    public final void cVq() {
        AppMethodBeat.i(124184);
        if (this.fPG == null) {
            this.fPG = new al();
            this.fPG.aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(124178);
                    a aVar = b.eGM;
                    c ll = a.ll("100344");
                    if (ll == null) {
                        ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
                        AppMethodBeat.o(124178);
                        return;
                    }
                    aj ajVar = aj.this;
                    boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpen"));
                    ajVar.uaB = z;
                    ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload :%b", Boolean.valueOf(aj.this.uaB));
                    aVar = b.eGM;
                    ll = a.ll("100346");
                    if (ll == null) {
                        ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
                        AppMethodBeat.o(124178);
                        return;
                    }
                    ajVar = aj.this;
                    if (ll.isValid() && "1".equals(ll.dru().get("isOpen"))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ajVar.uaC = z;
                    ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openRecommendPreload :%b", Boolean.valueOf(aj.this.uaC));
                    AppMethodBeat.o(124178);
                }
            });
        }
        AppMethodBeat.o(124184);
    }

    public final boolean cVr() {
        AppMethodBeat.i(124185);
        boolean booleanValue;
        if (this.uaD != null) {
            ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload cmdPreloadSwitch %b", this.uaD);
            booleanValue = this.uaD.booleanValue();
            AppMethodBeat.o(124185);
            return booleanValue;
        } else if (aa.HV(0) < 80007181) {
            ab.e("MicroMsg.WebSearch.WebSearchPreloadExport", "current search template not support preload");
            AppMethodBeat.o(124185);
            return false;
        } else {
            booleanValue = this.uaB;
            AppMethodBeat.o(124185);
            return booleanValue;
        }
    }

    public final boolean cVs() {
        AppMethodBeat.i(124186);
        boolean booleanValue;
        if (this.uaD != null) {
            ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "isOpenRecommendPreload cmdPreloadSwitch %b", this.uaD);
            booleanValue = this.uaD.booleanValue();
            AppMethodBeat.o(124186);
            return booleanValue;
        }
        booleanValue = this.uaC;
        AppMethodBeat.o(124186);
        return booleanValue;
    }

    public final boolean Ii(int i) {
        AppMethodBeat.i(124187);
        if (ah.bqo()) {
            boolean cVr;
            switch (i) {
                case 1:
                    cVr = cVr();
                    AppMethodBeat.o(124187);
                    return cVr;
                case 2:
                    cVr = cVs();
                    AppMethodBeat.o(124187);
                    return cVr;
                default:
                    AppMethodBeat.o(124187);
                    return false;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("please call from main process");
        AppMethodBeat.o(124187);
        throw illegalStateException;
    }

    static /* synthetic */ void J(String str, String str2, int i) {
        AppMethodBeat.i(124188);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_param_preload_url", str2);
        intent.putExtra("tools_process_action_code_key", str);
        intent.putExtra("tools_param_preload_search_biz", i);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(124188);
    }
}
