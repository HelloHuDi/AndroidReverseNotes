package com.tencent.p177mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1670b;
import com.tencent.p177mm.kernel.api.C1674f;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.model.p871b.C18612d;
import com.tencent.p177mm.model.p871b.C42187c;
import com.tencent.p177mm.model.p871b.C45437b;
import com.tencent.p177mm.modelstat.C31275m;
import com.tencent.p177mm.modelstat.C42225q;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1363a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3454c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3462i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.plugin.p980h.C12217a;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.plugin.record.C34797b;
import com.tencent.p177mm.plugin.sns.p1024b.C29032b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C15444n;
import com.tencent.p177mm.storage.C23509au;
import com.tencent.p177mm.storage.C30306j;
import com.tencent.p177mm.storage.C30307l;
import com.tencent.p177mm.storage.C36003g;
import com.tencent.p177mm.storage.C36004h;
import com.tencent.p177mm.storage.C40620aa;
import com.tencent.p177mm.storage.C40631p;
import com.tencent.p177mm.storage.C46626o;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7571bh;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5734i;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.model.c */
public final class C18628c {
    public static HashMap<Integer, C1366d> eaA;
    public C26418br fkd;
    public C9650bq fke;
    C36004h fkf;
    C42187c fkg;
    C18612d fkh;
    C30306j fki;
    C15444n fkj;
    C30307l fkk;
    C45437b fkl;

    /* renamed from: com.tencent.mm.model.c$2 */
    class C186222 implements C1670b {
        C186222() {
        }

        public final List<String> collectStoragePaths() {
            AppMethodBeat.m2504i(16200);
            LinkedList linkedList = new LinkedList();
            Collections.addAll(linkedList, new String[]{"image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/"});
            AppMethodBeat.m2505o(16200);
            return linkedList;
        }
    }

    /* renamed from: com.tencent.mm.model.c$4 */
    class C186234 implements C5734i {
        C186234() {
        }

        /* renamed from: ml */
        public final boolean mo11677ml(String str) {
            AppMethodBeat.m2504i(16203);
            if (str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg_encrypt.db")) {
                AppMethodBeat.m2505o(16203);
                return true;
            }
            AppMethodBeat.m2505o(16203);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.model.c$3 */
    class C186293 implements C1674f {
        C186293() {
        }

        /* renamed from: RV */
        public final void mo5174RV() {
            AppMethodBeat.m2504i(16201);
            C9638aw.m17189ZJ();
            AppMethodBeat.m2505o(16201);
        }

        /* renamed from: lM */
        public final void mo5175lM(String str) {
            AppMethodBeat.m2504i(16202);
            if (C1445f.m3070Mn()) {
                C1720g.m3537RQ();
                if (C1720g.m3536RP().eJL.equals(C6457e.eSn)) {
                    C1720g.m3537RQ();
                    C7305d.post(new C18635b(C1720g.m3536RP().cachePath, str), "AccountStorage_moveDataFiles");
                }
            }
            AppMethodBeat.m2505o(16202);
        }
    }

    /* renamed from: com.tencent.mm.model.c$5 */
    static class C186305 implements C1366d {
        C186305() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23509au.fnj;
        }
    }

    /* renamed from: com.tencent.mm.model.c$6 */
    static class C186316 implements C1366d {
        C186316() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C36004h.fnj;
        }
    }

    /* renamed from: com.tencent.mm.model.c$8 */
    static class C186328 implements C1366d {
        C186328() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C15444n.fnj;
        }
    }

    /* renamed from: com.tencent.mm.model.c$9 */
    static class C186339 implements C1366d {
        C186339() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30307l.fnj;
        }
    }

    /* renamed from: com.tencent.mm.model.c$a */
    public interface C18634a {
        /* renamed from: cx */
        void mo20971cx(boolean z);
    }

    /* renamed from: com.tencent.mm.model.c$b */
    static class C18635b implements Runnable {
        String cKf;
        String fkn;

        public C18635b(String str, String str2) {
            this.cKf = str;
            this.fkn = str2;
        }

        public final void run() {
            AppMethodBeat.m2504i(16204);
            if (C5046bo.isNullOrNil(this.cKf) || C5046bo.isNullOrNil(this.fkn)) {
                AppMethodBeat.m2505o(16204);
                return;
            }
            C4990ab.m7410d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.cKf + " to :" + this.fkn);
            if (!C1445f.m3070Mn()) {
                AppMethodBeat.m2505o(16204);
            } else if (this.fkn.substring(0, C6457e.eSn.length()).equals(C6457e.eSn)) {
                C5730e.m8635it(this.cKf + "image/", this.fkn + "image/");
                C5730e.m8635it(this.cKf + "image2/", this.fkn + "image2/");
                C5730e.m8635it(this.cKf + "video/", this.fkn + "video/");
                C5730e.m8635it(this.cKf + "voice/", this.fkn + "voice/");
                C5730e.m8635it(this.cKf + "voice2/", this.fkn + "voice2/");
                C5730e.m8635it(this.cKf + "package/", this.fkn + "package/");
                C5730e.m8635it(this.cKf + "emoji/", this.fkn + "emoji/");
                C5730e.m8635it(this.cKf + "mailapp/", this.fkn + "mailapp/");
                C5730e.m8635it(this.cKf + "brandicon/", this.fkn + "brandicon/");
                AppMethodBeat.m2505o(16204);
            } else {
                AppMethodBeat.m2505o(16204);
            }
        }
    }

    /* renamed from: com.tencent.mm.model.c$1 */
    class C186361 implements C1363a {
        C186361() {
        }

        /* renamed from: RF */
        public final void mo4747RF() {
            AppMethodBeat.m2504i(16199);
            C1720g.m3537RQ();
            if (C1720g.m3531RK()) {
                C31275m aks = C42225q.aks();
                if (aks != null) {
                    C4990ab.m7416i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(aks)));
                    long currentTimeMillis = System.currentTimeMillis();
                    aks.fTM.mo27468pl(true);
                    C4990ab.m7416i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
            }
            AppMethodBeat.m2505o(16199);
        }

        /* renamed from: RG */
        public final void mo4748RG() {
        }

        /* renamed from: RH */
        public final void mo4749RH() {
        }
    }

    /* renamed from: com.tencent.mm.model.c$7 */
    static class C186377 implements C1366d {
        C186377() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30306j.fnj;
        }
    }

    public C18628c() {
        AppMethodBeat.m2504i(16205);
        C1720g.m3537RQ();
        C1706e RP = C1720g.m3536RP();
        RP.eJJ.mo14670aD(new C186361());
        C6610c.m10890Sa().add(new C186222());
        C6610c.m10890Sa().add(new C186293());
        AppMethodBeat.m2505o(16205);
    }

    /* renamed from: QF */
    public static int m29064QF() {
        AppMethodBeat.m2504i(16206);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        int QF = C1668a.m3383QF();
        AppMethodBeat.m2505o(16206);
        return QF;
    }

    /* renamed from: XH */
    public static String m29073XH() {
        AppMethodBeat.m2504i(16207);
        C1720g.m3537RQ();
        String str = C1720g.m3536RP().eJL;
        AppMethodBeat.m2505o(16207);
        return str;
    }

    /* renamed from: RA */
    public static void m29066RA() {
        AppMethodBeat.m2504i(16208);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5228RA();
        AppMethodBeat.m2505o(16208);
    }

    public static boolean isSDCardAvailable() {
        AppMethodBeat.m2504i(16209);
        C1720g.m3537RQ();
        boolean isSDCardAvailable = C1720g.m3536RP().isSDCardAvailable();
        AppMethodBeat.m2505o(16209);
        return isSDCardAvailable;
    }

    /* renamed from: Rs */
    public static String m29067Rs() {
        AppMethodBeat.m2504i(16210);
        C1720g.m3537RQ();
        String Rs = C1720g.m3536RP().mo5234Rs();
        AppMethodBeat.m2505o(16210);
        return Rs;
    }

    public static void closeDB() {
        AppMethodBeat.m2504i(16211);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5245jC(null);
        AppMethodBeat.m2505o(16211);
    }

    /* renamed from: a */
    public static void m29103a(C1815as c1815as) {
        AppMethodBeat.m2504i(16212);
        C1720g.m3537RQ();
        C1668a RN = C1720g.m3534RN();
        C4990ab.m7417i("MMKernel.CoreAccount", "UserStatusChange: add %s", c1815as);
        synchronized (RN.eIX) {
            try {
                if (!RN.eIX.contains(c1815as)) {
                    RN.eIX.add(c1815as);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(16212);
            }
        }
    }

    /* renamed from: b */
    public static void m29104b(C1815as c1815as) {
        AppMethodBeat.m2504i(16213);
        C1720g.m3537RQ();
        C1668a RN = C1720g.m3534RN();
        C4990ab.m7417i("MMKernel.CoreAccount", "UserStatusChange: remove %s", c1815as);
        synchronized (RN.eIX) {
            try {
                RN.eIX.remove(c1815as);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(16213);
            }
        }
    }

    /* renamed from: QV */
    public static void m29065QV() {
        AppMethodBeat.m2504i(16214);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5160QV();
        AppMethodBeat.m2505o(16214);
    }

    /* renamed from: XI */
    public static boolean m29074XI() {
        AppMethodBeat.m2504i(16215);
        C1720g.m3537RQ();
        boolean jP = C1668a.m3404jP(C1720g.m3534RN().eIV);
        AppMethodBeat.m2505o(16215);
        return jP;
    }

    /* renamed from: XJ */
    public static int m29075XJ() {
        AppMethodBeat.m2504i(16216);
        C1720g.m3537RQ();
        int i = C1720g.m3534RN().eIW;
        AppMethodBeat.m2505o(16216);
        return i;
    }

    /* renamed from: Ru */
    public static C7480h m29069Ru() {
        AppMethodBeat.m2504i(16217);
        C1720g.m3537RQ();
        C7480h c7480h = C1720g.m3536RP().eJN;
        AppMethodBeat.m2505o(16217);
        return c7480h;
    }

    /* renamed from: XK */
    public static C7480h m29076XK() {
        AppMethodBeat.m2504i(16218);
        C1720g.m3537RQ();
        C7480h c7480h = C1720g.m3536RP().eJO;
        AppMethodBeat.m2505o(16218);
        return c7480h;
    }

    /* renamed from: lK */
    public static SharedPreferences m29106lK(String str) {
        AppMethodBeat.m2504i(16219);
        C1720g.m3537RQ();
        SharedPreferences lK = C1720g.m3536RP().mo5247lK(str);
        AppMethodBeat.m2505o(16219);
        return lK;
    }

    /* renamed from: Ry */
    public static C7580z m29072Ry() {
        AppMethodBeat.m2504i(16220);
        C1720g.m3537RQ();
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        AppMethodBeat.m2505o(16220);
        return Ry;
    }

    /* renamed from: XL */
    public static C3462i m29077XL() {
        AppMethodBeat.m2504i(16221);
        C3462i XL = ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL();
        AppMethodBeat.m2505o(16221);
        return XL;
    }

    /* renamed from: XM */
    public static C7309bd m29078XM() {
        AppMethodBeat.m2504i(16222);
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        AppMethodBeat.m2505o(16222);
        return XM;
    }

    /* renamed from: XN */
    public static C6980m m29079XN() {
        AppMethodBeat.m2504i(16223);
        C6980m XN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN();
        AppMethodBeat.m2505o(16223);
        return XN;
    }

    /* renamed from: XO */
    public static C6977h m29080XO() {
        AppMethodBeat.m2504i(16224);
        C6977h bOr = ((C6982j) C1720g.m3528K(C6982j.class)).bOr();
        AppMethodBeat.m2505o(16224);
        return bOr;
    }

    /* renamed from: XP */
    public static C46626o m29081XP() {
        AppMethodBeat.m2504i(16225);
        C46626o XP = ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP();
        AppMethodBeat.m2505o(16225);
        return XP;
    }

    /* renamed from: XQ */
    public static C40631p m29082XQ() {
        AppMethodBeat.m2504i(16226);
        C40631p XQ = ((C8939o) C1720g.m3528K(C8939o.class)).mo20358XQ();
        AppMethodBeat.m2505o(16226);
        return XQ;
    }

    /* renamed from: XR */
    public static C7310be m29083XR() {
        AppMethodBeat.m2504i(16227);
        C7310be XR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR();
        AppMethodBeat.m2505o(16227);
        return XR;
    }

    /* renamed from: XS */
    public static C42912b m29084XS() {
        AppMethodBeat.m2504i(16228);
        C42912b XS = ((C45826d) C1720g.m3528K(C45826d.class)).mo7017XS();
        AppMethodBeat.m2505o(16228);
        return XS;
    }

    /* renamed from: XT */
    public static C7571bh m29085XT() {
        AppMethodBeat.m2504i(16229);
        C7571bh XT = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT();
        AppMethodBeat.m2505o(16229);
        return XT;
    }

    /* renamed from: XU */
    public static C6978k m29086XU() {
        AppMethodBeat.m2504i(16230);
        C6978k XU = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU();
        AppMethodBeat.m2505o(16230);
        return XU;
    }

    /* renamed from: XV */
    public static C6663ag m29087XV() {
        AppMethodBeat.m2504i(16231);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C6663ag XV = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        AppMethodBeat.m2505o(16231);
        return XV;
    }

    /* renamed from: XW */
    public static String m29088XW() {
        AppMethodBeat.m2504i(16232);
        String XW = C43217c.m76863XW();
        AppMethodBeat.m2505o(16232);
        return XW;
    }

    /* renamed from: XX */
    public static String m29089XX() {
        AppMethodBeat.m2504i(16233);
        String XX = C43217c.m76864XX();
        AppMethodBeat.m2505o(16233);
        return XX;
    }

    /* renamed from: XY */
    public static String m29090XY() {
        AppMethodBeat.m2504i(16234);
        String XY = C32850q.m53708XY();
        AppMethodBeat.m2505o(16234);
        return XY;
    }

    /* renamed from: XZ */
    public static String m29091XZ() {
        AppMethodBeat.m2504i(16235);
        String XZ = C34797b.m57159XZ();
        AppMethodBeat.m2505o(16235);
        return XZ;
    }

    /* renamed from: Ya */
    public static String m29092Ya() {
        AppMethodBeat.m2504i(16236);
        String Ya = C40620aa.m70077Ya();
        AppMethodBeat.m2505o(16236);
        return Ya;
    }

    /* renamed from: Yb */
    public static String m29093Yb() {
        AppMethodBeat.m2504i(16237);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("emoji/").toString();
        AppMethodBeat.m2505o(16237);
        return stringBuilder2;
    }

    public static String getAccVideoPath() {
        AppMethodBeat.m2504i(16238);
        C37961o.alk();
        String accVideoPath = C37961o.getAccVideoPath();
        AppMethodBeat.m2505o(16238);
        return accVideoPath;
    }

    /* renamed from: Yc */
    public static String m29094Yc() {
        AppMethodBeat.m2504i(16239);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("image/shakeTranImg/").toString();
        AppMethodBeat.m2505o(16239);
        return stringBuilder2;
    }

    /* renamed from: Yd */
    public static String m29095Yd() {
        AppMethodBeat.m2504i(16240);
        String Yd = C12217a.m20142Yd();
        AppMethodBeat.m2505o(16240);
        return Yd;
    }

    /* renamed from: Ye */
    public static String m29096Ye() {
        AppMethodBeat.m2504i(16241);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("attachment/").toString();
        AppMethodBeat.m2505o(16241);
        return stringBuilder2;
    }

    /* renamed from: Yf */
    public static String m29097Yf() {
        AppMethodBeat.m2504i(16242);
        String Yf = ((C8939o) C1720g.m3528K(C8939o.class)).mo20359Yf();
        AppMethodBeat.m2505o(16242);
        return Yf;
    }

    /* renamed from: Yg */
    public static String m29098Yg() {
        AppMethodBeat.m2504i(16243);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("record/").toString();
        AppMethodBeat.m2505o(16243);
        return stringBuilder2;
    }

    public static String getAccSnsPath() {
        AppMethodBeat.m2504i(16244);
        String accSnsPath = ((C29032b) C1720g.m3530M(C29032b.class)).getAccSnsPath();
        AppMethodBeat.m2505o(16244);
        return accSnsPath;
    }

    public static String getAccSnsTmpPath() {
        AppMethodBeat.m2504i(16245);
        String accSnsTmpPath = ((C29032b) C1720g.m3530M(C29032b.class)).getAccSnsTmpPath();
        AppMethodBeat.m2505o(16245);
        return accSnsTmpPath;
    }

    /* renamed from: Yh */
    public static String m29099Yh() {
        AppMethodBeat.m2504i(16246);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.getAccPath()).append("voiceremind/").toString();
        AppMethodBeat.m2505o(16246);
        return stringBuilder2;
    }

    /* renamed from: Yi */
    public static String m29100Yi() {
        AppMethodBeat.m2504i(16247);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.getAccPath()).append("wenote/").toString();
        AppMethodBeat.m2505o(16247);
        return stringBuilder2;
    }

    /* renamed from: Rv */
    public static String m29070Rv() {
        AppMethodBeat.m2504i(16248);
        C1720g.m3537RQ();
        String Rv = C1720g.m3536RP().mo5237Rv();
        AppMethodBeat.m2505o(16248);
        return Rv;
    }

    /* renamed from: Rw */
    public static String m29071Rw() {
        AppMethodBeat.m2504i(16249);
        C1720g.m3537RQ();
        String Rw = C1720g.m3536RP().mo5238Rw();
        AppMethodBeat.m2505o(16249);
        return Rw;
    }

    /* renamed from: Rt */
    public static String m29068Rt() {
        AppMethodBeat.m2504i(16250);
        C1720g.m3537RQ();
        String str = C1720g.m3536RP().cachePath;
        AppMethodBeat.m2505o(16250);
        return str;
    }

    public static String getAccPath() {
        AppMethodBeat.m2504i(16251);
        C1720g.m3537RQ();
        String str = C1720g.m3536RP().eJM;
        AppMethodBeat.m2505o(16251);
        return str;
    }

    /* renamed from: Yj */
    public final void mo33884Yj() {
        AppMethodBeat.m2504i(16252);
        StringBuilder stringBuilder = new StringBuilder("mm");
        C1720g.m3537RQ();
        C1720g.m3534RN();
        String x = C1178g.m2591x(stringBuilder.append(C1668a.m3383QF()).toString().getBytes());
        String str = C5128ac.eSj + x + "/";
        String str2 = C6457e.eSn + x + "/";
        String[] a = new C5728b(str).mo11652a(new C186234());
        if (a == null) {
            AppMethodBeat.m2505o(16252);
            return;
        }
        for (String str3 : a) {
            String str4 = str2 + str3 + ".dump";
            C5730e.deleteFile(str4);
            C5730e.m8644y(str + str3, str4);
            C4990ab.m7416i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
        }
        AppMethodBeat.m2505o(16252);
    }

    /* renamed from: iy */
    public static void m29105iy(int i) {
        AppMethodBeat.m2504i(16253);
        C7485q.m12928kt(i);
        if ((i & 16) != 0) {
            C1829bf.m3741a("medianote", null);
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoX("medianote");
        }
        AppMethodBeat.m2505o(16253);
    }

    static {
        AppMethodBeat.m2504i(16262);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new C186305());
        eaA.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new C186316());
        eaA.put(Integer.valueOf("BackupMoveTime".hashCode()), new C186377());
        eaA.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new C186328());
        eaA.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new C186339());
        AppMethodBeat.m2505o(16262);
    }

    /* renamed from: Yk */
    public final C42187c mo33885Yk() {
        AppMethodBeat.m2504i(16254);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C42187c c42187c = this.fkg;
        AppMethodBeat.m2505o(16254);
        return c42187c;
    }

    /* renamed from: Yl */
    public final C18612d mo33886Yl() {
        AppMethodBeat.m2504i(16255);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C18612d c18612d = this.fkh;
        AppMethodBeat.m2505o(16255);
        return c18612d;
    }

    /* renamed from: Ym */
    public final C45437b mo33887Ym() {
        AppMethodBeat.m2504i(16256);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C45437b c45437b = this.fkl;
        AppMethodBeat.m2505o(16256);
        return c45437b;
    }

    /* renamed from: Yn */
    public static C36003g m29101Yn() {
        AppMethodBeat.m2504i(16257);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C36003g Yn = C20118a.ask().mo35364Yn();
        AppMethodBeat.m2505o(16257);
        return Yn;
    }

    /* renamed from: Yo */
    public static C3454c m29102Yo() {
        AppMethodBeat.m2504i(16258);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C3454c Yo = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo();
        AppMethodBeat.m2505o(16258);
        return Yo;
    }

    /* renamed from: Yp */
    public final C30306j mo33888Yp() {
        AppMethodBeat.m2504i(16259);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C30306j c30306j = this.fki;
        AppMethodBeat.m2505o(16259);
        return c30306j;
    }

    /* renamed from: Yq */
    public final C15444n mo33889Yq() {
        AppMethodBeat.m2504i(16260);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C15444n c15444n = this.fkj;
        AppMethodBeat.m2505o(16260);
        return c15444n;
    }

    /* renamed from: Yr */
    public final C30307l mo33890Yr() {
        AppMethodBeat.m2504i(16261);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C30307l c30307l = this.fkk;
        AppMethodBeat.m2505o(16261);
        return c30307l;
    }
}
