package com.tencent.p177mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.cat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.data.d */
public final class C43538d {
    public ConcurrentHashMap<String, CharSequence> qFP = new ConcurrentHashMap();

    public C43538d() {
        AppMethodBeat.m2504i(35794);
        AppMethodBeat.m2505o(35794);
    }

    /* renamed from: a */
    public final void mo69100a(cat cat, CharSequence charSequence) {
        AppMethodBeat.m2504i(35795);
        this.qFP.put(cat.wZG + "-" + cat.wZJ + "-" + cat.ncM, charSequence);
        AppMethodBeat.m2505o(35795);
    }
}
