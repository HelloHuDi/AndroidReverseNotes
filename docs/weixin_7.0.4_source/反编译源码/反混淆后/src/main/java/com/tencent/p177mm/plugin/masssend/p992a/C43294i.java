package com.tencent.p177mm.plugin.masssend.p992a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32648tu;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.bic;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.masssend.a.i */
public final class C43294i extends C4884c<C32648tu> {
    public C43294i() {
        AppMethodBeat.m2504i(22752);
        this.xxI = C32648tu.class.getName().hashCode();
        AppMethodBeat.m2505o(22752);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(22753);
        List list = ((C32648tu) c4883b).cPV.cPW;
        if (list == null || list.size() <= 0) {
            C4990ab.m7412e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
            AppMethodBeat.m2505o(22753);
        } else {
            byte[] a = C1946aa.m4150a(((bic) list.get(0)).vFG);
            if (a == null || a.length == 0) {
                AppMethodBeat.m2505o(22753);
            } else {
                String str = new String(a);
                C4990ab.m7416i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:".concat(String.valueOf(str)));
                C21270h.bNF().mo68839Qt(str);
                AppMethodBeat.m2505o(22753);
            }
        }
        return false;
    }
}
