package com.tencent.p177mm.plugin.backup.p345d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p344c.C33685b;
import com.tencent.p177mm.plugin.backup.p344c.C33685b.C111343;
import com.tencent.p177mm.plugin.backup.p344c.C33685b.C336834;
import com.tencent.p177mm.plugin.backup.p344c.C33685b.C33686b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.d.a */
public final class C45743a implements C33686b {
    public C33685b jsS;
    public C33686b jsT;
    public long jsU;
    public LinkedList<C27443b> jsV = null;
    public LinkedList<C27443b> jsW = null;
    public LinkedList<C27443b> jsX = null;
    public boolean jsY = false;
    public boolean jsZ = false;
    private Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.d.a$2 */
    public class C111442 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(17222);
            C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "start calculateChooseConvSize");
            C45743a.this.jsS = new C33685b();
            C33685b c33685b = C45743a.this.jsS;
            LinkedList aSW = C45743a.this.aSW();
            C45743a c45743a = C45743a.this;
            long j = C41258b.aSZ().aSu().jrc;
            long anU = C5046bo.anU();
            String str = (String) C38658d.aUr().aUs().mo61496Ry().get(2, null);
            int i = 0;
            Iterator it = aSW.iterator();
            while (it.hasNext()) {
                C27443b c27443b = (C27443b) it.next();
                if (c27443b.jri < 0) {
                    if (c33685b.mo54238a(c27443b, str, j)) {
                        break;
                    }
                    i++;
                    if (!(c33685b.jrv || c45743a == null)) {
                        C5004al.m7441d(new C111343(c45743a, aSW, c27443b.aSE(), i));
                    }
                } else {
                    i++;
                }
            }
            C4990ab.m7417i("MicroMsg.BackupCalculator", "calculChooseConvSize all, userSize:%d", Integer.valueOf(aSW.size()));
            if (!(c33685b.jrv || c45743a == null)) {
                C5004al.m7441d(new C336834(c45743a, aSW));
            }
            C4990ab.m7411d("MicroMsg.BackupCalculator", "calculChooseConvSize loading time[%d]", Long.valueOf(C5046bo.m7566gb(anU)));
            AppMethodBeat.m2505o(17222);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.a$1 */
    public class C274841 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(17221);
            if (C45743a.this.jsS != null) {
                C45743a.this.jsS.cancel();
            }
            C45743a.this.jsS = new C33685b();
            if (C45743a.this.aSU() == null || C45743a.this.aSU().size() == 0) {
                C4990ab.m7412e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
                C45743a.this.jsS.mo54237a(C45743a.this);
            }
            AppMethodBeat.m2505o(17221);
        }
    }

    public C45743a() {
        AppMethodBeat.m2504i(17223);
        AppMethodBeat.m2505o(17223);
    }

    public final LinkedList<C27443b> aSU() {
        AppMethodBeat.m2504i(17224);
        if (this.jsV == null) {
            this.jsV = new LinkedList();
        }
        LinkedList linkedList = this.jsV;
        AppMethodBeat.m2505o(17224);
        return linkedList;
    }

    /* renamed from: E */
    private static long m84535E(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17225);
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
        AppMethodBeat.m2505o(17225);
        return j;
    }

    public final LinkedList<C27443b> aSV() {
        AppMethodBeat.m2504i(17226);
        if (this.jsW == null) {
            this.jsW = new LinkedList();
        }
        LinkedList linkedList = this.jsW;
        AppMethodBeat.m2505o(17226);
        return linkedList;
    }

    /* renamed from: a */
    public final void mo73540a(int i, long j, long j2, LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17227);
        if (i == 0) {
            this.jsW = new LinkedList(linkedList);
            AppMethodBeat.m2505o(17227);
            return;
        }
        this.jsW = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C27443b c27443b = (C27443b) it.next();
            if (C38658d.aUr().aUs().mo61498XO().mo15353v(c27443b.jrf, j, j2) > 0) {
                this.jsW.add(c27443b);
            }
        }
        AppMethodBeat.m2505o(17227);
    }

    public final LinkedList<C27443b> aSW() {
        AppMethodBeat.m2504i(17228);
        if (this.jsX == null) {
            this.jsX = new LinkedList();
        }
        LinkedList linkedList = this.jsX;
        AppMethodBeat.m2505o(17228);
        return linkedList;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(17229);
        synchronized (this.lock) {
            try {
                if (this.jsS != null) {
                    this.jsS.cancel();
                    this.jsS = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17229);
            }
        }
    }

    public final void aSX() {
        AppMethodBeat.m2504i(17230);
        C41258b.aSZ();
        SharedPreferences aSz = C38634d.aSz();
        mo73540a(aSz.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), aSz.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), aSz.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), aSU());
        AppMethodBeat.m2505o(17230);
    }

    /* renamed from: B */
    public final void mo6658B(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17231);
        C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.jsY = true;
        this.jsV = new LinkedList(linkedList);
        this.jsU = C45743a.m84535E(this.jsV);
        aSX();
        C4990ab.m7417i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(aSU().size()), Integer.valueOf(aSV().size()));
        if (this.jsT != null) {
            this.jsT.mo6658B(aSV());
        }
        AppMethodBeat.m2505o(17231);
    }

    /* renamed from: a */
    public final void mo6660a(LinkedList<C27443b> linkedList, C27443b c27443b, int i) {
        AppMethodBeat.m2504i(17232);
        C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.jsV = linkedList;
        if (this.jsW != null) {
            Iterator it = this.jsW.iterator();
            while (it.hasNext()) {
                C27443b c27443b2 = (C27443b) it.next();
                if (c27443b2.jrf.equals(c27443b.jrf)) {
                    c27443b2.jri = c27443b.jri;
                    c27443b2.jrj = c27443b.jrj;
                    break;
                }
            }
        }
        if (C41258b.aSZ().aTb().jtV) {
            C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            C41258b.aSZ().aSu().mo68222O(13, i, linkedList.size());
            C41258b.aSZ().aTb().mo6651rj(13);
        }
        if (this.jsT != null) {
            this.jsT.mo6660a(aSV(), c27443b, i);
        }
        AppMethodBeat.m2505o(17232);
    }

    /* renamed from: C */
    public final void mo6659C(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17233);
        C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.jsZ = true;
        this.jsV = (LinkedList) linkedList.clone();
        aSX();
        if (C41258b.aSZ().aTb().jtV) {
            C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            C41258b.aSZ().aTb().aTp();
            AppMethodBeat.m2505o(17233);
            return;
        }
        if (this.jsT != null) {
            this.jsT.mo6659C(linkedList);
        }
        AppMethodBeat.m2505o(17233);
    }

    public final long aSY() {
        long j = 0;
        AppMethodBeat.m2504i(17234);
        if (aSW() == null) {
            AppMethodBeat.m2505o(17234);
            return 0;
        }
        Iterator it = aSW().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = ((C27443b) it.next()).jri + j2;
            } else {
                AppMethodBeat.m2505o(17234);
                return j2;
            }
        }
    }
}
