package com.tencent.mm.plugin.appbrand.luggage.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.io.InputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/customize/CustomizeCommLibReaderWrapper;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "()V", "info", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "init", "", "openRead", "Ljava/io/InputStream;", "fileName", "", "versionBuildInfo", "versionName", "plugin-appbrand-integration_release"})
public final class a implements o {
    public static final a ikd = new a();

    static {
        AppMethodBeat.i(134723);
        AppMethodBeat.o(134723);
    }

    private a() {
    }

    public final void init() {
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(134719);
        InputStream openRead = WxaCommLibRuntimeReader.avP().openRead(str);
        AppMethodBeat.o(134719);
        return openRead;
    }

    public final WxaPkgWrappingInfo avm() {
        AppMethodBeat.i(134720);
        WxaPkgWrappingInfo avm = WxaCommLibRuntimeReader.avP().avm();
        j.o(avm, "WxaCommLibRuntimeReader.getReader().info()");
        AppMethodBeat.o(134720);
        return avm;
    }

    public final String avk() {
        AppMethodBeat.i(134721);
        String avk = WxaCommLibRuntimeReader.avP().avk();
        j.o(avk, "WxaCommLibRuntimeReader.getReader().versionName()");
        AppMethodBeat.o(134721);
        return avk;
    }

    public final String avl() {
        AppMethodBeat.i(134722);
        String avl = WxaCommLibRuntimeReader.avP().avl();
        j.o(avl, "WxaCommLibRuntimeReader.…ader().versionBuildInfo()");
        AppMethodBeat.o(134722);
        return avl;
    }
}
