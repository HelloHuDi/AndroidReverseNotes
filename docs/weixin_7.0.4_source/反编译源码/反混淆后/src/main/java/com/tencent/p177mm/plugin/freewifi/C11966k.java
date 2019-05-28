package com.tencent.p177mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p1401f.C34187b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.freewifi.k */
public final class C11966k {
    public static Map<String, String> mua = new C119691();
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

    /* renamed from: com.tencent.mm.plugin.freewifi.k$a */
    public static class C11967a {
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

        /* synthetic */ C11967a(byte b) {
            this();
        }

        private C11967a() {
        }

        public final C11966k byq() {
            AppMethodBeat.m2504i(20607);
            C11966k c11966k = new C11966k();
            c11966k.ssid = this.ssid;
            c11966k.bssid = this.bssid;
            c11966k.cuI = this.cuI;
            c11966k.cuH = this.cuH;
            c11966k.mub = this.mub;
            c11966k.muc = this.muc;
            c11966k.mud = this.mud;
            c11966k.kBq = this.kBq;
            c11966k.mue = this.mue;
            c11966k.muf = (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.mue)}) + String.format("%03d", new Object[]{Long.valueOf(this.muf)})).intValue();
            c11966k.mug = this.mug;
            c11966k.result = this.result;
            c11966k.cIb = this.cIb;
            c11966k.muh = this.muh;
            c11966k.mui = this.mui;
            c11966k.ehr = this.ehr;
            AppMethodBeat.m2505o(20607);
            return c11966k;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.k$b */
    public enum C11968b {
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
            AppMethodBeat.m2505o(20611);
        }

        private C11968b(long j, String str, String str2) {
            AppMethodBeat.m2504i(20610);
            if (j > 999 || j < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("code must be between 0 and 999");
                AppMethodBeat.m2505o(20610);
                throw illegalArgumentException;
            }
            this.muQ = j;
            this.name = str;
            this.muR = str2;
            AppMethodBeat.m2505o(20610);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.k$1 */
    static class C119691 extends HashMap<String, String> {
        C119691() {
            AppMethodBeat.m2504i(20605);
            for (C11968b c11968b : C11968b.values()) {
                put(c11968b.name, c11968b.muR);
            }
            AppMethodBeat.m2505o(20605);
        }
    }

    /* synthetic */ C11966k(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(20616);
        AppMethodBeat.m2505o(20616);
    }

    /* renamed from: Mu */
    public static String m19854Mu(String str) {
        AppMethodBeat.m2504i(20612);
        String Mw = C34189m.m56058Mw((String) mua.get(str));
        AppMethodBeat.m2505o(20612);
        return Mw;
    }

    private C11966k() {
    }

    public static C11967a byo() {
        AppMethodBeat.m2504i(20613);
        C11967a c11967a = new C11967a();
        AppMethodBeat.m2505o(20613);
        return c11967a;
    }

    public final C11966k byp() {
        AppMethodBeat.m2504i(20614);
        C7060h.pYm.mo8381e(12804, C34189m.m56058Mw(this.ssid), C34189m.m56058Mw(this.bssid), C34189m.m56058Mw(this.cuI), C34189m.m56058Mw(this.cuH), Integer.valueOf(this.mub), C34189m.m56058Mw(this.muc), C34189m.m56058Mw(this.mud), C34189m.m56058Mw(this.kBq), Integer.valueOf(this.mue), Long.valueOf(this.muf), C34189m.m56058Mw(this.mug), Integer.valueOf(this.result), Integer.valueOf(this.cIb), C34189m.m56058Mw(this.muh), Long.valueOf(this.mui), C34189m.m56058Mw(this.ehr));
        AppMethodBeat.m2505o(20614);
        return this;
    }

    /* renamed from: b */
    public final C11966k mo23810b(Intent intent, boolean z) {
        AppMethodBeat.m2504i(20615);
        try {
            final int X = C34189m.m56065X(intent);
            if (X != 31) {
                AppMethodBeat.m2505o(20615);
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
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + C34189m.m56078h(e));
            }
            String jSONObject2 = jSONObject.toString();
            String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
            if (C34189m.isEmpty(stringExtra)) {
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
            } else {
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
            final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
            if (z) {
                C11976j.bza().byI().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(20606);
                        C11976j.byY().mo62012a(stringExtra2, X, stringExtra3, currentTimeMillis);
                        if (C34189m.byu()) {
                            C34187b.m56054kT(1);
                        }
                        AppMethodBeat.m2505o(20606);
                    }
                });
            }
            AppMethodBeat.m2505o(20615);
            return this;
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + C34189m.m56078h(e2));
        }
    }
}
