package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    public com.tencent.mm.plugin.backup.c.b jsS;
    public b jsT;
    public long jsU;
    public LinkedList<f.b> jsV = null;
    public LinkedList<f.b> jsW = null;
    public LinkedList<f.b> jsX = null;
    public boolean jsY = false;
    public boolean jsZ = false;
    private Object lock = new Object();

    public a() {
        AppMethodBeat.i(17223);
        AppMethodBeat.o(17223);
    }

    public final LinkedList<f.b> aSU() {
        AppMethodBeat.i(17224);
        if (this.jsV == null) {
            this.jsV = new LinkedList();
        }
        LinkedList linkedList = this.jsV;
        AppMethodBeat.o(17224);
        return linkedList;
    }

    private static long E(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(17225);
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((f.b) linkedList.get(0)).jrg;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                f.b bVar = (f.b) it.next();
                if (j > bVar.jrg) {
                    j2 = bVar.jrg;
                } else {
                    j2 = j;
                }
            }
        }
        AppMethodBeat.o(17225);
        return j;
    }

    public final LinkedList<f.b> aSV() {
        AppMethodBeat.i(17226);
        if (this.jsW == null) {
            this.jsW = new LinkedList();
        }
        LinkedList linkedList = this.jsW;
        AppMethodBeat.o(17226);
        return linkedList;
    }

    public final void a(int i, long j, long j2, LinkedList<f.b> linkedList) {
        AppMethodBeat.i(17227);
        if (i == 0) {
            this.jsW = new LinkedList(linkedList);
            AppMethodBeat.o(17227);
            return;
        }
        this.jsW = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f.b bVar = (f.b) it.next();
            if (d.aUr().aUs().XO().v(bVar.jrf, j, j2) > 0) {
                this.jsW.add(bVar);
            }
        }
        AppMethodBeat.o(17227);
    }

    public final LinkedList<f.b> aSW() {
        AppMethodBeat.i(17228);
        if (this.jsX == null) {
            this.jsX = new LinkedList();
        }
        LinkedList linkedList = this.jsX;
        AppMethodBeat.o(17228);
        return linkedList;
    }

    public final void cancel() {
        AppMethodBeat.i(17229);
        synchronized (this.lock) {
            try {
                if (this.jsS != null) {
                    this.jsS.cancel();
                    this.jsS = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17229);
            }
        }
    }

    public final void aSX() {
        AppMethodBeat.i(17230);
        b.aSZ();
        SharedPreferences aSz = com.tencent.mm.plugin.backup.b.d.aSz();
        a(aSz.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), aSz.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), aSz.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), aSU());
        AppMethodBeat.o(17230);
    }

    public final void B(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(17231);
        ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.jsY = true;
        this.jsV = new LinkedList(linkedList);
        this.jsU = E(this.jsV);
        aSX();
        ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(aSU().size()), Integer.valueOf(aSV().size()));
        if (this.jsT != null) {
            this.jsT.B(aSV());
        }
        AppMethodBeat.o(17231);
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
        AppMethodBeat.i(17232);
        ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.jsV = linkedList;
        if (this.jsW != null) {
            Iterator it = this.jsW.iterator();
            while (it.hasNext()) {
                f.b bVar2 = (f.b) it.next();
                if (bVar2.jrf.equals(bVar.jrf)) {
                    bVar2.jri = bVar.jri;
                    bVar2.jrj = bVar.jrj;
                    break;
                }
            }
        }
        if (b.aSZ().aTb().jtV) {
            ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.aSZ().aSu().O(13, i, linkedList.size());
            b.aSZ().aTb().rj(13);
        }
        if (this.jsT != null) {
            this.jsT.a(aSV(), bVar, i);
        }
        AppMethodBeat.o(17232);
    }

    public final void C(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(17233);
        ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.jsZ = true;
        this.jsV = (LinkedList) linkedList.clone();
        aSX();
        if (b.aSZ().aTb().jtV) {
            ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.aSZ().aTb().aTp();
            AppMethodBeat.o(17233);
            return;
        }
        if (this.jsT != null) {
            this.jsT.C(linkedList);
        }
        AppMethodBeat.o(17233);
    }

    public final long aSY() {
        long j = 0;
        AppMethodBeat.i(17234);
        if (aSW() == null) {
            AppMethodBeat.o(17234);
            return 0;
        }
        Iterator it = aSW().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = ((f.b) it.next()).jri + j2;
            } else {
                AppMethodBeat.o(17234);
                return j2;
            }
        }
    }
}
