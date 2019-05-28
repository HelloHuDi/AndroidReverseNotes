package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.j.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

enum u {
    ;

    static void a(int i, LinkedList<cwq> linkedList) {
        a aVar;
        AppMethodBeat.i(129665);
        HashSet hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cwq cwq = (cwq) it.next();
            if (!bo.isNullOrNil(cwq.username)) {
                hashSet.add(cwq.username);
            }
        }
        ArrayList arrayList = new ArrayList(hashSet.size());
        arrayList.addAll(hashSet);
        if (i == 3) {
            aVar = a.RECENTS_LIST;
        } else {
            aVar = a.DEFAULT;
        }
        r.a(arrayList, aVar);
        AppMethodBeat.o(129665);
    }
}
