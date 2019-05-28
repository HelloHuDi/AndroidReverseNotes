package com.tencent.p177mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.p1076b.C35753b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wepkg.utils.a */
public final class C35765a {
    /* renamed from: b */
    public static void m58633b(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        String encode;
        AppMethodBeat.m2504i(63622);
        C4990ab.m7411d("MicroMsg.WePkgReport", "reportWepkgLogicKv, scene = %s, url = %s, pkgId = %s, version = %s, resultCode = %d, costTime = %d, extInfo = %s", str, str2, str3, str4, Long.valueOf(j), Long.valueOf(j2), str5);
        try {
            if (C5046bo.isNullOrNil(str5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DownloadInfo.NETTYPE, C5023at.m7471gB(C4996ah.getContext()));
                encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } else {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str5, "UTF-8"));
                jSONObject2.put(DownloadInfo.NETTYPE, C5023at.m7471gB(C4996ah.getContext()));
                encode = URLEncoder.encode(jSONObject2.toString(), "UTF-8");
            }
            try {
                if (!C5046bo.isNullOrNil(str2)) {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            encode = str5;
        }
        C7060h.pYm.mo8381e(13980, str, str2, str3, str4, Long.valueOf(j), encode, Long.valueOf(j2));
        AppMethodBeat.m2505o(63622);
    }

    /* renamed from: c */
    public static void m58634c(String str, int i, String str2, long j) {
        AppMethodBeat.m2504i(63623);
        if (C35753b.dgn().ahC(str) != null) {
            C37860c.eBG.mo60578a(new C45406d(14229, C35765a.m58635q(str, C35753b.dgn().ahC(str).field_version, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), str2, "", C35753b.dgn().ahC(str).field_oldVersion, Integer.valueOf(4), Long.valueOf(j), Integer.valueOf(C35753b.dgn().ahC(str).field_pkgSize))));
        }
        AppMethodBeat.m2505o(63623);
    }

    /* renamed from: q */
    public static String m58635q(Object... objArr) {
        AppMethodBeat.m2504i(63624);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[11]));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(63624);
        return stringBuilder2;
    }

    public static String aic(String str) {
        AppMethodBeat.m2504i(63625);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(63625);
            return str2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            str2 = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            AppMethodBeat.m2505o(63625);
            return str2;
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.WePkgReport", e.getMessage());
            str2 = "";
            AppMethodBeat.m2505o(63625);
            return str2;
        } catch (UnsupportedEncodingException e2) {
            C4990ab.m7412e("MicroMsg.WePkgReport", e2.getMessage());
            str2 = "";
            AppMethodBeat.m2505o(63625);
            return str2;
        }
    }

    /* renamed from: Kl */
    public static String m58632Kl(int i) {
        AppMethodBeat.m2504i(63626);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subCode", i);
            String encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            AppMethodBeat.m2505o(63626);
            return encode;
        } catch (UnsupportedEncodingException | JSONException e) {
            AppMethodBeat.m2505o(63626);
            return null;
        }
    }
}
