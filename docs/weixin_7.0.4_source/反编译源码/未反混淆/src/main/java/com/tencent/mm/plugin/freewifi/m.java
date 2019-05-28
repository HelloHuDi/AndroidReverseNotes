package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
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

public final class m {
    private static SimpleDateFormat juL = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public interface a {
        void h(int i, int i2, String str, com.tencent.mm.ai.m mVar);
    }

    public static boolean isEmpty(String str) {
        AppMethodBeat.i(20627);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(20627);
            return true;
        }
        AppMethodBeat.o(20627);
        return false;
    }

    static {
        AppMethodBeat.i(20655);
        AppMethodBeat.o(20655);
    }

    public static String Mv(String str) {
        AppMethodBeat.i(20628);
        if (isEmpty(str)) {
            str = "";
            AppMethodBeat.o(20628);
            return str;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        AppMethodBeat.o(20628);
        return str;
    }

    public static boolean byr() {
        AppMethodBeat.i(20629);
        String cc = bo.cc(ah.getContext());
        if (cc == null || !cc.toLowerCase().startsWith(ah.getPackageName())) {
            AppMethodBeat.o(20629);
            return false;
        }
        AppMethodBeat.o(20629);
        return true;
    }

    public static void U(Intent intent) {
        AppMethodBeat.i(20630);
        if (isEmpty(intent.getStringExtra("free_wifi_sessionkey"))) {
            d(intent, bys());
        }
        AppMethodBeat.o(20630);
    }

    public static String bys() {
        AppMethodBeat.i(20631);
        String replace = UUID.randomUUID().toString().replace("-", "");
        AppMethodBeat.o(20631);
        return replace;
    }

    public static void d(Intent intent, String str) {
        AppMethodBeat.i(20632);
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
        AppMethodBeat.o(20632);
    }

    public static String V(Intent intent) {
        AppMethodBeat.i(20633);
        String Mw = Mw(intent.getStringExtra("free_wifi_sessionkey"));
        AppMethodBeat.o(20633);
        return Mw;
    }

    public static int W(Intent intent) {
        AppMethodBeat.i(20634);
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        AppMethodBeat.o(20634);
        return intExtra;
    }

    public static int X(Intent intent) {
        AppMethodBeat.i(20635);
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        AppMethodBeat.o(20635);
        return intExtra;
    }

    public static int Y(Intent intent) {
        AppMethodBeat.i(20636);
        int intExtra = intent.getIntExtra("free_wifi_channel_id", 0);
        AppMethodBeat.o(20636);
        return intExtra;
    }

    public static String Z(Intent intent) {
        AppMethodBeat.i(20637);
        String stringExtra = intent.getStringExtra("free_wifi_ap_key");
        AppMethodBeat.o(20637);
        return stringExtra;
    }

    public static String Mw(String str) {
        return str == null ? "" : str;
    }

    public static String Mx(String str) {
        AppMethodBeat.i(20638);
        String gE = at.gE(ah.getContext());
        ab.i(str, "getConnectedWifiSsid()=".concat(String.valueOf(gE)));
        AppMethodBeat.o(20638);
        return gE;
    }

    public static String My(String str) {
        AppMethodBeat.i(20639);
        String gF = at.gF(ah.getContext());
        ab.i(str, "getConnectedWifiBssid()=".concat(String.valueOf(gF)));
        AppMethodBeat.o(20639);
        return gF;
    }

    public static String Mz(String str) {
        AppMethodBeat.i(20640);
        String gG = at.gG(ah.getContext());
        ab.i(str, "getConnectedWifiClientMac()=".concat(String.valueOf(gG)));
        AppMethodBeat.o(20640);
        return gG;
    }

    public static String g(Exception exception) {
        AppMethodBeat.i(20641);
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String Mw = Mw(stringWriter.toString());
        if (Mw.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            Mw = Mw.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        AppMethodBeat.o(20641);
        return Mw;
    }

    public static String h(Exception exception) {
        AppMethodBeat.i(20642);
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String Mw = Mw(stringWriter.toString());
        AppMethodBeat.o(20642);
        return Mw;
    }

    public static String a(int i, b bVar, int i2) {
        Object format;
        AppMethodBeat.i(20643);
        ab.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", Integer.valueOf(i), bVar.name, Long.valueOf(bVar.muQ), Integer.valueOf(i2));
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(bVar.muQ)}));
        if (abs <= 999) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        String stringBuilder = append.append(format).toString();
        AppMethodBeat.o(20643);
        return stringBuilder;
    }

    public static void a(Intent intent, String str, final int i, int i2, final FreeWifiFrontPageUI freeWifiFrontPageUI, final String str2) {
        AppMethodBeat.i(20644);
        a(intent, str, i, i2, new a() {
            public final void h(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(20624);
                FreeWifiFrontPageUI freeWifiFrontPageUI;
                d dVar;
                com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a aVar;
                if (i == 0 && i2 == 0) {
                    if (mVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        gj bzj = ((com.tencent.mm.plugin.freewifi.d.a) mVar).bzj();
                        if (bzj != null) {
                            ab.i(str2, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ, bzj.vIF);
                            FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI;
                            d dVar2 = d.SUCCESS;
                            FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                            bVar.mzh = bzj;
                            freeWifiFrontPageUI2.a(dVar2, bVar);
                            AppMethodBeat.o(20624);
                            return;
                        }
                        ab.i(str2, "backPageInfo is null");
                        freeWifiFrontPageUI = freeWifiFrontPageUI;
                        dVar = d.FAIL;
                        aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                        aVar.myI = m.a(i, b.GetBackPageReturn, 21);
                        freeWifiFrontPageUI.a(dVar, aVar);
                        AppMethodBeat.o(20624);
                        return;
                    }
                    AppMethodBeat.o(20624);
                } else if (!m.eh(i, i2) || m.isEmpty(str)) {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    dVar = d.FAIL;
                    aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                    aVar.myI = m.a(i, b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    AppMethodBeat.o(20624);
                } else {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    dVar = d.FAIL;
                    aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                    aVar.text = str;
                    aVar.myI = m.a(i, b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    AppMethodBeat.o(20624);
                }
            }
        }, str2);
        AppMethodBeat.o(20644);
    }

    public static void a(Intent intent, String str, int i, int i2, a aVar, String str2) {
        AppMethodBeat.i(20645);
        final String str3 = str2;
        final String str4 = str;
        final Intent intent2 = intent;
        final int i3 = i;
        final int i4 = i2;
        final a aVar2 = aVar;
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20626);
                com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
                byo.ssid = m.Mx(str3);
                byo.bssid = m.My(str3);
                byo.cuI = m.Mz(str3);
                byo.cuH = str4;
                byo.kBq = m.V(intent2);
                byo.mue = i3;
                byo.muf = b.GetBackPage.muQ;
                byo.mug = b.GetBackPage.name;
                byo.cIb = m.Y(intent2);
                byo.result = 0;
                byo.byq().byp();
                String My = m.My(str3);
                String Mx = m.Mx(str3);
                int byL = com.tencent.mm.plugin.freewifi.model.d.byL();
                ab.i(str3, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + at.getNetType(ah.getContext()));
                ab.i(str3, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.V(intent2), Integer.valueOf(m.W(intent2)), str4, My, Mx, Integer.valueOf(byL));
                new com.tencent.mm.plugin.freewifi.d.a(str4, My, Mx, byL, i4, m.V(intent2)).c(new f() {
                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(20625);
                        ab.i(str3, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.V(intent2), Integer.valueOf(m.W(intent2)), Integer.valueOf(i), Integer.valueOf(i2), str);
                        com.tencent.mm.plugin.freewifi.k.a byo = k.byo();
                        byo.ssid = m.Mx(str3);
                        byo.bssid = m.My(str3);
                        byo.cuI = m.Mz(str3);
                        byo.cuH = str4;
                        byo.kBq = m.V(intent2);
                        byo.mue = m.X(intent2);
                        byo.muf = b.GetBackPage33Return.muQ;
                        byo.mug = b.GetBackPage33Return.name;
                        byo.cIb = m.Y(intent2);
                        byo.result = i2;
                        byo.ehr = str;
                        byo.byq().b(intent2, true).byp();
                        aVar2.h(i, i2, str, mVar);
                        AppMethodBeat.o(20625);
                    }
                });
                AppMethodBeat.o(20626);
            }
        });
        AppMethodBeat.o(20645);
    }

    public static int byt() {
        AppMethodBeat.i(20646);
        com.tencent.mm.plugin.account.friend.a.l.a apS = l.apS();
        if (apS == com.tencent.mm.plugin.account.friend.a.l.a.NO_INIT || apS == com.tencent.mm.plugin.account.friend.a.l.a.SET_MOBILE) {
            AppMethodBeat.o(20646);
            return 1;
        }
        aw.ZK();
        String str = (String) c.Ry().get(6, null);
        if (isEmpty(str)) {
            AppMethodBeat.o(20646);
            return 1;
        }
        Object Ps;
        if (str.startsWith("+")) {
            Ps = av.Ps(str);
        } else {
            Ps = "86";
        }
        if ("86".equals(Ps)) {
            AppMethodBeat.o(20646);
            return 2;
        }
        AppMethodBeat.o(20646);
        return 3;
    }

    public static void dU(Context context) {
        AppMethodBeat.i(20647);
        Intent intent = new Intent(context, BindMContactUI.class);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!bo.isNullOrNil(simCountryIso)) {
            com.tencent.mm.au.b.a k = com.tencent.mm.au.b.k(context, simCountryIso, context.getString(R.string.b3_));
            if (k != null) {
                intent.putExtra("country_name", k.fHE);
                intent.putExtra("couttry_code", k.fHD);
            }
        }
        MMWizardActivity.J(context, intent);
        AppMethodBeat.o(20647);
    }

    public static boolean eg(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean eh(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    public static int i(Exception exception) {
        AppMethodBeat.i(20648);
        if (exception instanceof SocketTimeoutException) {
            String h = h(exception);
            if (h.indexOf(".read") != -1) {
                AppMethodBeat.o(20648);
                return 105;
            } else if (h.indexOf(".connect") != -1) {
                AppMethodBeat.o(20648);
                return 104;
            } else {
                AppMethodBeat.o(20648);
                return 101;
            }
        } else if (exception instanceof ConnectException) {
            AppMethodBeat.o(20648);
            return 106;
        } else if (exception instanceof UnknownHostException) {
            AppMethodBeat.o(20648);
            return 102;
        } else {
            AppMethodBeat.o(20648);
            return 101;
        }
    }

    public static boolean k(Map<String, String> map, String str) {
        AppMethodBeat.i(20649);
        ab.i(str, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.vxo);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        ab.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", str2, str3);
        if (isEmpty(str2) && isEmpty(str3)) {
            AppMethodBeat.o(20649);
            return false;
        } else if (eo(str2, str3)) {
            AppMethodBeat.o(20649);
            return true;
        } else {
            int i = 1;
            while (true) {
                str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
                str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
                ab.i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", str2, str3);
                if (isEmpty(str2) && isEmpty(str3)) {
                    AppMethodBeat.o(20649);
                    return false;
                } else if (eo(str2, str3)) {
                    AppMethodBeat.o(20649);
                    return true;
                } else {
                    i++;
                }
            }
        }
    }

    private static boolean eo(String str, String str2) {
        AppMethodBeat.i(20650);
        int i = bo.getInt(str, 0);
        int i2 = bo.getInt(str2, 0);
        if (i == 0 && i2 != 0 && com.tencent.mm.protocal.d.vxo <= i2) {
            AppMethodBeat.o(20650);
            return true;
        } else if (i != 0 && i2 == 0 && com.tencent.mm.protocal.d.vxo >= i) {
            AppMethodBeat.o(20650);
            return true;
        } else if (i == 0 || i2 == 0 || com.tencent.mm.protocal.d.vxo < i || com.tencent.mm.protocal.d.vxo > i2) {
            AppMethodBeat.o(20650);
            return false;
        } else {
            AppMethodBeat.o(20650);
            return true;
        }
    }

    public static boolean byu() {
        AppMethodBeat.i(20651);
        if (((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            ab.i("TAG", "isWifiConnected()=true");
            AppMethodBeat.o(20651);
            return true;
        }
        ab.i("TAG", "isWifiConnected()=false");
        AppMethodBeat.o(20651);
        return false;
    }

    public static xa byv() {
        AppMethodBeat.i(20652);
        xa xaVar = new xa();
        xaVar.deviceBrand = com.tencent.mm.protocal.d.vxi;
        if (d.mtL == null || d.mtL.equals("")) {
            xaVar.wcW = Mz("MicroMsg.FreeWifi.Utils");
        } else {
            xaVar.wcW = d.mtL;
        }
        xaVar.deviceModel = com.tencent.mm.protocal.d.vxj;
        xaVar.osName = com.tencent.mm.protocal.d.vxl;
        xaVar.osVersion = com.tencent.mm.protocal.d.vxm;
        AppMethodBeat.o(20652);
        return xaVar;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, com.tencent.mm.sdk.e.j jVar, String str2) {
        AppMethodBeat.i(20653);
        String str3;
        if (linkedHashMap.size() == 0) {
            str3 = "";
            AppMethodBeat.o(20653);
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
        Cursor rawQuery = jVar.rawQuery(str4, new String[0]);
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
                        ab.e(str2, "unkonwn type " + cls.toString());
                        stringBuilder.append(rawQuery.getString(i));
                    }
                    stringBuilder.append("\t");
                    i++;
                }
                stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            } catch (Exception e) {
                ab.i(str2, "print " + str + "error." + e.getMessage());
                str3 = "";
                return str3;
            } finally {
                rawQuery.close();
                AppMethodBeat.o(20653);
            }
        }
        ab.i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    public static void MA(String str) {
        AppMethodBeat.i(20654);
        ab.i("FreeWifi", str);
        AppMethodBeat.o(20654);
    }
}
