package com.tencent.p177mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.p057v4.app.C6184a;
import android.support.p057v4.content.C0380b;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37762mr;
import com.tencent.p177mm.p230g.p231a.C42028ms;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.axy;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.api.aa */
public final class C46400aa {
    private static Map<Integer, C40190ao> tZX = new HashMap();
    private static Map<Integer, C14426k> tZY = new HashMap();
    private static int tZZ;

    /* renamed from: com.tencent.mm.plugin.websearch.api.aa$1 */
    static class C355681 implements Runnable {
        C355681() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124089);
            String cVf = C46400aa.cVf();
            if (!TextUtils.isEmpty(cVf)) {
                C4510aj.cVp().mo9581dy(cVf, 4);
            }
            AppMethodBeat.m2505o(124089);
        }
    }

    /* renamed from: k */
    public static Properties m87338k(C5728b c5728b) {
        AppMethodBeat.m2504i(124091);
        Properties properties = new Properties();
        if (c5728b != null && c5728b.isFile()) {
            Closeable closeable = null;
            try {
                closeable = C5730e.m8638p(c5728b);
                properties.load(closeable);
                C5046bo.m7527b(closeable);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                C5046bo.m7527b(closeable);
            } catch (Throwable th) {
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(124091);
            }
        }
        AppMethodBeat.m2505o(124091);
        return properties;
    }

    /* renamed from: HP */
    public static final String m87299HP(int i) {
        AppMethodBeat.m2504i(124092);
        StringBuilder append = new StringBuilder().append(i).append("_");
        C1720g.m3534RN();
        String stringBuilder = append.append(C1183p.getString(C1668a.m3383QF())).append("_").append(System.currentTimeMillis()).toString();
        AppMethodBeat.m2505o(124092);
        return stringBuilder;
    }

    static {
        AppMethodBeat.m2504i(124148);
        tZX.put(Integer.valueOf(2), new C40190ao("wxa_fts/res", "wxa_fts_template.zip", ""));
        tZX.put(Integer.valueOf(1), new C40190ao("fts_browse/res", "wrd_template.zip", "browse"));
        tZX.put(Integer.valueOf(0), new C40190ao("fts/res", "fts_template.zip", ""));
        Map map = tZY;
        Integer valueOf = Integer.valueOf(0);
        C46400aa.m87301HR(0);
        map.put(valueOf, C40189ag.cVn());
        map = tZY;
        valueOf = Integer.valueOf(1);
        C46400aa.m87301HR(1);
        map.put(valueOf, C40189ag.cVn());
        map = tZY;
        valueOf = Integer.valueOf(2);
        C46400aa.m87301HR(2);
        map.put(valueOf, C40189ag.cVn());
        AppMethodBeat.m2505o(124148);
    }

    /* renamed from: HQ */
    public static C40190ao m87300HQ(int i) {
        AppMethodBeat.m2504i(124093);
        C40190ao c40190ao = (C40190ao) tZX.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(124093);
        return c40190ao;
    }

    /* renamed from: HR */
    private static String m87301HR(int i) {
        AppMethodBeat.m2504i(124094);
        String str = ((C40190ao) tZX.get(Integer.valueOf(i))).aLD() + "/app.html";
        AppMethodBeat.m2505o(124094);
        return str;
    }

    public static String cUZ() {
        AppMethodBeat.m2504i(124095);
        tZX.get(Integer.valueOf(1));
        String str = "app.html";
        AppMethodBeat.m2505o(124095);
        return str;
    }

    public static String cVa() {
        AppMethodBeat.m2504i(124096);
        tZX.get(Integer.valueOf(1));
        String str = "config.conf";
        AppMethodBeat.m2505o(124096);
        return str;
    }

    public static void cVb() {
        AppMethodBeat.m2504i(124097);
        Iterator it = tZY.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(124097);
    }

    /* renamed from: HS */
    public static boolean m87302HS(int i) {
        AppMethodBeat.m2504i(124098);
        if (i == 2) {
            AppMethodBeat.m2505o(124098);
            return true;
        }
        boolean cVD = ((C40190ao) tZX.get(Integer.valueOf(i))).cVD();
        AppMethodBeat.m2505o(124098);
        return cVD;
    }

    /* renamed from: HT */
    public static int m87303HT(int i) {
        String str;
        AppMethodBeat.m2504i(124099);
        C40190ao c40190ao = (C40190ao) tZX.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(c40190ao.ubg)) {
            str = "config.conf";
        } else {
            str = c40190ao.ubg + "/config.conf";
        }
        AssetManager assets = C4996ah.getContext().getAssets();
        Properties properties = new Properties();
        Closeable closeable = null;
        try {
            closeable = assets.open(str);
            properties.load(closeable);
            C5046bo.m7527b(closeable);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, e.getMessage(), new Object[0]);
            C5046bo.m7527b(closeable);
        } catch (Throwable th) {
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(124099);
        }
        int intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
        AppMethodBeat.m2505o(124099);
        return intValue;
    }

    /* renamed from: HU */
    public static boolean m87304HU(int i) {
        AppMethodBeat.m2504i(124100);
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", Integer.valueOf(i));
        if (((C40190ao) tZX.get(Integer.valueOf(i))).afW() > 1) {
            AppMethodBeat.m2505o(124100);
            return true;
        }
        AppMethodBeat.m2505o(124100);
        return false;
    }

    /* renamed from: HV */
    public static int m87305HV(int i) {
        AppMethodBeat.m2504i(124101);
        int afW = ((C40190ao) tZX.get(Integer.valueOf(i))).afW();
        AppMethodBeat.m2505o(124101);
        return afW;
    }

    /* renamed from: HW */
    public static void m87306HW(int i) {
        tZZ = i;
    }

    public static int cVc() {
        return tZZ;
    }

    /* renamed from: HX */
    private static boolean m87307HX(int i) {
        String str;
        OutputStream outputStream = null;
        AppMethodBeat.m2504i(124102);
        AssetManager assets = C4996ah.getContext().getAssets();
        String cVC = ((C40190ao) tZX.get(Integer.valueOf(i))).cVC();
        C40190ao c40190ao = (C40190ao) tZX.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(c40190ao.ubg)) {
            str = c40190ao.ubf;
        } else {
            str = c40190ao.ubg + "/" + c40190ao.ubf;
        }
        if (C5046bo.isNullOrNil(cVC) || C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
            AppMethodBeat.m2505o(124102);
            return false;
        }
        InputStream open;
        try {
            open = assets.open(str);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            C4990ab.m7412e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
            AppMethodBeat.m2505o(124102);
            return false;
        }
        C5728b c5728b = new C5728b(cVC);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        c5728b.dMC().mkdirs();
        try {
            outputStream = C5730e.m8641q(c5728b);
        } catch (FileNotFoundException e2) {
            C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                C46400aa.copyFile(open, outputStream);
                C5046bo.m7527b(open);
                C5046bo.m7527b(outputStream);
                AppMethodBeat.m2505o(124102);
                return true;
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e3, "", new Object[0]);
                return false;
            } finally {
                C5046bo.m7527b(open);
                C5046bo.m7527b(outputStream);
                AppMethodBeat.m2505o(124102);
            }
        } else {
            C5046bo.m7527b(open);
            AppMethodBeat.m2505o(124102);
            return false;
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(124103);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.m2505o(124103);
                return;
            }
        }
    }

    /* renamed from: HY */
    public static String m87308HY(int i) {
        AppMethodBeat.m2504i(124104);
        String cVC = ((C40190ao) tZX.get(Integer.valueOf(i))).cVC();
        AppMethodBeat.m2505o(124104);
        return cVC;
    }

    /* renamed from: HZ */
    public static void m87309HZ(int i) {
        AppMethodBeat.m2504i(124105);
        ((C40190ao) tZX.get(Integer.valueOf(i))).cVA();
        AppMethodBeat.m2505o(124105);
    }

    /* renamed from: Ia */
    public static String m87310Ia(int i) {
        AppMethodBeat.m2504i(124106);
        String aLD = ((C40190ao) tZX.get(Integer.valueOf(i))).aLD();
        AppMethodBeat.m2505o(124106);
        return aLD;
    }

    /* renamed from: Ib */
    public static String m87311Ib(int i) {
        AppMethodBeat.m2504i(124107);
        String aLD = ((C40190ao) tZX.get(Integer.valueOf(C46400aa.m87314Ie(i)))).aLD();
        AppMethodBeat.m2505o(124107);
        return aLD;
    }

    /* renamed from: Ic */
    public static String m87312Ic(int i) {
        AppMethodBeat.m2504i(124108);
        String str = ((C40190ao) tZX.get(Integer.valueOf(C46400aa.m87314Ie(i)))).ubf;
        AppMethodBeat.m2505o(124108);
        return str;
    }

    /* renamed from: Id */
    public static int m87313Id(int i) {
        AppMethodBeat.m2504i(124109);
        int afW = ((C40190ao) tZX.get(Integer.valueOf(C46400aa.m87314Ie(i)))).afW();
        AppMethodBeat.m2505o(124109);
        return afW;
    }

    /* renamed from: Ie */
    private static int m87314Ie(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    /* renamed from: If */
    public static String m87315If(int i) {
        AppMethodBeat.m2504i(124110);
        String property = C46400aa.m87338k(new C5728b(((C40190ao) tZX.get(Integer.valueOf(i))).aLD(), "config_data.conf")).getProperty("kv_set", "");
        AppMethodBeat.m2505o(124110);
        return property;
    }

    public static String bVP() {
        AppMethodBeat.m2504i(124111);
        String str;
        if (C5023at.isWifi(C4996ah.getContext())) {
            str = "wifi";
            AppMethodBeat.m2505o(124111);
            return str;
        } else if (C5023at.is4G(C4996ah.getContext())) {
            str = "4g";
            AppMethodBeat.m2505o(124111);
            return str;
        } else if (C5023at.is3G(C4996ah.getContext())) {
            str = "3g";
            AppMethodBeat.m2505o(124111);
            return str;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            str = "2g";
            AppMethodBeat.m2505o(124111);
            return str;
        } else if (C5023at.isConnected(C4996ah.getContext())) {
            str = "";
            AppMethodBeat.m2505o(124111);
            return str;
        } else {
            str = "fail";
            AppMethodBeat.m2505o(124111);
            return str;
        }
    }

    public static axy abJ() {
        AppMethodBeat.m2504i(124112);
        try {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(67591, null);
            if (str != null) {
                axy axy = new axy();
                String[] split = str.split(",");
                axy.wfG = Integer.valueOf(split[0]).intValue();
                axy.wfJ = Integer.valueOf(split[1]).intValue();
                axy.vRq = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                axy.vRp = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", Float.valueOf(axy.vRq), Float.valueOf(axy.vRp));
                AppMethodBeat.m2505o(124112);
                return axy;
            }
            C4990ab.m7416i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
            AppMethodBeat.m2505o(124112);
            return null;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", e.getMessage());
            AppMethodBeat.m2505o(124112);
            return null;
        }
    }

    /* renamed from: az */
    private static Intent m87330az(Intent intent) {
        AppMethodBeat.m2504i(124113);
        if (intent == null) {
            AppMethodBeat.m2505o(124113);
            return null;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        AppMethodBeat.m2505o(124113);
        return intent;
    }

    public static Intent cVd() {
        AppMethodBeat.m2504i(124114);
        Intent az = C46400aa.m87330az(new Intent());
        AppMethodBeat.m2505o(124114);
        return az;
    }

    /* JADX WARNING: Missing block: B:141:0x02e7, code skipped:
            if (com.tencent.p177mm.plugin.websearch.api.C29736ac.adL("bizEntry").optInt("sugSwitch") == 1) goto L_0x01a3;
     */
    /* JADX WARNING: Missing block: B:143:0x02fa, code skipped:
            if (com.tencent.p177mm.plugin.websearch.api.C29736ac.adL("bizUnionTopEntry").optInt("sugSwitch") == 1) goto L_0x01a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static Map<String, String> m87321a(int i, boolean z, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Object valueOf;
        AppMethodBeat.m2504i(124115);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("searchId", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("sessionId", str3);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("subSessionId", str6);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(SearchIntents.EXTRA_QUERY, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("sceneActionType", str5);
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("pRequestId", str8);
        }
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("lang", C4988aa.m7403gw(C4996ah.getContext()));
        hashMap.put("platform", "android");
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("poiInfo", str7);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        switch (i) {
            case 21:
                valueOf = String.valueOf(C46400aa.m87305HV(1));
                break;
            default:
                valueOf = String.valueOf(C46400aa.m87305HV(0));
                break;
        }
        hashMap.put("version", valueOf);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        JSONObject adL;
        switch (i) {
            case 3:
            case 14:
            case 20:
            case 22:
                if (i2 == 1 && C29736ac.adL("bizTab").optInt("bizSugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 2 && C29736ac.adL("articleTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 8) {
                    adL = C29736ac.adL("snsTab");
                    if (adL.optInt("sugSwitch", 0) == 1) {
                        z2 = true;
                    }
                    if (adL.optInt("localSugSwitch", 0) == 1) {
                        z3 = true;
                    }
                }
                if (!z && i2 == 4 && C29736ac.adL("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 1 && C29736ac.adL("bizTab").optInt("mfsBizSwitch", 0) == 1) {
                    z4 = true;
                }
                if (i2 == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && C29736ac.adL("novelTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 512 && C29736ac.adL("musicTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 384 && C29736ac.adL("emotionTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 0 && z && C29736ac.adL("mixGlobal").optInt("mixSugSwitch", 0) == 1) {
                    z2 = true;
                    break;
                }
            case 6:
            case 9:
                break;
            case 11:
                break;
            case 24:
                if (i2 == 384 && C29736ac.adL("emoticonMall").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                    break;
                }
            case 300:
                adL = C29736ac.adL("mixGlobal");
                if (!z) {
                    break;
                }
                break;
            case 33:
                z2 = true;
                break;
        }
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4));
        if (z2) {
            hashMap.put("isSug", "1");
        }
        if (z3) {
            hashMap.put("isLocalSug", "1");
        }
        if (z4) {
            hashMap.put("isMostSearchBiz", "1");
        }
        if (z) {
            hashMap.put("isHomePage", "1");
        } else {
            hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        float dm = C1338a.m2860dm(C4996ah.getContext());
        if (!(dm == 1.0f || dm == 0.875f || dm == 1.125f || dm == 1.25f || dm == 1.375f || dm == 1.625f || dm == 1.875f || dm == 2.025f)) {
            dm = 1.0f;
        }
        hashMap.put("fontRatio", String.valueOf(dm));
        hashMap.put(DownloadInfo.NETTYPE, C46400aa.bVP());
        if (C37494a.aie()) {
            C9058e aih = C37494a.aih();
            if (aih != null) {
                hashMap.put("musicSnsId", aih.fJU);
            }
        }
        AppMethodBeat.m2505o(124115);
        return hashMap;
    }

    /* renamed from: d */
    public static Map<String, String> m87334d(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(124116);
        Map a = C46400aa.m87318a(i, z, i2, "");
        AppMethodBeat.m2505o(124116);
        return a;
    }

    /* renamed from: a */
    public static Map<String, String> m87318a(int i, boolean z, int i2, String str) {
        AppMethodBeat.m2504i(124117);
        Map a = C46400aa.m87319a(i, z, i2, str, "");
        AppMethodBeat.m2505o(124117);
        return a;
    }

    /* renamed from: a */
    private static Map<String, String> m87319a(int i, boolean z, int i2, String str, String str2) {
        AppMethodBeat.m2504i(124118);
        Map a = C46400aa.m87320a(i, z, i2, str, "", "", "", "", "", str2);
        AppMethodBeat.m2505o(124118);
        return a;
    }

    /* renamed from: a */
    private static Map<String, String> m87320a(int i, boolean z, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(124119);
        Map a = C46400aa.m87321a(i, z, i2, str, str2, str3, str4, str5, str6, str7, "");
        AppMethodBeat.m2505o(124119);
        return a;
    }

    /* renamed from: j */
    public static boolean m87337j(Activity activity, int i) {
        AppMethodBeat.m2504i(124120);
        try {
            if (C0380b.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                try {
                    C7060h.pYm.mo8381e(15104, Integer.valueOf(i), Integer.valueOf(2));
                    AppMethodBeat.m2505o(124120);
                    return true;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                }
            } else {
                C7060h.pYm.mo8381e(15104, Integer.valueOf(i), Integer.valueOf(1));
                if (C6184a.m9881a(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                    C4990ab.m7420w("MicroMsg.WebSearch.WebSearchApiLogic", "has shown request permission and user denied, do not show agagin");
                    AppMethodBeat.m2505o(124120);
                    return true;
                }
                C4990ab.m7420w("MicroMsg.WebSearch.WebSearchApiLogic", "showing request permission dialog");
                C6184a.m9880a(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 73);
                AppMethodBeat.m2505o(124120);
                return false;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
            AppMethodBeat.m2505o(124120);
            return true;
        }
    }

    /* renamed from: a */
    public static void m87324a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(124121);
        String str7 = "";
        String str8 = "";
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
            AppMethodBeat.m2505o(124121);
            return;
        }
        String HP;
        String HP2;
        Intent az = C46400aa.m87330az(intent);
        az.putExtra("ftsbizscene", 21);
        az.putExtra("ftsQuery", str);
        if (str2 != null) {
            az.putExtra("title", str2);
        }
        az.putExtra("isWebwx", str);
        az.putExtra("ftscaneditable", false);
        az.putExtra("key_load_js_without_delay", true);
        if (TextUtils.isEmpty(str5)) {
            HP = C46400aa.m87299HP(21);
        } else {
            HP = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            HP2 = C46400aa.m87299HP(21);
        } else {
            HP2 = str6;
        }
        Map a = C46400aa.m87321a(21, false, 2, str3, str4, HP, str, "2", HP2, "", str7);
        if (!C5046bo.isNullOrNil(str8)) {
            a.put("redPointMsgId", str8);
        }
        az.putExtra("rawUrl", C46400aa.m87333d(a, 1));
        az.putExtra("sessionId", HP);
        az.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        az.putExtra("status_bar_style", "black");
        C25985d.m41467b(context, "webview", ".ui.tools.fts.FTSWebViewUI", az);
        AppMethodBeat.m2505o(124121);
    }

    public static void cVe() {
        AppMethodBeat.m2504i(124122);
        C46400aa.m87339lL(0);
        AppMethodBeat.m2505o(124122);
    }

    /* renamed from: lL */
    public static void m87339lL(long j) {
        AppMethodBeat.m2504i(124123);
        C4510aj.cVp().cVq();
        C1720g.m3539RS().mo10310m(new C355681(), j);
        AppMethodBeat.m2505o(124123);
    }

    public static void adH(final String str) {
        AppMethodBeat.m2504i(124125);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            final /* synthetic */ int fwD = 201;

            public final void run() {
                AppMethodBeat.m2504i(124090);
                String bx = C46400aa.m87331bx(this.fwD, str);
                if (!TextUtils.isEmpty(bx)) {
                    C4510aj.cVp().mo9581dy(bx, 5);
                }
                AppMethodBeat.m2505o(124090);
            }
        });
        AppMethodBeat.m2505o(124125);
    }

    /* renamed from: bx */
    public static String m87331bx(int i, String str) {
        AppMethodBeat.m2504i(124126);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", "64");
        hashMap.put("lang", C4988aa.m7403gw(C4996ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(((C40190ao) tZX.get(Integer.valueOf(2))).afW()));
        hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("isSug", "1");
        hashMap.put(DownloadInfo.NETTYPE, C46400aa.bVP());
        hashMap.put("WASessionId", str);
        hashMap.put("sessionId", str);
        hashMap.put("subSessionId", str);
        hashMap.put("isPreload", "1");
        String d = C46400aa.m87333d(hashMap, 2);
        AppMethodBeat.m2505o(124126);
        return d;
    }

    /* renamed from: E */
    public static String m87298E(Map<String, String> map) {
        AppMethodBeat.m2504i(139149);
        String d = C46400aa.m87333d(map, 0);
        AppMethodBeat.m2505o(139149);
        return d;
    }

    /* renamed from: d */
    public static String m87333d(Map<String, String> map, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(124128);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        String aLD = C46400aa.m87300HQ(i).aLD();
        String str = "isOpenPreload";
        StringBuilder stringBuilder = new StringBuilder();
        if (!C4510aj.cVp().mo9577Ii(i == 1 ? 2 : 1)) {
            i2 = 0;
        }
        map.put(str, stringBuilder.append(i2).toString());
        stringBuffer.append(aLD);
        StringBuffer append;
        String str2;
        if (map.size() > 0) {
            append = stringBuffer.append("/");
            C46400aa.m87300HQ(i);
            append.append("app.html?");
            for (Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("&");
            }
            str2 = (String) map.get("sessionId");
            if (!map.containsKey("sessionId")) {
                str2 = C46400aa.m87299HP(C5046bo.ank((String) map.get("scene")));
                stringBuffer.append("sessionId");
                stringBuffer.append("=");
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            if (!map.containsKey("subSessionId")) {
                stringBuffer.append("subSessionId");
                stringBuffer.append("=");
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            stringBuffer.append("wechatVersion");
            stringBuffer.append("=");
            stringBuffer.append(C7243d.vxo);
            stringBuffer.append("&");
            str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
            AppMethodBeat.m2505o(124128);
            return str2;
        }
        append = stringBuffer.append("/");
        C46400aa.m87300HQ(i);
        append.append("app.html");
        str2 = stringBuffer.toString();
        AppMethodBeat.m2505o(124128);
        return str2;
    }

    /* renamed from: a */
    public static void m87325a(Intent intent, int i) {
        AppMethodBeat.m2504i(124129);
        intent.putExtra("ftsbizscene", i);
        Map d = C46400aa.m87334d(i, false, 384);
        String HP = C46400aa.m87299HP(C5046bo.ank((String) d.get("scene")));
        d.put("sessionId", HP);
        intent.putExtra("sessionId", HP);
        intent.putExtra("rawUrl", C46400aa.m87333d(d, 0));
        intent.putExtra("ftsType", 384);
        AppMethodBeat.m2505o(124129);
    }

    /* renamed from: Xq */
    public static long m87316Xq(String str) {
        AppMethodBeat.m2504i(124130);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(124130);
            return 0;
        }
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", str, Long.valueOf(new BigInteger(str).longValue()));
        AppMethodBeat.m2505o(124130);
        return new BigInteger(str).longValue();
    }

    /* renamed from: lM */
    public static boolean m87340lM(long j) {
        AppMethodBeat.m2504i(124131);
        C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", Long.valueOf(j));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SEARCH_REDDOT_LONG, Long.valueOf(j));
        AppMethodBeat.m2505o(124131);
        return false;
    }

    public static boolean cVg() {
        AppMethodBeat.m2504i(124132);
        JSONObject adL = C29736ac.adL("snsContactMatch");
        if (adL == null) {
            AppMethodBeat.m2505o(124132);
            return false;
        } else if (adL.optInt("matchSwitch") == 1) {
            AppMethodBeat.m2505o(124132);
            return true;
        } else {
            AppMethodBeat.m2505o(124132);
            return false;
        }
    }

    /* renamed from: a */
    public static void m87328a(String str, String str2, String str3, String str4, int i, String str5, int i2, String str6) {
        AppMethodBeat.m2504i(124133);
        C37762mr c37762mr = new C37762mr();
        c37762mr.cIx.query = str4;
        c37762mr.cIx.cvF = str2;
        c37762mr.cIx.cIy = str3;
        c37762mr.cIx.scene = i;
        c37762mr.cIx.cIz = str;
        c37762mr.cIx.cIB = str5;
        c37762mr.cIx.cIC = i2;
        c37762mr.cIx.cIA = str6;
        C4879a.xxA.mo10055m(c37762mr);
        AppMethodBeat.m2505o(124133);
    }

    public static void adI(String str) {
        AppMethodBeat.m2504i(124134);
        C42028ms c42028ms = new C42028ms();
        c42028ms.cID.scene = 201;
        c42028ms.cID.cvF = str;
        C4879a.xxA.mo10055m(c42028ms);
        AppMethodBeat.m2505o(124134);
    }

    public static int cVh() {
        AppMethodBeat.m2504i(124135);
        JSONObject adL = C29736ac.adL("snsContactMatch");
        if (adL != null) {
            int optInt = adL.optInt("queryUtfLenLimit");
            AppMethodBeat.m2505o(124135);
            return optInt;
        }
        AppMethodBeat.m2505o(124135);
        return 0;
    }

    /* renamed from: an */
    public static String m87329an(Map<String, ? extends Object> map) {
        AppMethodBeat.m2504i(124136);
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            if (entry.getValue() != null) {
                stringBuffer.append(entry.getValue().toString());
            }
            stringBuffer.append("&");
        }
        String str = stringBuffer.substring(0, stringBuffer.length() - 1).toString();
        AppMethodBeat.m2505o(124136);
        return str;
    }

    /* renamed from: t */
    public static String m87342t(Map<String, Object> map, String str) {
        AppMethodBeat.m2504i(124137);
        String str2;
        if (!map.containsKey(str)) {
            str2 = "";
            AppMethodBeat.m2505o(124137);
            return str2;
        } else if (map.get(str) != null) {
            str2 = map.get(str).toString();
            AppMethodBeat.m2505o(124137);
            return str2;
        } else {
            str2 = "";
            AppMethodBeat.m2505o(124137);
            return str2;
        }
    }

    /* renamed from: u */
    public static boolean m87343u(Map<String, Object> map, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(124138);
        String t = C46400aa.m87342t(map, str);
        if (C5046bo.isNullOrNil(t)) {
            AppMethodBeat.m2505o(124138);
            return z;
        }
        try {
            if ("1".equals(t)) {
                AppMethodBeat.m2505o(124138);
                return true;
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(t)) {
                AppMethodBeat.m2505o(124138);
                return z;
            } else {
                z = Boolean.valueOf(t).booleanValue();
                AppMethodBeat.m2505o(124138);
                return z;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(124138);
            return z;
        }
    }

    /* renamed from: d */
    public static int m87332d(Map<String, Object> map, String str, int i) {
        AppMethodBeat.m2504i(124139);
        String t = C46400aa.m87342t(map, str);
        if (C5046bo.isNullOrNil(t)) {
            AppMethodBeat.m2505o(124139);
        } else {
            try {
                i = Integer.valueOf(t).intValue();
                AppMethodBeat.m2505o(124139);
            } catch (Exception e) {
                AppMethodBeat.m2505o(124139);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static long m87317a(Map<String, Object> map, String str, long j) {
        AppMethodBeat.m2504i(124140);
        String t = C46400aa.m87342t(map, str);
        if (C5046bo.isNullOrNil(t)) {
            AppMethodBeat.m2505o(124140);
        } else {
            try {
                j = Long.valueOf(t).longValue();
                AppMethodBeat.m2505o(124140);
            } catch (Exception e) {
                AppMethodBeat.m2505o(124140);
            }
        }
        return j;
    }

    /* renamed from: d */
    public static void m87335d(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(124141);
        try {
            String str2 = C4996ah.doz() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(C4996ah.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                context.startActivity(intent);
                AppMethodBeat.m2505o(124141);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            AppMethodBeat.m2505o(124141);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", e);
            AppMethodBeat.m2505o(124141);
        }
    }

    /* renamed from: e */
    private static void m87336e(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(124142);
        try {
            String str2 = C4996ah.doz() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(C4996ah.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 10001);
            }
            AppMethodBeat.m2505o(124142);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", e);
            AppMethodBeat.m2505o(124142);
        }
    }

    public static boolean cVi() {
        AppMethodBeat.m2504i(124143);
        boolean endsWith = C5058f.CLIENT_VERSION.endsWith("0F");
        AppMethodBeat.m2505o(124143);
        return endsWith;
    }

    /* renamed from: a */
    public static void m87326a(C5728b c5728b, int i) {
        AppMethodBeat.m2504i(124144);
        C46400aa.m87327a(c5728b, i, false);
        AppMethodBeat.m2505o(124144);
    }

    /* renamed from: a */
    public static void m87327a(C5728b c5728b, int i, boolean z) {
        AppMethodBeat.m2504i(124145);
        while (true) {
            String HY = C46400aa.m87308HY(i);
            if (C5046bo.isNullOrNil(HY)) {
                C4990ab.m7421w("MicroMsg.WebSearch.WebSearchApiLogic", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", Integer.valueOf(i), C5736j.m8649w(c5728b.dMD()));
                AppMethodBeat.m2505o(124145);
                return;
            }
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            C5728b c5728b2 = new C5728b(c5728b, ".nomedia");
            if (!c5728b2.exists()) {
                try {
                    c5728b2.createNewFile();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "create nomedia file error", new Object[0]);
                }
            }
            c5728b2 = new C5728b(HY);
            if (C46400aa.m87307HX(i)) {
                int hU = C5046bo.m7570hU(C5736j.m8649w(c5728b2.dMD()), c5728b2.getParent());
                if (hU < 0) {
                    C4990ab.m7412e("MicroMsg.WebSearch.WebSearchApiLogic", "unzip fail, ret = " + hU + ", zipFilePath = " + C5736j.m8649w(c5728b2.dMD()) + ", unzipPath = " + c5728b2.getParent());
                } else {
                    C46400aa.m87309HZ(i);
                    hU = C46400aa.m87305HV(i);
                    C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "Unzip Path%s version=%d", c5728b2.getParent(), Integer.valueOf(hU));
                }
            } else {
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "copy template file from asset fail %s", C5736j.m8649w(c5728b2.dMD()));
            }
            if (z || i != 0 || C46400aa.m87302HS(i)) {
                AppMethodBeat.m2505o(124145);
            } else {
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchApiLogic", "init template fail, try again , ftsTemplateFolder %s, type %d", c5728b, Integer.valueOf(i));
                z = true;
            }
        }
        AppMethodBeat.m2505o(124145);
    }

    /* renamed from: lN */
    private static boolean m87341lN(long j) {
        return j == 100203;
    }

    /* renamed from: a */
    public static void m87322a(Activity activity, chv chv) {
        AppMethodBeat.m2504i(124146);
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", chv.toByteArray());
        } catch (IOException e) {
        }
        if (C46400aa.m87341lN(chv.xgG)) {
            C46400aa.m87336e(activity, ".ui.video.fs.TopStoryFSVideoUI", intent);
            AppMethodBeat.m2505o(124146);
            return;
        }
        C46400aa.m87336e(activity, ".ui.video.list.TopStoryListVideoUI", intent);
        AppMethodBeat.m2505o(124146);
    }

    /* renamed from: a */
    public static void m87323a(Context context, chv chv) {
        AppMethodBeat.m2504i(124147);
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", chv.toByteArray());
        } catch (IOException e) {
        }
        if (C46400aa.m87341lN(chv.xgG)) {
            C46400aa.m87335d(context, ".ui.video.fs.TopStoryFSVideoUI", intent);
            AppMethodBeat.m2505o(124147);
            return;
        }
        C46400aa.m87335d(context, ".ui.video.list.TopStoryListVideoUI", intent);
        AppMethodBeat.m2505o(124147);
    }

    public static String cVf() {
        AppMethodBeat.m2504i(124124);
        String HP = C46400aa.m87299HP(-1);
        Map d = C46400aa.m87334d(-1, true, 0);
        d.put("sessionId", HP);
        d.put("inputMarginTop", "32");
        d.put("inputMarginLeftRight", "24");
        d.put("inputHeight", "48");
        d.put("isPreload", "1");
        HP = C46400aa.m87333d(d, 0);
        AppMethodBeat.m2505o(124124);
        return HP;
    }
}
