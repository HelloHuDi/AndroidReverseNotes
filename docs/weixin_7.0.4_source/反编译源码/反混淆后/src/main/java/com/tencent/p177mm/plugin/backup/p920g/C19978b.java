package com.tencent.p177mm.plugin.backup.p920g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p346f.C33701j;
import com.tencent.p177mm.plugin.backup.p920g.C19986h.C19987a;
import com.tencent.p177mm.plugin.backup.p920g.C33704j.C33705a;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.backup.g.b */
public abstract class C19978b extends C1207m {
    private static final C7306ak handler = new C7306ak(Looper.getMainLooper());
    static int jqS = -1;
    private static final Map<Integer, Set<C1202f>> jxd = new HashMap();
    private static final LinkedHashMap<Integer, C19978b> jxe = new LinkedHashMap();
    private static C19977d jxf;
    static C19975a jxg;
    private static C42774f jxh = null;
    private static C33704j jxi = null;
    private static C19984g jxj = null;
    private static C19986h jxk = null;
    private static int jxl = new Random(C5046bo.anU()).nextInt(1147483648);
    private static C19979c jxm = null;
    private PByteArray jxc = new PByteArray();

    /* renamed from: com.tencent.mm.plugin.backup.g.b$a */
    public interface C19975a {
        /* renamed from: i */
        void mo35222i(int i, byte[] bArr);

        /* renamed from: j */
        int mo35223j(int i, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.b$b */
    public interface C19976b {
        /* renamed from: fo */
        void mo35224fo(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.b$d */
    public interface C19977d {
        /* renamed from: a */
        void mo6669a(boolean z, int i, byte[] bArr, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.b$c */
    public interface C19979c {
        void aTm();
    }

    public abstract C1331a aTS();

    public abstract C1331a aTT();

    public abstract int getType();

    /* renamed from: rw */
    public abstract void mo6711rw(int i);

    /* renamed from: a */
    public static void m30883a(C19977d c19977d) {
        jxf = c19977d;
    }

    /* renamed from: a */
    public static void m30880a(C19975a c19975a) {
        jxg = c19975a;
    }

    /* renamed from: rk */
    public static void m30890rk(int i) {
        jqS = i;
    }

    public static int aSx() {
        return jqS;
    }

    public static void aTU() {
        if (jxh != null) {
            jxh.stop();
        }
        C42774f c42774f = new C42774f();
        jxh = c42774f;
        c42774f.mo68246cg(true);
    }

    public static void aTV() {
        if (jxh != null) {
            jxh.stop();
        }
    }

    /* renamed from: a */
    public static void m30885a(C33705a c33705a) {
        jxi = new C33704j(c33705a);
    }

    public static void aTW() {
        int i = 0;
        if (jxi != null) {
            C33704j c33704j = jxi;
            C4990ab.m7416i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
            c33704j.jxZ = C5046bo.anU();
            c33704j.jxY = 0;
            c33704j.jxW = 0;
            c33704j.jyc.clear();
            c33704j.jyb = 0;
            c33704j.jya = 0;
            while (i < 10) {
                c33704j.jyc.offer(Long.valueOf(204800));
                i++;
            }
            c33704j.jyd.mo16770ae(1000, 1000);
            return;
        }
        C4990ab.m7412e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
    }

    public static void aTX() {
        if (jxi != null) {
            C33704j c33704j = jxi;
            C4990ab.m7416i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
            c33704j.jyd.stopTimer();
            c33704j.jyb = 0;
        }
    }

    public static String aTY() {
        if (jxi == null) {
            return "0B";
        }
        C4990ab.m7417i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", C33704j.m55084gz(jxi.jxX));
        return C33704j.m55084gz(jxi.jxX);
    }

    public static void aTZ() {
        if (jxj == null) {
            jxj = new C19984g();
        }
        C19984g c19984g = jxj;
        try {
            C4990ab.m7416i("MicroMsg.BackupLogManager", "start");
            C19984g.init();
            if (c19984g.jxJ != null) {
                c19984g.jxJ.stopTimer();
                c19984g.jxJ = null;
            }
            C19984g.startTime = C5046bo.anU();
            C19984g.jxH = c19984g.mo35233gy(C19984g.startTime);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupLogManager", e, "start exception", new Object[0]);
        }
    }

    /* renamed from: rx */
    public static void m30891rx(int i) {
        if (jxj != null) {
            C19984g c19984g = jxj;
            try {
                C4990ab.m7417i("MicroMsg.BackupLogManager", "end backupMode[%d]", Integer.valueOf(i));
                if (C19984g.startTime == 0 || C19984g.jxH == 0) {
                    C4990ab.m7413e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", Long.valueOf(C19984g.startTime), Long.valueOf(C19984g.jxH));
                    return;
                }
                C19984g.endTime = C5046bo.anU();
                C19984g.jxI = c19984g.mo35231B(C19984g.startTime, C19984g.endTime);
                C4990ab.m7417i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", Integer.valueOf(i), Long.valueOf(C19984g.endTime), Long.valueOf(C19984g.startTime), Long.valueOf(C19984g.jxI), Long.valueOf(C19984g.jxH));
                if (C19984g.jxI != 0 && C19984g.jxI > C19984g.jxH) {
                    c19984g.mo35232a(i, C19984g.endTime - C19984g.startTime, C19984g.jxI - C19984g.jxH, false);
                }
                C19984g.init();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BackupLogManager", e, "end exception", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m30884a(C19987a c19987a) {
        if (jxk == null) {
            C4990ab.m7416i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
        } else if (jxk.jxQ) {
            C4990ab.m7416i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
        } else {
            C4990ab.m7412e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
            return;
        }
        C19986h c19986h = new C19986h(c19987a);
        jxk = c19986h;
        C4990ab.m7416i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
        C19986h.index = 0;
        c19986h.jxQ = false;
        c19986h.jxP = 1;
        if (c19986h.jxO != null) {
            c19986h.jxR.mo16770ae(0, 0);
        }
    }

    public static void aUa() {
        if (jxk != null) {
            jxk.jxP = 0;
            C19986h c19986h = jxk;
            if (!c19986h.jxQ) {
                C4990ab.m7416i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
                c19986h.jxR.stopTimer();
                c19986h.jxQ = true;
            }
        }
    }

    public static int aUb() {
        if (jxk == null) {
            return 0;
        }
        return jxk.jxP;
    }

    /* renamed from: ry */
    public static void m30892ry(int i) {
        if (jxk != null) {
            jxk.jxP = i;
        }
    }

    public static void clear() {
        C4990ab.m7416i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (jxe) {
            jxe.clear();
        }
        synchronized (jxd) {
            jxd.clear();
        }
    }

    /* renamed from: a */
    public static void m30882a(C19979c c19979c) {
        jxm = c19979c;
    }

    public static void aTm() {
        if (jxm != null) {
            jxm.aTm();
        }
    }

    public boolean aUc() {
        try {
            byte[] toByteArray = aTT().toByteArray();
            synchronized (jxe) {
                int aUe = C19978b.aUe();
                C33701j.m55070a(toByteArray, aUe, (short) getType(), this.jxc, jqS);
                if (jxg != null) {
                    jxg.mo35222i(aUe, this.jxc.value);
                }
                C4990ab.m7417i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aUe), Integer.valueOf(getType()), Integer.valueOf(this.jxc.value.length));
                jxe.put(Integer.valueOf(aUe), this);
            }
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean aUd() {
        try {
            byte[] toByteArray = aTT().toByteArray();
            synchronized (jxe) {
                int aUe = C19978b.aUe();
                C33701j.m55070a(toByteArray, aUe, (short) getType(), this.jxc, jqS);
                if (jxg != null) {
                    jxg.mo35223j(aUe, this.jxc.value);
                }
                C4990ab.m7417i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aUe), Integer.valueOf(getType()), Integer.valueOf(this.jxc.value.length));
                jxe.put(Integer.valueOf(aUe), this);
            }
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    /* renamed from: K */
    public static boolean m30877K(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (jxe) {
            int aUe = C19978b.aUe();
            C33701j.m55070a(bArr, aUe, (short) i, pByteArray, jqS);
            if (jxg != null) {
                jxg.mo35222i(aUe, pByteArray.value);
            }
            C4990ab.m7417i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aUe), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        }
        return true;
    }

    /* renamed from: r */
    public static boolean m30889r(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        C33701j.m55070a(bArr, i2, (short) i, pByteArray, jqS);
        if (jxg != null) {
            jxg.mo35222i(i2, pByteArray.value);
        }
        C4990ab.m7417i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        return true;
    }

    /* renamed from: b */
    public static void m30887b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene";
        String str2 = "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        if (z) {
            try {
                C4990ab.m7420w("MicroMsg.BackupBaseScene", "callback error buf content : " + (bArr == null ? BuildConfig.COMMAND : new String(bArr)));
            } catch (Exception e) {
            }
            C19978b.m30888b(z, i2, bArr, i);
            return;
        }
        C19978b c19978b;
        if (jxh != null) {
            jxh.aUl();
            C4990ab.m7411d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", Integer.valueOf(i2), Long.valueOf(C5046bo.anU()));
        }
        synchronized (jxe) {
            c19978b = (C19978b) jxe.remove(Integer.valueOf(i));
        }
        if (c19978b == null) {
            C4990ab.m7417i("MicroMsg.BackupBaseScene", "notify scene null type:%d", Integer.valueOf(i2));
            if (c19978b == null && i2 == 16) {
                synchronized (jxe) {
                    Iterator it = new HashSet(jxe.keySet()).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        c19978b = (C19978b) jxe.get(num);
                        String str3 = "MicroMsg.BackupBaseScene";
                        String str4 = "callback sceneMap seq:%d scene:%s type:%s";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = num;
                        objArr2[1] = c19978b;
                        if (c19978b == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = Integer.valueOf(c19978b.getType());
                        }
                        objArr2[2] = str;
                        C4990ab.m7411d(str3, str4, objArr2);
                        if (c19978b != null && c19978b.getType() == 15) {
                            jxe.remove(num);
                            try {
                                c19978b.aTS().parseFrom(bArr);
                                c19978b.mo6711rw(i);
                            } catch (Exception e2) {
                                c19978b.mo35227l(3, -1, "buf to tagResp fail");
                                C4990ab.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "buf to tagResp error, type[%d], errMsg:%s ", Integer.valueOf(c19978b.getType()), e2.toString());
                            }
                        }
                    }
                }
                return;
            }
            C4990ab.m7417i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C19978b.m30888b(z, i2, bArr, i);
        } else if (bArr == null) {
            try {
                throw new Exception("buf is null");
            } catch (Exception e3) {
                c19978b.mo35227l(3, -1, "buf to resq fail");
                C4990ab.printErrStackTrace("MicroMsg.BackupBaseScene", e3, "%s ", e3.toString());
            }
        } else {
            c19978b.aTS().parseFrom(bArr);
            c19978b.mo6711rw(i);
        }
    }

    public static int aUe() {
        int i = jxl;
        jxl++;
        return i;
    }

    /* renamed from: a */
    public final void mo35225a(int i, PByteArray pByteArray) {
        this.jxc = new PByteArray();
        this.jxc.value = pByteArray.value;
        synchronized (jxe) {
            jxe.put(Integer.valueOf(i), this);
        }
    }

    /* renamed from: rz */
    public static void m30893rz(int i) {
        if (jxi != null) {
            C33704j c33704j = jxi;
            c33704j.jxY = ((long) i) + c33704j.jxY;
        }
    }

    /* renamed from: b */
    private static void m30888b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17638);
                if (C19978b.jxf != null) {
                    C19978b.jxf.mo6669a(z, i, bArr, i2);
                    AppMethodBeat.m2505o(17638);
                    return;
                }
                C4990ab.m7420w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
                AppMethodBeat.m2505o(17638);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: l */
    public final void mo35227l(final int i, final int i2, final String str) {
        handler.post(new Runnable() {
            public final void run() {
                Set set;
                AppMethodBeat.m2504i(17639);
                synchronized (C19978b.jxd) {
                    try {
                        set = (Set) C19978b.jxd.get(Integer.valueOf(C19978b.this.getType()));
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(17639);
                        }
                    }
                }
                if (set != null && set.size() > 0) {
                    HashSet<C1202f> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (C1202f c1202f : hashSet) {
                        if (c1202f != null && set.contains(c1202f)) {
                            c1202f.onSceneEnd(i, i2, str, C19978b.this);
                        }
                    }
                }
                AppMethodBeat.m2505o(17639);
            }
        });
    }

    /* renamed from: a */
    public static void m30879a(int i, C1202f c1202f) {
        synchronized (jxd) {
            if (!jxd.containsKey(Integer.valueOf(i))) {
                jxd.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) jxd.get(Integer.valueOf(i))).contains(c1202f)) {
                ((Set) jxd.get(Integer.valueOf(i))).add(c1202f);
            }
        }
    }

    /* renamed from: b */
    public static void m30886b(int i, C1202f c1202f) {
        synchronized (jxd) {
            try {
                if (jxd.get(Integer.valueOf(i)) != null) {
                    ((Set) jxd.get(Integer.valueOf(i))).remove(c1202f);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", e);
            }
        }
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        return 0;
    }

    /* renamed from: a */
    public static void m30881a(final C19976b c19976b) {
        handler.postAtFrontOfQueueV2(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.m2504i(17640);
                synchronized (C19978b.jxe) {
                    try {
                        long anU = C5046bo.anU();
                        for (Entry entry : C19978b.jxe.entrySet()) {
                            int i2;
                            if (entry != null) {
                                PByteArray a = ((C19978b) entry.getValue()).jxc;
                                if (a != null) {
                                    if (C19978b.jxg != null) {
                                        C19978b.jxg.mo35223j(((Integer) entry.getKey()).intValue(), a.value);
                                        C4990ab.m7417i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((C19978b) entry.getValue()).getType()), Integer.valueOf(a.value.length));
                                    } else {
                                        C4990ab.m7413e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((C19978b) entry.getValue()).getType()), Integer.valueOf(a.value.length));
                                    }
                                    i2 = i + 1;
                                } else {
                                    C4990ab.m7413e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", entry.getKey());
                                    i2 = i + 1;
                                }
                            } else {
                                i2 = i;
                            }
                            if (i2 > 0) {
                                if (i2 % 5 == 0) {
                                    c19976b.mo35224fo(false);
                                }
                            }
                            i = i2;
                        }
                        c19976b.mo35224fo(true);
                        C4990ab.m7417i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", Integer.valueOf(C19978b.jxe.size()), Long.valueOf(C5046bo.m7566gb(anU)));
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(17640);
                    }
                }
                AppMethodBeat.m2505o(17640);
            }
        });
    }
}
