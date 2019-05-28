package com.tencent.p177mm.plugin.music.model;

import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26083af;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p231a.C32512ae;
import com.tencent.p177mm.p230g.p711c.C42112dl;
import com.tencent.p177mm.p230g.p711c.C45395db;
import com.tencent.p177mm.plugin.music.model.p1000e.C12680b;
import com.tencent.p177mm.plugin.music.model.p1000e.C34596d;
import com.tencent.p177mm.plugin.music.model.p466d.C12677e;
import com.tencent.p177mm.plugin.music.model.p998a.C28569a;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p462e.C28560f;
import com.tencent.p177mm.plugin.music.p462e.C39434d;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p462e.C43326m;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p467ui.C3543a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.music.model.e */
public class C39445e implements C1816at {
    private C4884c gRa = new C126793();
    private C4884c<C26111d> mGU = new C394464();
    private C4884c oMA = new C28560f();
    private C12680b oMx;
    private ClipboardManager oMy;
    private C34596d oMz;

    /* renamed from: com.tencent.mm.plugin.music.model.e$1 */
    class C126781 implements C1366d {
        C126781() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(104892);
            String[] strArr = new String[1];
            Class cls = C45395db.class;
            strArr[0] = C7563j.m13217a(C45395db.m83583Hm(), "Music");
            AppMethodBeat.m2505o(104892);
            return strArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.e$3 */
    class C126793 extends C4884c<C32512ae> {
        C126793() {
            AppMethodBeat.m2504i(104894);
            this.xxI = C32512ae.class.getName().hashCode();
            AppMethodBeat.m2505o(104894);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(104895);
            C26083af c26083af = new C26083af();
            c26083af.csZ.ctb = new C3543a(C4996ah.getContext());
            C4879a.xxA.mo10055m(c26083af);
            AppMethodBeat.m2505o(104895);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.e$2 */
    class C285742 implements C1366d {
        C285742() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(104893);
            String[] strArr = new String[1];
            Class cls = C42112dl.class;
            strArr[0] = C7563j.m13217a(C42112dl.m74240Hm(), "PieceMusicInfo");
            AppMethodBeat.m2505o(104893);
            return strArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.e$4 */
    class C394464 extends C4884c<C26111d> {
        C394464() {
            AppMethodBeat.m2504i(104896);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(104896);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(104897);
            if (!((C26111d) c4883b).crQ.crR) {
                new C28569a().bUn();
            }
            AppMethodBeat.m2505o(104897);
            return false;
        }
    }

    public C39445e() {
        AppMethodBeat.m2504i(104898);
        AppMethodBeat.m2505o(104898);
    }

    private static C39445e bUj() {
        AppMethodBeat.m2504i(104899);
        C39445e c39445e = (C39445e) C7485q.m12925Y(C39445e.class);
        AppMethodBeat.m2505o(104899);
        return c39445e;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        AppMethodBeat.m2504i(104900);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("Music".hashCode()), new C126781());
        hashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new C285742());
        AppMethodBeat.m2505o(104900);
        return hashMap;
    }

    public static C12680b bUk() {
        AppMethodBeat.m2504i(104901);
        if (C39445e.bUj().oMx == null) {
            C39445e.bUj().oMx = new C12680b(C1720g.m3536RP().eJN);
        }
        C12680b c12680b = C39445e.bUj().oMx;
        AppMethodBeat.m2505o(104901);
        return c12680b;
    }

    public static ClipboardManager bUl() {
        AppMethodBeat.m2504i(104902);
        if (C39445e.bUj().oMy == null) {
            C39445e.bUj().oMy = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        }
        ClipboardManager clipboardManager = C39445e.bUj().oMy;
        AppMethodBeat.m2505o(104902);
        return clipboardManager;
    }

    public static C34596d bUm() {
        AppMethodBeat.m2504i(104903);
        if (C39445e.bUj().oMz == null) {
            C39445e.bUj().oMz = new C34596d(C1720g.m3536RP().eJN);
        }
        C34596d c34596d = C39445e.bUj().oMz;
        AppMethodBeat.m2505o(104903);
        return c34596d;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(104904);
        this.mGU.dnU();
        this.oMA.dnU();
        this.gRa.dnU();
        C43326m c43326m = new C43326m();
        C39435k.m67367a(c43326m);
        C43329b.m77294a(C28559e.class, c43326m);
        C43329b.m77294a(C39434d.class, new C12677e());
        AppMethodBeat.m2505o(104904);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(104905);
        C39435k.bUg();
        C43329b.m77293L(C28559e.class);
        this.oMx = null;
        this.oMy = null;
        this.oMz = null;
        C4879a.xxA.mo10053d(this.oMA);
        this.oMA.dead();
        this.gRa.dead();
        this.mGU.dead();
        AppMethodBeat.m2505o(104905);
    }
}
