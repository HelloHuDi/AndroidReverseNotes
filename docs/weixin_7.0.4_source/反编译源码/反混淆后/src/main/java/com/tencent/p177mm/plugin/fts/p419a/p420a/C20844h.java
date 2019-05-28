package com.tencent.p177mm.plugin.fts.p419a.p420a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.fts.a.a.h */
public abstract class C20844h extends C28106a {
    private WeakReference<C28114l> mAK;
    public C20846i mEl;
    public C28109j mEm;

    /* renamed from: com.tencent.mm.plugin.fts.a.a.h$1 */
    class C208451 implements Runnable {
        C208451() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114266);
            C28114l c28114l = (C28114l) C20844h.this.mAK.get();
            if (c28114l != null) {
                c28114l.mo8215b(C20844h.this.mEm);
            }
            AppMethodBeat.m2505o(114266);
        }
    }

    public C20844h(C20846i c20846i) {
        this.mEl = c20846i;
        this.mAK = new WeakReference(c20846i.mEw);
    }

    public final boolean execute() {
        C20846i c20846i = this.mEl;
        if (!C5046bo.isNullOrNil(c20846i.query)) {
            try {
                c20846i.query = new String(c20846i.query.getBytes("UTF8"), "UTF8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.mEm = new C28109j(this.mEl);
        C28114l c28114l;
        try {
            this.mEm.mEx = this;
            mo7437a(this.mEm);
            this.mEm.bFZ = 0;
            if (this.mEl.handler == null) {
                c28114l = (C28114l) this.mAK.get();
                if (c28114l != null) {
                    c28114l.mo8215b(this.mEm);
                }
            } else {
                this.mEl.handler.post(new C208451());
            }
            return true;
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                this.mEm.bFZ = 1;
            } else {
                this.mEm.bFZ = -1;
            }
            throw e2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (this.mEl.handler == null) {
                c28114l = (C28114l) this.mAK.get();
                if (c28114l != null) {
                    c28114l.mo8215b(this.mEm);
                }
            } else {
                this.mEl.handler.post(new C208451());
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo7437a(C28109j c28109j) {
        c28109j.mDz = C20840g.m32052aO(this.mEl.query, false);
        c28109j.bFZ = -5;
    }
}
