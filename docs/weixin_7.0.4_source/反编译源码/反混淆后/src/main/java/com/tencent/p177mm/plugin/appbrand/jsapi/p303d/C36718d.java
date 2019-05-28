package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19875h;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19881i;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19881i.C19884c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C33637x;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C16712e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.d */
public final class C36718d extends C33289h {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.d$a */
    static final class C33286a extends C38369p {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";

        private C33286a() {
        }

        /* synthetic */ C33286a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final void mo53801a(C44709u c44709u, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(123534);
        super.mo53801a(c44709u, jSONObject, i);
        AppMethodBeat.m2505o(123534);
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
    /* renamed from: a */
    public final boolean mo53803a(C16712e c16712e, JSONObject jSONObject, C44709u c44709u, int i) {
        AppMethodBeat.m2504i(123535);
        if (super.mo53803a(c16712e, jSONObject, c44709u, i)) {
            c16712e.jjF = Boolean.TRUE;
            c16712e.jjj = "emoji";
            c16712e.jjk = false;
            c16712e.jjl = false;
            c16712e.jjL = Boolean.FALSE;
            c16712e.jjG = Boolean.valueOf(jSONObject.optBoolean("confirm", true));
            AppMethodBeat.m2505o(123535);
            return true;
        }
        AppMethodBeat.m2505o(123535);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo53802a(final C19881i c19881i) {
        AppMethodBeat.m2504i(123536);
        super.mo53802a(c19881i);
        c19881i.jdM = new C19884c() {
            /* renamed from: db */
            public final void mo35133db(int i, int i2) {
                C44709u c44709u;
                AppMethodBeat.m2504i(123528);
                int i3 = c19881i.jdU;
                C32800b nU = C37922v.m64076Zp().mo60673nU("AppBrandJsInput@".concat(String.valueOf(i3)));
                if (nU == null) {
                    c44709u = null;
                } else {
                    WeakReference weakReference = (WeakReference) nU.get("webview_reference", null);
                    c44709u = weakReference == null ? null : (C44709u) weakReference.get();
                }
                if (c44709u == null || !c44709u.isRunning()) {
                    AppMethodBeat.m2505o(123528);
                    return;
                }
                C33286a c33286a = new C33286a();
                HashMap hashMap = new HashMap();
                hashMap.put("height", Integer.valueOf(C42668g.m75570qa(i2)));
                hashMap.put("lineCount", Integer.valueOf(i));
                hashMap.put("inputId", Integer.valueOf(i3));
                c33286a.mo61031i(c44709u).mo34958t(hashMap).aCj();
                AppMethodBeat.m2505o(123528);
            }
        };
        AppMethodBeat.m2505o(123536);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C19881i mo53800a(final WeakReference<C44709u> weakReference, final String str, final int i) {
        AppMethodBeat.m2504i(123537);
        C367192 c367192 = new C33637x() {
            /* renamed from: b */
            public final void mo21854b(String str, int i, boolean z, boolean z2) {
                AppMethodBeat.m2504i(123529);
                if (weakReference.get() != null) {
                    try {
                        String jSONObject = new JSONObject().put("value", C42677e.m75578Ei(str)).put("inputId", this.jdU).put("cursor", i).toString();
                        if (z) {
                            ((C44709u) weakReference.get()).mo51255h("onKeyboardConfirm", jSONObject, 0);
                        }
                        if (!z2) {
                            ((C44709u) weakReference.get()).mo51255h("onKeyboardComplete", jSONObject, 0);
                        }
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", C5046bo.m7574l(e));
                    }
                    if (!z2) {
                        aDC();
                    }
                }
                AppMethodBeat.m2505o(123529);
            }

            public final void aDA() {
                AppMethodBeat.m2504i(123530);
                if (weakReference.get() != null) {
                    int i = this.jdU;
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(i));
                    ((C44709u) weakReference.get()).mo6107M(i, C36718d.this.mo73394j("ok", hashMap));
                    C16663a.m25666S(i, str);
                    C16663a.m25667a(i, (C44709u) weakReference.get());
                }
                AppMethodBeat.m2505o(123530);
            }

            /* renamed from: Ba */
            public final void mo21851Ba(String str) {
                AppMethodBeat.m2504i(123531);
                C44709u c44709u = (C44709u) weakReference.get();
                if (c44709u == null) {
                    AppMethodBeat.m2505o(123531);
                    return;
                }
                try {
                    int i = this.jdU;
                    new C33294a().mo61030b(c44709u.getRuntime().mo15032xT(), c44709u.hashCode()).mo61027AL(new JSONObject().put("value", C42677e.m75578Ei(str)).put("data", C16663a.m25668ol(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8).toString()).aCj();
                    AppMethodBeat.m2505o(123531);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", e);
                    AppMethodBeat.m2505o(123531);
                }
            }

            public final void aDB() {
                AppMethodBeat.m2504i(123532);
                if (weakReference.get() != null) {
                    ((C44709u) weakReference.get()).mo6107M(i, C36718d.this.mo73394j("fail", null));
                    aDC();
                }
                AppMethodBeat.m2505o(123532);
            }

            private void aDC() {
                AppMethodBeat.m2504i(123533);
                C44709u c44709u = (C44709u) weakReference.get();
                if (c44709u == null || c44709u.aJz() == null) {
                    AppMethodBeat.m2505o(123533);
                    return;
                }
                C19875h.aQx().mo35114d(c44709u.aJz());
                AppMethodBeat.m2505o(123533);
            }
        };
        AppMethodBeat.m2505o(123537);
        return c367192;
    }
}
