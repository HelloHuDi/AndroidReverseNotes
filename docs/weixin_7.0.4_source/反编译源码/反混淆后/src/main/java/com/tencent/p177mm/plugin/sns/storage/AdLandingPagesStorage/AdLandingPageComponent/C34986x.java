package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x */
public final class C34986x extends C29086r {
    public boolean iXr = true;
    public LinkedList<C39779l> qWB = new LinkedList();
    public int qXu = 0;

    public C34986x() {
        AppMethodBeat.m2504i(36945);
        AppMethodBeat.m2505o(36945);
    }

    public final List<C29086r> cpf() {
        AppMethodBeat.m2504i(36946);
        ArrayList arrayList = new ArrayList(super.cpf());
        if (this.qWB != null) {
            Iterator it = this.qWB.iterator();
            while (it.hasNext()) {
                C39779l c39779l = (C39779l) it.next();
                if (c39779l.qWB != null) {
                    arrayList.addAll(c39779l.qWB);
                }
            }
        }
        AppMethodBeat.m2505o(36946);
        return arrayList;
    }
}
