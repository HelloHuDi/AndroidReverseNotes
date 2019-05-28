package com.tencent.p177mm.plugin.sns.storage;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.storage.b */
public final class C21984b {
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
    public C21985e qUX;
    public C13475c qUY;
    public C3956a qUZ;
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
    private C3957d qVg;
    public C21986f qVh;

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$a */
    public static class C3956a {
        public List<C13474b> list = new LinkedList();

        public C3956a() {
            AppMethodBeat.m2504i(36900);
            AppMethodBeat.m2505o(36900);
        }

        /* renamed from: q */
        public final C3956a mo8726q(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(36901);
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
                    AppMethodBeat.m2505o(36901);
                } else {
                    C13474b c13474b = new C13474b();
                    c13474b.url = C5046bo.m7532bc((String) map.get(str4), "");
                    c13474b.qVi = C5046bo.m7532bc((String) map.get(str3 + ".Wording.zh"), "");
                    c13474b.qOI = C5046bo.m7532bc((String) map.get(str3 + ".Wording.en"), "");
                    c13474b.qVj = C5046bo.m7532bc((String) map.get(str3 + ".Wording.tw"), "");
                    if ((c13474b.qVi.length() + c13474b.qOI.length()) + c13474b.qVj.length() > 0) {
                        this.list.add(c13474b);
                    }
                    i++;
                }
            }
            AppMethodBeat.m2505o(36901);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$d */
    public class C3957d {
        public String qVq;
        public String qVr;
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$b */
    public static class C13474b {
        public String qOI = "";
        public String qVi = "";
        public String qVj = "";
        public String url = "";
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$c */
    public static class C13475c {
        public String description;
        public int qVk;
        public int qVl = 30;
        public int qVm;
        public C13476a qVn;
        public String title;

        /* renamed from: com.tencent.mm.plugin.sns.storage.b$c$a */
        public static class C13476a {
            public int color;
            public long endTime;
            public float qVo;
            public String qVp;
            public long startTime;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$e */
    public static class C21985e {
        public String appVersion;
        public String cBb;
        public String csu;
        public String qTA = "";
        public List<C21988h> qVt = new ArrayList();

        public C21985e() {
            AppMethodBeat.m2504i(36902);
            AppMethodBeat.m2505o(36902);
        }

        /* renamed from: r */
        public final void mo37530r(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(36903);
            this.qTA = C5046bo.m7532bc((String) map.get(str + ".adxml.adTurnActionLink"), "");
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
                    AppMethodBeat.m2505o(36903);
                } else {
                    C21988h c21988h = new C21988h();
                    c21988h.title = C5046bo.m7532bc((String) map.get(str4 + ".title"), "");
                    c21988h.desc = C5046bo.m7532bc((String) map.get(str4 + ".desc"), "");
                    c21988h.qVk = C5046bo.ank((String) map.get(str4 + ".displayType"));
                    this.qVt.add(c21988h);
                    i++;
                }
            }
            AppMethodBeat.m2505o(36903);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$f */
    public class C21986f {
        public String qVu = "";
        public ArrayList<C21987g> qVv = new ArrayList();

        public C21986f() {
            AppMethodBeat.m2504i(36904);
            AppMethodBeat.m2505o(36904);
        }

        /* renamed from: Dl */
        public final String mo37531Dl(int i) {
            AppMethodBeat.m2504i(36905);
            String str;
            if (i < 0 || i >= this.qVv.size()) {
                str = "";
                AppMethodBeat.m2505o(36905);
                return str;
            }
            str = ((C21987g) this.qVv.get(i)).qVy;
            AppMethodBeat.m2505o(36905);
            return str;
        }

        /* renamed from: Dm */
        public final String mo37532Dm(int i) {
            AppMethodBeat.m2504i(36906);
            String str;
            if (i < 0 || i >= this.qVv.size()) {
                str = "";
                AppMethodBeat.m2505o(36906);
                return str;
            }
            str = ((C21987g) this.qVv.get(i)).title;
            AppMethodBeat.m2505o(36906);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$g */
    public class C21987g {
        public String lvA = "";
        public String qVw = "";
        public String qVx = "";
        public String qVy = "";
        public String title = "";
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.b$h */
    public static class C21988h {
        public String desc;
        public int qVk = 0;
        public String title;
    }

    public C21984b(String str) {
        AppMethodBeat.m2504i(36907);
        if (C5046bo.isNullOrNil(str) || !str.trim().startsWith("<RecXml")) {
            m33610ah(str, "", "adxml");
            AppMethodBeat.m2505o(36907);
            return;
        }
        Map ah = m33610ah(str, ".RecXml", "RecXml");
        if (!(ah == null || ah.isEmpty())) {
            this.qUz = C5046bo.ank((String) ah.get(".RecXml.$type"));
            this.qUA = C5046bo.ank((String) ah.get(".RecXml.$source"));
            this.qUB = C5046bo.ank((String) ah.get(".RecXml.$expId"));
            this.qUC = C29036i.m46094Xq((String) ah.get(".RecXml.$expOriginSnsId"));
        }
        AppMethodBeat.m2505o(36907);
    }

    /* renamed from: ah */
    private Map<String, String> m33610ah(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36908);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(36908);
            return null;
        }
        this.cHz = str;
        C4990ab.m7417i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", str, str2, str3);
        Map<String, String> z = C5049br.m7595z(str, str3);
        if (z == null) {
            AppMethodBeat.m2505o(36908);
            return null;
        }
        String str4;
        String str5;
        String str6;
        this.qUe = C5046bo.ank((String) z.get(str2 + ".adxml.adType"));
        this.qUf = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionTitle"), "");
        this.qTA = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionLink"), "");
        this.nickname = C5046bo.m7532bc((String) z.get(str2 + ".adxml.nickname"), "");
        this.qUg = C5046bo.ank((String) z.get(str2 + ".adxml.webviewRightBarShow"));
        this.qUh = C5046bo.ank((String) z.get(str2 + ".adxml.adActionLinkHidden"));
        this.qUi = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionLinkName"), "");
        this.qUj = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.qUk = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionLinkTitle.zh"), "");
        this.qUm = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionLinkTitle.tw"), "");
        this.qUl = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adActionLinkTitle.en"), "");
        this.qUo = C5046bo.m7532bc((String) z.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.qUp = C5046bo.m7532bc((String) z.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.qUn = C5046bo.ank((String) z.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (C5046bo.isNullOrNil(this.qUo) || C5046bo.isNullOrNil(this.qUp)) {
            this.qUn = 1;
        }
        this.qUt = C5046bo.m7532bc((String) z.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.qUv = C5046bo.m7532bc((String) z.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.qUu = C5046bo.m7532bc((String) z.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.qUw = C5046bo.m7532bc((String) z.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.qUy = C5046bo.m7532bc((String) z.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.qUx = C5046bo.m7532bc((String) z.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.qUq = C5046bo.ank((String) z.get(str2 + ".adxml.headClickType"));
        this.qUr = C5046bo.m7532bc((String) z.get(str2 + ".adxml.headClickParam"), "");
        this.qUs = C5046bo.ank((String) z.get(str2 + ".adxml.headClickRightBarShow"));
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
            C4990ab.m7416i("MicroMsg.ADXml", "newKey " + str7 + " " + str4 + " newValue : " + str8 + " " + str5);
            this.qUD.put(str4, str5);
            i = i2 + 1;
        }
        this.qTJ = z.containsKey(str2 + ".adxml.adCanvasInfo");
        this.qVa = C5046bo.ank((String) z.get(new StringBuilder().append(str2).append(".adxml.usePreferedInfo").toString())) == 1;
        this.qVb = C5046bo.nullAsNil((String) z.get(str2 + ".adxml.preferNickname"));
        this.qVc = C5046bo.nullAsNil((String) z.get(str2 + ".adxml.preferAvatar"));
        this.qUF = C5046bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.qUG = C5046bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.qUH = (float) C5046bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.qUI = (float) C5046bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.qUL = C5046bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.qUM = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.qUJ = C5046bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.qUK = C5046bo.ank((String) z.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.qUN = (float) C5046bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.qUO = (float) C5046bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.qUP = (float) C5046bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.qUQ = (float) C5046bo.anm((String) z.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.qUR = C5046bo.ank((String) z.get(str2 + ".adxml.adContentStyle"));
        this.qUS = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adCardInfo.title"), "");
        this.qUT = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adCardInfo.description"), "");
        i = 0;
        while (true) {
            int i3 = i;
            str6 = str2 + ".adxml.adCardInfo.adRatingCardInfo.tagList.tag" + (i3 == 0 ? "" : Integer.valueOf(i3));
            if (!z.containsKey(str6)) {
                break;
            }
            C4990ab.m7417i("MicroMsg.ADXml", "card ad tag %s", z.get(str6));
            if (!C5046bo.isNullOrNil((String) z.get(str6))) {
                this.qUW.add(z.get(str6));
            }
            i = i3 + 1;
        }
        this.qUU = C5046bo.nullAsNil((String) z.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
        this.qUV = C5046bo.nullAsNil((String) z.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
        str5 = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        str4 = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!(TextUtils.isEmpty(str5) || TextUtils.isEmpty(str4))) {
            this.qVg = new C3957d();
            this.qVg.qVq = str5;
            this.qVg.qVr = str4;
        }
        str4 = C5046bo.m7532bc((String) z.get(str2 + ".adxml.adVoteInfo.componentUrl"), "");
        if (!TextUtils.isEmpty(str4)) {
            this.qVh = new C21986f();
            this.qVh.qVu = str4;
            str6 = str2 + ".adxml.adVoteInfo.optionList.option";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str5 = str6 + i4;
                } else {
                    str5 = str6;
                }
                if (TextUtils.isEmpty(C5046bo.m7532bc((String) z.get(str5 + ".title"), ""))) {
                    break;
                }
                C21987g c21987g = new C21987g();
                c21987g.title = C5046bo.m7532bc((String) z.get(str5 + ".title"), "");
                c21987g.lvA = C5046bo.m7532bc((String) z.get(str5 + ".shareTitle"), "");
                c21987g.qVw = C5046bo.m7532bc((String) z.get(str5 + ".shareDesc"), "");
                c21987g.qVx = C5046bo.m7532bc((String) z.get(str5 + ".shareThumb"), "");
                c21987g.qVy = C5046bo.m7532bc((String) z.get(str5 + ".selectedTitle"), "");
                this.qVh.qVv.add(c21987g);
                i4++;
            }
        }
        this.qUE = z.containsKey(str2 + ".adxml.adTurnCanvasInfo");
        this.qUX = new C21985e();
        this.qUX.mo37530r(z, str2);
        this.qUZ = new C3956a().mo8726q(z, str2);
        if (this.qUR == 3) {
            this.qUY = new C13475c();
            str5 = str2 + ".adxml.adFullCardInfo";
            C13475c c13475c = this.qUY;
            c13475c.qVk = C5046bo.ank((String) z.get(str5 + ".displayType"));
            c13475c.title = C5046bo.nullAsNil((String) z.get(str5 + ".title"));
            c13475c.description = C5046bo.nullAsNil((String) z.get(str5 + ".description"));
            c13475c.qVl = C5046bo.getInt((String) z.get(str5 + ".markMaxAlpha"), 30);
            c13475c.qVm = C5046bo.ank((String) z.get(str5 + ".titlePosition"));
            if (!C5046bo.isNullOrNil((String) z.get(str5 + ".adGestureInfo.points"))) {
                c13475c.qVn = new C13476a();
                c13475c.qVn.color = -1;
                c13475c.qVn.startTime = (long) C5046bo.ank((String) z.get(str5 + ".adGestureInfo.startTime"));
                c13475c.qVn.endTime = (long) C5046bo.ank((String) z.get(str5 + ".adGestureInfo.endTime"));
                c13475c.qVn.qVo = C5046bo.ann((String) z.get(str5 + ".adGestureInfo.distance"));
                c13475c.qVn.color = Color.parseColor(C5046bo.nullAsNil((String) z.get(str5 + ".adGestureInfo.color")));
                c13475c.qVn.qVp = C5046bo.nullAsNil((String) z.get(str5 + ".adGestureInfo.points"));
            }
        }
        this.qVd = C5046bo.ank((String) z.get(str2 + ".adxml.compatible.clientVersion.androidMin"));
        this.qVe = C5046bo.ank((String) z.get(str2 + ".adxml.compatible.clientVersion.androidMax"));
        this.qVf = C5046bo.nullAsNil((String) z.get(str2 + ".adxml.compatible.jumpUrl"));
        AppMethodBeat.m2505o(36908);
        return z;
    }

    public final boolean coK() {
        return this.qTJ || this.qUE;
    }

    public final String coL() {
        AppMethodBeat.m2504i(36909);
        String str;
        if (coR()) {
            str = this.qVg.qVq;
            AppMethodBeat.m2505o(36909);
            return str;
        } else if (coS()) {
            str = ((C21987g) this.qVh.qVv.get(0)).title;
            AppMethodBeat.m2505o(36909);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(36909);
            return str;
        }
    }

    public final String coM() {
        AppMethodBeat.m2504i(36910);
        String str;
        if (coR()) {
            str = this.qVg.qVr;
            AppMethodBeat.m2505o(36910);
            return str;
        } else if (coS()) {
            str = ((C21987g) this.qVh.qVv.get(1)).title;
            AppMethodBeat.m2505o(36910);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(36910);
            return str;
        }
    }

    public final String coN() {
        AppMethodBeat.m2504i(36911);
        String str;
        if (coS()) {
            str = this.qVh.qVu;
            AppMethodBeat.m2505o(36911);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(36911);
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
        AppMethodBeat.m2504i(36912);
        if (this.qVh == null || this.qVh.qVv.size() <= 1) {
            AppMethodBeat.m2505o(36912);
            return false;
        }
        AppMethodBeat.m2505o(36912);
        return true;
    }

    public final String coT() {
        AppMethodBeat.m2504i(36913);
        String str = this.cHz;
        if (str.contains("<adCanvasInfoLeft>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
        }
        AppMethodBeat.m2505o(36913);
        return str;
    }

    public final String coU() {
        AppMethodBeat.m2504i(36914);
        String str = this.cHz;
        if (str.contains("<adCanvasInfoRight>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
        }
        AppMethodBeat.m2505o(36914);
        return str;
    }

    public final String coV() {
        AppMethodBeat.m2504i(36915);
        String str = this.cHz;
        if (str.contains("<adTurnCanvasInfo>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
        }
        AppMethodBeat.m2505o(36915);
        return str;
    }

    public final String coW() {
        AppMethodBeat.m2504i(36916);
        String str = this.cHz;
        if (this.qUY == null || !str.contains("<adFullCardGestureCanvasInfo>")) {
            str = "";
        } else {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");
        }
        AppMethodBeat.m2505o(36916);
        return str;
    }

    public final boolean coX() {
        return this.qUA == 2;
    }
}
