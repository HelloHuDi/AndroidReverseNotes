package com.tencent.p177mm.plugin.appbrand.page.p910b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c.C19628b;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.tencent.mm.plugin.appbrand.page.b.b */
public class C27222b implements C19627c {
    protected final C44709u ivs;
    protected final AtomicReference<C19628b> ivt = new AtomicReference();

    C27222b(C44709u c44709u) {
        AppMethodBeat.m2504i(87370);
        this.ivt.set(C19628b.SHOWN);
        this.ivs = c44709u;
        AppMethodBeat.m2505o(87370);
    }

    public final C19628b aBt() {
        AppMethodBeat.m2504i(87371);
        C19628b c19628b = (C19628b) this.ivt.get();
        AppMethodBeat.m2505o(87371);
        return c19628b;
    }

    public void aBr() {
    }

    public void aBs() {
    }

    public void aAS() {
        AppMethodBeat.m2504i(87372);
        if (this.ivs.mContext instanceof Activity) {
            C42696n.m75620c(((Activity) this.ivs.mContext).getWindow(), false);
        }
        AppMethodBeat.m2505o(87372);
    }

    public void onOrientationChanged(int i) {
    }
}
