package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.n */
public interface C10108n {

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.n$a */
    public enum C10107a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED;

        static {
            AppMethodBeat.m2505o(101782);
        }
    }
}
