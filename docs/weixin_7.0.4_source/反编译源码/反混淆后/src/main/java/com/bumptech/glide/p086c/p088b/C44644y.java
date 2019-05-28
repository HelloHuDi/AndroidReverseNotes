package com.bumptech.glide.p086c.p088b;

import android.util.Log;
import com.bumptech.glide.C31976h.C31977e;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C37189d;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p088b.C0753e.C0754a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p095h.C31975e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.y */
final class C44644y implements C0743a<Object>, C0753e, C0754a {
    private int aCm;
    private C17521b aCn;
    private Object aCo;
    private C25421c aCp;
    private final C37168f<?> azT;
    private final C0754a azU;
    private volatile C37176a<?> azZ;

    C44644y(C37168f<?> c37168f, C0754a c0754a) {
        this.azT = c37168f;
        this.azU = c0754a;
    }

    /* renamed from: mk */
    public final boolean mo2211mk() {
        Object obj;
        AppMethodBeat.m2504i(91890);
        if (this.aCo != null) {
            obj = this.aCo;
            this.aCo = null;
            long ok = C31975e.m51954ok();
            try {
                C37189d u = this.azT.awi.awj.awN.mo66581u(obj.getClass());
                if (u != null) {
                    C0752d c0752d = new C0752d(u, obj, this.azT.aAd);
                    this.aCp = new C25421c(this.azZ.azW, this.azT.aAb);
                    this.azT.mo59247mn().mo52047a(this.aCp, c0752d);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        new StringBuilder("Finished encoding source to cache, key: ").append(this.aCp).append(", data: ").append(obj).append(", encoder: ").append(u).append(", duration: ").append(C31975e.m51955q(ok));
                    }
                    this.azZ.aEq.cleanup();
                    this.aCn = new C17521b(Collections.singletonList(this.azZ.azW), this.azT, this);
                } else {
                    C31977e c31977e = new C31977e(obj.getClass());
                    AppMethodBeat.m2505o(91890);
                    throw c31977e;
                }
            } catch (Throwable th) {
                this.azZ.aEq.cleanup();
                AppMethodBeat.m2505o(91890);
            }
        }
        if (this.aCn == null || !this.aCn.mo2211mk()) {
            this.aCn = null;
            this.azZ = null;
            boolean z = false;
            while (!z) {
                if (this.aCm < this.azT.mo59248mo().size()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    break;
                }
                List mo = this.azT.mo59248mo();
                int i = this.aCm;
                this.aCm = i + 1;
                this.azZ = (C37176a) mo.get(i);
                if (this.azZ != null && (this.azT.aAl.mo2215a(this.azZ.aEq.mo2188mh()) || this.azT.mo59245l(this.azZ.aEq.mo2187mg()))) {
                    this.azZ.aEq.mo2184a(this.azT.aAk, this);
                    z = true;
                }
            }
            AppMethodBeat.m2505o(91890);
            return z;
        }
        AppMethodBeat.m2505o(91890);
        return true;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(91891);
        C37176a c37176a = this.azZ;
        if (c37176a != null) {
            c37176a.aEq.cancel();
        }
        AppMethodBeat.m2505o(91891);
    }

    /* renamed from: S */
    public final void mo2189S(Object obj) {
        AppMethodBeat.m2504i(91892);
        C31938i c31938i = this.azT.aAl;
        if (obj == null || !c31938i.mo2215a(this.azZ.aEq.mo2188mh())) {
            this.azU.mo2213a(this.azZ.azW, obj, this.azZ.aEq, this.azZ.aEq.mo2188mh(), this.aCp);
            AppMethodBeat.m2505o(91892);
            return;
        }
        this.aCo = obj;
        this.azU.mo2214mm();
        AppMethodBeat.m2505o(91892);
    }

    /* renamed from: b */
    public final void mo2190b(Exception exception) {
        AppMethodBeat.m2504i(91893);
        this.azU.mo2212a(this.aCp, exception, this.azZ.aEq, this.azZ.aEq.mo2188mh());
        AppMethodBeat.m2505o(91893);
    }

    /* renamed from: mm */
    public final void mo2214mm() {
        AppMethodBeat.m2504i(91894);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(91894);
        throw unsupportedOperationException;
    }

    /* renamed from: a */
    public final void mo2213a(C0779h c0779h, Object obj, C0742d<?> c0742d, C25405a c25405a, C0779h c0779h2) {
        AppMethodBeat.m2504i(91895);
        this.azU.mo2213a(c0779h, obj, c0742d, this.azZ.aEq.mo2188mh(), c0779h);
        AppMethodBeat.m2505o(91895);
    }

    /* renamed from: a */
    public final void mo2212a(C0779h c0779h, Exception exception, C0742d<?> c0742d, C25405a c25405a) {
        AppMethodBeat.m2504i(91896);
        this.azU.mo2212a(c0779h, exception, c0742d, this.azZ.aEq.mo2188mh());
        AppMethodBeat.m2505o(91896);
    }
}
