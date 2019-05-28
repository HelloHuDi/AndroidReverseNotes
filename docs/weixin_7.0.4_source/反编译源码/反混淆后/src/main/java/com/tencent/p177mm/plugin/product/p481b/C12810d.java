package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.b.d */
public final class C12810d {
    public List<String> phg = new ArrayList();

    public C12810d() {
        AppMethodBeat.m2504i(43979);
        m20809Kh();
        AppMethodBeat.m2505o(43979);
    }

    /* renamed from: Kh */
    private void m20809Kh() {
        AppMethodBeat.m2504i(43980);
        this.phg.clear();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(270340, (Object) "");
        C4990ab.m7410d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(str)));
        for (String str2 : C5046bo.m7508P(str2.split(";"))) {
            if (!C5046bo.isNullOrNil(str2)) {
                this.phg.add(str2);
            }
        }
        AppMethodBeat.m2505o(43980);
    }

    public final boolean bZX() {
        AppMethodBeat.m2504i(43981);
        C4990ab.m7410d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.phg.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.phg) {
            if (!(C5046bo.isNullOrNil(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        C4990ab.m7410d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(270340, stringBuffer.toString());
        AppMethodBeat.m2505o(43981);
        return true;
    }
}
