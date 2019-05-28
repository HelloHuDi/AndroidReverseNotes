package com.tencent.p177mm.plugin.shake.p1019b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18377qm;
import com.tencent.p177mm.p230g.p231a.C26242ss;
import com.tencent.p177mm.p230g.p231a.C32604oh;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C28997f;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C46197d;
import com.tencent.p177mm.plugin.shake.p509d.p1412b.C29001a;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C39695i;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C46199o;
import com.tencent.p177mm.pluginsdk.C44068p.C14896a;
import com.tencent.p177mm.pluginsdk.p1077c.C35783d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7309bd.C5131a;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.shake.b.m */
public final class C28987m implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C4884c egQ = new C289907();
    private C5132a flN = new C289892();
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    private C4884c oMA = new C132556();
    private C5131a oPE = new C2898314();
    private C13247e qrY;
    private C13249g qrZ;
    private C28997f qsa;
    private C46197d qsb;
    private C46199o qsc;
    private C28995n qsd = new C28995n();
    C35783d qse = new C289941();
    private C1837a qsf = new C1325213();
    private C4884c qsg = new C289843();
    private C1837a qsh = new C132534();
    private C1837a qsi = new C289855();

    /* renamed from: com.tencent.mm.plugin.shake.b.m$12 */
    class C1325112 implements Runnable {
        C1325112() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24487);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C5046bo.m7583o(C18628c.m29094Yc(), "Sk", 604800000);
                AppMethodBeat.m2505o(24487);
                return;
            }
            AppMethodBeat.m2505o(24487);
        }

        public final String toString() {
            AppMethodBeat.m2504i(24488);
            String str = super.toString() + "|onAccountPostReset";
            AppMethodBeat.m2505o(24488);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$13 */
    class C1325213 implements C1837a {
        C1325213() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(24489);
            C28987m.cjZ();
            if (C28987m.cjW() != null) {
                C28987m.cjZ();
                C28987m.cjW();
                String a = C1946aa.m4148a(c1197a.eAB.vED);
                C4990ab.m7418v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(a)));
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7410d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                    AppMethodBeat.m2505o(24489);
                    return;
                }
                Map z = C5049br.m7595z(a, "sysmsg");
                int i = C5046bo.getInt((String) z.get(".sysmsg.shake.$type"), 0);
                switch (i) {
                    case 1:
                        C13248f c13248f = new C13248f();
                        i = C5046bo.getInt((String) z.get(".sysmsg.shake.shaketv.msgtype"), 0);
                        if (i == 0) {
                            c13248f.field_type = 1;
                            c13248f.field_subtype = i;
                            c13248f.field_svrid = c1197a.eAB.ptF;
                            c13248f.field_createtime = C5046bo.anT();
                            c13248f.field_tag = (String) z.get(".sysmsg.shake.shaketv.jumpurl");
                            c13248f.field_status = 0;
                            c13248f.field_title = (String) z.get(".sysmsg.shake.shaketv.title");
                            c13248f.field_thumburl = (String) z.get(".sysmsg.shake.shaketv.iconurl");
                            c13248f.field_desc = (String) z.get(".sysmsg.shake.shaketv.desc");
                            c13248f.field_reserved1 = C5046bo.nullAsNil((String) z.get(".sysmsg.shake.shaketv.pid"));
                            C28987m.cjT().mo25317a(c13248f);
                            AppMethodBeat.m2505o(24489);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(24489);
                        return;
                    default:
                        C4990ab.m7410d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(24489);
                        return;
                }
            }
            C4990ab.m7420w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
            AppMethodBeat.m2505o(24489);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$4 */
    class C132534 implements C1837a {
        C132534() {
        }

        /* renamed from: a */
        public final void mo5414a(final C1197a c1197a) {
            AppMethodBeat.m2504i(24480);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
                AppMethodBeat.m2505o(24480);
                return;
            }
            C28987m.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24479);
                    C28987m.cjX().mo47086i(a, c1197a.eAB.ptF, 0);
                    AppMethodBeat.m2505o(24479);
                }
            });
            AppMethodBeat.m2505o(24480);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$6 */
    class C132556 extends C4884c<C45337kd> {
        C132556() {
            AppMethodBeat.m2504i(24483);
            this.xxI = C45337kd.class.getName().hashCode();
            AppMethodBeat.m2505o(24483);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24484);
            C45337kd c45337kd = (C45337kd) c4883b;
            if (c45337kd instanceof C45337kd) {
                switch (c45337kd.cFz.action) {
                    case -4:
                        Cursor cjB = C28987m.cjS().cjB();
                        c45337kd.cFA.cAV = new ArrayList();
                        while (cjB != null && cjB.moveToNext()) {
                            C34894d c34894d = new C34894d();
                            c34894d.mo8995d(cjB);
                            c45337kd.cFA.cAV.add(C39695i.m67840d(c34894d.field_lvbuffer, 0));
                        }
                        if (cjB != null) {
                            cjB.close();
                            break;
                        }
                        break;
                    case 12:
                        c45337kd.cFA.cFG = C29001a.m46039UK(c45337kd.cFz.cFE);
                        break;
                }
            }
            AppMethodBeat.m2505o(24484);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$14 */
    class C2898314 implements C5131a {
        C2898314() {
        }

        /* renamed from: a */
        public final void mo10530a(C7309bd c7309bd, C7616ad c7616ad) {
            AppMethodBeat.m2504i(24490);
            if (!(c7309bd == null || c7616ad == null || !c7616ad.mo16698Oa())) {
                C28987m.cjS().mo25303WC(c7616ad.field_username);
            }
            AppMethodBeat.m2505o(24490);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$3 */
    class C289843 extends C4884c<C32604oh> {
        C289843() {
            AppMethodBeat.m2504i(24477);
            this.xxI = C32604oh.class.getName().hashCode();
            AppMethodBeat.m2505o(24477);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24478);
            if (((C32604oh) c4883b) instanceof C32604oh) {
                C7060h.pYm.mo8381e(10221, Integer.valueOf(r7.cKC.scene));
                AppMethodBeat.m2505o(24478);
            } else {
                C4990ab.m7412e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
                AppMethodBeat.m2505o(24478);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$5 */
    class C289855 implements C1837a {
        C289855() {
        }

        /* renamed from: a */
        public final void mo5414a(final C1197a c1197a) {
            AppMethodBeat.m2504i(24482);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                AppMethodBeat.m2505o(24482);
                return;
            }
            C28987m.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24481);
                    C28987m.cjX().mo47086i(a, c1197a.eAB.ptF, 1);
                    AppMethodBeat.m2505o(24481);
                }
            });
            AppMethodBeat.m2505o(24482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$10 */
    static class C2898810 implements C1366d {
        C2898810() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46199o.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$2 */
    class C289892 implements C5132a {
        C289892() {
        }

        /* renamed from: a */
        public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
            AppMethodBeat.m2504i(24476);
            if (c7617ak != null && C1855t.m3917nC(c7617ak.field_username)) {
                c7617ak.setUsername("");
            }
            AppMethodBeat.m2505o(24476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$7 */
    class C289907 extends C4884c<C26242ss> {
        C289907() {
            AppMethodBeat.m2504i(24485);
            this.xxI = C26242ss.class.getName().hashCode();
            AppMethodBeat.m2505o(24485);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24486);
            C26242ss c26242ss = (C26242ss) c4883b;
            if (c26242ss.cOR.cOS.equals(C18377qm.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C28987m.this.qse.axy();
                } else {
                    C28987m.this.qse.unregister();
                }
            }
            AppMethodBeat.m2505o(24486);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$8 */
    static class C289918 implements C1366d {
        C289918() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C13247e.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$9 */
    static class C289929 implements C1366d {
        C289929() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C13249g.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$11 */
    static class C2899311 implements C1366d {
        C2899311() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46196k.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.m$1 */
    class C289941 extends C35783d {
        C289941() {
        }

        /* renamed from: NJ */
        public final C4883b mo36283NJ(String str) {
            AppMethodBeat.m2504i(24474);
            C18377qm c18377qm = new C18377qm();
            c18377qm.cMF.ctq = str;
            AppMethodBeat.m2505o(24474);
            return c18377qm;
        }

        public final C7296k bCU() {
            AppMethodBeat.m2504i(24475);
            C13249g cjT = C28987m.cjT();
            AppMethodBeat.m2505o(24475);
            return cjT;
        }
    }

    public C28987m() {
        AppMethodBeat.m2504i(24491);
        AppMethodBeat.m2505o(24491);
    }

    static /* synthetic */ C28987m cjZ() {
        AppMethodBeat.m2504i(24504);
        C28987m cjR = C28987m.cjR();
        AppMethodBeat.m2505o(24504);
        return cjR;
    }

    private static C28987m cjR() {
        AppMethodBeat.m2504i(24492);
        C9638aw.m17184ZE();
        C28987m c28987m = (C28987m) C45439bw.m83697oJ("plugin.shake");
        if (c28987m == null) {
            c28987m = new C28987m();
            C9638aw.m17184ZE().mo73244a("plugin.shake", c28987m);
        }
        AppMethodBeat.m2505o(24492);
        return c28987m;
    }

    public static C13247e cjS() {
        AppMethodBeat.m2504i(24493);
        C1720g.m3534RN().mo5159QU();
        if (C28987m.cjR().qrY == null) {
            C28987m cjR = C28987m.cjR();
            C9638aw.m17190ZK();
            cjR.qrY = new C13247e(C18628c.m29069Ru());
        }
        C13247e c13247e = C28987m.cjR().qrY;
        AppMethodBeat.m2505o(24493);
        return c13247e;
    }

    public static C13249g cjT() {
        AppMethodBeat.m2504i(24494);
        C1720g.m3534RN().mo5159QU();
        if (C28987m.cjR().qrZ == null) {
            C28987m cjR = C28987m.cjR();
            C9638aw.m17190ZK();
            cjR.qrZ = new C13249g(C18628c.m29069Ru());
        }
        C13249g c13249g = C28987m.cjR().qrZ;
        AppMethodBeat.m2505o(24494);
        return c13249g;
    }

    public static C46199o cjU() {
        AppMethodBeat.m2504i(24495);
        C1720g.m3534RN().mo5159QU();
        if (C28987m.cjR().qsc == null) {
            C28987m cjR = C28987m.cjR();
            C9638aw.m17190ZK();
            cjR.qsc = new C46199o(C18628c.m29069Ru());
        }
        C46199o c46199o = C28987m.cjR().qsc;
        AppMethodBeat.m2505o(24495);
        return c46199o;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(24496);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15808d(this.flN);
        C4879a.xxA.mo10053d(this.egQ);
        C4879a.xxA.mo10053d(this.qsg);
        C4879a.xxA.mo10053d(this.qsd);
        C4879a.xxA.mo10053d(this.oMA);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo15729b(this.oPE);
        C9638aw.getSysCmdMsgExtension().mo14903b("shake", this.qsf, true);
        C9638aw.getSysCmdMsgExtension().mo14903b("ShakeCardEntrance", this.qsh, true);
        C9638aw.getSysCmdMsgExtension().mo14903b("ShakeCardRedDot", this.qsi, true);
        C14896a.vav = null;
        AppMethodBeat.m2505o(24496);
    }

    static {
        AppMethodBeat.m2504i(24505);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new C289918());
        eaA.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new C289929());
        eaA.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new C2898810());
        eaA.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new C2899311());
        AppMethodBeat.m2505o(24505);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    public static void cjV() {
        AppMethodBeat.m2504i(24497);
        C28987m.cjS().cjH();
        C41789d.akR().axQ();
        AppMethodBeat.m2505o(24497);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(24498);
        C14896a.vav = new C13250h();
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15805c(this.flN);
        C4879a.xxA.mo10052c(this.egQ);
        C4879a.xxA.mo10052c(this.qsg);
        C4879a.xxA.mo10052c(this.qsd);
        C4879a.xxA.mo10052c(this.oMA);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo15707a(this.oPE);
        C9638aw.m17180RS().mo10302aa(new C1325112());
        C9638aw.getSysCmdMsgExtension().mo14900a("shake", this.qsf, true);
        C9638aw.getSysCmdMsgExtension().mo14900a("ShakeCardEntrance", this.qsh, true);
        C9638aw.getSysCmdMsgExtension().mo14900a("ShakeCardRedDot", this.qsi, true);
        this.qsa = null;
        this.qsb = null;
        AppMethodBeat.m2505o(24498);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static C46195i cjW() {
        AppMethodBeat.m2504i(24499);
        C1720g.m3534RN().mo5159QU();
        C46195i c46195i = C46195i.qrN;
        AppMethodBeat.m2505o(24499);
        return c46195i;
    }

    /* renamed from: sw */
    public static String m46015sw(String str) {
        AppMethodBeat.m2504i(24500);
        String format;
        if (C9638aw.m17179RK()) {
            r1 = new Object[2];
            C9638aw.m17190ZK();
            r1[0] = C18628c.m29094Yc();
            r1[1] = C1178g.m2591x(str.getBytes());
            format = String.format("%s/Sk_%s", r1);
            AppMethodBeat.m2505o(24500);
            return format;
        }
        format = "";
        AppMethodBeat.m2505o(24500);
        return format;
    }

    /* renamed from: fQ */
    public static String m46014fQ(String str, String str2) {
        AppMethodBeat.m2504i(24501);
        String str3;
        if (!C9638aw.m17179RK() || C5046bo.isNullOrNil(str)) {
            str3 = "";
            AppMethodBeat.m2505o(24501);
            return str3;
        }
        r1 = new Object[3];
        C9638aw.m17190ZK();
        r1[0] = C18628c.m29094Yc();
        r1[1] = str2;
        r1[2] = C1178g.m2591x(str.getBytes());
        str3 = String.format("%s/Sk%s_%s", r1);
        AppMethodBeat.m2505o(24501);
        return str3;
    }

    public static C28997f cjX() {
        AppMethodBeat.m2504i(24502);
        C1720g.m3534RN().mo5159QU();
        if (C28987m.cjR().qsa == null) {
            C28987m.cjR().qsa = new C28997f();
        }
        C28997f c28997f = C28987m.cjR().qsa;
        AppMethodBeat.m2505o(24502);
        return c28997f;
    }

    public static C46197d cjY() {
        AppMethodBeat.m2504i(24503);
        C1720g.m3534RN().mo5159QU();
        if (C28987m.cjR().qsb == null) {
            C28987m.cjR().qsb = new C46197d();
        }
        C46197d c46197d = C28987m.cjR().qsb;
        AppMethodBeat.m2505o(24503);
        return c46197d;
    }
}
