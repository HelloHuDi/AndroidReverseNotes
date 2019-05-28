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

/* renamed from: com.bumptech.glide.c.b.b */
final class C17521b implements C0743a<Object>, C0753e {
    private File aAa;
    private final List<C0779h> azS;
    private final C37168f<?> azT;
    private final C0754a azU;
    private int azV;
    private C0779h azW;
    private List<C37175n<File, ?>> azX;
    private int azY;
    private volatile C37176a<?> azZ;

    C17521b(C37168f<?> c37168f, C0754a c0754a) {
        this(c37168f.mo59249mp(), c37168f, c0754a);
        AppMethodBeat.m2504i(91752);
        AppMethodBeat.m2505o(91752);
    }

    C17521b(List<C0779h> list, C37168f<?> c37168f, C0754a c0754a) {
        this.azV = -1;
        this.azS = list;
        this.azT = c37168f;
        this.azU = c0754a;
    }

    /* renamed from: mk */
    public final boolean mo2211mk() {
        boolean z = false;
        AppMethodBeat.m2504i(91753);
        while (true) {
            if (this.azX == null || !m27349ml()) {
                this.azV++;
                if (this.azV >= this.azS.size()) {
                    AppMethodBeat.m2505o(91753);
                    break;
                }
                C0779h c0779h = (C0779h) this.azS.get(this.azV);
                this.aAa = this.azT.mo59247mn().mo52046a(new C25421c(c0779h, this.azT.aAb));
                if (this.aAa != null) {
                    this.azW = c0779h;
                    this.azX = this.azT.mo59251n(this.aAa);
                    this.azY = 0;
                }
            } else {
                this.azZ = null;
                while (!z && m27349ml()) {
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
                AppMethodBeat.m2505o(91753);
            }
        }
        return z;
    }

    /* renamed from: ml */
    private boolean m27349ml() {
        AppMethodBeat.m2504i(91754);
        if (this.azY < this.azX.size()) {
            AppMethodBeat.m2505o(91754);
            return true;
        }
        AppMethodBeat.m2505o(91754);
        return false;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(91755);
        C37176a c37176a = this.azZ;
        if (c37176a != null) {
            c37176a.aEq.cancel();
        }
        AppMethodBeat.m2505o(91755);
    }

    /* renamed from: S */
    public final void mo2189S(Object obj) {
        AppMethodBeat.m2504i(91756);
        this.azU.mo2213a(this.azW, obj, this.azZ.aEq, C25405a.DATA_DISK_CACHE, this.azW);
        AppMethodBeat.m2505o(91756);
    }

    /* renamed from: b */
    public final void mo2190b(Exception exception) {
        AppMethodBeat.m2504i(91757);
        this.azU.mo2212a(this.azW, exception, this.azZ.aEq, C25405a.DATA_DISK_CACHE);
        AppMethodBeat.m2505o(91757);
    }
}
