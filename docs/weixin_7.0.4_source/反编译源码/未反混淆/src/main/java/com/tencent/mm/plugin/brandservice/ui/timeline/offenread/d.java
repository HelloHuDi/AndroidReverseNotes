package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    static chc jQA;

    public static chc aWL() {
        AppMethodBeat.i(14342);
        if (jQA != null) {
            chc chc = jQA;
            AppMethodBeat.o(14342);
            return chc;
        }
        String str = (String) g.RP().Ry().get(a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(14342);
            return null;
        }
        chc chc2 = new chc();
        try {
            chc2.parseFrom(Base64.decode(str, 0));
            jQA = chc2;
            AppMethodBeat.o(14342);
            return chc2;
        } catch (IOException e) {
            ab.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", e.getMessage());
            AppMethodBeat.o(14342);
            return null;
        }
    }

    public static boolean FG(String str) {
        AppMethodBeat.i(14343);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(14343);
            return false;
        }
        chc aWL = aWL();
        if (aWL == null) {
            AppMethodBeat.o(14343);
            return false;
        }
        LinkedList linkedList = aWL.xfW;
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(14343);
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            chd chd = (chd) it.next();
            if (chd != null && str.equals(chd.vGE)) {
                AppMethodBeat.o(14343);
                return true;
            }
        }
        AppMethodBeat.o(14343);
        return false;
    }
}
