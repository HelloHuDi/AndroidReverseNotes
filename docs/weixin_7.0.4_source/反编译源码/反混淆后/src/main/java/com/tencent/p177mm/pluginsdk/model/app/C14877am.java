package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26408ad.C26410a;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p230g.p231a.C9312cy;
import com.tencent.p177mm.p230g.p231a.C9372hn;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.model.C30072b;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.model.app.C30061al.C30062a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.pluginsdk.model.app.am */
public class C14877am implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C35798o vcO;
    private C30062a vcP = null;
    private C7237j vcQ = new C7237j();
    private C30072b vcR = new C30072b();
    private C4884c vcS = new C148794();
    private C4884c vcT = new C148805();

    /* renamed from: com.tencent.mm.pluginsdk.model.app.am$2 */
    static class C148782 implements C1366d {
        C148782() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35798o.fnj;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.app.am$4 */
    class C148794 extends C4884c<C9372hn> {
        C148794() {
            AppMethodBeat.m2504i(27414);
            this.xxI = C9372hn.class.getName().hashCode();
            AppMethodBeat.m2505o(27414);
        }

        /* renamed from: a */
        private static boolean m23145a(C9372hn c9372hn) {
            int i;
            AppMethodBeat.m2504i(27415);
            try {
                if (C26373g.m41964Nu() == null) {
                    i = 0;
                } else {
                    i = C5046bo.getInt(C26373g.m41964Nu().getValue("AndroidUseUnicodeEmoji"), 0);
                }
            } catch (Exception e) {
                i = 0;
            }
            c9372hn.cCr.cwb = i;
            AppMethodBeat.m2505o(27415);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.app.am$5 */
    class C148805 extends C4884c<C6471cq> {
        C148805() {
            AppMethodBeat.m2504i(27417);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(27417);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(27418);
            int i = C5046bo.getInt(C26373g.m41964Nu().getValue("AndroidUseUnicodeEmoji"), 0);
            C9312cy c9312cy = new C9312cy();
            c9312cy.cwa.cwb = i;
            C4879a.xxA.mo10055m(c9312cy);
            AppMethodBeat.m2505o(27418);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.app.am$1 */
    static class C148811 implements C1366d {
        C148811() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C14884k.fnj;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.app.am$3 */
    class C148823 implements Runnable {
        C148823() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27413);
            SightVideoJNI.registerALL();
            AppMethodBeat.m2505o(27413);
        }
    }

    public C14877am() {
        AppMethodBeat.m2504i(27419);
        AppMethodBeat.m2505o(27419);
    }

    private static C14877am dhL() {
        AppMethodBeat.m2504i(27420);
        C9638aw.m17184ZE();
        C14877am c14877am = (C14877am) C45439bw.m83697oJ(C14877am.class.getName());
        if (c14877am == null) {
            c14877am = new C14877am();
        }
        AppMethodBeat.m2505o(27420);
        return c14877am;
    }

    public static C7237j dhM() {
        AppMethodBeat.m2504i(27421);
        C7237j c7237j = C14877am.dhL().vcQ;
        AppMethodBeat.m2505o(27421);
        return c7237j;
    }

    public static C30066c aUq() {
        AppMethodBeat.m2504i(27422);
        C30066c aUq = C34832a.aUq();
        AppMethodBeat.m2505o(27422);
        return aUq;
    }

    public static C41337h bYI() {
        AppMethodBeat.m2504i(27423);
        C41337h bYI = C34832a.bYI();
        AppMethodBeat.m2505o(27423);
        return bYI;
    }

    public static C35796i bYJ() {
        AppMethodBeat.m2504i(27424);
        C35796i bYJ = C34832a.bYJ();
        AppMethodBeat.m2505o(27424);
        return bYJ;
    }

    public static C14884k dhN() {
        AppMethodBeat.m2504i(27425);
        C14884k bYK = C34832a.bYK();
        AppMethodBeat.m2505o(27425);
        return bYK;
    }

    public static C35798o dhO() {
        AppMethodBeat.m2504i(27426);
        C1720g.m3534RN().mo5159QU();
        if (C14877am.dhL().vcO == null) {
            C14877am dhL = C14877am.dhL();
            C9638aw.m17190ZK();
            dhL.vcO = new C35798o(C18628c.m29069Ru());
        }
        C35798o c35798o = C14877am.dhL().vcO;
        AppMethodBeat.m2505o(27426);
        return c35798o;
    }

    public static C30062a dhP() {
        AppMethodBeat.m2504i(27427);
        C1720g.m3534RN().mo5159QU();
        if (C14877am.dhL().vcP == null) {
            C14877am.dhL().vcP = new C30062a();
        }
        C30062a c30062a = C14877am.dhL().vcP;
        AppMethodBeat.m2505o(27427);
        return c30062a;
    }

    public static C4735m bYL() {
        AppMethodBeat.m2504i(27428);
        C4735m bYL = C34832a.bYL();
        AppMethodBeat.m2505o(27428);
        return bYL;
    }

    public static C14883d bYM() {
        AppMethodBeat.m2504i(27429);
        C14883d bYM = C34832a.bYM();
        AppMethodBeat.m2505o(27429);
        return bYM;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(27430);
        C30062a c30062a = C14877am.dhL().vcP;
        if (c30062a != null) {
            c30062a.cqV = 0;
        }
        C1200d.m2637b(Integer.valueOf(47), this.vcR);
        C1200d.m2637b(Integer.valueOf(49), this.vcQ);
        C4879a.xxA.mo10053d(this.vcS);
        C4879a.xxA.mo10053d(this.vcT);
        C30076j.dhc();
        AppMethodBeat.m2505o(27430);
    }

    static {
        AppMethodBeat.m2504i(27432);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new C148811());
        eaA.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new C148782());
        AppMethodBeat.m2505o(27432);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(27431);
        C26410a.fls = C34832a.bYI();
        C1200d.m2636a(Integer.valueOf(47), this.vcR);
        C1200d.m2636a(Integer.valueOf(49), this.vcQ);
        C4879a.xxA.mo10052c(this.vcS);
        C4879a.xxA.mo10052c(this.vcT);
        C148823 c148823 = new C148823();
        try {
            c148823.run();
            AppMethodBeat.m2505o(27431);
        } catch (Throwable th) {
            if (C1443d.m3067fP(20)) {
                c148823.run();
                AppMethodBeat.m2505o(27431);
                return;
            }
            AppMethodBeat.m2505o(27431);
        }
    }
}
