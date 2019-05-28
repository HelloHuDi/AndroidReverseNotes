package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.e;

public abstract class d {
    boolean AvW = false;
    public b Awl;

    public abstract boolean dRl();

    public abstract void dRm();

    public abstract void execute();

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void b(final e eVar) {
        if (this.AvW) {
            com.tencent.soter.core.c.d.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            f dRn = f.dRn();
            com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: removing task: %d", Integer.valueOf(hashCode()));
            synchronized (dRn.Aww) {
                if (f.Awv.get(hashCode()) == null) {
                    com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(hashCode()));
                } else {
                    f.Awv.remove(hashCode());
                }
            }
            g.dRq().d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10479);
                    d dVar = d.this;
                    e eVar = eVar;
                    if (!(dVar.Awl == null || dVar.AvW)) {
                        dVar.Awl.a(eVar);
                        dVar.AvW = true;
                    }
                    AppMethodBeat.o(10479);
                }
            });
        }
    }
}
