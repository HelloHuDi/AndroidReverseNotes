package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

public final class c implements h {
    private i gPI;
    public final LinkedHashSet<j> htl = new LinkedHashSet();

    public c(i iVar) {
        AppMethodBeat.i(130289);
        this.gPI = iVar;
        AppMethodBeat.o(130289);
    }

    public final void bX(String str, String str2) {
    }

    public final void a(ah ahVar) {
    }

    public final void a(String str, String str2, int[] iArr) {
    }

    public final void b(ah ahVar) {
    }

    public final void M(int i, String str) {
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

    public final com.tencent.mm.plugin.appbrand.h.i aua() {
        return null;
    }

    public final com.tencent.mm.plugin.appbrand.h.i aBx() {
        return null;
    }

    public final b asD() {
        AppMethodBeat.i(130290);
        b bVar;
        if (this.gPI == null) {
            bVar = b.DESTROYED;
            AppMethodBeat.o(130290);
            return bVar;
        }
        bVar = this.gPI.gNN.gWy.awz();
        AppMethodBeat.o(130290);
        return bVar;
    }

    public final Map<String, m> aub() {
        return null;
    }

    public final <T extends j> T aa(Class<T> cls) {
        boolean z;
        AppMethodBeat.i(130291);
        T t = null;
        Iterator it = this.htl.iterator();
        while (it.hasNext()) {
            T t2 = (j) it.next();
            if (cls.isInstance(t2)) {
                t = t2;
                break;
            }
        }
        if (t == null) {
            try {
                t = (j) cls.newInstance();
            } catch (Exception e) {
                ab.e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", cls.getName());
            }
        }
        if (t != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        AppMethodBeat.o(130291);
        return t;
    }

    public final Handler aBy() {
        return null;
    }

    public final p asE() {
        return null;
    }

    public final k asF() {
        return null;
    }

    public final void B(Runnable runnable) {
        AppMethodBeat.i(130292);
        al.d(runnable);
        AppMethodBeat.o(130292);
    }

    public final <T extends com.tencent.luggage.a.b> T B(Class<T> cls) {
        return null;
    }

    public final i getRuntime() {
        return this.gPI;
    }
}
