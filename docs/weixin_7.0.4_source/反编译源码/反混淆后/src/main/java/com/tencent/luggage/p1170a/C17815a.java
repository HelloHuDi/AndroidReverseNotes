package com.tencent.luggage.p1170a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.luggage.a.a */
public final class C17815a implements C37383c {
    private static Map<Class<? extends C25681b>, C25681b> bOa = new ConcurrentHashMap();
    private static Map<Class<? extends C45116d>, C45116d> bOb = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(90706);
        AppMethodBeat.m2505o(90706);
    }

    public final String getName() {
        return "luggage-core";
    }

    /* renamed from: wH */
    public final Map<Class<? extends C25681b>, C25681b> mo32972wH() {
        return bOa;
    }

    /* renamed from: wI */
    public final Map<Class<? extends C45116d>, C45116d> mo32973wI() {
        return bOb;
    }
}
