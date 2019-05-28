package com.tencent.p177mm.plugin.appbrand;

import com.tencent.luggage.p1170a.C25681b;
import com.tencent.p177mm.plugin.appbrand.appcache.C19062o;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10438i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;

/* renamed from: com.tencent.mm.plugin.appbrand.d */
public abstract class C2119d extends C10438i {
    public final String getAppId() {
        return getRuntime() == null ? null : getRuntime().mAppId;
    }

    /* renamed from: aa */
    public final <T extends C10441j> T mo5937aa(Class<T> cls) {
        if (isRunning()) {
            return getRuntime().mo14986aa(cls);
        }
        return super.mo5937aa(cls);
    }

    public final C45524b asD() {
        if (isRunning()) {
            return getRuntime().gNN.gWy.awz();
        }
        return C45524b.DESTROYED;
    }

    public final C19092p asE() {
        if (isRunning()) {
            return getRuntime().asE();
        }
        return super.asE();
    }

    public final C33589k asF() {
        if (isRunning()) {
            return getRuntime().gNG;
        }
        return super.asF();
    }

    /* renamed from: B */
    public final <T extends C25681b> T mo5936B(Class<T> cls) {
        C6750i runtime = getRuntime();
        if (runtime != null) {
            C25681b c25681b = (C25681b) runtime.mo14978K(cls);
            if (c25681b != null) {
                return c25681b;
            }
        }
        return super.mo5936B((Class) cls);
    }

    public final C19062o asG() {
        return (C19062o) mo5936B(C31282o.class);
    }

    public boolean isRunning() {
        C6750i runtime = getRuntime();
        return (runtime == null || runtime.mFinished) ? false : true;
    }
}
