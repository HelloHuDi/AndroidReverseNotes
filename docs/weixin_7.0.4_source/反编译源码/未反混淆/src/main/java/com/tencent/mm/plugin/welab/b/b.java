package com.tencent.mm.plugin.welab.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class b implements a {
    public final void e(final List<c> list, final List<d> list2, final List<Integer> list3) {
        AppMethodBeat.i(80577);
        d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80576);
                b.f(list, list2, list3);
                AppMethodBeat.o(80576);
            }
        }, "cross_welab");
        AppMethodBeat.o(80577);
    }

    static /* synthetic */ void f(List list, List list2, List list3) {
        ArrayList arrayList;
        a aVar;
        AppMethodBeat.i(80578);
        long yz = bo.yz();
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        if (!(list2 == null || list2.isEmpty())) {
            for (d dVar : list2) {
                Object obj;
                if (dVar.status == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    hashSet.add(dVar.appId);
                } else {
                    if (dVar.status == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        hashSet2.add(dVar.appId);
                    }
                }
            }
        }
        if (!(list3 == null || list3.isEmpty())) {
            arrayList = new ArrayList();
            for (Integer num : list3) {
                aVar = new a();
                aVar.field_expId = num.toString();
                com.tencent.mm.plugin.welab.a.ddj().uLQ.b((c) aVar, "expId");
                if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                    aVar.field_Switch = 3;
                    aVar.field_endtime = bo.anT() - 1;
                    arrayList.add(aVar);
                    ab.i("MicroMsg.XExptForWelabBridge", "welab app[%s] stop now", aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                com.tencent.mm.plugin.welab.a.ddj().uLQ.ee(arrayList);
            }
        }
        if (!(list == null || list.isEmpty())) {
            HashMap hashMap = new HashMap();
            for (c a : list) {
                aVar = f.a(a);
                if (aVar.isValid()) {
                    if (!hashMap.containsKey(aVar.field_LabsAppId)) {
                        hashMap.put(aVar.field_LabsAppId, aVar);
                    } else if (bo.getInt(((a) hashMap.get(aVar.field_LabsAppId)).field_expId, 0) < bo.getInt(aVar.field_expId, 0)) {
                        hashMap.put(aVar.field_LabsAppId, aVar);
                    }
                    aVar.ddv();
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (a aVar2 : hashMap.values()) {
                aVar = com.tencent.mm.plugin.welab.a.ddj().agI(aVar2.field_LabsAppId);
                if (aVar.ddw() && bo.getInt(aVar.field_expId, 0) > bo.getInt(aVar2.field_expId, 0)) {
                    ab.w("MicroMsg.XExptForWelabBridge", "it had local welab item, don't update.local[%s] new[%s]", aVar, aVar2);
                } else if (aVar2.ddx()) {
                    com.tencent.mm.plugin.welab.a.ddj().uLQ.a((c) aVar2, "expId");
                } else {
                    arrayList2.add(aVar2);
                    linkedList.add(aVar2);
                    com.tencent.mm.plugin.welab.e.b.ddC().f(aVar2);
                    com.tencent.mm.plugin.welab.d.A(aVar2.field_LabsAppId, aVar2.field_expId, com.tencent.mm.plugin.welab.e.b.ddC().e(aVar2));
                }
            }
            if (!arrayList2.isEmpty()) {
                com.tencent.mm.plugin.welab.a.ddj().uLQ.ee(arrayList2);
            }
            h.pYm.k(863, 20, 1);
        }
        if (!(hashSet.isEmpty() && hashSet2.isEmpty())) {
            arrayList = new ArrayList();
            for (a aVar22 : com.tencent.mm.plugin.welab.a.ddj().uLQ.dds()) {
                if (aVar22 != null && aVar22.isValid() && aVar22.ddw()) {
                    if (hashSet.contains(aVar22.field_LabsAppId) && aVar22.field_Switch == 1) {
                        aVar22.field_Switch = 2;
                        arrayList.add(aVar22);
                    }
                    if (hashSet2.contains(aVar22.field_LabsAppId) && aVar22.field_Switch == 2) {
                        aVar22.field_Switch = 1;
                        arrayList.add(aVar22);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.tencent.mm.plugin.welab.a.ddj().uLQ.ee(arrayList);
            }
        }
        com.tencent.mm.plugin.welab.a.ddj();
        com.tencent.mm.plugin.welab.a.ed(linkedList);
        String str = "MicroMsg.XExptForWelabBridge";
        String str2 = "itemList [%d] delList[%d] cost[%d] openAppId[%s] closeAppId[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(list != null ? list.size() : 0);
        objArr[1] = Integer.valueOf(list3 != null ? list3.size() : 0);
        objArr[2] = Long.valueOf(bo.az(yz));
        objArr[3] = hashSet;
        objArr[4] = hashSet2;
        ab.i(str, str2, objArr);
        AppMethodBeat.o(80578);
    }
}
