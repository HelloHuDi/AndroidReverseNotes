package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class e implements l {
    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17458);
        String str2 = new String(guVar.vED.wVI);
        h XO = d.aUr().aUs().XO();
        biVar.setContent(str2);
        switch (guVar.jCt) {
            case 50:
                biVar.setStatus(6);
                break;
        }
        if (biVar.field_msgId == 0) {
            c.l(biVar);
        } else {
            XO.b(guVar.ptF, biVar);
        }
        AppMethodBeat.o(17458);
        return 0;
    }

    public final int a(gu guVar, boolean z, bi biVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        AppMethodBeat.i(17457);
        if (biVar.field_content == null) {
            AppMethodBeat.o(17457);
            return 0;
        }
        int length = biVar.field_content.getBytes().length;
        AppMethodBeat.o(17457);
        return length;
    }
}
