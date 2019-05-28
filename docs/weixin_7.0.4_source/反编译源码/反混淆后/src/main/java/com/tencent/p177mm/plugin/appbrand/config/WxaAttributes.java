package com.tencent.p177mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26313fw;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes */
public final class WxaAttributes extends C26313fw {
    public static final C4924a gSs;
    private C10172a hhM;
    private C2111d hhN;
    private C31283e hhO;
    private List<WxaEntryInfo> hhP = null;
    private C26832b hhQ;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$d */
    public static final class C2111d {
        public C2112a hib = new C2112a();
        public List<Pair<String, String>> hic;

        /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$d$a */
        public static final class C2112a {
            public int bQA;
            public boolean bQB;
            public boolean bQC;
            public boolean bQK;
            public int bQM;
            public int bQv;
            public int bQw;
            public int bQx;
            public int bQy;
            public int bQz;
            public boolean hbV;
            public boolean hbW;
            public int hbX;
            public int hgX;
            public boolean hgY;
            public int hhb;
            public int hhc;
            public int hid;
            public int hie;
            public int hif;
            public int hig;
        }

        public C2111d() {
            AppMethodBeat.m2504i(96161);
            AppMethodBeat.m2505o(96161);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$a */
    public static final class C10172a {
        public int fmr;
        public long haQ = 0;
        public long haR = 0;
        public int hgD;
        public String hgE;
        public String hhR;
        public int hhS;
        public List<String> hhT;
        public List<String> hhU;
        public List<String> hhV;
        public List<String> hhW;
        public List<String> hhX;
        public String hhY;

        /* renamed from: xy */
        public final boolean mo21563xy() {
            return this.fmr == 4;
        }

        /* renamed from: zx */
        public static C10172a m17796zx(String str) {
            AppMethodBeat.m2504i(96159);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
                AppMethodBeat.m2505o(96159);
                return null;
            }
            C10172a c10172a;
            try {
                JSONObject jSONObject = new JSONObject(str);
                c10172a = new C10172a();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    c10172a.haQ = optJSONObject.optLong("RunningFlag");
                    c10172a.hhR = optJSONObject.optString("AppOpenForbiddenUrl");
                    c10172a.haR = optJSONObject.optLong("CanNotStarWxaBeforeTime", 0);
                }
                optJSONObject = jSONObject.optJSONObject("Network");
                if (optJSONObject != null) {
                    c10172a.hhT = C38171t.m64608l(optJSONObject.optJSONArray("RequestDomain"));
                    c10172a.hhU = C38171t.m64608l(optJSONObject.optJSONArray("WsRequestDomain"));
                    c10172a.hhV = C38171t.m64608l(optJSONObject.optJSONArray("UploadDomain"));
                    c10172a.hhW = C38171t.m64608l(optJSONObject.optJSONArray("DownloadDomain"));
                    c10172a.hhX = C38171t.m64608l(optJSONObject.optJSONArray("UDPDomain"));
                }
                c10172a.hhS = jSONObject.optInt("WechatPluginApp", 0);
                c10172a.fmr = jSONObject.optInt("AppServiceType", 0);
                c10172a.hhY = jSONObject.optString("fromBusinessUsername");
                c10172a.hgD = jSONObject.optInt("OriginalFlag", 0);
                c10172a.hgE = jSONObject.optString("OriginalRedirectUrl");
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", str, e);
                c10172a = null;
            }
            AppMethodBeat.m2505o(96159);
            return c10172a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$c */
    public static class C10173c {
        public String bIy;
        public String cvZ;
        public String path;
        public int version;

        /* renamed from: zy */
        public static List<C10173c> m17798zy(String str) {
            AppMethodBeat.m2504i(96160);
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    AppMethodBeat.m2505o(96160);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        C10173c c10173c = new C10173c();
                        c10173c.bIy = jSONObject.optString("provider");
                        c10173c.version = jSONObject.optInt("version");
                        c10173c.path = jSONObject.optString("path");
                        c10173c.cvZ = jSONObject.optString("md5");
                        linkedList.add(c10173c);
                    }
                }
                AppMethodBeat.m2505o(96160);
                return linkedList;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.AppBrand.WxaAttributes.WxaCodeLibInfo", "parse json array, e = %s", e);
                AppMethodBeat.m2505o(96160);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$b */
    public static final class C26832b {
        public int fvv;
        public List<C26833a> hhZ;
        public int type;

        /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$b$a */
        public static final class C26833a {
            public String csu;
            public List<C26833a> hia;
            public String name;
            public int type;
            public String userName;
            public int version;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$e */
    public static final class C31283e {
        public int axy;
        public String bQk;
        public int bQl;
        public String hii;
        public String hij;
        public JSONObject hik;
        public List<C10173c> hil;
        public int him;
        public List<C31284f> hin;
        public boolean hio;
        public String hip;
        public String hiq;

        /* renamed from: zz */
        public static C31283e m50507zz(String str) {
            AppMethodBeat.m2504i(96166);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(96166);
                return null;
            }
            C31283e c31283e;
            try {
                JSONObject jSONObject = new JSONObject(str);
                c31283e = new C31283e();
                c31283e.axy = jSONObject.optInt("AppVersion", 0);
                c31283e.bQl = jSONObject.optInt("VersionState", -1);
                c31283e.hii = jSONObject.optString("VersionMD5");
                c31283e.hij = jSONObject.optString("device_orientation");
                c31283e.bQk = jSONObject.optString("client_js_ext_info");
                c31283e.him = jSONObject.optInt("code_size");
                c31283e.hik = jSONObject.optJSONObject("loading_image_info");
                c31283e.hin = C31284f.m50509zA(jSONObject.optString("module_list"));
                c31283e.hil = C10173c.m17798zy(jSONObject.optString("wxacode_lib_info_list"));
                c31283e.hio = jSONObject.optBoolean("UseModule", false);
                c31283e.hip = jSONObject.optString("EntranceModule");
                c31283e.hiq = jSONObject.optString("without_lib_md5");
            } catch (Exception e) {
                c31283e = null;
            }
            AppMethodBeat.m2505o(96166);
            return c31283e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$f */
    public static class C31284f {
        public boolean cta;
        public String cvZ;
        public String[] gSQ;
        public List<C10173c> hir;
        public String hit;
        public String name;
        public int size;

        /* renamed from: zA */
        public static List<C31284f> m50509zA(String str) {
            AppMethodBeat.m2504i(96167);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(96167);
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    AppMethodBeat.m2505o(96167);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        C31284f c31284f = new C31284f();
                        c31284f.name = jSONObject.getString("name");
                        c31284f.cvZ = jSONObject.getString("md5");
                        c31284f.size = jSONObject.optInt("size", 0);
                        c31284f.cta = jSONObject.optBoolean("independent", false);
                        c31284f.gSQ = C31284f.m50508n(jSONObject);
                        c31284f.hir = C10173c.m17798zy(jSONObject.optString("wxacode_lib_info_list"));
                        c31284f.hit = jSONObject.optString("without_lib_md5");
                        linkedList.add(c31284f);
                    }
                }
                AppMethodBeat.m2505o(96167);
                return linkedList;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", e);
                AppMethodBeat.m2505o(96167);
                return null;
            }
        }

        /* renamed from: n */
        private static String[] m50508n(JSONObject jSONObject) {
            int i = 0;
            AppMethodBeat.m2504i(96168);
            JSONArray optJSONArray = jSONObject.optJSONArray("alias");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                String[] strArr = new String[0];
                AppMethodBeat.m2505o(96168);
                return strArr;
            }
            String[] strArr2 = new String[optJSONArray.length()];
            while (i < optJSONArray.length()) {
                strArr2[i] = optJSONArray.optString(i);
                i++;
            }
            AppMethodBeat.m2505o(96168);
            return strArr2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo */
    public static final class WxaEntryInfo implements Parcelable {
        public static final Creator<WxaEntryInfo> CREATOR = new C312851();
        public String hih;
        public String iconUrl;
        public String title;
        public String username;

        /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo$1 */
        static class C312851 implements Creator<WxaEntryInfo> {
            C312851() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaEntryInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(96162);
                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo(parcel);
                AppMethodBeat.m2505o(96162);
                return wxaEntryInfo;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(96163);
            parcel.writeString(this.username);
            parcel.writeString(this.title);
            parcel.writeString(this.hih);
            parcel.writeString(this.iconUrl);
            AppMethodBeat.m2505o(96163);
        }

        protected WxaEntryInfo(Parcel parcel) {
            AppMethodBeat.m2504i(96164);
            this.username = parcel.readString();
            this.title = parcel.readString();
            this.hih = parcel.readString();
            this.iconUrl = parcel.readString();
            AppMethodBeat.m2505o(96164);
        }

        static {
            AppMethodBeat.m2504i(96165);
            AppMethodBeat.m2505o(96165);
        }
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(96169);
        super.mo8995d(cursor);
        this.hhM = null;
        this.hhN = null;
        this.hhO = null;
        this.hhP = null;
        this.hhQ = null;
        AppMethodBeat.m2505o(96169);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return gSs;
    }

    public final C10172a ayJ() {
        AppMethodBeat.m2504i(96170);
        if (this.hhM == null) {
            this.hhM = C10172a.m17796zx(this.field_appInfo);
        }
        C10172a c10172a = this.hhM;
        AppMethodBeat.m2505o(96170);
        return c10172a;
    }

    public final C2111d ayK() {
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(96171);
        if (this.hhN == null) {
            JSONObject jSONObject;
            boolean z2;
            try {
                jSONObject = new JSONObject(this.field_dynamicInfo);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.hhN = new C2111d();
            JSONObject optJSONObject = jSONObject.optJSONObject("NewSetting");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.hhN.hib.bQM = optJSONObject.optInt("MaxLocalstorageSize", 5);
            this.hhN.hib.hid = optJSONObject.optInt("OpendataMaxLocalstorageSize", 5);
            this.hhN.hib.hie = optJSONObject.optInt("MaxCodeSize", 5);
            this.hhN.hib.hgX = optJSONObject.optInt("ExpendedMaxWebviewDepth", 5);
            this.hhN.hib.bQv = optJSONObject.optInt("MaxBackgroundLifespan", 600);
            this.hhN.hib.bQw = optJSONObject.optInt("MaxRequestConcurrent", 5);
            this.hhN.hib.bQx = optJSONObject.optInt("MaxUploadConcurrent", 5);
            this.hhN.hib.bQy = optJSONObject.optInt("MaxDownloadConcurrent", 5);
            this.hhN.hib.bQz = optJSONObject.optInt("MaxWebsocketConnect", 2);
            this.hhN.hib.bQA = optJSONObject.optInt("MaxWorkerConcurrent", 1);
            this.hhN.hib.bQB = optJSONObject.optInt("WebsocketSkipPortCheck", 0) != 0;
            C2112a c2112a = this.hhN.hib;
            if (optJSONObject.optInt("TLSSkipHostnameCheck", 0) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c2112a.bQC = z2;
            this.hhN.hib.hif = optJSONObject.optInt("MaxFileStorageSize", 10);
            this.hhN.hib.hig = optJSONObject.optInt("BackgroundNetworkInterruptedTimeout", 5);
            c2112a = this.hhN.hib;
            if (optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c2112a.hgY = z2;
            this.hhN.hib.hhb = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.hhN.hib.hhc = optJSONObject.optInt("LifeSpanAfterSuspend", 300);
            c2112a = this.hhN.hib;
            if (optJSONObject.optInt("ScanCodeEnableZZM", 0) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c2112a.bQK = z2;
            c2112a = this.hhN.hib;
            if (optJSONObject.optInt("CanPreFetchData", 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c2112a.hbV = z2;
            C2112a c2112a2 = this.hhN.hib;
            if (optJSONObject.optInt("CanPeriodFetchData", 0) <= 0) {
                z = false;
            }
            c2112a2.hbW = z;
            this.hhN.hib.hbX = optJSONObject.optInt("PeriodFetchData", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("NewCategories");
            if (optJSONArray != null) {
                this.hhN.hic = new LinkedList();
                while (i < optJSONArray.length()) {
                    optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.hhN.hic.add(new Pair(optJSONObject.optString("first"), optJSONObject.optString("second")));
                    }
                    i++;
                }
            }
        }
        C2111d c2111d = this.hhN;
        AppMethodBeat.m2505o(96171);
        return c2111d;
    }

    public final C31283e ayL() {
        AppMethodBeat.m2504i(96172);
        C31283e c31283e;
        if (this.hhO != null || C5046bo.isNullOrNil(this.field_versionInfo)) {
            c31283e = this.hhO;
            AppMethodBeat.m2505o(96172);
            return c31283e;
        }
        c31283e = C31283e.m50507zz(this.field_versionInfo);
        this.hhO = c31283e;
        AppMethodBeat.m2505o(96172);
        return c31283e;
    }

    public final List<WxaEntryInfo> ayM() {
        AppMethodBeat.m2504i(96173);
        if (this.hhP == null && !C5046bo.isNullOrNil(this.field_bindWxaInfo)) {
            try {
                JSONArray optJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
                if (optJSONArray != null) {
                    this.hhP = new LinkedList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("username");
                            if (!C5046bo.isNullOrNil(optString)) {
                                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                wxaEntryInfo.username = optString;
                                wxaEntryInfo.title = optJSONObject.optString("title");
                                wxaEntryInfo.iconUrl = optJSONObject.optString("icon_url");
                                this.hhP.add(wxaEntryInfo);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                this.hhP = null;
            }
        }
        List list = this.hhP;
        AppMethodBeat.m2505o(96173);
        return list;
    }

    public final C26832b ayN() {
        AppMethodBeat.m2504i(96174);
        if (this.hhQ == null && !C5046bo.isNullOrNil(this.field_bizMenu)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_bizMenu);
                this.hhQ = new C26832b();
                this.hhQ.fvv = jSONObject.optInt("interactive_mode", 0);
                this.hhQ.type = jSONObject.optInt("type", 0);
                this.hhQ.hhZ = m50504k(jSONObject.optJSONArray("button_list"));
            } catch (Exception e) {
                this.hhQ = null;
            }
        }
        C26832b c26832b = this.hhQ;
        AppMethodBeat.m2505o(96174);
        return c26832b;
    }

    /* renamed from: k */
    private List<C26833a> m50504k(JSONArray jSONArray) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(96175);
        if (jSONArray != null) {
            arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    C26833a c26833a = new C26833a();
                    c26833a.name = jSONObject.optString("name", "");
                    c26833a.type = jSONObject.optInt("type");
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("value", ""));
                    c26833a.userName = jSONObject2.optString("userName", "");
                    c26833a.csu = jSONObject2.optString("pagePath", "");
                    c26833a.version = jSONObject2.optInt("version");
                    c26833a.hia = m50504k(jSONObject.optJSONArray("sub_button_list"));
                    arrayList.add(c26833a);
                }
            } catch (JSONException e) {
                AppMethodBeat.m2505o(96175);
                return null;
            }
        }
        arrayList = null;
        AppMethodBeat.m2505o(96175);
        return arrayList;
    }

    public final String toString() {
        AppMethodBeat.m2504i(96176);
        String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
        AppMethodBeat.m2505o(96176);
        return str;
    }

    static {
        AppMethodBeat.m2504i(96177);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[20];
        c4924a.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "usernameHash";
        c4924a.xDd.put("usernameHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "usernameHash";
        c4924a.columns[1] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "nickname";
        c4924a.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "shortNickname";
        c4924a.xDd.put("shortNickname", "TEXT");
        stringBuilder.append(" shortNickname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "brandIconURL";
        c4924a.xDd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "roundedSquareIconURL";
        c4924a.xDd.put("roundedSquareIconURL", "TEXT");
        stringBuilder.append(" roundedSquareIconURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "bigHeadURL";
        c4924a.xDd.put("bigHeadURL", "TEXT");
        stringBuilder.append(" bigHeadURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "smallHeadURL";
        c4924a.xDd.put("smallHeadURL", "TEXT");
        stringBuilder.append(" smallHeadURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "signature";
        c4924a.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "appOpt";
        c4924a.xDd.put("appOpt", "INTEGER default '0' ");
        stringBuilder.append(" appOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "registerSource";
        c4924a.xDd.put("registerSource", "TEXT");
        stringBuilder.append(" registerSource TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "appInfo";
        c4924a.xDd.put("appInfo", "TEXT");
        stringBuilder.append(" appInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "versionInfo";
        c4924a.xDd.put("versionInfo", "TEXT");
        stringBuilder.append(" versionInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "bindWxaInfo";
        c4924a.xDd.put("bindWxaInfo", "TEXT");
        stringBuilder.append(" bindWxaInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "dynamicInfo";
        c4924a.xDd.put("dynamicInfo", "TEXT");
        stringBuilder.append(" dynamicInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "reserved";
        c4924a.xDd.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        c4924a.columns[17] = "syncTimeSecond";
        c4924a.xDd.put("syncTimeSecond", "LONG default '0' ");
        stringBuilder.append(" syncTimeSecond LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "syncVersion";
        c4924a.xDd.put("syncVersion", "TEXT");
        stringBuilder.append(" syncVersion TEXT");
        stringBuilder.append(", ");
        c4924a.columns[19] = "bizMenu";
        c4924a.xDd.put("bizMenu", "TEXT");
        stringBuilder.append(" bizMenu TEXT");
        c4924a.columns[20] = "rowid";
        c4924a.sql = stringBuilder.toString();
        gSs = c4924a;
        AppMethodBeat.m2505o(96177);
    }
}
