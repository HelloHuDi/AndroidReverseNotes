package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.sns.model.h */
public abstract class C39759h<Params, Progress, Result> {
    private boolean cFy = false;
    C7306ak handler = C13373af.bCo();

    public abstract C4946a cin();

    /* renamed from: dv */
    public abstract Result mo25905dv();

    /* renamed from: u */
    public final boolean mo62862u(final Params... paramsArr) {
        if (this.cFy) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.cFy = true;
        C4946a cin = cin();
        if (cin == null) {
            return false;
        }
        cin.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36230);
                final Object dv = C39759h.this.mo25905dv();
                C39759h.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(36229);
                        C39759h.this.onPostExecute(dv);
                        AppMethodBeat.m2505o(36229);
                    }
                });
                AppMethodBeat.m2505o(36230);
            }
        });
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
