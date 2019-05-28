package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f extends Thread {
    private boolean isStop = false;
    private HashSet<String> kwE;
    private int kwj = 0;
    private int kwk = 0;
    private h kwz;

    public f(HashSet<String> hashSet, h hVar) {
        this.kwE = hashSet;
        this.kwz = hVar;
    }

    public final void run() {
        AppMethodBeat.i(18710);
        if (this.kwE == null || this.kwE.isEmpty()) {
            ab.w("MicroMsg.DeleteOtherAccController", "delete paths is null.");
            hh(0);
            AppMethodBeat.o(18710);
            return;
        }
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.RQ();
        g.RN();
        String x = com.tencent.mm.a.g.x(stringBuilder.append(a.QF()).toString().getBytes());
        Iterator it = this.kwE.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            ab.i("MicroMsg.DeleteOtherAccController", "uinPath[%s] path[%s]", x, str);
            if (!bo.isEqual(x, str)) {
                e(g.RP().eJL + str, arrayList);
                e(ac.eSj + str, arrayList2);
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
            ab.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", Integer.valueOf(i), str, Integer.valueOf(pInt.value));
            if (a(new b(str), pInt, pLong) == -1) {
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
            ab.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", Integer.valueOf(i), str, Integer.valueOf(pInt2.value));
            if (a(new b(str), pInt2, pLong2) == -1) {
                break;
            }
            this.kwk++;
            bgc();
        }
        ab.i("MicroMsg.DeleteOtherAccController", "delete finish sd[%d] data[%d]", Long.valueOf(pLong.value), Long.valueOf(pLong2.value));
        hh(pLong.value);
        AppMethodBeat.o(18710);
    }

    private static void e(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(18711);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(18711);
            return;
        }
        ab.i("MicroMsg.DeleteOtherAccController", "check paths [%s]", str);
        b bVar = new b(str);
        if (bVar.exists() && bVar.isDirectory()) {
            String[] list = bVar.list();
            if (list != null && list.length > 0) {
                for (String str2 : list) {
                    ab.d("MicroMsg.DeleteOtherAccController", "check add path[%s]", str + "/" + str2);
                    arrayList.add(str2);
                }
            }
        }
        AppMethodBeat.o(18711);
    }

    private void bgc() {
        AppMethodBeat.i(18712);
        if (this.isStop) {
            AppMethodBeat.o(18712);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18708);
                if (f.this.kwz != null) {
                    f.this.kwz.dP(f.this.kwk, f.this.kwj);
                }
                AppMethodBeat.o(18708);
            }
        });
        AppMethodBeat.o(18712);
    }

    private void hh(final long j) {
        AppMethodBeat.i(18713);
        if (this.isStop) {
            AppMethodBeat.o(18713);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18709);
                if (f.this.kwz != null) {
                    f.this.kwz.hi(j);
                }
                AppMethodBeat.o(18709);
            }
        });
        AppMethodBeat.o(18713);
    }

    private int a(b bVar, PInt pInt, PLong pLong) {
        AppMethodBeat.i(18714);
        String str = "MicroMsg.DeleteOtherAccController";
        String str2 = "delete [%d] [%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = bVar != null ? j.w(bVar.dMD()) : BuildConfig.COMMAND;
        ab.d(str, str2, objArr);
        if (pInt.value >= 10) {
            if (this.isStop) {
                AppMethodBeat.o(18714);
                return -1;
            }
            pInt.value = 0;
        }
        if (bVar == null || !bVar.exists()) {
            AppMethodBeat.o(18714);
            return 0;
        }
        if (bVar.isDirectory()) {
            b[] dMF = bVar.dMF();
            if (dMF != null) {
                for (b a : dMF) {
                    if (a(a, pInt, pLong) == -1) {
                        AppMethodBeat.o(18714);
                        return -1;
                    }
                }
            }
            bVar.delete();
        } else {
            pLong.value += bVar.length();
            bVar.delete();
            pInt.value++;
        }
        AppMethodBeat.o(18714);
        return 1;
    }
}
