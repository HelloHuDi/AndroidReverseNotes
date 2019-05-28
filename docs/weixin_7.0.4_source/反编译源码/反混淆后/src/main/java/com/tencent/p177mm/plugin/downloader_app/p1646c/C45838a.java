package com.tencent.p177mm.plugin.downloader_app.p1646c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.c.a */
public final class C45838a {
    /* renamed from: a */
    public static void m84850a(int i, int i2, int i3, int i4, String str, String str2, String str3) {
        AppMethodBeat.m2504i(136160);
        C4990ab.m7411d("MicroMsg.DownloadReporter", "kv16099, sceneId = %d, areaId = %d, positionId = %d, actionId = %d, appId = %s,noticeId = %s, extInfo = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3);
        C7060h.pYm.mo8381e(16099, Integer.valueOf(C45838a.azq()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3);
        AppMethodBeat.m2505o(136160);
    }

    public static int azq() {
        AppMethodBeat.m2504i(136161);
        if (C5023at.isWifi(C4996ah.getContext())) {
            AppMethodBeat.m2505o(136161);
            return 0;
        } else if (C5023at.is4G(C4996ah.getContext())) {
            AppMethodBeat.m2505o(136161);
            return 4;
        } else if (C5023at.is3G(C4996ah.getContext())) {
            AppMethodBeat.m2505o(136161);
            return 3;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            AppMethodBeat.m2505o(136161);
            return 2;
        } else {
            AppMethodBeat.m2505o(136161);
            return 1;
        }
    }

    /* renamed from: tQ */
    public static int m84852tQ(int i) {
        switch (i) {
            case 2:
                return 1002;
            case 4:
                return 1003;
            case 6:
                return 1004;
            default:
                return 0;
        }
    }

    /* renamed from: dD */
    public static String m84851dD(String str, String str2) {
        AppMethodBeat.m2504i(136162);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
        }
        String str3 = "";
        try {
            str3 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e2) {
        }
        AppMethodBeat.m2505o(136162);
        return str3;
    }
}
