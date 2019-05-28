package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class h extends a {
    private WeakReference<l> mAK;
    public i mEl;
    public j mEm;

    public h(i iVar) {
        this.mEl = iVar;
        this.mAK = new WeakReference(iVar.mEw);
    }

    public final boolean execute() {
        i iVar = this.mEl;
        if (!bo.isNullOrNil(iVar.query)) {
            try {
                iVar.query = new String(iVar.query.getBytes("UTF8"), "UTF8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.mEm = new j(this.mEl);
        l lVar;
        try {
            this.mEm.mEx = this;
            a(this.mEm);
            this.mEm.bFZ = 0;
            if (this.mEl.handler == null) {
                lVar = (l) this.mAK.get();
                if (lVar != null) {
                    lVar.b(this.mEm);
                }
            } else {
                this.mEl.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(114266);
                        l lVar = (l) h.this.mAK.get();
                        if (lVar != null) {
                            lVar.b(h.this.mEm);
                        }
                        AppMethodBeat.o(114266);
                    }
                });
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
                lVar = (l) this.mAK.get();
                if (lVar != null) {
                    lVar.b(this.mEm);
                }
            } else {
                this.mEl.handler.post(/* anonymous class already generated */);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(j jVar) {
        jVar.mDz = g.aO(this.mEl.query, false);
        jVar.bFZ = -5;
    }
}
