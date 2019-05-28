package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.k;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    static boolean ALK = false;
    static String ALM = "";
    static Map<String, Object> ALN = new HashMap();
    static String[] ALO = new String[]{"disable_url_watchdog"};

    public static class a {
        public boolean ALP = false;
        public Object ALQ = null;
    }

    static {
        AppMethodBeat.i(3794);
        AppMethodBeat.o(3794);
    }

    private static void init() {
        AppMethodBeat.i(3767);
        if (ALK) {
            AppMethodBeat.o(3767);
            return;
        }
        ALK = true;
        dTM();
        AppMethodBeat.o(3767);
    }

    private static synchronized void dTM() {
        synchronized (a.class) {
            AppMethodBeat.i(3768);
            ALN.clear();
            SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
            ALM = mMKVSharedTransportOld.getString("cStrTAGConfigVer", "");
            Map all = mMKVSharedTransportOld.getAll();
            if (all == null || all.size() == 0) {
                AppMethodBeat.o(3768);
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
                AppMethodBeat.o(3768);
            }
        }
    }

    public static String getAbstractInfo() {
        AppMethodBeat.i(3769);
        init();
        String dTN = dTN();
        AppMethodBeat.o(3769);
        return dTN;
    }

    private static synchronized String dTN() {
        String str;
        synchronized (a.class) {
            AppMethodBeat.i(3770);
            StringBuilder stringBuilder = new StringBuilder(512);
            Set<String> keySet = ALN.keySet();
            if (keySet == null) {
                str = "";
                AppMethodBeat.o(3770);
            } else {
                for (String str2 : keySet) {
                    if (!TextUtils.isEmpty(str2)) {
                        String bc = bc(auT(str2));
                        if (bc == null) {
                            bc = "";
                        }
                        stringBuilder.append(str2 + " : ");
                        stringBuilder.append(bc);
                        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
                str2 = stringBuilder.toString();
                AppMethodBeat.o(3770);
            }
        }
        return str2;
    }

    public static void Sv(int i) {
        AppMethodBeat.i(3771);
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", i).commit();
        AppMethodBeat.o(3771);
    }

    public static int dTO() {
        AppMethodBeat.i(3772);
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
        if (i <= 30) {
            AppMethodBeat.o(3772);
            return -1;
        }
        int i2 = (i * 60) * 1000;
        AppMethodBeat.o(3772);
        return i2;
    }

    private static synchronized Map<String, String> auT(String str) {
        Map I;
        synchronized (a.class) {
            AppMethodBeat.i(3773);
            I = I(str, ALN);
            AppMethodBeat.o(3773);
        }
        return I;
    }

    private static Map<String, String> I(String str, Map<String, Object> map) {
        AppMethodBeat.i(3774);
        init();
        if (str == null || str.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.o(3774);
            return hashMap;
        }
        Object obj = map.get(str);
        Map<String, String> map2;
        if (obj instanceof HashMap) {
            map2 = (Map) obj;
            AppMethodBeat.o(3774);
            return map2;
        }
        map2 = new HashMap();
        AppMethodBeat.o(3774);
        return map2;
    }

    public static d auU(String str) {
        AppMethodBeat.i(3775);
        init();
        d avc = avc(iG("setwebtype", str));
        AppMethodBeat.o(3775);
        return avc;
    }

    public static com.tencent.xweb.i.a auV(String str) {
        AppMethodBeat.i(3776);
        init();
        com.tencent.xweb.i.a avd = avd(iG("setjscore", str));
        AppMethodBeat.o(3776);
        return avd;
    }

    public static com.tencent.xweb.WebView.a auW(String str) {
        AppMethodBeat.i(3777);
        init();
        com.tencent.xweb.WebView.a ave = ave(iG("setfullscreenvideo", str));
        AppMethodBeat.o(3777);
        return ave;
    }

    public static com.tencent.xweb.d.a auX(String str) {
        AppMethodBeat.i(3778);
        init();
        com.tencent.xweb.d.a avf = avf(iG("fr_" + str.toLowerCase(), "tools"));
        AppMethodBeat.o(3778);
        return avf;
    }

    public static int auY(String str) {
        AppMethodBeat.i(3779);
        init();
        String iG = iG("setTraceSampleRatioInTenThousand", str);
        if (TextUtils.isEmpty(iG) || !TextUtils.isDigitsOnly(iG)) {
            AppMethodBeat.o(3779);
            return 0;
        }
        int parseInt = Integer.parseInt(iG);
        AppMethodBeat.o(3779);
        return parseInt;
    }

    public static String auZ(String str) {
        AppMethodBeat.i(3780);
        init();
        String iG = iG("setEnabledTraceCategory", str);
        AppMethodBeat.o(3780);
        return iG;
    }

    public static String ava(String str) {
        AppMethodBeat.i(3781);
        String curStrModule = WebView.getCurStrModule();
        if (TextUtils.isEmpty(curStrModule)) {
            curStrModule = "tools";
        }
        curStrModule = iG(str, curStrModule);
        AppMethodBeat.o(3781);
        return curStrModule;
    }

    public static synchronized String iG(String str, String str2) {
        String str3;
        synchronized (a.class) {
            AppMethodBeat.i(3782);
            init();
            Map auT = auT(str);
            if (auT == null || str2 == null) {
                str3 = "";
                AppMethodBeat.o(3782);
            } else {
                str3 = (String) auT.get(str2);
                AppMethodBeat.o(3782);
            }
        }
        return str3;
    }

    public static void a(com.tencent.xweb.c.a.a[] aVarArr, String str) {
        AppMethodBeat.i(3783);
        a(aVarArr, str, false);
        AppMethodBeat.o(3783);
    }

    /* JADX WARNING: Missing block: B:28:0x0081, code skipped:
            if (r2 == null) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(com.tencent.xweb.c.a.a[] aVarArr, String str, boolean z) {
        synchronized (a.class) {
            AppMethodBeat.i(3784);
            init();
            if (str == null) {
                AppMethodBeat.o(3784);
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
                if (aVarArr == null || aVarArr.length == 0) {
                    J(str, hashMap6);
                    AppMethodBeat.o(3784);
                } else {
                    int i = -1;
                    int i2 = 0;
                    while (i2 < aVarArr.length) {
                        int i3;
                        if (aVarArr[i2] != null) {
                            Object obj;
                            if (z) {
                                if ("revertToVersion".equals(aVarArr[i2].AOL)) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                            }
                            if (aVarArr[i2].AOK.dUw()) {
                                a aVar = (a) k.f(d.WV_KIND_CW).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[]{aVarArr[i2]});
                                if ((aVar == null || !aVar.ALP) && aVarArr[i2].AOM != null) {
                                    if (aVarArr[i2].AOL.equals("setConfigPeriod")) {
                                        try {
                                            i = Integer.parseInt(aVarArr[i2].AOM);
                                        } catch (Exception e) {
                                            Log.e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + aVarArr[i2].AOM);
                                        }
                                    }
                                    if (!(aVarArr[i2].AON == null || aVarArr[i2].AON.isEmpty())) {
                                        String[] split = aVarArr[i2].AON.split(",");
                                        String trim;
                                        String trim2;
                                        if (aVarArr[i2].AOL.equals("setwebtype")) {
                                            obj = null;
                                            for (String trim3 : split) {
                                                trim3 = trim3.trim();
                                                if (!(trim3 == null || trim3.isEmpty() || hashMap.containsKey(trim3))) {
                                                    hashMap.put(trim3, aVarArr[i2].AOM);
                                                    obj = 1;
                                                }
                                            }
                                            if (obj != null && aVarArr[i2].AOK.APa > 0) {
                                                f.nI(199);
                                            }
                                            i3 = i;
                                        } else if (aVarArr[i2].AOL.equals("setjscore")) {
                                            for (String trim22 : split) {
                                                trim22 = trim22.trim();
                                                if (!(trim22 == null || trim22.isEmpty() || hashMap2.containsKey(trim22))) {
                                                    hashMap2.put(trim22, aVarArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else if (aVarArr[i2].AOL.equals("setfullscreenvideo")) {
                                            for (String trim222 : split) {
                                                trim222 = trim222.trim();
                                                if (!(trim222 == null || trim222.isEmpty() || hashMap3.containsKey(trim222))) {
                                                    hashMap3.put(trim222, aVarArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else if (aVarArr[i2].AOL.equals("setTraceSampleRatioInTenThousand")) {
                                            for (String trim2222 : split) {
                                                trim2222 = trim2222.trim();
                                                if (!(trim2222 == null || trim2222.isEmpty() || hashMap4.containsKey(trim2222))) {
                                                    hashMap4.put(trim2222, aVarArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else if (aVarArr[i2].AOL.equals("setEnabledTraceCategory")) {
                                            for (String trim22222 : split) {
                                                trim22222 = trim22222.trim();
                                                if (!(trim22222 == null || trim22222.isEmpty() || hashMap5.containsKey(trim22222))) {
                                                    hashMap5.put(trim22222, aVarArr[i2].AOM);
                                                }
                                            }
                                            i3 = i;
                                        } else {
                                            Object obj2;
                                            CharSequence charSequence = aVarArr[i2].AOL;
                                            String str2 = aVarArr[i2].AOM;
                                            if (aVarArr[i2].AOL.equals("executeCommand")) {
                                                String[] avb = avb(aVarArr[i2].AOM);
                                                if (avb != null && avb.length >= 2) {
                                                    charSequence = avb[0];
                                                    obj2 = avb[1];
                                                }
                                            } else {
                                                trim3 = str2;
                                            }
                                            if (!TextUtils.isEmpty(charSequence)) {
                                                Map I = I(charSequence, hashMap6);
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
                    Sv(i);
                    J(str, hashMap6);
                    AppMethodBeat.o(3784);
                }
            }
        }
    }

    public static String[] avb(String str) {
        AppMethodBeat.i(3785);
        String[] strArr = new String[2];
        if (str == null || !str.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            AppMethodBeat.o(3785);
            return null;
        }
        int indexOf = str.indexOf(58);
        strArr[0] = str.substring(0, indexOf);
        if (str.length() - 1 <= indexOf) {
            strArr[1] = "";
        } else {
            strArr[1] = str.substring(indexOf + 1);
        }
        AppMethodBeat.o(3785);
        return strArr;
    }

    private static d avc(String str) {
        AppMethodBeat.i(3786);
        d dVar;
        if (str == null || str.isEmpty()) {
            dVar = d.WV_KIND_NONE;
            AppMethodBeat.o(3786);
            return dVar;
        }
        dVar = d.WV_KIND_NONE;
        try {
            dVar = d.valueOf(str);
        } catch (Exception e) {
        }
        AppMethodBeat.o(3786);
        return dVar;
    }

    private static com.tencent.xweb.i.a avd(String str) {
        AppMethodBeat.i(3787);
        com.tencent.xweb.i.a aVar;
        if (str == null || str.isEmpty()) {
            aVar = com.tencent.xweb.i.a.RT_TYPE_AUTO;
            AppMethodBeat.o(3787);
            return aVar;
        }
        aVar = com.tencent.xweb.i.a.RT_TYPE_AUTO;
        try {
            aVar = com.tencent.xweb.i.a.valueOf(str);
        } catch (Exception e) {
        }
        AppMethodBeat.o(3787);
        return aVar;
    }

    private static com.tencent.xweb.WebView.a ave(String str) {
        AppMethodBeat.i(3788);
        com.tencent.xweb.WebView.a aVar;
        if (str == null || str.isEmpty()) {
            aVar = com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS;
            AppMethodBeat.o(3788);
            return aVar;
        }
        aVar = com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS;
        try {
            aVar = com.tencent.xweb.WebView.a.valueOf(str);
        } catch (Exception e) {
        }
        AppMethodBeat.o(3788);
        return aVar;
    }

    public static com.tencent.xweb.d.a avf(String str) {
        AppMethodBeat.i(3789);
        com.tencent.xweb.d.a aVar = com.tencent.xweb.d.a.NONE;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(3789);
        } else {
            try {
                aVar = com.tencent.xweb.d.a.valueOf(str);
            } catch (Exception e) {
                aVar = com.tencent.xweb.d.a.NONE;
            }
            AppMethodBeat.o(3789);
        }
        return aVar;
    }

    private static String bc(Map<String, String> map) {
        AppMethodBeat.i(3790);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.o(3790);
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
        AppMethodBeat.o(3790);
        return str;
    }

    private static synchronized void dTQ() {
        synchronized (a.class) {
            AppMethodBeat.i(3793);
            dTP();
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
                                edit.putString((String) entry.getKey(), bc(map));
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
            XWalkEnvironment.addXWalkInitializeLog(dTN());
            AppMethodBeat.o(3793);
        }
    }

    private static synchronized void J(String str, Map<String, Object> map) {
        synchronized (a.class) {
            AppMethodBeat.i(3791);
            ALM = str;
            ALN = map;
            dTQ();
            AppMethodBeat.o(3791);
        }
    }

    private static synchronized void dTP() {
        synchronized (a.class) {
            AppMethodBeat.i(3792);
            Map all = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG").getAll();
            if (all == null || all.size() == 0) {
                AppMethodBeat.o(3792);
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
                AppMethodBeat.o(3792);
            }
        }
    }
}
