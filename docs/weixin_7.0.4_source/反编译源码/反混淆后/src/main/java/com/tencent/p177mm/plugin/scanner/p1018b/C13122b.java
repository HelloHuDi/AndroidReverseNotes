package com.tencent.p177mm.plugin.scanner.p1018b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9529eb;
import com.tencent.p177mm.plugin.scanner.p740a.C46181p;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.scanner.b.b */
public final class C13122b extends C7563j {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46181p.ccO, "ScanTranslationResult")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(80897);
        AppMethodBeat.m2505o(80897);
    }

    public C13122b(C4927e c4927e) {
        super(c4927e, C46181p.ccO, "ScanTranslationResult", null);
        this.bSd = c4927e;
    }

    /* renamed from: Wf */
    public final C9529eb mo25148Wf(String str) {
        AppMethodBeat.m2504i(80896);
        C46181p c46181p = new C46181p();
        c46181p.field_originMD5 = str;
        if (mo10102b((C4925c) c46181p, new String[0])) {
            AppMethodBeat.m2505o(80896);
            return c46181p;
        }
        AppMethodBeat.m2505o(80896);
        return null;
    }
}
