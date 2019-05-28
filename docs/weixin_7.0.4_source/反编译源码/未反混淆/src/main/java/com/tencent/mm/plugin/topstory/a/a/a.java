package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import java.util.ArrayList;

public final class a {
    public static int ID = 845;

    public static void a(com.tencent.mm.plugin.topstory.a.b.a aVar) {
        ArrayList arrayList;
        IDKey iDKey;
        AppMethodBeat.i(96378);
        if (aVar.sAP > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(0);
            iDKey.SetValue(aVar.sAP);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            e.pXa.b(arrayList, false);
        }
        if (aVar.sAG > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(2);
            iDKey.SetValue(aVar.sAG);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(3);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            e.pXa.b(arrayList, false);
        }
        if (aVar.sAQ > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(4);
            iDKey.SetValue(aVar.sAQ);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(ID);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            e.pXa.b(arrayList, false);
        }
        AppMethodBeat.o(96378);
    }
}
