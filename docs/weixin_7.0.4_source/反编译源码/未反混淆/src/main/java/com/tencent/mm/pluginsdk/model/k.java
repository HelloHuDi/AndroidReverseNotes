package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public abstract class k<Params, Progress, Result> {
    private boolean cFy = false;
    ak handler = new ak(Looper.getMainLooper());

    public abstract a cin();

    public abstract Result dv();

    public final boolean u(final Params... paramsArr) {
        if (this.cFy) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.cFy = true;
        v(paramsArr);
        a cin = cin();
        if (cin == null) {
            return false;
        }
        cin.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79216);
                final Object dv = k.this.dv();
                k.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(79215);
                        k.this.onPostExecute(dv);
                        AppMethodBeat.o(79215);
                    }
                });
                AppMethodBeat.o(79216);
            }
        });
        return true;
    }

    public void v(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
