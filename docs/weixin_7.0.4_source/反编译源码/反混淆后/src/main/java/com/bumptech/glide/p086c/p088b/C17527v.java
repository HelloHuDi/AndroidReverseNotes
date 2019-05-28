package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p088b.C0753e.C0754a;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.v */
final class C17527v implements C0743a<Object>, C0753e {
    private File aAa;
    private int aCg = -1;
    private C41548w aCh;
    private final C37168f<?> azT;
    private final C0754a azU;
    private int azV;
    private C0779h azW;
    private List<C37175n<File, ?>> azX;
    private int azY;
    private volatile C37176a<?> azZ;

    C17527v(C37168f<?> c37168f, C0754a c0754a) {
        this.azT = c37168f;
        this.azU = c0754a;
    }

    /* renamed from: mk */
    public final boolean mo2211mk() {
        AppMethodBeat.m2504i(91877);
        List mp = this.azT.mo59249mp();
        if (mp.isEmpty()) {
            AppMethodBeat.m2505o(91877);
            return false;
        }
        C37168f c37168f = this.azT;
        List b = c37168f.awi.awj.mo52081b(c37168f.axb.getClass(), c37168f.aAf, c37168f.awY);
        if (b.isEmpty() && File.class.equals(this.azT.awY)) {
            AppMethodBeat.m2505o(91877);
            return false;
        }
        while (true) {
            if (this.azX == null || !m27364ml()) {
                this.aCg++;
                if (this.aCg >= b.size()) {
                    this.azV++;
                    if (this.azV >= mp.size()) {
                        AppMethodBeat.m2505o(91877);
                        return false;
                    }
                    this.aCg = 0;
                }
                C0779h c0779h = (C0779h) mp.get(this.azV);
                Class cls = (Class) b.get(this.aCg);
                this.aCh = new C41548w(this.azT.awi.awk, c0779h, this.azT.aAb, this.azT.width, this.azT.height, this.azT.mo59250n(cls), cls, this.azT.aAd);
                this.aAa = this.azT.mo59247mn().mo52046a(this.aCh);
                if (this.aAa != null) {
                    this.azW = c0779h;
                    this.azX = this.azT.mo59251n(this.aAa);
                    this.azY = 0;
                }
            } else {
                this.azZ = null;
                boolean z = false;
                while (!z && m27364ml()) {
                    boolean z2;
                    List list = this.azX;
                    int i = this.azY;
                    this.azY = i + 1;
                    this.azZ = ((C37175n) list.get(i)).mo2225b(this.aAa, this.azT.width, this.azT.height, this.azT.aAd);
                    if (this.azZ == null || !this.azT.mo59245l(this.azZ.aEq.mo2187mg())) {
                        z2 = z;
                    } else {
                        z2 = true;
                        this.azZ.aEq.mo2184a(this.azT.aAk, this);
                    }
                    z = z2;
                }
                AppMethodBeat.m2505o(91877);
                return z;
            }
        }
    }

    /* renamed from: ml */
    private boolean m27364ml() {
        AppMethodBeat.m2504i(91878);
        if (this.azY < this.azX.size()) {
            AppMethodBeat.m2505o(91878);
            return true;
        }
        AppMethodBeat.m2505o(91878);
        return false;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(91879);
        C37176a c37176a = this.azZ;
        if (c37176a != null) {
            c37176a.aEq.cancel();
        }
        AppMethodBeat.m2505o(91879);
    }

    /* renamed from: S */
    public final void mo2189S(Object obj) {
        AppMethodBeat.m2504i(91880);
        this.azU.mo2213a(this.azW, obj, this.azZ.aEq, C25405a.RESOURCE_DISK_CACHE, this.aCh);
        AppMethodBeat.m2505o(91880);
    }

    /* renamed from: b */
    public final void mo2190b(Exception exception) {
        AppMethodBeat.m2504i(91881);
        this.azU.mo2212a(this.aCh, exception, this.azZ.aEq, C25405a.RESOURCE_DISK_CACHE);
        AppMethodBeat.m2505o(91881);
    }
}
