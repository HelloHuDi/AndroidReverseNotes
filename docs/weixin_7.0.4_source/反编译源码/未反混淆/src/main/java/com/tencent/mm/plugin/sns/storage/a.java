package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
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
    public a qTO;
    public b qTP;
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

    public static class a {
        public String appVersion;
        public String cBb;
        public String csu;
    }

    public static class b {
        private List<a> qTW = new ArrayList();
        public Map<String, List<a>> qTX = new HashMap();

        public static class a {
            public static int qTY = 101;
            public long qFI = 0;
            public String qTZ = "";
            public String qUa = "";
            public String qUb = "";
            public int qUc = 0;
            public long qUd = 0;

            public a(String str, String str2, String str3, int i) {
                this.qTZ = str;
                this.qUa = str2;
                this.qUb = str3;
                this.qUc = i;
            }
        }

        public final List<a> coJ() {
            Object obj;
            AppMethodBeat.i(36894);
            String gw = aa.gw(ah.getContext());
            if ("zh_CN".equals(gw) || "zh_TW".equals(gw) || "zh_HK".equals(gw)) {
                String obj2 = gw;
            } else {
                obj2 = "en";
            }
            if (!this.qTX.containsKey(obj2)) {
                ArrayList arrayList = new ArrayList();
                for (a aVar : this.qTW) {
                    if ("zh_CN".equals(obj2) && !bo.isNullOrNil(aVar.qTZ)) {
                        arrayList.add(aVar);
                    } else if (("zh_TW".equals(obj2) || "zh_HK".equals(obj2)) && !bo.isNullOrNil(aVar.qUa)) {
                        arrayList.add(aVar);
                    } else if ("en".equals(obj2) && !bo.isNullOrNil(aVar.qUb)) {
                        arrayList.add(aVar);
                    }
                }
                this.qTX.put(obj2, arrayList);
            }
            List list = (List) this.qTX.get(obj2);
            AppMethodBeat.o(36894);
            return list;
        }

        public b() {
            AppMethodBeat.i(36895);
            AppMethodBeat.o(36895);
        }

        public b(Map<String, String> map, String str) {
            AppMethodBeat.i(36896);
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
                    this.qTW.add(new a(bo.bc((String) map.get(str3 + ".Wording.zh"), ""), bo.bc((String) map.get(str3 + ".Wording.tw"), ""), bo.bc((String) map.get(str3 + ".Wording.en"), ""), bo.ank((String) map.get(str3 + ".ReasonId"))));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(36896);
                    return;
                }
            }
        }
    }

    public final boolean coI() {
        return this.qTw == 4 && this.qTO != null;
    }

    public a() {
        AppMethodBeat.i(36897);
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
        this.qTP = new b();
        this.qTQ = "";
        this.qTR = "";
        this.qTS = "";
        this.qTT = false;
        this.qTU = "";
        this.qTV = false;
        AppMethodBeat.o(36897);
    }

    public a(String str) {
        AppMethodBeat.i(36898);
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
        this.qTP = new b();
        this.qTQ = "";
        this.qTR = "";
        this.qTS = "";
        this.qTT = false;
        this.qTU = "";
        this.qTV = false;
        this.qTJ = false;
        YH(str);
        AppMethodBeat.o(36898);
    }

    private void YH(String str) {
        boolean z = true;
        AppMethodBeat.i(36899);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36899);
            return;
        }
        ab.i("MicroMsg.ADInfo", "feed xml %s", str);
        Map z2 = br.z(str, "ADInfo");
        if (z2 == null) {
            AppMethodBeat.o(36899);
            return;
        }
        this.hnw = bo.bc((String) z2.get(".ADInfo.viewid"), "");
        if (z2.get(".ADInfo.ad_sns_pos") == null) {
            AppMethodBeat.o(36899);
            return;
        }
        String bc;
        this.qTt = bo.ank((String) z2.get(".ADInfo.ad_sns_pos"));
        this.qTu = bo.anl((String) z2.get(".ADInfo.noExposureExpireTime"));
        this.qTv = bo.anl((String) z2.get(".ADInfo.exposureNoActionExpireTime"));
        this.qPj = bo.bc((String) z2.get(".ADInfo.uxInfo"), "");
        this.qTw = bo.ank((String) z2.get(".ADInfo.adActionType"));
        this.qTx = bo.bc((String) z2.get(".ADInfo.adActionCardTitle"), "");
        this.qTy = bo.bc((String) z2.get(".ADInfo.adActionCardTpId"), "");
        this.qTz = bo.bc((String) z2.get(".ADInfo.adActionCardExt"), "");
        this.qTA = bo.bc((String) z2.get(".ADInfo.adActionLink"), "");
        this.qTB = bo.ank((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
        this.qTC = bo.bc((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
        this.qTD = bo.bc((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
        this.qTE = bo.bc((String) z2.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
        String bc2 = bo.bc((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
        this.qTF = bo.ank((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
        this.qTH = bo.bc((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
        if (this.qTF == qTs) {
            String bc3 = bo.bc((String) z2.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
            String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
            this.qTI.clear();
            int i = 0;
            while (true) {
                if (i == 0) {
                    bc = bo.bc((String) z2.get(str2), "");
                } else {
                    bc = bo.bc((String) z2.get(str2 + i), "");
                }
                if (bo.isNullOrNil(bc)) {
                    break;
                }
                this.qTI.add(bc);
                i++;
            }
            boolean z3 = bc3.indexOf("%s") >= 0;
            i = bc3.indexOf("%");
            int lastIndexOf = bc3.lastIndexOf("%");
            if (!bo.isNullOrNil(bc3) && z3 && i == lastIndexOf) {
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
            if (bo.isNullOrNil(bc)) {
                break;
            }
            this.qTN.put(bc, str3);
            i2++;
        }
        Matcher matcher = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(str);
        if (matcher.find()) {
            bc = matcher.group();
            if (!bo.isNullOrNil(bc)) {
                this.qTM = bc.replaceAll("</?adCanvasExt>", "");
            }
        }
        bc = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
        if (!TextUtils.isEmpty(bc)) {
            this.qTO = new a();
            this.qTO.cBb = bc;
            this.qTO.appVersion = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
            this.qTO.csu = (String) z2.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
        }
        this.qTP = new b(z2, ".ADInfo");
        this.qTQ = bo.bc((String) z2.get(".ADInfo.dislikeInfo.Title.zh"), "");
        this.qTS = bo.bc((String) z2.get(".ADInfo.dislikeInfo.Title.tw"), "");
        this.qTR = bo.bc((String) z2.get(".ADInfo.dislikeInfo.Title.en"), "");
        this.qTT = bo.ank((String) z2.get(".ADInfo.dislikeInfo.forbidClick")) > 0;
        this.qTU = bo.bc((String) z2.get(".ADInfo.adInfoSyncBuffer"), "");
        if (bo.ank((String) z2.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
            z = false;
        }
        this.qTV = z;
        AppMethodBeat.o(36899);
    }
}
