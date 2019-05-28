package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C20128a;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.view.C31128d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.d */
public final class C33779d implements C20128a {
    private C20161c kgY;

    public C33779d(C20161c c20161c) {
        this.kgY = c20161c;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(88146);
        if (this.kgY != null) {
            C42852am.baW().mo10116c(this.kgY);
        }
        AppMethodBeat.m2505o(88146);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(88147);
        if (this.kgY != null) {
            C42852am.baW().mo10117d(this.kgY);
            C20161c c20161c = this.kgY;
            c20161c.kgW.release();
            c20161c.kgW = null;
            c20161c.bIf();
            int i = (int) (c20161c.endTime - c20161c.beginTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(25);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            C7060h.pYm.mo8379b(arrayList, true);
            this.kgY = null;
        }
        AppMethodBeat.m2505o(88147);
    }

    /* renamed from: ZZ */
    public final void mo35378ZZ() {
        AppMethodBeat.m2504i(88148);
        if (this.kgY != null) {
            this.kgY.mo5248a(null, null);
        }
        AppMethodBeat.m2505o(88148);
    }

    /* renamed from: sM */
    public final /* synthetic */ C42837b mo35381sM(int i) {
        AppMethodBeat.m2504i(88149);
        if (this.kgY != null) {
            ShareCardInfo shareCardInfo = (ShareCardInfo) this.kgY.getItem(i);
            AppMethodBeat.m2505o(88149);
            return shareCardInfo;
        }
        AppMethodBeat.m2505o(88149);
        return null;
    }
}
