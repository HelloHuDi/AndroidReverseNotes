package com.tencent.luggage.bridge;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* renamed from: com.tencent.luggage.bridge.o */
public final class C37392o {
    C25684s bOF;
    C45120n bOG;
    public C32178f bOH;
    public C32181p bOI;
    public ConcurrentHashMap<String, C45119l> bOJ = new ConcurrentHashMap();
    private ConcurrentHashMap<String, C0985j> bOK = new ConcurrentHashMap();
    private ConcurrentHashMap<Integer, C0983h> bOL = new ConcurrentHashMap();
    private AtomicInteger bOM = new AtomicInteger(1);

    public C37392o(C25684s c25684s) {
        AppMethodBeat.m2504i(90736);
        this.bOF = c25684s;
        this.bOG = new C45120n(this);
        this.bOH = new C32178f(this.bOF);
        this.bOI = new C8858q(this);
        this.bOF.addJavascriptInterface(new C8859r(this.bOG), "_luggageBridgeNative");
        AppMethodBeat.m2505o(90736);
    }

    /* renamed from: bw */
    public final void mo60230bw(String str) {
        AppMethodBeat.m2504i(90737);
        this.bOF.mo43469by(str);
        AppMethodBeat.m2505o(90737);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C45118e mo60227a(C37390m c37390m, boolean z) {
        AppMethodBeat.m2504i(90738);
        try {
            C0986k c0986k = new C0986k(this.bOH, c37390m, z);
            C45119l c45119l = (C45119l) this.bOJ.get(c0986k.bOr);
            if (c45119l != null) {
                c45119l.mo52836a(c0986k);
            } else {
                C45124d.m82928e("LuggageBridge", "Invoke Listener Not Found: %s", c0986k.bOr);
                c0986k.mo3951a("system:function_not_exist", null);
            }
            if (c0986k.bOx) {
                C45118e wN = c0986k.mo3953wN();
                AppMethodBeat.m2505o(90738);
                return wN;
            }
            AppMethodBeat.m2505o(90738);
            return null;
        } catch (JSONException e) {
            C45124d.m82928e("LuggageBridge", "inflate Js2JavaInvokeContext failed: %s", e);
            AppMethodBeat.m2505o(90738);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo60228a(C37390m c37390m) {
        AppMethodBeat.m2504i(90739);
        try {
            C45124d.m82930i("LuggageBridge", "processEventFromJs, EventName = %s", new C0984i(c37390m).bOu);
            m62990a(r0);
            AppMethodBeat.m2505o(90739);
        } catch (JSONException e) {
            C45124d.m82928e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", e);
            AppMethodBeat.m2505o(90739);
        }
    }

    /* renamed from: a */
    private void m62990a(C0984i c0984i) {
        AppMethodBeat.m2504i(90740);
        if (((C0985j) this.bOK.get(c0984i.bOu)) == null) {
            C45124d.m82928e("LuggageBridge", "no listener for event: %s", c0984i.bOu);
            AppMethodBeat.m2505o(90740);
            return;
        }
        AppMethodBeat.m2505o(90740);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo60229b(C37390m c37390m) {
        AppMethodBeat.m2504i(90741);
        try {
            C32179g c32179g = new C32179g(c37390m);
            if (((C0983h) this.bOL.get(Integer.valueOf(c32179g.bOs))) == null) {
                C45124d.m82928e("LuggageBridge", "no listener for callback: %d", Integer.valueOf(c32179g.bOs));
                AppMethodBeat.m2505o(90741);
                return;
            }
            if (!c32179g.bOt) {
                this.bOL.remove(Integer.valueOf(c32179g.bOs));
            }
            AppMethodBeat.m2505o(90741);
        } catch (JSONException e) {
            C45124d.m82928e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", e);
            AppMethodBeat.m2505o(90741);
        }
    }
}
