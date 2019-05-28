package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0007J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "generateWxConfig", "getActivity", "Landroid/app/Activity;", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i */
public abstract class C10438i extends C33295d implements C33327h {
    private final String TAG = "AppBrandComponentWxaSharedKT";

    public JSONObject aue() {
        JSONObject jSONObject = new JSONObject();
        mo21957h(jSONObject);
        mo21956b(jSONObject, "preload", Boolean.TRUE);
        return jSONObject;
    }

    /* renamed from: xW */
    public JSONObject mo21959xW() {
        JSONObject jSONObject = new JSONObject();
        mo21957h(jSONObject);
        return jSONObject;
    }

    /* renamed from: h */
    public void mo21957h(JSONObject jSONObject) {
        C25052j.m39376p(jSONObject, "config");
        mo21956b(jSONObject, "platform", "android");
        mo21956b(jSONObject, "system", "Android " + VERSION.RELEASE);
    }

    /* renamed from: b */
    public final void mo21956b(JSONObject jSONObject, String str, Object obj) {
        C25052j.m39376p(jSONObject, "obj");
        C25052j.m39376p(str, "key");
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            C45124d.printErrStackTrace(this.TAG, e, "put with key(" + str + ')', new Object[0]);
        }
    }

    /* renamed from: B */
    public final void mo6106B(Runnable runnable) {
        C6750i runtime = getRuntime();
        if (runtime != null) {
            runtime.mo14977B(runnable);
        }
    }

    /* renamed from: q */
    public final void mo21958q(JSONObject jSONObject) {
        C25052j.m39376p(jSONObject, "__wxConfig");
        aBx().evaluateJavascript("var __wxConfig = ".concat(String.valueOf(jSONObject)), null);
    }
}
