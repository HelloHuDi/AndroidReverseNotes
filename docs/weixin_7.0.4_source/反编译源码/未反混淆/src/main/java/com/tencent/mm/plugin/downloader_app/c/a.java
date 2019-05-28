package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(int i, int i2, int i3, int i4, String str, String str2, String str3) {
        AppMethodBeat.i(136160);
        ab.d("MicroMsg.DownloadReporter", "kv16099, sceneId = %d, areaId = %d, positionId = %d, actionId = %d, appId = %s,noticeId = %s, extInfo = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3);
        h.pYm.e(16099, Integer.valueOf(azq()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3);
        AppMethodBeat.o(136160);
    }

    public static int azq() {
        AppMethodBeat.i(136161);
        if (at.isWifi(ah.getContext())) {
            AppMethodBeat.o(136161);
            return 0;
        } else if (at.is4G(ah.getContext())) {
            AppMethodBeat.o(136161);
            return 4;
        } else if (at.is3G(ah.getContext())) {
            AppMethodBeat.o(136161);
            return 3;
        } else if (at.is2G(ah.getContext())) {
            AppMethodBeat.o(136161);
            return 2;
        } else {
            AppMethodBeat.o(136161);
            return 1;
        }
    }

    public static int tQ(int i) {
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

    public static String dD(String str, String str2) {
        AppMethodBeat.i(136162);
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
        AppMethodBeat.o(136162);
        return str3;
    }
}
