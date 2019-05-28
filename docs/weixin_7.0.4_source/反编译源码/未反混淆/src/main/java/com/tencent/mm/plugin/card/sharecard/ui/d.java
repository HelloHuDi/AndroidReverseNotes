package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class d implements a {
    private c kgY;

    public d(c cVar) {
        this.kgY = cVar;
    }

    public final void onCreate() {
        AppMethodBeat.i(88146);
        if (this.kgY != null) {
            am.baW().c(this.kgY);
        }
        AppMethodBeat.o(88146);
    }

    public final void onDestroy() {
        AppMethodBeat.i(88147);
        if (this.kgY != null) {
            am.baW().d(this.kgY);
            c cVar = this.kgY;
            cVar.kgW.release();
            cVar.kgW = null;
            cVar.bIf();
            int i = (int) (cVar.endTime - cVar.beginTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(25);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.pYm.b(arrayList, true);
            this.kgY = null;
        }
        AppMethodBeat.o(88147);
    }

    public final void ZZ() {
        AppMethodBeat.i(88148);
        if (this.kgY != null) {
            this.kgY.a(null, null);
        }
        AppMethodBeat.o(88148);
    }

    public final /* synthetic */ b sM(int i) {
        AppMethodBeat.i(88149);
        if (this.kgY != null) {
            ShareCardInfo shareCardInfo = (ShareCardInfo) this.kgY.getItem(i);
            AppMethodBeat.o(88149);
            return shareCardInfo;
        }
        AppMethodBeat.o(88149);
        return null;
    }
}
