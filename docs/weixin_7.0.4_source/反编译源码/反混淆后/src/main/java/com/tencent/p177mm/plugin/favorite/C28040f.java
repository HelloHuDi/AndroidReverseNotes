package com.tencent.p177mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C37720gf;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C6892ab;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.favorite.f */
public final class C28040f implements C1816at {
    private C4884c mqs = new C280411();

    /* renamed from: com.tencent.mm.plugin.favorite.f$1 */
    class C280411 extends C4884c<C37720gf> {
        C280411() {
            AppMethodBeat.m2504i(20535);
            this.xxI = C37720gf.class.getName().hashCode();
            AppMethodBeat.m2505o(20535);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20536);
            C37720gf c37720gf = (C37720gf) c4883b;
            if (c37720gf.cAC.cAD != null && (c37720gf.cAC.cAD instanceof C23273a) && c37720gf.cAC.csX != null && (c37720gf.cAC.csX instanceof Context)) {
                C27966g c27966g;
                C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c37720gf.cAC.cvv);
                if (iE != null || C5046bo.isNullOrNil(c37720gf.cAC.cAE)) {
                    c27966g = iE;
                } else {
                    c27966g = C39037b.m66341LF(c37720gf.cAC.cAE);
                }
                C23273a c23273a = (C23273a) c37720gf.cAC.cAD;
                Context context = (Context) c37720gf.cAC.csX;
                C43093d.m76580a(c23273a, context, c27966g);
                C43093d.m76585b(c23273a, context, c27966g);
            }
            c37720gf.cAC.cvv = 0;
            c37720gf.cAC.cAD = null;
            c37720gf.cAC.csX = null;
            AppMethodBeat.m2505o(20536);
            return false;
        }
    }

    public C28040f() {
        AppMethodBeat.m2504i(20537);
        AppMethodBeat.m2505o(20537);
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(20538);
        C4990ab.m7417i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", Boolean.valueOf(z));
        C4879a.xxA.mo10051b(this.mqs);
        C1720g.m3542a(C20679y.class, new C45941c());
        C1720g.m3542a(C6892ab.class, new C28039e());
        AppMethodBeat.m2505o(20538);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(20539);
        C4879a.xxA.mo10053d(this.mqs);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(128);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4192);
        AppMethodBeat.m2505o(20539);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }
}
