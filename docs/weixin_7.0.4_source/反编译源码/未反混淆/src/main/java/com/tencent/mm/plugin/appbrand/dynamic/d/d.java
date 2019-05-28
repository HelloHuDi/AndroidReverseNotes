package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.z.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public d(int i) {
        super("getSystemInfo", i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10830);
        Context context = aVar.getContext();
        v.b Qy = aVar.Qy();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        HashMap hashMap = new HashMap();
        hashMap.put("model", q.LS());
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Integer.valueOf(g.qa(Qy.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(g.qa(Qy.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(g.qa(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(g.qa(displayMetrics.heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, aa.gw(context));
        hashMap.put("version", com.tencent.mm.sdk.platformtools.g.ar(null, com.tencent.mm.protocal.d.vxo));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        aVar2.au(a(true, "", (Map) hashMap));
        AppMethodBeat.o(10830);
    }
}
