package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import android.widget.EditText;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19871c.C19873a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19875h;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19881i;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19881i.C11022b;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j.C198952;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j.C198963;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j.C198974;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j.C19900a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38600e;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38601l;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42743o;
import com.tencent.p177mm.plugin.appbrand.widget.input.C44719g;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45718aa;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C19866d;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C11017h;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C16712e;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33623a.C11016b;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33623a.C27408a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C38599c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.h */
public class C33289h extends C16663a<C16712e> {
    public static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.h$a */
    public static final class C33294a extends C38369p {
        public static final int CTRL_INDEX = 78;
        public static final String NAME = "onKeyboardValueChange";
    }

    /* renamed from: a */
    public void mo53801a(C44709u c44709u, JSONObject jSONObject, int i) {
        int optInt;
        int optInt2;
        AppMethodBeat.m2504i(123555);
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
                final C44709u c44709u2 = c44709u;
                final int i3 = i;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(123545);
                        if (C42743o.m75752a(c44709u2, i2, optInt, optInt2)) {
                            c44709u2.mo6107M(i3, C33289h.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(123545);
                            return;
                        }
                        c44709u2.mo6107M(i3, C33289h.this.mo73394j("fail:invalid data", null));
                        AppMethodBeat.m2505o(123545);
                    }
                });
                AppMethodBeat.m2505o(123555);
                return;
            }
        } catch (JSONException e) {
        }
        final C16712e c16712e = new C16712e();
        if (mo53803a(c16712e, jSONObject, c44709u, i)) {
            if (!jSONObject.has("inputId")) {
                c16712e.jdk = (c44709u.hashCode() + "#" + System.currentTimeMillis() + "#" + System.nanoTime()).hashCode();
            }
            final String optString = jSONObject.optString("data");
            final C44709u c44709u3 = c44709u;
            final int i4 = i;
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(123546);
                    C33289h.m54448a(C33289h.this, c44709u3, optInt, optInt2, optString, c16712e, i4);
                    AppMethodBeat.m2505o(123546);
                }
            });
            AppMethodBeat.m2505o(123555);
            return;
        }
        AppMethodBeat.m2505o(123555);
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
    /* renamed from: a */
    public void mo53802a(C19881i c19881i) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C19881i mo53800a(final WeakReference<C44709u> weakReference, final String str, final int i) {
        AppMethodBeat.m2504i(123556);
        C103736 c103736 = new C19881i() {
            /* renamed from: b */
            public final void mo21854b(String str, int i, boolean z, boolean z2) {
                AppMethodBeat.m2504i(123550);
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
                        C4990ab.m7413e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", C5046bo.m7574l(e));
                    }
                    if (!z2) {
                        aDC();
                    }
                }
                AppMethodBeat.m2505o(123550);
            }

            public final void aDA() {
                AppMethodBeat.m2504i(123551);
                if (weakReference.get() != null) {
                    int i = this.jdU;
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(i));
                    ((C44709u) weakReference.get()).mo6107M(i, C33289h.this.mo73394j("ok", hashMap));
                    C16663a.m25666S(i, str);
                    C16663a.m25667a(i, (C44709u) weakReference.get());
                }
                AppMethodBeat.m2505o(123551);
            }

            public final void aDB() {
                AppMethodBeat.m2504i(123552);
                if (weakReference.get() != null) {
                    ((C44709u) weakReference.get()).mo6107M(i, C33289h.this.mo73394j("fail", null));
                    aDC();
                }
                AppMethodBeat.m2505o(123552);
            }

            /* renamed from: Ba */
            public final void mo21851Ba(String str) {
                AppMethodBeat.m2504i(123553);
                C44709u c44709u = (C44709u) weakReference.get();
                if (c44709u == null) {
                    AppMethodBeat.m2505o(123553);
                    return;
                }
                try {
                    int i = this.jdU;
                    new C33294a().mo61030b(c44709u.getRuntime().mo15032xT(), c44709u.hashCode()).mo61027AL(new JSONObject().put("value", C42677e.m75578Ei(str)).put("data", C16663a.m25668ol(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8).toString()).aCj();
                    AppMethodBeat.m2505o(123553);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", e);
                    AppMethodBeat.m2505o(123553);
                }
            }

            private void aDC() {
                AppMethodBeat.m2504i(123554);
                C44709u c44709u = (C44709u) weakReference.get();
                if (c44709u == null || c44709u.aJz() == null) {
                    AppMethodBeat.m2505o(123554);
                    return;
                }
                C19875h.aQx().mo35114d(c44709u.aJz());
                AppMethodBeat.m2505o(123554);
            }
        };
        AppMethodBeat.m2505o(123556);
        return c103736;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo53803a(C16712e c16712e, JSONObject jSONObject, C44709u c44709u, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(123557);
        if (super.mo30637a(c16712e, jSONObject, c44709u, i)) {
            int i3;
            c16712e.jji = jSONObject.optInt("parentId");
            c16712e.jdk = jSONObject.optInt("inputId");
            c16712e.jjp = Integer.valueOf(Math.max(0, c16712e.jjp.intValue()));
            if (c16712e.jjq == null) {
                i3 = 0;
            } else {
                i3 = Math.max(0, c16712e.jjq.intValue());
            }
            c16712e.jjq = Integer.valueOf(i3);
            c16712e.jjj = jSONObject.optString("type", "text");
            if (C42743o.jeT.contains(c16712e.jjj)) {
                if (c16712e.jjM == null) {
                    c16712e.jjM = Boolean.TRUE;
                }
                c16712e.jjk = jSONObject.optBoolean("password");
                c16712e.jjU = Boolean.valueOf(jSONObject.optBoolean("password"));
                if (aDz()) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("dropdown");
                    if (optJSONObject != null) {
                        C27408a c27408a = new C27408a();
                        c27408a.jiU = optJSONObject.optInt("marginLeft");
                        c27408a.jiV = optJSONObject.optInt("marginRight");
                        c27408a.jiW = optJSONObject.optString("width");
                        JSONArray optJSONArray = optJSONObject.optJSONArray("options");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            c27408a.jiX = new ArrayList();
                            while (i2 < optJSONArray.length()) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    String optString = optJSONObject2.optString("id");
                                    String optString2 = optJSONObject2.optString("title");
                                    String optString3 = optJSONObject2.optString(C8741b.CONTENT);
                                    if (!(C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2))) {
                                        C11016b c11016b = new C11016b();
                                        c11016b.f2885id = optString;
                                        c11016b.title = optString2;
                                        c11016b.content = optString3;
                                        c27408a.jiX.add(c11016b);
                                    }
                                }
                                i2++;
                            }
                            c16712e.jjn = c27408a;
                        }
                    }
                }
                AppMethodBeat.m2505o(123557);
                return true;
            }
            c44709u.mo6107M(i, mo73394j("fail:unsupported input type", null));
            AppMethodBeat.m2505o(123557);
            return false;
        }
        AppMethodBeat.m2505o(123557);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m54448a(C33289h c33289h, final C44709u c44709u, int i, int i2, String str, C16712e c16712e, int i3) {
        Object obj;
        int intValue;
        int intValue2;
        WeakReference weakReference;
        AppMethodBeat.m2504i(123560);
        C19898j aQJ = C19900a.jer;
        C45718aa a = C19873a.m30763a(c16712e.jjj, c44709u, c16712e);
        if (a == null) {
            obj = null;
        } else {
            boolean z;
            if (c16712e.jjo != null) {
                a.mo35095EG(c16712e.jjo);
            }
            a.mo35098a((C11017h) c16712e);
            if (c16712e.jjn != null) {
                C27408a c27408a = c16712e.jjn;
                C44709u c44709u2 = (C44709u) a.jdm.get();
                if (!(c44709u2 == null || a.aQl() == null)) {
                    C19866d.m30749a(c44709u2, a.aQl(), c27408a);
                }
            }
            int intValue3 = c16712e.jjp.intValue();
            int intValue4 = c16712e.jjq.intValue();
            intValue = c16712e.jjs.intValue();
            intValue2 = c16712e.jjr.intValue();
            C44709u c44709u3 = (C44709u) a.jdm.get();
            if (c44709u3 == null || c44709u3.aJz() == null) {
                z = false;
            } else {
                EditText aQl = a.aQl();
                if (aQl == null) {
                    z = false;
                } else {
                    C44719g c44719g = (C44719g) c44709u3.aAY();
                    if (c44719g == null) {
                        z = false;
                    } else {
                        boolean a2 = c44719g.mo71784a(c44709u3.aJz(), aQl, intValue3, intValue4, intValue, intValue2);
                        if (a2) {
                            ((C38595ab) aQl).mo6564a(a.jdo);
                            aQl.addTextChangedListener(a);
                        }
                        z = a2;
                    }
                }
            }
            if (!z) {
                obj = null;
            } else if (a.mo35128dr(i, i2)) {
                weakReference = new WeakReference(c44709u);
                intValue4 = a.jdk;
                ((C38595ab) a.aQl()).setOnKeyUpPostImeListener(new C198952(weakReference, a, str));
                a.jdj = new C198963(weakReference, a, intValue4, str);
                a.jdl = new C198974(weakReference, intValue4);
                C38600e.m65412a(c44709u, a);
                obj = Integer.valueOf(intValue4);
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("inputId", obj);
            c44709u.mo6107M(i3, c33289h.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(123560);
            return;
        }
        final String appId = c44709u.getAppId();
        c44709u.hashCode();
        weakReference = new WeakReference(c44709u);
        c16712e.jdm = weakReference;
        final C19881i a3 = c33289h.mo53800a(weakReference, str, i3);
        a3.jea.jin = new C38599c() {
            /* renamed from: bh */
            public final void mo53807bh(String str, int i) {
                AppMethodBeat.m2504i(123547);
                int i2 = a3.jdU;
                if (a3.jdW == null) {
                    C4990ab.m7413e("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", appId);
                    AppMethodBeat.m2505o(123547);
                    return;
                }
                C33294a c33294a = new C33294a();
                HashMap hashMap = new HashMap();
                hashMap.put("value", C42677e.m75578Ei(str));
                hashMap.put("data", C16663a.m25668ol(i2));
                hashMap.put("cursor", Integer.valueOf(i));
                hashMap.put("inputId", Integer.valueOf(i2));
                hashMap.put("keyCode", Integer.valueOf(a3.jdW.getLastKeyPressed()));
                c33294a.mo61030b(c44709u.getRuntime().mo15032xT(), c44709u.hashCode()).mo34958t(hashMap).aCj();
                AppMethodBeat.m2505o(123547);
            }
        };
        a3.jdO = new C11022b() {
            /* renamed from: a */
            public final void mo22678a(C45718aa c45718aa, int i) {
                AppMethodBeat.m2504i(123548);
                try {
                    C44709u c44709u = (C44709u) weakReference.get();
                    if (c44709u == null) {
                        AppMethodBeat.m2505o(123548);
                        return;
                    }
                    int pZ = C42668g.m75569pZ(i);
                    c44709u.mo51255h("onKeyboardShow", C41725h.m73451QC().mo33333J("inputId", c45718aa.getInputId()).mo33333J("height", pZ).toString(), 0);
                    new C45628v().mo73408a(pZ, c44709u.mo44926xT(), c44709u, Integer.valueOf(c45718aa.getInputId()));
                    AppMethodBeat.m2505o(123548);
                } catch (Exception e) {
                    AppMethodBeat.m2505o(123548);
                }
            }
        };
        c33289h.mo53802a(a3);
        final C16712e c16712e2 = c16712e;
        intValue = i;
        intValue2 = i2;
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123549);
                C44709u c44709u = (C44709u) weakReference.get();
                if (c44709u == null || c44709u.aJz() == null) {
                    AppMethodBeat.m2505o(123549);
                    return;
                }
                C19881i c19881i = a3;
                C16712e c16712e = c16712e2;
                int i = intValue;
                int i2 = intValue2;
                c19881i.jdT = c16712e;
                c44709u = (C44709u) c16712e.jdm.get();
                if (c44709u != null) {
                    C38601l c38601l = new C38601l(c44709u);
                }
                c19881i.mo35129ds(i, i2);
                AppMethodBeat.m2505o(123549);
            }
        });
        AppMethodBeat.m2505o(123560);
    }
}
