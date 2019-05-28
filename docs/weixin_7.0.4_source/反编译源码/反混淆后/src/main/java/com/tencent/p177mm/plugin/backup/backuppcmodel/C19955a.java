package com.tencent.p177mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p344c.C33685b;
import com.tencent.p177mm.plugin.backup.p344c.C33685b.C33684a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.a */
public final class C19955a implements C33684a {
    public long jsU;
    private LinkedList<C27443b> jsV = null;
    private LinkedList<C27443b> jsW = null;
    private LinkedList<C27443b> jsX = null;
    public boolean jsY = false;
    C33685b jtR;
    public boolean jvR = false;
    public C33684a jvS;
    private Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.a$1 */
    class C199561 implements Runnable {
        C199561() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17477);
            if (C19955a.this.jtR != null) {
                C19955a.this.jtR.cancel();
            }
            C19955a.this.jtR = new C33685b();
            C19955a.this.jtR.mo54237a(C19955a.this);
            AppMethodBeat.m2505o(17477);
        }
    }

    public C19955a() {
        AppMethodBeat.m2504i(17478);
        AppMethodBeat.m2505o(17478);
    }

    /* renamed from: E */
    private static long m30859E(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17479);
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((C27443b) linkedList.get(0)).jrg;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                C27443b c27443b = (C27443b) it.next();
                if (j > c27443b.jrg) {
                    j2 = c27443b.jrg;
                } else {
                    j2 = j;
                }
            }
        }
        AppMethodBeat.m2505o(17479);
        return j;
    }

    public final LinkedList<C27443b> aSU() {
        AppMethodBeat.m2504i(17480);
        if (this.jsV == null) {
            this.jsV = new LinkedList();
        }
        LinkedList linkedList = this.jsV;
        AppMethodBeat.m2505o(17480);
        return linkedList;
    }

    public final LinkedList<C27443b> aSV() {
        AppMethodBeat.m2504i(17481);
        if (this.jsW == null) {
            this.jsW = new LinkedList();
        }
        LinkedList linkedList = this.jsW;
        AppMethodBeat.m2505o(17481);
        return linkedList;
    }

    /* renamed from: a */
    public final void mo35199a(int i, long j, long j2, LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17482);
        if (i == 0) {
            this.jsW = new LinkedList(linkedList);
            AppMethodBeat.m2505o(17482);
            return;
        }
        if (this.jsW == null) {
            this.jsW = new LinkedList();
        } else {
            this.jsW.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C27443b c27443b = (C27443b) it.next();
            if (C38658d.aUr().aUs().mo61498XO().mo15353v(c27443b.jrf, j, j2) > 0) {
                this.jsW.add(c27443b);
            }
        }
        AppMethodBeat.m2505o(17482);
    }

    /* renamed from: F */
    public final void mo35198F(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17483);
        if (linkedList == null || linkedList.size() == 0) {
            this.jsX = new LinkedList();
            AppMethodBeat.m2505o(17483);
            return;
        }
        this.jsX = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.jsX.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
        AppMethodBeat.m2505o(17483);
    }

    private LinkedList<C27443b> aSW() {
        AppMethodBeat.m2504i(17484);
        if (this.jsX == null) {
            this.jsX = new LinkedList();
        }
        LinkedList linkedList = this.jsX;
        AppMethodBeat.m2505o(17484);
        return linkedList;
    }

    /* renamed from: fn */
    public final void mo35204fn(boolean z) {
        AppMethodBeat.m2504i(17485);
        C4990ab.m7417i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", Boolean.valueOf(z));
        this.jvR = z;
        C38658d.aUr().aUu();
        C7305d.post(new C199561(), "BackupPcChooseServer.calculateToChoose");
        AppMethodBeat.m2505o(17485);
    }

    /* renamed from: B */
    public final void mo6658B(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17486);
        String str = "MicroMsg.BackupPcChooseServer";
        String str2 = "onCalcuConvFinish, conv size[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        C4990ab.m7417i(str, str2, objArr);
        this.jsY = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.jvS != null) {
                this.jvS.mo6658B(linkedList);
            }
            if (this.jvR) {
                C42760e aTF = C42759b.aTD().aTF();
                C42760e.jwu = true;
                aTF.jtS.aSI();
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aSu().jqW = -23;
                C42759b.aTD().aTF().mo68236ru(-23);
            }
            AppMethodBeat.m2505o(17486);
            return;
        }
        this.jsV = new LinkedList(linkedList);
        this.jsU = C19955a.m30859E(this.jsV);
        C42759b.aTD();
        SharedPreferences aSz = C38634d.aSz();
        mo35199a(aSz.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), aSz.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), aSz.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), aSU());
        C4990ab.m7417i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(linkedList.size()), Integer.valueOf(aSV().size()));
        if (this.jvR) {
            mo35198F(aSV());
            C42759b.aTD().aTF().mo68230G(C38635g.m65500A(aSW()));
            C42759b.aTD().aTF().mo68233gx((long) aSW().size());
        }
        if (this.jvS != null) {
            this.jvS.mo6658B(aSV());
        }
        AppMethodBeat.m2505o(17486);
    }

    public final void aTC() {
        this.jsV = null;
        this.jsX = null;
        this.jsW = null;
        this.jsY = false;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(17487);
        C4990ab.m7417i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", C5046bo.dpG());
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
                AppMethodBeat.m2505o(17487);
            }
        }
    }
}
