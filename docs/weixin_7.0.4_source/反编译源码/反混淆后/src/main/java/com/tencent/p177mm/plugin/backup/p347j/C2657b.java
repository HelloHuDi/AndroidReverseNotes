package com.tencent.p177mm.plugin.backup.p347j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26083af;
import com.tencent.p177mm.p230g.p231a.C26270x;
import com.tencent.p177mm.p230g.p231a.C32512ae;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.plugin.backup.backupui.C33672a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui.C27473a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.j.b */
public final class C2657b {
    private static C2657b jDg;
    C4884c gRa;
    C4884c jDe;
    C4884c jDf;

    /* renamed from: com.tencent.mm.plugin.backup.j.b$3 */
    class C26583 extends C4884c<C32512ae> {
        C26583() {
            AppMethodBeat.m2504i(18105);
            this.xxI = C32512ae.class.getName().hashCode();
            AppMethodBeat.m2505o(18105);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18106);
            C32512ae c32512ae = (C32512ae) c4883b;
            C4990ab.m7416i("MicroMsg.BackupEventListener", "receive BannerOnInitEvent.");
            C26083af c26083af = new C26083af();
            c26083af.csZ.ctb = new C27473a(c32512ae.csY.activity);
            c26083af.csZ.cta = false;
            C4879a.xxA.mo10055m(c26083af);
            c26083af = new C26083af();
            c26083af.csZ.ctb = new C33672a(c32512ae.csY.activity);
            c26083af.csZ.cta = false;
            C4879a.xxA.mo10055m(c26083af);
            AppMethodBeat.m2505o(18106);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.b$1 */
    class C26591 extends C4884c<C26270x> {
        C26591() {
            AppMethodBeat.m2504i(18101);
            this.xxI = C26270x.class.getName().hashCode();
            AppMethodBeat.m2505o(18101);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18102);
            C6798a.reset();
            AppMethodBeat.m2505o(18102);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.b$2 */
    class C26602 extends C4884c<C45382z> {
        C26602() {
            AppMethodBeat.m2504i(18103);
            this.xxI = C45382z.class.getName().hashCode();
            AppMethodBeat.m2505o(18103);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18104);
            boolean z = ((C45382z) c4883b).csU.csV;
            C33710c.m55092rK(1).mo61481m(Boolean.valueOf(z));
            AppMethodBeat.m2505o(18104);
            return false;
        }
    }

    public static C2657b aVg() {
        AppMethodBeat.m2504i(18107);
        if (jDg == null) {
            jDg = new C2657b();
        }
        C2657b c2657b = jDg;
        AppMethodBeat.m2505o(18107);
        return c2657b;
    }
}
