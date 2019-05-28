package com.tencent.p177mm.plugin.wallet_core.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.p057v4.content.C0380b;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.jniinterface.AesEcb;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.protocal.protobuf.C15319aw;
import com.tencent.p177mm.protocal.protobuf.biv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.k */
public final class C22594k {
    private static C22595b tzk;
    private static C22594k tzl;
    private static C15319aw tzm = null;
    private static long tzn = 0;
    public JSONArray tzo;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.k$a */
    public static class C22593a {
        public String iBz;
        public String org;
        public String orh;
        public String ori;
        public String systemId;
        public String type;
        public String tzp;
        public String tzq;
        public String tzr;
        public String tzs;
        public String tzt;
        public String tzu;
        public String tzv;
        public String tzw;
        public String tzx;
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.k$b */
    static class C22595b implements C42206a {
        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            return z;
        }
    }

    private C22594k() {
        AppMethodBeat.m2504i(46766);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, (Object) "");
        C4990ab.m7416i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
        if (!C5046bo.isNullOrNil(str)) {
            try {
                this.tzo = new JSONArray(str);
                AppMethodBeat.m2505o(46766);
                return;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.GpsReportHelper", "parse lbs config error", e);
            }
        }
        AppMethodBeat.m2505o(46766);
    }

    public static C22594k cPt() {
        AppMethodBeat.m2504i(46767);
        if (tzl == null) {
            tzl = new C22594k();
        }
        C22594k c22594k = tzl;
        AppMethodBeat.m2505o(46767);
        return c22594k;
    }

    private static String cPu() {
        AppMethodBeat.m2504i(46768);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Context context = C4996ah.getContext();
            String str2;
            if (context == null) {
                str2 = "";
                AppMethodBeat.m2505o(46768);
                return str2;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            int i = 0;
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                stringBuffer.append(String.format(str, new Object[]{Integer.valueOf(i), C22594k.m34295kX(scanResult.SSID), Integer.valueOf(i), C22594k.m34295kX(scanResult.BSSID), Integer.valueOf(i), Integer.valueOf(scanResult.level)}));
                int i2 = i + 1;
                if (i2 >= 5) {
                    break;
                }
                i = i2;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7413e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", Long.valueOf(currentTimeMillis2));
            str2 = stringBuffer.toString();
            AppMethodBeat.m2505o(46768);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
    }

    private static String cPv() {
        AppMethodBeat.m2504i(46769);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        String stringBuilder;
        if (C22594k.cPB()) {
            hashMap.put("is_ci_permitted", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hashMap.put("net_type", C5023at.m7471gB(C4996ah.getContext()));
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7413e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", Long.valueOf(currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (C22594k.cPw()) {
                hashMap.put("is_ci_permitted", "1");
                hashMap.put("uuid", UUID.randomUUID().toString());
                hashMap.put("sample_time", (System.currentTimeMillis() / 1000));
                hashMap.put("phone_brand", Build.BRAND);
                hashMap.put("phone_model", Build.MODEL);
                try {
                    if (C4996ah.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            hashMap.put("net_subtype", activeNetworkInfo.getSubtype());
                        }
                    }
                } catch (Exception e) {
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                C4990ab.m7413e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", Long.valueOf(currentTimeMillis));
                currentTimeMillis = System.currentTimeMillis();
                List et = C22594k.m34293et(C4996ah.getContext());
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                C4990ab.m7413e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", Long.valueOf(currentTimeMillis));
                currentTimeMillis2 = System.currentTimeMillis();
                int size = et.size();
                for (int i = 0; i < size; i++) {
                    C22593a c22593a = (C22593a) et.get(i);
                    if (c22593a != null) {
                        hashMap.put("mcc_".concat(String.valueOf(i)), c22593a.org);
                        hashMap.put("mnc_".concat(String.valueOf(i)), c22593a.orh);
                        hashMap.put("lac_".concat(String.valueOf(i)), c22593a.tzp);
                        hashMap.put("cell_id_".concat(String.valueOf(i)), c22593a.ori);
                        hashMap.put("type_".concat(String.valueOf(i)), c22593a.type);
                        hashMap.put("sid_".concat(String.valueOf(i)), c22593a.tzr);
                        hashMap.put("net_id_".concat(String.valueOf(i)), c22593a.tzs);
                        hashMap.put("sys_id_".concat(String.valueOf(i)), c22593a.systemId);
                        hashMap.put("dbm_".concat(String.valueOf(i)), c22593a.tzt);
                        hashMap.put("tac_".concat(String.valueOf(i)), c22593a.tzq);
                        hashMap.put("arfcn_".concat(String.valueOf(i)), c22593a.tzw);
                        hashMap.put("earfcn_".concat(String.valueOf(i)), c22593a.tzu);
                        hashMap.put("uarfcn_".concat(String.valueOf(i)), c22593a.tzv);
                        hashMap.put("dbm_".concat(String.valueOf(i)), c22593a.tzt);
                    }
                }
                hashMap.put("count", String.valueOf(size));
            }
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (String stringBuilder3 : hashMap.keySet()) {
                if (!C5046bo.isNullOrNil((String) hashMap.get(stringBuilder3))) {
                    stringBuilder2.append(String.format("&%s=%s", new Object[]{(String) r7.next(), C22594k.m34295kX((String) hashMap.get(stringBuilder3))}));
                }
            }
            stringBuilder3 = stringBuilder2.toString();
            if (!C5046bo.isNullOrNil(stringBuilder3) && stringBuilder3.indexOf("&") == 0) {
                stringBuilder3 = stringBuilder3.substring(1);
            }
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            C4990ab.m7413e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", Long.valueOf(currentTimeMillis2));
            AppMethodBeat.m2505o(46769);
            return stringBuilder3;
        }
        stringBuilder3 = "";
        AppMethodBeat.m2505o(46769);
        return stringBuilder3;
    }

    private static boolean cPw() {
        AppMethodBeat.m2504i(46770);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (C0380b.checkSelfPermission(C4996ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    AppMethodBeat.m2505o(46770);
                    return true;
                }
                AppMethodBeat.m2505o(46770);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GpsReportHelper", "check permission exception:%s.", e);
                AppMethodBeat.m2505o(46770);
                return true;
            }
        }
        AppMethodBeat.m2505o(46770);
        return true;
    }

    /* renamed from: kX */
    private static String m34295kX(String str) {
        AppMethodBeat.m2504i(46771);
        try {
            str = C18178q.encode(str, "UTF-8");
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(46771);
        return str;
    }

    /* renamed from: gM */
    private static void m34294gM(String str, String str2) {
        AppMethodBeat.m2504i(46772);
        if (tzm == null) {
            tzm = new C15319aw();
        }
        C4990ab.m7411d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", str, str2);
        byte[] bArr = new byte[16];
        byte[] bytes = C30862w.dNR().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        bytes = Base64.encode(bArr, 0);
        C15319aw c15319aw = tzm;
        if (C43810o.tzz == null) {
            C43810o.tzz = new C43810o();
        }
        c15319aw.vCI = C43810o.tzz.mo69493bw(bytes);
        C4990ab.m7411d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", tzm.vCI);
        if (!C5046bo.isNullOrNil(str)) {
            bytes = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
            tzm.vCH = new String(bytes);
            C4990ab.m7411d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new String(bytes));
        }
        if (!C5046bo.isNullOrNil(str2)) {
            bytes = Base64.encode(AesEcb.aesCryptEcb(str2.getBytes(), bArr, true, true), 0);
            tzm.vCJ = new String(bytes);
            C4990ab.m7411d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new String(bytes));
        }
        AppMethodBeat.m2505o(46772);
    }

    /* renamed from: Hp */
    public static void m34292Hp(int i) {
        AppMethodBeat.m2504i(46773);
        C4990ab.m7416i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(i)));
        tzn = System.currentTimeMillis() / 1000;
        if (!C22594k.cPz()) {
            tzk = null;
            C22594k.cPx();
            tzn = System.currentTimeMillis() / 1000;
        }
        AppMethodBeat.m2505o(46773);
    }

    private static void cPx() {
        AppMethodBeat.m2504i(46774);
        long currentTimeMillis = System.currentTimeMillis();
        if (C22594k.cPz()) {
            AppMethodBeat.m2505o(46774);
            return;
        }
        if (C22594k.cPA() || C22594k.cPB()) {
            String str;
            String str2 = "";
            try {
                str = ((WifiManager) C4996ah.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getRssi();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                str = str2;
            }
            str2 = C5023at.m7474gE(C4996ah.getContext());
            String str3 = System.currentTimeMillis();
            String gF = C5023at.m7475gF(C4996ah.getContext());
            String gG = C5023at.m7476gG(C4996ah.getContext());
            str = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[]{C22594k.m34295kX(str2), C22594k.m34295kX(gF), C22594k.m34295kX(gG), str, str3});
            str2 = str + C22594k.cPu();
            if (C22594k.cPB()) {
                str = C22594k.cPv();
            } else {
                str = null;
            }
            C22594k.m34294gM(str2, str);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        C4990ab.m7413e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", Long.valueOf(currentTimeMillis2));
        AppMethodBeat.m2505o(46774);
    }

    public static C15319aw cPy() {
        AppMethodBeat.m2504i(46775);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - tzn > 300) {
            C22594k.cPx();
            tzn = currentTimeMillis;
        }
        C15319aw c15319aw = tzm;
        AppMethodBeat.m2505o(46775);
        return c15319aw;
    }

    public static biv bQO() {
        AppMethodBeat.m2504i(46776);
        if (tzm == null) {
            AppMethodBeat.m2505o(46776);
            return null;
        }
        biv biv = new biv();
        biv.dud = tzm.dud;
        biv.duc = tzm.duc;
        biv.latitude = tzm.latitude;
        biv.longitude = tzm.longitude;
        biv.vCE = tzm.vCE;
        biv.vCI = tzm.vCI;
        biv.vCF = tzm.vCF;
        biv.vCG = tzm.vCG;
        biv.vCH = tzm.vCH;
        AppMethodBeat.m2505o(46776);
        return biv;
    }

    private static boolean cPz() {
        AppMethodBeat.m2504i(46777);
        boolean adL = C14241r.cPI().cQo().adL();
        AppMethodBeat.m2505o(46777);
        return adL;
    }

    private static boolean cPA() {
        AppMethodBeat.m2504i(46778);
        boolean cQb = C14241r.cPI().cQo().cQb();
        AppMethodBeat.m2505o(46778);
        return cQb;
    }

    public static boolean cPB() {
        AppMethodBeat.m2504i(46779);
        boolean cQc = C14241r.cPI().cQo().cQc();
        AppMethodBeat.m2505o(46779);
        return cQc;
    }

    /* renamed from: et */
    private static synchronized List<C22593a> m34293et(Context context) {
        LinkedList linkedList;
        synchronized (C22594k.class) {
            AppMethodBeat.m2504i(46780);
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i = VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        int i2;
                        C22593a c22593a = new C22593a();
                        c22593a.iBz = telephonyManager.getNetworkType();
                        int mnc;
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            mnc = cellIdentity.getMnc();
                            c22593a.ori = cellIdentity.getCid();
                            c22593a.org = cellIdentity.getMcc();
                            c22593a.orh = cellIdentity.getMnc();
                            c22593a.tzp = cellIdentity.getLac();
                            c22593a.tzt = cellSignalStrength.getDbm();
                            c22593a.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (VERSION.SDK_INT >= 24) {
                                c22593a.tzw = cellIdentity.getArfcn();
                            }
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity2.getSystemId();
                            c22593a.ori = cellIdentity2.getBasestationId();
                            c22593a.orh = cellIdentity2.getSystemId();
                            c22593a.tzp = cellIdentity2.getNetworkId();
                            c22593a.tzt = cellSignalStrength2.getDbm();
                            c22593a.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            mnc = cellIdentity3.getMnc();
                            c22593a.ori = cellIdentity3.getCi();
                            c22593a.org = cellIdentity3.getMcc();
                            c22593a.orh = cellIdentity3.getMnc();
                            c22593a.tzq = cellIdentity3.getTac();
                            c22593a.tzt = cellSignalStrength3.getDbm();
                            c22593a.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (VERSION.SDK_INT >= 24) {
                                c22593a.tzu = cellIdentity3.getEarfcn();
                            }
                            i2 = mnc;
                        } else if (i < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            C4990ab.m7416i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity4.getMnc();
                            c22593a.ori = cellIdentity4.getCid();
                            c22593a.org = cellIdentity4.getMcc();
                            c22593a.orh = cellIdentity4.getMnc();
                            c22593a.tzp = cellIdentity4.getLac();
                            c22593a.tzt = cellSignalStrength4.getDbm();
                            c22593a.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (VERSION.SDK_INT >= 24) {
                                c22593a.tzv = cellIdentity4.getUarfcn();
                            }
                            i2 = mnc;
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(c22593a);
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", e);
            }
            AppMethodBeat.m2505o(46780);
        }
        return linkedList;
    }
}
