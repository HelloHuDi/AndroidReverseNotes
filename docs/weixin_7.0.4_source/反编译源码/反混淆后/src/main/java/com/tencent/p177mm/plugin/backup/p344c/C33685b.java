package com.tencent.p177mm.plugin.backup.p344c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p346f.C45745h;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.c.b */
public final class C33685b {
    public boolean jrv = false;

    /* renamed from: com.tencent.mm.plugin.backup.c.b$3 */
    public class C111343 implements Runnable {
        final /* synthetic */ LinkedList jrA;
        final /* synthetic */ C27443b jrB;
        final /* synthetic */ int jrC;
        final /* synthetic */ C33686b jrz;

        public C111343(C33686b c33686b, LinkedList linkedList, C27443b c27443b, int i) {
            this.jrz = c33686b;
            this.jrA = linkedList;
            this.jrB = c27443b;
            this.jrC = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(17169);
            if (!(C33685b.this.jrv || this.jrz == null)) {
                this.jrz.mo6660a(this.jrA, this.jrB, this.jrC);
            }
            AppMethodBeat.m2505o(17169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.b$4 */
    public class C336834 implements Runnable {
        final /* synthetic */ LinkedList jrA;
        final /* synthetic */ C33686b jrz;

        public C336834(C33686b c33686b, LinkedList linkedList) {
            this.jrz = c33686b;
            this.jrA = linkedList;
        }

        public final void run() {
            AppMethodBeat.m2504i(17170);
            if (!(C33685b.this.jrv || this.jrz == null)) {
                this.jrz.mo6659C(this.jrA);
            }
            AppMethodBeat.m2505o(17170);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.b$a */
    public interface C33684a {
        /* renamed from: B */
        void mo6658B(LinkedList<C27443b> linkedList);
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.b$b */
    public interface C33686b extends C33684a {
        /* renamed from: C */
        void mo6659C(LinkedList<C27443b> linkedList);

        /* renamed from: a */
        void mo6660a(LinkedList<C27443b> linkedList, C27443b c27443b, int i);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(17171);
        C4990ab.m7417i("MicroMsg.BackupCalculator", "cancel. stack:%s", C5046bo.dpG());
        this.jrv = true;
        AppMethodBeat.m2505o(17171);
    }

    /* renamed from: a */
    public final void mo54237a(final C33684a c33684a) {
        AppMethodBeat.m2504i(17172);
        C4990ab.m7416i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long anU = C5046bo.anU();
        final LinkedList linkedList = new LinkedList();
        Cursor c = C38658d.aUr().aUs().mo61499XR().mo15804c(C1855t.fkP, C38635g.m65509Ko(), "*");
        if (c.getCount() == 0) {
            if (c33684a != null) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(17167);
                        if (c33684a != null) {
                            c33684a.mo6658B(linkedList);
                        }
                        AppMethodBeat.m2505o(17167);
                    }
                });
            }
            C4990ab.m7416i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            c.close();
            AppMethodBeat.m2505o(17172);
            return;
        }
        c.moveToFirst();
        C4990ab.m7417i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", Integer.valueOf(c.getCount()));
        while (!this.jrv) {
            C7617ak c7617ak = new C7617ak();
            c7617ak.mo8995d(c);
            if (!C5046bo.isNullOrNil(c7617ak.field_username)) {
                if (C38658d.aUr().aUs().mo61498XO().mo15262Rp(c7617ak.field_username) <= 0) {
                    C4990ab.m7417i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", c7617ak.field_username);
                } else {
                    C9638aw.m17190ZK();
                    if (C7616ad.m13547Mn(C18628c.m29078XM().aoO(c7617ak.field_username).field_verifyFlag)) {
                        C4990ab.m7417i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", c7617ak.field_username, Integer.valueOf(r5));
                    } else {
                        C27443b c27443b = new C27443b();
                        c27443b.jrf = c7617ak.field_username;
                        c27443b.jrg = C38658d.aUr().aUs().mo61498XO().mo15265Rs(c7617ak.field_username);
                        c27443b.jrh = C38658d.aUr().aUs().mo61498XO().mo15266Rt(c7617ak.field_username);
                        C4990ab.m7417i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", c27443b.jrf, Integer.valueOf(r5), Long.valueOf(c27443b.jrg), Long.valueOf(c27443b.jrh));
                        linkedList.add(c27443b);
                    }
                }
            }
            if (!c.moveToNext()) {
                c.close();
                if (!(this.jrv || c33684a == null)) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(17168);
                            if (!(C33685b.this.jrv || c33684a == null)) {
                                c33684a.mo6658B(linkedList);
                            }
                            AppMethodBeat.m2505o(17168);
                        }
                    });
                }
                C4990ab.m7417i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", Long.valueOf(C5046bo.m7566gb(anU)));
                AppMethodBeat.m2505o(17172);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        c.close();
        AppMethodBeat.m2505o(17172);
    }

    /* renamed from: a */
    public final boolean mo54238a(C27443b c27443b, String str, long j) {
        AppMethodBeat.m2504i(17173);
        if (c27443b == null) {
            AppMethodBeat.m2505o(17173);
            return false;
        }
        Cursor Rj = C38658d.aUr().aUs().mo61498XO().mo15256Rj(c27443b.jrf);
        C4990ab.m7417i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", c27443b.jrf, Integer.valueOf(Rj.getCount()));
        if (Rj.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!Rj.isAfterLast()) {
                if (this.jrv) {
                    C4990ab.m7416i("MicroMsg.BackupCalculator", "calConversation cancel, return");
                    Rj.close();
                    AppMethodBeat.m2505o(17173);
                    return true;
                }
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(Rj);
                try {
                    C45745h.m84542a(c7620bi, true, str, pLong, null, null, false, false, j);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                Rj.moveToNext();
            }
            c27443b.jri = pLong.value;
            c27443b.jrj = pLong2.value;
            C4990ab.m7417i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", c27443b.jrf, Long.valueOf(c27443b.jri), Long.valueOf(c27443b.jrj));
        }
        Rj.close();
        AppMethodBeat.m2505o(17173);
        return false;
    }
}
