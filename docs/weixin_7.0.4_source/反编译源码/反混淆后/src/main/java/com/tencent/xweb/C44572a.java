package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C31139d.C31140a;
import com.tencent.xweb.C41128i.C36587a;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.WebView.C46827a;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.p1115c.C46831a.C16383a;
import com.tencent.xweb.util.C24532f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.a */
public final class C44572a {
    static boolean ALK = false;
    static String ALM = "";
    static Map<String, Object> ALN = new HashMap();
    static String[] ALO = new String[]{"disable_url_watchdog"};

    /* renamed from: com.tencent.xweb.a$a */
    public static class C41118a {
        public boolean ALP = false;
        public Object ALQ = null;
    }

    static {
        AppMethodBeat.m2504i(3794);
        AppMethodBeat.m2505o(3794);
    }

    private static void init() {
        AppMethodBeat.m2504i(3767);
        if (ALK) {
            AppMethodBeat.m2505o(3767);
            return;
        }
        ALK = true;
        C44572a.dTM();
        AppMethodBeat.m2505o(3767);
    }

    private static synchronized void dTM() {
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3768);
            ALN.clear();
            SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
            ALM = mMKVSharedTransportOld.getString("cStrTAGConfigVer", "");
            Map all = mMKVSharedTransportOld.getAll();
            if (all == null || all.size() == 0) {
                AppMethodBeat.m2505o(3768);
            } else {
                for (Entry key : all.entrySet()) {
                    String str = (String) key.getKey();
                    String string = mMKVSharedTransportOld.getString(str, "");
                    if (!(str == null || string == null)) {
                        HashMap hashMap = new HashMap();
                        if (!(string == null || string.isEmpty())) {
                            for (String str2 : string.split(";")) {
                                if (!(str2 == null || str2.isEmpty())) {
                                    String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                    if (!(split.length != 2 || split[0] == null || split[1] == null)) {
                                        hashMap.put(split[0], split[1]);
                                    }
                                }
                            }
                        }
                        if (hashMap.size() == 0) {
                            ALN.put(str, string);
                        } else {
                            ALN.put(str, hashMap);
                        }
                    }
                }
                AppMethodBeat.m2505o(3768);
            }
        }
    }

    public static String getAbstractInfo() {
        AppMethodBeat.m2504i(3769);
        C44572a.init();
        String dTN = C44572a.dTN();
        AppMethodBeat.m2505o(3769);
        return dTN;
    }

    private static synchronized String dTN() {
        String str;
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3770);
            StringBuilder stringBuilder = new StringBuilder(512);
            Set<String> keySet = ALN.keySet();
            if (keySet == null) {
                str = "";
                AppMethodBeat.m2505o(3770);
            } else {
                for (String str2 : keySet) {
                    if (!TextUtils.isEmpty(str2)) {
                        String bc = C44572a.m80958bc(C44572a.auT(str2));
                        if (bc == null) {
                            bc = "";
                        }
                        stringBuilder.append(str2 + " : ");
                        stringBuilder.append(bc);
                        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
                str2 = stringBuilder.toString();
                AppMethodBeat.m2505o(3770);
            }
        }
        return str2;
    }

    /* renamed from: Sv */
    public static void m80955Sv(int i) {
        AppMethodBeat.m2504i(3771);
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", i).commit();
        AppMethodBeat.m2505o(3771);
    }

    public static int dTO() {
        AppMethodBeat.m2504i(3772);
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
        if (i <= 30) {
            AppMethodBeat.m2505o(3772);
            return -1;
        }
        int i2 = (i * 60) * 1000;
        AppMethodBeat.m2505o(3772);
        return i2;
    }

    private static synchronized Map<String, String> auT(String str) {
        Map I;
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3773);
            I = C44572a.m80953I(str, ALN);
            AppMethodBeat.m2505o(3773);
        }
        return I;
    }

    /* renamed from: I */
    private static Map<String, String> m80953I(String str, Map<String, Object> map) {
        AppMethodBeat.m2504i(3774);
        C44572a.init();
        if (str == null || str.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.m2505o(3774);
            return hashMap;
        }
        Object obj = map.get(str);
        Map<String, String> map2;
        if (obj instanceof HashMap) {
            map2 = (Map) obj;
            AppMethodBeat.m2505o(3774);
            return map2;
        }
        map2 = new HashMap();
        AppMethodBeat.m2505o(3774);
        return map2;
    }

    public static C44570d auU(String str) {
        AppMethodBeat.m2504i(3775);
        C44572a.init();
        C44570d avc = C44572a.avc(C44572a.m80959iG("setwebtype", str));
        AppMethodBeat.m2505o(3775);
        return avc;
    }

    public static C36587a auV(String str) {
        AppMethodBeat.m2504i(3776);
        C44572a.init();
        C36587a avd = C44572a.avd(C44572a.m80959iG("setjscore", str));
        AppMethodBeat.m2505o(3776);
        return avd;
    }

    public static C46827a auW(String str) {
        AppMethodBeat.m2504i(3777);
        C44572a.init();
        C46827a ave = C44572a.ave(C44572a.m80959iG("setfullscreenvideo", str));
        AppMethodBeat.m2505o(3777);
        return ave;
    }

    public static C31140a auX(String str) {
        AppMethodBeat.m2504i(3778);
        C44572a.init();
        C31140a avf = C44572a.avf(C44572a.m80959iG("fr_" + str.toLowerCase(), "tools"));
        AppMethodBeat.m2505o(3778);
        return avf;
    }

    public static int auY(String str) {
        AppMethodBeat.m2504i(3779);
        C44572a.init();
        String iG = C44572a.m80959iG("setTraceSampleRatioInTenThousand", str);
        if (TextUtils.isEmpty(iG) || !TextUtils.isDigitsOnly(iG)) {
            AppMethodBeat.m2505o(3779);
            return 0;
        }
        int parseInt = Integer.parseInt(iG);
        AppMethodBeat.m2505o(3779);
        return parseInt;
    }

    public static String auZ(String str) {
        AppMethodBeat.m2504i(3780);
        C44572a.init();
        String iG = C44572a.m80959iG("setEnabledTraceCategory", str);
        AppMethodBeat.m2505o(3780);
        return iG;
    }

    public static String ava(String str) {
        AppMethodBeat.m2504i(3781);
        String curStrModule = WebView.getCurStrModule();
        if (TextUtils.isEmpty(curStrModule)) {
            curStrModule = "tools";
        }
        curStrModule = C44572a.m80959iG(str, curStrModule);
        AppMethodBeat.m2505o(3781);
        return curStrModule;
    }

    /* renamed from: iG */
    public static synchronized String m80959iG(String str, String str2) {
        String str3;
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3782);
            C44572a.init();
            Map auT = C44572a.auT(str);
            if (auT == null || str2 == null) {
                str3 = "";
                AppMethodBeat.m2505o(3782);
            } else {
                str3 = (String) auT.get(str2);
                AppMethodBeat.m2505o(3782);
            }
        }
        return str3;
    }

    /* renamed from: a */
    public static void m80956a(C16383a[] c16383aArr, String str) {
        AppMethodBeat.m2504i(3783);
        C44572a.m80957a(c16383aArr, str, false);
        AppMethodBeat.m2505o(3783);
    }

    /* JADX WARNING: Missing block: B:28:0x0081, code skipped:
            if (r2 == null) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static synchronized void m80957a(C16383a[] c16383aArr, String str, boolean z) {
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3784);
            C44572a.init();
            if (str == null) {
                AppMethodBeat.m2505o(3784);
            } else {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = new HashMap();
                HashMap hashMap5 = new HashMap();
                HashMap hashMap6 = new HashMap();
                hashMap6.put("setwebtype", hashMap);
                hashMap6.put("setjscore", hashMap2);
                hashMap6.put("setfullscreenvideo", hashMap3);
                hashMap6.put("setTraceSampleRatioInTenThousand", hashMap4);
                hashMap6.put("setEnabledTraceCategory", hashMap5);
                if (c16383aArr == null || c16383aArr.length == 0) {
                    C44572a.m80954J(str, hashMap6);
                    AppMethodBeat.m2505o(3784);
                } else {
                    int i = -1;
                    int i2 = 0;
                    while (i2 < c16383aArr.length) {
                        int i3;
                        if (c16383aArr[i2] != null) {
                            Object obj;
                            if (z) {
                                if ("revertToVersion".equals(c16383aArr[i2].AOL)) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                            }
                            if (c16383aArr[i2].AOK.dUw()) {
                                C41118a c41118a = (C41118a) C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[]{c16383aArr[i2]});
                                if ((c41118a == null || !c41118a.ALP) && c16383aArr[i2].AOM != null) {
                                    if (c16383aArr[i2].AOL.equals("setConfigPeriod")) {
                                        try {
                                            i = Integer.parseInt(c16383aArr[i2].AOM);
                                        } catch (Exception e) {
                                            Log.m81046e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + c16383aArr[i2].AOM);
                                        }
                                    }
                                    if (!(c16383aArr[i2].AON == null || c16383aArr[i2].AON.isEmpty())) {
                                        String[] split = c16383aArr[i2].AON.split(",");
                                        String trim;
                                        String trim2;
                                        if (c16383aArr[i2].AOL.equals("setwebtype")) {
                                            obj = null;
                                            for (String trim3 : split) {
                                                trim3 = trim3.trim();
                                                if (!(trim3 == null || trim3.isEmpty() || hashMap.containsKey(trim3))) {
                                                    hashMap.put(trim3, c16383aArr[i2].AOM);
                                                    obj = 1;
                                                }
                                            }
                                            if (obj != null && c16383aArr[i2].AOK.APa > 0) {
                                                C24532f.m38181nI(199);
                                            }
                                            i3 = i;
                                        } else if (c16383aArr[i2].AOL.equals("setjscore")) {
                                            for (String trim22 : split) {
                                                trim22 = trim22.trim();
                                                if (!(trim22 == null || trim22.isEmpty() || hashMap2.containsKey(trim22))) {
                                                    hashMap2.put(trim22, c16383aArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else if (c16383aArr[i2].AOL.equals("setfullscreenvideo")) {
                                            for (String trim222 : split) {
                                                trim222 = trim222.trim();
                                                if (!(trim222 == null || trim222.isEmpty() || hashMap3.containsKey(trim222))) {
                                                    hashMap3.put(trim222, c16383aArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else if (c16383aArr[i2].AOL.equals("setTraceSampleRatioInTenThousand")) {
                                            for (String trim2222 : split) {
                                                trim2222 = trim2222.trim();
                                                if (!(trim2222 == null || trim2222.isEmpty() || hashMap4.containsKey(trim2222))) {
                                                    hashMap4.put(trim2222, c16383aArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else if (c16383aArr[i2].AOL.equals("setEnabledTraceCategory")) {
                                            for (String trim22222 : split) {
                                                trim22222 = trim22222.trim();
                                                if (!(trim22222 == null || trim22222.isEmpty() || hashMap5.containsKey(trim22222))) {
                                                    hashMap5.put(trim22222, c16383aArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else {
                                            Object obj2;
                                            CharSequence charSequence = c16383aArr[i2].AOL;
                                            String str2 = c16383aArr[i2].AOM;
                                            if (c16383aArr[i2].AOL.equals("executeCommand")) {
                                                String[] avb = C44572a.avb(c16383aArr[i2].AOM);
                                                if (avb != null && avb.length >= 2) {
                                                    charSequence = avb[0];
                                                    obj2 = avb[1];
                                                }
                                            } else {
                                                trim3 = str2;
                                            }
                                            if (!TextUtils.isEmpty(charSequence)) {
                                                Map I = C44572a.m80953I(charSequence, hashMap6);
                                                if (I == null || I.isEmpty()) {
                                                    I = new HashMap();
                                                    hashMap6.put(charSequence, I);
                                                }
                                                for (String trim4 : split) {
                                                    String trim42 = trim42.trim();
                                                    if (!(trim42 == null || trim42.isEmpty() || I.containsKey(trim42))) {
                                                        I.put(trim42, obj2);
                                                    }
                                                }
                                            }
                                        }
                                        i2++;
                                        i = i3;
                                    }
                                }
                            }
                        }
                        i3 = i;
                        i2++;
                        i = i3;
                    }
                    C44572a.m80955Sv(i);
                    C44572a.m80954J(str, hashMap6);
                    AppMethodBeat.m2505o(3784);
                }
            }
        }
    }

    public static String[] avb(String str) {
        AppMethodBeat.m2504i(3785);
        String[] strArr = new String[2];
        if (str == null || !str.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            AppMethodBeat.m2505o(3785);
            return null;
        }
        int indexOf = str.indexOf(58);
        strArr[0] = str.substring(0, indexOf);
        if (str.length() - 1 <= indexOf) {
            strArr[1] = "";
        } else {
            strArr[1] = str.substring(indexOf + 1);
        }
        AppMethodBeat.m2505o(3785);
        return strArr;
    }

    private static C44570d avc(String str) {
        AppMethodBeat.m2504i(3786);
        C44570d c44570d;
        if (str == null || str.isEmpty()) {
            c44570d = C44570d.WV_KIND_NONE;
            AppMethodBeat.m2505o(3786);
            return c44570d;
        }
        c44570d = C44570d.WV_KIND_NONE;
        try {
            c44570d = C44570d.valueOf(str);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(3786);
        return c44570d;
    }

    private static C36587a avd(String str) {
        AppMethodBeat.m2504i(3787);
        C36587a c36587a;
        if (str == null || str.isEmpty()) {
            c36587a = C36587a.RT_TYPE_AUTO;
            AppMethodBeat.m2505o(3787);
            return c36587a;
        }
        c36587a = C36587a.RT_TYPE_AUTO;
        try {
            c36587a = C36587a.valueOf(str);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(3787);
        return c36587a;
    }

    private static C46827a ave(String str) {
        AppMethodBeat.m2504i(3788);
        C46827a c46827a;
        if (str == null || str.isEmpty()) {
            c46827a = C46827a.HOOK_EVALUTE_JS;
            AppMethodBeat.m2505o(3788);
            return c46827a;
        }
        c46827a = C46827a.HOOK_EVALUTE_JS;
        try {
            c46827a = C46827a.valueOf(str);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(3788);
        return c46827a;
    }

    public static C31140a avf(String str) {
        AppMethodBeat.m2504i(3789);
        C31140a c31140a = C31140a.NONE;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(3789);
        } else {
            try {
                c31140a = C31140a.valueOf(str);
            } catch (Exception e) {
                c31140a = C31140a.NONE;
            }
            AppMethodBeat.m2505o(3789);
        }
        return c31140a;
    }

    /* renamed from: bc */
    private static String m80958bc(Map<String, String> map) {
        AppMethodBeat.m2504i(3790);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.m2505o(3790);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append((String) entry.getValue());
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(3790);
        return str;
    }

    private static synchronized void dTQ() {
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3793);
            C44572a.dTP();
            Editor edit = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").edit();
            edit.putString("cStrTAGConfigVer", ALM);
            for (Entry entry : ALN.entrySet()) {
                if (!(entry.getKey() == null || ((String) entry.getKey()).isEmpty())) {
                    Object value = entry.getValue();
                    if (value == null) {
                        continue;
                    } else if (value instanceof Map) {
                        try {
                            Map map = (Map) value;
                            if (map != null) {
                                edit.putString((String) entry.getKey(), C44572a.m80958bc(map));
                            }
                        } catch (Exception e) {
                            edit.putString((String) entry.getKey(), value.toString());
                        }
                    } else {
                        edit.putString((String) entry.getKey(), value.toString());
                    }
                }
            }
            edit.commit();
            XWalkEnvironment.addXWalkInitializeLog(C44572a.dTN());
            AppMethodBeat.m2505o(3793);
        }
    }

    /* renamed from: J */
    private static synchronized void m80954J(String str, Map<String, Object> map) {
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3791);
            ALM = str;
            ALN = map;
            C44572a.dTQ();
            AppMethodBeat.m2505o(3791);
        }
    }

    private static synchronized void dTP() {
        synchronized (C44572a.class) {
            AppMethodBeat.m2504i(3792);
            Map all = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").getAll();
            if (all == null || all.size() == 0) {
                AppMethodBeat.m2505o(3792);
            } else {
                ArrayList arrayList = new ArrayList();
                for (Entry key : all.entrySet()) {
                    arrayList.add((String) key.getKey());
                }
                Editor edit = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").edit();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.commit();
                AppMethodBeat.m2505o(3792);
            }
        }
    }
}
