package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.c */
public final class C33093c extends C45510a {
    public static final C33093c gSg = new C33093c();
    final WxaPkgWrappingInfo gSf;

    public final void init() {
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(114302);
        InputStream openRead = C38104an.openRead(str);
        AppMethodBeat.m2505o(114302);
        return openRead;
    }

    public final WxaPkgWrappingInfo avm() {
        return this.gSf;
    }

    public C33093c() {
        AppMethodBeat.m2504i(114303);
        this.gSf = new WxaPkgWrappingInfo();
        this.gSf.gVw = true;
        this.gSf.gVt = 0;
        this.gSf.gVu = C38104an.VERSION;
        this.gSf.cvZ = "";
        AppMethodBeat.m2505o(114303);
    }

    static {
        AppMethodBeat.m2504i(114304);
        AppMethodBeat.m2505o(114304);
    }

    public final String toString() {
        return "AssetReader";
    }
}
