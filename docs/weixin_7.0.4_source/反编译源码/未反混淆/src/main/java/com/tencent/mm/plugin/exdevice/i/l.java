package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import junit.framework.Assert;

public final class l extends a {
    private final long ftT = 15000;
    private c lxJ = null;
    boolean lxK = false;
    boolean lxL = false;
    Runnable lxM = new Runnable() {
        public final void run() {
            AppMethodBeat.i(19745);
            l.this.lxK = true;
            if (l.this.lxL) {
                AppMethodBeat.o(19745);
                return;
            }
            l.this.lxJ.a(-1, -1, -2, "TimeOut", null);
            AppMethodBeat.o(19745);
        }

        public final String toString() {
            AppMethodBeat.i(19746);
            String str = super.toString() + "|mAsyncTimeOut";
            AppMethodBeat.o(19746);
            return str;
        }
    };

    public l(c cVar) {
        AppMethodBeat.i(19749);
        Assert.assertNotNull(cVar);
        this.lxJ = cVar;
        AppMethodBeat.o(19749);
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        AppMethodBeat.i(19750);
        if (this.lxL) {
            AppMethodBeat.o(19750);
        } else if (this.lxK) {
            AppMethodBeat.o(19750);
        } else {
            aw.RS().doN().removeCallbacks(this.lxM);
            final long j2 = j;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            final p pVar2 = pVar;
            aw.RS().doN().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19747);
                    l.this.lxJ.a(j2, i3, i4, str2, pVar2);
                    AppMethodBeat.o(19747);
                }

                public final String toString() {
                    AppMethodBeat.i(19748);
                    String str = super.toString() + "|onTaskEnd";
                    AppMethodBeat.o(19748);
                    return str;
                }
            });
            AppMethodBeat.o(19750);
        }
    }
}
