package com.tencent.p177mm.audio.p195b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.compatible.p219b.C41934b;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.audio.b.e */
public final class C9044e extends C32303f {
    AudioRecord cpL;
    int cpX;
    boolean cpx;
    private int cqa = 12800;
    C9043b cqb = new C9043b();
    C41934b cqc = null;
    C1293a cqd;
    final Object cqe = new Object();
    final byte[] cqf = new byte[0];
    final Object cqg = new Object();
    Timer cqh = null;
    boolean cqi = false;
    private boolean cqj = false;
    boolean mIsMute = false;
    int mStatus = 0;

    /* renamed from: com.tencent.mm.audio.b.e$a */
    class C9042a extends TimerTask {
        private int cql = (C9044e.this.cpX * 2);
        private int cqm = C9044e.this.cpX;
        byte[] cqn = new byte[this.cql];

        C9042a() {
            AppMethodBeat.m2504i(55750);
            AppMethodBeat.m2505o(55750);
        }

        public final void run() {
            AppMethodBeat.m2504i(55751);
            if (!C9044e.this.mIsPause) {
                int EP = (int) (0.8d * ((double) C9044e.this.mo20488EP()));
                if (EP < C9044e.this.cpX * 8) {
                    EP = C9044e.this.cpX * 8;
                }
                if (C9044e.this.mo20489EQ() > EP) {
                    EP = 8;
                } else {
                    EP = 1;
                }
                for (int i = 0; i < EP; i++) {
                    int x = C9044e.this.mo20490x(this.cqn, this.cqm);
                    if (C9044e.this.cqd != null && x == 0) {
                        C9044e.this.cqd.mo4601u(this.cqn, this.cqm);
                    }
                }
            }
            AppMethodBeat.m2505o(55751);
        }
    }

    /* renamed from: com.tencent.mm.audio.b.e$b */
    final class C9043b implements Runnable {
        volatile C9045c cqo;

        C9043b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:134:0x00a1 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01a0  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0174  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0265  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x017b  */
        /* JADX WARNING: Missing block: B:13:0x009b, code skipped:
            r0 = new byte[r13.cqk.cpX];
     */
        /* JADX WARNING: Missing block: B:15:0x00a5, code skipped:
            if (2 != r13.cqk.mStatus) goto L_0x00c0;
     */
        /* JADX WARNING: Missing block: B:16:0x00a7, code skipped:
            r1 = r13.cqk.cqf;
     */
        /* JADX WARNING: Missing block: B:17:0x00ab, code skipped:
            monitor-enter(r1);
     */
        /* JADX WARNING: Missing block: B:20:0x00b0, code skipped:
            if (r13.cqk.mIsPause == false) goto L_0x00dc;
     */
        /* JADX WARNING: Missing block: B:22:?, code skipped:
            r13.cqk.cqf.wait();
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(55752);
            C4990ab.m7417i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", Integer.valueOf(C9044e.this.cpX));
            if (-123456789 != C9044e.this.cpB) {
                C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "set priority to " + C9044e.this.cpB);
                Process.setThreadPriority(C9044e.this.cpB);
            }
            synchronized (C9044e.this.cqg) {
                try {
                    C4990ab.m7417i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", Long.valueOf(Thread.currentThread().getId()), C9044e.this.cqg);
                    if (1 != C9044e.this.mStatus) {
                        C4990ab.m7412e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + C9044e.this.mStatus);
                    } else {
                        C9044e.this.mStatus = 2;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(55752);
                }
            }
            byte[] bArr;
            int read;
            return;
            try {
                if (2 != C9044e.this.mStatus) {
                    if (this.cqo != null) {
                        this.cqo.finish();
                    }
                    C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
                    AppMethodBeat.m2505o(55752);
                    return;
                }
                if (C9044e.this.cpL == null) {
                    C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
                    synchronized (C9044e.this.cqg) {
                        try {
                            C9044e.this.mStatus = 3;
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(55752);
                        }
                    }
                }
                if (C9044e.this.cpx) {
                    bArr = new byte[C9044e.this.cpX];
                }
                C9044e.this.cqp++;
                C1446a c1446a = new C1446a();
                read = C9044e.this.cpL.read(bArr, 0, C9044e.this.cpX);
                if (2 == C9044e.this.mStatus) {
                    if (C9044e.this.cpT != null) {
                        C9044e.this.cpT.mo4589d(read, bArr);
                    }
                    if (C9044e.this.cpX != read) {
                        C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(read)));
                    }
                    if (read < C9044e.this.cpX) {
                        C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (C9044e.this.cqd != null && read > 0) {
                        if (read > bArr.length) {
                            read = bArr.length;
                        }
                        if (C9044e.this.cqc == null) {
                            if (C9044e.this.mIsMute) {
                                Arrays.fill(bArr, 0, read, (byte) 0);
                            }
                            C41934b c41934b = C9044e.this.cqc;
                            if (read > 0) {
                                int i;
                                if (c41934b.eoO) {
                                    c41934b.eoP.lock();
                                }
                                if (c41934b.eoM == c41934b.eoN) {
                                    i = c41934b.eoJ;
                                } else if ((c41934b.eoN + 1) % c41934b.eoJ == c41934b.eoM) {
                                    i = 0;
                                } else {
                                    if (c41934b.eoM < c41934b.eoN) {
                                        c41934b.eoK = c41934b.eoN - c41934b.eoM;
                                    } else if (c41934b.eoM > c41934b.eoN) {
                                        c41934b.eoK = (c41934b.eoN + c41934b.eoJ) - c41934b.eoM;
                                    }
                                    if (c41934b.eoO) {
                                        c41934b.eoP.unlock();
                                    }
                                    i = c41934b.eoJ - c41934b.eoK;
                                }
                                if (read <= i) {
                                    if ((c41934b.eoN + read) % c41934b.eoJ == c41934b.eoM) {
                                        read = -1;
                                    } else {
                                        if (c41934b.eoO) {
                                            c41934b.eoP.lock();
                                        }
                                        if (c41934b.eoM >= c41934b.eoN || read <= c41934b.eoJ - c41934b.eoN) {
                                            System.arraycopy(bArr, 0, c41934b.eoL, c41934b.eoN, read);
                                            c41934b.eoN = (read + c41934b.eoN) % c41934b.eoJ;
                                        } else {
                                            System.arraycopy(bArr, 0, c41934b.eoL, c41934b.eoN, c41934b.eoJ - c41934b.eoN);
                                            System.arraycopy(bArr, c41934b.eoJ - c41934b.eoN, c41934b.eoL, 0, read - (c41934b.eoJ - c41934b.eoN));
                                            c41934b.eoN = read - (c41934b.eoJ - c41934b.eoN);
                                            c41934b.eoN %= c41934b.eoJ;
                                        }
                                        if (c41934b.eoO) {
                                            c41934b.eoP.unlock();
                                        }
                                        read = 0;
                                    }
                                    if (read == 0) {
                                        C4990ab.m7413e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", Integer.valueOf(read), Integer.valueOf(C9044e.this.cqc.mo67572KH()));
                                    }
                                }
                            }
                            read = -1;
                            if (read == 0) {
                            }
                        } else if (C9044e.this.cqd != null) {
                            if (C9044e.this.mIsMute) {
                                Arrays.fill(bArr, 0, read, (byte) 0);
                            }
                            C9044e.this.cqd.mo4601u(bArr, read);
                        }
                    }
                }
                if (this.cqo != null) {
                }
                C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
                AppMethodBeat.m2505o(55752);
                return;
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.m2505o(55752);
                }
            }
            if (read > bArr.length) {
            }
            if (C9044e.this.cqc == null) {
            }
        }
    }

    /* renamed from: com.tencent.mm.audio.b.e$c */
    interface C9045c {
        void finish();
    }

    /* renamed from: com.tencent.mm.audio.b.e$1 */
    class C90461 implements C9045c {
        C90461() {
        }

        public final void finish() {
            AppMethodBeat.m2504i(55749);
            C9044e.this.cqb.cqo = null;
            C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
            if (C9044e.this.cqc != null) {
                if (C9044e.this.cqh != null) {
                    C9044e.this.cqh.cancel();
                    C9044e.this.cqh = null;
                }
                C41934b c41934b = C9044e.this.cqc;
                c41934b.eoJ = 0;
                c41934b.eoK = 0;
                c41934b.eoM = 0;
                c41934b.eoN = 0;
                c41934b.eoL = null;
                synchronized (C9044e.this.cqe) {
                    try {
                        C9044e.this.cqc = null;
                        C9044e.this.cqd = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(55749);
                        }
                    }
                }
                C9044e.this.cqi = false;
                C9044e.this.cqc = null;
            }
            AppMethodBeat.m2505o(55749);
        }
    }

    public C9044e(AudioRecord audioRecord, boolean z, int i, C1293a c1293a, boolean z2) {
        AppMethodBeat.m2504i(55753);
        this.cpL = audioRecord;
        this.cpx = z;
        this.cpX = i;
        this.cqd = c1293a;
        this.cqj = z2;
        AppMethodBeat.m2505o(55753);
    }

    /* renamed from: EL */
    public final boolean mo20481EL() {
        boolean z = true;
        AppMethodBeat.m2504i(55754);
        C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", JsApiStartRecordVoice.NAME);
        synchronized (this.cqg) {
            try {
                this.mStatus = 1;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(55754);
            }
        }
        C4990ab.m7417i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", C7305d.xDG.dqb());
        C7305d.m12298f(this.cqb, "RecordModeAsyncRead_record");
        if (true == this.cqj) {
            boolean z2;
            this.cqc = new C41934b();
            if (this.cqc == null) {
                C4990ab.m7412e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.cqa = this.cpX * 20;
                C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.cqa);
                C41934b c41934b = this.cqc;
                int i = this.cqa;
                if (i <= 0) {
                    z2 = true;
                } else {
                    c41934b.eoL = new byte[i];
                    if (c41934b.eoL == null) {
                        z2 = true;
                    } else {
                        c41934b.eoJ = i;
                        if (c41934b.eoO) {
                            c41934b.eoP = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    C4990ab.m7412e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.cqi || this.cqh != null) {
                    C4990ab.m7420w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.cqi);
                } else {
                    this.cqh = new Timer();
                    if (this.cqh != null) {
                        z = false;
                    }
                }
                if (z) {
                    C4990ab.m7412e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
                    AppMethodBeat.m2505o(55754);
                    return false;
                }
                this.cqh.scheduleAtFixedRate(new C9042a(), 60, 20);
                this.cqi = true;
            } else {
                C4990ab.m7412e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        AppMethodBeat.m2505o(55754);
        return true;
    }

    public final void stopRecord() {
        AppMethodBeat.m2504i(55755);
        C4990ab.m7416i("MicroMsg.RecordModeAsyncRead", JsApiStopRecordVoice.NAME);
        synchronized (this.cqg) {
            try {
                this.mStatus = 3;
                this.cqb.cqo = new C90461();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(55755);
            }
        }
        synchronized (this.cqf) {
            try {
                this.cqf.notify();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55755);
                }
            }
        }
    }

    /* renamed from: EP */
    public final int mo20488EP() {
        synchronized (this.cqe) {
            if (this.cqc != null) {
                int i = this.cqc.eoJ;
                return i;
            }
            return -1;
        }
    }

    /* renamed from: EQ */
    public final int mo20489EQ() {
        int KH;
        AppMethodBeat.m2504i(55756);
        synchronized (this.cqe) {
            try {
                if (this.cqc != null) {
                    KH = this.cqc.mo67572KH();
                } else {
                    AppMethodBeat.m2505o(55756);
                    return -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(55756);
            }
        }
        return KH;
    }

    /* renamed from: x */
    public final int mo20490x(byte[] bArr, int i) {
        int i2 = -1;
        AppMethodBeat.m2504i(55757);
        synchronized (this.cqe) {
            try {
                if (this.cqc != null) {
                    C41934b c41934b = this.cqc;
                    if (i > 0 && i <= c41934b.mo67572KH() && bArr != null) {
                        if (c41934b.eoM != c41934b.eoN) {
                            if (c41934b.eoO) {
                                c41934b.eoP.lock();
                            }
                            if (c41934b.eoM < c41934b.eoN) {
                                System.arraycopy(c41934b.eoL, c41934b.eoM, bArr, 0, i);
                                c41934b.eoM += i;
                            } else if (i <= c41934b.eoJ - c41934b.eoM) {
                                System.arraycopy(c41934b.eoL, c41934b.eoM, bArr, 0, i);
                                c41934b.eoM += i;
                            } else {
                                System.arraycopy(c41934b.eoL, c41934b.eoM, bArr, 0, c41934b.eoJ - c41934b.eoM);
                                System.arraycopy(c41934b.eoL, 0, bArr, c41934b.eoJ - c41934b.eoM, i - (c41934b.eoJ - c41934b.eoM));
                                c41934b.eoM = i - (c41934b.eoJ - c41934b.eoM);
                            }
                            if (c41934b.eoO) {
                                c41934b.eoP.unlock();
                            }
                            i2 = 0;
                        }
                    }
                } else {
                    AppMethodBeat.m2505o(55757);
                }
            } finally {
                AppMethodBeat.m2505o(55757);
            }
        }
        return i2;
    }

    /* renamed from: bs */
    public final void mo20482bs(boolean z) {
        this.mIsMute = z;
    }
}
