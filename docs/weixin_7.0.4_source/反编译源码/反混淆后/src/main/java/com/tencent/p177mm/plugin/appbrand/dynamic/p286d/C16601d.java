package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.d */
public final class C16601d extends C10200a {
    public C16601d(int i) {
        super("getSystemInfo", i);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10830);
        Context context = c36405a.getContext();
        C32800b Qy = c36405a.mo11733Qy();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        HashMap hashMap = new HashMap();
        hashMap.put("model", C1427q.m3034LS());
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Integer.valueOf(C42668g.m75570qa(Qy.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(C42668g.m75570qa(Qy.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(C42668g.m75570qa(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(C42668g.m75570qa(displayMetrics.heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, C4988aa.m7403gw(context));
        hashMap.put("version", C5059g.m7672ar(null, C7243d.vxo));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        c16115a.mo11732au(mo57327a(true, "", (Map) hashMap));
        AppMethodBeat.m2505o(10830);
    }
}
