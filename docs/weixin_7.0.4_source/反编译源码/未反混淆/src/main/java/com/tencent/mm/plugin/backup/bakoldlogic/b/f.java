package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class f implements j {
    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17792);
        String str2 = new String(guVar.vED.wVI);
        h XO = b.aUY().aUZ().XO();
        biVar.setContent(str2);
        switch (guVar.jCt) {
            case 50:
                biVar.setStatus(6);
                break;
        }
        if (biVar.field_msgId == 0) {
            d.l(biVar);
        } else {
            XO.b(guVar.ptF, biVar);
        }
        AppMethodBeat.o(17792);
        return 0;
    }

    public final int a(gu guVar, bi biVar, LinkedList<u> linkedList) {
        AppMethodBeat.i(17791);
        if (biVar.field_content == null) {
            AppMethodBeat.o(17791);
            return 0;
        }
        int length = biVar.field_content.getBytes().length;
        AppMethodBeat.o(17791);
        return length;
    }
}
