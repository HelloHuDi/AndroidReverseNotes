package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C44101be;
import com.tencent.p177mm.protocal.protobuf.C44102bf;
import com.tencent.p177mm.protocal.protobuf.cgq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.g */
public final class C20602g {
    public C27896f lMA;

    C20602g() {
    }

    /* renamed from: c */
    static void m31838c(C44101be c44101be) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(73373);
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: " + c44101be.vDg.activityName);
        C44102bf bqs = C27895c.bqs();
        C20602g.m31836c(bqs);
        if (bqs == null) {
            linkedList = null;
        } else {
            linkedList = bqs.vDi;
        }
        if (linkedList == null) {
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: allTaskRecords == null");
            C20602g.m31832a(bqs, c44101be, true);
        } else {
            boolean z = false;
            int size = linkedList.size() - 1;
            while (size >= 0) {
                boolean z2;
                cgq cgq = (cgq) linkedList.get(size);
                if (cgq != null && cgq.xfx) {
                    for (int size2 = cgq.xfy.size() - 1; size2 >= 0; size2--) {
                        C44101be c44101be2 = (C44101be) cgq.xfy.get(size2);
                        if (c44101be2 != null && C45902h.m85094a(c44101be.vDg, c44101be2.vDg)) {
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
                C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: findThisTask NOT: " + c44101be.vDg.activityName);
                C20602g.m31832a(bqs, c44101be, true);
            }
        }
        C27895c.m44357a(bqs);
        AppMethodBeat.m2505o(73373);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final boolean mo35875d(C44101be c44101be) {
        AppMethodBeat.m2504i(73374);
        if (TextUtils.isEmpty(c44101be.vDg.activityName)) {
            AppMethodBeat.m2505o(73374);
            return false;
        }
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, flagNewTask: " + c44101be.vDg.activityName);
        C44102bf bqs = C27895c.bqs();
        C20602g.m31836c(bqs);
        C7583c a = C20602g.m31831a(bqs, c44101be);
        if (a == null) {
            AppMethodBeat.m2505o(73374);
            return false;
        }
        cgq cgq = (cgq) a.get(0);
        bqs.vDi.remove(((Integer) a.get(1)).intValue());
        bqs.vDi.addLast(cgq);
        C44101be c44101be2 = (C44101be) cgq.xfy.getLast();
        if (!(c44101be2 == null || C45902h.m85094a(c44101be2.vDg, c44101be.vDg))) {
            C4990ab.m7412e("TaskRecordWrapper", "habbyge-mali, flagNewTask: " + c44101be.vDg.activityName + "/" + c44101be2.vDg.activityName);
            int size = cgq.xfy.size() - 1;
            while (size >= 0 && !C45902h.m85094a(((C44101be) cgq.xfy.get(size)).vDg, c44101be.vDg)) {
                cgq.xfy.remove(size);
                size--;
            }
        }
        C27895c.m44357a(bqs);
        if (this.lMA != null) {
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, activityRecord: " + c44101be.vDg.activityName);
        }
        AppMethodBeat.m2505o(73374);
        return true;
    }

    /* renamed from: a */
    public static C44101be m31830a(C44102bf c44102bf, String str, String str2) {
        AppMethodBeat.m2504i(73375);
        if (c44102bf == null) {
            AppMethodBeat.m2505o(73375);
            return null;
        }
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, doPopRealActivity: " + str + "=" + str2);
        for (int size = c44102bf.vDi.size() - 1; size >= 0; size--) {
            cgq cgq = (cgq) c44102bf.vDi.get(size);
            for (int size2 = cgq.xfy.size() - 1; size2 >= 0; size2--) {
                C44101be c44101be = (C44101be) cgq.xfy.get(size2);
                if (C45902h.m85095l(c44101be.vDg.activityName, c44101be.vDg.wkp, str, str2)) {
                    C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, doPopRealActivity.pop YES: " + str + "=" + str2);
                    cgq.xfy.remove(size2);
                    if (cgq.xfy.isEmpty()) {
                        c44102bf.vDi.remove(size);
                    }
                    AppMethodBeat.m2505o(73375);
                    return c44101be;
                }
                C4990ab.m7412e("TaskRecordWrapper", "habbyge-mali, doPopRealActivity.pop NOT: " + str + "/" + c44101be.vDg.activityName);
            }
        }
        AppMethodBeat.m2505o(73375);
        return null;
    }

    /* renamed from: a */
    public static C7583c<cgq, Integer> m31831a(C44102bf c44102bf, C44101be c44101be) {
        AppMethodBeat.m2504i(73376);
        if (c44102bf == null || c44102bf.vDi.isEmpty() || c44101be == null) {
            AppMethodBeat.m2505o(73376);
            return null;
        }
        for (int size = c44102bf.vDi.size() - 1; size >= 0; size--) {
            cgq cgq = (cgq) c44102bf.vDi.get(size);
            if (!(cgq == null || cgq.xfy.isEmpty())) {
                int size2 = cgq.xfy.size() - 1;
                while (size2 >= 0) {
                    C44101be c44101be2 = (C44101be) cgq.xfy.get(size2);
                    if (c44101be2 == null || !C45902h.m85094a(c44101be.vDg, c44101be2.vDg)) {
                        size2--;
                    } else {
                        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, getTaskOfActivity 2: " + c44101be2.vDg.activityName + "/" + c44101be2.vDg.wkp);
                        C7583c<cgq, Integer> F = C5710a.m8574F(cgq, Integer.valueOf(size));
                        AppMethodBeat.m2505o(73376);
                        return F;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(73376);
        return null;
    }

    /* renamed from: b */
    static void m31834b(C44102bf c44102bf, C44101be c44101be) {
        AppMethodBeat.m2504i(73377);
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, push: " + c44101be.vDg.activityName);
        cgq cgq = null;
        if (!c44102bf.vDi.isEmpty()) {
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, push: stack.taskRecords NOT NULL");
            cgq = (cgq) c44102bf.vDi.getLast();
        }
        if (cgq == null) {
            cgq = new cgq();
            c44102bf.vDi.addLast(cgq);
        }
        cgq.xfy.addLast(c44101be);
        AppMethodBeat.m2505o(73377);
    }

    /* renamed from: a */
    static void m31832a(C44102bf c44102bf, C44101be c44101be, boolean z) {
        AppMethodBeat.m2504i(73378);
        if (c44101be == null) {
            AppMethodBeat.m2505o(73378);
            return;
        }
        cgq cgq = new cgq();
        cgq.xfx = z;
        cgq.xfy.addLast(c44101be);
        if (c44102bf == null) {
            c44102bf = new C44102bf();
        }
        c44102bf.vDi.addLast(cgq);
        AppMethodBeat.m2505o(73378);
    }

    /* renamed from: b */
    static boolean m31835b(C44102bf c44102bf) {
        AppMethodBeat.m2504i(73379);
        if (c44102bf == null) {
            AppMethodBeat.m2505o(73379);
            return false;
        }
        cgq cgq = null;
        if (!c44102bf.vDi.isEmpty()) {
            cgq = (cgq) c44102bf.vDi.getLast();
        }
        if (cgq == null || !cgq.xfx) {
            AppMethodBeat.m2505o(73379);
            return false;
        }
        AppMethodBeat.m2505o(73379);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo35873a(C44102bf c44102bf, int i) {
        AppMethodBeat.m2504i(73380);
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, pop_int: ".concat(String.valueOf(i)));
        if (c44102bf == null) {
            AppMethodBeat.m2505o(73380);
            return;
        }
        cgq cgq = (cgq) c44102bf.vDi.getLast();
        int size = cgq.xfy.size();
        if (i < 0 || i >= size) {
            AppMethodBeat.m2505o(73380);
            return;
        }
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, pop_int activityCount = ".concat(String.valueOf(size)));
        for (int i2 = size - 1; i2 >= i; i2--) {
            C44101be c44101be = (C44101be) cgq.xfy.remove(i2);
            C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, pop_int_activity: " + c44101be.vDg.activityName);
            if (this.lMA != null) {
                this.lMA.mo23526b(c44101be);
            }
        }
        if (cgq.xfy.isEmpty() && !c44102bf.vDi.isEmpty()) {
            c44102bf.vDi.removeLast();
        }
        AppMethodBeat.m2505o(73380);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo35874a(C44102bf c44102bf, int i, C44101be c44101be) {
        AppMethodBeat.m2504i(73381);
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, popTask: " + i + "/" + c44101be.vDg.activityName);
        if (c44102bf == null) {
            AppMethodBeat.m2505o(73381);
            return;
        }
        int size = c44102bf.vDi.size();
        if (i < 0 || i >= size) {
            AppMethodBeat.m2505o(73381);
            return;
        }
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, popTask taskCount = ".concat(String.valueOf(size)));
        for (int i2 = size - 1; i2 >= i; i2--) {
            Iterator it = ((cgq) c44102bf.vDi.remove(i2)).xfy.iterator();
            while (it.hasNext()) {
                C44101be c44101be2 = (C44101be) it.next();
                if (this.lMA != null) {
                    this.lMA.mo23526b(c44101be2);
                }
            }
        }
        AppMethodBeat.m2505o(73381);
    }

    /* renamed from: c */
    static C7583c<Integer, Integer> m31837c(C44102bf c44102bf, C44101be c44101be) {
        AppMethodBeat.m2504i(73382);
        C7583c b = C20602g.m31833b(c44102bf, c44101be.vDg.activityName, c44101be.vDg.wkp);
        AppMethodBeat.m2505o(73382);
        return b;
    }

    /* renamed from: b */
    public static C7583c<Integer, Integer> m31833b(C44102bf c44102bf, String str, String str2) {
        AppMethodBeat.m2504i(73383);
        if (TextUtils.isEmpty(str)) {
            C7583c F = C5710a.m8574F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.m2505o(73383);
            return F;
        }
        C4990ab.m7410d("TaskRecordWrapper", "habbyge-mali, search: " + str + "/" + str2);
        C7583c<Integer, Integer> F2;
        if (c44102bf == null) {
            F2 = C5710a.m8574F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.m2505o(73383);
            return F2;
        }
        int size = c44102bf.vDi.size();
        if (size <= 0) {
            F2 = C5710a.m8574F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.m2505o(73383);
            return F2;
        }
        int i = size - 1;
        int i2 = -1;
        int i3 = -1;
        while (i >= 0) {
            int i4;
            cgq cgq = (cgq) c44102bf.vDi.get(i);
            for (int size2 = cgq.xfy.size() - 1; size2 >= 0; size2--) {
                C44101be c44101be = (C44101be) cgq.xfy.get(size2);
                if (C45902h.m85095l(str, str2, c44101be.vDg.activityName, c44101be.vDg.wkp)) {
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
            F2 = C5710a.m8574F(Integer.valueOf(-1), Integer.valueOf(-1));
            AppMethodBeat.m2505o(73383);
            return F2;
        }
        F2 = C5710a.m8574F(Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.m2505o(73383);
        return F2;
    }

    /* renamed from: c */
    static C44101be m31836c(C44102bf c44102bf) {
        AppMethodBeat.m2504i(73385);
        if (c44102bf == null) {
            AppMethodBeat.m2505o(73385);
            return null;
        }
        cgq cgq;
        if (c44102bf.vDi.isEmpty()) {
            cgq = null;
        } else {
            cgq = (cgq) c44102bf.vDi.getLast();
        }
        if (cgq == null) {
            AppMethodBeat.m2505o(73385);
            return null;
        } else if (cgq.xfy.isEmpty()) {
            AppMethodBeat.m2505o(73385);
            return null;
        } else {
            C44101be c44101be = (C44101be) cgq.xfy.getLast();
            AppMethodBeat.m2505o(73385);
            return c44101be;
        }
    }

    public static C7583c<C44102bf, C44101be> bqz() {
        AppMethodBeat.m2504i(73384);
        C44102bf bqs = C27895c.bqs();
        C7583c F = C5710a.m8574F(bqs, C20602g.m31836c(bqs));
        AppMethodBeat.m2505o(73384);
        return F;
    }
}
