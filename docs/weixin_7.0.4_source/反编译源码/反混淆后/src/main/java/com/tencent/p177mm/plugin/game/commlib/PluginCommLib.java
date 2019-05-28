package com.tencent.p177mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.plugin.game.commlib.p1650d.C45986a;
import com.tencent.p177mm.plugin.game.commlib.p977a.C12106b;
import com.tencent.p177mm.plugin.game.commlib.p977a.C34261a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.commlib.PluginCommLib */
public class PluginCommLib extends C7597f implements C9562c, C12106b {
    private C4884c lOc = new C342601();

    /* renamed from: com.tencent.mm.plugin.game.commlib.PluginCommLib$1 */
    class C342601 extends C4884c<C37748jt> {
        C342601() {
            AppMethodBeat.m2504i(59410);
            this.xxI = C37748jt.class.getName().hashCode();
            AppMethodBeat.m2505o(59410);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(59411);
            C4990ab.m7416i("MicroMsg.PluginCommLib", "manual force login");
            C20945b.bDn().mo36287hI(true);
            AppMethodBeat.m2505o(59411);
            return false;
        }
    }

    public PluginCommLib() {
        AppMethodBeat.m2504i(59412);
        AppMethodBeat.m2505o(59412);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(59414);
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C34261a.class, new C12107d());
        }
        AppMethodBeat.m2505o(59414);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(59415);
        C4879a.xxA.mo10051b(this.lOc);
        AppMethodBeat.m2505o(59415);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(59416);
        C4879a.xxA.mo10053d(this.lOc);
        C45986a.aNR();
        AppMethodBeat.m2505o(59416);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(59413);
        C28180e.m44759NL(c1681g.eHT);
        AppMethodBeat.m2505o(59413);
    }
}
