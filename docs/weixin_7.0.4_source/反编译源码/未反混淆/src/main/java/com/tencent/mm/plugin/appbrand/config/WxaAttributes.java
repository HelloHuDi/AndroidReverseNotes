package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes extends fw {
    public static final com.tencent.mm.sdk.e.c.a gSs;
    private a hhM;
    private d hhN;
    private e hhO;
    private List<WxaEntryInfo> hhP = null;
    private b hhQ;

    public static final class d {
        public a hib = new a();
        public List<Pair<String, String>> hic;

        public static final class a {
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

        public d() {
            AppMethodBeat.i(96161);
            AppMethodBeat.o(96161);
        }
    }

    public static final class a {
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

        public final boolean xy() {
            return this.fmr == 4;
        }

        public static a zx(String str) {
            AppMethodBeat.i(96159);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
                AppMethodBeat.o(96159);
                return null;
            }
            a aVar;
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    aVar.haQ = optJSONObject.optLong("RunningFlag");
                    aVar.hhR = optJSONObject.optString("AppOpenForbiddenUrl");
                    aVar.haR = optJSONObject.optLong("CanNotStarWxaBeforeTime", 0);
                }
                optJSONObject = jSONObject.optJSONObject("Network");
                if (optJSONObject != null) {
                    aVar.hhT = t.l(optJSONObject.optJSONArray("RequestDomain"));
                    aVar.hhU = t.l(optJSONObject.optJSONArray("WsRequestDomain"));
                    aVar.hhV = t.l(optJSONObject.optJSONArray("UploadDomain"));
                    aVar.hhW = t.l(optJSONObject.optJSONArray("DownloadDomain"));
                    aVar.hhX = t.l(optJSONObject.optJSONArray("UDPDomain"));
                }
                aVar.hhS = jSONObject.optInt("WechatPluginApp", 0);
                aVar.fmr = jSONObject.optInt("AppServiceType", 0);
                aVar.hhY = jSONObject.optString("fromBusinessUsername");
                aVar.hgD = jSONObject.optInt("OriginalFlag", 0);
                aVar.hgE = jSONObject.optString("OriginalRedirectUrl");
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", str, e);
                aVar = null;
            }
            AppMethodBeat.o(96159);
            return aVar;
        }
    }

    public static class c {
        public String bIy;
        public String cvZ;
        public String path;
        public int version;

        public static List<c> zy(String str) {
            AppMethodBeat.i(96160);
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    AppMethodBeat.o(96160);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        c cVar = new c();
                        cVar.bIy = jSONObject.optString("provider");
                        cVar.version = jSONObject.optInt("version");
                        cVar.path = jSONObject.optString("path");
                        cVar.cvZ = jSONObject.optString("md5");
                        linkedList.add(cVar);
                    }
                }
                AppMethodBeat.o(96160);
                return linkedList;
            } catch (JSONException e) {
                ab.e("MicroMsg.AppBrand.WxaAttributes.WxaCodeLibInfo", "parse json array, e = %s", e);
                AppMethodBeat.o(96160);
                return null;
            }
        }
    }

    public static final class b {
        public int fvv;
        public List<a> hhZ;
        public int type;

        public static final class a {
            public String csu;
            public List<a> hia;
            public String name;
            public int type;
            public String userName;
            public int version;
        }
    }

    public static final class e {
        public int axy;
        public String bQk;
        public int bQl;
        public String hii;
        public String hij;
        public JSONObject hik;
        public List<c> hil;
        public int him;
        public List<f> hin;
        public boolean hio;
        public String hip;
        public String hiq;

        public static e zz(String str) {
            AppMethodBeat.i(96166);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(96166);
                return null;
            }
            e eVar;
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar = new e();
                eVar.axy = jSONObject.optInt("AppVersion", 0);
                eVar.bQl = jSONObject.optInt("VersionState", -1);
                eVar.hii = jSONObject.optString("VersionMD5");
                eVar.hij = jSONObject.optString("device_orientation");
                eVar.bQk = jSONObject.optString("client_js_ext_info");
                eVar.him = jSONObject.optInt("code_size");
                eVar.hik = jSONObject.optJSONObject("loading_image_info");
                eVar.hin = f.zA(jSONObject.optString("module_list"));
                eVar.hil = c.zy(jSONObject.optString("wxacode_lib_info_list"));
                eVar.hio = jSONObject.optBoolean("UseModule", false);
                eVar.hip = jSONObject.optString("EntranceModule");
                eVar.hiq = jSONObject.optString("without_lib_md5");
            } catch (Exception e) {
                eVar = null;
            }
            AppMethodBeat.o(96166);
            return eVar;
        }
    }

    public static class f {
        public boolean cta;
        public String cvZ;
        public String[] gSQ;
        public List<c> hir;
        public String hit;
        public String name;
        public int size;

        public static List<f> zA(String str) {
            AppMethodBeat.i(96167);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(96167);
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    AppMethodBeat.o(96167);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        f fVar = new f();
                        fVar.name = jSONObject.getString("name");
                        fVar.cvZ = jSONObject.getString("md5");
                        fVar.size = jSONObject.optInt("size", 0);
                        fVar.cta = jSONObject.optBoolean("independent", false);
                        fVar.gSQ = n(jSONObject);
                        fVar.hir = c.zy(jSONObject.optString("wxacode_lib_info_list"));
                        fVar.hit = jSONObject.optString("without_lib_md5");
                        linkedList.add(fVar);
                    }
                }
                AppMethodBeat.o(96167);
                return linkedList;
            } catch (JSONException e) {
                ab.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", e);
                AppMethodBeat.o(96167);
                return null;
            }
        }

        private static String[] n(JSONObject jSONObject) {
            int i = 0;
            AppMethodBeat.i(96168);
            JSONArray optJSONArray = jSONObject.optJSONArray("alias");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                String[] strArr = new String[0];
                AppMethodBeat.o(96168);
                return strArr;
            }
            String[] strArr2 = new String[optJSONArray.length()];
            while (i < optJSONArray.length()) {
                strArr2[i] = optJSONArray.optString(i);
                i++;
            }
            AppMethodBeat.o(96168);
            return strArr2;
        }
    }

    public static final class WxaEntryInfo implements Parcelable {
        public static final Creator<WxaEntryInfo> CREATOR = new Creator<WxaEntryInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaEntryInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(96162);
                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo(parcel);
                AppMethodBeat.o(96162);
                return wxaEntryInfo;
            }
        };
        public String hih;
        public String iconUrl;
        public String title;
        public String username;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(96163);
            parcel.writeString(this.username);
            parcel.writeString(this.title);
            parcel.writeString(this.hih);
            parcel.writeString(this.iconUrl);
            AppMethodBeat.o(96163);
        }

        protected WxaEntryInfo(Parcel parcel) {
            AppMethodBeat.i(96164);
            this.username = parcel.readString();
            this.title = parcel.readString();
            this.hih = parcel.readString();
            this.iconUrl = parcel.readString();
            AppMethodBeat.o(96164);
        }

        static {
            AppMethodBeat.i(96165);
            AppMethodBeat.o(96165);
        }
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(96169);
        super.d(cursor);
        this.hhM = null;
        this.hhN = null;
        this.hhO = null;
        this.hhP = null;
        this.hhQ = null;
        AppMethodBeat.o(96169);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return gSs;
    }

    public final a ayJ() {
        AppMethodBeat.i(96170);
        if (this.hhM == null) {
            this.hhM = a.zx(this.field_appInfo);
        }
        a aVar = this.hhM;
        AppMethodBeat.o(96170);
        return aVar;
    }

    public final d ayK() {
        boolean z = true;
        int i = 0;
        AppMethodBeat.i(96171);
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
            this.hhN = new d();
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
            a aVar = this.hhN.hib;
            if (optJSONObject.optInt("TLSSkipHostnameCheck", 0) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.bQC = z2;
            this.hhN.hib.hif = optJSONObject.optInt("MaxFileStorageSize", 10);
            this.hhN.hib.hig = optJSONObject.optInt("BackgroundNetworkInterruptedTimeout", 5);
            aVar = this.hhN.hib;
            if (optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.hgY = z2;
            this.hhN.hib.hhb = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.hhN.hib.hhc = optJSONObject.optInt("LifeSpanAfterSuspend", 300);
            aVar = this.hhN.hib;
            if (optJSONObject.optInt("ScanCodeEnableZZM", 0) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.bQK = z2;
            aVar = this.hhN.hib;
            if (optJSONObject.optInt("CanPreFetchData", 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.hbV = z2;
            a aVar2 = this.hhN.hib;
            if (optJSONObject.optInt("CanPeriodFetchData", 0) <= 0) {
                z = false;
            }
            aVar2.hbW = z;
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
        d dVar = this.hhN;
        AppMethodBeat.o(96171);
        return dVar;
    }

    public final e ayL() {
        AppMethodBeat.i(96172);
        e eVar;
        if (this.hhO != null || bo.isNullOrNil(this.field_versionInfo)) {
            eVar = this.hhO;
            AppMethodBeat.o(96172);
            return eVar;
        }
        eVar = e.zz(this.field_versionInfo);
        this.hhO = eVar;
        AppMethodBeat.o(96172);
        return eVar;
    }

    public final List<WxaEntryInfo> ayM() {
        AppMethodBeat.i(96173);
        if (this.hhP == null && !bo.isNullOrNil(this.field_bindWxaInfo)) {
            try {
                JSONArray optJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
                if (optJSONArray != null) {
                    this.hhP = new LinkedList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("username");
                            if (!bo.isNullOrNil(optString)) {
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
        AppMethodBeat.o(96173);
        return list;
    }

    public final b ayN() {
        AppMethodBeat.i(96174);
        if (this.hhQ == null && !bo.isNullOrNil(this.field_bizMenu)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_bizMenu);
                this.hhQ = new b();
                this.hhQ.fvv = jSONObject.optInt("interactive_mode", 0);
                this.hhQ.type = jSONObject.optInt("type", 0);
                this.hhQ.hhZ = k(jSONObject.optJSONArray("button_list"));
            } catch (Exception e) {
                this.hhQ = null;
            }
        }
        b bVar = this.hhQ;
        AppMethodBeat.o(96174);
        return bVar;
    }

    private List<a> k(JSONArray jSONArray) {
        ArrayList arrayList;
        AppMethodBeat.i(96175);
        if (jSONArray != null) {
            arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.name = jSONObject.optString("name", "");
                    aVar.type = jSONObject.optInt("type");
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("value", ""));
                    aVar.userName = jSONObject2.optString("userName", "");
                    aVar.csu = jSONObject2.optString("pagePath", "");
                    aVar.version = jSONObject2.optInt("version");
                    aVar.hia = k(jSONObject.optJSONArray("sub_button_list"));
                    arrayList.add(aVar);
                }
            } catch (JSONException e) {
                AppMethodBeat.o(96175);
                return null;
            }
        }
        arrayList = null;
        AppMethodBeat.o(96175);
        return arrayList;
    }

    public final String toString() {
        AppMethodBeat.i(96176);
        String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
        AppMethodBeat.o(96176);
        return str;
    }

    static {
        AppMethodBeat.i(96177);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "usernameHash";
        aVar.xDd.put("usernameHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "usernameHash";
        aVar.columns[1] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "shortNickname";
        aVar.xDd.put("shortNickname", "TEXT");
        stringBuilder.append(" shortNickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "brandIconURL";
        aVar.xDd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "roundedSquareIconURL";
        aVar.xDd.put("roundedSquareIconURL", "TEXT");
        stringBuilder.append(" roundedSquareIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "bigHeadURL";
        aVar.xDd.put("bigHeadURL", "TEXT");
        stringBuilder.append(" bigHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "smallHeadURL";
        aVar.xDd.put("smallHeadURL", "TEXT");
        stringBuilder.append(" smallHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "signature";
        aVar.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "appOpt";
        aVar.xDd.put("appOpt", "INTEGER default '0' ");
        stringBuilder.append(" appOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "registerSource";
        aVar.xDd.put("registerSource", "TEXT");
        stringBuilder.append(" registerSource TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "appInfo";
        aVar.xDd.put("appInfo", "TEXT");
        stringBuilder.append(" appInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "versionInfo";
        aVar.xDd.put("versionInfo", "TEXT");
        stringBuilder.append(" versionInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "bindWxaInfo";
        aVar.xDd.put("bindWxaInfo", "TEXT");
        stringBuilder.append(" bindWxaInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "dynamicInfo";
        aVar.xDd.put("dynamicInfo", "TEXT");
        stringBuilder.append(" dynamicInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "reserved";
        aVar.xDd.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "syncTimeSecond";
        aVar.xDd.put("syncTimeSecond", "LONG default '0' ");
        stringBuilder.append(" syncTimeSecond LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "syncVersion";
        aVar.xDd.put("syncVersion", "TEXT");
        stringBuilder.append(" syncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "bizMenu";
        aVar.xDd.put("bizMenu", "TEXT");
        stringBuilder.append(" bizMenu TEXT");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        gSs = aVar;
        AppMethodBeat.o(96177);
    }
}
