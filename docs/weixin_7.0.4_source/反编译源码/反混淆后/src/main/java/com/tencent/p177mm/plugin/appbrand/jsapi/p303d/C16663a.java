package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p329s.C42680k;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C2572f;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33624b;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33626d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.a */
abstract class C16663a<P extends C2572f> extends C10296a<C44709u> {
    C16663a() {
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo30637a(P p, JSONObject jSONObject, C44709u c44709u, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            try {
                p.jjp = Integer.valueOf(C42668g.m75564g(jSONObject2, "width"));
                try {
                    p.jjq = Integer.valueOf(C42668g.m75564g(jSONObject2, "height"));
                } catch (Exception e2) {
                }
                p.jjr = Integer.valueOf(C42668g.m75564g(jSONObject2, "top"));
                p.jjs = Integer.valueOf(C42668g.m75564g(jSONObject2, "left"));
            } catch (Exception e3) {
                e = e3;
                if (!aDx()) {
                    C4990ab.m7413e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", C5046bo.m7574l(e));
                    c44709u.mo6107M(i, mo73394j("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 != null) {
                }
                p.jjH = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                p.jjo = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
                p.jjy = Integer.valueOf(jSONObject.getInt("maxLength"));
                p.jjz = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.jjC = Integer.valueOf(C42668g.m75552Ef(jSONObject3.getString("color")));
                p.jjB = Integer.valueOf(C42668g.m75564g(jSONObject3, "fontSize"));
                p.jjA = jSONObject3.optString("fontWeight", "normal");
                p.jjE = Boolean.valueOf(jSONObject.getBoolean("hidden"));
                p.jjD = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.jjI = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.jjK = C33624b.m54895EI(jSONObject.optString("confirmType"));
                p.jjL = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                p.jjM = C42680k.m75587bG(jSONObject.opt("adjustPosition"));
                return true;
            }
        } catch (Exception e4) {
            e = e4;
            jSONObject2 = null;
            if (aDx()) {
            }
            if (jSONObject2 != null) {
            }
            p.jjH = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
            p.jjo = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
            p.jjy = Integer.valueOf(jSONObject.getInt("maxLength"));
            p.jjz = jSONObject.optString("placeholder");
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.jjC = Integer.valueOf(C42668g.m75552Ef(jSONObject3.getString("color")));
            p.jjB = Integer.valueOf(C42668g.m75564g(jSONObject3, "fontSize"));
            p.jjA = jSONObject3.optString("fontWeight", "normal");
            p.jjE = Boolean.valueOf(jSONObject.getBoolean("hidden"));
            p.jjD = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.jjI = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.jjK = C33624b.m54895EI(jSONObject.optString("confirmType"));
            p.jjL = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            p.jjM = C42680k.m75587bG(jSONObject.opt("adjustPosition"));
            return true;
        }
        if (jSONObject2 != null) {
            p.hdi = jSONObject2.optString("fontWeight", null);
            try {
                p.jjt = Integer.valueOf(C42668g.m75564g(jSONObject2, "minHeight"));
            } catch (Exception e5) {
            }
            try {
                p.jju = Integer.valueOf(C42668g.m75564g(jSONObject2, "maxHeight"));
            } catch (Exception e6) {
            }
            p.hdq = jSONObject2.optString("textAlign", null);
            try {
                p.jjw = Integer.valueOf(C42668g.m75559by(jSONObject2.getString("color"), WebView.NIGHT_MODE_COLOR));
            } catch (Exception e7) {
            }
            try {
                p.jjv = Integer.valueOf(C42668g.m75559by(jSONObject2.getString("backgroundColor"), 0));
            } catch (Exception e8) {
            }
            try {
                p.jjx = Float.valueOf(C42668g.m75566i(jSONObject2, "fontSize"));
            } catch (Exception e9) {
            }
            try {
                p.jjJ = Integer.valueOf(C42668g.m75564g(jSONObject2, "marginBottom"));
            } catch (Exception e10) {
                p.jjJ = null;
            }
            p.jjN = C33626d.m54898bv(jSONObject2.opt("lineSpace"));
            if (p.jjN != null) {
                p.jjN = Integer.valueOf(C42668g.m75571qb(p.jjN.intValue()));
            }
            p.jjO = C33626d.m54898bv(jSONObject2.opt("lineHeight"));
            if (p.jjO != null) {
                p.jjO = Integer.valueOf(C42668g.m75571qb(p.jjO.intValue()));
            }
        } else if (!aDx()) {
            C4990ab.m7412e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            c44709u.mo6107M(i, mo73394j("fail:invalid data", null));
            return false;
        }
        try {
            p.jjH = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
        } catch (Exception e11) {
        }
        p.jjo = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
        try {
            p.jjy = Integer.valueOf(jSONObject.getInt("maxLength"));
        } catch (Exception e12) {
        }
        p.jjz = jSONObject.optString("placeholder");
        try {
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.jjC = Integer.valueOf(C42668g.m75552Ef(jSONObject3.getString("color")));
            p.jjB = Integer.valueOf(C42668g.m75564g(jSONObject3, "fontSize"));
            p.jjA = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception e13) {
        }
        try {
            p.jjE = Boolean.valueOf(jSONObject.getBoolean("hidden"));
        } catch (JSONException e14) {
            p.jjE = null;
        }
        try {
            p.jjD = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception e15) {
            p.jjD = null;
        }
        try {
            p.jjI = Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (Exception e16) {
            p.jjI = null;
        }
        p.jjK = C33624b.m54895EI(jSONObject.optString("confirmType"));
        try {
            p.jjL = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e17) {
            p.jjL = null;
        }
        p.jjM = C42680k.m75587bG(jSONObject.opt("adjustPosition"));
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean aDx() {
        return false;
    }

    /* renamed from: ol */
    protected static String m25668ol(int i) {
        return C37922v.m64076Zp().mo60676y("AppBrandJsInput@".concat(String.valueOf(i)), true).getString("passing_data", "");
    }

    /* renamed from: S */
    protected static void m25666S(int i, String str) {
        C37922v.m64076Zp().mo60676y("AppBrandJsInput@".concat(String.valueOf(i)), true).mo53348ae("passing_data", str);
    }

    /* renamed from: a */
    protected static void m25667a(int i, C44709u c44709u) {
        if (c44709u != null) {
            C37922v.m64076Zp().mo60676y("AppBrandJsInput@".concat(String.valueOf(i)), true).mo53356j("webview_reference", new WeakReference(c44709u));
        }
    }
}
