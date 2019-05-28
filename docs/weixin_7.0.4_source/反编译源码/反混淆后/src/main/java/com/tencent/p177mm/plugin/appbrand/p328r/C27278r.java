package com.tencent.p177mm.plugin.appbrand.p328r;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.appbrand.r.r */
public final class C27278r {
    private static String afT() {
        AppMethodBeat.m2504i(93780);
        String replace = C6457e.eSk.replace("/data/user/0", "/data/data");
        AppMethodBeat.m2505o(93780);
        return replace;
    }

    public static String aLD() {
        AppMethodBeat.m2504i(93781);
        File file = new File(C27278r.afT(), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(93781);
        return absolutePath;
    }

    /* renamed from: J */
    public static Properties m43307J(File file) {
        Throwable e;
        AppMethodBeat.m2504i(93782);
        Properties properties = new Properties();
        if (file != null && file.isFile()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    C1173e.m2573p(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                        C1173e.m2573p(fileInputStream);
                        AppMethodBeat.m2505o(93782);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        C1173e.m2573p(fileInputStream);
                        AppMethodBeat.m2505o(93782);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                C1173e.m2573p(fileInputStream);
                AppMethodBeat.m2505o(93782);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                C1173e.m2573p(fileInputStream);
                AppMethodBeat.m2505o(93782);
                throw e;
            }
        }
        AppMethodBeat.m2505o(93782);
        return properties;
    }

    public static int aLE() {
        AppMethodBeat.m2504i(93783);
        int intValue = Integer.valueOf(C27278r.m43307J(new File(C27278r.aLD(), "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
        AppMethodBeat.m2505o(93783);
        return intValue;
    }

    /* renamed from: E */
    public static String m43306E(Map<String, String> map) {
        AppMethodBeat.m2504i(93784);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(C27278r.aLD());
        stringBuffer.append("/app.html?");
        for (Entry entry : map.entrySet()) {
            stringBuffer.append("&");
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
        }
        if (!map.containsKey("sessionId")) {
            stringBuffer.append("&");
            stringBuffer.append("sessionId");
            stringBuffer.append("=");
            stringBuffer.append(C46400aa.m87299HP(C5046bo.ank((String) map.get("scene"))));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(93784);
        return stringBuffer2;
    }

    /* renamed from: d */
    public static Map<String, String> m43309d(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(93785);
        Map a = C27278r.m43308a(i, z, i2, "");
        AppMethodBeat.m2505o(93785);
        return a;
    }

    /* renamed from: a */
    public static Map<String, String> m43308a(int i, boolean z, int i2, String str) {
        boolean z2;
        AppMethodBeat.m2504i(93786);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("lang", C4988aa.m7403gw(C4996ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(C27278r.aLE()));
        hashMap.put("isHomePage", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put(DownloadInfo.NETTYPE, C46400aa.bVP());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        C5141c ll = C18624c.abi().mo17131ll("100192");
        if (ll.isValid() && "1".equals(ll.dru().get("openSearchSuggestion"))) {
            z2 = true;
        } else {
            z2 = false;
        }
        C4990ab.m7417i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2));
        if (z2) {
            hashMap.put("isSug", "1");
        }
        AppMethodBeat.m2505o(93786);
        return hashMap;
    }

    public static final boolean aNU() {
        AppMethodBeat.m2504i(93787);
        C5141c ll = C18624c.abi().mo17131ll("100223");
        if (!ll.isValid()) {
            AppMethodBeat.m2505o(93787);
            return false;
        } else if (C5046bo.getInt((String) ll.dru().get("switchWeAppTemplate"), 0) == 1) {
            AppMethodBeat.m2505o(93787);
            return true;
        } else {
            AppMethodBeat.m2505o(93787);
            return false;
        }
    }

    public static final boolean aNV() {
        AppMethodBeat.m2504i(93788);
        C5141c ll = C18624c.abi().mo17131ll("100435");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (C5046bo.getInt((String) dru.get("forceClose"), 0) == 0 && C5046bo.getInt((String) dru.get("open"), 0) == 1) {
                AppMethodBeat.m2505o(93788);
                return true;
            }
            AppMethodBeat.m2505o(93788);
            return false;
        }
        AppMethodBeat.m2505o(93788);
        return false;
    }
}
