package com.tencent.luggage.bridge;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public final class o {
    s bOF;
    n bOG;
    public f bOH;
    public p bOI;
    public ConcurrentHashMap<String, l> bOJ = new ConcurrentHashMap();
    private ConcurrentHashMap<String, j> bOK = new ConcurrentHashMap();
    private ConcurrentHashMap<Integer, h> bOL = new ConcurrentHashMap();
    private AtomicInteger bOM = new AtomicInteger(1);

    public o(s sVar) {
        AppMethodBeat.i(90736);
        this.bOF = sVar;
        this.bOG = new n(this);
        this.bOH = new f(this.bOF);
        this.bOI = new q(this);
        this.bOF.addJavascriptInterface(new r(this.bOG), "_luggageBridgeNative");
        AppMethodBeat.o(90736);
    }

    public final void bw(String str) {
        AppMethodBeat.i(90737);
        this.bOF.by(str);
        AppMethodBeat.o(90737);
    }

    /* Access modifiers changed, original: final */
    public final e a(m mVar, boolean z) {
        AppMethodBeat.i(90738);
        try {
            k kVar = new k(this.bOH, mVar, z);
            l lVar = (l) this.bOJ.get(kVar.bOr);
            if (lVar != null) {
                lVar.a(kVar);
            } else {
                d.e("LuggageBridge", "Invoke Listener Not Found: %s", kVar.bOr);
                kVar.a("system:function_not_exist", null);
            }
            if (kVar.bOx) {
                e wN = kVar.wN();
                AppMethodBeat.o(90738);
                return wN;
            }
            AppMethodBeat.o(90738);
            return null;
        } catch (JSONException e) {
            d.e("LuggageBridge", "inflate Js2JavaInvokeContext failed: %s", e);
            AppMethodBeat.o(90738);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(m mVar) {
        AppMethodBeat.i(90739);
        try {
            d.i("LuggageBridge", "processEventFromJs, EventName = %s", new i(mVar).bOu);
            a(r0);
            AppMethodBeat.o(90739);
        } catch (JSONException e) {
            d.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", e);
            AppMethodBeat.o(90739);
        }
    }

    private void a(i iVar) {
        AppMethodBeat.i(90740);
        if (((j) this.bOK.get(iVar.bOu)) == null) {
            d.e("LuggageBridge", "no listener for event: %s", iVar.bOu);
            AppMethodBeat.o(90740);
            return;
        }
        AppMethodBeat.o(90740);
    }

    /* Access modifiers changed, original: final */
    public final void b(m mVar) {
        AppMethodBeat.i(90741);
        try {
            g gVar = new g(mVar);
            if (((h) this.bOL.get(Integer.valueOf(gVar.bOs))) == null) {
                d.e("LuggageBridge", "no listener for callback: %d", Integer.valueOf(gVar.bOs));
                AppMethodBeat.o(90741);
                return;
            }
            if (!gVar.bOt) {
                this.bOL.remove(Integer.valueOf(gVar.bOs));
            }
            AppMethodBeat.o(90741);
        } catch (JSONException e) {
            d.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", e);
            AppMethodBeat.o(90741);
        }
    }
}
