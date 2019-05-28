package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class b {
    public boolean jrv = false;

    /* renamed from: com.tencent.mm.plugin.backup.c.b$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ LinkedList jrA;
        final /* synthetic */ com.tencent.mm.plugin.backup.b.f.b jrB;
        final /* synthetic */ int jrC;
        final /* synthetic */ b jrz;

        public AnonymousClass3(b bVar, LinkedList linkedList, com.tencent.mm.plugin.backup.b.f.b bVar2, int i) {
            this.jrz = bVar;
            this.jrA = linkedList;
            this.jrB = bVar2;
            this.jrC = i;
        }

        public final void run() {
            AppMethodBeat.i(17169);
            if (!(b.this.jrv || this.jrz == null)) {
                this.jrz.a(this.jrA, this.jrB, this.jrC);
            }
            AppMethodBeat.o(17169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.b$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ LinkedList jrA;
        final /* synthetic */ b jrz;

        public AnonymousClass4(b bVar, LinkedList linkedList) {
            this.jrz = bVar;
            this.jrA = linkedList;
        }

        public final void run() {
            AppMethodBeat.i(17170);
            if (!(b.this.jrv || this.jrz == null)) {
                this.jrz.C(this.jrA);
            }
            AppMethodBeat.o(17170);
        }
    }

    public interface a {
        void B(LinkedList<com.tencent.mm.plugin.backup.b.f.b> linkedList);
    }

    public interface b extends a {
        void C(LinkedList<com.tencent.mm.plugin.backup.b.f.b> linkedList);

        void a(LinkedList<com.tencent.mm.plugin.backup.b.f.b> linkedList, com.tencent.mm.plugin.backup.b.f.b bVar, int i);
    }

    public final void cancel() {
        AppMethodBeat.i(17171);
        ab.i("MicroMsg.BackupCalculator", "cancel. stack:%s", bo.dpG());
        this.jrv = true;
        AppMethodBeat.o(17171);
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(17172);
        ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long anU = bo.anU();
        final LinkedList linkedList = new LinkedList();
        Cursor c = d.aUr().aUs().XR().c(t.fkP, g.Ko(), "*");
        if (c.getCount() == 0) {
            if (aVar != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(17167);
                        if (aVar != null) {
                            aVar.B(linkedList);
                        }
                        AppMethodBeat.o(17167);
                    }
                });
            }
            ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            c.close();
            AppMethodBeat.o(17172);
            return;
        }
        c.moveToFirst();
        ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", Integer.valueOf(c.getCount()));
        while (!this.jrv) {
            ak akVar = new ak();
            akVar.d(c);
            if (!bo.isNullOrNil(akVar.field_username)) {
                if (d.aUr().aUs().XO().Rp(akVar.field_username) <= 0) {
                    ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", akVar.field_username);
                } else {
                    aw.ZK();
                    if (ad.Mn(c.XM().aoO(akVar.field_username).field_verifyFlag)) {
                        ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", akVar.field_username, Integer.valueOf(r5));
                    } else {
                        com.tencent.mm.plugin.backup.b.f.b bVar = new com.tencent.mm.plugin.backup.b.f.b();
                        bVar.jrf = akVar.field_username;
                        bVar.jrg = d.aUr().aUs().XO().Rs(akVar.field_username);
                        bVar.jrh = d.aUr().aUs().XO().Rt(akVar.field_username);
                        ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", bVar.jrf, Integer.valueOf(r5), Long.valueOf(bVar.jrg), Long.valueOf(bVar.jrh));
                        linkedList.add(bVar);
                    }
                }
            }
            if (!c.moveToNext()) {
                c.close();
                if (!(this.jrv || aVar == null)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(17168);
                            if (!(b.this.jrv || aVar == null)) {
                                aVar.B(linkedList);
                            }
                            AppMethodBeat.o(17168);
                        }
                    });
                }
                ab.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", Long.valueOf(bo.gb(anU)));
                AppMethodBeat.o(17172);
                return;
            }
        }
        ab.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        c.close();
        AppMethodBeat.o(17172);
    }

    public final boolean a(com.tencent.mm.plugin.backup.b.f.b bVar, String str, long j) {
        AppMethodBeat.i(17173);
        if (bVar == null) {
            AppMethodBeat.o(17173);
            return false;
        }
        Cursor Rj = d.aUr().aUs().XO().Rj(bVar.jrf);
        ab.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", bVar.jrf, Integer.valueOf(Rj.getCount()));
        if (Rj.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!Rj.isAfterLast()) {
                if (this.jrv) {
                    ab.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
                    Rj.close();
                    AppMethodBeat.o(17173);
                    return true;
                }
                bi biVar = new bi();
                biVar.d(Rj);
                try {
                    h.a(biVar, true, str, pLong, null, null, false, false, j);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                Rj.moveToNext();
            }
            bVar.jri = pLong.value;
            bVar.jrj = pLong2.value;
            ab.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", bVar.jrf, Long.valueOf(bVar.jri), Long.valueOf(bVar.jrj));
        }
        Rj.close();
        AppMethodBeat.o(17173);
        return false;
    }
}
