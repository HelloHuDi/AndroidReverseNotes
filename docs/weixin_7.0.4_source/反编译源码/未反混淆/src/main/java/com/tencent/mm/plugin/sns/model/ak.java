package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class ak {
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02bb A:{SYNTHETIC, EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f4 A:{Catch:{ Exception -> 0x039f }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01bf A:{Catch:{ Exception -> 0x02a3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f4 A:{Catch:{ Exception -> 0x039f }} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02bb A:{SYNTHETIC, EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01bf A:{Catch:{ Exception -> 0x02a3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02bb A:{SYNTHETIC, EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f4 A:{Catch:{ Exception -> 0x039f }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f4 A:{Catch:{ Exception -> 0x039f }} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02bb A:{SYNTHETIC, EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  , EDGE_INSN: B:117:0x02bb->B:98:0x02bb ?: BREAK  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String cnZ() {
        String str;
        Throwable e;
        TelephonyManager telephonyManager;
        String str2;
        String str3;
        String str4;
        List gJ;
        int i;
        String str5;
        Throwable e2;
        StringBuilder stringBuilder;
        Throwable e3;
        AppMethodBeat.i(36564);
        Context context = ah.getContext();
        if (context == null) {
            ab.e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            AppMethodBeat.o(36564);
            return null;
        }
        int subtype;
        String stringBuffer;
        int i2 = 0;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i2 = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i2 = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i2 = 3;
            } else if (subtype == 1 || subtype == 2) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        } catch (Exception e4) {
            ab.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bo.l(e4));
        }
        ab.i("MicroMsg.SnsItemReportHelper", "get netType :%d", Integer.valueOf(i2));
        String str6 = "";
        String str7 = "";
        String str8 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();
            subtype = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer2.append(at.gE(ah.getContext()));
            stringBuffer3.append(at.gF(ah.getContext()));
            String gF = at.gF(ah.getContext());
            arrayList.add(gF);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                    }
                });
                int i3 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bo.isNullOrNil(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(gF)) {
                            int i4 = i3 - 1;
                            if (i3 <= 0) {
                                break;
                            }
                            stringBuffer2.append("|");
                            stringBuffer2.append(bo.nullAsNil(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer3.append("|");
                            stringBuffer3.append(bo.nullAsNil(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer4.append("|");
                            stringBuffer4.append(scanResult.level);
                            i3 = i4;
                        } else {
                            subtype = scanResult.level;
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
            try {
                str7 = stringBuffer3.toString();
                str8 = subtype + stringBuffer4.toString();
                str = stringBuffer;
            } catch (Exception e5) {
                e = e5;
                ab.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", bo.l(e));
                str = stringBuffer;
                ab.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str, str8);
                str6 = "";
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                }
                str6 = stringBuffer;
                ab.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
                str2 = "";
                str3 = "";
                str4 = "";
                stringBuffer = "";
                gJ = at.gJ(context);
                i = 0;
                while (true) {
                    try {
                        str5 = stringBuffer;
                        if (i >= gJ.size()) {
                        }
                        i++;
                    } catch (Exception e6) {
                        e2 = e6;
                        stringBuffer = str5;
                        ab.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bo.l(e2));
                        ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(i2).append(",");
                        stringBuilder.append(str.replace(",", " ")).append(",");
                        stringBuilder.append(str7.replace(",", " ")).append(",");
                        stringBuilder.append(str8.replace(",", " ")).append(",");
                        stringBuilder.append(str6.replace(",", " ")).append(",");
                        stringBuilder.append(str2.replace(",", " ")).append(",");
                        stringBuilder.append(str3.replace(",", " ")).append(",");
                        stringBuilder.append(str4.replace(",", " ")).append(",");
                        stringBuilder.append(stringBuffer.replace(",", " "));
                        stringBuffer = stringBuilder.toString();
                        AppMethodBeat.o(36564);
                        return stringBuffer;
                    }
                }
                stringBuffer = str5;
                ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
                stringBuilder = new StringBuilder();
                stringBuilder.append(i2).append(",");
                stringBuilder.append(str.replace(",", " ")).append(",");
                stringBuilder.append(str7.replace(",", " ")).append(",");
                stringBuilder.append(str8.replace(",", " ")).append(",");
                stringBuilder.append(str6.replace(",", " ")).append(",");
                stringBuilder.append(str2.replace(",", " ")).append(",");
                stringBuilder.append(str3.replace(",", " ")).append(",");
                stringBuilder.append(str4.replace(",", " ")).append(",");
                stringBuilder.append(stringBuffer.replace(",", " "));
                stringBuffer = stringBuilder.toString();
                AppMethodBeat.o(36564);
                return stringBuffer;
            }
        } catch (Exception e7) {
            e = e7;
            stringBuffer = str6;
            ab.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", bo.l(e));
            str = stringBuffer;
            ab.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str, str8);
            str6 = "";
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
            }
            str6 = stringBuffer;
            ab.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
            str2 = "";
            str3 = "";
            str4 = "";
            stringBuffer = "";
            gJ = at.gJ(context);
            i = 0;
            while (true) {
                str5 = stringBuffer;
                if (i >= gJ.size()) {
                }
                i++;
            }
            stringBuffer = str5;
            ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str.replace(",", " ")).append(",");
            stringBuilder.append(str7.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(str2.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(stringBuffer.replace(",", " "));
            stringBuffer = stringBuilder.toString();
            AppMethodBeat.o(36564);
            return stringBuffer;
        }
        ab.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str, str8);
        str6 = "";
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                stringBuffer = telephonyManager.getNetworkOperatorName();
                try {
                    if (bo.isNullOrNil(stringBuffer)) {
                        stringBuffer = "";
                    }
                } catch (Exception e8) {
                    e3 = e8;
                    ab.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bo.l(e3));
                    str6 = stringBuffer;
                    ab.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
                    str2 = "";
                    str3 = "";
                    str4 = "";
                    stringBuffer = "";
                    gJ = at.gJ(context);
                    i = 0;
                    while (true) {
                        str5 = stringBuffer;
                        if (i >= gJ.size()) {
                        }
                        i++;
                    }
                    stringBuffer = str5;
                    ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str.replace(",", " ")).append(",");
                    stringBuilder.append(str7.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(stringBuffer.replace(",", " "));
                    stringBuffer = stringBuilder.toString();
                    AppMethodBeat.o(36564);
                    return stringBuffer;
                }
            }
            stringBuffer = str6;
            str6 = stringBuffer;
        } catch (Exception e9) {
            e3 = e9;
            stringBuffer = str6;
            ab.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bo.l(e3));
            str6 = stringBuffer;
            ab.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
            str2 = "";
            str3 = "";
            str4 = "";
            stringBuffer = "";
            gJ = at.gJ(context);
            i = 0;
            while (true) {
                str5 = stringBuffer;
                if (i >= gJ.size()) {
                }
                i++;
            }
            stringBuffer = str5;
            ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str.replace(",", " ")).append(",");
            stringBuilder.append(str7.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(str2.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(stringBuffer.replace(",", " "));
            stringBuffer = stringBuilder.toString();
            AppMethodBeat.o(36564);
            return stringBuffer;
        }
        ab.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
        str2 = "";
        str3 = "";
        str4 = "";
        stringBuffer = "";
        try {
            gJ = at.gJ(context);
            i = 0;
            while (true) {
                str5 = stringBuffer;
                if (i >= gJ.size()) {
                    break;
                }
                a aVar = (a) gJ.get(i);
                str2 = bo.bc(aVar.org, "");
                str3 = bo.bc(aVar.orh, "");
                if (str4.length() > 0 && !bo.isNullOrNil(aVar.ori)) {
                    str4 = str4 + "|";
                }
                if (!bo.isNullOrNil(aVar.ori)) {
                    str4 = str4 + aVar.ori;
                }
                if (str5.length() > 0 && !bo.isNullOrNil(aVar.tzp)) {
                    str5 = str5 + "|";
                }
                if (bo.isNullOrNil(aVar.tzp)) {
                    stringBuffer = str5;
                } else {
                    stringBuffer = str5 + aVar.tzp;
                }
                i++;
            }
            stringBuffer = str5;
        } catch (Exception e32) {
            e2 = e32;
            ab.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bo.l(e2));
            ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str.replace(",", " ")).append(",");
            stringBuilder.append(str7.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(str2.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(stringBuffer.replace(",", " "));
            stringBuffer = stringBuilder.toString();
            AppMethodBeat.o(36564);
            return stringBuffer;
        }
        ab.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
        stringBuilder = new StringBuilder();
        stringBuilder.append(i2).append(",");
        stringBuilder.append(str.replace(",", " ")).append(",");
        stringBuilder.append(str7.replace(",", " ")).append(",");
        stringBuilder.append(str8.replace(",", " ")).append(",");
        stringBuilder.append(str6.replace(",", " ")).append(",");
        stringBuilder.append(str2.replace(",", " ")).append(",");
        stringBuilder.append(str3.replace(",", " ")).append(",");
        stringBuilder.append(str4.replace(",", " ")).append(",");
        stringBuilder.append(stringBuffer.replace(",", " "));
        stringBuffer = stringBuilder.toString();
        AppMethodBeat.o(36564);
        return stringBuffer;
    }

    public static void iN(long j) {
        AppMethodBeat.i(36565);
        if (j == 0) {
            AppMethodBeat.o(36565);
            return;
        }
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(36565);
        } else if (kD.field_type != 1) {
            AppMethodBeat.o(36565);
        } else {
            bav cqM = kD.cqM();
            if (cqM == null) {
                AppMethodBeat.o(36565);
                return;
            }
            LinkedList linkedList = cqM.wFr;
            LinkedList linkedList2 = kD.cqu().xfI.wbK;
            int min = Math.min(linkedList.size(), linkedList2.size());
            String str = "";
            if (min > 0) {
                str = cnZ();
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(36565);
                    return;
                }
            }
            String str2 = str;
            for (int i = 0; i < min; i++) {
                cbv cbv = (cbv) linkedList.get(i);
                StringBuffer stringBuffer = new StringBuffer();
                bau bau = (bau) linkedList2.get(i);
                stringBuffer.append("||index: ".concat(String.valueOf(i)));
                stringBuffer.append("||item poi lat " + cbv.xbm + " " + cbv.xbn);
                stringBuffer.append("||item poi accuracy loctype " + cbv.bEJ + " " + cbv.rkk);
                stringBuffer.append("||item pic lat " + cbv.xbk + " " + cbv.xbl);
                stringBuffer.append("||item exitime:" + cbv.xbp + " filetime: " + cbv.xbq);
                stringBuffer.append("||item source: " + cbv.xbo);
                stringBuffer.append("||url" + bau.Url);
                String str3 = bau.Url;
                if (str3.startsWith("http://mmsns.qpic.cn/mmsns/")) {
                    int lastIndexOf = str3.lastIndexOf("/");
                    if (lastIndexOf > 27 && lastIndexOf < str3.length()) {
                        str3 = str3.substring(27, lastIndexOf);
                    }
                }
                ab.d("MicroMsg.SnsItemReportHelper", "report:%s", str3 + "," + i.jV(j) + "," + i + "," + bo.anT() + "," + cbv.xbo + "," + cbv.xbq + "," + cbv.xbp + "," + cbv.xbl + "," + cbv.xbk + "," + cbv.xbn + "," + cbv.xbm + "," + str2 + "," + cbv.bEJ + "," + cbv.rkk);
                h.pYm.X(11985, str);
            }
            AppMethodBeat.o(36565);
        }
    }
}
