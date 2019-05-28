package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.l */
public final class C42357l extends C10065a {
    final int gSA;

    public C42357l(String str, int i, int i2, String str2) {
        String format = String.format(Locale.US, "EncWxaPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = C10072ap.avY() + "/enc/";
        C15428j.aih(str3);
        str3 = stringBuilder.append(str3).append(String.format(Locale.US, "%d_%d_%d.encwxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)})).toString();
        this(format, str3, str2, str, i, i2);
        AppMethodBeat.m2504i(59436);
        AppMethodBeat.m2505o(59436);
    }

    private C42357l(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, str4, i2, 0);
        this.gSA = i;
    }

    public final String toShortString() {
        AppMethodBeat.m2504i(59437);
        String format = String.format(Locale.US, "EncryptPkgDownloadRequest[%s %d %d]", new Object[]{this.appId, Integer.valueOf(this.gSA), Integer.valueOf(this.version)});
        AppMethodBeat.m2505o(59437);
        return format;
    }
}
