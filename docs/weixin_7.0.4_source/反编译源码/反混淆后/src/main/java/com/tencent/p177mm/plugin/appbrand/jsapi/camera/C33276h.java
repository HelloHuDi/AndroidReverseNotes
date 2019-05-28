package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.h */
public final class C33276h extends C42467ah {
    private static final int CTRL_INDEX = 455;
    public static final String NAME = "onCameraScanCode";
    public static C33276h hGZ = new C33276h();

    static {
        AppMethodBeat.m2504i(130972);
        AppMethodBeat.m2505o(130972);
    }

    /* renamed from: a */
    public static void m54431a(C2241c c2241c, int i, String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(130971);
        HashMap hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(i));
        hashMap.put("type", str);
        hashMap.put("result", str2);
        if (bArr != null && bArr.length > 0) {
            String encodeToString = Base64.encodeToString(bArr, 2);
            hashMap.put("charSet", ProtocolPackage.ServerEncoding);
            hashMap.put("rawData", encodeToString);
        }
        C45124d.m82926d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", new JSONObject(hashMap).toString());
        c2241c.mo6109a(hGZ.getName(), r0, null);
        AppMethodBeat.m2505o(130971);
    }
}
