package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.widget.b.k;

public abstract class d extends i {
    public final String getAppId() {
        return getRuntime() == null ? null : getRuntime().mAppId;
    }

    public final <T extends j> T aa(Class<T> cls) {
        if (isRunning()) {
            return getRuntime().aa(cls);
        }
        return super.aa(cls);
    }

    public final b asD() {
        if (isRunning()) {
            return getRuntime().gNN.gWy.awz();
        }
        return b.DESTROYED;
    }

    public final p asE() {
        if (isRunning()) {
            return getRuntime().asE();
        }
        return super.asE();
    }

    public final k asF() {
        if (isRunning()) {
            return getRuntime().gNG;
        }
        return super.asF();
    }

    public final <T extends com.tencent.luggage.a.b> T B(Class<T> cls) {
        i runtime = getRuntime();
        if (runtime != null) {
            com.tencent.luggage.a.b bVar = (com.tencent.luggage.a.b) runtime.K(cls);
            if (bVar != null) {
                return bVar;
            }
        }
        return super.B((Class) cls);
    }

    public final o asG() {
        return (o) B(com.tencent.mm.plugin.appbrand.appstorage.o.class);
    }

    public boolean isRunning() {
        i runtime = getRuntime();
        return (runtime == null || runtime.mFinished) ? false : true;
    }
}
