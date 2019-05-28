package com.tencent.p177mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fts.b */
public final class C31363b extends C28106a implements Runnable {
    private int errorCode;
    private C20846i mAJ;
    private WeakReference<C28114l> mAK;

    public C31363b(int i, C20846i c20846i) {
        AppMethodBeat.m2504i(136518);
        this.errorCode = i;
        this.mAJ = c20846i;
        this.mAK = new WeakReference(c20846i.mEw);
        AppMethodBeat.m2505o(136518);
    }

    public final boolean execute() {
        AppMethodBeat.m2504i(136519);
        if (this.errorCode == -2 || this.errorCode == -3) {
            final C28109j c28109j = new C28109j(this.mAJ);
            c28109j.mEx = this;
            c28109j.bFZ = this.errorCode;
            c28109j.mEy = new LinkedList();
            c28109j.mDz = C20840g.m32052aO(this.mAJ.query, false);
            if (this.mAJ.handler == null) {
                C28114l c28114l = (C28114l) this.mAK.get();
                if (c28114l != null) {
                    c28114l.mo8215b(c28109j);
                }
            } else {
                this.mAJ.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(136517);
                        C28114l c28114l = (C28114l) C31363b.this.mAK.get();
                        if (c28114l != null) {
                            c28114l.mo8215b(c28109j);
                        }
                        AppMethodBeat.m2505o(136517);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(136519);
        return true;
    }

    public final void run() {
        AppMethodBeat.m2504i(136520);
        try {
            execute();
            AppMethodBeat.m2505o(136520);
        } catch (Exception e) {
            AppMethodBeat.m2505o(136520);
        }
    }

    public final int getPriority() {
        return 0;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final int getId() {
        return -1;
    }
}
