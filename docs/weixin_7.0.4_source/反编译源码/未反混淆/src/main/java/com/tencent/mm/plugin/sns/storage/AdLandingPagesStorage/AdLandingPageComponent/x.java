package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x extends r {
    public boolean iXr = true;
    public LinkedList<l> qWB = new LinkedList();
    public int qXu = 0;

    public x() {
        AppMethodBeat.i(36945);
        AppMethodBeat.o(36945);
    }

    public final List<r> cpf() {
        AppMethodBeat.i(36946);
        ArrayList arrayList = new ArrayList(super.cpf());
        if (this.qWB != null) {
            Iterator it = this.qWB.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.qWB != null) {
                    arrayList.addAll(lVar.qWB);
                }
            }
        }
        AppMethodBeat.o(36946);
        return arrayList;
    }
}
