package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.bakoldlogic.c.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d implements g {
    private boolean cAY = false;
    private Random eFe = new Random();
    private boolean eVT = false;
    List<String> jzq = new LinkedList();
    HashSet<String> jzr = new HashSet();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d jzs;
    f jzt;
    boolean jzu = false;
    private long jzv;
    private long jzw;
    int jzx;
    int jzy = 0;
    Object lock = new Object();

    public d() {
        AppMethodBeat.i(17830);
        AppMethodBeat.o(17830);
    }

    public final void pause() {
        AppMethodBeat.i(17831);
        ab.i("MicroMsg.BakPCServer", "pause");
        this.cAY = true;
        AppMethodBeat.o(17831);
    }

    public final void resume() {
        AppMethodBeat.i(17832);
        ab.i("MicroMsg.BakPCServer", "resume");
        this.cAY = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17832);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.i(17833);
        ab.i("MicroMsg.BakPCServer", "cancel");
        this.eVT = true;
        b.b(5, this.jzt);
        this.jzs = null;
        this.jzu = false;
        this.jzx = 0;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17833);
            }
        }
    }

    /* JADX WARNING: Missing block: B:43:?, code skipped:
            r7 = new com.tencent.mm.storage.bi();
            r7.d(r13);
     */
    /* JADX WARNING: Missing block: B:45:0x00a4, code skipped:
            if (r4 <= 0) goto L_0x0130;
     */
    /* JADX WARNING: Missing block: B:46:0x00a6, code skipped:
            r5 = 1;
     */
    /* JADX WARNING: Missing block: B:49:0x00ae, code skipped:
            if (r7.field_msgSvrId != 0) goto L_0x0134;
     */
    /* JADX WARNING: Missing block: B:50:0x00b0, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BackupPackMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", r7.field_talker, java.lang.Integer.valueOf(r7.getType()));
     */
    /* JADX WARNING: Missing block: B:51:0x00cc, code skipped:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:52:0x00cd, code skipped:
            r11 = r4 - 1;
     */
    /* JADX WARNING: Missing block: B:71:0x0130, code skipped:
            r5 = null;
     */
    /* JADX WARNING: Missing block: B:73:?, code skipped:
            r2 = new com.tencent.mm.protocal.protobuf.gu();
            r2.ptF = r7.field_msgSvrId;
     */
    /* JADX WARNING: Missing block: B:74:0x0140, code skipped:
            if (r7.field_isSend != 1) goto L_0x01d1;
     */
    /* JADX WARNING: Missing block: B:75:0x0142, code skipped:
            r2.vEB = new com.tencent.mm.protocal.protobuf.bts().alV(r20);
            r2.vEC = new com.tencent.mm.protocal.protobuf.bts().alV(r7.field_talker);
            r5 = 2;
            r6 = r2;
     */
    /* JADX WARNING: Missing block: B:76:0x015e, code skipped:
            r6.vIY = r5;
            r2.vJd = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t();
            r2.vJe = 0;
            r2.vJf = 0;
            r2.vEG = "";
            r2.jCt = com.tencent.mm.pluginsdk.model.app.l.Kx(r7.getType());
            r2.vIZ = (int) (r7.field_createTime / 1000);
            r2.vJh = r7.field_createTime;
            r2.vJg = (int) r7.field_msgSeq;
            r2.vJi = r7.field_flag;
            r5 = new com.tencent.mm.protocal.protobuf.bts();
            r5.alV(com.tencent.mm.sdk.platformtools.bo.bc(r7.field_content, ""));
            r2.vED = r5;
            r5 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.aUA().rD(com.tencent.mm.pluginsdk.model.app.l.Kx(r7.getType()));
     */
    /* JADX WARNING: Missing block: B:77:0x01b5, code skipped:
            if (r5 != null) goto L_0x01f5;
     */
    /* JADX WARNING: Missing block: B:78:0x01b7, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BackupPackMsgLogic", "packedMsg unknow type[%d]", java.lang.Integer.valueOf(r7.getType()));
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:79:0x01d1, code skipped:
            r2.vEB = new com.tencent.mm.protocal.protobuf.bts().alV(r7.field_talker);
            r2.vEC = new com.tencent.mm.protocal.protobuf.bts().alV(r20);
     */
    /* JADX WARNING: Missing block: B:80:0x01eb, code skipped:
            if (r5 == null) goto L_0x01f1;
     */
    /* JADX WARNING: Missing block: B:81:0x01ed, code skipped:
            r5 = 3;
            r6 = r2;
     */
    /* JADX WARNING: Missing block: B:82:0x01f1, code skipped:
            r5 = 4;
            r6 = r2;
     */
    /* JADX WARNING: Missing block: B:83:0x01f5, code skipped:
            r5 = r5.a(r2, r7, r14);
     */
    /* JADX WARNING: Missing block: B:84:0x01f9, code skipped:
            if (r5 >= 0) goto L_0x01fe;
     */
    /* JADX WARNING: Missing block: B:85:0x01fb, code skipped:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:86:0x01fe, code skipped:
            r12.value += (long) r5;
            r12.value += 60;
     */
    /* JADX WARNING: Missing block: B:87:0x020d, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:89:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPCServer", r2, "", new java.lang.Object[0]);
            com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.BakPCServer", "backupChatMsg %s".concat(java.lang.String.valueOf(r2)));
            r2 = null;
            r11 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean r(String str, String str2, int i) {
        AppMethodBeat.i(17834);
        PLong pLong = new PLong();
        Cursor Rj = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().XO().Rj(str);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        try {
            LinkedList linkedList3;
            int i2;
            String a;
            c cVar;
            if (Rj.moveToFirst()) {
                linkedList3 = linkedList;
                i2 = i;
                while (!Rj.isAfterLast()) {
                    synchronized (this.lock) {
                        if (this.jzr.size() > 10) {
                            try {
                                this.lock.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                        if (this.cAY && !this.eVT) {
                            try {
                                this.lock.wait();
                            } catch (InterruptedException e2) {
                                ab.printErrStackTrace("MicroMsg.BakPCServer", e2, "", new Object[0]);
                            } catch (Throwable th) {
                                AppMethodBeat.o(17834);
                                throw th;
                            }
                        }
                        if (this.eVT) {
                            ab.i("MicroMsg.BakPCServer", "backupImp cancel");
                            Rj.close();
                            AppMethodBeat.o(17834);
                            return false;
                        }
                    }
                }
                linkedList = linkedList3;
            }
            if (pLong.value > 0) {
                a = a(this.eFe);
                cVar = new c(a, 1, linkedList, "", this, a.aUB().jqU);
                synchronized (this.lock) {
                    cVar.aUc();
                    this.jzr.add(a);
                    ab.i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", Integer.valueOf(this.jzr.size()));
                }
                pLong.value = 0;
                LinkedList linkedList4 = new LinkedList();
            }
            Rj.close();
            AppMethodBeat.o(17834);
            return true;
            if (r2 != null) {
                linkedList3.add(r2);
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                cVar = new c(uVar.cHr, 2, null, uVar.path, this, a.aUB().jqU);
                synchronized (this.lock) {
                    cVar.aUc();
                    this.jzr.add(uVar.cHr);
                    ab.i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", Integer.valueOf(this.jzr.size()));
                }
            }
            linkedList2.clear();
            if (pLong.value > 262144) {
                ab.d("MicroMsg.BakPCServer", "limitSize " + pLong.value);
                a = a(this.eFe);
                linkedList = linkedList3;
                cVar = new c(a, 1, linkedList, "", this, a.aUB().jqU);
                synchronized (this.lock) {
                    cVar.aUc();
                    this.jzr.add(a);
                    ab.i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", Integer.valueOf(this.jzr.size()));
                }
                linkedList3 = new LinkedList();
                pLong.value = 0;
            }
            Rj.moveToNext();
            i2 = r11;
        } catch (Throwable th2) {
            Rj.close();
            AppMethodBeat.o(17834);
            throw th2;
        }
    }

    /* Access modifiers changed, original: final */
    public final void aUI() {
        AppMethodBeat.i(17835);
        if (!this.jzu || this.eVT) {
            AppMethodBeat.o(17835);
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.jzr.isEmpty()) {
                    a.aUB().aUC().jzK = 4;
                    a.aUB().aUC().jzL = 3;
                    b.b(5, this.jzt);
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).aUc();
                    c aUD = a.aUB().aUD();
                    aUD.jzm++;
                    if (this.jzs != null) {
                        this.jzs.aUP();
                    } else {
                        ab.i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    ab.i("MicroMsg.BakPCServer", "send backup finish cmd");
                }
            } finally {
                AppMethodBeat.o(17835);
            }
        }
    }

    private static String a(Random random) {
        AppMethodBeat.i(17836);
        String x = com.tencent.mm.a.g.x((bo.yz() + random.nextDouble()).getBytes());
        AppMethodBeat.o(17836);
        return x;
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(17837);
        this.jzw += (long) i;
        int i3 = this.jzv == 0 ? 0 : (int) ((this.jzw * 100) / this.jzv);
        if (i3 > this.jzx) {
            this.jzx = i3;
            c.setProgress(this.jzx);
            if (!(this.cAY || this.eVT || this.jzs == null || this.jzx < 0 || this.jzx > 100)) {
                this.jzs.rI(this.jzx);
            }
        }
        AppMethodBeat.o(17837);
    }
}
