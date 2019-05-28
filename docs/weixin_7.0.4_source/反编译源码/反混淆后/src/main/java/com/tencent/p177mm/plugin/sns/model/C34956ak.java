package com.tencent.p177mm.plugin.sns.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.cbv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5023at.C5022a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.ak */
public final class C34956ak {

    /* renamed from: com.tencent.mm.plugin.sns.model.ak$1 */
    static class C134081 implements Comparator<ScanResult> {
        C134081() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    }

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
        AppMethodBeat.m2504i(36564);
        Context context = C4996ah.getContext();
        if (context == null) {
            C4990ab.m7412e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            AppMethodBeat.m2505o(36564);
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
            C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getNetType : %s", C5046bo.m7574l(e4));
        }
        C4990ab.m7417i("MicroMsg.SnsItemReportHelper", "get netType :%d", Integer.valueOf(i2));
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
            stringBuffer2.append(C5023at.m7474gE(C4996ah.getContext()));
            stringBuffer3.append(C5023at.m7475gF(C4996ah.getContext()));
            String gF = C5023at.m7475gF(C4996ah.getContext());
            arrayList.add(gF);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new C134081());
                int i3 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || C5046bo.isNullOrNil(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(gF)) {
                            int i4 = i3 - 1;
                            if (i3 <= 0) {
                                break;
                            }
                            stringBuffer2.append("|");
                            stringBuffer2.append(C5046bo.nullAsNil(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer3.append("|");
                            stringBuffer3.append(C5046bo.nullAsNil(scanResult.BSSID).replace("|", "").replace(" ", ""));
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
                C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", C5046bo.m7574l(e));
                str = stringBuffer;
                C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str, str8);
                str6 = "";
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                }
                str6 = stringBuffer;
                C4990ab.m7417i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
                str2 = "";
                str3 = "";
                str4 = "";
                stringBuffer = "";
                gJ = C5023at.m7479gJ(context);
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
                        C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getNetType : %s", C5046bo.m7574l(e2));
                        C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
                        AppMethodBeat.m2505o(36564);
                        return stringBuffer;
                    }
                }
                stringBuffer = str5;
                C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
                AppMethodBeat.m2505o(36564);
                return stringBuffer;
            }
        } catch (Exception e7) {
            e = e7;
            stringBuffer = str6;
            C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", C5046bo.m7574l(e));
            str = stringBuffer;
            C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str, str8);
            str6 = "";
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
            }
            str6 = stringBuffer;
            C4990ab.m7417i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
            str2 = "";
            str3 = "";
            str4 = "";
            stringBuffer = "";
            gJ = C5023at.m7479gJ(context);
            i = 0;
            while (true) {
                str5 = stringBuffer;
                if (i >= gJ.size()) {
                }
                i++;
            }
            stringBuffer = str5;
            C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
            AppMethodBeat.m2505o(36564);
            return stringBuffer;
        }
        C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str, str8);
        str6 = "";
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                stringBuffer = telephonyManager.getNetworkOperatorName();
                try {
                    if (C5046bo.isNullOrNil(stringBuffer)) {
                        stringBuffer = "";
                    }
                } catch (Exception e8) {
                    e3 = e8;
                    C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getNetType : %s", C5046bo.m7574l(e3));
                    str6 = stringBuffer;
                    C4990ab.m7417i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
                    str2 = "";
                    str3 = "";
                    str4 = "";
                    stringBuffer = "";
                    gJ = C5023at.m7479gJ(context);
                    i = 0;
                    while (true) {
                        str5 = stringBuffer;
                        if (i >= gJ.size()) {
                        }
                        i++;
                    }
                    stringBuffer = str5;
                    C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
                    AppMethodBeat.m2505o(36564);
                    return stringBuffer;
                }
            }
            stringBuffer = str6;
            str6 = stringBuffer;
        } catch (Exception e9) {
            e3 = e9;
            stringBuffer = str6;
            C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getNetType : %s", C5046bo.m7574l(e3));
            str6 = stringBuffer;
            C4990ab.m7417i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
            str2 = "";
            str3 = "";
            str4 = "";
            stringBuffer = "";
            gJ = C5023at.m7479gJ(context);
            i = 0;
            while (true) {
                str5 = stringBuffer;
                if (i >= gJ.size()) {
                }
                i++;
            }
            stringBuffer = str5;
            C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
            AppMethodBeat.m2505o(36564);
            return stringBuffer;
        }
        C4990ab.m7417i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str6);
        str2 = "";
        str3 = "";
        str4 = "";
        stringBuffer = "";
        try {
            gJ = C5023at.m7479gJ(context);
            i = 0;
            while (true) {
                str5 = stringBuffer;
                if (i >= gJ.size()) {
                    break;
                }
                C5022a c5022a = (C5022a) gJ.get(i);
                str2 = C5046bo.m7532bc(c5022a.org, "");
                str3 = C5046bo.m7532bc(c5022a.orh, "");
                if (str4.length() > 0 && !C5046bo.isNullOrNil(c5022a.ori)) {
                    str4 = str4 + "|";
                }
                if (!C5046bo.isNullOrNil(c5022a.ori)) {
                    str4 = str4 + c5022a.ori;
                }
                if (str5.length() > 0 && !C5046bo.isNullOrNil(c5022a.tzp)) {
                    str5 = str5 + "|";
                }
                if (C5046bo.isNullOrNil(c5022a.tzp)) {
                    stringBuffer = str5;
                } else {
                    stringBuffer = str5 + c5022a.tzp;
                }
                i++;
            }
            stringBuffer = str5;
        } catch (Exception e32) {
            e2 = e32;
            C4990ab.m7413e("MicroMsg.SnsItemReportHelper", "getNetType : %s", C5046bo.m7574l(e2));
            C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
            AppMethodBeat.m2505o(36564);
            return stringBuffer;
        }
        C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str2, str3, str4, stringBuffer);
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
        AppMethodBeat.m2505o(36564);
        return stringBuffer;
    }

    /* renamed from: iN */
    public static void m57410iN(long j) {
        AppMethodBeat.m2504i(36565);
        if (j == 0) {
            AppMethodBeat.m2505o(36565);
            return;
        }
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(36565);
        } else if (kD.field_type != 1) {
            AppMethodBeat.m2505o(36565);
        } else {
            bav cqM = kD.cqM();
            if (cqM == null) {
                AppMethodBeat.m2505o(36565);
                return;
            }
            LinkedList linkedList = cqM.wFr;
            LinkedList linkedList2 = kD.cqu().xfI.wbK;
            int min = Math.min(linkedList.size(), linkedList2.size());
            String str = "";
            if (min > 0) {
                str = C34956ak.cnZ();
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(36565);
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
                C4990ab.m7411d("MicroMsg.SnsItemReportHelper", "report:%s", str3 + "," + C29036i.m46117jV(j) + "," + i + "," + C5046bo.anT() + "," + cbv.xbo + "," + cbv.xbq + "," + cbv.xbp + "," + cbv.xbl + "," + cbv.xbk + "," + cbv.xbn + "," + cbv.xbm + "," + str2 + "," + cbv.bEJ + "," + cbv.rkk);
                C7060h.pYm.mo8374X(11985, str);
            }
            AppMethodBeat.m2505o(36565);
        }
    }
}
