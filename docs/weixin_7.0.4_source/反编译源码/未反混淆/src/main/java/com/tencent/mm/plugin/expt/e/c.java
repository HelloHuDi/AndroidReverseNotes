package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c {
    private static String TAG = "MicroMsg.ExptMMKV";
    private static c lOQ;
    private static HashSet<String> lOR = new HashSet();

    static {
        AppMethodBeat.i(73622);
        long yz = bo.yz();
        for (b name : b.values()) {
            lOR.add(name.name());
        }
        ab.i(TAG, "get mulit expt enum cost time [%d]", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(73622);
    }

    public static c bru() {
        AppMethodBeat.i(73615);
        if (lOQ == null) {
            lOQ = new c();
        }
        c cVar = lOQ;
        AppMethodBeat.o(73615);
        return cVar;
    }

    protected c() {
    }

    public static as brs() {
        AppMethodBeat.i(73616);
        as brs = com.tencent.mm.plugin.expt.d.b.brr().brs();
        AppMethodBeat.o(73616);
        return brs;
    }

    public static String a(a aVar, String str, boolean z) {
        AppMethodBeat.i(73617);
        String b = com.tencent.mm.plugin.expt.d.b.brr().b(aVar.name(), str, z, true);
        AppMethodBeat.o(73617);
        return b;
    }

    public final void bF(List<com.tencent.mm.plugin.expt.d.a> list) {
        AppMethodBeat.i(73618);
        if (!brv()) {
            AppMethodBeat.o(73618);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.o(73618);
        } else {
            long yz = bo.yz();
            as brs = com.tencent.mm.plugin.expt.d.b.brr().brs();
            if (brs == null) {
                AppMethodBeat.o(73618);
                return;
            }
            int i = 0;
            int i2 = 0;
            for (com.tencent.mm.plugin.expt.d.a aVar : list) {
                if (aVar != null) {
                    int i3;
                    HashMap brq = aVar.brq();
                    if (brq != null) {
                        int i4;
                        Iterator it = brq.keySet().iterator();
                        int i5 = 0;
                        while (true) {
                            i4 = i2;
                            if (!it.hasNext()) {
                                break;
                            }
                            brs.putInt((String) it.next(), aVar.field_exptId);
                            i2 = i4 + 1;
                            i5 = 1;
                        }
                        if (i5 != 0) {
                            brs.putString(aVar.field_exptId, aVar.field_exptContent);
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
            ab.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", aZm(), Integer.valueOf(list.size()), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(bo.az(yz)), Boolean.valueOf(commit));
            AppMethodBeat.o(73618);
        }
    }

    public final void bG(List<Integer> list) {
        AppMethodBeat.i(73619);
        if (!brv()) {
            AppMethodBeat.o(73619);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.o(73619);
        } else {
            long yz = bo.yz();
            as brs = com.tencent.mm.plugin.expt.d.b.brr().brs();
            if (brs == null) {
                AppMethodBeat.o(73619);
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
            ab.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", aZm(), Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(bo.az(yz)), Boolean.valueOf(commit));
            AppMethodBeat.o(73619);
        }
    }

    public final boolean brv() {
        AppMethodBeat.i(73620);
        if (ah.bqo()) {
            AppMethodBeat.o(73620);
            return true;
        }
        ab.c(TAG, "%s only mm process can write expt info", aZm());
        AppMethodBeat.o(73620);
        return false;
    }

    private String aZm() {
        AppMethodBeat.i(73621);
        String str = hashCode();
        AppMethodBeat.o(73621);
        return str;
    }
}
