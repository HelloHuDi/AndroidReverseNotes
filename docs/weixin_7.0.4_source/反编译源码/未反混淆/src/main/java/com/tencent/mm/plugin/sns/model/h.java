package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    private boolean cFy = false;
    ak handler = af.bCo();

    public abstract a cin();

    public abstract Result dv();

    public final boolean u(final Params... paramsArr) {
        if (this.cFy) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.cFy = true;
        a cin = cin();
        if (cin == null) {
            return false;
        }
        cin.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36230);
                final Object dv = h.this.dv();
                h.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36229);
                        h.this.onPostExecute(dv);
                        AppMethodBeat.o(36229);
                    }
                });
                AppMethodBeat.o(36230);
            }
        });
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
