package com.tencent.p177mm.plugin.expt.p1257e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C3002b;
import com.tencent.p177mm.plugin.expt.p396d.C3006b;
import com.tencent.p177mm.plugin.expt.p396d.C7503a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.e.c */
public final class C27892c {
    private static String TAG = "MicroMsg.ExptMMKV";
    private static C27892c lOQ;
    private static HashSet<String> lOR = new HashSet();

    static {
        AppMethodBeat.m2504i(73622);
        long yz = C5046bo.m7588yz();
        for (C3002b name : C3002b.values()) {
            lOR.add(name.name());
        }
        C4990ab.m7417i(TAG, "get mulit expt enum cost time [%d]", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(73622);
    }

    public static C27892c bru() {
        AppMethodBeat.m2504i(73615);
        if (lOQ == null) {
            lOQ = new C27892c();
        }
        C27892c c27892c = lOQ;
        AppMethodBeat.m2505o(73615);
        return c27892c;
    }

    protected C27892c() {
    }

    public static C5018as brs() {
        AppMethodBeat.m2504i(73616);
        C5018as brs = C3006b.brr().brs();
        AppMethodBeat.m2505o(73616);
        return brs;
    }

    /* renamed from: a */
    public static String m44337a(C11745a c11745a, String str, boolean z) {
        AppMethodBeat.m2504i(73617);
        String b = C3006b.brr().mo7215b(c11745a.name(), str, z, true);
        AppMethodBeat.m2505o(73617);
        return b;
    }

    /* renamed from: bF */
    public final void mo45792bF(List<C7503a> list) {
        AppMethodBeat.m2504i(73618);
        if (!brv()) {
            AppMethodBeat.m2505o(73618);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(73618);
        } else {
            long yz = C5046bo.m7588yz();
            C5018as brs = C3006b.brr().brs();
            if (brs == null) {
                AppMethodBeat.m2505o(73618);
                return;
            }
            int i = 0;
            int i2 = 0;
            for (C7503a c7503a : list) {
                if (c7503a != null) {
                    int i3;
                    HashMap brq = c7503a.brq();
                    if (brq != null) {
                        int i4;
                        Iterator it = brq.keySet().iterator();
                        int i5 = 0;
                        while (true) {
                            i4 = i2;
                            if (!it.hasNext()) {
                                break;
                            }
                            brs.putInt((String) it.next(), c7503a.field_exptId);
                            i2 = i4 + 1;
                            i5 = 1;
                        }
                        if (i5 != 0) {
                            brs.putString(c7503a.field_exptId, c7503a.field_exptContent);
                            i3 = i + 1;
                            i2 = i4;
                        } else {
                            i3 = i;
                            i2 = i4;
                        }
                    } else {
                        i3 = i;
                    }
                    i = i3;
                }
            }
            boolean commit = brs.commit();
            C4990ab.m7417i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", aZm(), Integer.valueOf(list.size()), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)), Boolean.valueOf(commit));
            AppMethodBeat.m2505o(73618);
        }
    }

    /* renamed from: bG */
    public final void mo45793bG(List<Integer> list) {
        AppMethodBeat.m2504i(73619);
        if (!brv()) {
            AppMethodBeat.m2505o(73619);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(73619);
        } else {
            long yz = C5046bo.m7588yz();
            C5018as brs = C3006b.brr().brs();
            if (brs == null) {
                AppMethodBeat.m2505o(73619);
                return;
            }
            HashSet hashSet = new HashSet();
            int i = 0;
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                if (brs.contains(String.valueOf(intValue2))) {
                    brs.remove(String.valueOf(intValue2));
                    hashSet.add(Integer.valueOf(intValue2));
                    intValue2 = i + 1;
                } else {
                    intValue2 = i;
                }
                i = intValue2;
            }
            Iterator it = lOR.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                int i3 = brs.getInt(str, 0);
                if (i3 > 0 && hashSet.contains(Integer.valueOf(i3))) {
                    brs.remove(str);
                    i2++;
                }
                i2 = i2;
            }
            boolean commit = brs.commit();
            C4990ab.m7417i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", aZm(), Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(C5046bo.m7525az(yz)), Boolean.valueOf(commit));
            AppMethodBeat.m2505o(73619);
        }
    }

    public final boolean brv() {
        AppMethodBeat.m2504i(73620);
        if (C4996ah.bqo()) {
            AppMethodBeat.m2505o(73620);
            return true;
        }
        C4990ab.m7409c(TAG, "%s only mm process can write expt info", aZm());
        AppMethodBeat.m2505o(73620);
        return false;
    }

    private String aZm() {
        AppMethodBeat.m2504i(73621);
        String str = hashCode();
        AppMethodBeat.m2505o(73621);
        return str;
    }
}
