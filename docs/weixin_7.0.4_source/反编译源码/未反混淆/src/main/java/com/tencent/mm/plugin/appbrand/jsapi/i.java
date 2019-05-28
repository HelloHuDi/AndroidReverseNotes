package com.tencent.mm.plugin.appbrand.jsapi;

import a.f.b.j;
import a.l;
import android.os.Build.VERSION;
import com.tencent.luggage.g.d;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0007J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "generateWxConfig", "getActivity", "Landroid/app/Activity;", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
public abstract class i extends d implements h {
    private final String TAG = "AppBrandComponentWxaSharedKT";

    public JSONObject aue() {
        JSONObject jSONObject = new JSONObject();
        h(jSONObject);
        b(jSONObject, "preload", Boolean.TRUE);
        return jSONObject;
    }

    public JSONObject xW() {
        JSONObject jSONObject = new JSONObject();
        h(jSONObject);
        return jSONObject;
    }

    public void h(JSONObject jSONObject) {
        j.p(jSONObject, "config");
        b(jSONObject, "platform", "android");
        b(jSONObject, "system", "Android " + VERSION.RELEASE);
    }

    public final void b(JSONObject jSONObject, String str, Object obj) {
        j.p(jSONObject, "obj");
        j.p(str, "key");
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            d.printErrStackTrace(this.TAG, e, "put with key(" + str + ')', new Object[0]);
        }
    }

    public final void B(Runnable runnable) {
        com.tencent.mm.plugin.appbrand.i runtime = getRuntime();
        if (runtime != null) {
            runtime.B(runnable);
        }
    }

    public final void q(JSONObject jSONObject) {
        j.p(jSONObject, "__wxConfig");
        aBx().evaluateJavascript("var __wxConfig = ".concat(String.valueOf(jSONObject)), null);
    }
}
