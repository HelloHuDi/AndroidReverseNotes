package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void b(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        String encode;
        AppMethodBeat.i(63622);
        ab.d("MicroMsg.WePkgReport", "reportWepkgLogicKv, scene = %s, url = %s, pkgId = %s, version = %s, resultCode = %d, costTime = %d, extInfo = %s", str, str2, str3, str4, Long.valueOf(j), Long.valueOf(j2), str5);
        try {
            if (bo.isNullOrNil(str5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DownloadInfo.NETTYPE, at.gB(ah.getContext()));
                encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } else {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str5, "UTF-8"));
                jSONObject2.put(DownloadInfo.NETTYPE, at.gB(ah.getContext()));
                encode = URLEncoder.encode(jSONObject2.toString(), "UTF-8");
            }
            try {
                if (!bo.isNullOrNil(str2)) {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            encode = str5;
        }
        h.pYm.e(13980, str, str2, str3, str4, Long.valueOf(j), encode, Long.valueOf(j2));
        AppMethodBeat.o(63622);
    }

    public static void c(String str, int i, String str2, long j) {
        AppMethodBeat.i(63623);
        if (b.dgn().ahC(str) != null) {
            c.eBG.a(new d(14229, q(str, b.dgn().ahC(str).field_version, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), str2, "", b.dgn().ahC(str).field_oldVersion, Integer.valueOf(4), Long.valueOf(j), Integer.valueOf(b.dgn().ahC(str).field_pkgSize))));
        }
        AppMethodBeat.o(63623);
    }

    public static String q(Object... objArr) {
        AppMethodBeat.i(63624);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[11]));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(63624);
        return stringBuilder2;
    }

    public static String aic(String str) {
        AppMethodBeat.i(63625);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(63625);
            return str2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            str2 = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            AppMethodBeat.o(63625);
            return str2;
        } catch (JSONException e) {
            ab.e("MicroMsg.WePkgReport", e.getMessage());
            str2 = "";
            AppMethodBeat.o(63625);
            return str2;
        } catch (UnsupportedEncodingException e2) {
            ab.e("MicroMsg.WePkgReport", e2.getMessage());
            str2 = "";
            AppMethodBeat.o(63625);
            return str2;
        }
    }

    public static String Kl(int i) {
        AppMethodBeat.i(63626);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subCode", i);
            String encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            AppMethodBeat.o(63626);
            return encode;
        } catch (UnsupportedEncodingException | JSONException e) {
            AppMethodBeat.o(63626);
            return null;
        }
    }
}
