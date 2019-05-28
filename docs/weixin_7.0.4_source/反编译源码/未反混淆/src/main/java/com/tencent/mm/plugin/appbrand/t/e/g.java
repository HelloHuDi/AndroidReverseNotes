package com.tencent.mm.plugin.appbrand.t.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {
    private byte[] content;
    private TreeMap<String, String> iTF = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public g() {
        AppMethodBeat.i(73267);
        AppMethodBeat.o(73267);
    }

    public final Iterator<String> aOx() {
        AppMethodBeat.i(73268);
        Iterator it = Collections.unmodifiableSet(this.iTF.keySet()).iterator();
        AppMethodBeat.o(73268);
        return it;
    }

    public final String Eq(String str) {
        AppMethodBeat.i(73269);
        String str2 = (String) this.iTF.get(str);
        if (str2 == null) {
            str2 = "";
            AppMethodBeat.o(73269);
            return str2;
        }
        AppMethodBeat.o(73269);
        return str2;
    }

    public final byte[] aOy() {
        return this.content;
    }

    public final void put(String str, String str2) {
        AppMethodBeat.i(73270);
        this.iTF.put(str, str2);
        AppMethodBeat.o(73270);
    }

    public final boolean Er(String str) {
        AppMethodBeat.i(73271);
        boolean containsKey = this.iTF.containsKey(str);
        AppMethodBeat.o(73271);
        return containsKey;
    }
}
