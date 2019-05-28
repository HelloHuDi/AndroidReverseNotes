package com.tencent.p177mm.plugin.websearch.p1663a;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.websearch.a.a */
public final class C46398a {
    private static String afT() {
        AppMethodBeat.m2504i(91357);
        String replace = C6457e.eSk.replace("/data/user/0", "/data/data");
        AppMethodBeat.m2505o(91357);
        return replace;
    }

    public static String aLD() {
        AppMethodBeat.m2504i(91358);
        File file = new File(C46398a.afT(), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        AppMethodBeat.m2505o(91358);
        return absolutePath;
    }

    /* renamed from: J */
    private static Properties m87286J(File file) {
        Throwable e;
        AppMethodBeat.m2504i(91359);
        Properties properties = new Properties();
        if (file.isFile()) {
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
                        AppMethodBeat.m2505o(91359);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        C1173e.m2573p(fileInputStream);
                        AppMethodBeat.m2505o(91359);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                C1173e.m2573p(fileInputStream);
                AppMethodBeat.m2505o(91359);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                C1173e.m2573p(fileInputStream);
                AppMethodBeat.m2505o(91359);
                throw e;
            }
        }
        AppMethodBeat.m2505o(91359);
        return properties;
    }

    private static int aLE() {
        AppMethodBeat.m2504i(91360);
        int intValue = Integer.valueOf(C46398a.m87286J(new File(C46398a.aLD(), "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
        AppMethodBeat.m2505o(91360);
        return intValue;
    }

    /* renamed from: E */
    public static String m87285E(Map<String, String> map) {
        AppMethodBeat.m2504i(91361);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(C46398a.aLD());
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
        AppMethodBeat.m2505o(91361);
        return stringBuffer2;
    }

    /* renamed from: bA */
    public static Map<String, String> m87287bA(int i, String str) {
        AppMethodBeat.m2504i(91362);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", "64");
        hashMap.put("lang", C4988aa.m7403gw(C4996ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(C46398a.aLE()));
        hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        C5141c ll = C18624c.abi().mo17131ll("100192");
        boolean z = ll.isValid() && "1".equals(ll.dru().get("openSearchSuggestion"));
        C4990ab.m7417i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", Integer.valueOf(i), Boolean.FALSE, Integer.valueOf(64), Boolean.valueOf(z));
        if (z) {
            hashMap.put("isSug", "1");
        }
        AppMethodBeat.m2505o(91362);
        return hashMap;
    }
}
