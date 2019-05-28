package com.tencent.p177mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.model.k */
public abstract class C23251k<Params, Progress, Result> {
    private boolean cFy = false;
    C7306ak handler = new C7306ak(Looper.getMainLooper());

    public abstract C4946a cin();

    /* renamed from: dv */
    public abstract Result mo38879dv();

    /* renamed from: u */
    public final boolean mo38881u(final Params... paramsArr) {
        if (this.cFy) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.cFy = true;
        mo38882v(paramsArr);
        C4946a cin = cin();
        if (cin == null) {
            return false;
        }
        cin.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(79216);
                final Object dv = C23251k.this.mo38879dv();
                C23251k.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(79215);
                        C23251k.this.onPostExecute(dv);
                        AppMethodBeat.m2505o(79215);
                    }
                });
                AppMethodBeat.m2505o(79216);
            }
        });
        return true;
    }

    /* renamed from: v */
    public void mo38882v(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
