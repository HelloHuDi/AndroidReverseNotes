package com.tencent.p177mm.p188an;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.mm.an.c */
final class C41755c implements Runnable {
    boolean fAA = false;
    int fAs = 0;
    private C1240d fAt = null;
    C8952b fAu = new C8952b();
    private long fAv = 0;
    private long fAw = 0;
    private long fAx = 0;
    String fAy = null;
    private String fAz = null;

    /* renamed from: com.tencent.mm.an.c$d */
    public static class C1240d implements Serializable {
        long endTime = 0;
        long fAG = 0;
        int fAl = 0;
        boolean fAm = true;
        boolean fAn = false;
        int pid = 0;
        long startTime = 0;

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo4517a(int i, long j, long j2, int i2) {
            AppMethodBeat.m2504i(58341);
            this.pid = i;
            if (this.startTime <= 0) {
                this.startTime = j;
                this.fAG = C1839cb.aaD();
            }
            this.endTime = j2;
            this.fAl = i2;
            AppMethodBeat.m2505o(58341);
        }

        /* renamed from: b */
        static C1240d m2675b(int i, long j, long j2, int i2) {
            AppMethodBeat.m2504i(58342);
            C1240d c1240d = new C1240d();
            c1240d.pid = i;
            c1240d.startTime = j;
            c1240d.endTime = j2;
            c1240d.fAl = i2;
            AppMethodBeat.m2505o(58342);
            return c1240d;
        }

        public final String toString() {
            AppMethodBeat.m2504i(58343);
            String format = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[]{Integer.valueOf(this.pid), C41753a.m73605fF(this.fAG), C41753a.m73605fF(this.startTime), C41753a.m73605fF(this.endTime), Boolean.valueOf(this.fAm), Boolean.valueOf(this.fAn), Integer.valueOf(this.fAl)});
            AppMethodBeat.m2505o(58343);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.an.c$b */
    static class C8952b implements Serializable {
        final List<C1240d> fAB = new CopyOnWriteArrayList();
        final List<C41756a> fAC = new CopyOnWriteArrayList();
        final List<C41756a> fAD = new CopyOnWriteArrayList();
        final List<C8953c> fAE = new CopyOnWriteArrayList();

        C8952b() {
            AppMethodBeat.m2504i(58339);
            AppMethodBeat.m2505o(58339);
        }
    }

    /* renamed from: com.tencent.mm.an.c$c */
    static class C8953c implements Serializable {
        long fAF = 0;
        long fAk = 0;
        long fAp = 0;
        long fAq = 0;
        long fAr = 0;
        int pid = 0;

        C8953c(int i, long j, long j2, long j3, long j4, long j5) {
            this.pid = i;
            this.fAk = j;
            this.fAF = j2;
            this.fAp = j3;
            this.fAq = j4;
            this.fAr = j5;
        }

        public final String toString() {
            AppMethodBeat.m2504i(58340);
            String format = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[]{Integer.valueOf(this.pid), C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.fAF), C41753a.m73605fF(this.fAp), Long.valueOf(this.fAq), Long.valueOf(this.fAr)});
            AppMethodBeat.m2505o(58340);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.an.c$a */
    static class C41756a implements Serializable {
        long fAk = 0;
        long time = 0;
        int type = 0;

        C41756a(long j, long j2, int i) {
            this.fAk = j;
            this.time = j2;
            this.type = i;
        }

        public final String toString() {
            AppMethodBeat.m2504i(58338);
            String format = String.format("serverTime:%s,time:%s,type:%s", new Object[]{C41753a.m73605fF(this.fAk), C41753a.m73605fF(this.time), Integer.valueOf(this.type)});
            AppMethodBeat.m2505o(58338);
            return format;
        }
    }

    C41755c() {
        AppMethodBeat.m2504i(58344);
        if (this.fAy == null) {
            this.fAy = C1761b.eSj + "ProcessDetector";
            File file = new File(this.fAy);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        if (C4996ah.bqo()) {
            this.fAz = this.fAy + "/mm";
            AppMethodBeat.m2505o(58344);
            return;
        }
        if (C4996ah.doE()) {
            this.fAz = this.fAy + "/push";
        }
        AppMethodBeat.m2505o(58344);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "process detector thread interrupt.thread id:%s", java.lang.Integer.valueOf(android.os.Process.myTid()));
            java.lang.Thread.currentThread().interrupt();
            r15.fAA = false;
     */
    /* JADX WARNING: Missing block: B:45:0x01e4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x01e5, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.ActiveDetector.ProcessDetector", "exception,%s", r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:58:0x0224, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.ObjectUtil", "Write close exception:" + r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:71:0x0289, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:73:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.ObjectUtil", "Write close exception:" + r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:83:0x02b4, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:84:0x02b5, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.ObjectUtil", "Write close exception:" + r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        C8952b c8952b;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(58345);
        clear();
        this.fAw = System.currentTimeMillis();
        this.fAx = this.fAw;
        this.fAt = new C1240d();
        this.fAt.mo4517a(Process.myPid(), this.fAw, this.fAx, this.fAs);
        if (this.fAu.fAB.isEmpty()) {
            try {
                c8952b = (C8952b) C41754b.m73609x(new FileInputStream(this.fAz));
                if (c8952b != null) {
                    c8952b.fAC.addAll(this.fAu.fAC);
                    c8952b.fAD.addAll(this.fAu.fAD);
                    c8952b.fAE.addAll(this.fAu.fAE);
                    this.fAu = c8952b;
                }
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.ActiveDetector.ProcessDetector", "%s,read exception:" + e2.getMessage(), this.fAz);
            }
        }
        C41755c.m73610a(this.fAu);
        this.fAu.fAB.add(this.fAt);
        C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]exist process status data size:%s,send broadcast size:%s, receive broadcast size:%s", Integer.valueOf(this.fAu.fAB.size()), Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
        while (this.fAA && !Thread.currentThread().isInterrupted()) {
            try {
                int myPid = Process.myPid();
                long currentTimeMillis = System.currentTimeMillis();
                C1240d c1240d = this.fAt;
                long j = this.fAx;
                int i = this.fAs;
                long j2 = currentTimeMillis - j;
                if (c1240d.fAl != i || j2 > 20000) {
                    C1240d b = C1240d.m2675b(myPid, j, currentTimeMillis, i);
                    if (c1240d.fAl != i) {
                        b.fAn = true;
                    }
                    if (j2 > 20000) {
                        b.fAm = false;
                    }
                    c1240d = b;
                } else {
                    c1240d.mo4517a(myPid, j, currentTimeMillis, i);
                    c1240d = null;
                }
                if (c1240d != null) {
                    C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]create process status:%s", c1240d);
                    this.fAt = c1240d;
                    this.fAu.fAB.add(this.fAt);
                } else {
                    C4990ab.m7411d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]current process status:%s", this.fAt);
                }
                C4990ab.m7411d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]send broadcast:%s,receive broadcast:%s", this.fAu.fAC, this.fAu.fAD);
                this.fAx = currentTimeMillis;
                if (this.fAv <= 0 || currentTimeMillis - this.fAv > 180000) {
                    this.fAv = currentTimeMillis;
                    if (!(this.fAu == null || this.fAu.fAB == null || this.fAu.fAB.isEmpty())) {
                        C4990ab.m7411d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]save data to %s", this.fAz);
                        c8952b = this.fAu;
                        FileOutputStream fileOutputStream = new FileOutputStream(this.fAz);
                        if (c8952b != null) {
                            ObjectOutputStream objectOutputStream;
                            try {
                                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                try {
                                    objectOutputStream.writeObject(c8952b);
                                    objectOutputStream.flush();
                                    objectOutputStream.close();
                                } catch (Exception e3) {
                                    e2 = e3;
                                    try {
                                        C4990ab.m7420w("MicroMsg.ObjectUtil", "Write exception:" + e2.getMessage());
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", this.fAt);
                                        C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
                                        Thread.sleep(10000);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        AppMethodBeat.m2505o(58345);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                objectOutputStream = null;
                                C4990ab.m7420w("MicroMsg.ObjectUtil", "Write exception:" + e2.getMessage());
                                if (objectOutputStream != null) {
                                }
                                C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", this.fAt);
                                C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
                                Thread.sleep(10000);
                            } catch (Throwable th3) {
                                th = th3;
                                objectOutputStream = null;
                                if (objectOutputStream != null) {
                                }
                                AppMethodBeat.m2505o(58345);
                                throw th;
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", this.fAt);
                    C4990ab.m7417i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", Integer.valueOf(this.fAu.fAC.size()), Integer.valueOf(this.fAu.fAD.size()));
                }
            } catch (Exception e22) {
                C4990ab.m7413e("MicroMsg.ActiveDetector.ProcessDetector", "%s,write exception:" + e22.getMessage(), this.fAz);
            } catch (InterruptedException e5) {
            }
            Thread.sleep(10000);
        }
        AppMethodBeat.m2505o(58345);
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        this.fAA = false;
        this.fAw = 0;
        this.fAx = 0;
    }

    /* renamed from: a */
    private static void m73610a(C8952b c8952b) {
        AppMethodBeat.m2504i(58346);
        if (c8952b == null) {
            AppMethodBeat.m2505o(58346);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            for (C1240d c1240d : c8952b.fAB) {
                if (c1240d != null) {
                    if (currentTimeMillis - c1240d.endTime < 86400000) {
                        break;
                    }
                    c8952b.fAB.remove(c1240d);
                } else {
                    c8952b.fAB.remove(c1240d);
                }
            }
            for (C41756a c41756a : c8952b.fAC) {
                if (c41756a != null) {
                    if (currentTimeMillis - c41756a.time < 86400000) {
                        break;
                    }
                    c8952b.fAC.remove(c41756a);
                } else {
                    c8952b.fAC.remove(c41756a);
                }
            }
            for (C41756a c41756a2 : c8952b.fAD) {
                if (c41756a2 != null) {
                    if (currentTimeMillis - c41756a2.time < 86400000) {
                        break;
                    }
                    c8952b.fAD.remove(c41756a2);
                } else {
                    c8952b.fAD.remove(c41756a2);
                }
            }
            for (C8953c c8953c : c8952b.fAE) {
                if (c8953c != null) {
                    if (currentTimeMillis - c8953c.fAF < 86400000) {
                        break;
                    }
                    c8952b.fAE.remove(c8953c);
                } else {
                    c8952b.fAE.remove(c8953c);
                }
            }
            AppMethodBeat.m2505o(58346);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", e, "check data exception.", new Object[0]);
            AppMethodBeat.m2505o(58346);
        }
    }
}
