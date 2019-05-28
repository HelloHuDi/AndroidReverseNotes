package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel.C27454c;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C11116d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C2645d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C42767b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C36747d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C45737j;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b.C11125a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b.C111262;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11131d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C27478c;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C45742a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C45742a.C45741a;
import com.tencent.p177mm.plugin.backup.p344c.C33691e;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p921i.C11155t;
import com.tencent.p177mm.plugin.backup.p921i.C33707ac;
import com.tencent.p177mm.plugin.backup.p921i.C38659ab;
import com.tencent.p177mm.plugin.backup.p921i.C38664r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.C46545gv;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f */
public final class C27463f implements C32231g {
    boolean cAY = false;
    boolean eVT = false;
    boolean jsp = false;
    List<C11155t> jzS;
    List<C11155t> jzT;
    int jzU = 0;
    public boolean jzV = false;
    long jzW;
    long jzX;
    int jzY;
    HashSet<String> jzr = new HashSet();
    C11116d jzs;
    private C1202f jzt;
    boolean jzu = false;
    int jzy = 0;
    Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$1 */
    class C199641 implements Runnable {
        C199641() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17861);
            C27463f.m43582a(C27463f.this);
            AppMethodBeat.m2505o(17861);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$2 */
    class C274642 implements C1202f {

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$2$1 */
        class C274651 implements Runnable {
            C274651() {
            }

            public final void run() {
                AppMethodBeat.m2504i(17862);
                C27463f.m43582a(C27463f.this);
                AppMethodBeat.m2505o(17862);
            }
        }

        C274642() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17863);
            C33707ac c33707ac = (C33707ac) ((C19978b) c1207m).aTS();
            if (c33707ac.jBh != 2) {
                AppMethodBeat.m2505o(17863);
                return;
            }
            C38664r c38664r = c33707ac.jCN;
            C27463f.this.jzT.addAll(c38664r.jCl);
            C27463f.this.jzS.addAll(c38664r.jCk);
            C4990ab.m7417i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", Integer.valueOf(C27463f.this.jzT.size()), Integer.valueOf(C27463f.this.jzS.size()), Integer.valueOf(c38664r.jBX), Integer.valueOf(c38664r.jBW));
            if (C27463f.this.jzT.size() < c38664r.jBX || C27463f.this.jzS.size() < c38664r.jBW) {
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                new C42767b(2).aUc();
                AppMethodBeat.m2505o(17863);
                return;
            }
            C27463f.this.jzW = c38664r.jBS;
            C4990ab.m7417i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", Long.valueOf(C27463f.this.jzW));
            C19978b.m30886b(3, this);
            C7305d.post(new C274651(), "RecoverPCServer_recover_getIDList");
            AppMethodBeat.m2505o(17863);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$3 */
    class C274663 implements C1202f {
        C274663() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17864);
            C4990ab.m7417i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", ((C2645d) c1207m).f1262id, Integer.valueOf(i), Integer.valueOf(i2));
            synchronized (C27463f.this.lock) {
                try {
                    C27463f.this.jzr.remove(r11.f1262id);
                    C4990ab.m7417i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", Integer.valueOf(C27463f.this.jzr.size()));
                    if (C27463f.this.jzr.size() <= 10) {
                        C27463f.this.lock.notifyAll();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(17864);
                    }
                }
            }
            C27463f c27463f = C27463f.this;
            c27463f.jzy++;
            if (C27463f.this.jzy % 300 == 0) {
                C27463f.this.aUT();
            }
            C27463f.this.aUS();
            AppMethodBeat.m2505o(17864);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$4 */
    class C274674 extends C11125a {
        C274674() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17865);
            C27463f c27463f = C27463f.this;
            int aT = C27463f.m43583aT(c27463f.jzS);
            C4990ab.m7416i("MicroMsg.RecoverPCServer", "all msg item Count : ".concat(String.valueOf(aT)));
            C4990ab.m7410d("MicroMsg.RecoverPCServer", "readFromSdcard start");
            C7305d.m12285a(new C274685(aT), "RecoverPCServer_recoverFromSdcard", 1).start();
            AppMethodBeat.m2505o(17865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$5 */
    class C274685 implements Runnable {
        final /* synthetic */ int jAb;

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$5$1 */
        class C26441 implements Runnable {
            C26441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(17866);
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "readFromSdcard end");
                C4990ab.dot();
                C41257a.aUB().aUC().jzL = 7;
                C27463f.this.jzU = 0;
                if (C27463f.this.jzs != null) {
                    C27463f.this.jzs.aSt();
                } else {
                    C4990ab.m7416i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                }
                C27460e.aUN();
                new C42767b(8).aUc();
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "recover ok");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.TRUE);
                C38643c aUD = C41257a.aUB().aUD();
                aUD.jzo++;
                C41257a.aUB().aUC().jzK = 7;
                C27463f.this.cancel();
                C45742a aVa = C11124b.aUY().aVa();
                StringBuffer stringBuffer = new StringBuffer();
                Iterator it = aVa.jyk.iterator();
                while (it.hasNext()) {
                    C45741a c45741a = (C45741a) it.next();
                    if (c45741a.type == 2 && c45741a.obj != null && (c45741a.obj instanceof String)) {
                        stringBuffer.append(c45741a.type + " : " + ((String) c45741a.obj) + " ,");
                    } else if (c45741a.type == 1 && c45741a.obj != null && (c45741a.obj instanceof String)) {
                        stringBuffer.append(c45741a.type + " : " + ((String) c45741a.obj) + " ,");
                    }
                }
                C4990ab.m7410d("MicroMsg.BakOldRecoverDelayData", "dump delay " + stringBuffer.toString());
                AppMethodBeat.m2505o(17866);
            }
        }

        C274685(int i) {
            this.jAb = i;
        }

        public final void run() {
            Exception e;
            AppMethodBeat.m2504i(17867);
            C33691e.reset();
            C33691e.aST();
            C27454c c27454c = new C27454c();
            c27454c.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (C11155t c11155t : C27463f.this.jzS) {
                int a;
                try {
                    a = C27463f.this.mo45250a(C27452a.aUy() + "backupItem/" + C27452a.m43552Fb(c11155t.f2889ID) + c11155t.f2889ID, hashMap, c27454c, hashSet);
                    if (a < 0) {
                        c27454c.end();
                        C4990ab.m7420w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        AppMethodBeat.m2505o(17867);
                        return;
                    }
                    a += i;
                    try {
                        C27463f.this.mo45254dB(a, this.jAb);
                        C4990ab.m7417i("MicroMsg.RecoverPCServer", "recover has done: %d", Integer.valueOf(a));
                        i = a;
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.m7412e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        C4990ab.m7414f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Exception e3) {
                    e = e3;
                    a = i;
                    C4990ab.m7412e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    C4990ab.m7414f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            C11131d.m18843k(hashMap);
            c27454c.end();
            C27463f.this.mo45254dB(100, 100);
            C4990ab.m7416i("MicroMsg.RecoverPCServer", "build temDB finish!");
            C4990ab.dot();
            C11124b aUY = C11124b.aUY();
            aUY.mo22831c(new C111262(new C26441()), 10);
            AppMethodBeat.m2505o(17867);
        }
    }

    public C27463f() {
        AppMethodBeat.m2504i(17868);
        AppMethodBeat.m2505o(17868);
    }

    public final void pause() {
        AppMethodBeat.m2504i(17869);
        C4990ab.m7416i("MicroMsg.RecoverPCServer", "pause");
        this.cAY = true;
        AppMethodBeat.m2505o(17869);
    }

    public final void resume() {
        AppMethodBeat.m2504i(17870);
        C4990ab.m7416i("MicroMsg.RecoverPCServer", "resume");
        this.cAY = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17870);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(17871);
        C4990ab.m7416i("MicroMsg.RecoverPCServer", "cancel");
        this.eVT = true;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17871);
            }
        }
        C19978b.m30886b(7, this.jzt);
        this.jzs = null;
        this.jzV = false;
        this.jsp = false;
        this.jzU = 0;
        this.jzY = 0;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:20:0x0062, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(17872);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aUS() {
        AppMethodBeat.m2504i(17872);
        if (!this.jzu || this.eVT) {
            AppMethodBeat.m2505o(17872);
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.jzr.isEmpty()) {
                    if (this.eVT) {
                    } else {
                        this.jzV = true;
                        this.jzY = 0;
                        C41257a.aUB().aUC().jzK = 6;
                        C41257a.aUB().aUC().jzL = 5;
                        if (this.jzs != null) {
                            this.jzs.aUP();
                        } else {
                            C4990ab.m7416i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                        }
                        C19978b.m30886b(7, this.jzt);
                        mo45254dB(0, 0);
                        C27460e.aUN();
                        C4990ab.m7416i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
                    }
                }
            } finally {
                AppMethodBeat.m2505o(17872);
            }
        }
    }

    /* renamed from: aT */
    public static int m43583aT(List<C11155t> list) {
        AppMethodBeat.m2504i(17873);
        int i = 0;
        for (C11155t c11155t : list) {
            try {
                i = ((C46545gv) new C46545gv().parseFrom(C1173e.m2571f(C27452a.aUy() + "backupItem/" + C27452a.m43552Fb(c11155t.f2889ID) + c11155t.f2889ID, 0, -1))).jBw.size() + i;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(17873);
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dB */
    public final void mo45254dB(int i, int i2) {
        AppMethodBeat.m2504i(17874);
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if (!(i == 0 && i2 == 0) && i3 <= this.jzU) {
            AppMethodBeat.m2505o(17874);
            return;
        }
        this.jzU = i3;
        if (!(this.cAY || this.eVT || this.jzs == null || this.jzU < 0 || this.jzU > 100)) {
            this.jzs.mo22820rJ(this.jzU);
        }
        C38659ab c38659ab = new C38659ab();
        c38659ab.jBh = 13;
        c38659ab.jCI = 0;
        c38659ab.jCJ = this.jzU;
        try {
            C4990ab.m7417i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", Integer.valueOf(i3));
            C19978b.m30877K(c38659ab.toByteArray(), 3);
            AppMethodBeat.m2505o(17874);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            AppMethodBeat.m2505o(17874);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo45250a(String str, HashMap<String, Integer> hashMap, C27454c c27454c, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(17875);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] f = C1173e.m2571f(str, 0, -1);
        String str2;
        try {
            C46545gv c46545gv = (C46545gv) new C46545gv().parseFrom(f);
            Iterator it = c46545gv.jBw.iterator();
            while (it.hasNext()) {
                C40522gu c40522gu = (C40522gu) it.next();
                if (this.cAY && !this.eVT) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e) {
                            C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(17875);
                        }
                    }
                }
                if (this.eVT) {
                    C4990ab.m7416i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    AppMethodBeat.m2505o(17875);
                    return -1;
                }
                try {
                    String str3 = (String) C11124b.aUY().aUZ().mo45267Ry().get(2, null);
                    C6977h XO = C11124b.aUY().aUZ().mo45269XO();
                    str2 = c40522gu.vEB.wVI;
                    String str4 = c40522gu.vEC.wVI;
                    String str5;
                    if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str4)) {
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
                        C4990ab.m7421w(str3, str5, objArr);
                    } else {
                        C4990ab.m7417i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", Integer.valueOf(c40522gu.jCt), str2, str4);
                        C27478c aUZ = C11124b.aUY().aUZ();
                        if (aUZ.uin == 0) {
                            C1819b c1819b = new C1819b();
                            AppMethodBeat.m2505o(17875);
                            throw c1819b;
                        }
                        Object obj;
                        long j;
                        C6978k c6978k = aUZ.jys;
                        C7309bd XM = C11124b.aUY().aUZ().mo45268XM();
                        Object obj2 = (c6978k.has(str2) || str3.equals(str2)) ? 1 : null;
                        if (obj2 != null) {
                            obj = str4;
                        } else {
                            str5 = str2;
                        }
                        if (c40522gu.vJh != 0) {
                            j = c40522gu.vJh;
                        } else {
                            j = ((long) c40522gu.vIZ) * 1000;
                        }
                        hashSet.add(obj);
                        List Ko = C27452a.m43556Ko();
                        if (Ko.contains(str2) || Ko.contains(str4)) {
                            C4990ab.m7420w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str2 + " " + str4);
                        } else {
                            if (c40522gu.ptF == 0 && c40522gu.ptD != 0) {
                                c40522gu.ptF = (long) c40522gu.ptD;
                            }
                            if (c40522gu.ptF != 0) {
                                if (!str3.equals(str2)) {
                                    str4 = str2;
                                }
                                C7620bi Q = XO.mo15241Q(str4, c40522gu.ptF);
                                if (Q.field_msgId != 0) {
                                    C4990ab.m7416i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
                                } else {
                                    if (c40522gu.ptF != 0) {
                                        Q.mo14774eI(c40522gu.ptF);
                                    }
                                    Q.mo14777eL((long) c40522gu.vJg);
                                    Q.mo14775eJ(j);
                                    Q.mo14783hY(c40522gu.vJi);
                                    Q.setType(c40522gu.jCt);
                                    C7616ad aoO = XM.aoO(obj);
                                    if (aoO == null || C5046bo.isNullOrNil(aoO.field_username) || !aoO.dsf()) {
                                        Q.mo14781hO(obj2 != null ? 1 : 0);
                                        Q.mo14794ju(obj);
                                        Q.setStatus(obj2 != null ? c40522gu.vIY : 4);
                                        if (hashMap.get(obj) == null) {
                                            hashMap.put(obj, Integer.valueOf(0));
                                        }
                                        if (obj2 == null && c40522gu.vIY == 3) {
                                            hashMap.put(obj, Integer.valueOf(C5046bo.m7512a((Integer) hashMap.get(obj), 0) + 1));
                                        }
                                        C45737j rD = C36747d.aUA().mo58597rD(c40522gu.jCt);
                                        if (rD == null) {
                                            C4990ab.m7416i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
                                        } else {
                                            rD.mo22812a(str3, c40522gu, Q);
                                        }
                                    } else {
                                        C4990ab.m7420w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(obj)));
                                    }
                                }
                            } else {
                                C4990ab.m7420w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
                            }
                        }
                    }
                    this.jzy++;
                    if (this.jzy % 100 == 0) {
                        aUT();
                    }
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e2.toString());
                    C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                }
                C33691e.m55032rm(c40522gu.jCt);
                long anU = C5046bo.anU();
                if (anU - c27454c.eRt > 10000) {
                    c27454c.end();
                    c27454c.begin();
                    c27454c.eRt = anU;
                }
            }
            C33691e.aSS();
            C4990ab.m7410d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            int size = c46545gv.jBw.size();
            AppMethodBeat.m2505o(17875);
            return size;
        } catch (Exception e3) {
            Throwable th2 = e3;
            String str6 = "MicroMsg.RecoverPCServer";
            str2 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = th2;
            objArr2[2] = Integer.valueOf(f == null ? 0 : f.length);
            C4990ab.m7413e(str6, str2, objArr2);
            C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", th2, "", new Object[0]);
            AppMethodBeat.m2505o(17875);
            return 0;
        }
    }

    public final void aUT() {
        AppMethodBeat.m2504i(17876);
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        C4990ab.m7417i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.jzy));
        AppMethodBeat.m2505o(17876);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(17877);
        this.jzX += (long) i;
        int i3 = this.jzW == 0 ? 0 : (int) ((this.jzX * 100) / this.jzW);
        if (i3 > this.jzY) {
            this.jzY = i3;
            C2645d.setProgress(this.jzY);
        }
        if (this.cAY || this.eVT || this.jzs == null || this.jzY < 0 || this.jzY > 100) {
            C4990ab.m7411d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", Integer.valueOf(this.jzY));
            AppMethodBeat.m2505o(17877);
            return;
        }
        this.jzs.mo22819rI(this.jzY);
        AppMethodBeat.m2505o(17877);
    }

    /* renamed from: a */
    static /* synthetic */ void m43582a(C27463f c27463f) {
        C2645d c2645d;
        AppMethodBeat.m2504i(17878);
        C1173e.m2575t(new File(C27452a.aUy()));
        c27463f.jzt = new C274663();
        C19978b.m30879a(7, c27463f.jzt);
        for (C11155t c11155t : c27463f.jzT) {
            if (c27463f.cAY && !c27463f.eVT) {
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (c27463f.lock) {
                    try {
                        c27463f.lock.wait();
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(17878);
                    }
                }
            }
            if (c27463f.eVT) {
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "backupImp canceled");
                AppMethodBeat.m2505o(17878);
                return;
            }
            c2645d = new C2645d(C27452a.aUy(), c11155t.f2889ID, 2, c11155t.jCo, c27463f, C41257a.aUB().jqU);
            synchronized (c27463f.lock) {
                try {
                    c2645d.aUc();
                    c27463f.jzr.add(c11155t.f2889ID);
                    C4990ab.m7417i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", Integer.valueOf(c27463f.jzr.size()));
                    if (c27463f.jzr.size() > 10) {
                        c27463f.lock.wait();
                    }
                } catch (InterruptedException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(17878);
                }
            }
        }
        for (C11155t c11155t2 : c27463f.jzS) {
            if (c27463f.cAY && !c27463f.eVT) {
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (c27463f.lock) {
                    try {
                        c27463f.lock.wait();
                    } catch (InterruptedException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                    } catch (Throwable th3) {
                        AppMethodBeat.m2505o(17878);
                    }
                }
            }
            if (c27463f.eVT) {
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "backupImp canceled");
                AppMethodBeat.m2505o(17878);
                return;
            }
            c2645d = new C2645d(C27452a.aUy(), c11155t2.f2889ID, 1, c11155t2.jCo, c27463f, C41257a.aUB().jqU);
            synchronized (c27463f.lock) {
                try {
                    c2645d.aUc();
                    c27463f.jzr.add(c11155t2.f2889ID);
                    C4990ab.m7417i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", Integer.valueOf(c27463f.jzr.size()));
                    if (c27463f.jzr.size() > 10) {
                        c27463f.lock.wait();
                    }
                } catch (InterruptedException e222) {
                    C4990ab.printErrStackTrace("MicroMsg.RecoverPCServer", e222, "", new Object[0]);
                } catch (Throwable th4) {
                    AppMethodBeat.m2505o(17878);
                }
            }
        }
        c27463f.jzu = true;
        C4990ab.m7416i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        c27463f.aUS();
        AppMethodBeat.m2505o(17878);
    }
}
