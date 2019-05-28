package com.tencent.p177mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.game.preload.c */
public final class C38231c implements C33327h {
    private C6750i gPI;
    public final LinkedHashSet<C10441j> htl = new LinkedHashSet();

    public C38231c(C6750i c6750i) {
        AppMethodBeat.m2504i(130289);
        this.gPI = c6750i;
        AppMethodBeat.m2505o(130289);
    }

    /* renamed from: bX */
    public final void mo6116bX(String str, String str2) {
    }

    /* renamed from: a */
    public final void mo6108a(C42467ah c42467ah) {
    }

    /* renamed from: a */
    public final void mo6109a(String str, String str2, int[] iArr) {
    }

    /* renamed from: b */
    public final void mo6115b(C42467ah c42467ah) {
    }

    /* renamed from: M */
    public final void mo6107M(int i, String str) {
    }

    public final int aBw() {
        return 0;
    }

    public final String getAppId() {
        return this.gPI.mAppId;
    }

    public final Context getContext() {
        return null;
    }

    public final boolean isRunning() {
        return false;
    }

    public final C6747i aua() {
        return null;
    }

    public final C6747i aBx() {
        return null;
    }

    public final C45524b asD() {
        AppMethodBeat.m2504i(130290);
        C45524b c45524b;
        if (this.gPI == null) {
            c45524b = C45524b.DESTROYED;
            AppMethodBeat.m2505o(130290);
            return c45524b;
        }
        c45524b = this.gPI.gNN.gWy.awz();
        AppMethodBeat.m2505o(130290);
        return c45524b;
    }

    public final Map<String, C45608m> aub() {
        return null;
    }

    /* renamed from: aa */
    public final <T extends C10441j> T mo5937aa(Class<T> cls) {
        boolean z;
        AppMethodBeat.m2504i(130291);
        T t = null;
        Iterator it = this.htl.iterator();
        while (it.hasNext()) {
            T t2 = (C10441j) it.next();
            if (cls.isInstance(t2)) {
                t = t2;
                break;
            }
        }
        if (t == null) {
            try {
                t = (C10441j) cls.newInstance();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", cls.getName());
            }
        }
        if (t != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        AppMethodBeat.m2505o(130291);
        return t;
    }

    public final Handler aBy() {
        return null;
    }

    public final C19092p asE() {
        return null;
    }

    public final C33589k asF() {
        return null;
    }

    /* renamed from: B */
    public final void mo6106B(Runnable runnable) {
        AppMethodBeat.m2504i(130292);
        C5004al.m7441d(runnable);
        AppMethodBeat.m2505o(130292);
    }

    /* renamed from: B */
    public final <T extends C25681b> T mo5936B(Class<T> cls) {
        return null;
    }

    public final C6750i getRuntime() {
        return this.gPI;
    }
}
