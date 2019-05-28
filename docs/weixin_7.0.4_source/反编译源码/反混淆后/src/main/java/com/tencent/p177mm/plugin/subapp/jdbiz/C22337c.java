package com.tencent.p177mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C42012iw;
import com.tencent.p177mm.p230g.p231a.C6489hv;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14833a;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14834b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.subapp.jdbiz.c */
public class C22337c implements C1816at, C14834b {
    private C4884c ecA = new C139071();
    private C29389a ssE = null;
    private C22336b ssF = null;
    Map<String, Integer> ssG = new HashMap();

    /* renamed from: com.tencent.mm.plugin.subapp.jdbiz.c$1 */
    class C139071 extends C4884c<C6489hv> {
        C139071() {
            AppMethodBeat.m2504i(25201);
            this.xxI = C6489hv.class.getName().hashCode();
            AppMethodBeat.m2505o(25201);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25202);
            C6489hv c6489hv = (C6489hv) c4883b;
            if (c6489hv != null && (c6489hv instanceof C6489hv)) {
                c6489hv.cCO.url = C22337c.this.cDA();
            }
            AppMethodBeat.m2505o(25202);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.jdbiz.c$2 */
    class C223382 implements Runnable {
        C223382() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25203);
            C4879a.xxA.mo10055m(new C42012iw());
            AppMethodBeat.m2505o(25203);
        }
    }

    public final /* synthetic */ C14833a cDB() {
        AppMethodBeat.m2504i(25219);
        C22336b cDw = cDw();
        AppMethodBeat.m2505o(25219);
        return cDw;
    }

    public C22337c() {
        AppMethodBeat.m2504i(25204);
        C4990ab.m7416i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + C5046bo.dpG());
        AppMethodBeat.m2505o(25204);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(25206);
        C4990ab.m7416i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.ssE == null) {
            this.ssE = new C29389a();
        }
        C9638aw.getSysCmdMsgExtension().mo14900a("jd", this.ssE, true);
        C4879a.xxA.mo10052c(this.ecA);
        AppMethodBeat.m2505o(25206);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(25207);
        C4990ab.m7416i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.ssE != null) {
            C4879a.xxA.mo10053d(this.ssE.ssn);
            C9638aw.getSysCmdMsgExtension().mo14903b("jd", this.ssE, true);
        }
        this.ssG.clear();
        this.ssE = null;
        C4879a.xxA.mo10053d(this.ecA);
        AppMethodBeat.m2505o(25207);
    }

    public final boolean cDs() {
        AppMethodBeat.m2504i(25208);
        C9638aw.m17190ZK();
        boolean equals = "1".equals((String) C18628c.m29072Ry().get(327939, (Object) ""));
        AppMethodBeat.m2505o(25208);
        return equals;
    }

    public final boolean cDt() {
        AppMethodBeat.m2504i(25209);
        C9638aw.m17190ZK();
        boolean equals = "1".equals((String) C18628c.m29072Ry().get(327938, (Object) ""));
        AppMethodBeat.m2505o(25209);
        return equals;
    }

    public final void cDu() {
        AppMethodBeat.m2504i(25210);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(327938, (Object) "");
        AppMethodBeat.m2505o(25210);
    }

    public final void cDv() {
        AppMethodBeat.m2504i(25211);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(327939, (Object) "");
        AppMethodBeat.m2505o(25211);
    }

    public final C22336b cDw() {
        AppMethodBeat.m2504i(25212);
        if (this.ssF == null) {
            this.ssF = C22336b.cDj();
        }
        C22336b c22336b = this.ssF;
        AppMethodBeat.m2505o(25212);
        return c22336b;
    }

    /* renamed from: b */
    public static void m34039b(C22336b c22336b) {
        AppMethodBeat.m2504i(25213);
        C1720g.m3534RN().mo5159QU();
        C22337c cDr = C22337c.cDr();
        if (cDr.ssF == null) {
            cDr.ssF = C22336b.cDj();
        }
        C4990ab.m7417i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", cDr.ssF.mo37877SY(), c22336b.mo37877SY());
        if (c22336b.mo37879a(cDr.ssF)) {
            if (!C5046bo.isNullOrNil(c22336b.ssu) || c22336b.sst) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(327939, (Object) "1");
            }
            if (c22336b.sss) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(327938, (Object) "1");
            } else {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(327938, (Object) "");
            }
            cDr.ssF = c22336b;
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(327942, c22336b.cJh);
            cDr.cDx();
            AppMethodBeat.m2505o(25213);
            return;
        }
        C4990ab.m7416i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
        AppMethodBeat.m2505o(25213);
    }

    private void cDx() {
        AppMethodBeat.m2504i(25214);
        new C7306ak(Looper.getMainLooper()).post(new C223382());
        AppMethodBeat.m2505o(25214);
    }

    public final void cDy() {
        AppMethodBeat.m2504i(25215);
        if (C9638aw.m17179RK() && (C22337c.cDr().cDs() || C22337c.cDr().cDt())) {
            C22336b cDw = C22337c.cDr().cDw();
            if ((!C5046bo.isNullOrNil(cDw.ssu) || cDw.sst) && cDw.bxX()) {
                C4990ab.m7416i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                C22337c.cDr().cDu();
                C22337c.cDr().cDv();
                C22337c.cDr().cDx();
            }
        }
        AppMethodBeat.m2505o(25215);
    }

    /* renamed from: dn */
    public static String m34040dn(String str, int i) {
        AppMethodBeat.m2504i(25216);
        if (-1 == str.indexOf(35)) {
            if (-1 == str.indexOf(63)) {
                str = str + "?wc_scene=" + i;
            } else {
                str = str + "&wc_scene=" + i;
            }
        }
        AppMethodBeat.m2505o(25216);
        return str;
    }

    public static boolean cDz() {
        AppMethodBeat.m2504i(25217);
        String value = C26373g.m41964Nu().getValue("JDEntranceConfigName");
        String value2 = C26373g.m41964Nu().getValue("JDEntranceConfigIconUrl");
        String value3 = C26373g.m41964Nu().getValue("JDEntranceConfigJumpUrl");
        if (C5046bo.isNullOrNil(value) || C5046bo.isNullOrNil(value2) || C5046bo.isNullOrNil(value3)) {
            AppMethodBeat.m2505o(25217);
            return false;
        }
        AppMethodBeat.m2505o(25217);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String cDA() {
        int i = 1;
        AppMethodBeat.m2504i(25218);
        String value = C26373g.m41964Nu().getValue("JDEntranceConfigJumpUrl");
        if (C5046bo.isNullOrNil(value)) {
            AppMethodBeat.m2505o(25218);
            return null;
        }
        int i2;
        int i3;
        String dn;
        C22336b cDw = cDw();
        if (cDs()) {
            if (!cDw.bxX() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(cDw.ssq) && !C5046bo.isNullOrNil(cDw.jumpUrl)) {
                C4990ab.m7417i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", cDw.jumpUrl);
                value = cDw.jumpUrl;
                i2 = 6;
                if (cDw.ssw < System.currentTimeMillis() / 1000) {
                }
                if (i3 != 0) {
                }
                dn = C22337c.m34040dn(value, i2);
                AppMethodBeat.m2505o(25218);
                return dn;
            } else if (cDw.sst) {
                i2 = 2;
                if ("2".equals(cDw.ssq) && !C5046bo.isNullOrNil(cDw.jumpUrl)) {
                    if (cDw.ssw < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (cDw.ssx == 0 || cDw.ssx >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = cDw.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                dn = C22337c.m34040dn(value, i2);
                AppMethodBeat.m2505o(25218);
                return dn;
            }
        }
        i2 = 1;
        if (cDw.ssw < System.currentTimeMillis() / 1000) {
        }
        if (i3 != 0) {
        }
        dn = C22337c.m34040dn(value, i2);
        AppMethodBeat.m2505o(25218);
        return dn;
    }

    public static C22337c cDr() {
        AppMethodBeat.m2504i(25205);
        C22337c c22337c = (C22337c) C44044f.vdy;
        if (c22337c == null) {
            c22337c = new C22337c();
            C44044f.vdy = c22337c;
        }
        AppMethodBeat.m2505o(25205);
        return c22337c;
    }
}
