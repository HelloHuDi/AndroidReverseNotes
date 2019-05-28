package com.tencent.p177mm.p184aj;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9517ae;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aj.d */
public final class C16527d extends C9517ae {
    protected static C4924a ccO;
    public static int fuU = 1;
    public static int fuV = 0;
    public static int fuW = 1;
    private static int fuZ = 0;
    private static C16529b fva = null;
    private List<C16528a> fuX;
    public C16529b fuY;

    /* renamed from: com.tencent.mm.aj.d$a */
    public static class C16528a {
        public String description;
        public String fvb;
        public String title;
        public String url;
    }

    /* renamed from: com.tencent.mm.aj.d$b */
    public static class C16529b {
        private int fmr = 0;
        private C16534g fvA;
        private String fvB;
        private String fvC;
        private boolean fvD = false;
        public C16535a fvE;
        private List<WxaEntryInfo> fvF;
        public JSONObject fvc = null;
        private boolean fvd = true;
        public boolean fve = false;
        private boolean fvf = false;
        public boolean fvg = false;
        private String fvh;
        private String fvi;
        private List<C16533f> fvj = null;
        private C16531d fvk = null;
        private C16530c fvl = null;
        private C16532e fvm = null;
        C8932a fvn = null;
        private boolean fvo = false;
        boolean fvp = false;
        int fvq;
        public boolean fvr = false;
        public int fvs = 0;
        private String fvt;
        private C16536b fvu = null;
        private int fvv = 0;
        private int fvw = C16527d.fuV;
        private String fvx;
        private boolean fvy = false;
        private int fvz;

        /* renamed from: com.tencent.mm.aj.d$b$c */
        public static class C16530c {
            public int fvK;
            public List<C37455j> fvL = null;
            public int type;

            /* renamed from: com.tencent.mm.aj.d$b$c$a */
            public static class C8932a {
                public long appid = 0;
                public String fvM;
                public String fvN;
                public int fvO;
                public String fvP;
                public String fvQ;

                /* renamed from: qL */
                public static C8932a m16102qL(String str) {
                    AppMethodBeat.m2504i(11273);
                    C4990ab.m7416i("MicroMsg.BizInfo", "EnterpriseBizInfo = ".concat(String.valueOf(str)));
                    C8932a c8932a = new C8932a();
                    if (str == null || str.length() <= 0) {
                        AppMethodBeat.m2505o(11273);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            c8932a.fvM = jSONObject.optString("belong");
                            c8932a.fvN = jSONObject.optString("freeze_wording");
                            c8932a.fvO = jSONObject.optInt("child_type");
                            c8932a.fvP = jSONObject.optString("home_url");
                            String optString = jSONObject.optString("exattr");
                            if (C5046bo.isNullOrNil(optString)) {
                                c8932a.fvQ = null;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(optString);
                                c8932a.fvQ = jSONObject2.optString("chat_extension_url");
                                c8932a.appid = jSONObject2.optLong("app_id");
                            }
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                        }
                        AppMethodBeat.m2505o(11273);
                    }
                    return c8932a;
                }
            }

            /* renamed from: qK */
            public static C16530c m25404qK(String str) {
                AppMethodBeat.m2504i(11274);
                C4990ab.m7416i("MicroMsg.BizInfo", "MenuInfo = ".concat(String.valueOf(str)));
                C16530c c16530c = new C16530c();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.m2505o(11274);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        c16530c.fvK = jSONObject.optInt("update_time");
                        c16530c.type = jSONObject.optInt("type", 0);
                        c16530c.fvL = C37455j.m63154e(jSONObject.optJSONArray("button_list"));
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(11274);
                }
                return c16530c;
            }
        }

        /* renamed from: com.tencent.mm.aj.d$b$d */
        public static class C16531d {
            public int fvR = 0;
            public String fvS;
            public String fvT;
            public String fvU;
            public String fvV;

            /* renamed from: qM */
            public static C16531d m25405qM(String str) {
                AppMethodBeat.m2504i(11275);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(11275);
                    return null;
                }
                C4990ab.m7417i("MicroMsg.BizInfo", "biz verify info is [%s]", str);
                C16531d c16531d = new C16531d();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    c16531d.fvR = jSONObject.optInt("Type");
                    c16531d.fvS = jSONObject.optString("Description");
                    c16531d.fvT = jSONObject.optString("Name");
                    c16531d.fvU = jSONObject.optString("IntroUrl");
                    c16531d.fvV = jSONObject.optString("VerifySubTitle");
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                }
                C4990ab.m7417i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", Integer.valueOf(c16531d.fvR), c16531d.fvS, c16531d.fvT, c16531d.fvU);
                AppMethodBeat.m2505o(11275);
                return c16531d;
            }
        }

        /* renamed from: com.tencent.mm.aj.d$b$e */
        public static class C16532e {
            public int fvW;
            public String fvX;
            public List<String> fvY;
            public String fvZ;

            /* renamed from: qN */
            public static C16532e m25406qN(String str) {
                AppMethodBeat.m2504i(11276);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(11276);
                    return null;
                }
                try {
                    C16532e c16532e = new C16532e();
                    JSONObject jSONObject = new JSONObject(str);
                    c16532e.fvW = jSONObject.optInt("reputation_level", -1);
                    c16532e.fvX = jSONObject.optString("scope_of_business");
                    c16532e.fvZ = jSONObject.optString("guarantee_detail_h5_url");
                    JSONArray optJSONArray = jSONObject.optJSONArray("guarantee_info");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        if (length > 0) {
                            c16532e.fvY = new ArrayList();
                            for (int i = 0; i < length; i++) {
                                String string = optJSONArray.getString(i);
                                if (!C5046bo.isNullOrNil(string)) {
                                    c16532e.fvY.add(string);
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(11276);
                    return c16532e;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(11276);
                    return null;
                }
            }
        }

        /* renamed from: com.tencent.mm.aj.d$b$f */
        public static class C16533f {
            public String description;
            public String fwa;
            public String iconUrl;

            /* renamed from: d */
            public static List<C16533f> m25407d(JSONArray jSONArray) {
                AppMethodBeat.m2504i(11277);
                LinkedList linkedList = new LinkedList();
                if (jSONArray == null) {
                    AppMethodBeat.m2505o(11277);
                } else {
                    try {
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            C16533f c16533f = new C16533f();
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            c16533f.iconUrl = optJSONObject.optString("icon");
                            c16533f.description = optJSONObject.optString("description");
                            c16533f.fwa = optJSONObject.optString("description_key");
                            linkedList.add(c16533f);
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(11277);
                }
                return linkedList;
            }
        }

        /* renamed from: com.tencent.mm.aj.d$b$g */
        public static class C16534g {
            public String fwb;
            public String fwc;
            public boolean fwd;

            /* renamed from: qO */
            public static C16534g m25408qO(String str) {
                AppMethodBeat.m2504i(11278);
                C4990ab.m7417i("MicroMsg.BizInfo", "RegisterSource = %s", str);
                C16534g c16534g = new C16534g();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.m2505o(11278);
                } else {
                    try {
                        boolean z;
                        JSONObject jSONObject = new JSONObject(str);
                        c16534g.fwb = jSONObject.optString("RegisterBody");
                        c16534g.fwc = jSONObject.optString("IntroUrl");
                        if (jSONObject.optInt("IsClose", 0) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c16534g.fwd = z;
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.BizInfo", "exception in RegisterSource:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(11278);
                }
                return c16534g;
            }
        }

        /* renamed from: com.tencent.mm.aj.d$b$a */
        public static class C16535a {
            public ArrayList<String> fvG;

            /* renamed from: qI */
            public static C16535a m25409qI(String str) {
                AppMethodBeat.m2504i(11271);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(11271);
                    return null;
                }
                C16535a c16535a = new C16535a();
                C4990ab.m7411d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", str);
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("origin_name_list");
                    if (optJSONArray != null) {
                        c16535a.fvG = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            c16535a.fvG.add(optJSONArray.optString(i));
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                }
                AppMethodBeat.m2505o(11271);
                return c16535a;
            }
        }

        /* renamed from: com.tencent.mm.aj.d$b$b */
        public static class C16536b {
            public int fvH;
            public int fvI;
            public int fvJ;

            /* renamed from: qJ */
            public static C16536b m25410qJ(String str) {
                AppMethodBeat.m2504i(11272);
                C4990ab.m7416i("MicroMsg.BizInfo", "HardwareBizInfo = ".concat(String.valueOf(str)));
                C16536b c16536b = new C16536b();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.m2505o(11272);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        c16536b.fvH = jSONObject.optInt("hardware_flag");
                        c16536b.fvI = jSONObject.optInt("connect_status_display_mode");
                        c16536b.fvJ = jSONObject.optInt("special_internal_brand_type");
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(11272);
                }
                return c16536b;
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
            AppMethodBeat.m2504i(11279);
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
            AppMethodBeat.m2505o(11279);
            return list;
        }

        public final boolean adZ() {
            AppMethodBeat.m2504i(11280);
            if (!(this.fvc == null || this.fvc.optJSONObject("WifiBizInfo") == null || this.fvc.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") != 1)) {
                this.fvD = true;
            }
            boolean z = this.fvD;
            AppMethodBeat.m2505o(11280);
            return z;
        }

        public final boolean aea() {
            AppMethodBeat.m2504i(11281);
            if (this.fvc != null) {
                this.fvf = "1".equals(this.fvc.optString("IsShowMember"));
            }
            boolean z = this.fvf;
            AppMethodBeat.m2505o(11281);
            return z;
        }

        public final boolean aeb() {
            AppMethodBeat.m2504i(11282);
            if (this.fvc != null) {
                this.fvw = C5046bo.getInt(this.fvc.optString("NotifyManage"), C16527d.fuV);
            }
            if (this.fvw == C16527d.fuU) {
                AppMethodBeat.m2505o(11282);
                return true;
            }
            AppMethodBeat.m2505o(11282);
            return false;
        }

        public final String aec() {
            AppMethodBeat.m2504i(11283);
            if (this.fvc != null) {
                this.fvh = this.fvc.optString("VerifyContactPromptTitle");
            }
            String str = this.fvh;
            AppMethodBeat.m2505o(11283);
            return str;
        }

        public final String aed() {
            AppMethodBeat.m2504i(11284);
            if (this.fvc != null) {
                this.fvB = this.fvc.optString("TrademarkUrl");
            }
            String str = this.fvB;
            AppMethodBeat.m2505o(11284);
            return str;
        }

        public final String aee() {
            AppMethodBeat.m2504i(11285);
            if (this.fvc != null) {
                this.fvC = this.fvc.optString("TrademarkName");
            }
            String str = this.fvC;
            AppMethodBeat.m2505o(11285);
            return str;
        }

        public final String aef() {
            AppMethodBeat.m2504i(11286);
            if (this.fvc != null) {
                this.fvi = this.fvc.optString("ConferenceContactExpireTime");
            }
            String str = this.fvi;
            AppMethodBeat.m2505o(11286);
            return str;
        }

        public final List<C16533f> aeg() {
            AppMethodBeat.m2504i(11287);
            if (this.fvc != null && this.fvj == null) {
                this.fvj = C16533f.m25407d(this.fvc.optJSONArray("Privilege"));
            }
            List list = this.fvj;
            AppMethodBeat.m2505o(11287);
            return list;
        }

        public final int aeh() {
            AppMethodBeat.m2504i(11288);
            if (this.fvc != null) {
                this.fvv = this.fvc.optInt("InteractiveMode");
            }
            int i = this.fvv;
            AppMethodBeat.m2505o(11288);
            return i;
        }

        public final C16532e aei() {
            AppMethodBeat.m2504i(11289);
            if (this.fvc != null && this.fvm == null) {
                this.fvm = C16532e.m25406qN(this.fvc.optString("PayShowInfo"));
            }
            C16532e c16532e = this.fvm;
            AppMethodBeat.m2505o(11289);
            return c16532e;
        }

        public final C16536b aej() {
            AppMethodBeat.m2504i(11290);
            if (this.fvc != null && this.fvu == null) {
                String optString = this.fvc.optString("HardwareBizInfo");
                if (optString != null) {
                    this.fvu = C16536b.m25410qJ(optString);
                }
            }
            C16536b c16536b = this.fvu;
            AppMethodBeat.m2505o(11290);
            return c16536b;
        }

        public final C16531d aek() {
            AppMethodBeat.m2504i(11291);
            if (this.fvc != null && this.fvk == null) {
                this.fvk = C16531d.m25405qM(this.fvc.optString("VerifySource"));
            }
            C16531d c16531d = this.fvk;
            AppMethodBeat.m2505o(11291);
            return c16531d;
        }

        public final C16534g ael() {
            AppMethodBeat.m2504i(11292);
            if (this.fvc != null && this.fvA == null) {
                String optString = this.fvc.optString("RegisterSource");
                if (optString != null) {
                    this.fvA = C16534g.m25408qO(optString);
                }
            }
            C16534g c16534g = this.fvA;
            AppMethodBeat.m2505o(11292);
            return c16534g;
        }

        public final boolean adL() {
            boolean z = false;
            AppMethodBeat.m2504i(11293);
            if (this.fvc != null) {
                if (C5046bo.getInt(this.fvc.optString("ReportLocationType"), 0) > 0) {
                    z = true;
                }
                this.fvo = z;
            }
            z = this.fvo;
            AppMethodBeat.m2505o(11293);
            return z;
        }

        public final boolean aem() {
            boolean z = true;
            AppMethodBeat.m2504i(11294);
            if (this.fvc != null) {
                if (C5046bo.getInt(this.fvc.optString("IsTrademarkProtection"), 0) != 1) {
                    z = false;
                }
                this.fvy = z;
            }
            z = this.fvy;
            AppMethodBeat.m2505o(11294);
            return z;
        }

        public final int getServiceType() {
            AppMethodBeat.m2504i(11295);
            if (this.fvc != null) {
                this.fmr = this.fvc.optInt("ServiceType", 0);
            }
            int i = this.fmr;
            AppMethodBeat.m2505o(11295);
            return i;
        }

        public final String aen() {
            AppMethodBeat.m2504i(11296);
            if (this.fvc != null) {
                this.fvt = this.fvc.optString("SupportEmoticonLinkPrefix");
            }
            String str = this.fvt;
            AppMethodBeat.m2505o(11296);
            return str;
        }

        public final C16530c aeo() {
            AppMethodBeat.m2504i(11297);
            if (this.fvc != null && this.fvl == null) {
                String optString = this.fvc.optString("MMBizMenu");
                if (optString != null) {
                    this.fvl = C16530c.m25404qK(optString);
                }
            }
            C16530c c16530c = this.fvl;
            AppMethodBeat.m2505o(11297);
            return c16530c;
        }

        public final String aep() {
            AppMethodBeat.m2504i(11298);
            if (this.fvc != null) {
                this.fvx = this.fvc.optString("ServicePhone");
            }
            String str = this.fvx;
            AppMethodBeat.m2505o(11298);
            return str;
        }

        private C16529b() {
        }

        /* renamed from: qH */
        static C16529b m25403qH(String str) {
            AppMethodBeat.m2504i(11300);
            C16529b c16529b = new C16529b();
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(11300);
            } else {
                try {
                    System.currentTimeMillis();
                    c16529b.fvc = new JSONObject(str);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
                }
                AppMethodBeat.m2505o(11300);
            }
            return c16529b;
        }

        public final C8932a aer() {
            AppMethodBeat.m2504i(11301);
            if (this.fvc != null && this.fvn == null) {
                String optString = this.fvc.optString("EnterpriseBizInfo");
                if (optString != null) {
                    this.fvn = C8932a.m16102qL(optString);
                }
            }
            C8932a c8932a = this.fvn;
            AppMethodBeat.m2505o(11301);
            return c8932a;
        }

        public final boolean aeq() {
            AppMethodBeat.m2504i(11299);
            if (this.fvc != null) {
                this.fvz = this.fvc.optInt("FunctionFlag");
            }
            if ((this.fvz & C16527d.fuW) > 0) {
                AppMethodBeat.m2505o(11299);
                return true;
            }
            AppMethodBeat.m2505o(11299);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(11321);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[20];
        c4924a.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "brandList";
        c4924a.xDd.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "brandListVersion";
        c4924a.xDd.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "brandListContent";
        c4924a.xDd.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "brandFlag";
        c4924a.xDd.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = IssueStorage.COLUMN_EXT_INFO;
        c4924a.xDd.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "brandInfo";
        c4924a.xDd.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "brandIconURL";
        c4924a.xDd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[10] = "hadAlert";
        c4924a.xDd.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "acceptType";
        c4924a.xDd.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "type";
        c4924a.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "enterpriseFather";
        c4924a.xDd.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "kfWorkerId";
        c4924a.xDd.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "specialType";
        c4924a.xDd.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "attrSyncVersion";
        c4924a.xDd.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        c4924a.columns[18] = "incrementUpdateTime";
        c4924a.xDd.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[19] = "bitFlag";
        c4924a.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        c4924a.columns[20] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(11321);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: cJ */
    public final C16529b mo30481cJ(boolean z) {
        C16529b qH;
        AppMethodBeat.m2504i(11302);
        if (this.fuY == null || z) {
            if (C5046bo.isNullOrNil(this.field_extInfo) || fuZ != this.field_extInfo.hashCode()) {
                qH = C16529b.m25403qH(this.field_extInfo);
                this.fuY = qH;
                fva = qH;
                fuZ = C5046bo.nullAsNil(this.field_extInfo).hashCode();
            } else {
                this.fuY = fva;
            }
        }
        qH = this.fuY;
        AppMethodBeat.m2505o(11302);
        return qH;
    }

    public final boolean adH() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean adI() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean adJ() {
        AppMethodBeat.m2504i(11303);
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            AppMethodBeat.m2505o(11303);
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime < instance.getTimeInMillis()) {
            AppMethodBeat.m2505o(11303);
            return true;
        }
        AppMethodBeat.m2505o(11303);
        return false;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(11318);
        super.mo8995d(cursor);
        AppMethodBeat.m2505o(11318);
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        AppMethodBeat.m2504i(11319);
        ContentValues Hl = super.mo10098Hl();
        AppMethodBeat.m2505o(11319);
        return Hl;
    }

    public final List<C16528a> adY() {
        AppMethodBeat.m2504i(11320);
        if (this.fuX != null) {
            List list = this.fuX;
            AppMethodBeat.m2505o(11320);
            return list;
        }
        this.fuX = new LinkedList();
        List<C16528a> list2;
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            list2 = this.fuX;
            AppMethodBeat.m2505o(11320);
            return list2;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                C16528a c16528a = new C16528a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                c16528a.title = optJSONObject.optString("title");
                c16528a.url = optJSONObject.optString("url");
                c16528a.fvb = optJSONObject.optString("title_key");
                c16528a.description = optJSONObject.optString("description");
                this.fuX.add(c16528a);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BizInfo", "exception:%s", C5046bo.m7574l(e));
        }
        list2 = this.fuX;
        AppMethodBeat.m2505o(11320);
        return list2;
    }

    /* renamed from: lc */
    private boolean m25397lc(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    /* renamed from: ld */
    private void m25398ld(int i) {
        this.field_bitFlag |= i;
    }

    public final void adK() {
        AppMethodBeat.m2504i(11304);
        mo30481cJ(false);
        C16529b c16529b = this.fuY;
        if (c16529b.fvc != null) {
            c16529b.fvq = c16529b.fvc.optInt("ConnectorMsgType");
        }
        this.field_acceptType = c16529b.fvq;
        this.field_type = mo30481cJ(false).getServiceType();
        if (adR()) {
            m25398ld(1);
            AppMethodBeat.m2505o(11304);
            return;
        }
        this.field_bitFlag &= -2;
        AppMethodBeat.m2505o(11304);
    }

    public final boolean adL() {
        AppMethodBeat.m2504i(11305);
        mo30481cJ(false);
        C4990ab.m7417i("MicroMsg.BizInfo", "is report location, user %s %B", this.field_username, Boolean.valueOf(this.fuY.adL()));
        boolean adL = this.fuY.adL();
        AppMethodBeat.m2505o(11305);
        return adL;
    }

    public final boolean adM() {
        AppMethodBeat.m2504i(11306);
        mo30481cJ(false);
        if (this.field_type == 1) {
            AppMethodBeat.m2505o(11306);
            return true;
        }
        AppMethodBeat.m2505o(11306);
        return false;
    }

    public final boolean adN() {
        AppMethodBeat.m2504i(11307);
        mo30481cJ(false);
        if (this.field_type == 0) {
            AppMethodBeat.m2505o(11307);
            return true;
        }
        AppMethodBeat.m2505o(11307);
        return false;
    }

    public final boolean adO() {
        AppMethodBeat.m2504i(11308);
        mo30481cJ(false);
        if (this.field_type == 2 || this.field_type == 3) {
            AppMethodBeat.m2505o(11308);
            return true;
        }
        AppMethodBeat.m2505o(11308);
        return false;
    }

    public final boolean adP() {
        AppMethodBeat.m2504i(11309);
        mo30481cJ(false);
        if (this.field_type == 2) {
            AppMethodBeat.m2505o(11309);
            return true;
        }
        AppMethodBeat.m2505o(11309);
        return false;
    }

    public final boolean adQ() {
        AppMethodBeat.m2504i(11310);
        mo30481cJ(false);
        if (this.field_type == 3) {
            AppMethodBeat.m2505o(11310);
            return true;
        }
        AppMethodBeat.m2505o(11310);
        return false;
    }

    public final boolean adR() {
        boolean z;
        AppMethodBeat.m2504i(11311);
        mo30481cJ(false);
        if (this.fuY == null || this.fuY.aer() == null) {
            z = false;
        } else {
            z = this.fuY.fvn.fvO == 1;
            if (z && !m25397lc(1)) {
                m25398ld(1);
                C41747z.aeR().mo43726e(this);
            }
            if (z) {
                C4990ab.m7411d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", this.field_username);
            }
        }
        AppMethodBeat.m2505o(11311);
        return z;
    }

    public final boolean adS() {
        boolean z;
        AppMethodBeat.m2504i(11312);
        mo30481cJ(false);
        if (this.fuY == null || this.fuY.aer() == null) {
            z = false;
        } else {
            z = this.fuY.fvn.fvO == 2;
            if (z && !m25397lc(2)) {
                m25398ld(2);
                C41747z.aeR().mo43726e(this);
            }
            if (z) {
                C4990ab.m7411d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", this.field_username);
            }
        }
        AppMethodBeat.m2505o(11312);
        return z;
    }

    public final String adT() {
        AppMethodBeat.m2504i(11313);
        mo30481cJ(false);
        if (this.fuY != null) {
            C8932a aer = this.fuY.aer();
            if (!(aer == null || aer.fvP == null || aer.fvP.isEmpty())) {
                String str = aer.fvP;
                AppMethodBeat.m2505o(11313);
                return str;
            }
        }
        AppMethodBeat.m2505o(11313);
        return null;
    }

    public final long adU() {
        AppMethodBeat.m2504i(11314);
        mo30481cJ(false);
        if (this.fuY != null) {
            C8932a aer = this.fuY.aer();
            if (!(aer == null || aer.appid == 0)) {
                long j = aer.appid;
                AppMethodBeat.m2505o(11314);
                return j;
            }
        }
        AppMethodBeat.m2505o(11314);
        return 0;
    }

    public final boolean adV() {
        AppMethodBeat.m2504i(11315);
        mo30481cJ(false);
        if (this.fuY == null) {
            C4990ab.m7416i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
            AppMethodBeat.m2505o(11315);
            return true;
        } else if (this.fuY.ael() == null) {
            C4990ab.m7416i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
            AppMethodBeat.m2505o(11315);
            return true;
        } else if (this.fuY.ael().fwd) {
            AppMethodBeat.m2505o(11315);
            return false;
        } else {
            AppMethodBeat.m2505o(11315);
            return true;
        }
    }

    public final String adW() {
        AppMethodBeat.m2504i(11316);
        mo30481cJ(false);
        if (this.fuY != null) {
            C8932a aer = this.fuY.aer();
            if (aer != null) {
                String str = aer.fvQ;
                AppMethodBeat.m2505o(11316);
                return str;
            }
        }
        AppMethodBeat.m2505o(11316);
        return null;
    }

    public final String adX() {
        AppMethodBeat.m2504i(11317);
        String str = mo30481cJ(false).aer().fvM;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.BizInfo", "check father: %s, %s", this.field_username, str);
        }
        AppMethodBeat.m2505o(11317);
        return str;
    }
}
