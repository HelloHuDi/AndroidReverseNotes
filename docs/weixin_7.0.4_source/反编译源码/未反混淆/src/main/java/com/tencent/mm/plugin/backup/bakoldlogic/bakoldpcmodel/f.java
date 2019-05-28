package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.c.e;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f implements g {
    boolean cAY = false;
    boolean eVT = false;
    boolean jsp = false;
    List<t> jzS;
    List<t> jzT;
    int jzU = 0;
    public boolean jzV = false;
    long jzW;
    long jzX;
    int jzY;
    HashSet<String> jzr = new HashSet();
    d jzs;
    private com.tencent.mm.ai.f jzt;
    boolean jzu = false;
    int jzy = 0;
    Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int jAb;

        AnonymousClass5(int i) {
            this.jAb = i;
        }

        public final void run() {
            Exception e;
            AppMethodBeat.i(17867);
            e.reset();
            e.aST();
            c cVar = new c();
            cVar.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (t tVar : f.this.jzS) {
                int a;
                try {
                    a = f.this.a(a.aUy() + "backupItem/" + a.Fb(tVar.ID) + tVar.ID, hashMap, cVar, hashSet);
                    if (a < 0) {
                        cVar.end();
                        ab.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        AppMethodBeat.o(17867);
                        return;
                    }
                    a += i;
                    try {
                        f.this.dB(a, this.jAb);
                        ab.i("MicroMsg.RecoverPCServer", "recover has done: %d", Integer.valueOf(a));
                        i = a;
                    } catch (Exception e2) {
                        e = e2;
                        ab.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        ab.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Exception e3) {
                    e = e3;
                    a = i;
                    ab.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    ab.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            com.tencent.mm.plugin.backup.bakoldlogic.d.d.k(hashMap);
            cVar.end();
            f.this.dB(100, 100);
            ab.i("MicroMsg.RecoverPCServer", "build temDB finish!");
            ab.dot();
            b aUY = b.aUY();
            aUY.c(new com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass2(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17866);
                    ab.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
                    ab.dot();
                    a.aUB().aUC().jzL = 7;
                    f.this.jzU = 0;
                    if (f.this.jzs != null) {
                        f.this.jzs.aSt();
                    } else {
                        ab.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                    }
                    e.aUN();
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(8).aUc();
                    ab.i("MicroMsg.RecoverPCServer", "recover ok");
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.TRUE);
                    c aUD = a.aUB().aUD();
                    aUD.jzo++;
                    a.aUB().aUC().jzK = 7;
                    f.this.cancel();
                    com.tencent.mm.plugin.backup.bakoldlogic.d.a aVa = b.aUY().aVa();
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator it = aVa.jyk.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.backup.bakoldlogic.d.a.a aVar = (com.tencent.mm.plugin.backup.bakoldlogic.d.a.a) it.next();
                        if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                            stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
                        } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                            stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
                        }
                    }
                    ab.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + stringBuffer.toString());
                    AppMethodBeat.o(17866);
                }
            }), 10);
            AppMethodBeat.o(17867);
        }
    }

    public f() {
        AppMethodBeat.i(17868);
        AppMethodBeat.o(17868);
    }

    public final void pause() {
        AppMethodBeat.i(17869);
        ab.i("MicroMsg.RecoverPCServer", "pause");
        this.cAY = true;
        AppMethodBeat.o(17869);
    }

    public final void resume() {
        AppMethodBeat.i(17870);
        ab.i("MicroMsg.RecoverPCServer", "resume");
        this.cAY = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17870);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.i(17871);
        ab.i("MicroMsg.RecoverPCServer", "cancel");
        this.eVT = true;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17871);
            }
        }
        com.tencent.mm.plugin.backup.g.b.b(7, this.jzt);
        this.jzs = null;
        this.jzV = false;
        this.jsp = false;
        this.jzU = 0;
        this.jzY = 0;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:20:0x0062, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(17872);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aUS() {
        AppMethodBeat.i(17872);
        if (!this.jzu || this.eVT) {
            AppMethodBeat.o(17872);
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.jzr.isEmpty()) {
                    if (this.eVT) {
                    } else {
                        this.jzV = true;
                        this.jzY = 0;
                        a.aUB().aUC().jzK = 6;
                        a.aUB().aUC().jzL = 5;
                        if (this.jzs != null) {
                            this.jzs.aUP();
                        } else {
                            ab.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                        }
                        com.tencent.mm.plugin.backup.g.b.b(7, this.jzt);
                        dB(0, 0);
                        e.aUN();
                        ab.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
                    }
                }
            } finally {
                AppMethodBeat.o(17872);
            }
        }
    }

    public static int aT(List<t> list) {
        AppMethodBeat.i(17873);
        int i = 0;
        for (t tVar : list) {
            try {
                i = ((gv) new gv().parseFrom(com.tencent.mm.a.e.f(a.aUy() + "backupItem/" + a.Fb(tVar.ID) + tVar.ID, 0, -1))).jBw.size() + i;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(17873);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void dB(int i, int i2) {
        AppMethodBeat.i(17874);
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if (!(i == 0 && i2 == 0) && i3 <= this.jzU) {
            AppMethodBeat.o(17874);
            return;
        }
        this.jzU = i3;
        if (!(this.cAY || this.eVT || this.jzs == null || this.jzU < 0 || this.jzU > 100)) {
            this.jzs.rJ(this.jzU);
        }
        com.tencent.mm.plugin.backup.i.ab abVar = new com.tencent.mm.plugin.backup.i.ab();
        abVar.jBh = 13;
        abVar.jCI = 0;
        abVar.jCJ = this.jzU;
        try {
            ab.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", Integer.valueOf(i3));
            com.tencent.mm.plugin.backup.g.b.K(abVar.toByteArray(), 3);
            AppMethodBeat.o(17874);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            ab.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            AppMethodBeat.o(17874);
        }
    }

    /* Access modifiers changed, original: final */
    public final int a(String str, HashMap<String, Integer> hashMap, c cVar, HashSet<String> hashSet) {
        AppMethodBeat.i(17875);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] f = com.tencent.mm.a.e.f(str, 0, -1);
        String str2;
        try {
            gv gvVar = (gv) new gv().parseFrom(f);
            Iterator it = gvVar.jBw.iterator();
            while (it.hasNext()) {
                gu guVar = (gu) it.next();
                if (this.cAY && !this.eVT) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e) {
                            ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.o(17875);
                        }
                    }
                }
                if (this.eVT) {
                    ab.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    AppMethodBeat.o(17875);
                    return -1;
                }
                try {
                    String str3 = (String) b.aUY().aUZ().Ry().get(2, null);
                    h XO = b.aUY().aUZ().XO();
                    str2 = guVar.vEB.wVI;
                    String str4 = guVar.vEC.wVI;
                    String str5;
                    if (bo.isNullOrNil(str2) || bo.isNullOrNil(str4)) {
                        str3 = "MicroMsg.BackupPackMsgLogic";
                        str5 = "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]";
                        Object[] objArr = new Object[2];
                        if (str2 == null) {
                            str2 = BuildConfig.COMMAND;
                        }
                        objArr[0] = str2;
                        if (str4 == null) {
                            str4 = BuildConfig.COMMAND;
                        }
                        objArr[1] = str4;
                        ab.w(str3, str5, objArr);
                    } else {
                        ab.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", Integer.valueOf(guVar.jCt), str2, str4);
                        com.tencent.mm.plugin.backup.bakoldlogic.d.c aUZ = b.aUY().aUZ();
                        if (aUZ.uin == 0) {
                            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                            AppMethodBeat.o(17875);
                            throw bVar;
                        }
                        Object obj;
                        long j;
                        k kVar = aUZ.jys;
                        bd XM = b.aUY().aUZ().XM();
                        Object obj2 = (kVar.has(str2) || str3.equals(str2)) ? 1 : null;
                        if (obj2 != null) {
                            obj = str4;
                        } else {
                            str5 = str2;
                        }
                        if (guVar.vJh != 0) {
                            j = guVar.vJh;
                        } else {
                            j = ((long) guVar.vIZ) * 1000;
                        }
                        hashSet.add(obj);
                        List Ko = a.Ko();
                        if (Ko.contains(str2) || Ko.contains(str4)) {
                            ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str2 + " " + str4);
                        } else {
                            if (guVar.ptF == 0 && guVar.ptD != 0) {
                                guVar.ptF = (long) guVar.ptD;
                            }
                            if (guVar.ptF != 0) {
                                if (!str3.equals(str2)) {
                                    str4 = str2;
                                }
                                bi Q = XO.Q(str4, guVar.ptF);
                                if (Q.field_msgId != 0) {
                                    ab.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
                                } else {
                                    if (guVar.ptF != 0) {
                                        Q.eI(guVar.ptF);
                                    }
                                    Q.eL((long) guVar.vJg);
                                    Q.eJ(j);
                                    Q.hY(guVar.vJi);
                                    Q.setType(guVar.jCt);
                                    ad aoO = XM.aoO(obj);
                                    if (aoO == null || bo.isNullOrNil(aoO.field_username) || !aoO.dsf()) {
                                        Q.hO(obj2 != null ? 1 : 0);
                                        Q.ju(obj);
                                        Q.setStatus(obj2 != null ? guVar.vIY : 4);
                                        if (hashMap.get(obj) == null) {
                                            hashMap.put(obj, Integer.valueOf(0));
                                        }
                                        if (obj2 == null && guVar.vIY == 3) {
                                            hashMap.put(obj, Integer.valueOf(bo.a((Integer) hashMap.get(obj), 0) + 1));
                                        }
                                        j rD = com.tencent.mm.plugin.backup.bakoldlogic.b.d.aUA().rD(guVar.jCt);
                                        if (rD == null) {
                                            ab.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
                                        } else {
                                            rD.a(str3, guVar, Q);
                                        }
                                    } else {
                                        ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(obj)));
                                    }
                                }
                            } else {
                                ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
                            }
                        }
                    }
                    this.jzy++;
                    if (this.jzy % 100 == 0) {
                        aUT();
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e2.toString());
                    ab.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                }
                e.rm(guVar.jCt);
                long anU = bo.anU();
                if (anU - cVar.eRt > 10000) {
                    cVar.end();
                    cVar.begin();
                    cVar.eRt = anU;
                }
            }
            e.aSS();
            ab.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            int size = gvVar.jBw.size();
            AppMethodBeat.o(17875);
            return size;
        } catch (Exception e3) {
            Throwable th2 = e3;
            String str6 = "MicroMsg.RecoverPCServer";
            str2 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = th2;
            objArr2[2] = Integer.valueOf(f == null ? 0 : f.length);
            ab.e(str6, str2, objArr2);
            ab.printErrStackTrace("MicroMsg.RecoverPCServer", th2, "", new Object[0]);
            AppMethodBeat.o(17875);
            return 0;
        }
    }

    public final void aUT() {
        AppMethodBeat.i(17876);
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        ab.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.jzy));
        AppMethodBeat.o(17876);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(17877);
        this.jzX += (long) i;
        int i3 = this.jzW == 0 ? 0 : (int) ((this.jzX * 100) / this.jzW);
        if (i3 > this.jzY) {
            this.jzY = i3;
            com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.jzY);
        }
        if (this.cAY || this.eVT || this.jzs == null || this.jzY < 0 || this.jzY > 100) {
            ab.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", Integer.valueOf(this.jzY));
            AppMethodBeat.o(17877);
            return;
        }
        this.jzs.rI(this.jzY);
        AppMethodBeat.o(17877);
    }

    static /* synthetic */ void a(f fVar) {
        com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar;
        AppMethodBeat.i(17878);
        com.tencent.mm.a.e.t(new File(a.aUy()));
        fVar.jzt = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(17864);
                ab.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", ((com.tencent.mm.plugin.backup.bakoldlogic.c.d) mVar).id, Integer.valueOf(i), Integer.valueOf(i2));
                synchronized (f.this.lock) {
                    try {
                        f.this.jzr.remove(r11.id);
                        ab.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", Integer.valueOf(f.this.jzr.size()));
                        if (f.this.jzr.size() <= 10) {
                            f.this.lock.notifyAll();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(17864);
                        }
                    }
                }
                f fVar = f.this;
                fVar.jzy++;
                if (f.this.jzy % 300 == 0) {
                    f.this.aUT();
                }
                f.this.aUS();
                AppMethodBeat.o(17864);
            }
        };
        com.tencent.mm.plugin.backup.g.b.a(7, fVar.jzt);
        for (t tVar : fVar.jzT) {
            if (fVar.cAY && !fVar.eVT) {
                ab.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.o(17878);
                    }
                }
            }
            if (fVar.eVT) {
                ab.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                AppMethodBeat.o(17878);
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.aUy(), tVar.ID, 2, tVar.jCo, fVar, a.aUB().jqU);
            synchronized (fVar.lock) {
                try {
                    dVar.aUc();
                    fVar.jzr.add(tVar.ID);
                    ab.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", Integer.valueOf(fVar.jzr.size()));
                    if (fVar.jzr.size() > 10) {
                        fVar.lock.wait();
                    }
                } catch (InterruptedException e2) {
                    ab.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                } catch (Throwable th2) {
                    AppMethodBeat.o(17878);
                }
            }
        }
        for (t tVar2 : fVar.jzS) {
            if (fVar.cAY && !fVar.eVT) {
                ab.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (InterruptedException e22) {
                        ab.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                    } catch (Throwable th3) {
                        AppMethodBeat.o(17878);
                    }
                }
            }
            if (fVar.eVT) {
                ab.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                AppMethodBeat.o(17878);
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.aUy(), tVar2.ID, 1, tVar2.jCo, fVar, a.aUB().jqU);
            synchronized (fVar.lock) {
                try {
                    dVar.aUc();
                    fVar.jzr.add(tVar2.ID);
                    ab.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", Integer.valueOf(fVar.jzr.size()));
                    if (fVar.jzr.size() > 10) {
                        fVar.lock.wait();
                    }
                } catch (InterruptedException e222) {
                    ab.printErrStackTrace("MicroMsg.RecoverPCServer", e222, "", new Object[0]);
                } catch (Throwable th4) {
                    AppMethodBeat.o(17878);
                }
            }
        }
        fVar.jzu = true;
        ab.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        fVar.aUS();
        AppMethodBeat.o(17878);
    }
}
