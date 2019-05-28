package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 315;
    public static final String NAME = "stopWifi";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94378);
        ab.i("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
        Context context = cVar.getContext();
        HashMap hashMap;
        if (context == null) {
            ab.e("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            cVar.M(i, j("fail:context is null", hashMap));
            AppMethodBeat.o(94378);
        } else if (d.ide) {
            if (d.idf != null) {
                ab.i("MicroMsg.JsApiStopWifi", "unregisterReceiver");
                context.unregisterReceiver(d.idf);
                d.ide = false;
                d.idf = null;
            }
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            cVar.M(i, j("ok", hashMap));
            AppMethodBeat.o(94378);
        } else {
            ab.e("MicroMsg.JsApiStopWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            cVar.M(i, j("fail:not invoke startWifi", hashMap));
            AppMethodBeat.o(94378);
        }
    }
}
