package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.exdevice.service.C11661p;
import com.tencent.p177mm.plugin.exdevice.service.C27863l.C27864a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.i.l */
public final class C45887l extends C27864a {
    private final long ftT = 15000;
    private C45884c lxJ = null;
    boolean lxK = false;
    boolean lxL = false;
    Runnable lxM = new C458861();

    /* renamed from: com.tencent.mm.plugin.exdevice.i.l$1 */
    class C458861 implements Runnable {
        C458861() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19745);
            C45887l.this.lxK = true;
            if (C45887l.this.lxL) {
                AppMethodBeat.m2505o(19745);
                return;
            }
            C45887l.this.lxJ.mo45711a(-1, -1, -2, "TimeOut", null);
            AppMethodBeat.m2505o(19745);
        }

        public final String toString() {
            AppMethodBeat.m2504i(19746);
            String str = super.toString() + "|mAsyncTimeOut";
            AppMethodBeat.m2505o(19746);
            return str;
        }
    }

    public C45887l(C45884c c45884c) {
        AppMethodBeat.m2504i(19749);
        Assert.assertNotNull(c45884c);
        this.lxJ = c45884c;
        AppMethodBeat.m2505o(19749);
    }

    /* renamed from: a */
    public final void mo23407a(long j, int i, int i2, String str, C11661p c11661p) {
        AppMethodBeat.m2504i(19750);
        if (this.lxL) {
            AppMethodBeat.m2505o(19750);
        } else if (this.lxK) {
            AppMethodBeat.m2505o(19750);
        } else {
            C9638aw.m17180RS().doN().removeCallbacks(this.lxM);
            final long j2 = j;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            final C11661p c11661p2 = c11661p;
            C9638aw.m17180RS().doN().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(19747);
                    C45887l.this.lxJ.mo45711a(j2, i3, i4, str2, c11661p2);
                    AppMethodBeat.m2505o(19747);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(19748);
                    String str = super.toString() + "|onTaskEnd";
                    AppMethodBeat.m2505o(19748);
                    return str;
                }
            });
            AppMethodBeat.m2505o(19750);
        }
    }
}
