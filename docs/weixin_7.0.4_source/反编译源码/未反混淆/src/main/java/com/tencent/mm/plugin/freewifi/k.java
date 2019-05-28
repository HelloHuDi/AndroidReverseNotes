package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> mua = new HashMap<String, String>() {
        {
            AppMethodBeat.i(20605);
            for (b bVar : b.values()) {
                put(bVar.name, bVar.muR);
            }
            AppMethodBeat.o(20605);
        }
    };
    private String bssid;
    private int cIb;
    private String cuH;
    private String cuI;
    private String ehr;
    private String kBq;
    private int mub;
    private String muc;
    private String mud;
    private int mue;
    private long muf;
    private String mug;
    private String muh;
    private long mui;
    private int result;
    private String ssid;

    public static class a {
        public String bssid;
        public int cIb;
        public String cuH;
        public String cuI;
        public String ehr;
        public String kBq;
        private int mub;
        public String muc;
        public String mud;
        public int mue;
        public long muf;
        public String mug;
        public String muh;
        private long mui;
        public int result;
        public String ssid;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
        }

        public final k byq() {
            AppMethodBeat.i(20607);
            k kVar = new k();
            kVar.ssid = this.ssid;
            kVar.bssid = this.bssid;
            kVar.cuI = this.cuI;
            kVar.cuH = this.cuH;
            kVar.mub = this.mub;
            kVar.muc = this.muc;
            kVar.mud = this.mud;
            kVar.kBq = this.kBq;
            kVar.mue = this.mue;
            kVar.muf = (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.mue)}) + String.format("%03d", new Object[]{Long.valueOf(this.muf)})).intValue();
            kVar.mug = this.mug;
            kVar.result = this.result;
            kVar.cIb = this.cIb;
            kVar.muh = this.muh;
            kVar.mui = this.mui;
            kVar.ehr = this.ehr;
            AppMethodBeat.o(20607);
            return kVar;
        }
    }

    public enum b {
        GetFrontPage(10, "getFrontPage", "a"),
        GetFrontPageReturn(11, "getFrontpageReturn", "ar"),
        GetFrontPageReturnDataCheck(12, "getFrontPageReturnDataCheck", "ard"),
        AddNetwork(20, "addNetwork", "n"),
        GetBackPage(30, "getBackPage", "b"),
        GetBackPageReturn(31, "getBackPageReturn", "br"),
        GetBackPage33(32, "getBackPage33", "b33"),
        GetBackPage33Return(33, "getBackPage33Return", "b33r"),
        BackpageFinished(40, "backpageFinished", "bf"),
        QinghuaiBackpageFinished(50, "qinghuaiBackpageFinished", "qbf"),
        ScanNearFieldWifiAndReport(110, "scanNearFieldWifiAndReport", "sc"),
        GetThreeOneLock(290, "getThreeOneLock", "31lk"),
        GetPortalApInfo(300, "getPortalApInfo", "o"),
        GetPortalApInfoReturn(301, "getPortalApInfoReturn", "or"),
        GetPortalApInfoReturnDataCheck(302, "getPortalApInfoReturnDataCheck", "ord"),
        FrontPageUIClosed(303, "frontPageUIClosed", "af"),
        FrontPageUIClosedByGoBack(311, "frontPageUIClosedByGoBack", "afg"),
        FrontPageUIClosedByGoSuc(312, "frontPageUIClosedByGoSuc", "afs"),
        FrontPageUIClosedByGoContactInfoUI(313, "frontPageUIClosedByGoContactInfoUI", "afc"),
        ThreeOneAuth(305, "threeOneAuth", "31a"),
        ThreeTwoAuth(306, "threeTwoAuth", "32a"),
        ThreeTwoBlack(307, "threeTwoAuthBlack", "32ab"),
        ThreeThreeAuth(308, "threeThreeAuth", "33a"),
        GetPcFrontPage(210, "getPcFrontPage", "pca"),
        GetPcFrontPageReturn(211, "getPcFrontPageReturn", "pcar"),
        SetPcLoginUserInfo(212, "setPcLoginUserInfo", "pcset"),
        SetPcLoginUserInfoReturn(212, "setPcLoginUserInfoReturn", "pcsetr"),
        ManufacturerConnectLoading(500, "manufacturerConnectLoading", "mld"),
        CopyPwdPageUIClosedByGoBack(600, "CopyPwdPageUIClosedByGoBack", "cpg");
        
        public long muQ;
        String muR;
        public String name;

        static {
            AppMethodBeat.o(20611);
        }

        private b(long j, String str, String str2) {
            AppMethodBeat.i(20610);
            if (j > 999 || j < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("code must be between 0 and 999");
                AppMethodBeat.o(20610);
                throw illegalArgumentException;
            }
            this.muQ = j;
            this.name = str;
            this.muR = str2;
            AppMethodBeat.o(20610);
        }
    }

    /* synthetic */ k(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(20616);
        AppMethodBeat.o(20616);
    }

    public static String Mu(String str) {
        AppMethodBeat.i(20612);
        String Mw = m.Mw((String) mua.get(str));
        AppMethodBeat.o(20612);
        return Mw;
    }

    private k() {
    }

    public static a byo() {
        AppMethodBeat.i(20613);
        a aVar = new a();
        AppMethodBeat.o(20613);
        return aVar;
    }

    public final k byp() {
        AppMethodBeat.i(20614);
        h.pYm.e(12804, m.Mw(this.ssid), m.Mw(this.bssid), m.Mw(this.cuI), m.Mw(this.cuH), Integer.valueOf(this.mub), m.Mw(this.muc), m.Mw(this.mud), m.Mw(this.kBq), Integer.valueOf(this.mue), Long.valueOf(this.muf), m.Mw(this.mug), Integer.valueOf(this.result), Integer.valueOf(this.cIb), m.Mw(this.muh), Long.valueOf(this.mui), m.Mw(this.ehr));
        AppMethodBeat.o(20614);
        return this;
    }

    public final k b(Intent intent, boolean z) {
        AppMethodBeat.i(20615);
        try {
            final int X = m.X(intent);
            if (X != 31) {
                AppMethodBeat.o(20615);
                return this;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ssid", this.ssid);
                jSONObject.put("bssid", this.bssid);
                jSONObject.put("clientMac", this.cuI);
                jSONObject.put("apKey", this.cuH);
                jSONObject.put("qrtype", this.mub);
                jSONObject.put("mpShopId", this.muc);
                jSONObject.put("mpAppId", this.mud);
                jSONObject.put("sessionKey", this.kBq);
                jSONObject.put("protocolType", this.mue);
                jSONObject.put("stageCode", this.muf);
                jSONObject.put("stageName", this.mug);
                jSONObject.put("result", this.result);
                jSONObject.put("channel", this.cIb);
                jSONObject.put("mpUserName", this.muh);
                jSONObject.put("timeCost", this.mui);
                jSONObject.put("resultMsg", this.ehr);
                jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
            } catch (JSONException e) {
                ab.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.h(e));
            }
            String jSONObject2 = jSONObject.toString();
            String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
            if (m.isEmpty(stringExtra)) {
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
            } else {
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
            final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
            if (z) {
                j.bza().byI().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20606);
                        j.byY().a(stringExtra2, X, stringExtra3, currentTimeMillis);
                        if (m.byu()) {
                            com.tencent.mm.plugin.freewifi.f.b.kT(1);
                        }
                        AppMethodBeat.o(20606);
                    }
                });
            }
            AppMethodBeat.o(20615);
            return this;
        } catch (Exception e2) {
            ab.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.h(e2));
        }
    }
}
