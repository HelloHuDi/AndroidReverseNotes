package com.tencent.p177mm.plugin.topstory.p539a.p540a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.topstory.a.a.a */
public final class C4202a {
    /* renamed from: ID */
    public static int f1285ID = 845;

    /* renamed from: a */
    public static void m6546a(C29428a c29428a) {
        ArrayList arrayList;
        IDKey iDKey;
        AppMethodBeat.m2504i(96378);
        if (c29428a.sAP > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(f1285ID);
            iDKey.SetKey(0);
            iDKey.SetValue(c29428a.sAP);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(f1285ID);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            C7053e.pXa.mo8379b(arrayList, false);
        }
        if (c29428a.sAG > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(f1285ID);
            iDKey.SetKey(2);
            iDKey.SetValue(c29428a.sAG);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(f1285ID);
            iDKey.SetKey(3);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            C7053e.pXa.mo8379b(arrayList, false);
        }
        if (c29428a.sAQ > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(f1285ID);
            iDKey.SetKey(4);
            iDKey.SetValue(c29428a.sAQ);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(f1285ID);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            C7053e.pXa.mo8379b(arrayList, false);
        }
        AppMethodBeat.m2505o(96378);
    }
}
