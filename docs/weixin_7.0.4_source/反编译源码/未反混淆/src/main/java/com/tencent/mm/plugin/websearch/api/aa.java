package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
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

public final class aa {
    private static Map<Integer, ao> tZX = new HashMap();
    private static Map<Integer, k> tZY = new HashMap();
    private static int tZZ;

    public static Properties k(b bVar) {
        AppMethodBeat.i(124091);
        Properties properties = new Properties();
        if (bVar != null && bVar.isFile()) {
            Closeable closeable = null;
            try {
                closeable = e.p(bVar);
                properties.load(closeable);
                bo.b(closeable);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                bo.b(closeable);
            } catch (Throwable th) {
                bo.b(closeable);
                AppMethodBeat.o(124091);
            }
        }
        AppMethodBeat.o(124091);
        return properties;
    }

    public static final String HP(int i) {
        AppMethodBeat.i(124092);
        StringBuilder append = new StringBuilder().append(i).append("_");
        g.RN();
        String stringBuilder = append.append(p.getString(a.QF())).append("_").append(System.currentTimeMillis()).toString();
        AppMethodBeat.o(124092);
        return stringBuilder;
    }

    static {
        AppMethodBeat.i(124148);
        tZX.put(Integer.valueOf(2), new ao("wxa_fts/res", "wxa_fts_template.zip", ""));
        tZX.put(Integer.valueOf(1), new ao("fts_browse/res", "wrd_template.zip", "browse"));
        tZX.put(Integer.valueOf(0), new ao("fts/res", "fts_template.zip", ""));
        Map map = tZY;
        Integer valueOf = Integer.valueOf(0);
        HR(0);
        map.put(valueOf, ag.cVn());
        map = tZY;
        valueOf = Integer.valueOf(1);
        HR(1);
        map.put(valueOf, ag.cVn());
        map = tZY;
        valueOf = Integer.valueOf(2);
        HR(2);
        map.put(valueOf, ag.cVn());
        AppMethodBeat.o(124148);
    }

    public static ao HQ(int i) {
        AppMethodBeat.i(124093);
        ao aoVar = (ao) tZX.get(Integer.valueOf(i));
        AppMethodBeat.o(124093);
        return aoVar;
    }

    private static String HR(int i) {
        AppMethodBeat.i(124094);
        String str = ((ao) tZX.get(Integer.valueOf(i))).aLD() + "/app.html";
        AppMethodBeat.o(124094);
        return str;
    }

    public static String cUZ() {
        AppMethodBeat.i(124095);
        tZX.get(Integer.valueOf(1));
        String str = "app.html";
        AppMethodBeat.o(124095);
        return str;
    }

    public static String cVa() {
        AppMethodBeat.i(124096);
        tZX.get(Integer.valueOf(1));
        String str = "config.conf";
        AppMethodBeat.o(124096);
        return str;
    }

    public static void cVb() {
        AppMethodBeat.i(124097);
        Iterator it = tZY.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(124097);
    }

    public static boolean HS(int i) {
        AppMethodBeat.i(124098);
        if (i == 2) {
            AppMethodBeat.o(124098);
            return true;
        }
        boolean cVD = ((ao) tZX.get(Integer.valueOf(i))).cVD();
        AppMethodBeat.o(124098);
        return cVD;
    }

    public static int HT(int i) {
        String str;
        AppMethodBeat.i(124099);
        ao aoVar = (ao) tZX.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(aoVar.ubg)) {
            str = "config.conf";
        } else {
            str = aoVar.ubg + "/config.conf";
        }
        AssetManager assets = ah.getContext().getAssets();
        Properties properties = new Properties();
        Closeable closeable = null;
        try {
            closeable = assets.open(str);
            properties.load(closeable);
            bo.b(closeable);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, e.getMessage(), new Object[0]);
            bo.b(closeable);
        } catch (Throwable th) {
            bo.b(closeable);
            AppMethodBeat.o(124099);
        }
        int intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
        AppMethodBeat.o(124099);
        return intValue;
    }

    public static boolean HU(int i) {
        AppMethodBeat.i(124100);
        ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", Integer.valueOf(i));
        if (((ao) tZX.get(Integer.valueOf(i))).afW() > 1) {
            AppMethodBeat.o(124100);
            return true;
        }
        AppMethodBeat.o(124100);
        return false;
    }

    public static int HV(int i) {
        AppMethodBeat.i(124101);
        int afW = ((ao) tZX.get(Integer.valueOf(i))).afW();
        AppMethodBeat.o(124101);
        return afW;
    }

    public static void HW(int i) {
        tZZ = i;
    }

    public static int cVc() {
        return tZZ;
    }

    private static boolean HX(int i) {
        String str;
        OutputStream outputStream = null;
        AppMethodBeat.i(124102);
        AssetManager assets = ah.getContext().getAssets();
        String cVC = ((ao) tZX.get(Integer.valueOf(i))).cVC();
        ao aoVar = (ao) tZX.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(aoVar.ubg)) {
            str = aoVar.ubf;
        } else {
            str = aoVar.ubg + "/" + aoVar.ubf;
        }
        if (bo.isNullOrNil(cVC) || bo.isNullOrNil(str)) {
            ab.w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
            AppMethodBeat.o(124102);
            return false;
        }
        InputStream open;
        try {
            open = assets.open(str);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
            AppMethodBeat.o(124102);
            return false;
        }
        b bVar = new b(cVC);
        if (bVar.exists()) {
            bVar.delete();
        }
        bVar.dMC().mkdirs();
        try {
            outputStream = e.q(bVar);
        } catch (FileNotFoundException e2) {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                copyFile(open, outputStream);
                bo.b(open);
                bo.b(outputStream);
                AppMethodBeat.o(124102);
                return true;
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e3, "", new Object[0]);
                return false;
            } finally {
                bo.b(open);
                bo.b(outputStream);
                AppMethodBeat.o(124102);
            }
        } else {
            bo.b(open);
            AppMethodBeat.o(124102);
            return false;
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(124103);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(124103);
                return;
            }
        }
    }

    public static String HY(int i) {
        AppMethodBeat.i(124104);
        String cVC = ((ao) tZX.get(Integer.valueOf(i))).cVC();
        AppMethodBeat.o(124104);
        return cVC;
    }

    public static void HZ(int i) {
        AppMethodBeat.i(124105);
        ((ao) tZX.get(Integer.valueOf(i))).cVA();
        AppMethodBeat.o(124105);
    }

    public static String Ia(int i) {
        AppMethodBeat.i(124106);
        String aLD = ((ao) tZX.get(Integer.valueOf(i))).aLD();
        AppMethodBeat.o(124106);
        return aLD;
    }

    public static String Ib(int i) {
        AppMethodBeat.i(124107);
        String aLD = ((ao) tZX.get(Integer.valueOf(Ie(i)))).aLD();
        AppMethodBeat.o(124107);
        return aLD;
    }

    public static String Ic(int i) {
        AppMethodBeat.i(124108);
        String str = ((ao) tZX.get(Integer.valueOf(Ie(i)))).ubf;
        AppMethodBeat.o(124108);
        return str;
    }

    public static int Id(int i) {
        AppMethodBeat.i(124109);
        int afW = ((ao) tZX.get(Integer.valueOf(Ie(i)))).afW();
        AppMethodBeat.o(124109);
        return afW;
    }

    private static int Ie(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    public static String If(int i) {
        AppMethodBeat.i(124110);
        String property = k(new b(((ao) tZX.get(Integer.valueOf(i))).aLD(), "config_data.conf")).getProperty("kv_set", "");
        AppMethodBeat.o(124110);
        return property;
    }

    public static String bVP() {
        AppMethodBeat.i(124111);
        String str;
        if (at.isWifi(ah.getContext())) {
            str = "wifi";
            AppMethodBeat.o(124111);
            return str;
        } else if (at.is4G(ah.getContext())) {
            str = "4g";
            AppMethodBeat.o(124111);
            return str;
        } else if (at.is3G(ah.getContext())) {
            str = "3g";
            AppMethodBeat.o(124111);
            return str;
        } else if (at.is2G(ah.getContext())) {
            str = "2g";
            AppMethodBeat.o(124111);
            return str;
        } else if (at.isConnected(ah.getContext())) {
            str = "";
            AppMethodBeat.o(124111);
            return str;
        } else {
            str = "fail";
            AppMethodBeat.o(124111);
            return str;
        }
    }

    public static axy abJ() {
        AppMethodBeat.i(124112);
        try {
            String str = (String) g.RP().Ry().get(67591, null);
            if (str != null) {
                axy axy = new axy();
                String[] split = str.split(",");
                axy.wfG = Integer.valueOf(split[0]).intValue();
                axy.wfJ = Integer.valueOf(split[1]).intValue();
                axy.vRq = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                axy.vRp = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", Float.valueOf(axy.vRq), Float.valueOf(axy.vRp));
                AppMethodBeat.o(124112);
                return axy;
            }
            ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
            AppMethodBeat.o(124112);
            return null;
        } catch (Exception e) {
            ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", e.getMessage());
            AppMethodBeat.o(124112);
            return null;
        }
    }

    private static Intent az(Intent intent) {
        AppMethodBeat.i(124113);
        if (intent == null) {
            AppMethodBeat.o(124113);
            return null;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        AppMethodBeat.o(124113);
        return intent;
    }

    public static Intent cVd() {
        AppMethodBeat.i(124114);
        Intent az = az(new Intent());
        AppMethodBeat.o(124114);
        return az;
    }

    /* JADX WARNING: Missing block: B:141:0x02e7, code skipped:
            if (com.tencent.mm.plugin.websearch.api.ac.adL("bizEntry").optInt("sugSwitch") == 1) goto L_0x01a3;
     */
    /* JADX WARNING: Missing block: B:143:0x02fa, code skipped:
            if (com.tencent.mm.plugin.websearch.api.ac.adL("bizUnionTopEntry").optInt("sugSwitch") == 1) goto L_0x01a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Map<String, String> a(int i, boolean z, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Object valueOf;
        AppMethodBeat.i(124115);
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
        hashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()));
        hashMap.put("platform", "android");
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("poiInfo", str7);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        switch (i) {
            case 21:
                valueOf = String.valueOf(HV(1));
                break;
            default:
                valueOf = String.valueOf(HV(0));
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
                if (i2 == 1 && ac.adL("bizTab").optInt("bizSugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 2 && ac.adL("articleTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 8) {
                    adL = ac.adL("snsTab");
                    if (adL.optInt("sugSwitch", 0) == 1) {
                        z2 = true;
                    }
                    if (adL.optInt("localSugSwitch", 0) == 1) {
                        z3 = true;
                    }
                }
                if (!z && i2 == 4 && ac.adL("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 1 && ac.adL("bizTab").optInt("mfsBizSwitch", 0) == 1) {
                    z4 = true;
                }
                if (i2 == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && ac.adL("novelTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 512 && ac.adL("musicTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 384 && ac.adL("emotionTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 0 && z && ac.adL("mixGlobal").optInt("mixSugSwitch", 0) == 1) {
                    z2 = true;
                    break;
                }
            case 6:
            case 9:
                break;
            case 11:
                break;
            case 24:
                if (i2 == 384 && ac.adL("emoticonMall").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                    break;
                }
            case 300:
                adL = ac.adL("mixGlobal");
                if (!z) {
                    break;
                }
                break;
            case 33:
                z2 = true;
                break;
        }
        ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4));
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
        float dm = com.tencent.mm.bz.a.dm(ah.getContext());
        if (!(dm == 1.0f || dm == 0.875f || dm == 1.125f || dm == 1.25f || dm == 1.375f || dm == 1.625f || dm == 1.875f || dm == 2.025f)) {
            dm = 1.0f;
        }
        hashMap.put("fontRatio", String.valueOf(dm));
        hashMap.put(DownloadInfo.NETTYPE, bVP());
        if (com.tencent.mm.aw.a.aie()) {
            com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
            if (aih != null) {
                hashMap.put("musicSnsId", aih.fJU);
            }
        }
        AppMethodBeat.o(124115);
        return hashMap;
    }

    public static Map<String, String> d(int i, boolean z, int i2) {
        AppMethodBeat.i(124116);
        Map a = a(i, z, i2, "");
        AppMethodBeat.o(124116);
        return a;
    }

    public static Map<String, String> a(int i, boolean z, int i2, String str) {
        AppMethodBeat.i(124117);
        Map a = a(i, z, i2, str, "");
        AppMethodBeat.o(124117);
        return a;
    }

    private static Map<String, String> a(int i, boolean z, int i2, String str, String str2) {
        AppMethodBeat.i(124118);
        Map a = a(i, z, i2, str, "", "", "", "", "", str2);
        AppMethodBeat.o(124118);
        return a;
    }

    private static Map<String, String> a(int i, boolean z, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(124119);
        Map a = a(i, z, i2, str, str2, str3, str4, str5, str6, str7, "");
        AppMethodBeat.o(124119);
        return a;
    }

    public static boolean j(Activity activity, int i) {
        AppMethodBeat.i(124120);
        try {
            if (android.support.v4.content.b.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                try {
                    h.pYm.e(15104, Integer.valueOf(i), Integer.valueOf(2));
                    AppMethodBeat.o(124120);
                    return true;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                }
            } else {
                h.pYm.e(15104, Integer.valueOf(i), Integer.valueOf(1));
                if (android.support.v4.app.a.a(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                    ab.w("MicroMsg.WebSearch.WebSearchApiLogic", "has shown request permission and user denied, do not show agagin");
                    AppMethodBeat.o(124120);
                    return true;
                }
                ab.w("MicroMsg.WebSearch.WebSearchApiLogic", "showing request permission dialog");
                android.support.v4.app.a.a(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 73);
                AppMethodBeat.o(124120);
                return false;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
            AppMethodBeat.o(124120);
            return true;
        }
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(124121);
        String str7 = "";
        String str8 = "";
        if (context == null) {
            ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
            AppMethodBeat.o(124121);
            return;
        }
        String HP;
        String HP2;
        Intent az = az(intent);
        az.putExtra("ftsbizscene", 21);
        az.putExtra("ftsQuery", str);
        if (str2 != null) {
            az.putExtra("title", str2);
        }
        az.putExtra("isWebwx", str);
        az.putExtra("ftscaneditable", false);
        az.putExtra("key_load_js_without_delay", true);
        if (TextUtils.isEmpty(str5)) {
            HP = HP(21);
        } else {
            HP = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            HP2 = HP(21);
        } else {
            HP2 = str6;
        }
        Map a = a(21, false, 2, str3, str4, HP, str, "2", HP2, "", str7);
        if (!bo.isNullOrNil(str8)) {
            a.put("redPointMsgId", str8);
        }
        az.putExtra("rawUrl", d(a, 1));
        az.putExtra("sessionId", HP);
        az.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        az.putExtra("status_bar_style", "black");
        d.b(context, "webview", ".ui.tools.fts.FTSWebViewUI", az);
        AppMethodBeat.o(124121);
    }

    public static void cVe() {
        AppMethodBeat.i(124122);
        lL(0);
        AppMethodBeat.o(124122);
    }

    public static void lL(long j) {
        AppMethodBeat.i(124123);
        aj.cVp().cVq();
        g.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(124089);
                String cVf = aa.cVf();
                if (!TextUtils.isEmpty(cVf)) {
                    aj.cVp().dy(cVf, 4);
                }
                AppMethodBeat.o(124089);
            }
        }, j);
        AppMethodBeat.o(124123);
    }

    public static void adH(final String str) {
        AppMethodBeat.i(124125);
        g.RS().aa(new Runnable() {
            final /* synthetic */ int fwD = 201;

            public final void run() {
                AppMethodBeat.i(124090);
                String bx = aa.bx(this.fwD, str);
                if (!TextUtils.isEmpty(bx)) {
                    aj.cVp().dy(bx, 5);
                }
                AppMethodBeat.o(124090);
            }
        });
        AppMethodBeat.o(124125);
    }

    public static String bx(int i, String str) {
        AppMethodBeat.i(124126);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("type", "64");
        hashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(((ao) tZX.get(Integer.valueOf(2))).afW()));
        hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("isSug", "1");
        hashMap.put(DownloadInfo.NETTYPE, bVP());
        hashMap.put("WASessionId", str);
        hashMap.put("sessionId", str);
        hashMap.put("subSessionId", str);
        hashMap.put("isPreload", "1");
        String d = d(hashMap, 2);
        AppMethodBeat.o(124126);
        return d;
    }

    public static String E(Map<String, String> map) {
        AppMethodBeat.i(139149);
        String d = d(map, 0);
        AppMethodBeat.o(139149);
        return d;
    }

    public static String d(Map<String, String> map, int i) {
        int i2 = 1;
        AppMethodBeat.i(124128);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        String aLD = HQ(i).aLD();
        String str = "isOpenPreload";
        StringBuilder stringBuilder = new StringBuilder();
        if (!aj.cVp().Ii(i == 1 ? 2 : 1)) {
            i2 = 0;
        }
        map.put(str, stringBuilder.append(i2).toString());
        stringBuffer.append(aLD);
        StringBuffer append;
        String str2;
        if (map.size() > 0) {
            append = stringBuffer.append("/");
            HQ(i);
            append.append("app.html?");
            for (Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("&");
            }
            str2 = (String) map.get("sessionId");
            if (!map.containsKey("sessionId")) {
                str2 = HP(bo.ank((String) map.get("scene")));
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
            stringBuffer.append(com.tencent.mm.protocal.d.vxo);
            stringBuffer.append("&");
            str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
            AppMethodBeat.o(124128);
            return str2;
        }
        append = stringBuffer.append("/");
        HQ(i);
        append.append("app.html");
        str2 = stringBuffer.toString();
        AppMethodBeat.o(124128);
        return str2;
    }

    public static void a(Intent intent, int i) {
        AppMethodBeat.i(124129);
        intent.putExtra("ftsbizscene", i);
        Map d = d(i, false, 384);
        String HP = HP(bo.ank((String) d.get("scene")));
        d.put("sessionId", HP);
        intent.putExtra("sessionId", HP);
        intent.putExtra("rawUrl", d(d, 0));
        intent.putExtra("ftsType", 384);
        AppMethodBeat.o(124129);
    }

    public static long Xq(String str) {
        AppMethodBeat.i(124130);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(124130);
            return 0;
        }
        ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", str, Long.valueOf(new BigInteger(str).longValue()));
        AppMethodBeat.o(124130);
        return new BigInteger(str).longValue();
    }

    public static boolean lM(long j) {
        AppMethodBeat.i(124131);
        ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", Long.valueOf(j));
        g.RP().Ry().set(ac.a.USERINFO_SEARCH_REDDOT_LONG, Long.valueOf(j));
        AppMethodBeat.o(124131);
        return false;
    }

    public static boolean cVg() {
        AppMethodBeat.i(124132);
        JSONObject adL = ac.adL("snsContactMatch");
        if (adL == null) {
            AppMethodBeat.o(124132);
            return false;
        } else if (adL.optInt("matchSwitch") == 1) {
            AppMethodBeat.o(124132);
            return true;
        } else {
            AppMethodBeat.o(124132);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, String str4, int i, String str5, int i2, String str6) {
        AppMethodBeat.i(124133);
        mr mrVar = new mr();
        mrVar.cIx.query = str4;
        mrVar.cIx.cvF = str2;
        mrVar.cIx.cIy = str3;
        mrVar.cIx.scene = i;
        mrVar.cIx.cIz = str;
        mrVar.cIx.cIB = str5;
        mrVar.cIx.cIC = i2;
        mrVar.cIx.cIA = str6;
        com.tencent.mm.sdk.b.a.xxA.m(mrVar);
        AppMethodBeat.o(124133);
    }

    public static void adI(String str) {
        AppMethodBeat.i(124134);
        ms msVar = new ms();
        msVar.cID.scene = 201;
        msVar.cID.cvF = str;
        com.tencent.mm.sdk.b.a.xxA.m(msVar);
        AppMethodBeat.o(124134);
    }

    public static int cVh() {
        AppMethodBeat.i(124135);
        JSONObject adL = ac.adL("snsContactMatch");
        if (adL != null) {
            int optInt = adL.optInt("queryUtfLenLimit");
            AppMethodBeat.o(124135);
            return optInt;
        }
        AppMethodBeat.o(124135);
        return 0;
    }

    public static String an(Map<String, ? extends Object> map) {
        AppMethodBeat.i(124136);
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
        AppMethodBeat.o(124136);
        return str;
    }

    public static String t(Map<String, Object> map, String str) {
        AppMethodBeat.i(124137);
        String str2;
        if (!map.containsKey(str)) {
            str2 = "";
            AppMethodBeat.o(124137);
            return str2;
        } else if (map.get(str) != null) {
            str2 = map.get(str).toString();
            AppMethodBeat.o(124137);
            return str2;
        } else {
            str2 = "";
            AppMethodBeat.o(124137);
            return str2;
        }
    }

    public static boolean u(Map<String, Object> map, String str) {
        boolean z = false;
        AppMethodBeat.i(124138);
        String t = t(map, str);
        if (bo.isNullOrNil(t)) {
            AppMethodBeat.o(124138);
            return z;
        }
        try {
            if ("1".equals(t)) {
                AppMethodBeat.o(124138);
                return true;
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(t)) {
                AppMethodBeat.o(124138);
                return z;
            } else {
                z = Boolean.valueOf(t).booleanValue();
                AppMethodBeat.o(124138);
                return z;
            }
        } catch (Exception e) {
            AppMethodBeat.o(124138);
            return z;
        }
    }

    public static int d(Map<String, Object> map, String str, int i) {
        AppMethodBeat.i(124139);
        String t = t(map, str);
        if (bo.isNullOrNil(t)) {
            AppMethodBeat.o(124139);
        } else {
            try {
                i = Integer.valueOf(t).intValue();
                AppMethodBeat.o(124139);
            } catch (Exception e) {
                AppMethodBeat.o(124139);
            }
        }
        return i;
    }

    public static long a(Map<String, Object> map, String str, long j) {
        AppMethodBeat.i(124140);
        String t = t(map, str);
        if (bo.isNullOrNil(t)) {
            AppMethodBeat.o(124140);
        } else {
            try {
                j = Long.valueOf(t).longValue();
                AppMethodBeat.o(124140);
            } catch (Exception e) {
                AppMethodBeat.o(124140);
            }
        }
        return j;
    }

    public static void d(Context context, String str, Intent intent) {
        AppMethodBeat.i(124141);
        try {
            String str2 = ah.doz() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(ah.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                context.startActivity(intent);
                AppMethodBeat.o(124141);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            AppMethodBeat.o(124141);
        } catch (Exception e) {
            ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", e);
            AppMethodBeat.o(124141);
        }
    }

    private static void e(Context context, String str, Intent intent) {
        AppMethodBeat.i(124142);
        try {
            String str2 = ah.doz() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(ah.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 10001);
            }
            AppMethodBeat.o(124142);
        } catch (Exception e) {
            ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", e);
            AppMethodBeat.o(124142);
        }
    }

    public static boolean cVi() {
        AppMethodBeat.i(124143);
        boolean endsWith = f.CLIENT_VERSION.endsWith("0F");
        AppMethodBeat.o(124143);
        return endsWith;
    }

    public static void a(b bVar, int i) {
        AppMethodBeat.i(124144);
        a(bVar, i, false);
        AppMethodBeat.o(124144);
    }

    public static void a(b bVar, int i, boolean z) {
        AppMethodBeat.i(124145);
        while (true) {
            String HY = HY(i);
            if (bo.isNullOrNil(HY)) {
                ab.w("MicroMsg.WebSearch.WebSearchApiLogic", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", Integer.valueOf(i), j.w(bVar.dMD()));
                AppMethodBeat.o(124145);
                return;
            }
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            b bVar2 = new b(bVar, ".nomedia");
            if (!bVar2.exists()) {
                try {
                    bVar2.createNewFile();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "create nomedia file error", new Object[0]);
                }
            }
            bVar2 = new b(HY);
            if (HX(i)) {
                int hU = bo.hU(j.w(bVar2.dMD()), bVar2.getParent());
                if (hU < 0) {
                    ab.e("MicroMsg.WebSearch.WebSearchApiLogic", "unzip fail, ret = " + hU + ", zipFilePath = " + j.w(bVar2.dMD()) + ", unzipPath = " + bVar2.getParent());
                } else {
                    HZ(i);
                    hU = HV(i);
                    ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "Unzip Path%s version=%d", bVar2.getParent(), Integer.valueOf(hU));
                }
            } else {
                ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "copy template file from asset fail %s", j.w(bVar2.dMD()));
            }
            if (z || i != 0 || HS(i)) {
                AppMethodBeat.o(124145);
            } else {
                ab.i("MicroMsg.WebSearch.WebSearchApiLogic", "init template fail, try again , ftsTemplateFolder %s, type %d", bVar, Integer.valueOf(i));
                z = true;
            }
        }
        AppMethodBeat.o(124145);
    }

    private static boolean lN(long j) {
        return j == 100203;
    }

    public static void a(Activity activity, chv chv) {
        AppMethodBeat.i(124146);
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", chv.toByteArray());
        } catch (IOException e) {
        }
        if (lN(chv.xgG)) {
            e(activity, ".ui.video.fs.TopStoryFSVideoUI", intent);
            AppMethodBeat.o(124146);
            return;
        }
        e(activity, ".ui.video.list.TopStoryListVideoUI", intent);
        AppMethodBeat.o(124146);
    }

    public static void a(Context context, chv chv) {
        AppMethodBeat.i(124147);
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", chv.toByteArray());
        } catch (IOException e) {
        }
        if (lN(chv.xgG)) {
            d(context, ".ui.video.fs.TopStoryFSVideoUI", intent);
            AppMethodBeat.o(124147);
            return;
        }
        d(context, ".ui.video.list.TopStoryListVideoUI", intent);
        AppMethodBeat.o(124147);
    }

    public static String cVf() {
        AppMethodBeat.i(124124);
        String HP = HP(-1);
        Map d = d(-1, true, 0);
        d.put("sessionId", HP);
        d.put("inputMarginTop", "32");
        d.put("inputMarginLeftRight", "24");
        d.put("inputHeight", "48");
        d.put("isPreload", "1");
        HP = d(d, 0);
        AppMethodBeat.o(124124);
        return HP;
    }
}
