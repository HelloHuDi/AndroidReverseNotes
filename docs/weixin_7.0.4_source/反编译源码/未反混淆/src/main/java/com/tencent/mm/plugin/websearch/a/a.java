package com.tencent.mm.plugin.websearch.a;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public final class a {
    private static String afT() {
        AppMethodBeat.i(91357);
        String replace = e.eSk.replace("/data/user/0", "/data/data");
        AppMethodBeat.o(91357);
        return replace;
    }

    public static String aLD() {
        AppMethodBeat.i(91358);
        File file = new File(afT(), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.o(91358);
        return absolutePath;
    }

    private static Properties J(File file) {
        Throwable e;
        AppMethodBeat.i(91359);
        Properties properties = new Properties();
        if (file.isFile()) {
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
                        AppMethodBeat.o(91359);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        com.tencent.mm.a.e.p(fileInputStream);
                        AppMethodBeat.o(91359);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                ab.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                com.tencent.mm.a.e.p(fileInputStream);
                AppMethodBeat.o(91359);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                com.tencent.mm.a.e.p(fileInputStream);
                AppMethodBeat.o(91359);
                throw e;
            }
        }
        AppMethodBeat.o(91359);
        return properties;
    }

    private static int aLE() {
        AppMethodBeat.i(91360);
        int intValue = Integer.valueOf(J(new File(aLD(), "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
        AppMethodBeat.o(91360);
        return intValue;
    }

    public static String E(Map<String, String> map) {
        AppMethodBeat.i(91361);
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
        AppMethodBeat.o(91361);
        return stringBuffer2;
    }

    public static Map<String, String> bA(int i, String str) {
        AppMethodBeat.i(91362);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", "64");
        hashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(aLE()));
        hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        c ll = com.tencent.mm.model.c.c.abi().ll("100192");
        boolean z = ll.isValid() && "1".equals(ll.dru().get("openSearchSuggestion"));
        ab.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", Integer.valueOf(i), Boolean.FALSE, Integer.valueOf(64), Boolean.valueOf(z));
        if (z) {
            hashMap.put("isSug", "1");
        }
        AppMethodBeat.o(91362);
        return hashMap;
    }
}
