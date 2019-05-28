package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements com.tencent.mm.plugin.backup.c.b.a {
    public long jsU;
    private LinkedList<b> jsV = null;
    private LinkedList<b> jsW = null;
    private LinkedList<b> jsX = null;
    public boolean jsY = false;
    com.tencent.mm.plugin.backup.c.b jtR;
    public boolean jvR = false;
    public com.tencent.mm.plugin.backup.c.b.a jvS;
    private Object lock = new Object();

    public a() {
        AppMethodBeat.i(17478);
        AppMethodBeat.o(17478);
    }

    private static long E(LinkedList<b> linkedList) {
        AppMethodBeat.i(17479);
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((b) linkedList.get(0)).jrg;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                if (j > bVar.jrg) {
                    j2 = bVar.jrg;
                } else {
                    j2 = j;
                }
            }
        }
        AppMethodBeat.o(17479);
        return j;
    }

    public final LinkedList<b> aSU() {
        AppMethodBeat.i(17480);
        if (this.jsV == null) {
            this.jsV = new LinkedList();
        }
        LinkedList linkedList = this.jsV;
        AppMethodBeat.o(17480);
        return linkedList;
    }

    public final LinkedList<b> aSV() {
        AppMethodBeat.i(17481);
        if (this.jsW == null) {
            this.jsW = new LinkedList();
        }
        LinkedList linkedList = this.jsW;
        AppMethodBeat.o(17481);
        return linkedList;
    }

    public final void a(int i, long j, long j2, LinkedList<b> linkedList) {
        AppMethodBeat.i(17482);
        if (i == 0) {
            this.jsW = new LinkedList(linkedList);
            AppMethodBeat.o(17482);
            return;
        }
        if (this.jsW == null) {
            this.jsW = new LinkedList();
        } else {
            this.jsW.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (d.aUr().aUs().XO().v(bVar.jrf, j, j2) > 0) {
                this.jsW.add(bVar);
            }
        }
        AppMethodBeat.o(17482);
    }

    public final void F(LinkedList<b> linkedList) {
        AppMethodBeat.i(17483);
        if (linkedList == null || linkedList.size() == 0) {
            this.jsX = new LinkedList();
            AppMethodBeat.o(17483);
            return;
        }
        this.jsX = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.jsX.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
        AppMethodBeat.o(17483);
    }

    private LinkedList<b> aSW() {
        AppMethodBeat.i(17484);
        if (this.jsX == null) {
            this.jsX = new LinkedList();
        }
        LinkedList linkedList = this.jsX;
        AppMethodBeat.o(17484);
        return linkedList;
    }

    public final void fn(boolean z) {
        AppMethodBeat.i(17485);
        ab.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", Boolean.valueOf(z));
        this.jvR = z;
        d.aUr().aUu();
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17477);
                if (a.this.jtR != null) {
                    a.this.jtR.cancel();
                }
                a.this.jtR = new com.tencent.mm.plugin.backup.c.b();
                a.this.jtR.a(a.this);
                AppMethodBeat.o(17477);
            }
        }, "BackupPcChooseServer.calculateToChoose");
        AppMethodBeat.o(17485);
    }

    public final void B(LinkedList<b> linkedList) {
        AppMethodBeat.i(17486);
        String str = "MicroMsg.BackupPcChooseServer";
        String str2 = "onCalcuConvFinish, conv size[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        ab.i(str, str2, objArr);
        this.jsY = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.jvS != null) {
                this.jvS.B(linkedList);
            }
            if (this.jvR) {
                e aTF = b.aTD().aTF();
                e.jwu = true;
                aTF.jtS.aSI();
                b.aTD().aTa().stop();
                b.aTD().aSu().jqW = -23;
                b.aTD().aTF().ru(-23);
            }
            AppMethodBeat.o(17486);
            return;
        }
        this.jsV = new LinkedList(linkedList);
        this.jsU = E(this.jsV);
        b.aTD();
        SharedPreferences aSz = com.tencent.mm.plugin.backup.b.d.aSz();
        a(aSz.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), aSz.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), aSz.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), aSU());
        ab.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(linkedList.size()), Integer.valueOf(aSV().size()));
        if (this.jvR) {
            F(aSV());
            b.aTD().aTF().G(g.A(aSW()));
            b.aTD().aTF().gx((long) aSW().size());
        }
        if (this.jvS != null) {
            this.jvS.B(aSV());
        }
        AppMethodBeat.o(17486);
    }

    public final void aTC() {
        this.jsV = null;
        this.jsX = null;
        this.jsW = null;
        this.jsY = false;
    }

    public final void cancel() {
        AppMethodBeat.i(17487);
        ab.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", bo.dpG());
        synchronized (this.lock) {
            try {
                if (this.jtR != null) {
                    this.jtR.cancel();
                    this.jtR = null;
                }
                this.jsY = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17487);
            }
        }
    }
}
