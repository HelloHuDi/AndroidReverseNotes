package com.tencent.p177mm.plugin.clean.p362c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.clean.c.f */
public final class C33821f extends Thread {
    private boolean isStop = false;
    private HashSet<String> kwE;
    private int kwj = 0;
    private int kwk = 0;
    private C33824h kwz;

    /* renamed from: com.tencent.mm.plugin.clean.c.f$1 */
    class C338221 implements Runnable {
        C338221() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18708);
            if (C33821f.this.kwz != null) {
                C33821f.this.kwz.mo23158dP(C33821f.this.kwk, C33821f.this.kwj);
            }
            AppMethodBeat.m2505o(18708);
        }
    }

    public C33821f(HashSet<String> hashSet, C33824h c33824h) {
        this.kwE = hashSet;
        this.kwz = c33824h;
    }

    public final void run() {
        AppMethodBeat.m2504i(18710);
        if (this.kwE == null || this.kwE.isEmpty()) {
            C4990ab.m7420w("MicroMsg.DeleteOtherAccController", "delete paths is null.");
            m55317hh(0);
            AppMethodBeat.m2505o(18710);
            return;
        }
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("mm");
        C1720g.m3537RQ();
        C1720g.m3534RN();
        String x = C1178g.m2591x(stringBuilder.append(C1668a.m3383QF()).toString().getBytes());
        Iterator it = this.kwE.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            C4990ab.m7417i("MicroMsg.DeleteOtherAccController", "uinPath[%s] path[%s]", x, str);
            if (!C5046bo.isEqual(x, str)) {
                C33821f.m55316e(C1720g.m3536RP().eJL + str, arrayList);
                C33821f.m55316e(C5128ac.eSj + str, arrayList2);
            }
        }
        this.kwj = arrayList.size() + arrayList2.size();
        this.kwk = 0;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        int size = arrayList.size();
        PInt pInt = new PInt();
        int i = 0;
        while (!this.isStop && i < size) {
            pInt.value = 0;
            str = (String) arrayList.get(i);
            i++;
            C4990ab.m7417i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", Integer.valueOf(i), str, Integer.valueOf(pInt.value));
            if (m55312a(new C5728b(str), pInt, pLong) == -1) {
                break;
            }
            this.kwk++;
            bgc();
        }
        int size2 = arrayList2.size();
        PInt pInt2 = new PInt();
        i = 0;
        while (!this.isStop && i < size2) {
            pInt2.value = 0;
            str = (String) arrayList2.get(i);
            i++;
            C4990ab.m7417i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", Integer.valueOf(i), str, Integer.valueOf(pInt2.value));
            if (m55312a(new C5728b(str), pInt2, pLong2) == -1) {
                break;
            }
            this.kwk++;
            bgc();
        }
        C4990ab.m7417i("MicroMsg.DeleteOtherAccController", "delete finish sd[%d] data[%d]", Long.valueOf(pLong.value), Long.valueOf(pLong2.value));
        m55317hh(pLong.value);
        AppMethodBeat.m2505o(18710);
    }

    /* renamed from: e */
    private static void m55316e(String str, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(18711);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(18711);
            return;
        }
        C4990ab.m7417i("MicroMsg.DeleteOtherAccController", "check paths [%s]", str);
        C5728b c5728b = new C5728b(str);
        if (c5728b.exists() && c5728b.isDirectory()) {
            String[] list = c5728b.list();
            if (list != null && list.length > 0) {
                for (String str2 : list) {
                    C4990ab.m7411d("MicroMsg.DeleteOtherAccController", "check add path[%s]", str + "/" + str2);
                    arrayList.add(str2);
                }
            }
        }
        AppMethodBeat.m2505o(18711);
    }

    private void bgc() {
        AppMethodBeat.m2504i(18712);
        if (this.isStop) {
            AppMethodBeat.m2505o(18712);
            return;
        }
        C5004al.m7441d(new C338221());
        AppMethodBeat.m2505o(18712);
    }

    /* renamed from: hh */
    private void m55317hh(final long j) {
        AppMethodBeat.m2504i(18713);
        if (this.isStop) {
            AppMethodBeat.m2505o(18713);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18709);
                if (C33821f.this.kwz != null) {
                    C33821f.this.kwz.mo23159hi(j);
                }
                AppMethodBeat.m2505o(18709);
            }
        });
        AppMethodBeat.m2505o(18713);
    }

    /* renamed from: a */
    private int m55312a(C5728b c5728b, PInt pInt, PLong pLong) {
        AppMethodBeat.m2504i(18714);
        String str = "MicroMsg.DeleteOtherAccController";
        String str2 = "delete [%d] [%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = c5728b != null ? C5736j.m8649w(c5728b.dMD()) : BuildConfig.COMMAND;
        C4990ab.m7411d(str, str2, objArr);
        if (pInt.value >= 10) {
            if (this.isStop) {
                AppMethodBeat.m2505o(18714);
                return -1;
            }
            pInt.value = 0;
        }
        if (c5728b == null || !c5728b.exists()) {
            AppMethodBeat.m2505o(18714);
            return 0;
        }
        if (c5728b.isDirectory()) {
            C5728b[] dMF = c5728b.dMF();
            if (dMF != null) {
                for (C5728b a : dMF) {
                    if (m55312a(a, pInt, pLong) == -1) {
                        AppMethodBeat.m2505o(18714);
                        return -1;
                    }
                }
            }
            c5728b.delete();
        } else {
            pLong.value += c5728b.length();
            c5728b.delete();
            pInt.value++;
        }
        AppMethodBeat.m2505o(18714);
        return 1;
    }
}
