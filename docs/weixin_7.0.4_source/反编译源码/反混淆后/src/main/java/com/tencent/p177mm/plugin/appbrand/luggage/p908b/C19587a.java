package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import java.io.InputStream;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/customize/CustomizeCommLibReaderWrapper;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "()V", "info", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "init", "", "openRead", "Ljava/io/InputStream;", "fileName", "", "versionBuildInfo", "versionName", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.a */
public final class C19587a implements C31282o {
    public static final C19587a ikd = new C19587a();

    static {
        AppMethodBeat.m2504i(134723);
        AppMethodBeat.m2505o(134723);
    }

    private C19587a() {
    }

    public final void init() {
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(134719);
        InputStream openRead = WxaCommLibRuntimeReader.avP().openRead(str);
        AppMethodBeat.m2505o(134719);
        return openRead;
    }

    public final WxaPkgWrappingInfo avm() {
        AppMethodBeat.m2504i(134720);
        WxaPkgWrappingInfo avm = WxaCommLibRuntimeReader.avP().avm();
        C25052j.m39375o(avm, "WxaCommLibRuntimeReader.getReader().info()");
        AppMethodBeat.m2505o(134720);
        return avm;
    }

    public final String avk() {
        AppMethodBeat.m2504i(134721);
        String avk = WxaCommLibRuntimeReader.avP().avk();
        C25052j.m39375o(avk, "WxaCommLibRuntimeReader.getReader().versionName()");
        AppMethodBeat.m2505o(134721);
        return avk;
    }

    public final String avl() {
        AppMethodBeat.m2504i(134722);
        String avl = WxaCommLibRuntimeReader.avP().avl();
        C25052j.m39375o(avl, "WxaCommLibRuntimeReader.…ader().versionBuildInfo()");
        AppMethodBeat.m2505o(134722);
        return avl;
    }
}
