package com.tencent.soter.p663a.p664g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C46744e;

/* renamed from: com.tencent.soter.a.g.d */
public abstract class C44469d {
    boolean AvW = false;
    public C16164b Awl;

    public abstract boolean dRl();

    public abstract void dRm();

    public abstract void execute();

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: b */
    public final synchronized void mo70642b(final C46744e c46744e) {
        if (this.AvW) {
            C44476d.m80486w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            C40994f dRn = C40994f.dRn();
            C44476d.m80484i("Soter.SoterTaskManager", "soter: removing task: %d", Integer.valueOf(hashCode()));
            synchronized (dRn.Aww) {
                if (C40994f.Awv.get(hashCode()) == null) {
                    C44476d.m80484i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(hashCode()));
                } else {
                    C40994f.Awv.remove(hashCode());
                }
            }
            C44472g.dRq().mo70645d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10479);
                    C44469d c44469d = C44469d.this;
                    C46744e c46744e = c46744e;
                    if (!(c44469d.Awl == null || c44469d.AvW)) {
                        c44469d.Awl.mo17330a(c46744e);
                        c44469d.AvW = true;
                    }
                    AppMethodBeat.m2505o(10479);
                }
            });
        }
    }
}
