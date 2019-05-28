package com.tencent.p177mm.plugin.welab.p753b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.welab.C29974a;
import com.tencent.p177mm.plugin.welab.C40361d;
import com.tencent.p177mm.plugin.welab.C40363f;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p1563e.C46450b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.welab.b.b */
public final class C35734b implements C7232a {
    /* renamed from: e */
    public final void mo15607e(final List<C14716c> list, final List<C46449d> list2, final List<Integer> list3) {
        AppMethodBeat.m2504i(80577);
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80576);
                C35734b.m58570f(list, list2, list3);
                AppMethodBeat.m2505o(80576);
            }
        }, "cross_welab");
        AppMethodBeat.m2505o(80577);
    }

    /* renamed from: f */
    static /* synthetic */ void m58570f(List list, List list2, List list3) {
        ArrayList arrayList;
        C23169a c23169a;
        AppMethodBeat.m2504i(80578);
        long yz = C5046bo.m7588yz();
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        if (!(list2 == null || list2.isEmpty())) {
            for (C46449d c46449d : list2) {
                Object obj;
                if (c46449d.status == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    hashSet.add(c46449d.appId);
                } else {
                    if (c46449d.status == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        hashSet2.add(c46449d.appId);
                    }
                }
            }
        }
        if (!(list3 == null || list3.isEmpty())) {
            arrayList = new ArrayList();
            for (Integer num : list3) {
                c23169a = new C23169a();
                c23169a.field_expId = num.toString();
                C29974a.ddj().uLQ.mo10102b((C4925c) c23169a, "expId");
                if (!TextUtils.isEmpty(c23169a.field_LabsAppId)) {
                    c23169a.field_Switch = 3;
                    c23169a.field_endtime = C5046bo.anT() - 1;
                    arrayList.add(c23169a);
                    C4990ab.m7417i("MicroMsg.XExptForWelabBridge", "welab app[%s] stop now", c23169a);
                }
            }
            if (!arrayList.isEmpty()) {
                C29974a.ddj().uLQ.mo63727ee(arrayList);
            }
        }
        if (!(list == null || list.isEmpty())) {
            HashMap hashMap = new HashMap();
            for (C14716c a : list) {
                c23169a = C40363f.m69203a(a);
                if (c23169a.isValid()) {
                    if (!hashMap.containsKey(c23169a.field_LabsAppId)) {
                        hashMap.put(c23169a.field_LabsAppId, c23169a);
                    } else if (C5046bo.getInt(((C23169a) hashMap.get(c23169a.field_LabsAppId)).field_expId, 0) < C5046bo.getInt(c23169a.field_expId, 0)) {
                        hashMap.put(c23169a.field_LabsAppId, c23169a);
                    }
                    c23169a.ddv();
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (C23169a c23169a2 : hashMap.values()) {
                c23169a = C29974a.ddj().agI(c23169a2.field_LabsAppId);
                if (c23169a.ddw() && C5046bo.getInt(c23169a.field_expId, 0) > C5046bo.getInt(c23169a2.field_expId, 0)) {
                    C4990ab.m7421w("MicroMsg.XExptForWelabBridge", "it had local welab item, don't update.local[%s] new[%s]", c23169a, c23169a2);
                } else if (c23169a2.ddx()) {
                    C29974a.ddj().uLQ.mo16760a((C4925c) c23169a2, "expId");
                } else {
                    arrayList2.add(c23169a2);
                    linkedList.add(c23169a2);
                    C46450b.ddC().mo74670f(c23169a2);
                    C40361d.m69199A(c23169a2.field_LabsAppId, c23169a2.field_expId, C46450b.ddC().mo74669e(c23169a2));
                }
            }
            if (!arrayList2.isEmpty()) {
                C29974a.ddj().uLQ.mo63727ee(arrayList2);
            }
            C7060h.pYm.mo15419k(863, 20, 1);
        }
        if (!(hashSet.isEmpty() && hashSet2.isEmpty())) {
            arrayList = new ArrayList();
            for (C23169a c23169a22 : C29974a.ddj().uLQ.dds()) {
                if (c23169a22 != null && c23169a22.isValid() && c23169a22.ddw()) {
                    if (hashSet.contains(c23169a22.field_LabsAppId) && c23169a22.field_Switch == 1) {
                        c23169a22.field_Switch = 2;
                        arrayList.add(c23169a22);
                    }
                    if (hashSet2.contains(c23169a22.field_LabsAppId) && c23169a22.field_Switch == 2) {
                        c23169a22.field_Switch = 1;
                        arrayList.add(c23169a22);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                C29974a.ddj().uLQ.mo63727ee(arrayList);
            }
        }
        C29974a.ddj();
        C29974a.m47423ed(linkedList);
        String str = "MicroMsg.XExptForWelabBridge";
        String str2 = "itemList [%d] delList[%d] cost[%d] openAppId[%s] closeAppId[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(list != null ? list.size() : 0);
        objArr[1] = Integer.valueOf(list3 != null ? list3.size() : 0);
        objArr[2] = Long.valueOf(C5046bo.m7525az(yz));
        objArr[3] = hashSet;
        objArr[4] = hashSet2;
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(80578);
    }
}
