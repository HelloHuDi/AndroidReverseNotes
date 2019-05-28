package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.widget.EditText;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.c.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends a<e> {
    public static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    public static final class a extends p {
        public static final int CTRL_INDEX = 78;
        public static final String NAME = "onKeyboardValueChange";
    }

    public void a(u uVar, JSONObject jSONObject, int i) {
        int optInt;
        int optInt2;
        AppMethodBeat.i(123555);
        int optInt3 = jSONObject.optInt("cursor", -2);
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            optInt = jSONObject.optInt("selectionStart", -2);
            optInt2 = jSONObject.optInt("selectionEnd", -2);
        } else {
            optInt2 = optInt3;
            optInt = optInt3;
        }
        try {
            final int i2 = jSONObject.getInt("inputId");
            if (aDy()) {
                final u uVar2 = uVar;
                final int i3 = i;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(123545);
                        if (o.a(uVar2, i2, optInt, optInt2)) {
                            uVar2.M(i3, h.this.j("ok", null));
                            AppMethodBeat.o(123545);
                            return;
                        }
                        uVar2.M(i3, h.this.j("fail:invalid data", null));
                        AppMethodBeat.o(123545);
                    }
                });
                AppMethodBeat.o(123555);
                return;
            }
        } catch (JSONException e) {
        }
        final e eVar = new e();
        if (a(eVar, jSONObject, uVar, i)) {
            if (!jSONObject.has("inputId")) {
                eVar.jdk = (uVar.hashCode() + "#" + System.currentTimeMillis() + "#" + System.nanoTime()).hashCode();
            }
            final String optString = jSONObject.optString("data");
            final u uVar3 = uVar;
            final int i4 = i;
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123546);
                    h.a(h.this, uVar3, optInt, optInt2, optString, eVar, i4);
                    AppMethodBeat.o(123546);
                }
            });
            AppMethodBeat.o(123555);
            return;
        }
        AppMethodBeat.o(123555);
    }

    /* Access modifiers changed, original: protected */
    public boolean aDy() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean aDz() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void a(i iVar) {
    }

    /* Access modifiers changed, original: protected */
    public i a(final WeakReference<u> weakReference, final String str, final int i) {
        AppMethodBeat.i(123556);
        AnonymousClass6 anonymousClass6 = new i() {
            public final void b(String str, int i, boolean z, boolean z2) {
                AppMethodBeat.i(123550);
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
                        ab.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", bo.l(e));
                    }
                    if (!z2) {
                        aDC();
                    }
                }
                AppMethodBeat.o(123550);
            }

            public final void aDA() {
                AppMethodBeat.i(123551);
                if (weakReference.get() != null) {
                    int i = this.jdU;
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(i));
                    ((u) weakReference.get()).M(i, h.this.j("ok", hashMap));
                    a.S(i, str);
                    a.a(i, (u) weakReference.get());
                }
                AppMethodBeat.o(123551);
            }

            public final void aDB() {
                AppMethodBeat.i(123552);
                if (weakReference.get() != null) {
                    ((u) weakReference.get()).M(i, h.this.j("fail", null));
                    aDC();
                }
                AppMethodBeat.o(123552);
            }

            public final void Ba(String str) {
                AppMethodBeat.i(123553);
                u uVar = (u) weakReference.get();
                if (uVar == null) {
                    AppMethodBeat.o(123553);
                    return;
                }
                try {
                    int i = this.jdU;
                    new a().b(uVar.getRuntime().xT(), uVar.hashCode()).AL(new JSONObject().put("value", com.tencent.mm.plugin.appbrand.s.e.Ei(str)).put("data", a.ol(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8).toString()).aCj();
                    AppMethodBeat.o(123553);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", e);
                    AppMethodBeat.o(123553);
                }
            }

            private void aDC() {
                AppMethodBeat.i(123554);
                u uVar = (u) weakReference.get();
                if (uVar == null || uVar.aJz() == null) {
                    AppMethodBeat.o(123554);
                    return;
                }
                com.tencent.mm.plugin.appbrand.widget.input.h.aQx().d(uVar.aJz());
                AppMethodBeat.o(123554);
            }
        };
        AppMethodBeat.o(123556);
        return anonymousClass6;
    }

    /* Access modifiers changed, original: protected */
    public boolean a(e eVar, JSONObject jSONObject, u uVar, int i) {
        int i2 = 0;
        AppMethodBeat.i(123557);
        if (super.a(eVar, jSONObject, uVar, i)) {
            int i3;
            eVar.jji = jSONObject.optInt("parentId");
            eVar.jdk = jSONObject.optInt("inputId");
            eVar.jjp = Integer.valueOf(Math.max(0, eVar.jjp.intValue()));
            if (eVar.jjq == null) {
                i3 = 0;
            } else {
                i3 = Math.max(0, eVar.jjq.intValue());
            }
            eVar.jjq = Integer.valueOf(i3);
            eVar.jjj = jSONObject.optString("type", "text");
            if (o.jeT.contains(eVar.jjj)) {
                if (eVar.jjM == null) {
                    eVar.jjM = Boolean.TRUE;
                }
                eVar.jjk = jSONObject.optBoolean("password");
                eVar.jjU = Boolean.valueOf(jSONObject.optBoolean("password"));
                if (aDz()) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("dropdown");
                    if (optJSONObject != null) {
                        com.tencent.mm.plugin.appbrand.widget.input.d.a.a aVar = new com.tencent.mm.plugin.appbrand.widget.input.d.a.a();
                        aVar.jiU = optJSONObject.optInt("marginLeft");
                        aVar.jiV = optJSONObject.optInt("marginRight");
                        aVar.jiW = optJSONObject.optString("width");
                        JSONArray optJSONArray = optJSONObject.optJSONArray("options");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            aVar.jiX = new ArrayList();
                            while (i2 < optJSONArray.length()) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    String optString = optJSONObject2.optString("id");
                                    String optString2 = optJSONObject2.optString("title");
                                    String optString3 = optJSONObject2.optString(b.CONTENT);
                                    if (!(bo.isNullOrNil(optString) || bo.isNullOrNil(optString2))) {
                                        com.tencent.mm.plugin.appbrand.widget.input.d.a.b bVar = new com.tencent.mm.plugin.appbrand.widget.input.d.a.b();
                                        bVar.id = optString;
                                        bVar.title = optString2;
                                        bVar.content = optString3;
                                        aVar.jiX.add(bVar);
                                    }
                                }
                                i2++;
                            }
                            eVar.jjn = aVar;
                        }
                    }
                }
                AppMethodBeat.o(123557);
                return true;
            }
            uVar.M(i, j("fail:unsupported input type", null));
            AppMethodBeat.o(123557);
            return false;
        }
        AppMethodBeat.o(123557);
        return false;
    }

    static /* synthetic */ void a(h hVar, final u uVar, int i, int i2, String str, e eVar, int i3) {
        Object obj;
        int intValue;
        int intValue2;
        WeakReference weakReference;
        AppMethodBeat.i(123560);
        j aQJ = com.tencent.mm.plugin.appbrand.widget.input.j.a.jer;
        aa a = com.tencent.mm.plugin.appbrand.widget.input.c.a.a(eVar.jjj, uVar, eVar);
        if (a == null) {
            obj = null;
        } else {
            boolean z;
            if (eVar.jjo != null) {
                a.EG(eVar.jjo);
            }
            a.a((com.tencent.mm.plugin.appbrand.widget.input.d.h) eVar);
            if (eVar.jjn != null) {
                com.tencent.mm.plugin.appbrand.widget.input.d.a.a aVar = eVar.jjn;
                u uVar2 = (u) a.jdm.get();
                if (!(uVar2 == null || a.aQl() == null)) {
                    d.a(uVar2, a.aQl(), aVar);
                }
            }
            int intValue3 = eVar.jjp.intValue();
            int intValue4 = eVar.jjq.intValue();
            intValue = eVar.jjs.intValue();
            intValue2 = eVar.jjr.intValue();
            u uVar3 = (u) a.jdm.get();
            if (uVar3 == null || uVar3.aJz() == null) {
                z = false;
            } else {
                EditText aQl = a.aQl();
                if (aQl == null) {
                    z = false;
                } else {
                    g gVar = (g) uVar3.aAY();
                    if (gVar == null) {
                        z = false;
                    } else {
                        boolean a2 = gVar.a(uVar3.aJz(), aQl, intValue3, intValue4, intValue, intValue2);
                        if (a2) {
                            ((com.tencent.mm.plugin.appbrand.widget.input.ab) aQl).a(a.jdo);
                            aQl.addTextChangedListener(a);
                        }
                        z = a2;
                    }
                }
            }
            if (!z) {
                obj = null;
            } else if (a.dr(i, i2)) {
                weakReference = new WeakReference(uVar);
                intValue4 = a.jdk;
                ((com.tencent.mm.plugin.appbrand.widget.input.ab) a.aQl()).setOnKeyUpPostImeListener(new com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass2(weakReference, a, str));
                a.jdj = new com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass3(weakReference, a, intValue4, str);
                a.jdl = new com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass4(weakReference, intValue4);
                com.tencent.mm.plugin.appbrand.widget.input.e.a(uVar, a);
                obj = Integer.valueOf(intValue4);
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("inputId", obj);
            uVar.M(i3, hVar.j("ok", hashMap));
            AppMethodBeat.o(123560);
            return;
        }
        final String appId = uVar.getAppId();
        uVar.hashCode();
        weakReference = new WeakReference(uVar);
        eVar.jdm = weakReference;
        final i a3 = hVar.a(weakReference, str, i3);
        a3.jea.jin = new c() {
            public final void bh(String str, int i) {
                AppMethodBeat.i(123547);
                int i2 = a3.jdU;
                if (a3.jdW == null) {
                    ab.e("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", appId);
                    AppMethodBeat.o(123547);
                    return;
                }
                a aVar = new a();
                HashMap hashMap = new HashMap();
                hashMap.put("value", com.tencent.mm.plugin.appbrand.s.e.Ei(str));
                hashMap.put("data", a.ol(i2));
                hashMap.put("cursor", Integer.valueOf(i));
                hashMap.put("inputId", Integer.valueOf(i2));
                hashMap.put("keyCode", Integer.valueOf(a3.jdW.getLastKeyPressed()));
                aVar.b(uVar.getRuntime().xT(), uVar.hashCode()).t(hashMap).aCj();
                AppMethodBeat.o(123547);
            }
        };
        a3.jdO = new i.b() {
            public final void a(aa aaVar, int i) {
                AppMethodBeat.i(123548);
                try {
                    u uVar = (u) weakReference.get();
                    if (uVar == null) {
                        AppMethodBeat.o(123548);
                        return;
                    }
                    int pZ = com.tencent.mm.plugin.appbrand.r.g.pZ(i);
                    uVar.h("onKeyboardShow", com.tencent.mm.aa.h.QC().J("inputId", aaVar.getInputId()).J("height", pZ).toString(), 0);
                    new v().a(pZ, uVar.xT(), uVar, Integer.valueOf(aaVar.getInputId()));
                    AppMethodBeat.o(123548);
                } catch (Exception e) {
                    AppMethodBeat.o(123548);
                }
            }
        };
        hVar.a(a3);
        final e eVar2 = eVar;
        intValue = i;
        intValue2 = i2;
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123549);
                u uVar = (u) weakReference.get();
                if (uVar == null || uVar.aJz() == null) {
                    AppMethodBeat.o(123549);
                    return;
                }
                i iVar = a3;
                e eVar = eVar2;
                int i = intValue;
                int i2 = intValue2;
                iVar.jdT = eVar;
                uVar = (u) eVar.jdm.get();
                if (uVar != null) {
                    l lVar = new l(uVar);
                }
                iVar.ds(i, i2);
                AppMethodBeat.o(123549);
            }
        });
        AppMethodBeat.o(123560);
    }
}
