package com.tencent.p177mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C11988b;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28088a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28089d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.protocal.protobuf.C23460xa;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.freewifi.m */
public final class C34189m {
    private static SimpleDateFormat juL = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    /* renamed from: com.tencent.mm.plugin.freewifi.m$a */
    public interface C34190a {
        /* renamed from: h */
        void mo46010h(int i, int i2, String str, C1207m c1207m);
    }

    public static boolean isEmpty(String str) {
        AppMethodBeat.m2504i(20627);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(20627);
            return true;
        }
        AppMethodBeat.m2505o(20627);
        return false;
    }

    static {
        AppMethodBeat.m2504i(20655);
        AppMethodBeat.m2505o(20655);
    }

    /* renamed from: Mv */
    public static String m56057Mv(String str) {
        AppMethodBeat.m2504i(20628);
        if (C34189m.isEmpty(str)) {
            str = "";
            AppMethodBeat.m2505o(20628);
            return str;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        AppMethodBeat.m2505o(20628);
        return str;
    }

    public static boolean byr() {
        AppMethodBeat.m2504i(20629);
        String cc = C5046bo.m7542cc(C4996ah.getContext());
        if (cc == null || !cc.toLowerCase().startsWith(C4996ah.getPackageName())) {
            AppMethodBeat.m2505o(20629);
            return false;
        }
        AppMethodBeat.m2505o(20629);
        return true;
    }

    /* renamed from: U */
    public static void m56062U(Intent intent) {
        AppMethodBeat.m2504i(20630);
        if (C34189m.isEmpty(intent.getStringExtra("free_wifi_sessionkey"))) {
            C34189m.m56072d(intent, C34189m.bys());
        }
        AppMethodBeat.m2505o(20630);
    }

    public static String bys() {
        AppMethodBeat.m2504i(20631);
        String replace = UUID.randomUUID().toString().replace("-", "");
        AppMethodBeat.m2505o(20631);
        return replace;
    }

    /* renamed from: d */
    public static void m56072d(Intent intent, String str) {
        AppMethodBeat.m2504i(20632);
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
        AppMethodBeat.m2505o(20632);
    }

    /* renamed from: V */
    public static String m56063V(Intent intent) {
        AppMethodBeat.m2504i(20633);
        String Mw = C34189m.m56058Mw(intent.getStringExtra("free_wifi_sessionkey"));
        AppMethodBeat.m2505o(20633);
        return Mw;
    }

    /* renamed from: W */
    public static int m56064W(Intent intent) {
        AppMethodBeat.m2504i(20634);
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        AppMethodBeat.m2505o(20634);
        return intExtra;
    }

    /* renamed from: X */
    public static int m56065X(Intent intent) {
        AppMethodBeat.m2504i(20635);
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        AppMethodBeat.m2505o(20635);
        return intExtra;
    }

    /* renamed from: Y */
    public static int m56066Y(Intent intent) {
        AppMethodBeat.m2504i(20636);
        int intExtra = intent.getIntExtra("free_wifi_channel_id", 0);
        AppMethodBeat.m2505o(20636);
        return intExtra;
    }

    /* renamed from: Z */
    public static String m56067Z(Intent intent) {
        AppMethodBeat.m2504i(20637);
        String stringExtra = intent.getStringExtra("free_wifi_ap_key");
        AppMethodBeat.m2505o(20637);
        return stringExtra;
    }

    /* renamed from: Mw */
    public static String m56058Mw(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: Mx */
    public static String m56059Mx(String str) {
        AppMethodBeat.m2504i(20638);
        String gE = C5023at.m7474gE(C4996ah.getContext());
        C4990ab.m7416i(str, "getConnectedWifiSsid()=".concat(String.valueOf(gE)));
        AppMethodBeat.m2505o(20638);
        return gE;
    }

    /* renamed from: My */
    public static String m56060My(String str) {
        AppMethodBeat.m2504i(20639);
        String gF = C5023at.m7475gF(C4996ah.getContext());
        C4990ab.m7416i(str, "getConnectedWifiBssid()=".concat(String.valueOf(gF)));
        AppMethodBeat.m2505o(20639);
        return gF;
    }

    /* renamed from: Mz */
    public static String m56061Mz(String str) {
        AppMethodBeat.m2504i(20640);
        String gG = C5023at.m7476gG(C4996ah.getContext());
        C4990ab.m7416i(str, "getConnectedWifiClientMac()=".concat(String.valueOf(gG)));
        AppMethodBeat.m2505o(20640);
        return gG;
    }

    /* renamed from: g */
    public static String m56077g(Exception exception) {
        AppMethodBeat.m2504i(20641);
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String Mw = C34189m.m56058Mw(stringWriter.toString());
        if (Mw.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            Mw = Mw.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        AppMethodBeat.m2505o(20641);
        return Mw;
    }

    /* renamed from: h */
    public static String m56078h(Exception exception) {
        AppMethodBeat.m2504i(20642);
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String Mw = C34189m.m56058Mw(stringWriter.toString());
        AppMethodBeat.m2505o(20642);
        return Mw;
    }

    /* renamed from: a */
    public static String m56068a(int i, C11968b c11968b, int i2) {
        Object format;
        AppMethodBeat.m2504i(20643);
        C4990ab.m7417i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", Integer.valueOf(i), c11968b.name, Long.valueOf(c11968b.muQ), Integer.valueOf(i2));
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(c11968b.muQ)}));
        if (abs <= 999) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        String stringBuilder = append.append(format).toString();
        AppMethodBeat.m2505o(20643);
        return stringBuilder;
    }

    /* renamed from: a */
    public static void m56071a(Intent intent, String str, final int i, int i2, final FreeWifiFrontPageUI freeWifiFrontPageUI, final String str2) {
        AppMethodBeat.m2504i(20644);
        C34189m.m56070a(intent, str, i, i2, new C34190a() {
            /* renamed from: h */
            public final void mo46010h(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(20624);
                FreeWifiFrontPageUI freeWifiFrontPageUI;
                C28089d c28089d;
                C28088a c28088a;
                if (i == 0 && i2 == 0) {
                    if (c1207m instanceof C28075a) {
                        C23391gj bzj = ((C28075a) c1207m).bzj();
                        if (bzj != null) {
                            C4990ab.m7417i(str2, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ, bzj.vIF);
                            FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI;
                            C28089d c28089d2 = C28089d.SUCCESS;
                            C11988b c11988b = new C11988b();
                            c11988b.mzh = bzj;
                            freeWifiFrontPageUI2.mo62019a(c28089d2, c11988b);
                            AppMethodBeat.m2505o(20624);
                            return;
                        }
                        C4990ab.m7416i(str2, "backPageInfo is null");
                        freeWifiFrontPageUI = freeWifiFrontPageUI;
                        c28089d = C28089d.FAIL;
                        c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(i, C11968b.GetBackPageReturn, 21);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        AppMethodBeat.m2505o(20624);
                        return;
                    }
                    AppMethodBeat.m2505o(20624);
                } else if (!C34189m.m56075eh(i, i2) || C34189m.isEmpty(str)) {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    c28089d = C28089d.FAIL;
                    c28088a = new C28088a();
                    c28088a.myI = C34189m.m56068a(i, C11968b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    AppMethodBeat.m2505o(20624);
                } else {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    c28089d = C28089d.FAIL;
                    c28088a = new C28088a();
                    c28088a.text = str;
                    c28088a.myI = C34189m.m56068a(i, C11968b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    AppMethodBeat.m2505o(20624);
                }
            }
        }, str2);
        AppMethodBeat.m2505o(20644);
    }

    /* renamed from: a */
    public static void m56070a(Intent intent, String str, int i, int i2, C34190a c34190a, String str2) {
        AppMethodBeat.m2504i(20645);
        final String str3 = str2;
        final String str4 = str;
        final Intent intent2 = intent;
        final int i3 = i;
        final int i4 = i2;
        final C34190a c34190a2 = c34190a;
        C11976j.byZ().byI().post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.freewifi.m$2$1 */
            class C69121 implements C1202f {
                C69121() {
                }

                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(20625);
                    C4990ab.m7417i(str3, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(intent2), Integer.valueOf(C34189m.m56064W(intent2)), Integer.valueOf(i), Integer.valueOf(i2), str);
                    C11967a byo = C11966k.byo();
                    byo.ssid = C34189m.m56059Mx(str3);
                    byo.bssid = C34189m.m56060My(str3);
                    byo.cuI = C34189m.m56061Mz(str3);
                    byo.cuH = str4;
                    byo.kBq = C34189m.m56063V(intent2);
                    byo.mue = C34189m.m56065X(intent2);
                    byo.muf = C11968b.GetBackPage33Return.muQ;
                    byo.mug = C11968b.GetBackPage33Return.name;
                    byo.cIb = C34189m.m56066Y(intent2);
                    byo.result = i2;
                    byo.ehr = str;
                    byo.byq().mo23810b(intent2, true).byp();
                    c34190a2.mo46010h(i, i2, str, c1207m);
                    AppMethodBeat.m2505o(20625);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(20626);
                C11967a byo = C11966k.byo();
                byo.ssid = C34189m.m56059Mx(str3);
                byo.bssid = C34189m.m56060My(str3);
                byo.cuI = C34189m.m56061Mz(str3);
                byo.cuH = str4;
                byo.kBq = C34189m.m56063V(intent2);
                byo.mue = i3;
                byo.muf = C11968b.GetBackPage.muQ;
                byo.mug = C11968b.GetBackPage.name;
                byo.cIb = C34189m.m56066Y(intent2);
                byo.result = 0;
                byo.byq().byp();
                String My = C34189m.m56060My(str3);
                String Mx = C34189m.m56059Mx(str3);
                int byL = C45957d.byL();
                C4990ab.m7416i(str3, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + C5023at.getNetType(C4996ah.getContext()));
                C4990ab.m7417i(str3, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", C34189m.m56063V(intent2), Integer.valueOf(C34189m.m56064W(intent2)), str4, My, Mx, Integer.valueOf(byL));
                new C28075a(str4, My, Mx, byL, i4, C34189m.m56063V(intent2)).mo68619c(new C69121());
                AppMethodBeat.m2505o(20626);
            }
        });
        AppMethodBeat.m2505o(20645);
    }

    public static int byt() {
        AppMethodBeat.m2504i(20646);
        C38034a apS = C38033l.apS();
        if (apS == C38034a.NO_INIT || apS == C38034a.SET_MOBILE) {
            AppMethodBeat.m2505o(20646);
            return 1;
        }
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(6, null);
        if (C34189m.isEmpty(str)) {
            AppMethodBeat.m2505o(20646);
            return 1;
        }
        Object Ps;
        if (str.startsWith("+")) {
            Ps = C5025av.m7481Ps(str);
        } else {
            Ps = "86";
        }
        if ("86".equals(Ps)) {
            AppMethodBeat.m2505o(20646);
            return 2;
        }
        AppMethodBeat.m2505o(20646);
        return 3;
    }

    /* renamed from: dU */
    public static void m56073dU(Context context) {
        AppMethodBeat.m2504i(20647);
        Intent intent = new Intent(context, BindMContactUI.class);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!C5046bo.isNullOrNil(simCountryIso)) {
            C17951a k = C17950b.m28210k(context, simCountryIso, context.getString(C25738R.string.b3_));
            if (k != null) {
                intent.putExtra("country_name", k.fHE);
                intent.putExtra("couttry_code", k.fHD);
            }
        }
        MMWizardActivity.m23791J(context, intent);
        AppMethodBeat.m2505o(20647);
    }

    /* renamed from: eg */
    public static boolean m56074eg(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: eh */
    public static boolean m56075eh(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    /* renamed from: i */
    public static int m56079i(Exception exception) {
        AppMethodBeat.m2504i(20648);
        if (exception instanceof SocketTimeoutException) {
            String h = C34189m.m56078h(exception);
            if (h.indexOf(".read") != -1) {
                AppMethodBeat.m2505o(20648);
                return 105;
            } else if (h.indexOf(".connect") != -1) {
                AppMethodBeat.m2505o(20648);
                return 104;
            } else {
                AppMethodBeat.m2505o(20648);
                return 101;
            }
        } else if (exception instanceof ConnectException) {
            AppMethodBeat.m2505o(20648);
            return 106;
        } else if (exception instanceof UnknownHostException) {
            AppMethodBeat.m2505o(20648);
            return 102;
        } else {
            AppMethodBeat.m2505o(20648);
            return 101;
        }
    }

    /* renamed from: k */
    public static boolean m56080k(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(20649);
        C4990ab.m7416i(str, "CLIENT_VERSION=" + C7243d.vxo);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        C4990ab.m7417i(str, "checkMsgPushedVersion. min0=%s,max0=%s", str2, str3);
        if (C34189m.isEmpty(str2) && C34189m.isEmpty(str3)) {
            AppMethodBeat.m2505o(20649);
            return false;
        } else if (C34189m.m56076eo(str2, str3)) {
            AppMethodBeat.m2505o(20649);
            return true;
        } else {
            int i = 1;
            while (true) {
                str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
                str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
                C4990ab.m7417i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", str2, str3);
                if (C34189m.isEmpty(str2) && C34189m.isEmpty(str3)) {
                    AppMethodBeat.m2505o(20649);
                    return false;
                } else if (C34189m.m56076eo(str2, str3)) {
                    AppMethodBeat.m2505o(20649);
                    return true;
                } else {
                    i++;
                }
            }
        }
    }

    /* renamed from: eo */
    private static boolean m56076eo(String str, String str2) {
        AppMethodBeat.m2504i(20650);
        int i = C5046bo.getInt(str, 0);
        int i2 = C5046bo.getInt(str2, 0);
        if (i == 0 && i2 != 0 && C7243d.vxo <= i2) {
            AppMethodBeat.m2505o(20650);
            return true;
        } else if (i != 0 && i2 == 0 && C7243d.vxo >= i) {
            AppMethodBeat.m2505o(20650);
            return true;
        } else if (i == 0 || i2 == 0 || C7243d.vxo < i || C7243d.vxo > i2) {
            AppMethodBeat.m2505o(20650);
            return false;
        } else {
            AppMethodBeat.m2505o(20650);
            return true;
        }
    }

    public static boolean byu() {
        AppMethodBeat.m2504i(20651);
        if (((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            C4990ab.m7416i("TAG", "isWifiConnected()=true");
            AppMethodBeat.m2505o(20651);
            return true;
        }
        C4990ab.m7416i("TAG", "isWifiConnected()=false");
        AppMethodBeat.m2505o(20651);
        return false;
    }

    public static C23460xa byv() {
        AppMethodBeat.m2504i(20652);
        C23460xa c23460xa = new C23460xa();
        c23460xa.deviceBrand = C7243d.vxi;
        if (C28078d.mtL == null || C28078d.mtL.equals("")) {
            c23460xa.wcW = C34189m.m56061Mz("MicroMsg.FreeWifi.Utils");
        } else {
            c23460xa.wcW = C28078d.mtL;
        }
        c23460xa.deviceModel = C7243d.vxj;
        c23460xa.osName = C7243d.vxl;
        c23460xa.osVersion = C7243d.vxm;
        AppMethodBeat.m2505o(20652);
        return c23460xa;
    }

    /* renamed from: a */
    public static String m56069a(String str, LinkedHashMap<String, Class> linkedHashMap, C7563j c7563j, String str2) {
        AppMethodBeat.m2504i(20653);
        String str3;
        if (linkedHashMap.size() == 0) {
            str3 = "";
            AppMethodBeat.m2505o(20653);
            return str3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry key : linkedHashMap.entrySet()) {
            stringBuilder2.append((String) key.getKey()).append(",");
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.delete(stringBuilder2.length() - 1, stringBuilder2.length());
        }
        String str4 = "select " + stringBuilder2.toString() + " from " + str;
        for (Entry key2 : linkedHashMap.entrySet()) {
            stringBuilder.append((String) key2.getKey()).append("\t");
        }
        stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        Cursor rawQuery = c7563j.rawQuery(str4, new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                int i = 0;
                for (Entry key22 : linkedHashMap.entrySet()) {
                    Class cls = (Class) key22.getValue();
                    if (cls == String.class) {
                        stringBuilder.append(rawQuery.getString(i));
                    } else if (cls == Integer.TYPE) {
                        stringBuilder.append(rawQuery.getInt(i));
                    } else if (cls == Long.TYPE) {
                        stringBuilder.append(rawQuery.getLong(i));
                    } else if (cls == Float.TYPE) {
                        stringBuilder.append(rawQuery.getFloat(i));
                    } else if (cls == Double.TYPE) {
                        stringBuilder.append(rawQuery.getDouble(i));
                    } else {
                        C4990ab.m7412e(str2, "unkonwn type " + cls.toString());
                        stringBuilder.append(rawQuery.getString(i));
                    }
                    stringBuilder.append("\t");
                    i++;
                }
                stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            } catch (Exception e) {
                C4990ab.m7416i(str2, "print " + str + "error." + e.getMessage());
                str3 = "";
                return str3;
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(20653);
            }
        }
        C4990ab.m7416i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    /* renamed from: MA */
    public static void m56056MA(String str) {
        AppMethodBeat.m2504i(20654);
        C4990ab.m7416i("FreeWifi", str);
        AppMethodBeat.m2505o(20654);
    }
}
