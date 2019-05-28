package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.protocal.protobuf.cwq;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.u */
enum C26784u {
    ;

    /* renamed from: a */
    static void m42629a(int i, LinkedList<cwq> linkedList) {
        C33137a c33137a;
        AppMethodBeat.m2504i(129665);
        HashSet hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cwq cwq = (cwq) it.next();
            if (!C5046bo.isNullOrNil(cwq.username)) {
                hashSet.add(cwq.username);
            }
        }
        ArrayList arrayList = new ArrayList(hashSet.size());
        arrayList.addAll(hashSet);
        if (i == 3) {
            c33137a = C33137a.RECENTS_LIST;
        } else {
            c33137a = C33137a.DEFAULT;
        }
        C42406r.m75073a(arrayList, c33137a);
        AppMethodBeat.m2505o(129665);
    }
}
