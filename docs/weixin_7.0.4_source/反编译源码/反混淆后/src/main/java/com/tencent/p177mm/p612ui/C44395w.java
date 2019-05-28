package com.tencent.p177mm.p612ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37920l;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16107a;
import com.tencent.p177mm.p1099x.C16107a.C16108a;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1099x.C30903b.C30902a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d.C6329a;
import com.tencent.p177mm.p230g.p231a.C32622px;
import com.tencent.p177mm.p230g.p231a.C42012iw;
import com.tencent.p177mm.p230g.p231a.C6552to;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.LauncherUI.C23538c;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.card.p1243c.C33762b;
import com.tencent.p177mm.plugin.ipcall.C21098d;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C43691e;
import com.tencent.p177mm.plugin.websearch.api.C4514am;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14714c;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.pluginsdk.C44068p.C14896a;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14833a;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14834b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C36001bm;
import com.tencent.p177mm.storage.C46622bu;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.ui.w */
public final class C44395w implements C4937b {
    MMFragmentActivity yhZ;
    C4884c<C32622px> yhq = new C443965();
    C4884c yhr = new C443924();
    C23538c ynS;
    C5301c ynT;
    boolean ynU;
    Runnable ynV = new C307901();
    C44394a ynW;
    C16108a ynX = new C3635210();
    C4937b ynY = new C3635311();
    C4884c ynZ = new C443902();

    /* renamed from: com.tencent.mm.ui.w$7 */
    class C240807 implements Runnable {
        C240807() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29665);
            C44395w.this.ynU = true;
            C5004al.m7439af(C44395w.this.ynV);
            C5004al.m7441d(C44395w.this.ynV);
            AppMethodBeat.m2505o(29665);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$8 */
    class C240818 implements Runnable {
        C240818() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29666);
            C44395w.this.ynU = true;
            C5004al.m7439af(C44395w.this.ynV);
            C5004al.m7442n(C44395w.this.ynV, 300);
            AppMethodBeat.m2505o(29666);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$1 */
    class C307901 implements Runnable {

        /* renamed from: com.tencent.mm.ui.w$1$1 */
        class C307911 implements C5681a<Void, Integer> {
            C307911() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(29651);
                Void k = m49124k((Integer) obj);
                AppMethodBeat.m2505o(29651);
                return k;
            }

            /* JADX WARNING: Missing block: B:83:0x029f, code skipped:
            if (((java.lang.Boolean) com.tencent.p177mm.model.C18628c.m29072Ry().get(com.tencent.p177mm.storage.C5128ac.C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, java.lang.Boolean.FALSE)).booleanValue() == true) goto L_0x02a1;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: k */
            private Void m49124k(Integer num) {
                Void voidR;
                boolean z;
                boolean cDt;
                AppMethodBeat.m2504i(29650);
                C44395w.this.ynT.mo10915px(false);
                C44395w.this.ynT.mo10904MO(num.intValue());
                if (num.intValue() <= 0 && C9089a.dgL() && C41789d.akQ().baS() > 0) {
                    C44395w.this.ynT.mo10915px(true);
                }
                if (num.intValue() <= 0 && (C1853r.m3829YK() & 32768) == 0) {
                    C9638aw.m17190ZK();
                    if (C42252ah.m74620f((Boolean) C18628c.m29072Ry().get(68384, null))) {
                        C9638aw.m17190ZK();
                        if (C42252ah.isNullOrNil((String) C18628c.m29072Ry().get(68377, null))) {
                            C9638aw.m17190ZK();
                            if (((Boolean) C18628c.m29072Ry().get(589825, Boolean.FALSE)).booleanValue()) {
                                C44395w.this.ynT.mo10915px(true);
                                voidR = zXH;
                                AppMethodBeat.m2505o(29650);
                                return voidR;
                            }
                            Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, null);
                            long longValue = obj == null ? 0 : ((Long) obj).longValue();
                            if (longValue != 0 && ((C29034m) C1720g.m3528K(C29034m.class)).mo47121jM(longValue)) {
                                C44395w.this.ynT.mo10915px(true);
                                voidR = zXH;
                                AppMethodBeat.m2505o(29650);
                                return voidR;
                            }
                        }
                        C44395w.this.ynT.mo10915px(true);
                        voidR = zXH;
                        AppMethodBeat.m2505o(29650);
                        return voidR;
                    }
                }
                C43691e redDotMgr = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr();
                if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                    C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
                } else if (redDotMgr != null && redDotMgr.cFi() && redDotMgr.cFj() && ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cET()) {
                    C44395w.this.ynT.mo10915px(true);
                }
                if (((C23167a) C1720g.m3528K(C23167a.class)).agO("labs_nearbylife") && ((C23167a) C1720g.m3528K(C23167a.class)).mo38786xj("labs_nearbylife") && ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                    C44395w.this.ynT.mo10915px(true);
                }
                if (num.intValue() <= 0) {
                    z = (C1853r.m3823YE() & 4194304) != 0;
                    String value = C26373g.m41964Nu().getValue("JDEntranceConfigName");
                    String value2 = C26373g.m41964Nu().getValue("JDEntranceConfigIconUrl");
                    String value3 = C26373g.m41964Nu().getValue("JDEntranceConfigJumpUrl");
                    C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd tryshow configName " + value + " iconUrl " + value2 + " jumpUrl " + value3);
                    if (!(z || C42252ah.isNullOrNil(value) || C42252ah.isNullOrNil(value2) || C42252ah.isNullOrNil(value3))) {
                        C14834b c14834b = C44044f.vdy;
                        if (c14834b != null) {
                            cDt = c14834b.cDt();
                            C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(cDt)));
                            if (cDt) {
                                C14833a cDB = c14834b.cDB();
                                if (!cDB.isStart() || cDB.bxX()) {
                                    C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                                } else {
                                    C44395w.this.ynT.mo10915px(true);
                                    voidR = zXH;
                                    AppMethodBeat.m2505o(29650);
                                    return voidR;
                                }
                            }
                        }
                    }
                }
                z = (C1853r.m3823YE() & 33554432) != 0;
                if (!C21098d.bGW()) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
                } else if (!(z || C44395w.this.ynT.getShowFriendPoint() || num.intValue() > 0)) {
                    C9638aw.m17190ZK();
                    if (((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= C26373g.m41964Nu().getInt("WCOEntranceRedDot", 0)) {
                        C9638aw.m17190ZK();
                    }
                    C44395w.this.ynT.mo10915px(true);
                }
                if ((C1853r.m3823YE() & 2097152) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    C4514am cVt = C4514am.cVt();
                    if (cVt.uaS != null && cVt.uaS.isValid() && cVt.uaS.uaW == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        C44395w.this.ynT.mo10915px(true);
                    }
                }
                C9638aw.m17190ZK();
                if ((C18628c.m29072Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    cDt = true;
                } else {
                    cDt = false;
                }
                if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) == 1) {
                    C9638aw.m17190ZK();
                    z = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue();
                } else {
                    z = false;
                }
                if (z && r3) {
                    C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                    C44395w.this.ynT.mo10916py(true);
                }
                C44395w.this.ynU = false;
                voidR = zXH;
                AppMethodBeat.m2505o(29650);
                return voidR;
            }
        }

        /* renamed from: com.tencent.mm.ui.w$1$2 */
        class C307922 implements C5681a<Integer, Void> {
            C307922() {
            }

            public final /* synthetic */ Object call(Object obj) {
                int i = 0;
                AppMethodBeat.m2504i(29652);
                if (C9638aw.m17179RK()) {
                    int YD = C1853r.m3822YD();
                    if ((C1853r.m3829YK() & 64) == 0 && (YD & 32768) == 0) {
                        YD = C37920l.m64042Yv() + 0;
                    } else {
                        YD = 0;
                    }
                    if ((C1853r.m3829YK() & 512) == 0 && !C9089a.dgL()) {
                        i = C41789d.akQ().baS() + 0;
                    }
                    if ((C1853r.m3829YK() & 256) == 0) {
                        C46622bu akR = C41789d.akR();
                        if (akR != null) {
                            i += akR.baS();
                        }
                        i += C14896a.dgQ().cjL();
                    }
                    YD += i;
                    if ((C1853r.m3829YK() & 32768) != 0 || C21877n.qFz == null) {
                        i = YD;
                    } else {
                        i = YD + C21877n.qFz.baS();
                    }
                    C43691e redDotMgr = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr();
                    if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                        C4990ab.m7416i("MicroMsg.UnreadCountHelper", "checkLookVisibility EuropeanUnionCountry");
                    } else if (redDotMgr != null && redDotMgr.cFi() && redDotMgr.cFj()) {
                        int cEU = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEU();
                        if (((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEY() && cEU > 0) {
                            i += cEU;
                        }
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.UnreadCountHelper", "getFindTabUnreadCount, but mmcore not ready");
                }
                Integer valueOf = Integer.valueOf(i);
                AppMethodBeat.m2505o(29652);
                return valueOf;
            }
        }

        C307901() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29653);
            if (!C1720g.m3534RN().mo5161QY()) {
                C4990ab.m7412e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
                AppMethodBeat.m2505o(29653);
            } else if (C44395w.this.ynT == null) {
                C4990ab.m7420w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
                AppMethodBeat.m2505o(29653);
            } else {
                C5698f.dMn().mo15893d(new C307922()).mo15896f(new C307911()).mo15890a(C44395w.this.yhZ);
                AppMethodBeat.m2505o(29653);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(29654);
            String str = super.toString() + "|setTagRunnable";
            AppMethodBeat.m2505o(29654);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.w$9 */
    class C307939 implements Runnable {
        C307939() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29667);
            if (C44395w.this.ynU) {
                C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
                C5004al.m7439af(C44395w.this.ynV);
            }
            AppMethodBeat.m2505o(29667);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$10 */
    class C3635210 implements C16108a {
        C3635210() {
        }

        /* renamed from: p */
        public final void mo25292p(int i, String str) {
            AppMethodBeat.m2504i(29668);
            if (i == 262145 || i == 262156 || i == 262152 || i == 266260 || i == 266267) {
                C44395w.m80256b(C44395w.this);
            }
            if (i == 262147 || i == 262149 || i == 352279) {
                C44395w.m80256b(C44395w.this);
            }
            AppMethodBeat.m2505o(29668);
        }

        /* renamed from: b */
        public final void mo25291b(C5127a c5127a) {
            AppMethodBeat.m2504i(29669);
            if (c5127a == C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC) {
                C44395w.m80256b(C44395w.this);
            }
            AppMethodBeat.m2505o(29669);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$11 */
    class C3635311 implements C4937b {
        C3635311() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(29670);
            int bh = C42252ah.m74609bh(obj);
            C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(bh), c7298n);
            C9638aw.m17190ZK();
            if (c7298n != C18628c.m29072Ry() || bh <= 0) {
                C4990ab.m7413e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(bh), c7298n);
                AppMethodBeat.m2505o(29670);
                return;
            }
            C44395w.this.dyE();
            if (bh == 143618) {
                C44395w.m80255a(C44395w.this);
                AppMethodBeat.m2505o(29670);
                return;
            }
            if (bh == 204817 || bh == 204820) {
                C44395w.m80256b(C44395w.this);
            }
            AppMethodBeat.m2505o(29670);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$2 */
    class C443902 extends C4884c<C6552to> {
        C443902() {
            AppMethodBeat.m2504i(29655);
            this.xxI = C6552to.class.getName().hashCode();
            AppMethodBeat.m2505o(29655);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29656);
            C4990ab.m7419v("MicroMsg.LauncherUI.MainTabUnreadMgr", "appTagUnreadChangeListener, event:%s", ((C6552to) c4883b).toString());
            C44395w.this.dyE();
            AppMethodBeat.m2505o(29656);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.w$3 */
    class C443913 implements Runnable {
        C443913() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(29658);
            String str = super.toString() + "|setAddressTagUnread";
            AppMethodBeat.m2505o(29658);
            return str;
        }

        public final void run() {
            int h;
            AppMethodBeat.m2504i(29657);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                h = C42252ah.m74624h((Integer) C18628c.m29072Ry().get(143618, null));
            } else {
                C4990ab.m7420w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
                h = 0;
            }
            if (C44395w.this.ynT != null) {
                C44395w.this.ynT.mo10903MN(h);
            }
            AppMethodBeat.m2505o(29657);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$4 */
    class C443924 extends C4884c<C42012iw> {

        /* renamed from: com.tencent.mm.ui.w$4$1 */
        class C159851 implements Runnable {
            C159851() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29659);
                C44395w.this.ynU = true;
                C5004al.m7439af(C44395w.this.ynV);
                C5004al.m7441d(C44395w.this.ynV);
                AppMethodBeat.m2505o(29659);
            }
        }

        C443924() {
            AppMethodBeat.m2504i(29660);
            this.xxI = C42012iw.class.getName().hashCode();
            AppMethodBeat.m2505o(29660);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29661);
            C1314b.m2812HQ().mo4642o(new C159851());
            AppMethodBeat.m2505o(29661);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.w$6 */
    class C443936 implements Runnable {
        C443936() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29664);
            C44395w.m80255a(C44395w.this);
            C44395w.this.dyI();
            C44395w.m80256b(C44395w.this);
            AppMethodBeat.m2505o(29664);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$a */
    static class C44394a implements C6329a {
        C5301c ynT;

        public C44394a(C5301c c5301c) {
            this.ynT = c5301c;
        }

        /* renamed from: e */
        public final void mo14568e(C36001bm c36001bm) {
            AppMethodBeat.m2504i(29671);
            if (c36001bm.field_tipId == C32321b.fKD) {
                C16841a.bVv();
                if (C1301c.m2776lQ(C32321b.fKD)) {
                    this.ynT.mo10916py(true);
                }
            }
            AppMethodBeat.m2505o(29671);
        }
    }

    /* renamed from: com.tencent.mm.ui.w$5 */
    class C443965 extends C4884c<C32622px> {
        C443965() {
            AppMethodBeat.m2504i(29662);
            this.xxI = C32622px.class.getName().hashCode();
            AppMethodBeat.m2505o(29662);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29663);
            C44395w.this.ynU = true;
            C5004al.m7439af(C44395w.this.ynV);
            C5004al.m7441d(C44395w.this.ynV);
            AppMethodBeat.m2505o(29663);
            return false;
        }
    }

    public C44395w() {
        AppMethodBeat.m2504i(29672);
        AppMethodBeat.m2505o(29672);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyI() {
        AppMethodBeat.m2504i(29673);
        C1314b.m2812HQ().mo4642o(new C240807());
        AppMethodBeat.m2505o(29673);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyE() {
        AppMethodBeat.m2504i(29674);
        C1314b.m2812HQ().mo4642o(new C240818());
        AppMethodBeat.m2505o(29674);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyC() {
        AppMethodBeat.m2504i(29675);
        C1314b.m2812HQ().mo4642o(new C307939());
        AppMethodBeat.m2505o(29675);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyD() {
        AppMethodBeat.m2504i(29676);
        if (this.ynU) {
            C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
            dyI();
        }
        AppMethodBeat.m2505o(29676);
    }

    /* renamed from: No */
    public final void mo70264No(int i) {
        AppMethodBeat.m2504i(29677);
        if (this.ynT != null) {
            this.ynT.mo10902MM(i);
            this.ynS.dxq();
        }
        AppMethodBeat.m2505o(29677);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(29678);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(29678);
            return;
        }
        C9638aw.m17190ZK();
        if (c7298n == C18628c.m29083XR()) {
            C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", Integer.valueOf(i), obj);
            if (C7616ad.m13548mR((String) obj)) {
                dyE();
            }
            AppMethodBeat.m2505o(29678);
            return;
        }
        AppMethodBeat.m2505o(29678);
    }

    /* renamed from: Np */
    public final void mo70265Np(int i) {
        AppMethodBeat.m2504i(29679);
        if (this.ynT != null) {
            this.ynT.setTo(i);
        }
        AppMethodBeat.m2505o(29679);
    }

    public final int dyJ() {
        AppMethodBeat.m2504i(29680);
        int i = 0;
        if (this.ynT != null && this.ynT.getMainTabUnread() > 0) {
            i = this.ynT.getMainTabUnread();
        }
        AppMethodBeat.m2505o(29680);
        return i;
    }

    /* renamed from: a */
    static /* synthetic */ void m80255a(C44395w c44395w) {
        AppMethodBeat.m2504i(29681);
        C5004al.m7441d(new C443913());
        AppMethodBeat.m2505o(29681);
    }

    /* renamed from: b */
    static /* synthetic */ void m80256b(C44395w c44395w) {
        AppMethodBeat.m2504i(29682);
        if (C9638aw.m17179RK()) {
            Object obj;
            int i;
            C1720g.m3528K(C33762b.class);
            boolean bX = C16112c.m24429PK().mo28551bX(262156, 266241);
            boolean bY = C16112c.m24429PK().mo28552bY(262156, 266241);
            C4990ab.m7417i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(bX), Boolean.valueOf(bY));
            if (bX || bY) {
                C9638aw.m17190ZK();
                long longValue = ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
                long lb = C42252ah.m74628lb(C26373g.m41964Nu().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * lb;
                C4990ab.m7417i("MicroMsg.LauncherUI.MainTabUnreadMgr", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(lb), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
                if (longValue > 0 && lb > 0 && r14 >= ((double) lb)) {
                    bX = false;
                    C16112c.m24429PK().mo28556x(262156, false);
                    bY = false;
                }
            }
            C4990ab.m7417i("MicroMsg.LauncherUI.MainTabUnreadMgr", "after check, hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(bX), Boolean.valueOf(bY));
            boolean bX2 = C16112c.m24429PK().mo28551bX(262145, 266241);
            boolean bY2 = C16112c.m24429PK().mo28552bY(266260, 266241);
            boolean bX3 = C16112c.m24429PK().mo28551bX(262147, 266241);
            boolean bX4 = C16112c.m24429PK().mo28551bX(262149, 266241);
            boolean bY3 = C16112c.m24429PK().mo28552bY(262152, 266256);
            boolean bX5 = C16112c.m24429PK().mo28551bX(262152, 266256);
            boolean a = C16112c.m24429PK().mo28545a(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
            boolean bX6 = C16112c.m24429PK().mo28551bX(352279, 266241);
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            C14714c c14714c = (C14714c) C1720g.m3528K(C14714c.class);
            Object obj2 = null;
            if (c14714c != null) {
                obj = (c14714c.ddn() || c14714c.ddo()) ? 1 : null;
                obj2 = obj;
            }
            C16107a PK = C16112c.m24429PK();
            int i2;
            if (PK.initialized) {
                C30902a F = PK.eER.mo49428F(262152, 266256, 4);
                if (F == null) {
                    i2 = 0;
                } else {
                    i2 = C16107a.parseInt(F.value);
                }
            } else {
                C4990ab.m7420w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
                i2 = 0;
            }
            C33762b c33762b = (C33762b) C1720g.m3528K(C33762b.class);
            if (c33762b == null || !(c33762b.bbn() || c33762b.bbo())) {
                obj = null;
            } else {
                obj = 1;
            }
            Object obj3;
            if (obj == null || !(bY3 || bX5 || i2 > 0)) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            C1720g.m3537RQ();
            bY3 = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            C1720g.m3537RQ();
            long longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0))).longValue();
            if (bY3 && longValue2 > 0 && System.currentTimeMillis() > longValue2) {
                C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasNewMallDot expire, ignore redot");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, (Object) Boolean.FALSE);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0));
                bY3 = false;
            }
            bX5 = C16112c.m24429PK().mo28550b(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
            C1720g.m3537RQ();
            longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0))).longValue();
            if (bX5 && longValue2 > 0 && System.currentTimeMillis() > longValue2) {
                C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasNewMallDot expire, ignore redot");
                bY3 = false;
                C16112c.m24429PK().mo28554c(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0));
            }
            if (c44395w.ynT != null) {
                if (bY || bX || bX2 || obj3 != null || bX3 || bX4 || bY2 || obj2 != null || a || r7 || bX5 || bX6) {
                    c44395w.ynT.mo10916py(true);
                } else {
                    c44395w.ynT.mo10916py(false);
                }
            }
            C22212h c22212h = C22212h.scu;
            C22212h.m33898lp(bX6 ? 1 : 0);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (bY) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            c7060h.mo8381e(14872, objArr);
            C36001bm Ms = C16841a.bVu().mo48500Ms(C32321b.fKD);
            if (Ms == null || Ms.field_isExit) {
                C16841a.bVv();
                if (C1301c.m2776lQ(C32321b.fKD)) {
                    c44395w.ynT.mo10916py(true);
                }
            } else {
                c44395w.ynW = new C44394a(c44395w.ynT);
                C16841a.bVt().fKT = c44395w.ynW;
            }
            if (c44395w.ynT != null) {
                c44395w.ynT.mo10917pz(booleanValue);
            }
            AppMethodBeat.m2505o(29682);
            return;
        }
        C4990ab.m7420w("MicroMsg.LauncherUI.MainTabUnreadMgr", "want update more menu new tips, but mmcore not ready");
        AppMethodBeat.m2505o(29682);
    }
}
