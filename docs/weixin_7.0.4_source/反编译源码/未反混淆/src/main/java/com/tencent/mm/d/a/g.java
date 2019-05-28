package com.tencent.mm.d.a;

import com.eclipsesource.v8.ILoadLibraryDelegate;
import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class g {
    static {
        AppMethodBeat.i(113803);
        V8.setLoadLibraryDelegate(new ILoadLibraryDelegate() {
            public final void loadLibrary(String str) {
                AppMethodBeat.i(113799);
                k.a("mmv8", i.class.getClassLoader());
                k.a("node", i.class.getClassLoader());
                k.a("j2v8", i.class.getClassLoader());
                ab.i("MicroMsg.JSRuntimeCreator", "load so done");
                AppMethodBeat.o(113799);
            }
        });
        AppMethodBeat.o(113803);
    }

    public static i g(String str, byte[] bArr) {
        AppMethodBeat.i(113800);
        i j = i.j(str, bArr);
        AppMethodBeat.o(113800);
        return j;
    }

    public static v h(String str, byte[] bArr) {
        AppMethodBeat.i(113801);
        v k = v.k(str, bArr);
        AppMethodBeat.o(113801);
        return k;
    }

    public static v i(String str, byte[] bArr) {
        AppMethodBeat.i(113802);
        v f = b.f(str, bArr);
        AppMethodBeat.o(113802);
        return f;
    }
}
