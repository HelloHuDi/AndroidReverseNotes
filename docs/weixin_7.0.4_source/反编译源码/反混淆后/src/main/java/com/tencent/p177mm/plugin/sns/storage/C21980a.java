package com.tencent.p177mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.sns.storage.a */
public final class C21980a {
    public static int qTr = 0;
    public static int qTs = 1;
    public String cHz;
    public String hnw;
    public String qPj;
    public String qTA;
    public int qTB;
    public String qTC;
    public String qTD;
    public String qTE;
    public int qTF;
    public String qTG;
    public String qTH;
    public LinkedList<String> qTI;
    boolean qTJ;
    public String qTK;
    public String qTL;
    public String qTM;
    public HashMap<String, String> qTN;
    public C21981a qTO;
    public C21982b qTP;
    public String qTQ;
    public String qTR;
    public String qTS;
    public boolean qTT;
    public String qTU;
    public boolean qTV;
    public int qTt;
    public long qTu;
    public long qTv;
    public int qTw;
    public String qTx;
    public String qTy;
    public String qTz;

    /* renamed from: com.tencent.mm.plugin.sns.storage.a$a */
    public static class C21981a {
        public String appVersion;
        public String cBb;
        public String csu;
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.a$b */
    public static class C21982b {
        private List<C21983a> qTW = new ArrayList();
        public Map<String, List<C21983a>> qTX = new HashMap();

        /* renamed from: com.tencent.mm.plugin.sns.storage.a$b$a */
        public static class C21983a {
            public static int qTY = 101;
            public long qFI = 0;
            public String qTZ = "";
            public String qUa = "";
            public String qUb = "";
            public int qUc = 0;
            public long qUd = 0;

            public C21983a(String str, String str2, String str3, int i) {
                this.qTZ = str;
                this.qUa = str2;
                this.qUb = str3;
                this.qUc = i;
            }
        }

        public final List<C21983a> coJ() {
            Object obj;
            AppMethodBeat.m2504i(36894);
            String gw = C4988aa.m7403gw(C4996ah.getContext());
            if ("zh_CN".equals(gw) || "zh_TW".equals(gw) || "zh_HK".equals(gw)) {
                String obj2 = gw;
            } else {
                obj2 = "en";
            }
            if (!this.qTX.containsKey(obj2)) {
                ArrayList arrayList = new ArrayList();
                for (C21983a c21983a : this.qTW) {
                    if ("zh_CN".equals(obj2) && !C5046bo.isNullOrNil(c21983a.qTZ)) {
                        arrayList.add(c21983a);
                    } else if (("zh_TW".equals(obj2) || "zh_HK".equals(obj2)) && !C5046bo.isNullOrNil(c21983a.qUa)) {
                        arrayList.add(c21983a);
                    } else if ("en".equals(obj2) && !C5046bo.isNullOrNil(c21983a.qUb)) {
                        arrayList.add(c21983a);
                    }
                }
                this.qTX.put(obj2, arrayList);
            }
            List list = (List) this.qTX.get(obj2);
            AppMethodBeat.m2505o(36894);
            return list;
        }

        public C21982b() {
            AppMethodBeat.m2504i(36895);
            AppMethodBeat.m2505o(36895);
        }

        public C21982b(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(36896);
            String str2 = str + ".dislikeInfo.ReasonList";
            int i = 0;
            while (true) {
                String str3;
                int i2 = i;
                String str4 = str2 + ".Reason";
                if (i2 > 0) {
                    str3 = str4 + i2;
                } else {
                    str3 = str4;
                }
                if (map.get(str3 + ".ReasonId") != null) {
                    this.qTW.add(new C21983a(C5046bo.m7532bc((String) map.get(str3 + ".Wording.zh"), ""), C5046bo.m7532bc((String) map.get(str3 + ".Wording.tw"), ""), C5046bo.m7532bc((String) map.get(str3 + ".Wording.en"), ""), C5046bo.ank((String) map.get(str3 + ".ReasonId"))));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(36896);
                    return;
                }
            }
        }
    }

    public final boolean coI() {
        return this.qTw == 4 && this.qTO != null;
    }

    public C21980a() {
        AppMethodBeat.m2504i(36897);
        this.cHz = "";
        this.qPj = "";
        this.qTw = 0;
        this.qTx = "";
        this.qTy = "";
        this.qTz = "";
        this.qTA = "";
        this.qTB = 0;
        this.qTC = "";
        this.qTD = "";
        this.qTE = "";
        this.qTF = qTr;
        this.qTG = "";
        this.qTH = "";
        this.qTI = new LinkedList();
        this.qTM = "";
        this.qTP = new C21982b();
        this.qTQ = "";
        this.qTR = "";
        this.qTS = "";
        this.qTT = false;
        this.qTU = "";
        this.qTV = false;
        AppMethodBeat.m2505o(36897);
    }

    public C21980a(String str) {
        AppMethodBeat.m2504i(36898);
        this.cHz = "";
        this.qPj = "";
        this.qTw = 0;
        this.qTx = "";
        this.qTy = "";
        this.qTz = "";
        this.qTA = "";
        this.qTB = 0;
        this.qTC = "";
        this.qTD = "";
        this.qTE = "";
        this.qTF = qTr;
        this.qTG = "";
        this.qTH = "";
        this.qTI = new LinkedList();
        this.qTM = "";
        this.qTP = new C21982b();
        this.qTQ = "";
        this.qTR = "";
        this.qTS = "";
        this.qTT = false;
        this.qTU = "";
        this.qTV = false;
        this.qTJ = false;
        m33609YH(str);
        AppMethodBeat.m2505o(36898);
    }

    /* renamed from: YH */
    private void m33609YH(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(36899);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36899);
            return;
        }
        C4990ab.m7417i("MicroMsg.ADInfo", "feed xml %s", str);
        Map z2 = C5049br.m7595z(str, "ADInfo");
        if (z2 == null) {
            AppMethodBeat.m2505o(36899);
            return;
        }
        this.hnw = C5046bo.m7532bc((String) z2.get(".ADInfo.viewid"), "");
        if (z2.get(".ADInfo.ad_sns_pos") == null) {
            AppMethodBeat.m2505o(36899);
            return;
        }
        String bc;
        this.qTt = C5046bo.ank((String) z2.get(".ADInfo.ad_sns_pos"));
        this.qTu = C5046bo.anl((String) z2.get(".ADInfo.noExposureExpireTime"));
        this.qTv = C5046bo.anl((String) z2.get(".ADInfo.exposureNoActionExpireTime"));
        this.qPj = C5046bo.m7532bc((String) z2.get(".ADInfo.uxInfo"), "");
        this.qTw = C5046bo.ank((String) z2.get(".ADInfo.adActionType"));
        this.qTx = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionCardTitle"), "");
        this.qTy = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionCardTpId"), "");
        this.qTz = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionCardExt"), "");
        this.qTA = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionLink"), "");
        this.qTB = C5046bo.ank((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
        this.qTC = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
        this.qTD = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
        this.qTE = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
        String bc2 = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
        this.qTF = C5046bo.ank((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
        this.qTH = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
        if (this.qTF == qTs) {
            String bc3 = C5046bo.m7532bc((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
            String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
            this.qTI.clear();
            int i = 0;
            while (true) {
                if (i == 0) {
                    bc = C5046bo.m7532bc((String) z2.get(str2), "");
                } else {
                    bc = C5046bo.m7532bc((String) z2.get(str2 + i), "");
                }
                if (C5046bo.isNullOrNil(bc)) {
                    break;
                }
                this.qTI.add(bc);
                i++;
            }
            boolean z3 = bc3.indexOf("%s") >= 0;
            i = bc3.indexOf("%");
            int lastIndexOf = bc3.lastIndexOf("%");
            if (!C5046bo.isNullOrNil(bc3) && z3 && i == lastIndexOf) {
                this.qTG = bc3;
            } else {
                this.qTG = bc2;
                this.qTF = qTr;
            }
        } else {
            this.qTG = bc2;
            this.qTF = qTr;
        }
        this.qTJ = z2.containsKey(".ADInfo.adCanvasInfo");
        this.qTL = (String) z2.get(".ADInfo.session_data.aid");
        this.qTK = (String) z2.get(".ADInfo.session_data.trace_id");
        this.qTN = new HashMap();
        bc2 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
        int i2 = 0;
        while (true) {
            String str3;
            if (i2 == 0) {
                str3 = bc2;
            } else {
                str3 = bc2 + i2;
            }
            bc = (String) z2.get(str3 + ".cardTpId");
            str3 = (String) z2.get(str3 + ".cardExt");
            if (C5046bo.isNullOrNil(bc)) {
                break;
            }
            this.qTN.put(bc, str3);
            i2++;
        }
        Matcher matcher = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(str);
        if (matcher.find()) {
            bc = matcher.group();
            if (!C5046bo.isNullOrNil(bc)) {
                this.qTM = bc.replaceAll("</?adCanvasExt>", "");
            }
        }
        bc = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
        if (!TextUtils.isEmpty(bc)) {
            this.qTO = new C21981a();
            this.qTO.cBb = bc;
            this.qTO.appVersion = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
            this.qTO.csu = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
        }
        this.qTP = new C21982b(z2, ".ADInfo");
        this.qTQ = C5046bo.m7532bc((String) z2.get(".ADInfo.dislikeInfo.Title.zh"), "");
        this.qTS = C5046bo.m7532bc((String) z2.get(".ADInfo.dislikeInfo.Title.tw"), "");
        this.qTR = C5046bo.m7532bc((String) z2.get(".ADInfo.dislikeInfo.Title.en"), "");
        this.qTT = C5046bo.ank((String) z2.get(".ADInfo.dislikeInfo.forbidClick")) > 0;
        this.qTU = C5046bo.m7532bc((String) z2.get(".ADInfo.adInfoSyncBuffer"), "");
        if (C5046bo.ank((String) z2.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
            z = false;
        }
        this.qTV = z;
        AppMethodBeat.m2505o(36899);
    }
}
