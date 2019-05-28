package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends ah {
    private static final int CTRL_INDEX = 455;
    public static final String NAME = "onCameraScanCode";
    public static h hGZ = new h();

    static {
        AppMethodBeat.i(130972);
        AppMethodBeat.o(130972);
    }

    public static void a(c cVar, int i, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(130971);
        HashMap hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(i));
        hashMap.put("type", str);
        hashMap.put("result", str2);
        if (bArr != null && bArr.length > 0) {
            String encodeToString = Base64.encodeToString(bArr, 2);
            hashMap.put("charSet", ProtocolPackage.ServerEncoding);
            hashMap.put("rawData", encodeToString);
        }
        d.d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", new JSONObject(hashMap).toString());
        cVar.a(hGZ.getName(), r0, null);
        AppMethodBeat.o(130971);
    }
}
