package com.tencent.p177mm.plugin.cdndownloader.p935f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.cdndownloader.f.c */
public final class C11368c extends C7563j<C38783a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C38783a.ccO, "CdnDownloadInfo")};

    static {
        AppMethodBeat.m2504i(963);
        AppMethodBeat.m2505o(963);
    }

    public C11368c(C4927e c4927e) {
        super(c4927e, C38783a.ccO, "CdnDownloadInfo", null);
    }

    /* renamed from: HG */
    public final boolean mo23102HG(String str) {
        AppMethodBeat.m2504i(962);
        boolean hY = mo16768hY("CdnDownloadInfo", String.format("delete from %s where %s=%s", new Object[]{"CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(str.hashCode())}));
        AppMethodBeat.m2505o(962);
        return hY;
    }
}
