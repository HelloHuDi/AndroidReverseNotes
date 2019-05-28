package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.protocal.protobuf.chc;
import com.tencent.p177mm.protocal.protobuf.chd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d */
public final class C42822d {
    static chc jQA;

    public static chc aWL() {
        AppMethodBeat.m2504i(14342);
        if (jQA != null) {
            chc chc = jQA;
            AppMethodBeat.m2505o(14342);
            return chc;
        }
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(14342);
            return null;
        }
        chc chc2 = new chc();
        try {
            chc2.parseFrom(Base64.decode(str, 0));
            jQA = chc2;
            AppMethodBeat.m2505o(14342);
            return chc2;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", e.getMessage());
            AppMethodBeat.m2505o(14342);
            return null;
        }
    }

    /* renamed from: FG */
    public static boolean m75969FG(String str) {
        AppMethodBeat.m2504i(14343);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(14343);
            return false;
        }
        chc aWL = C42822d.aWL();
        if (aWL == null) {
            AppMethodBeat.m2505o(14343);
            return false;
        }
        LinkedList linkedList = aWL.xfW;
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(14343);
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            chd chd = (chd) it.next();
            if (chd != null && str.equals(chd.vGE)) {
                AppMethodBeat.m2505o(14343);
                return true;
            }
        }
        AppMethodBeat.m2505o(14343);
        return false;
    }
}
