package com.tencent.mm.plugin.sns.storage;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b {
    public String cHz = "";
    public String nickname;
    public String qTA;
    boolean qTJ;
    public int qUA;
    public int qUB;
    public long qUC;
    public Map<String, String> qUD = new HashMap();
    boolean qUE;
    public int qUF;
    public int qUG;
    public float qUH;
    public float qUI;
    public int qUJ;
    public int qUK;
    public int qUL;
    public String qUM;
    public float qUN;
    public float qUO;
    public float qUP;
    public float qUQ;
    public int qUR;
    public String qUS;
    public String qUT;
    public String qUU;
    public String qUV;
    public List<String> qUW = new ArrayList();
    public e qUX;
    public c qUY;
    public a qUZ;
    public int qUe;
    public String qUf;
    public int qUg = 0;
    public int qUh = 0;
    public String qUi = "";
    public String qUj = "";
    public String qUk = "";
    public String qUl = "";
    public String qUm = "";
    public int qUn = 0;
    public String qUo = "";
    public String qUp = "";
    public int qUq = 0;
    public String qUr = "";
    public int qUs = 0;
    public String qUt = "";
    public String qUu = "";
    public String qUv = "";
    public String qUw = "";
    public String qUx = "";
    public String qUy = "";
    public int qUz;
    public boolean qVa;
    public String qVb;
    public String qVc;
    public int qVd;
    public int qVe;
    public String qVf;
    private d qVg;
    public f qVh;

    public static class a {
        public List<b> list = new LinkedList();

        public a() {
            AppMethodBeat.i(36900);
            AppMethodBeat.o(36900);
        }

        public final a q(Map<String, String> map, String str) {
            AppMethodBeat.i(36901);
            String str2 = str + ".adxml.feedbackInfo.feedbackList.item";
            int i = 0;
            while (true) {
                String str3;
                if (i > 0) {
                    str3 = str2 + i;
                } else {
                    str3 = str2;
                }
                String str4 = str3 + ".url";
                if (map.get(str4) == null || ((String) map.get(str4)).length() <= 0) {
                    AppMethodBeat.o(36901);
                } else {
                    b bVar = new b();
                    bVar.url = bo.bc((String) map.get(str4), "");
                    bVar.qVi = bo.bc((String) map.get(str3 + ".Wording.zh"), "");
                    bVar.qOI = bo.bc((String) map.get(str3 + ".Wording.en"), "");
                    bVar.qVj = bo.bc((String) map.get(str3 + ".Wording.tw"), "");
                    if ((bVar.qVi.length() + bVar.qOI.length()) + bVar.qVj.length() > 0) {
                        this.list.add(bVar);
                    }
                    i++;
                }
            }
            AppMethodBeat.o(36901);
            return this;
        }
    }

    public class d {
        public String qVq;
        public String qVr;
    }

    public static class b {
        public String qOI = "";
        public String qVi = "";
        public String qVj = "";
        public String url = "";
    }

    public static class c {
        public String description;
        public int qVk;
        public int qVl = 30;
        public int qVm;
        public a qVn;
        public String title;

        public static class a {
            public int color;
            public long endTime;
            public float qVo;
            public String qVp;
            public long startTime;
        }
    }

    public static class e {
        public String appVersion;
        public String cBb;
        public String csu;
        public String qTA = "";
        public List<h> qVt = new ArrayList();

        public e() {
            AppMethodBeat.i(36902);
            AppMethodBeat.o(36902);
        }

        public final void r(Map<String, String> map, String str) {
            AppMethodBeat.i(36903);
            this.qTA = bo.bc((String) map.get(str + ".adxml.adTurnActionLink"), "");
            String str2 = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appUserName");
            if (!TextUtils.isEmpty(str2)) {
                this.cBb = str2;
                this.appVersion = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appVersion");
                this.csu = (String) map.get(str + ".adxml.adTurnActionExtWeApp.relativePagePath");
            }
            String str3 = str + ".adxml.adTurnInfo.materialInfo";
            int i = 0;
            while (true) {
                String str4;
                if (i > 0) {
                    str4 = str3 + i;
                } else {
                    str4 = str3;
                }
                if (map.get(str4 + ".displayType") == null || ((String) map.get(str4 + ".displayType")).length() <= 0) {
                    AppMethodBeat.o(36903);
                } else {
                    h hVar = new h();
                    hVar.title = bo.bc((String) map.get(str4 + ".title"), "");
                    hVar.desc = bo.bc((String) map.get(str4 + ".desc"), "");
                    hVar.qVk = bo.ank((String) map.get(str4 + ".displayType"));
                    this.qVt.add(hVar);
                    i++;
                }
            }
            AppMethodBeat.o(36903);
        }
    }

    public class f {
        public String qVu = "";
        public ArrayList<g> qVv = new ArrayList();

        public f() {
            AppMethodBeat.i(36904);
            AppMethodBeat.o(36904);
        }

        public final String Dl(int i) {
            AppMethodBeat.i(36905);
            String str;
            if (i < 0 || i >= this.qVv.size()) {
                str = "";
                AppMethodBeat.o(36905);
                return str;
            }
            str = ((g) this.qVv.get(i)).qVy;
            AppMethodBeat.o(36905);
            return str;
        }

        public final String Dm(int i) {
            AppMethodBeat.i(36906);
            String str;
            if (i < 0 || i >= this.qVv.size()) {
                str = "";
                AppMethodBeat.o(36906);
                return str;
            }
            str = ((g) this.qVv.get(i)).title;
            AppMethodBeat.o(36906);
            return str;
        }
    }

    public class g {
        public String lvA = "";
        public String qVw = "";
        public String qVx = "";
        public String qVy = "";
        public String title = "";
    }

    public static class h {
        public String desc;
        public int qVk = 0;
        public String title;
    }

    public b(String str) {
        AppMethodBeat.i(36907);
        if (bo.isNullOrNil(str) || !str.trim().startsWith("<RecXml")) {
            ah(str, "", "adxml");
            AppMethodBeat.o(36907);
            return;
        }
        Map ah = ah(str, ".RecXml", "RecXml");
        if (!(ah == null || ah.isEmpty())) {
            this.qUz = bo.ank((String) ah.get(".RecXml.$type"));
            this.qUA = bo.ank((String) ah.get(".RecXml.$source"));
            this.qUB = bo.ank((String) ah.get(".RecXml.$expId"));
            this.qUC = i.Xq((String) ah.get(".RecXml.$expOriginSnsId"));
        }
        AppMethodBeat.o(36907);
    }

    private Map<String, String> ah(String str, String str2, String str3) {
        AppMethodBeat.i(36908);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str3)) {
            AppMethodBeat.o(36908);
            return null;
        }
        this.cHz = str;
        ab.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", str, str2, str3);
        Map<String, String> z = br.z(str, str3);
        if (z == null) {
            AppMethodBeat.o(36908);
            return null;
        }
        String str4;
        String str5;
        String str6;
        this.qUe = bo.ank((String) z.get(str2 + ".adxml.adType"));
        this.qUf = bo.bc((String) z.get(str2 + ".adxml.adActionTitle"), "");
        this.qTA = bo.bc((String) z.get(str2 + ".adxml.adActionLink"), "");
        this.nickname = bo.bc((String) z.get(str2 + ".adxml.nickname"), "");
        this.qUg = bo.ank((String) z.get(str2 + ".adxml.webviewRightBarShow"));
        this.qUh = bo.ank((String) z.get(str2 + ".adxml.adActionLinkHidden"));
        this.qUi = bo.bc((String) z.get(str2 + ".adxml.adActionLinkName"), "");
        this.qUj = bo.bc((String) z.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.qUk = bo.bc((String) z.get(str2 + ".adxml.adActionLinkTitle.zh"), "");
        this.qUm = bo.bc((String) z.get(str2 + ".adxml.adActionLinkTitle.tw"), "");
        this.qUl = bo.bc((String) z.get(str2 + ".adxml.adActionLinkTitle.en"), "");
        this.qUo = bo.bc((String) z.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.qUp = bo.bc((String) z.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.qUn = bo.ank((String) z.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (bo.isNullOrNil(this.qUo) || bo.isNullOrNil(this.qUp)) {
            this.qUn = 1;
        }
        this.qUt = bo.bc((String) z.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.qUv = bo.bc((String) z.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.qUu = bo.bc((String) z.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.qUw = bo.bc((String) z.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.qUy = bo.bc((String) z.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.qUx = bo.bc((String) z.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.qUq = bo.ank((String) z.get(str2 + ".adxml.headClickType"));
        this.qUr = bo.bc((String) z.get(str2 + ".adxml.headClickParam"), "");
        this.qUs = bo.ank((String) z.get(str2 + ".adxml.headClickRightBarShow"));
        int i = 0;
        while (true) {
            int i2 = i;
            String str7 = str2 + ".adxml.adArgs.arg" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".key";
            str4 = (String) z.get(str7);
            if (str4 == null) {
                break;
            }
            String str8 = str2 + ".adxml.adArgs.arg" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".value";
            str5 = (String) z.get(str8);
            ab.i("MicroMsg.ADXml", "newKey " + str7 + " " + str4 + " newValue : " + str8 + " " + str5);
            this.qUD.put(str4, str5);
            i = i2 + 1;
        }
        this.qTJ = z.containsKey(str2 + ".adxml.adCanvasInfo");
        this.qVa = bo.ank((String) z.get(new StringBuilder().append(str2).append(".adxml.usePreferedInfo").toString())) == 1;
        this.qVb = bo.nullAsNil((String) z.get(str2 + ".adxml.preferNickname"));
        this.qVc = bo.nullAsNil((String) z.get(str2 + ".adxml.preferAvatar"));
        this.qUF = bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.qUG = bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.qUH = (float) bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.qUI = (float) bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.qUL = bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.qUM = bo.bc((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.qUJ = bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.qUK = bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.qUN = (float) bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.qUO = (float) bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.qUP = (float) bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.qUQ = (float) bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.qUR = bo.ank((String) z.get(str2 + ".adxml.adContentStyle"));
        this.qUS = bo.bc((String) z.get(str2 + ".adxml.adCardInfo.title"), "");
        this.qUT = bo.bc((String) z.get(str2 + ".adxml.adCardInfo.description"), "");
        i = 0;
        while (true) {
            int i3 = i;
            str6 = str2 + ".adxml.adCardInfo.adRatingCardInfo.tagList.tag" + (i3 == 0 ? "" : Integer.valueOf(i3));
            if (!z.containsKey(str6)) {
                break;
            }
            ab.i("MicroMsg.ADXml", "card ad tag %s", z.get(str6));
            if (!bo.isNullOrNil((String) z.get(str6))) {
                this.qUW.add(z.get(str6));
            }
            i = i3 + 1;
        }
        this.qUU = bo.nullAsNil((String) z.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
        this.qUV = bo.nullAsNil((String) z.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
        str5 = bo.bc((String) z.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        str4 = bo.bc((String) z.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!(TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4))) {
            this.qVg = new d();
            this.qVg.qVq = str5;
            this.qVg.qVr = str4;
        }
        str4 = bo.bc((String) z.get(str2 + ".adxml.adVoteInfo.componentUrl"), "");
        if (!TextUtils.isEmpty(str4)) {
            this.qVh = new f();
            this.qVh.qVu = str4;
            str6 = str2 + ".adxml.adVoteInfo.optionList.option";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str5 = str6 + i4;
                } else {
                    str5 = str6;
                }
                if (TextUtils.isEmpty(bo.bc((String) z.get(str5 + ".title"), ""))) {
                    break;
                }
                g gVar = new g();
                gVar.title = bo.bc((String) z.get(str5 + ".title"), "");
                gVar.lvA = bo.bc((String) z.get(str5 + ".shareTitle"), "");
                gVar.qVw = bo.bc((String) z.get(str5 + ".shareDesc"), "");
                gVar.qVx = bo.bc((String) z.get(str5 + ".shareThumb"), "");
                gVar.qVy = bo.bc((String) z.get(str5 + ".selectedTitle"), "");
                this.qVh.qVv.add(gVar);
                i4++;
            }
        }
        this.qUE = z.containsKey(str2 + ".adxml.adTurnCanvasInfo");
        this.qUX = new e();
        this.qUX.r(z, str2);
        this.qUZ = new a().q(z, str2);
        if (this.qUR == 3) {
            this.qUY = new c();
            str5 = str2 + ".adxml.adFullCardInfo";
            c cVar = this.qUY;
            cVar.qVk = bo.ank((String) z.get(str5 + ".displayType"));
            cVar.title = bo.nullAsNil((String) z.get(str5 + ".title"));
            cVar.description = bo.nullAsNil((String) z.get(str5 + ".description"));
            cVar.qVl = bo.getInt((String) z.get(str5 + ".markMaxAlpha"), 30);
            cVar.qVm = bo.ank((String) z.get(str5 + ".titlePosition"));
            if (!bo.isNullOrNil((String) z.get(str5 + ".adGestureInfo.points"))) {
                cVar.qVn = new a();
                cVar.qVn.color = -1;
                cVar.qVn.startTime = (long) bo.ank((String) z.get(str5 + ".adGestureInfo.startTime"));
                cVar.qVn.endTime = (long) bo.ank((String) z.get(str5 + ".adGestureInfo.endTime"));
                cVar.qVn.qVo = bo.ann((String) z.get(str5 + ".adGestureInfo.distance"));
                cVar.qVn.color = Color.parseColor(bo.nullAsNil((String) z.get(str5 + ".adGestureInfo.color")));
                cVar.qVn.qVp = bo.nullAsNil((String) z.get(str5 + ".adGestureInfo.points"));
            }
        }
        this.qVd = bo.ank((String) z.get(str2 + ".adxml.compatible.clientVersion.androidMin"));
        this.qVe = bo.ank((String) z.get(str2 + ".adxml.compatible.clientVersion.androidMax"));
        this.qVf = bo.nullAsNil((String) z.get(str2 + ".adxml.compatible.jumpUrl"));
        AppMethodBeat.o(36908);
        return z;
    }

    public final boolean coK() {
        return this.qTJ || this.qUE;
    }

    public final String coL() {
        AppMethodBeat.i(36909);
        String str;
        if (coR()) {
            str = this.qVg.qVq;
            AppMethodBeat.o(36909);
            return str;
        } else if (coS()) {
            str = ((g) this.qVh.qVv.get(0)).title;
            AppMethodBeat.o(36909);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(36909);
            return str;
        }
    }

    public final String coM() {
        AppMethodBeat.i(36910);
        String str;
        if (coR()) {
            str = this.qVg.qVr;
            AppMethodBeat.o(36910);
            return str;
        } else if (coS()) {
            str = ((g) this.qVh.qVv.get(1)).title;
            AppMethodBeat.o(36910);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(36910);
            return str;
        }
    }

    public final String coN() {
        AppMethodBeat.i(36911);
        String str;
        if (coS()) {
            str = this.qVh.qVu;
            AppMethodBeat.o(36911);
            return str;
        }
        str = "";
        AppMethodBeat.o(36911);
        return str;
    }

    public final boolean coO() {
        return this.qUR == 2;
    }

    public final boolean coP() {
        return this.qUR == 1;
    }

    public final boolean coQ() {
        return this.qUR == 3;
    }

    public final boolean coR() {
        return this.qVg != null;
    }

    public final boolean coS() {
        AppMethodBeat.i(36912);
        if (this.qVh == null || this.qVh.qVv.size() <= 1) {
            AppMethodBeat.o(36912);
            return false;
        }
        AppMethodBeat.o(36912);
        return true;
    }

    public final String coT() {
        AppMethodBeat.i(36913);
        String str = this.cHz;
        if (str.contains("<adCanvasInfoLeft>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
        }
        AppMethodBeat.o(36913);
        return str;
    }

    public final String coU() {
        AppMethodBeat.i(36914);
        String str = this.cHz;
        if (str.contains("<adCanvasInfoRight>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
        }
        AppMethodBeat.o(36914);
        return str;
    }

    public final String coV() {
        AppMethodBeat.i(36915);
        String str = this.cHz;
        if (str.contains("<adTurnCanvasInfo>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
        }
        AppMethodBeat.o(36915);
        return str;
    }

    public final String coW() {
        AppMethodBeat.i(36916);
        String str = this.cHz;
        if (this.qUY == null || !str.contains("<adFullCardGestureCanvasInfo>")) {
            str = "";
        } else {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");
        }
        AppMethodBeat.o(36916);
        return str;
    }

    public final boolean coX() {
        return this.qUA == 2;
    }
}
