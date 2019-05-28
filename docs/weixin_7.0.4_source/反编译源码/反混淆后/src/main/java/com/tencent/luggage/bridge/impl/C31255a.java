package com.tencent.luggage.bridge.impl;

import com.tencent.luggage.bridge.impl.p1588a.C41703b;
import com.tencent.luggage.bridge.p814a.C8852a.C8851a;
import com.tencent.luggage.bridge.p814a.C8852a.C8854b;
import com.tencent.luggage.bridge.p814a.C8852a.C8855c;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vfs.FileSystemManager;

/* renamed from: com.tencent.luggage.bridge.impl.a */
public class C31255a implements C8854b {
    final C19162a bOW = new C41703b();

    public C31255a() {
        AppMethodBeat.m2504i(90759);
        AppMethodBeat.m2505o(90759);
    }

    /* renamed from: a */
    public void mo20026a(C8855c c8855c) {
        AppMethodBeat.m2504i(90760);
        FileSystemManager.setContext(C4996ah.getContext());
        c8855c.mo20023a(C19162a.class, this.bOW);
        AppMethodBeat.m2505o(90760);
    }

    /* renamed from: a */
    public void mo20025a(C8851a c8851a) {
        AppMethodBeat.m2504i(90761);
        c8851a.mo20023a(C19162a.class, (C25681b) this.bOW);
        AppMethodBeat.m2505o(90761);
    }
}
