package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.storage.C40631p;
import com.tencent.p177mm.storage.C46626o;
import com.tencent.p177mm.storage.C5142e;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.aj.l */
public final class C25771l implements C8939o, C1655b, C6616b, C1671c {
    private C46626o fwE;
    private C40631p fwF;

    /* renamed from: XP */
    public final C46626o mo20357XP() {
        return this.fwE;
    }

    /* renamed from: XQ */
    public final C40631p mo20358XQ() {
        return this.fwF;
    }

    /* renamed from: Yf */
    public final String mo20359Yf() {
        AppMethodBeat.m2504i(11416);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("brandicon/").toString();
        AppMethodBeat.m2505o(11416);
        return stringBuilder2;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(11417);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"brandicon/"});
        AppMethodBeat.m2505o(11417);
        return linkedList;
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(11418);
        C6977h bOr = ((C6982j) C1720g.m3528K(C6982j.class)).bOr();
        C5142e c46626o = new C46626o(bOr);
        this.fwE = c46626o;
        bOr.mo15290a(c46626o);
        this.fwF = new C40631p(((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR());
        AppMethodBeat.m2505o(11418);
    }

    public final void onAccountRelease() {
    }

    public final void parallelsDependency() {
        AppMethodBeat.m2504i(11419);
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C6983p.class));
        AppMethodBeat.m2505o(11419);
    }
}
