package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.appcache.C19062o;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.an */
public class C26917an extends C19497u<C2119d> {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(101943);
        C2119d c2119d = (C2119d) c2241c;
        String j;
        if (c2119d.isRunning()) {
            j = mo73394j("ok", mo44663a(c2119d));
            AppMethodBeat.m2505o(101943);
            return j;
        }
        j = mo73394j("fail js context not running", null);
        AppMethodBeat.m2505o(101943);
        return j;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public Map<String, Object> mo44663a(C2119d c2119d) {
        boolean z = true;
        AppMethodBeat.m2504i(101942);
        HashMap hashMap = new HashMap();
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) c2119d.mo5937aa(AppBrandSysConfigLU.class);
        hashMap.put("appDebug", Boolean.valueOf(appBrandSysConfigLU.hhd.gVt != 0));
        hashMap.put("appMd5", C5046bo.nullAsNil(appBrandSysConfigLU.hhd.cvZ));
        hashMap.put("appVersion", Integer.valueOf(appBrandSysConfigLU.hhd.gVu));
        C19062o asG = c2119d.asG();
        if (asG != null) {
            WxaPkgWrappingInfo avm = asG.avm();
            String str = "libDebug";
            if (avm.gVt == 0) {
                z = false;
            }
            hashMap.put(str, Boolean.valueOf(z));
            hashMap.put("libMd5", C5046bo.nullAsNil(avm.cvZ));
            hashMap.put("libVersion", Integer.valueOf(avm.gVu));
        }
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        AppMethodBeat.m2505o(101942);
        return hashMap;
    }
}
