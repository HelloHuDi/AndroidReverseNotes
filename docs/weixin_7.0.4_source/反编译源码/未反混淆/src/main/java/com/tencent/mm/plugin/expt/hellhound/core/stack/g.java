package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class g {
    public f lMA;

    g() {
    }

    static void c(be beVar) {
        LinkedList linkedList;
        AppMethodBeat.i(73373);
        ab.d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: " + beVar.vDg.activityName);
        bf bqs = c.bqs();
        c(bqs);
        if (bqs == null) {
            linkedList = null;
        } else {
            linkedList = bqs.vDi;
        }
        if (linkedList == null) {
            ab.d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: allTaskRecords == null");
            a(bqs, beVar, true);
        } else {
            boolean z = false;
            int size = linkedList.size() - 1;
            while (size >= 0) {
                boolean z2;
                cgq cgq = (cgq) linkedList.get(size);
                if (cgq != null && cgq.xfx) {
                    for (int size2 = cgq.xfy.size() - 1; size2 >= 0; size2--) {
                        be beVar2 = (be) cgq.xfy.get(size2);
                        if (beVar2 != null && h.a(beVar.vDg, beVar2.vDg)) {
                            linkedList.addLast((cgq) linkedList.remove(size));
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = z;
                size--;
                z = z2;
            }
            if (!z) {
                ab.d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: findThisTask NOT: " + beVar.vDg.activityName);
                a(bqs, beVar, true);
            }
        }
        c.a(bqs);
        AppMethodBeat.o(73373);
    }

    /* Access modifiers changed, original: final */
    public final boolean d(be beVar) {
        AppMethodBeat.i(73374);
        if (TextUtils.isEmpty(beVar.vDg.activityName)) {
            AppMethodBeat.o(73374);
            return false;
        }
        ab.d("TaskRecordWrapper", "habbyge-mali, flagNewTask: " + beVar.vDg.activityName);
        bf bqs = c.bqs();
        c(bqs);
        c a = a(bqs, beVar);
        if (a == null) {
            AppMethodBeat.o(73374);
            return false;
        }
        cgq cgq = (cgq) a.get(0);
        bqs.vDi.remove(((Integer) a.get(1)).intValue());
        bqs.vDi.addLast(cgq);
        be beVar2 = (be) cgq.xfy.getLast();
        if (!(beVar2 == null || h.a(beVar2.vDg, beVar.vDg))) {
            ab.e("TaskRecordWrapper", "habbyge-mali, flagNewTask: " + beVar.vDg.activityName + "/" + beVar2.vDg.activityName);
            int size = cgq.xfy.size() - 1;
            while (size >= 0 && !h.a(((be) cgq.xfy.get(size)).vDg, beVar.vDg)) {
                cgq.xfy.remove(size);
                size--;
            }
        }
        c.a(bqs);
        if (this.lMA != null) {
            ab.d("TaskRecordWrapper", "habbyge-mali, activityRecord: " + beVar.vDg.activityName);
        }
        AppMethodBeat.o(73374);
        return true;
    }

    public static be a(bf bfVar, String str, String str2) {
        AppMethodBeat.i(73375);
        if (bfVar == null) {
            AppMethodBeat.o(73375);
            return null;
        }
        ab.d("TaskRecordWrapper", "habbyge-mali, doPopRealActivity: " + str + "=" + str2);
        for (int size = bfVar.vDi.size() - 1; size >= 0; size--) {
            cgq cgq = (cgq) bfVar.vDi.get(size);
            for (int size2 = cgq.xfy.size() - 1; size2 >= 0; size2--) {
                be beVar = (be) cgq.xfy.get(size2);
                if (h.l(beVar.vDg.activityName, beVar.vDg.wkp, str, str2)) {
                    ab.d("TaskRecordWrapper", "habbyge-mali, doPopRealActivity.pop YES: " + str + "=" + str2);
                    cgq.xfy.remove(size2);
                    if (cgq.xfy.isEmpty()) {
                        bfVar.vDi.remove(size);
                    }
                    AppMethodBeat.o(73375);
                    return beVar;
                }
                ab.e("TaskRecordWrapper", "habbyge-mali, doPopRealActivity.pop NOT: " + str + "/" + beVar.vDg.activityName);
            }
        }
        AppMethodBeat.o(73375);
        return null;
    }

    public static c<cgq, Integer> a(bf bfVar, be beVar) {
        AppMethodBeat.i(73376);
        if (bfVar == null || bfVar.vDi.isEmpty() || beVar == null) {
            AppMethodBeat.o(73376);
            return null;
        }
        for (int size = bfVar.vDi.size() - 1; size >= 0; size--) {
            cgq cgq = (cgq) bfVar.vDi.get(size);
            if (!(cgq == null || cgq.xfy.isEmpty())) {
                int size2 = cgq.xfy.size() - 1;
                while (size2 >= 0) {
                    be beVar2 = (be) cgq.xfy.get(size2);
                    if (beVar2 == null || !h.a(beVar.vDg, beVar2.vDg)) {
                        size2--;
                    } else {
                        ab.d("TaskRecordWrapper", "habbyge-mali, getTaskOfActivity 2: " + beVar2.vDg.activityName + "/" + beVar2.vDg.wkp);
                        c<cgq, Integer> F = a.F(cgq, Integer.valueOf(size));
                        AppMethodBeat.o(73376);
                        return F;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(73376);
        return null;
    }

    static void b(bf bfVar, be beVar) {
        AppMethodBeat.i(73377);
        ab.d("TaskRecordWrapper", "habbyge-mali, push: " + beVar.vDg.activityName);
        cgq cgq = null;
        if (!bfVar.vDi.isEmpty()) {
            ab.d("TaskRecordWrapper", "habbyge-mali, push: stack.taskRecords NOT NULL");
            cgq = (cgq) bfVar.vDi.getLast();
        }
        if (cgq == null) {
            cgq = new cgq();
            bfVar.vDi.addLast(cgq);
        }
        cgq.xfy.addLast(beVar);
        AppMethodBeat.o(73377);
    }

    static void a(bf bfVar, be beVar, boolean z) {
        AppMethodBeat.i(73378);
        if (beVar == null) {
            AppMethodBeat.o(73378);
            return;
        }
        cgq cgq = new cgq();
        cgq.xfx = z;
        cgq.xfy.addLast(beVar);
        if (bfVar == null) {
            bfVar = new bf();
        }
        bfVar.vDi.addLast(cgq);
        AppMethodBeat.o(73378);
    }

    static boolean b(bf bfVar) {
        AppMethodBeat.i(73379);
        if (bfVar == null) {
            AppMethodBeat.o(73379);
            return false;
        }
        cgq cgq = null;
        if (!bfVar.vDi.isEmpty()) {
            cgq = (cgq) bfVar.vDi.getLast();
        }
        if (cgq == null || !cgq.xfx) {
            AppMethodBeat.o(73379);
            return false;
        }
        AppMethodBeat.o(73379);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void a(bf bfVar, int i) {
        AppMethodBeat.i(73380);
        ab.d("TaskRecordWrapper", "habbyge-mali, pop_int: ".concat(String.valueOf(i)));
        if (bfVar == null) {
            AppMethodBeat.o(73380);
            return;
        }
        cgq cgq = (cgq) bfVar.vDi.getLast();
        int size = cgq.xfy.size();
        if (i < 0 || i >= size) {
            AppMethodBeat.o(73380);
            return;
        }
        ab.d("TaskRecordWrapper", "habbyge-mali, pop_int activityCount = ".concat(String.valueOf(size)));
        for (int i2 = size - 1; i2 >= i; i2--) {
            be beVar = (be) cgq.xfy.remove(i2);
            ab.d("TaskRecordWrapper", "habbyge-mali, pop_int_activity: " + beVar.vDg.activityName);
            if (this.lMA != null) {
                this.lMA.b(beVar);
            }
        }
        if (cgq.xfy.isEmpty() && !bfVar.vDi.isEmpty()) {
            bfVar.vDi.removeLast();
        }
        AppMethodBeat.o(73380);
    }

    /* Access modifiers changed, original: final */
    public final void a(bf bfVar, int i, be beVar) {
        AppMethodBeat.i(73381);
        ab.d("TaskRecordWrapper", "habbyge-mali, popTask: " + i + "/" + beVar.vDg.activityName);
        if (bfVar == null) {
            AppMethodBeat.o(73381);
            return;
        }
        int size = bfVar.vDi.size();
        if (i < 0 || i >= size) {
            AppMethodBeat.o(73381);
            return;
        }
        ab.d("TaskRecordWrapper", "habbyge-mali, popTask taskCount = ".concat(String.valueOf(size)));
        for (int i2 = size - 1; i2 >= i; i2--) {
            Iterator it = ((cgq) bfVar.vDi.remove(i2)).xfy.iterator();
            while (it.hasNext()) {
                be beVar2 = (be) it.next();
                if (this.lMA != null) {
                    this.lMA.b(beVar2);
                }
            }
        }
        AppMethodBeat.o(73381);
    }

    static c<Integer, Integer> c(bf bfVar, be beVar) {
        AppMethodBeat.i(73382);
        c b = b(bfVar, beVar.vDg.activityName, beVar.vDg.wkp);
        AppMethodBeat.o(73382);
        return b;
    }

    public static c<Integer, Integer> b(bf bfVar, String str, String str2) {
        AppMethodBeat.i(73383);
        if (TextUtils.isEmpty(str)) {
            c F = a.F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.o(73383);
            return F;
        }
        ab.d("TaskRecordWrapper", "habbyge-mali, search: " + str + "/" + str2);
        c<Integer, Integer> F2;
        if (bfVar == null) {
            F2 = a.F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.o(73383);
            return F2;
        }
        int size = bfVar.vDi.size();
        if (size <= 0) {
            F2 = a.F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.o(73383);
            return F2;
        }
        int i = size - 1;
        int i2 = -1;
        int i3 = -1;
        while (i >= 0) {
            int i4;
            cgq cgq = (cgq) bfVar.vDi.get(i);
            for (int size2 = cgq.xfy.size() - 1; size2 >= 0; size2--) {
                be beVar = (be) cgq.xfy.get(size2);
                if (h.l(str, str2, beVar.vDg.activityName, beVar.vDg.wkp)) {
                    size = size2;
                    i4 = i;
                    break;
                }
            }
            size = i2;
            i4 = i3;
            i--;
            i2 = size;
            i3 = i4;
        }
        if (i3 == -1) {
            F2 = a.F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.o(73383);
            return F2;
        }
        F2 = a.F(Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(73383);
        return F2;
    }

    static be c(bf bfVar) {
        AppMethodBeat.i(73385);
        if (bfVar == null) {
            AppMethodBeat.o(73385);
            return null;
        }
        cgq cgq;
        if (bfVar.vDi.isEmpty()) {
            cgq = null;
        } else {
            cgq = (cgq) bfVar.vDi.getLast();
        }
        if (cgq == null) {
            AppMethodBeat.o(73385);
            return null;
        } else if (cgq.xfy.isEmpty()) {
            AppMethodBeat.o(73385);
            return null;
        } else {
            be beVar = (be) cgq.xfy.getLast();
            AppMethodBeat.o(73385);
            return beVar;
        }
    }

    public static c<bf, be> bqz() {
        AppMethodBeat.i(73384);
        bf bqs = c.bqs();
        c F = a.F(bqs, c(bqs));
        AppMethodBeat.o(73384);
        return F;
    }
}
