package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
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
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public final class k {
    private static b tzk;
    private static k tzl;
    private static aw tzm = null;
    private static long tzn = 0;
    public JSONArray tzo;

    public static class a {
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

    static class b implements com.tencent.mm.modelgeo.b.a {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            return z;
        }
    }

    private k() {
        AppMethodBeat.i(46766);
        g.RQ();
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, (Object) "");
        ab.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
        if (!bo.isNullOrNil(str)) {
            try {
                this.tzo = new JSONArray(str);
                AppMethodBeat.o(46766);
                return;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                ab.e("MicroMsg.GpsReportHelper", "parse lbs config error", e);
            }
        }
        AppMethodBeat.o(46766);
    }

    public static k cPt() {
        AppMethodBeat.i(46767);
        if (tzl == null) {
            tzl = new k();
        }
        k kVar = tzl;
        AppMethodBeat.o(46767);
        return kVar;
    }

    private static String cPu() {
        AppMethodBeat.i(46768);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Context context = ah.getContext();
            String str2;
            if (context == null) {
                str2 = "";
                AppMethodBeat.o(46768);
                return str2;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            wifiManager.getConnectionInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            int i = 0;
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                stringBuffer.append(String.format(str, new Object[]{Integer.valueOf(i), kX(scanResult.SSID), Integer.valueOf(i), kX(scanResult.BSSID), Integer.valueOf(i), Integer.valueOf(scanResult.level)}));
                int i2 = i + 1;
                if (i2 >= 5) {
                    break;
                }
                i = i2;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", Long.valueOf(currentTimeMillis2));
            str2 = stringBuffer.toString();
            AppMethodBeat.o(46768);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
    }

    private static String cPv() {
        AppMethodBeat.i(46769);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        String stringBuilder;
        if (cPB()) {
            hashMap.put("is_ci_permitted", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hashMap.put("net_type", at.gB(ah.getContext()));
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", Long.valueOf(currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (cPw()) {
                hashMap.put("is_ci_permitted", "1");
                hashMap.put("uuid", UUID.randomUUID().toString());
                hashMap.put("sample_time", (System.currentTimeMillis() / 1000));
                hashMap.put("phone_brand", Build.BRAND);
                hashMap.put("phone_model", Build.MODEL);
                try {
                    if (ah.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            hashMap.put("net_subtype", activeNetworkInfo.getSubtype());
                        }
                    }
                } catch (Exception e) {
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", Long.valueOf(currentTimeMillis));
                currentTimeMillis = System.currentTimeMillis();
                List et = et(ah.getContext());
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", Long.valueOf(currentTimeMillis));
                currentTimeMillis2 = System.currentTimeMillis();
                int size = et.size();
                for (int i = 0; i < size; i++) {
                    a aVar = (a) et.get(i);
                    if (aVar != null) {
                        hashMap.put("mcc_".concat(String.valueOf(i)), aVar.org);
                        hashMap.put("mnc_".concat(String.valueOf(i)), aVar.orh);
                        hashMap.put("lac_".concat(String.valueOf(i)), aVar.tzp);
                        hashMap.put("cell_id_".concat(String.valueOf(i)), aVar.ori);
                        hashMap.put("type_".concat(String.valueOf(i)), aVar.type);
                        hashMap.put("sid_".concat(String.valueOf(i)), aVar.tzr);
                        hashMap.put("net_id_".concat(String.valueOf(i)), aVar.tzs);
                        hashMap.put("sys_id_".concat(String.valueOf(i)), aVar.systemId);
                        hashMap.put("dbm_".concat(String.valueOf(i)), aVar.tzt);
                        hashMap.put("tac_".concat(String.valueOf(i)), aVar.tzq);
                        hashMap.put("arfcn_".concat(String.valueOf(i)), aVar.tzw);
                        hashMap.put("earfcn_".concat(String.valueOf(i)), aVar.tzu);
                        hashMap.put("uarfcn_".concat(String.valueOf(i)), aVar.tzv);
                        hashMap.put("dbm_".concat(String.valueOf(i)), aVar.tzt);
                    }
                }
                hashMap.put("count", String.valueOf(size));
            }
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (String stringBuilder3 : hashMap.keySet()) {
                if (!bo.isNullOrNil((String) hashMap.get(stringBuilder3))) {
                    stringBuilder2.append(String.format("&%s=%s", new Object[]{(String) r7.next(), kX((String) hashMap.get(stringBuilder3))}));
                }
            }
            stringBuilder3 = stringBuilder2.toString();
            if (!bo.isNullOrNil(stringBuilder3) && stringBuilder3.indexOf("&") == 0) {
                stringBuilder3 = stringBuilder3.substring(1);
            }
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", Long.valueOf(currentTimeMillis2));
            AppMethodBeat.o(46769);
            return stringBuilder3;
        }
        stringBuilder3 = "";
        AppMethodBeat.o(46769);
        return stringBuilder3;
    }

    private static boolean cPw() {
        AppMethodBeat.i(46770);
        if (VERSION.SDK_INT >= 23 || "MNC".equals(VERSION.CODENAME)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    AppMethodBeat.o(46770);
                    return true;
                }
                AppMethodBeat.o(46770);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", e);
                AppMethodBeat.o(46770);
                return true;
            }
        }
        AppMethodBeat.o(46770);
        return true;
    }

    private static String kX(String str) {
        AppMethodBeat.i(46771);
        try {
            str = q.encode(str, "UTF-8");
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
        }
        AppMethodBeat.o(46771);
        return str;
    }

    private static void gM(String str, String str2) {
        AppMethodBeat.i(46772);
        if (tzm == null) {
            tzm = new aw();
        }
        ab.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", str, str2);
        byte[] bArr = new byte[16];
        byte[] bytes = w.dNR().getBytes();
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
        aw awVar = tzm;
        if (o.tzz == null) {
            o.tzz = new o();
        }
        awVar.vCI = o.tzz.bw(bytes);
        ab.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", tzm.vCI);
        if (!bo.isNullOrNil(str)) {
            bytes = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
            tzm.vCH = new String(bytes);
            ab.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new String(bytes));
        }
        if (!bo.isNullOrNil(str2)) {
            bytes = Base64.encode(AesEcb.aesCryptEcb(str2.getBytes(), bArr, true, true), 0);
            tzm.vCJ = new String(bytes);
            ab.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new String(bytes));
        }
        AppMethodBeat.o(46772);
    }

    public static void Hp(int i) {
        AppMethodBeat.i(46773);
        ab.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(i)));
        tzn = System.currentTimeMillis() / 1000;
        if (!cPz()) {
            tzk = null;
            cPx();
            tzn = System.currentTimeMillis() / 1000;
        }
        AppMethodBeat.o(46773);
    }

    private static void cPx() {
        AppMethodBeat.i(46774);
        long currentTimeMillis = System.currentTimeMillis();
        if (cPz()) {
            AppMethodBeat.o(46774);
            return;
        }
        if (cPA() || cPB()) {
            String str;
            String str2 = "";
            try {
                str = ((WifiManager) ah.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getRssi();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                str = str2;
            }
            str2 = at.gE(ah.getContext());
            String str3 = System.currentTimeMillis();
            String gF = at.gF(ah.getContext());
            String gG = at.gG(ah.getContext());
            str = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", new Object[]{kX(str2), kX(gF), kX(gG), str, str3});
            str2 = str + cPu();
            if (cPB()) {
                str = cPv();
            } else {
                str = null;
            }
            gM(str2, str);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ab.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", Long.valueOf(currentTimeMillis2));
        AppMethodBeat.o(46774);
    }

    public static aw cPy() {
        AppMethodBeat.i(46775);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - tzn > 300) {
            cPx();
            tzn = currentTimeMillis;
        }
        aw awVar = tzm;
        AppMethodBeat.o(46775);
        return awVar;
    }

    public static biv bQO() {
        AppMethodBeat.i(46776);
        if (tzm == null) {
            AppMethodBeat.o(46776);
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
        AppMethodBeat.o(46776);
        return biv;
    }

    private static boolean cPz() {
        AppMethodBeat.i(46777);
        boolean adL = r.cPI().cQo().adL();
        AppMethodBeat.o(46777);
        return adL;
    }

    private static boolean cPA() {
        AppMethodBeat.i(46778);
        boolean cQb = r.cPI().cQo().cQb();
        AppMethodBeat.o(46778);
        return cQb;
    }

    public static boolean cPB() {
        AppMethodBeat.i(46779);
        boolean cQc = r.cPI().cQo().cQc();
        AppMethodBeat.o(46779);
        return cQc;
    }

    private static synchronized List<a> et(Context context) {
        LinkedList linkedList;
        synchronized (k.class) {
            AppMethodBeat.i(46780);
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i = VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        int i2;
                        a aVar = new a();
                        aVar.iBz = telephonyManager.getNetworkType();
                        int mnc;
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            mnc = cellIdentity.getMnc();
                            aVar.ori = cellIdentity.getCid();
                            aVar.org = cellIdentity.getMcc();
                            aVar.orh = cellIdentity.getMnc();
                            aVar.tzp = cellIdentity.getLac();
                            aVar.tzt = cellSignalStrength.getDbm();
                            aVar.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (VERSION.SDK_INT >= 24) {
                                aVar.tzw = cellIdentity.getArfcn();
                            }
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity2.getSystemId();
                            aVar.ori = cellIdentity2.getBasestationId();
                            aVar.orh = cellIdentity2.getSystemId();
                            aVar.tzp = cellIdentity2.getNetworkId();
                            aVar.tzt = cellSignalStrength2.getDbm();
                            aVar.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            mnc = cellIdentity3.getMnc();
                            aVar.ori = cellIdentity3.getCi();
                            aVar.org = cellIdentity3.getMcc();
                            aVar.orh = cellIdentity3.getMnc();
                            aVar.tzq = cellIdentity3.getTac();
                            aVar.tzt = cellSignalStrength3.getDbm();
                            aVar.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (VERSION.SDK_INT >= 24) {
                                aVar.tzu = cellIdentity3.getEarfcn();
                            }
                            i2 = mnc;
                        } else if (i < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            ab.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            mnc = cellIdentity4.getMnc();
                            aVar.ori = cellIdentity4.getCid();
                            aVar.org = cellIdentity4.getMcc();
                            aVar.orh = cellIdentity4.getMnc();
                            aVar.tzp = cellIdentity4.getLac();
                            aVar.tzt = cellSignalStrength4.getDbm();
                            aVar.tzx = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (VERSION.SDK_INT >= 24) {
                                aVar.tzv = cellIdentity4.getUarfcn();
                            }
                            i2 = mnc;
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", e);
            }
            AppMethodBeat.o(46780);
        }
        return linkedList;
    }
}
