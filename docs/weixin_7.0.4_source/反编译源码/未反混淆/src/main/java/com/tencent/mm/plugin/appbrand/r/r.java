package com.tencent.mm.plugin.appbrand.r;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public final class r {
    private static String afT() {
        AppMethodBeat.i(93780);
        String replace = e.eSk.replace("/data/user/0", "/data/data");
        AppMethodBeat.o(93780);
        return replace;
    }

    public static String aLD() {
        AppMethodBeat.i(93781);
        File file = new File(afT(), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(93781);
        return absolutePath;
    }

    public static Properties J(File file) {
        Throwable e;
        AppMethodBeat.i(93782);
        Properties properties = new Properties();
        if (file != null && file.isFile()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    com.tencent.mm.a.e.p(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                        com.tencent.mm.a.e.p(fileInputStream);
                        AppMethodBeat.o(93782);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        com.tencent.mm.a.e.p(fileInputStream);
                        AppMethodBeat.o(93782);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                ab.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                com.tencent.mm.a.e.p(fileInputStream);
                AppMethodBeat.o(93782);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                com.tencent.mm.a.e.p(fileInputStream);
                AppMethodBeat.o(93782);
                throw e;
            }
        }
        AppMethodBeat.o(93782);
        return properties;
    }

    public static int aLE() {
        AppMethodBeat.i(93783);
        int intValue = Integer.valueOf(J(new File(aLD(), "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
        AppMethodBeat.o(93783);
        return intValue;
    }

    public static String E(Map<String, String> map) {
        AppMethodBeat.i(93784);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(aLD());
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
            stringBuffer.append(aa.HP(bo.ank((String) map.get("scene"))));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(93784);
        return stringBuffer2;
    }

    public static Map<String, String> d(int i, boolean z, int i2) {
        AppMethodBeat.i(93785);
        Map a = a(i, z, i2, "");
        AppMethodBeat.o(93785);
        return a;
    }

    public static Map<String, String> a(int i, boolean z, int i2, String str) {
        boolean z2;
        AppMethodBeat.i(93786);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(aLE()));
        hashMap.put("isHomePage", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put(DownloadInfo.NETTYPE, aa.bVP());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        c ll = com.tencent.mm.model.c.c.abi().ll("100192");
        if (ll.isValid() && "1".equals(ll.dru().get("openSearchSuggestion"))) {
            z2 = true;
        } else {
            z2 = false;
        }
        ab.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2));
        if (z2) {
            hashMap.put("isSug", "1");
        }
        AppMethodBeat.o(93786);
        return hashMap;
    }

    public static final boolean aNU() {
        AppMethodBeat.i(93787);
        c ll = com.tencent.mm.model.c.c.abi().ll("100223");
        if (!ll.isValid()) {
            AppMethodBeat.o(93787);
            return false;
        } else if (bo.getInt((String) ll.dru().get("switchWeAppTemplate"), 0) == 1) {
            AppMethodBeat.o(93787);
            return true;
        } else {
            AppMethodBeat.o(93787);
            return false;
        }
    }

    public static final boolean aNV() {
        AppMethodBeat.i(93788);
        c ll = com.tencent.mm.model.c.c.abi().ll("100435");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (bo.getInt((String) dru.get("forceClose"), 0) == 0 && bo.getInt((String) dru.get("open"), 0) == 1) {
                AppMethodBeat.o(93788);
                return true;
            }
            AppMethodBeat.o(93788);
            return false;
        }
        AppMethodBeat.o(93788);
        return false;
    }
}
