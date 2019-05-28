package com.tencent.mm.an;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class c implements Runnable {
    boolean fAA = false;
    int fAs = 0;
    private d fAt = null;
    b fAu = new b();
    private long fAv = 0;
    private long fAw = 0;
    private long fAx = 0;
    String fAy = null;
    private String fAz = null;

    public static class d implements Serializable {
        long endTime = 0;
        long fAG = 0;
        int fAl = 0;
        boolean fAm = true;
        boolean fAn = false;
        int pid = 0;
        long startTime = 0;

        /* Access modifiers changed, original: final */
        public final void a(int i, long j, long j2, int i2) {
            AppMethodBeat.i(58341);
            this.pid = i;
            if (this.startTime <= 0) {
                this.startTime = j;
                this.fAG = cb.aaD();
            }
            this.endTime = j2;
            this.fAl = i2;
            AppMethodBeat.o(58341);
        }

        static d b(int i, long j, long j2, int i2) {
            AppMethodBeat.i(58342);
            d dVar = new d();
            dVar.pid = i;
            dVar.startTime = j;
            dVar.endTime = j2;
            dVar.fAl = i2;
            AppMethodBeat.o(58342);
            return dVar;
        }

        public final String toString() {
            AppMethodBeat.i(58343);
            String format = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[]{Integer.valueOf(this.pid), a.fF(this.fAG), a.fF(this.startTime), a.fF(this.endTime), Boolean.valueOf(this.fAm), Boolean.valueOf(this.fAn), Integer.valueOf(this.fAl)});
            AppMethodBeat.o(58343);
            return format;
        }
    }

    static class b implements Serializable {
        final List<d> fAB = new CopyOnWriteArrayList();
        final List<a> fAC = new CopyOnWriteArrayList();
        final List<a> fAD = new CopyOnWriteArrayList();
        final List<c> fAE = new CopyOnWriteArrayList();

        b() {
            AppMethodBeat.i(58339);
            AppMethodBeat.o(58339);
        }
    }

    static class c implements Serializable {
        long fAF = 0;
        long fAk = 0;
        long fAp = 0;
        long fAq = 0;
        long fAr = 0;
        int pid = 0;

        c(int i, long j, long j2, long j3, long j4, long j5) {
            this.pid = i;
            this.fAk = j;
            this.fAF = j2;
            this.fAp = j3;
            this.fAq = j4;
            this.fAr = j5;
        }

        public final String toString() {
            AppMethodBeat.i(58340);
            String format = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[]{Integer.valueOf(this.pid), a.fF(this.fAk), a.fF(this.fAF), a.fF(this.fAp), Long.valueOf(this.fAq), Long.valueOf(this.fAr)});
            AppMethodBeat.o(58340);
            return format;
        }
    }

    static class a implements Serializable {
        long fAk = 0;
        long time = 0;
        int type = 0;

        a(long j, long j2, int i) {
            this.fAk = j;
            this.time = j2;
            this.type = i;
        }

        public final String toString() {
            AppMethodBeat.i(58338);
            String format = String.format("serverTime:%s,time:%s,type:%s", new Object[]{a.fF(this.fAk), a.fF(this.time), Integer.valueOf(this.type)});
            AppMethodBeat.o(58338);
            return format;
        }
    }

    c() {
        AppMethodBeat.i(58344);
        if (this.fAy == null) {
            this.fAy = com.tencent.mm.loader.j.b.eSj + "ProcessDetector";
            File file = new File(this.fAy);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        if (ah.bqo()) {
            this.fAz = this.fAy + "/mm";
            AppMethodBeat.o(58344);
            return;
        }
        if (ah.doE()) {
            this.fAz = this.fAy + "/push";
        }
        AppMethodBeat.o(58344);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A:{Splitter:B:11:0x00b5, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A:{Splitter:B:11:0x00b5, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A:{Splitter:B:11:0x00b5, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A:{Splitter:B:11:0x00b5, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0284 A:{SYNTHETIC, Splitter:B:69:0x0284} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02aa A:{SYNTHETIC, Splitter:B:77:0x02aa} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A:{Splitter:B:11:0x00b5, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:39:0x0188, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ActiveDetector.ProcessDetector", "process detector thread interrupt.thread id:%s", java.lang.Integer.valueOf(android.os.Process.myTid()));
            java.lang.Thread.currentThread().interrupt();
            r15.fAA = false;
     */
    /* JADX WARNING: Missing block: B:45:0x01e4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x01e5, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ActiveDetector.ProcessDetector", "exception,%s", r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:58:0x0224, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ObjectUtil", "Write close exception:" + r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:71:0x0289, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:73:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ObjectUtil", "Write close exception:" + r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:83:0x02b4, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:84:0x02b5, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ObjectUtil", "Write close exception:" + r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        b bVar;
        Exception e;
        Throwable th;
        AppMethodBeat.i(58345);
        clear();
        this.fAw = System.currentTimeMillis();
        this.fAx = this.fAw;
        this.fAt = new d();
        this.fAt.a(Process.myPid(), this.fAw, this.fAx, this.fAs);
        if (this.fAu.fAB.isEmpty()) {
            try {
                bVar = (b) b.x(new FileInputStream(this.fAz));
                if (bVar != null) {
                    bVar.fAC.addAll(this.fAu.fAC);
                    bVar.fAD.addAll(this.fAu.fAD);
                    bVar.fAE.addAll(this.fAu.fAE);
                    this.fAu = bVar;
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.ActiveDetector.ProcessDetector", "%s,read exception:" + e2.getMessage(), this.fAz);
            }
        }
        a(this.fAu);
        this.fAu.fAB.add(this.fAt);
        ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]exist process status data size:%s,send broadcast size:%s, receive broadcast size:%s", Integer.valueOf(this.fAu.fAB.size()), Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
        while (this.fAA && !Thread.currentThread().isInterrupted()) {
            try {
                int myPid = Process.myPid();
                long currentTimeMillis = System.currentTimeMillis();
                d dVar = this.fAt;
                long j = this.fAx;
                int i = this.fAs;
                long j2 = currentTimeMillis - j;
                if (dVar.fAl != i || j2 > 20000) {
                    d b = d.b(myPid, j, currentTimeMillis, i);
                    if (dVar.fAl != i) {
                        b.fAn = true;
                    }
                    if (j2 > 20000) {
                        b.fAm = false;
                    }
                    dVar = b;
                } else {
                    dVar.a(myPid, j, currentTimeMillis, i);
                    dVar = null;
                }
                if (dVar != null) {
                    ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]create process status:%s", dVar);
                    this.fAt = dVar;
                    this.fAu.fAB.add(this.fAt);
                } else {
                    ab.d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]current process status:%s", this.fAt);
                }
                ab.d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]send broadcast:%s,receive broadcast:%s", this.fAu.fAC, this.fAu.fAD);
                this.fAx = currentTimeMillis;
                if (this.fAv <= 0 || currentTimeMillis - this.fAv > 180000) {
                    this.fAv = currentTimeMillis;
                    if (!(this.fAu == null || this.fAu.fAB == null || this.fAu.fAB.isEmpty())) {
                        ab.d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]save data to %s", this.fAz);
                        bVar = this.fAu;
                        FileOutputStream fileOutputStream = new FileOutputStream(this.fAz);
                        if (bVar != null) {
                            ObjectOutputStream objectOutputStream;
                            try {
                                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                try {
                                    objectOutputStream.writeObject(bVar);
                                    objectOutputStream.flush();
                                    objectOutputStream.close();
                                } catch (Exception e3) {
                                    e2 = e3;
                                    try {
                                        ab.w("MicroMsg.ObjectUtil", "Write exception:" + e2.getMessage());
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", this.fAt);
                                        ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
                                        Thread.sleep(10000);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        AppMethodBeat.o(58345);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                objectOutputStream = null;
                                ab.w("MicroMsg.ObjectUtil", "Write exception:" + e2.getMessage());
                                if (objectOutputStream != null) {
                                }
                                ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", this.fAt);
                                ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
                                Thread.sleep(10000);
                            } catch (Throwable th3) {
                                th = th3;
                                objectOutputStream = null;
                                if (objectOutputStream != null) {
                                }
                                AppMethodBeat.o(58345);
                                throw th;
                            }
                        }
                    }
                    ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", this.fAt);
                    ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
                }
            } catch (Exception e22) {
                ab.e("MicroMsg.ActiveDetector.ProcessDetector", "%s,write exception:" + e22.getMessage(), this.fAz);
            } catch (InterruptedException e5) {
            }
            Thread.sleep(10000);
        }
        AppMethodBeat.o(58345);
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        this.fAA = false;
        this.fAw = 0;
        this.fAx = 0;
    }

    private static void a(b bVar) {
        AppMethodBeat.i(58346);
        if (bVar == null) {
            AppMethodBeat.o(58346);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            for (d dVar : bVar.fAB) {
                if (dVar != null) {
                    if (currentTimeMillis - dVar.endTime < 86400000) {
                        break;
                    }
                    bVar.fAB.remove(dVar);
                } else {
                    bVar.fAB.remove(dVar);
                }
            }
            for (a aVar : bVar.fAC) {
                if (aVar != null) {
                    if (currentTimeMillis - aVar.time < 86400000) {
                        break;
                    }
                    bVar.fAC.remove(aVar);
                } else {
                    bVar.fAC.remove(aVar);
                }
            }
            for (a aVar2 : bVar.fAD) {
                if (aVar2 != null) {
                    if (currentTimeMillis - aVar2.time < 86400000) {
                        break;
                    }
                    bVar.fAD.remove(aVar2);
                } else {
                    bVar.fAD.remove(aVar2);
                }
            }
            for (c cVar : bVar.fAE) {
                if (cVar != null) {
                    if (currentTimeMillis - cVar.fAF < 86400000) {
                        break;
                    }
                    bVar.fAE.remove(cVar);
                } else {
                    bVar.fAE.remove(cVar);
                }
            }
            AppMethodBeat.o(58346);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", e, "check data exception.", new Object[0]);
            AppMethodBeat.o(58346);
        }
    }
}
