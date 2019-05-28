package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends h {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    static final class a extends p {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(u uVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(123534);
        super.a(uVar, jSONObject, i);
        AppMethodBeat.o(123534);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aDy() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aDz() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(e eVar, JSONObject jSONObject, u uVar, int i) {
        AppMethodBeat.i(123535);
        if (super.a(eVar, jSONObject, uVar, i)) {
            eVar.jjF = Boolean.TRUE;
            eVar.jjj = "emoji";
            eVar.jjk = false;
            eVar.jjl = false;
            eVar.jjL = Boolean.FALSE;
            eVar.jjG = Boolean.valueOf(jSONObject.optBoolean("confirm", true));
            AppMethodBeat.o(123535);
            return true;
        }
        AppMethodBeat.o(123535);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(final i iVar) {
        AppMethodBeat.i(123536);
        super.a(iVar);
        iVar.jdM = new c() {
            public final void db(int i, int i2) {
                u uVar;
                AppMethodBeat.i(123528);
                int i3 = iVar.jdU;
                b nU = v.Zp().nU("AppBrandJsInput@".concat(String.valueOf(i3)));
                if (nU == null) {
                    uVar = null;
                } else {
                    WeakReference weakReference = (WeakReference) nU.get("webview_reference", null);
                    uVar = weakReference == null ? null : (u) weakReference.get();
                }
                if (uVar == null || !uVar.isRunning()) {
                    AppMethodBeat.o(123528);
                    return;
                }
                a aVar = new a();
                HashMap hashMap = new HashMap();
                hashMap.put("height", Integer.valueOf(g.qa(i2)));
                hashMap.put("lineCount", Integer.valueOf(i));
                hashMap.put("inputId", Integer.valueOf(i3));
                aVar.i(uVar).t(hashMap).aCj();
                AppMethodBeat.o(123528);
            }
        };
        AppMethodBeat.o(123536);
    }

    /* Access modifiers changed, original: protected|final */
    public final i a(final WeakReference<u> weakReference, final String str, final int i) {
        AppMethodBeat.i(123537);
        AnonymousClass2 anonymousClass2 = new x() {
            public final void b(String str, int i, boolean z, boolean z2) {
                AppMethodBeat.i(123529);
                if (weakReference.get() != null) {
                    try {
                        String jSONObject = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.s.e.Ei(str)).put("inputId", this.jdU).put("cursor", i).toString();
                        if (z) {
                            ((u) weakReference.get()).h("onKeyboardConfirm", jSONObject, 0);
                        }
                        if (!z2) {
                            ((u) weakReference.get()).h("onKeyboardComplete", jSONObject, 0);
                        }
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", bo.l(e));
                    }
                    if (!z2) {
                        aDC();
                    }
                }
                AppMethodBeat.o(123529);
            }

            public final void aDA() {
                AppMethodBeat.i(123530);
                if (weakReference.get() != null) {
                    int i = this.jdU;
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(i));
                    ((u) weakReference.get()).M(i, d.this.j("ok", hashMap));
                    a.S(i, str);
                    a.a(i, (u) weakReference.get());
                }
                AppMethodBeat.o(123530);
            }

            public final void Ba(String str) {
                AppMethodBeat.i(123531);
                u uVar = (u) weakReference.get();
                if (uVar == null) {
                    AppMethodBeat.o(123531);
                    return;
                }
                try {
                    int i = this.jdU;
                    new com.tencent.mm.plugin.appbrand.jsapi.d.h.a().b(uVar.getRuntime().xT(), uVar.hashCode()).AL(new JSONObject().put("value", com.tencent.mm.plugin.appbrand.s.e.Ei(str)).put("data", a.ol(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8).toString()).aCj();
                    AppMethodBeat.o(123531);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", e);
                    AppMethodBeat.o(123531);
                }
            }

            public final void aDB() {
                AppMethodBeat.i(123532);
                if (weakReference.get() != null) {
                    ((u) weakReference.get()).M(i, d.this.j("fail", null));
                    aDC();
                }
                AppMethodBeat.o(123532);
            }

            private void aDC() {
                AppMethodBeat.i(123533);
                u uVar = (u) weakReference.get();
                if (uVar == null || uVar.aJz() == null) {
                    AppMethodBeat.o(123533);
                    return;
                }
                h.aQx().d(uVar.aJz());
                AppMethodBeat.o(123533);
            }
        };
        AppMethodBeat.o(123537);
        return anonymousClass2;
    }
}
