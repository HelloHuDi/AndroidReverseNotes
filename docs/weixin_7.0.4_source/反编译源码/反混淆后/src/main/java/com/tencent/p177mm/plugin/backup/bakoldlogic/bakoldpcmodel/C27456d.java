package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C11116d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C42767b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C45740c;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d */
public final class C27456d implements C32231g {
    private boolean cAY = false;
    private Random eFe = new Random();
    private boolean eVT = false;
    List<String> jzq = new LinkedList();
    HashSet<String> jzr = new HashSet();
    C11116d jzs;
    C1202f jzt;
    boolean jzu = false;
    private long jzv;
    private long jzw;
    int jzx;
    int jzy = 0;
    Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d$1 */
    class C199611 implements Runnable {
        C199611() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17828);
            C27456d c27456d = C27456d.this;
            c27456d.jzy = 0;
            c27456d.jzt = new C274552();
            C19978b.m30879a(5, c27456d.jzt);
            String str = (String) C11124b.aUY().aUZ().mo45267Ry().get(2, null);
            for (String str2 : c27456d.jzq) {
                int i;
                C7617ak aoZ = C11124b.aUY().aUZ().mo45270XR().aoZ(str2);
                if (aoZ != null) {
                    i = aoZ.field_unReadCount;
                } else {
                    i = 0;
                }
                C4990ab.m7417i("MicroMsg.BakPCServer", "backupImp convName:%s, unReadCount:%d", str2, Integer.valueOf(i));
                if (!c27456d.mo45234r(str2, str, i)) {
                    C4990ab.m7416i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
                    AppMethodBeat.m2505o(17828);
                    return;
                }
            }
            c27456d.jzu = true;
            C4990ab.m7416i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
            c27456d.aUI();
            AppMethodBeat.m2505o(17828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d$2 */
    class C274552 implements C1202f {
        C274552() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17829);
            C4990ab.m7417i("MicroMsg.BakPCServer", "onSceneEnd %s, %d, %d", ((C45740c) c1207m).jxp.jCx, Integer.valueOf(i), Integer.valueOf(i2));
            synchronized (C27456d.this.lock) {
                try {
                    C27456d.this.jzr.remove(r14.jxp.jCx);
                    C4990ab.m7417i("MicroMsg.BakPCServer", "onSceneEnd left: size:%d", Integer.valueOf(C27456d.this.jzr.size()));
                    if (C27456d.this.jzr.size() <= 10) {
                        C27456d.this.lock.notifyAll();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(17829);
                    }
                }
            }
            C27456d c27456d = C27456d.this;
            c27456d.jzy++;
            if (C27456d.this.jzy % 100 == 0) {
                c27456d = C27456d.this;
                System.gc();
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                C4990ab.m7417i("MicroMsg.BakPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(c27456d.jzy));
            }
            C27456d.this.aUI();
            AppMethodBeat.m2505o(17829);
        }
    }

    public C27456d() {
        AppMethodBeat.m2504i(17830);
        AppMethodBeat.m2505o(17830);
    }

    public final void pause() {
        AppMethodBeat.m2504i(17831);
        C4990ab.m7416i("MicroMsg.BakPCServer", "pause");
        this.cAY = true;
        AppMethodBeat.m2505o(17831);
    }

    public final void resume() {
        AppMethodBeat.m2504i(17832);
        C4990ab.m7416i("MicroMsg.BakPCServer", "resume");
        this.cAY = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17832);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(17833);
        C4990ab.m7416i("MicroMsg.BakPCServer", "cancel");
        this.eVT = true;
        C19978b.m30886b(5, this.jzt);
        this.jzs = null;
        this.jzu = false;
        this.jzx = 0;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17833);
            }
        }
    }

    /* JADX WARNING: Missing block: B:43:?, code skipped:
            r7 = new com.tencent.p177mm.storage.C7620bi();
            r7.mo8995d(r13);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.BackupPackMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", r7.field_talker, java.lang.Integer.valueOf(r7.getType()));
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
            r2 = new com.tencent.p177mm.protocal.protobuf.C40522gu();
            r2.ptF = r7.field_msgSvrId;
     */
    /* JADX WARNING: Missing block: B:74:0x0140, code skipped:
            if (r7.field_isSend != 1) goto L_0x01d1;
     */
    /* JADX WARNING: Missing block: B:75:0x0142, code skipped:
            r2.vEB = new com.tencent.p177mm.protocal.protobuf.bts().alV(r20);
            r2.vEC = new com.tencent.p177mm.protocal.protobuf.bts().alV(r7.field_talker);
            r5 = 2;
            r6 = r2;
     */
    /* JADX WARNING: Missing block: B:76:0x015e, code skipped:
            r6.vIY = r5;
            r2.vJd = new com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t();
            r2.vJe = 0;
            r2.vJf = 0;
            r2.vEG = "";
            r2.jCt = com.tencent.p177mm.pluginsdk.model.app.C4733l.m7082Kx(r7.getType());
            r2.vIZ = (int) (r7.field_createTime / 1000);
            r2.vJh = r7.field_createTime;
            r2.vJg = (int) r7.field_msgSeq;
            r2.vJi = r7.field_flag;
            r5 = new com.tencent.p177mm.protocal.protobuf.bts();
            r5.alV(com.tencent.p177mm.sdk.platformtools.C5046bo.m7532bc(r7.field_content, ""));
            r2.vED = r5;
            r5 = com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C36747d.aUA().mo58597rD(com.tencent.p177mm.pluginsdk.model.app.C4733l.m7082Kx(r7.getType()));
     */
    /* JADX WARNING: Missing block: B:77:0x01b5, code skipped:
            if (r5 != null) goto L_0x01f5;
     */
    /* JADX WARNING: Missing block: B:78:0x01b7, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.BackupPackMsgLogic", "packedMsg unknow type[%d]", java.lang.Integer.valueOf(r7.getType()));
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:79:0x01d1, code skipped:
            r2.vEB = new com.tencent.p177mm.protocal.protobuf.bts().alV(r7.field_talker);
            r2.vEC = new com.tencent.p177mm.protocal.protobuf.bts().alV(r20);
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
            r5 = r5.mo22811a(r2, r7, r14);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.BakPCServer", r2, "", new java.lang.Object[0]);
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7414f("MicroMsg.BakPCServer", "backupChatMsg %s".concat(java.lang.String.valueOf(r2)));
            r2 = null;
            r11 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: r */
    public final boolean mo45234r(String str, String str2, int i) {
        AppMethodBeat.m2504i(17834);
        PLong pLong = new PLong();
        Cursor Rj = C11124b.aUY().aUZ().mo45269XO().mo15256Rj(str);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        try {
            LinkedList linkedList3;
            int i2;
            String a;
            C45740c c45740c;
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
                                C4990ab.printErrStackTrace("MicroMsg.BakPCServer", e2, "", new Object[0]);
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(17834);
                                throw th;
                            }
                        }
                        if (this.eVT) {
                            C4990ab.m7416i("MicroMsg.BakPCServer", "backupImp cancel");
                            Rj.close();
                            AppMethodBeat.m2505o(17834);
                            return false;
                        }
                    }
                }
                linkedList = linkedList3;
            }
            if (pLong.value > 0) {
                a = C27456d.m43569a(this.eFe);
                c45740c = new C45740c(a, 1, linkedList, "", this, C41257a.aUB().jqU);
                synchronized (this.lock) {
                    c45740c.aUc();
                    this.jzr.add(a);
                    C4990ab.m7417i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", Integer.valueOf(this.jzr.size()));
                }
                pLong.value = 0;
                LinkedList linkedList4 = new LinkedList();
            }
            Rj.close();
            AppMethodBeat.m2505o(17834);
            return true;
            if (r2 != null) {
                linkedList3.add(r2);
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                C19993u c19993u = (C19993u) it.next();
                c45740c = new C45740c(c19993u.cHr, 2, null, c19993u.path, this, C41257a.aUB().jqU);
                synchronized (this.lock) {
                    c45740c.aUc();
                    this.jzr.add(c19993u.cHr);
                    C4990ab.m7417i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", Integer.valueOf(this.jzr.size()));
                }
            }
            linkedList2.clear();
            if (pLong.value > 262144) {
                C4990ab.m7410d("MicroMsg.BakPCServer", "limitSize " + pLong.value);
                a = C27456d.m43569a(this.eFe);
                linkedList = linkedList3;
                c45740c = new C45740c(a, 1, linkedList, "", this, C41257a.aUB().jqU);
                synchronized (this.lock) {
                    c45740c.aUc();
                    this.jzr.add(a);
                    C4990ab.m7417i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", Integer.valueOf(this.jzr.size()));
                }
                linkedList3 = new LinkedList();
                pLong.value = 0;
            }
            Rj.moveToNext();
            i2 = r11;
        } catch (Throwable th2) {
            Rj.close();
            AppMethodBeat.m2505o(17834);
            throw th2;
        }
    }

    /* Access modifiers changed, original: final */
    public final void aUI() {
        AppMethodBeat.m2504i(17835);
        if (!this.jzu || this.eVT) {
            AppMethodBeat.m2505o(17835);
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.jzr.isEmpty()) {
                    C41257a.aUB().aUC().jzK = 4;
                    C41257a.aUB().aUC().jzL = 3;
                    C19978b.m30886b(5, this.jzt);
                    new C42767b(5).aUc();
                    C38643c aUD = C41257a.aUB().aUD();
                    aUD.jzm++;
                    if (this.jzs != null) {
                        this.jzs.aUP();
                    } else {
                        C4990ab.m7416i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    C4990ab.m7416i("MicroMsg.BakPCServer", "send backup finish cmd");
                }
            } finally {
                AppMethodBeat.m2505o(17835);
            }
        }
    }

    /* renamed from: a */
    private static String m43569a(Random random) {
        AppMethodBeat.m2504i(17836);
        String x = C1178g.m2591x((C5046bo.m7588yz() + random.nextDouble()).getBytes());
        AppMethodBeat.m2505o(17836);
        return x;
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(17837);
        this.jzw += (long) i;
        int i3 = this.jzv == 0 ? 0 : (int) ((this.jzw * 100) / this.jzv);
        if (i3 > this.jzx) {
            this.jzx = i3;
            C45740c.setProgress(this.jzx);
            if (!(this.cAY || this.eVT || this.jzs == null || this.jzx < 0 || this.jzx > 100)) {
                this.jzs.mo22819rI(this.jzx);
            }
        }
        AppMethodBeat.m2505o(17837);
    }
}
