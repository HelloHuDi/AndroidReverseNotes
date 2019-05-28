package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b extends a implements Runnable {
    private int errorCode;
    private i mAJ;
    private WeakReference<l> mAK;

    public b(int i, i iVar) {
        AppMethodBeat.i(136518);
        this.errorCode = i;
        this.mAJ = iVar;
        this.mAK = new WeakReference(iVar.mEw);
        AppMethodBeat.o(136518);
    }

    public final boolean execute() {
        AppMethodBeat.i(136519);
        if (this.errorCode == -2 || this.errorCode == -3) {
            final j jVar = new j(this.mAJ);
            jVar.mEx = this;
            jVar.bFZ = this.errorCode;
            jVar.mEy = new LinkedList();
            jVar.mDz = g.aO(this.mAJ.query, false);
            if (this.mAJ.handler == null) {
                l lVar = (l) this.mAK.get();
                if (lVar != null) {
                    lVar.b(jVar);
                }
            } else {
                this.mAJ.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136517);
                        l lVar = (l) b.this.mAK.get();
                        if (lVar != null) {
                            lVar.b(jVar);
                        }
                        AppMethodBeat.o(136517);
                    }
                });
            }
        }
        AppMethodBeat.o(136519);
        return true;
    }

    public final void run() {
        AppMethodBeat.i(136520);
        try {
            execute();
            AppMethodBeat.o(136520);
        } catch (Exception e) {
            AppMethodBeat.o(136520);
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
