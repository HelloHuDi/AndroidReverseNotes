package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public abstract class b extends m {
    private static final ak handler = new ak(Looper.getMainLooper());
    static int jqS = -1;
    private static final Map<Integer, Set<f>> jxd = new HashMap();
    private static final LinkedHashMap<Integer, b> jxe = new LinkedHashMap();
    private static d jxf;
    static a jxg;
    private static f jxh = null;
    private static j jxi = null;
    private static g jxj = null;
    private static h jxk = null;
    private static int jxl = new Random(bo.anU()).nextInt(1147483648);
    private static c jxm = null;
    private PByteArray jxc = new PByteArray();

    public interface a {
        void i(int i, byte[] bArr);

        int j(int i, byte[] bArr);
    }

    public interface b {
        void fo(boolean z);
    }

    public interface d {
        void a(boolean z, int i, byte[] bArr, int i2);
    }

    public interface c {
        void aTm();
    }

    public abstract com.tencent.mm.bt.a aTS();

    public abstract com.tencent.mm.bt.a aTT();

    public abstract int getType();

    public abstract void rw(int i);

    public static void a(d dVar) {
        jxf = dVar;
    }

    public static void a(a aVar) {
        jxg = aVar;
    }

    public static void rk(int i) {
        jqS = i;
    }

    public static int aSx() {
        return jqS;
    }

    public static void aTU() {
        if (jxh != null) {
            jxh.stop();
        }
        f fVar = new f();
        jxh = fVar;
        fVar.cg(true);
    }

    public static void aTV() {
        if (jxh != null) {
            jxh.stop();
        }
    }

    public static void a(com.tencent.mm.plugin.backup.g.j.a aVar) {
        jxi = new j(aVar);
    }

    public static void aTW() {
        int i = 0;
        if (jxi != null) {
            j jVar = jxi;
            ab.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
            jVar.jxZ = bo.anU();
            jVar.jxY = 0;
            jVar.jxW = 0;
            jVar.jyc.clear();
            jVar.jyb = 0;
            jVar.jya = 0;
            while (i < 10) {
                jVar.jyc.offer(Long.valueOf(204800));
                i++;
            }
            jVar.jyd.ae(1000, 1000);
            return;
        }
        ab.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
    }

    public static void aTX() {
        if (jxi != null) {
            j jVar = jxi;
            ab.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
            jVar.jyd.stopTimer();
            jVar.jyb = 0;
        }
    }

    public static String aTY() {
        if (jxi == null) {
            return "0B";
        }
        ab.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", j.gz(jxi.jxX));
        return j.gz(jxi.jxX);
    }

    public static void aTZ() {
        if (jxj == null) {
            jxj = new g();
        }
        g gVar = jxj;
        try {
            ab.i("MicroMsg.BackupLogManager", "start");
            g.init();
            if (gVar.jxJ != null) {
                gVar.jxJ.stopTimer();
                gVar.jxJ = null;
            }
            g.startTime = bo.anU();
            g.jxH = gVar.gy(g.startTime);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupLogManager", e, "start exception", new Object[0]);
        }
    }

    public static void rx(int i) {
        if (jxj != null) {
            g gVar = jxj;
            try {
                ab.i("MicroMsg.BackupLogManager", "end backupMode[%d]", Integer.valueOf(i));
                if (g.startTime == 0 || g.jxH == 0) {
                    ab.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", Long.valueOf(g.startTime), Long.valueOf(g.jxH));
                    return;
                }
                g.endTime = bo.anU();
                g.jxI = gVar.B(g.startTime, g.endTime);
                ab.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", Integer.valueOf(i), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.jxI), Long.valueOf(g.jxH));
                if (g.jxI != 0 && g.jxI > g.jxH) {
                    gVar.a(i, g.endTime - g.startTime, g.jxI - g.jxH, false);
                }
                g.init();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BackupLogManager", e, "end exception", new Object[0]);
            }
        }
    }

    public static void a(com.tencent.mm.plugin.backup.g.h.a aVar) {
        if (jxk == null) {
            ab.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
        } else if (jxk.jxQ) {
            ab.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
        } else {
            ab.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
            return;
        }
        h hVar = new h(aVar);
        jxk = hVar;
        ab.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
        h.index = 0;
        hVar.jxQ = false;
        hVar.jxP = 1;
        if (hVar.jxO != null) {
            hVar.jxR.ae(0, 0);
        }
    }

    public static void aUa() {
        if (jxk != null) {
            jxk.jxP = 0;
            h hVar = jxk;
            if (!hVar.jxQ) {
                ab.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
                hVar.jxR.stopTimer();
                hVar.jxQ = true;
            }
        }
    }

    public static int aUb() {
        if (jxk == null) {
            return 0;
        }
        return jxk.jxP;
    }

    public static void ry(int i) {
        if (jxk != null) {
            jxk.jxP = i;
        }
    }

    public static void clear() {
        ab.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (jxe) {
            jxe.clear();
        }
        synchronized (jxd) {
            jxd.clear();
        }
    }

    public static void a(c cVar) {
        jxm = cVar;
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
                int aUe = aUe();
                j.a(toByteArray, aUe, (short) getType(), this.jxc, jqS);
                if (jxg != null) {
                    jxg.i(aUe, this.jxc.value);
                }
                ab.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aUe), Integer.valueOf(getType()), Integer.valueOf(this.jxc.value.length));
                jxe.put(Integer.valueOf(aUe), this);
            }
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean aUd() {
        try {
            byte[] toByteArray = aTT().toByteArray();
            synchronized (jxe) {
                int aUe = aUe();
                j.a(toByteArray, aUe, (short) getType(), this.jxc, jqS);
                if (jxg != null) {
                    jxg.j(aUe, this.jxc.value);
                }
                ab.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aUe), Integer.valueOf(getType()), Integer.valueOf(this.jxc.value.length));
                jxe.put(Integer.valueOf(aUe), this);
            }
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean K(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (jxe) {
            int aUe = aUe();
            j.a(bArr, aUe, (short) i, pByteArray, jqS);
            if (jxg != null) {
                jxg.i(aUe, pByteArray.value);
            }
            ab.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aUe), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        }
        return true;
    }

    public static boolean r(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        j.a(bArr, i2, (short) i, pByteArray, jqS);
        if (jxg != null) {
            jxg.i(i2, pByteArray.value);
        }
        ab.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        return true;
    }

    public static void b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene";
        String str2 = "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        if (z) {
            try {
                ab.w("MicroMsg.BackupBaseScene", "callback error buf content : " + (bArr == null ? BuildConfig.COMMAND : new String(bArr)));
            } catch (Exception e) {
            }
            b(z, i2, bArr, i);
            return;
        }
        b bVar;
        if (jxh != null) {
            jxh.aUl();
            ab.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", Integer.valueOf(i2), Long.valueOf(bo.anU()));
        }
        synchronized (jxe) {
            bVar = (b) jxe.remove(Integer.valueOf(i));
        }
        if (bVar == null) {
            ab.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", Integer.valueOf(i2));
            if (bVar == null && i2 == 16) {
                synchronized (jxe) {
                    Iterator it = new HashSet(jxe.keySet()).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        bVar = (b) jxe.get(num);
                        String str3 = "MicroMsg.BackupBaseScene";
                        String str4 = "callback sceneMap seq:%d scene:%s type:%s";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = num;
                        objArr2[1] = bVar;
                        if (bVar == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = Integer.valueOf(bVar.getType());
                        }
                        objArr2[2] = str;
                        ab.d(str3, str4, objArr2);
                        if (bVar != null && bVar.getType() == 15) {
                            jxe.remove(num);
                            try {
                                bVar.aTS().parseFrom(bArr);
                                bVar.rw(i);
                            } catch (Exception e2) {
                                bVar.l(3, -1, "buf to tagResp fail");
                                ab.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "buf to tagResp error, type[%d], errMsg:%s ", Integer.valueOf(bVar.getType()), e2.toString());
                            }
                        }
                    }
                }
                return;
            }
            ab.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", Integer.valueOf(i), Integer.valueOf(i2));
            b(z, i2, bArr, i);
        } else if (bArr == null) {
            try {
                throw new Exception("buf is null");
            } catch (Exception e3) {
                bVar.l(3, -1, "buf to resq fail");
                ab.printErrStackTrace("MicroMsg.BackupBaseScene", e3, "%s ", e3.toString());
            }
        } else {
            bVar.aTS().parseFrom(bArr);
            bVar.rw(i);
        }
    }

    public static int aUe() {
        int i = jxl;
        jxl++;
        return i;
    }

    public final void a(int i, PByteArray pByteArray) {
        this.jxc = new PByteArray();
        this.jxc.value = pByteArray.value;
        synchronized (jxe) {
            jxe.put(Integer.valueOf(i), this);
        }
    }

    public static void rz(int i) {
        if (jxi != null) {
            j jVar = jxi;
            jVar.jxY = ((long) i) + jVar.jxY;
        }
    }

    private static void b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17638);
                if (b.jxf != null) {
                    b.jxf.a(z, i, bArr, i2);
                    AppMethodBeat.o(17638);
                    return;
                }
                ab.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
                AppMethodBeat.o(17638);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void l(final int i, final int i2, final String str) {
        handler.post(new Runnable() {
            public final void run() {
                Set set;
                AppMethodBeat.i(17639);
                synchronized (b.jxd) {
                    try {
                        set = (Set) b.jxd.get(Integer.valueOf(b.this.getType()));
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(17639);
                        }
                    }
                }
                if (set != null && set.size() > 0) {
                    HashSet<f> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (f fVar : hashSet) {
                        if (fVar != null && set.contains(fVar)) {
                            fVar.onSceneEnd(i, i2, str, b.this);
                        }
                    }
                }
                AppMethodBeat.o(17639);
            }
        });
    }

    public static void a(int i, f fVar) {
        synchronized (jxd) {
            if (!jxd.containsKey(Integer.valueOf(i))) {
                jxd.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) jxd.get(Integer.valueOf(i))).contains(fVar)) {
                ((Set) jxd.get(Integer.valueOf(i))).add(fVar);
            }
        }
    }

    public static void b(int i, f fVar) {
        synchronized (jxd) {
            try {
                if (jxd.get(Integer.valueOf(i)) != null) {
                    ((Set) jxd.get(Integer.valueOf(i))).remove(fVar);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", e);
            }
        }
    }

    public final int a(e eVar, f fVar) {
        return 0;
    }

    public static void a(final b bVar) {
        handler.postAtFrontOfQueueV2(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(17640);
                synchronized (b.jxe) {
                    try {
                        long anU = bo.anU();
                        for (Entry entry : b.jxe.entrySet()) {
                            int i2;
                            if (entry != null) {
                                PByteArray a = ((b) entry.getValue()).jxc;
                                if (a != null) {
                                    if (b.jxg != null) {
                                        b.jxg.j(((Integer) entry.getKey()).intValue(), a.value);
                                        ab.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(a.value.length));
                                    } else {
                                        ab.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(a.value.length));
                                    }
                                    i2 = i + 1;
                                } else {
                                    ab.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", entry.getKey());
                                    i2 = i + 1;
                                }
                            } else {
                                i2 = i;
                            }
                            if (i2 > 0) {
                                if (i2 % 5 == 0) {
                                    bVar.fo(false);
                                }
                            }
                            i = i2;
                        }
                        bVar.fo(true);
                        ab.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", Integer.valueOf(b.jxe.size()), Long.valueOf(bo.gb(anU)));
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.o(17640);
                    }
                }
                AppMethodBeat.o(17640);
            }
        });
    }
}
