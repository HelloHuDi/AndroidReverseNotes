package com.tencent.p177mm.plugin.readerapp.p1015c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.model.C32780bm;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C37443d.C17888a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.readerapp.c.g */
public class C39565g implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C32780bm pEL;
    private C28795c pEM = new C28795c();
    private C21567a pEN = new C21567a();
    private C28796d pEO = new C28796d();
    private C46156f pEP = new C46156f();

    /* renamed from: com.tencent.mm.plugin.readerapp.c.g$a */
    public interface C12945a {
        void cdW();
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.c.g$1 */
    static class C395661 implements C1366d {
        C395661() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C32780bm.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.c.g$4 */
    class C395684 implements Runnable {
        C395684() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76767);
            if (C1720g.m3531RK()) {
                C5046bo.m7583o(C43217c.m76863XW(), "ReaderApp_", 604800000);
                AppMethodBeat.m2505o(76767);
                return;
            }
            AppMethodBeat.m2505o(76767);
        }

        public final String toString() {
            AppMethodBeat.m2504i(76768);
            String str = super.toString() + "|onAccountPostReset";
            AppMethodBeat.m2505o(76768);
            return str;
        }
    }

    public C39565g() {
        AppMethodBeat.m2504i(76769);
        AppMethodBeat.m2505o(76769);
    }

    /* renamed from: d */
    static /* synthetic */ void m67626d(C12945a c12945a) {
        AppMethodBeat.m2504i(76782);
        C39565g.m67624c(c12945a);
        AppMethodBeat.m2505o(76782);
    }

    private static C39565g cdY() {
        AppMethodBeat.m2504i(76770);
        C39565g c39565g = (C39565g) C7485q.m12925Y(C39565g.class);
        AppMethodBeat.m2505o(76770);
        return c39565g;
    }

    public static C32780bm cdZ() {
        AppMethodBeat.m2504i(76771);
        C1720g.m3534RN().mo5159QU();
        if (C39565g.cdY().pEL == null) {
            C39565g.cdY().pEL = new C32780bm(C1720g.m3536RP().eJN);
        }
        C32780bm c32780bm = C39565g.cdY().pEL;
        AppMethodBeat.m2505o(76771);
        return c32780bm;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(76772);
        C17888a.m28061b(this.pEM);
        C4879a.xxA.mo10053d(this.pEN);
        C4879a.xxA.mo10053d(this.pEO);
        C4879a.xxA.mo10053d(this.pEP);
        C43418e c43418e = C43418e.pEK;
        AppMethodBeat.m2505o(76772);
    }

    static {
        AppMethodBeat.m2504i(76783);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new C395661());
        AppMethodBeat.m2505o(76783);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(76773);
        if ((SQLiteGlobal.journalSizeLimit & i) != 0) {
            C39565g.m67622a(null);
        }
        if ((262144 & i) != 0) {
            C39565g.m67623b(null);
        }
        AppMethodBeat.m2505o(76773);
    }

    /* renamed from: a */
    public static void m67622a(C12945a c12945a) {
        AppMethodBeat.m2504i(76774);
        C39565g.cdZ().mo53339kJ(20);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("newsapp");
        C39565g.m67621a(20, c12945a);
        AppMethodBeat.m2505o(76774);
    }

    /* renamed from: b */
    public static void m67623b(C12945a c12945a) {
        AppMethodBeat.m2504i(76775);
        C39565g.cdZ().mo53339kJ(11);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("blogapp");
        C39565g.m67621a(11, c12945a);
        AppMethodBeat.m2505o(76775);
    }

    /* renamed from: jA */
    public static void m67627jA(long j) {
        AppMethodBeat.m2504i(76776);
        C39565g.m67628n(C39565g.cdZ().mo53337fn(j), 20);
        AppMethodBeat.m2505o(76776);
    }

    /* renamed from: cU */
    public static void m67625cU(String str, int i) {
        AppMethodBeat.m2504i(76777);
        C39565g.m67628n(C39565g.cdZ().mo53334Q(str, i), i);
        AppMethodBeat.m2505o(76777);
    }

    /* renamed from: n */
    private static void m67628n(List<C32779bl> list, int i) {
        AppMethodBeat.m2504i(76778);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(76778);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                if (i3 == 0) {
                    C5046bo.deleteFile(C30080q.m47642v(((C32779bl) list.get(i3)).aan(), i, "@T"));
                } else {
                    C5046bo.deleteFile(C30080q.m47642v(((C32779bl) list.get(i3)).aan(), i, "@S"));
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(76778);
                return;
            }
        }
    }

    /* renamed from: c */
    private static void m67624c(final C12945a c12945a) {
        AppMethodBeat.m2504i(76779);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(76764);
                if (c12945a != null) {
                    c12945a.cdW();
                }
                AppMethodBeat.m2505o(76764);
            }
        });
        AppMethodBeat.m2505o(76779);
    }

    /* renamed from: a */
    private static void m67621a(final int i, final C12945a c12945a) {
        AppMethodBeat.m2504i(76780);
        if (C1720g.m3531RK()) {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.m2504i(76765);
                    C5728b c5728b = new C5728b(C43217c.m76863XW());
                    if (c5728b.exists() && c5728b.isDirectory()) {
                        C5728b[] dMF = c5728b.dMF();
                        if (dMF == null || dMF.length <= 0) {
                            C39565g.m67626d(c12945a);
                            AppMethodBeat.m2505o(76765);
                            return;
                        }
                        String format = String.format("reader_%d_", new Object[]{Integer.valueOf(i)});
                        String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(i)});
                        while (i < dMF.length) {
                            if (dMF[i].getName().startsWith(format)) {
                                dMF[i].delete();
                            }
                            if (dMF[i].getName().startsWith(format2)) {
                                dMF[i].delete();
                            }
                            i++;
                        }
                        C39565g.m67626d(c12945a);
                        AppMethodBeat.m2505o(76765);
                        return;
                    }
                    C39565g.m67626d(c12945a);
                    AppMethodBeat.m2505o(76765);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(76766);
                    String str = super.toString() + "|deleteAllPic";
                    AppMethodBeat.m2505o(76766);
                    return str;
                }
            });
            AppMethodBeat.m2505o(76780);
            return;
        }
        C39565g.m67624c(c12945a);
        AppMethodBeat.m2505o(76780);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(76781);
        C17888a.m28060a(this.pEM);
        C1720g.m3539RS().mo10302aa(new C395684());
        C4879a.xxA.mo10052c(this.pEN);
        C4879a.xxA.mo10052c(this.pEO);
        C4879a.xxA.mo10052c(this.pEP);
        C43418e c43418e = C43418e.pEK;
        AppMethodBeat.m2505o(76781);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
