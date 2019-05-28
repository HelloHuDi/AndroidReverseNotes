package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class an extends u<d> {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(101943);
        d dVar = (d) cVar;
        String j;
        if (dVar.isRunning()) {
            j = j("ok", a(dVar));
            AppMethodBeat.o(101943);
            return j;
        }
        j = j("fail js context not running", null);
        AppMethodBeat.o(101943);
        return j;
    }

    /* Access modifiers changed, original: protected */
    public Map<String, Object> a(d dVar) {
        boolean z = true;
        AppMethodBeat.i(101942);
        HashMap hashMap = new HashMap();
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) dVar.aa(AppBrandSysConfigLU.class);
        hashMap.put("appDebug", Boolean.valueOf(appBrandSysConfigLU.hhd.gVt != 0));
        hashMap.put("appMd5", bo.nullAsNil(appBrandSysConfigLU.hhd.cvZ));
        hashMap.put("appVersion", Integer.valueOf(appBrandSysConfigLU.hhd.gVu));
        o asG = dVar.asG();
        if (asG != null) {
            WxaPkgWrappingInfo avm = asG.avm();
            String str = "libDebug";
            if (avm.gVt == 0) {
                z = false;
            }
            hashMap.put(str, Boolean.valueOf(z));
            hashMap.put("libMd5", bo.nullAsNil(avm.cvZ));
            hashMap.put("libVersion", Integer.valueOf(avm.gVu));
        }
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        AppMethodBeat.o(101942);
        return hashMap;
    }
}
