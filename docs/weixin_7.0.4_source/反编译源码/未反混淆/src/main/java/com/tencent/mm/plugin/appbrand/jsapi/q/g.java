package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g<C extends c> extends u<C> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    public final String b(C c, JSONObject jSONObject) {
        AppMethodBeat.i(126415);
        String j = j("ok", d(c));
        AppMethodBeat.o(126415);
        return j;
    }

    /* Access modifiers changed, original: protected */
    public Map<String, Object> d(C c) {
        AppMethodBeat.i(126416);
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("system", "Android " + VERSION.RELEASE);
        DisplayMetrics displayMetrics = c.getContext().getResources().getDisplayMetrics();
        hashMap.put("pixelRatio", Float.valueOf(displayMetrics.density));
        hashMap.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(displayMetrics.heightPixels)));
        AppMethodBeat.o(126416);
        return hashMap;
    }
}
