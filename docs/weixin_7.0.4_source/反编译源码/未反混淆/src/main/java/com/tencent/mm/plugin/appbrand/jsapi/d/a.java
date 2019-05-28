package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.d;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a<P extends f> extends com.tencent.mm.plugin.appbrand.jsapi.a<u> {
    a() {
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(P p, JSONObject jSONObject, u uVar, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
            try {
                p.jjp = Integer.valueOf(g.g(jSONObject2, "width"));
                try {
                    p.jjq = Integer.valueOf(g.g(jSONObject2, "height"));
                } catch (Exception e2) {
                }
                p.jjr = Integer.valueOf(g.g(jSONObject2, "top"));
                p.jjs = Integer.valueOf(g.g(jSONObject2, "left"));
            } catch (Exception e3) {
                e = e3;
                if (!aDx()) {
                    ab.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", bo.l(e));
                    uVar.M(i, j("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 != null) {
                }
                p.jjH = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                p.jjo = jSONObject.optString("defaultValue", jSONObject.optString("value", null));
                p.jjy = Integer.valueOf(jSONObject.getInt("maxLength"));
                p.jjz = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.jjC = Integer.valueOf(g.Ef(jSONObject3.getString("color")));
                p.jjB = Integer.valueOf(g.g(jSONObject3, "fontSize"));
                p.jjA = jSONObject3.optString("fontWeight", "normal");
                p.jjE = Boolean.valueOf(jSONObject.getBoolean("hidden"));
                p.jjD = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.jjI = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.jjK = b.EI(jSONObject.optString("confirmType"));
                p.jjL = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                p.jjM = k.bG(jSONObject.opt("adjustPosition"));
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
            p.jjC = Integer.valueOf(g.Ef(jSONObject3.getString("color")));
            p.jjB = Integer.valueOf(g.g(jSONObject3, "fontSize"));
            p.jjA = jSONObject3.optString("fontWeight", "normal");
            p.jjE = Boolean.valueOf(jSONObject.getBoolean("hidden"));
            p.jjD = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.jjI = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.jjK = b.EI(jSONObject.optString("confirmType"));
            p.jjL = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            p.jjM = k.bG(jSONObject.opt("adjustPosition"));
            return true;
        }
        if (jSONObject2 != null) {
            p.hdi = jSONObject2.optString("fontWeight", null);
            try {
                p.jjt = Integer.valueOf(g.g(jSONObject2, "minHeight"));
            } catch (Exception e5) {
            }
            try {
                p.jju = Integer.valueOf(g.g(jSONObject2, "maxHeight"));
            } catch (Exception e6) {
            }
            p.hdq = jSONObject2.optString("textAlign", null);
            try {
                p.jjw = Integer.valueOf(g.by(jSONObject2.getString("color"), WebView.NIGHT_MODE_COLOR));
            } catch (Exception e7) {
            }
            try {
                p.jjv = Integer.valueOf(g.by(jSONObject2.getString("backgroundColor"), 0));
            } catch (Exception e8) {
            }
            try {
                p.jjx = Float.valueOf(g.i(jSONObject2, "fontSize"));
            } catch (Exception e9) {
            }
            try {
                p.jjJ = Integer.valueOf(g.g(jSONObject2, "marginBottom"));
            } catch (Exception e10) {
                p.jjJ = null;
            }
            p.jjN = d.bv(jSONObject2.opt("lineSpace"));
            if (p.jjN != null) {
                p.jjN = Integer.valueOf(g.qb(p.jjN.intValue()));
            }
            p.jjO = d.bv(jSONObject2.opt("lineHeight"));
            if (p.jjO != null) {
                p.jjO = Integer.valueOf(g.qb(p.jjO.intValue()));
            }
        } else if (!aDx()) {
            ab.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            uVar.M(i, j("fail:invalid data", null));
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
            p.jjC = Integer.valueOf(g.Ef(jSONObject3.getString("color")));
            p.jjB = Integer.valueOf(g.g(jSONObject3, "fontSize"));
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
        p.jjK = b.EI(jSONObject.optString("confirmType"));
        try {
            p.jjL = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e17) {
            p.jjL = null;
        }
        p.jjM = k.bG(jSONObject.opt("adjustPosition"));
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean aDx() {
        return false;
    }

    protected static String ol(int i) {
        return v.Zp().y("AppBrandJsInput@".concat(String.valueOf(i)), true).getString("passing_data", "");
    }

    protected static void S(int i, String str) {
        v.Zp().y("AppBrandJsInput@".concat(String.valueOf(i)), true).ae("passing_data", str);
    }

    protected static void a(int i, u uVar) {
        if (uVar != null) {
            v.Zp().y("AppBrandJsInput@".concat(String.valueOf(i)), true).j("webview_reference", new WeakReference(uVar));
        }
    }
}
