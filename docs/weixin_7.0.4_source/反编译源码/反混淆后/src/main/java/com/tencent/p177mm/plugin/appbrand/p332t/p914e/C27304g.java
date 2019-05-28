package com.tencent.p177mm.plugin.appbrand.p332t.p914e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* renamed from: com.tencent.mm.plugin.appbrand.t.e.g */
public class C27304g implements C38515c {
    private byte[] content;
    private TreeMap<String, String> iTF = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public C27304g() {
        AppMethodBeat.m2504i(73267);
        AppMethodBeat.m2505o(73267);
    }

    public final Iterator<String> aOx() {
        AppMethodBeat.m2504i(73268);
        Iterator it = Collections.unmodifiableSet(this.iTF.keySet()).iterator();
        AppMethodBeat.m2505o(73268);
        return it;
    }

    /* renamed from: Eq */
    public final String mo22296Eq(String str) {
        AppMethodBeat.m2504i(73269);
        String str2 = (String) this.iTF.get(str);
        if (str2 == null) {
            str2 = "";
            AppMethodBeat.m2505o(73269);
            return str2;
        }
        AppMethodBeat.m2505o(73269);
        return str2;
    }

    public final byte[] aOy() {
        return this.content;
    }

    public final void put(String str, String str2) {
        AppMethodBeat.m2504i(73270);
        this.iTF.put(str, str2);
        AppMethodBeat.m2505o(73270);
    }

    /* renamed from: Er */
    public final boolean mo22297Er(String str) {
        AppMethodBeat.m2504i(73271);
        boolean containsKey = this.iTF.containsKey(str);
        AppMethodBeat.m2505o(73271);
        return containsKey;
    }
}
