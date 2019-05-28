package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ae;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends ae {
    protected static com.tencent.mm.sdk.e.c.a ccO;
    public static int fuU = 1;
    public static int fuV = 0;
    public static int fuW = 1;
    private static int fuZ = 0;
    private static b fva = null;
    private List<a> fuX;
    public b fuY;

    public static class a {
        public String description;
        public String fvb;
        public String title;
        public String url;
    }

    public static class b {
        private int fmr = 0;
        private g fvA;
        private String fvB;
        private String fvC;
        private boolean fvD = false;
        public a fvE;
        private List<WxaEntryInfo> fvF;
        public JSONObject fvc = null;
        private boolean fvd = true;
        public boolean fve = false;
        private boolean fvf = false;
        public boolean fvg = false;
        private String fvh;
        private String fvi;
        private List<f> fvj = null;
        private d fvk = null;
        private c fvl = null;
        private e fvm = null;
        a fvn = null;
        private boolean fvo = false;
        boolean fvp = false;
        int fvq;
        public boolean fvr = false;
        public int fvs = 0;
        private String fvt;
        private b fvu = null;
        private int fvv = 0;
        private int fvw = d.fuV;
        private String fvx;
        private boolean fvy = false;
        private int fvz;

        public static class c {
            public int fvK;
            public List<j> fvL = null;
            public int type;

            public static class a {
                public long appid = 0;
                public String fvM;
                public String fvN;
                public int fvO;
                public String fvP;
                public String fvQ;

                public static a qL(String str) {
                    AppMethodBeat.i(11273);
                    ab.i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(str)));
                    a aVar = new a();
                    if (str == null || str.length() <= 0) {
                        AppMethodBeat.o(11273);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            aVar.fvM = jSONObject.optString("belong");
                            aVar.fvN = jSONObject.optString("freeze_wording");
                            aVar.fvO = jSONObject.optInt("child_type");
                            aVar.fvP = jSONObject.optString("home_url");
                            String optString = jSONObject.optString("exattr");
                            if (bo.isNullOrNil(optString)) {
                                aVar.fvQ = null;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(optString);
                                aVar.fvQ = jSONObject2.optString("chat_extension_url");
                                aVar.appid = jSONObject2.optLong("app_id");
                            }
                        } catch (JSONException e) {
                            ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                        }
                        AppMethodBeat.o(11273);
                    }
                    return aVar;
                }
            }

            public static c qK(String str) {
                AppMethodBeat.i(11274);
                ab.i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(str)));
                c cVar = new c();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(11274);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        cVar.fvK = jSONObject.optInt("update_time");
                        cVar.type = jSONObject.optInt("type", 0);
                        cVar.fvL = j.e(jSONObject.optJSONArray("button_list"));
                    } catch (JSONException e) {
                        ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                    }
                    AppMethodBeat.o(11274);
                }
                return cVar;
            }
        }

        public static class d {
            public int fvR = 0;
            public String fvS;
            public String fvT;
            public String fvU;
            public String fvV;

            public static d qM(String str) {
                AppMethodBeat.i(11275);
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(11275);
                    return null;
                }
                ab.i("MicroMsg.BizInfo", "biz verify info is [%s]", str);
                d dVar = new d();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    dVar.fvR = jSONObject.optInt("Type");
                    dVar.fvS = jSONObject.optString("Description");
                    dVar.fvT = jSONObject.optString("Name");
                    dVar.fvU = jSONObject.optString("IntroUrl");
                    dVar.fvV = jSONObject.optString("VerifySubTitle");
                } catch (Exception e) {
                    ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                }
                ab.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", Integer.valueOf(dVar.fvR), dVar.fvS, dVar.fvT, dVar.fvU);
                AppMethodBeat.o(11275);
                return dVar;
            }
        }

        public static class e {
            public int fvW;
            public String fvX;
            public List<String> fvY;
            public String fvZ;

            public static e qN(String str) {
                AppMethodBeat.i(11276);
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(11276);
                    return null;
                }
                try {
                    e eVar = new e();
                    JSONObject jSONObject = new JSONObject(str);
                    eVar.fvW = jSONObject.optInt("reputation_level", -1);
                    eVar.fvX = jSONObject.optString("scope_of_business");
                    eVar.fvZ = jSONObject.optString("guarantee_detail_h5_url");
                    JSONArray optJSONArray = jSONObject.optJSONArray("guarantee_info");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        if (length > 0) {
                            eVar.fvY = new ArrayList();
                            for (int i = 0; i < length; i++) {
                                String string = optJSONArray.getString(i);
                                if (!bo.isNullOrNil(string)) {
                                    eVar.fvY.add(string);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(11276);
                    return eVar;
                } catch (Exception e) {
                    ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                    AppMethodBeat.o(11276);
                    return null;
                }
            }
        }

        public static class f {
            public String description;
            public String fwa;
            public String iconUrl;

            public static List<f> d(JSONArray jSONArray) {
                AppMethodBeat.i(11277);
                LinkedList linkedList = new LinkedList();
                if (jSONArray == null) {
                    AppMethodBeat.o(11277);
                } else {
                    try {
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            f fVar = new f();
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            fVar.iconUrl = optJSONObject.optString("icon");
                            fVar.description = optJSONObject.optString("description");
                            fVar.fwa = optJSONObject.optString("description_key");
                            linkedList.add(fVar);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                    }
                    AppMethodBeat.o(11277);
                }
                return linkedList;
            }
        }

        public static class g {
            public String fwb;
            public String fwc;
            public boolean fwd;

            public static g qO(String str) {
                AppMethodBeat.i(11278);
                ab.i("MicroMsg.BizInfo", "RegisterSource = %s", str);
                g gVar = new g();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(11278);
                } else {
                    try {
                        boolean z;
                        JSONObject jSONObject = new JSONObject(str);
                        gVar.fwb = jSONObject.optString("RegisterBody");
                        gVar.fwc = jSONObject.optString("IntroUrl");
                        if (jSONObject.optInt("IsClose", 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        gVar.fwd = z;
                    } catch (JSONException e) {
                        ab.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", bo.l(e));
                    }
                    AppMethodBeat.o(11278);
                }
                return gVar;
            }
        }

        public static class a {
            public ArrayList<String> fvG;

            public static a qI(String str) {
                AppMethodBeat.i(11271);
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(11271);
                    return null;
                }
                a aVar = new a();
                ab.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", str);
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("origin_name_list");
                    if (optJSONArray != null) {
                        aVar.fvG = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aVar.fvG.add(optJSONArray.optString(i));
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                }
                AppMethodBeat.o(11271);
                return aVar;
            }
        }

        public static class b {
            public int fvH;
            public int fvI;
            public int fvJ;

            public static b qJ(String str) {
                AppMethodBeat.i(11272);
                ab.i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(str)));
                b bVar = new b();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(11272);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        bVar.fvH = jSONObject.optInt("hardware_flag");
                        bVar.fvI = jSONObject.optInt("connect_status_display_mode");
                        bVar.fvJ = jSONObject.optInt("special_internal_brand_type");
                    } catch (JSONException e) {
                        ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                    }
                    AppMethodBeat.o(11272);
                }
                return bVar;
            }

            public final boolean aes() {
                return (this.fvH & 1) > 0;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final List<WxaEntryInfo> getWxaEntryInfoList() {
            AppMethodBeat.i(11279);
            if (this.fvF == null) {
                this.fvF = new LinkedList();
                if (this.fvc != null) {
                    JSONObject jSONObject;
                    JSONArray optJSONArray;
                    String optString = this.fvc.optString("BindWxaInfo");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            jSONObject = new JSONObject(optString);
                        } catch (JSONException e) {
                        }
                        if (jSONObject == null) {
                            optJSONArray = jSONObject.optJSONArray("wxaEntryInfo");
                        } else {
                            optJSONArray = null;
                        }
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                if (optJSONObject != null) {
                                    String optString2 = optJSONObject.optString("username");
                                    String optString3 = optJSONObject.optString("title");
                                    String optString4 = optJSONObject.optString("title_key");
                                    optString = optJSONObject.optString("icon_url");
                                    if (!(TextUtils.isEmpty(optString2) || (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString4)))) {
                                        WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                        wxaEntryInfo.username = optString2;
                                        wxaEntryInfo.title = optString3;
                                        wxaEntryInfo.hih = optString4;
                                        wxaEntryInfo.iconUrl = optString;
                                        this.fvF.add(wxaEntryInfo);
                                    }
                                }
                            }
                        }
                    }
                    jSONObject = null;
                    if (jSONObject == null) {
                    }
                    if (optJSONArray != null) {
                    }
                }
            }
            List list = this.fvF;
            AppMethodBeat.o(11279);
            return list;
        }

        public final boolean adZ() {
            AppMethodBeat.i(11280);
            if (!(this.fvc == null || this.fvc.optJSONObject("WifiBizInfo") == null || this.fvc.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") != 1)) {
                this.fvD = true;
            }
            boolean z = this.fvD;
            AppMethodBeat.o(11280);
            return z;
        }

        public final boolean aea() {
            AppMethodBeat.i(11281);
            if (this.fvc != null) {
                this.fvf = "1".equals(this.fvc.optString("IsShowMember"));
            }
            boolean z = this.fvf;
            AppMethodBeat.o(11281);
            return z;
        }

        public final boolean aeb() {
            AppMethodBeat.i(11282);
            if (this.fvc != null) {
                this.fvw = bo.getInt(this.fvc.optString("NotifyManage"), d.fuV);
            }
            if (this.fvw == d.fuU) {
                AppMethodBeat.o(11282);
                return true;
            }
            AppMethodBeat.o(11282);
            return false;
        }

        public final String aec() {
            AppMethodBeat.i(11283);
            if (this.fvc != null) {
                this.fvh = this.fvc.optString("VerifyContactPromptTitle");
            }
            String str = this.fvh;
            AppMethodBeat.o(11283);
            return str;
        }

        public final String aed() {
            AppMethodBeat.i(11284);
            if (this.fvc != null) {
                this.fvB = this.fvc.optString("TrademarkUrl");
            }
            String str = this.fvB;
            AppMethodBeat.o(11284);
            return str;
        }

        public final String aee() {
            AppMethodBeat.i(11285);
            if (this.fvc != null) {
                this.fvC = this.fvc.optString("TrademarkName");
            }
            String str = this.fvC;
            AppMethodBeat.o(11285);
            return str;
        }

        public final String aef() {
            AppMethodBeat.i(11286);
            if (this.fvc != null) {
                this.fvi = this.fvc.optString("ConferenceContactExpireTime");
            }
            String str = this.fvi;
            AppMethodBeat.o(11286);
            return str;
        }

        public final List<f> aeg() {
            AppMethodBeat.i(11287);
            if (this.fvc != null && this.fvj == null) {
                this.fvj = f.d(this.fvc.optJSONArray("Privilege"));
            }
            List list = this.fvj;
            AppMethodBeat.o(11287);
            return list;
        }

        public final int aeh() {
            AppMethodBeat.i(11288);
            if (this.fvc != null) {
                this.fvv = this.fvc.optInt("InteractiveMode");
            }
            int i = this.fvv;
            AppMethodBeat.o(11288);
            return i;
        }

        public final e aei() {
            AppMethodBeat.i(11289);
            if (this.fvc != null && this.fvm == null) {
                this.fvm = e.qN(this.fvc.optString("PayShowInfo"));
            }
            e eVar = this.fvm;
            AppMethodBeat.o(11289);
            return eVar;
        }

        public final b aej() {
            AppMethodBeat.i(11290);
            if (this.fvc != null && this.fvu == null) {
                String optString = this.fvc.optString("HardwareBizInfo");
                if (optString != null) {
                    this.fvu = b.qJ(optString);
                }
            }
            b bVar = this.fvu;
            AppMethodBeat.o(11290);
            return bVar;
        }

        public final d aek() {
            AppMethodBeat.i(11291);
            if (this.fvc != null && this.fvk == null) {
                this.fvk = d.qM(this.fvc.optString("VerifySource"));
            }
            d dVar = this.fvk;
            AppMethodBeat.o(11291);
            return dVar;
        }

        public final g ael() {
            AppMethodBeat.i(11292);
            if (this.fvc != null && this.fvA == null) {
                String optString = this.fvc.optString("RegisterSource");
                if (optString != null) {
                    this.fvA = g.qO(optString);
                }
            }
            g gVar = this.fvA;
            AppMethodBeat.o(11292);
            return gVar;
        }

        public final boolean adL() {
            boolean z = false;
            AppMethodBeat.i(11293);
            if (this.fvc != null) {
                if (bo.getInt(this.fvc.optString("ReportLocationType"), 0) > 0) {
                    z = true;
                }
                this.fvo = z;
            }
            z = this.fvo;
            AppMethodBeat.o(11293);
            return z;
        }

        public final boolean aem() {
            boolean z = true;
            AppMethodBeat.i(11294);
            if (this.fvc != null) {
                if (bo.getInt(this.fvc.optString("IsTrademarkProtection"), 0) != 1) {
                    z = false;
                }
                this.fvy = z;
            }
            z = this.fvy;
            AppMethodBeat.o(11294);
            return z;
        }

        public final int getServiceType() {
            AppMethodBeat.i(11295);
            if (this.fvc != null) {
                this.fmr = this.fvc.optInt("ServiceType", 0);
            }
            int i = this.fmr;
            AppMethodBeat.o(11295);
            return i;
        }

        public final String aen() {
            AppMethodBeat.i(11296);
            if (this.fvc != null) {
                this.fvt = this.fvc.optString("SupportEmoticonLinkPrefix");
            }
            String str = this.fvt;
            AppMethodBeat.o(11296);
            return str;
        }

        public final c aeo() {
            AppMethodBeat.i(11297);
            if (this.fvc != null && this.fvl == null) {
                String optString = this.fvc.optString("MMBizMenu");
                if (optString != null) {
                    this.fvl = c.qK(optString);
                }
            }
            c cVar = this.fvl;
            AppMethodBeat.o(11297);
            return cVar;
        }

        public final String aep() {
            AppMethodBeat.i(11298);
            if (this.fvc != null) {
                this.fvx = this.fvc.optString("ServicePhone");
            }
            String str = this.fvx;
            AppMethodBeat.o(11298);
            return str;
        }

        private b() {
        }

        static b qH(String str) {
            AppMethodBeat.i(11300);
            b bVar = new b();
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(11300);
            } else {
                try {
                    System.currentTimeMillis();
                    bVar.fvc = new JSONObject(str);
                } catch (Exception e) {
                    ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
                }
                AppMethodBeat.o(11300);
            }
            return bVar;
        }

        public final a aer() {
            AppMethodBeat.i(11301);
            if (this.fvc != null && this.fvn == null) {
                String optString = this.fvc.optString("EnterpriseBizInfo");
                if (optString != null) {
                    this.fvn = a.qL(optString);
                }
            }
            a aVar = this.fvn;
            AppMethodBeat.o(11301);
            return aVar;
        }

        public final boolean aeq() {
            AppMethodBeat.i(11299);
            if (this.fvc != null) {
                this.fvz = this.fvc.optInt("FunctionFlag");
            }
            if ((this.fvz & d.fuW) > 0) {
                AppMethodBeat.o(11299);
                return true;
            }
            AppMethodBeat.o(11299);
            return false;
        }
    }

    static {
        AppMethodBeat.i(11321);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandList";
        aVar.xDd.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandListVersion";
        aVar.xDd.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandListContent";
        aVar.xDd.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "brandFlag";
        aVar.xDd.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = IssueStorage.COLUMN_EXT_INFO;
        aVar.xDd.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "brandInfo";
        aVar.xDd.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "brandIconURL";
        aVar.xDd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "hadAlert";
        aVar.xDd.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "acceptType";
        aVar.xDd.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "type";
        aVar.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "enterpriseFather";
        aVar.xDd.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "kfWorkerId";
        aVar.xDd.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "specialType";
        aVar.xDd.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "attrSyncVersion";
        aVar.xDd.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "incrementUpdateTime";
        aVar.xDd.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "bitFlag";
        aVar.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(11321);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final b cJ(boolean z) {
        b qH;
        AppMethodBeat.i(11302);
        if (this.fuY == null || z) {
            if (bo.isNullOrNil(this.field_extInfo) || fuZ != this.field_extInfo.hashCode()) {
                qH = b.qH(this.field_extInfo);
                this.fuY = qH;
                fva = qH;
                fuZ = bo.nullAsNil(this.field_extInfo).hashCode();
            } else {
                this.fuY = fva;
            }
        }
        qH = this.fuY;
        AppMethodBeat.o(11302);
        return qH;
    }

    public final boolean adH() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean adI() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean adJ() {
        AppMethodBeat.i(11303);
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            AppMethodBeat.o(11303);
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime < instance.getTimeInMillis()) {
            AppMethodBeat.o(11303);
            return true;
        }
        AppMethodBeat.o(11303);
        return false;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(11318);
        super.d(cursor);
        AppMethodBeat.o(11318);
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(11319);
        ContentValues Hl = super.Hl();
        AppMethodBeat.o(11319);
        return Hl;
    }

    public final List<a> adY() {
        AppMethodBeat.i(11320);
        if (this.fuX != null) {
            List list = this.fuX;
            AppMethodBeat.o(11320);
            return list;
        }
        this.fuX = new LinkedList();
        List<a> list2;
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            list2 = this.fuX;
            AppMethodBeat.o(11320);
            return list2;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aVar.title = optJSONObject.optString("title");
                aVar.url = optJSONObject.optString("url");
                aVar.fvb = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.fuX.add(aVar);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.BizInfo", "exception:%s", bo.l(e));
        }
        list2 = this.fuX;
        AppMethodBeat.o(11320);
        return list2;
    }

    private boolean lc(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    private void ld(int i) {
        this.field_bitFlag |= i;
    }

    public final void adK() {
        AppMethodBeat.i(11304);
        cJ(false);
        b bVar = this.fuY;
        if (bVar.fvc != null) {
            bVar.fvq = bVar.fvc.optInt("ConnectorMsgType");
        }
        this.field_acceptType = bVar.fvq;
        this.field_type = cJ(false).getServiceType();
        if (adR()) {
            ld(1);
            AppMethodBeat.o(11304);
            return;
        }
        this.field_bitFlag &= -2;
        AppMethodBeat.o(11304);
    }

    public final boolean adL() {
        AppMethodBeat.i(11305);
        cJ(false);
        ab.i("MicroMsg.BizInfo", "is report location, user %s %B", this.field_username, Boolean.valueOf(this.fuY.adL()));
        boolean adL = this.fuY.adL();
        AppMethodBeat.o(11305);
        return adL;
    }

    public final boolean adM() {
        AppMethodBeat.i(11306);
        cJ(false);
        if (this.field_type == 1) {
            AppMethodBeat.o(11306);
            return true;
        }
        AppMethodBeat.o(11306);
        return false;
    }

    public final boolean adN() {
        AppMethodBeat.i(11307);
        cJ(false);
        if (this.field_type == 0) {
            AppMethodBeat.o(11307);
            return true;
        }
        AppMethodBeat.o(11307);
        return false;
    }

    public final boolean adO() {
        AppMethodBeat.i(11308);
        cJ(false);
        if (this.field_type == 2 || this.field_type == 3) {
            AppMethodBeat.o(11308);
            return true;
        }
        AppMethodBeat.o(11308);
        return false;
    }

    public final boolean adP() {
        AppMethodBeat.i(11309);
        cJ(false);
        if (this.field_type == 2) {
            AppMethodBeat.o(11309);
            return true;
        }
        AppMethodBeat.o(11309);
        return false;
    }

    public final boolean adQ() {
        AppMethodBeat.i(11310);
        cJ(false);
        if (this.field_type == 3) {
            AppMethodBeat.o(11310);
            return true;
        }
        AppMethodBeat.o(11310);
        return false;
    }

    public final boolean adR() {
        boolean z;
        AppMethodBeat.i(11311);
        cJ(false);
        if (this.fuY == null || this.fuY.aer() == null) {
            z = false;
        } else {
            z = this.fuY.fvn.fvO == 1;
            if (z && !lc(1)) {
                ld(1);
                z.aeR().e(this);
            }
            if (z) {
                ab.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", this.field_username);
            }
        }
        AppMethodBeat.o(11311);
        return z;
    }

    public final boolean adS() {
        boolean z;
        AppMethodBeat.i(11312);
        cJ(false);
        if (this.fuY == null || this.fuY.aer() == null) {
            z = false;
        } else {
            z = this.fuY.fvn.fvO == 2;
            if (z && !lc(2)) {
                ld(2);
                z.aeR().e(this);
            }
            if (z) {
                ab.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", this.field_username);
            }
        }
        AppMethodBeat.o(11312);
        return z;
    }

    public final String adT() {
        AppMethodBeat.i(11313);
        cJ(false);
        if (this.fuY != null) {
            a aer = this.fuY.aer();
            if (!(aer == null || aer.fvP == null || aer.fvP.isEmpty())) {
                String str = aer.fvP;
                AppMethodBeat.o(11313);
                return str;
            }
        }
        AppMethodBeat.o(11313);
        return null;
    }

    public final long adU() {
        AppMethodBeat.i(11314);
        cJ(false);
        if (this.fuY != null) {
            a aer = this.fuY.aer();
            if (!(aer == null || aer.appid == 0)) {
                long j = aer.appid;
                AppMethodBeat.o(11314);
                return j;
            }
        }
        AppMethodBeat.o(11314);
        return 0;
    }

    public final boolean adV() {
        AppMethodBeat.i(11315);
        cJ(false);
        if (this.fuY == null) {
            ab.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
            AppMethodBeat.o(11315);
            return true;
        } else if (this.fuY.ael() == null) {
            ab.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
            AppMethodBeat.o(11315);
            return true;
        } else if (this.fuY.ael().fwd) {
            AppMethodBeat.o(11315);
            return false;
        } else {
            AppMethodBeat.o(11315);
            return true;
        }
    }

    public final String adW() {
        AppMethodBeat.i(11316);
        cJ(false);
        if (this.fuY != null) {
            a aer = this.fuY.aer();
            if (aer != null) {
                String str = aer.fvQ;
                AppMethodBeat.o(11316);
                return str;
            }
        }
        AppMethodBeat.o(11316);
        return null;
    }

    public final String adX() {
        AppMethodBeat.i(11317);
        String str = cJ(false).aer().fvM;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BizInfo", "check father: %s, %s", this.field_username, str);
        }
        AppMethodBeat.o(11317);
        return str;
    }
}
