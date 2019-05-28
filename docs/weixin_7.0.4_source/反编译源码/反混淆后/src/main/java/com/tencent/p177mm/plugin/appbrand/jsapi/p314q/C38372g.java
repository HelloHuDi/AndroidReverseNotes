package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.g */
public class C38372g<C extends C2241c> extends C19497u<C> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    /* renamed from: b */
    public final String mo6145b(C c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126415);
        String j = mo73394j("ok", mo61033d(c));
        AppMethodBeat.m2505o(126415);
        return j;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public Map<String, Object> mo61033d(C c) {
        AppMethodBeat.m2504i(126416);
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("system", "Android " + VERSION.RELEASE);
        DisplayMetrics displayMetrics = c.getContext().getResources().getDisplayMetrics();
        hashMap.put("pixelRatio", Float.valueOf(displayMetrics.density));
        hashMap.put("screenWidth", Integer.valueOf(C42668g.m75569pZ(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(C42668g.m75569pZ(displayMetrics.heightPixels)));
        AppMethodBeat.m2505o(126416);
        return hashMap;
    }
}
