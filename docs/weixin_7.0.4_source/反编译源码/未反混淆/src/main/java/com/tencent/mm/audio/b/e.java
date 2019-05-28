package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    AudioRecord cpL;
    int cpX;
    boolean cpx;
    private int cqa = 12800;
    b cqb = new b();
    com.tencent.mm.compatible.b.b cqc = null;
    com.tencent.mm.audio.b.c.a cqd;
    final Object cqe = new Object();
    final byte[] cqf = new byte[0];
    final Object cqg = new Object();
    Timer cqh = null;
    boolean cqi = false;
    private boolean cqj = false;
    boolean mIsMute = false;
    int mStatus = 0;

    class a extends TimerTask {
        private int cql = (e.this.cpX * 2);
        private int cqm = e.this.cpX;
        byte[] cqn = new byte[this.cql];

        a() {
            AppMethodBeat.i(55750);
            AppMethodBeat.o(55750);
        }

        public final void run() {
            AppMethodBeat.i(55751);
            if (!e.this.mIsPause) {
                int EP = (int) (0.8d * ((double) e.this.EP()));
                if (EP < e.this.cpX * 8) {
                    EP = e.this.cpX * 8;
                }
                if (e.this.EQ() > EP) {
                    EP = 8;
                } else {
                    EP = 1;
                }
                for (int i = 0; i < EP; i++) {
                    int x = e.this.x(this.cqn, this.cqm);
                    if (e.this.cqd != null && x == 0) {
                        e.this.cqd.u(this.cqn, this.cqm);
                    }
                }
            }
            AppMethodBeat.o(55751);
        }
    }

    final class b implements Runnable {
        volatile c cqo;

        b() {
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
            AppMethodBeat.i(55752);
            ab.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", Integer.valueOf(e.this.cpX));
            if (-123456789 != e.this.cpB) {
                ab.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.cpB);
                Process.setThreadPriority(e.this.cpB);
            }
            synchronized (e.this.cqg) {
                try {
                    ab.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", Long.valueOf(Thread.currentThread().getId()), e.this.cqg);
                    if (1 != e.this.mStatus) {
                        ab.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
                    } else {
                        e.this.mStatus = 2;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(55752);
                }
            }
            byte[] bArr;
            int read;
            return;
            try {
                if (2 != e.this.mStatus) {
                    if (this.cqo != null) {
                        this.cqo.finish();
                    }
                    ab.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
                    AppMethodBeat.o(55752);
                    return;
                }
                if (e.this.cpL == null) {
                    ab.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
                    synchronized (e.this.cqg) {
                        try {
                            e.this.mStatus = 3;
                        } catch (Throwable th) {
                            AppMethodBeat.o(55752);
                        }
                    }
                }
                if (e.this.cpx) {
                    bArr = new byte[e.this.cpX];
                }
                e.this.cqp++;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                read = e.this.cpL.read(bArr, 0, e.this.cpX);
                if (2 == e.this.mStatus) {
                    if (e.this.cpT != null) {
                        e.this.cpT.d(read, bArr);
                    }
                    if (e.this.cpX != read) {
                        ab.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(read)));
                    }
                    if (read < e.this.cpX) {
                        ab.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (e.this.cqd != null && read > 0) {
                        if (read > bArr.length) {
                            read = bArr.length;
                        }
                        if (e.this.cqc == null) {
                            if (e.this.mIsMute) {
                                Arrays.fill(bArr, 0, read, (byte) 0);
                            }
                            com.tencent.mm.compatible.b.b bVar = e.this.cqc;
                            if (read > 0) {
                                int i;
                                if (bVar.eoO) {
                                    bVar.eoP.lock();
                                }
                                if (bVar.eoM == bVar.eoN) {
                                    i = bVar.eoJ;
                                } else if ((bVar.eoN + 1) % bVar.eoJ == bVar.eoM) {
                                    i = 0;
                                } else {
                                    if (bVar.eoM < bVar.eoN) {
                                        bVar.eoK = bVar.eoN - bVar.eoM;
                                    } else if (bVar.eoM > bVar.eoN) {
                                        bVar.eoK = (bVar.eoN + bVar.eoJ) - bVar.eoM;
                                    }
                                    if (bVar.eoO) {
                                        bVar.eoP.unlock();
                                    }
                                    i = bVar.eoJ - bVar.eoK;
                                }
                                if (read <= i) {
                                    if ((bVar.eoN + read) % bVar.eoJ == bVar.eoM) {
                                        read = -1;
                                    } else {
                                        if (bVar.eoO) {
                                            bVar.eoP.lock();
                                        }
                                        if (bVar.eoM >= bVar.eoN || read <= bVar.eoJ - bVar.eoN) {
                                            System.arraycopy(bArr, 0, bVar.eoL, bVar.eoN, read);
                                            bVar.eoN = (read + bVar.eoN) % bVar.eoJ;
                                        } else {
                                            System.arraycopy(bArr, 0, bVar.eoL, bVar.eoN, bVar.eoJ - bVar.eoN);
                                            System.arraycopy(bArr, bVar.eoJ - bVar.eoN, bVar.eoL, 0, read - (bVar.eoJ - bVar.eoN));
                                            bVar.eoN = read - (bVar.eoJ - bVar.eoN);
                                            bVar.eoN %= bVar.eoJ;
                                        }
                                        if (bVar.eoO) {
                                            bVar.eoP.unlock();
                                        }
                                        read = 0;
                                    }
                                    if (read == 0) {
                                        ab.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", Integer.valueOf(read), Integer.valueOf(e.this.cqc.KH()));
                                    }
                                }
                            }
                            read = -1;
                            if (read == 0) {
                            }
                        } else if (e.this.cqd != null) {
                            if (e.this.mIsMute) {
                                Arrays.fill(bArr, 0, read, (byte) 0);
                            }
                            e.this.cqd.u(bArr, read);
                        }
                    }
                }
                if (this.cqo != null) {
                }
                ab.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
                AppMethodBeat.o(55752);
                return;
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.o(55752);
                }
            }
            if (read > bArr.length) {
            }
            if (e.this.cqc == null) {
            }
        }
    }

    interface c {
        void finish();
    }

    public e(AudioRecord audioRecord, boolean z, int i, com.tencent.mm.audio.b.c.a aVar, boolean z2) {
        AppMethodBeat.i(55753);
        this.cpL = audioRecord;
        this.cpx = z;
        this.cpX = i;
        this.cqd = aVar;
        this.cqj = z2;
        AppMethodBeat.o(55753);
    }

    public final boolean EL() {
        boolean z = true;
        AppMethodBeat.i(55754);
        ab.i("MicroMsg.RecordModeAsyncRead", JsApiStartRecordVoice.NAME);
        synchronized (this.cqg) {
            try {
                this.mStatus = 1;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(55754);
            }
        }
        ab.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", d.xDG.dqb());
        d.f(this.cqb, "RecordModeAsyncRead_record");
        if (true == this.cqj) {
            boolean z2;
            this.cqc = new com.tencent.mm.compatible.b.b();
            if (this.cqc == null) {
                ab.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.cqa = this.cpX * 20;
                ab.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.cqa);
                com.tencent.mm.compatible.b.b bVar = this.cqc;
                int i = this.cqa;
                if (i <= 0) {
                    z2 = true;
                } else {
                    bVar.eoL = new byte[i];
                    if (bVar.eoL == null) {
                        z2 = true;
                    } else {
                        bVar.eoJ = i;
                        if (bVar.eoO) {
                            bVar.eoP = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    ab.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.cqi || this.cqh != null) {
                    ab.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.cqi);
                } else {
                    this.cqh = new Timer();
                    if (this.cqh != null) {
                        z = false;
                    }
                }
                if (z) {
                    ab.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
                    AppMethodBeat.o(55754);
                    return false;
                }
                this.cqh.scheduleAtFixedRate(new a(), 60, 20);
                this.cqi = true;
            } else {
                ab.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        AppMethodBeat.o(55754);
        return true;
    }

    public final void stopRecord() {
        AppMethodBeat.i(55755);
        ab.i("MicroMsg.RecordModeAsyncRead", JsApiStopRecordVoice.NAME);
        synchronized (this.cqg) {
            try {
                this.mStatus = 3;
                this.cqb.cqo = new c() {
                    public final void finish() {
                        AppMethodBeat.i(55749);
                        e.this.cqb.cqo = null;
                        ab.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
                        if (e.this.cqc != null) {
                            if (e.this.cqh != null) {
                                e.this.cqh.cancel();
                                e.this.cqh = null;
                            }
                            com.tencent.mm.compatible.b.b bVar = e.this.cqc;
                            bVar.eoJ = 0;
                            bVar.eoK = 0;
                            bVar.eoM = 0;
                            bVar.eoN = 0;
                            bVar.eoL = null;
                            synchronized (e.this.cqe) {
                                try {
                                    e.this.cqc = null;
                                    e.this.cqd = null;
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.o(55749);
                                    }
                                }
                            }
                            e.this.cqi = false;
                            e.this.cqc = null;
                        }
                        AppMethodBeat.o(55749);
                    }
                };
            } finally {
                while (true) {
                }
                AppMethodBeat.o(55755);
            }
        }
        synchronized (this.cqf) {
            try {
                this.cqf.notify();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55755);
                }
            }
        }
    }

    public final int EP() {
        synchronized (this.cqe) {
            if (this.cqc != null) {
                int i = this.cqc.eoJ;
                return i;
            }
            return -1;
        }
    }

    public final int EQ() {
        int KH;
        AppMethodBeat.i(55756);
        synchronized (this.cqe) {
            try {
                if (this.cqc != null) {
                    KH = this.cqc.KH();
                } else {
                    AppMethodBeat.o(55756);
                    return -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(55756);
            }
        }
        return KH;
    }

    public final int x(byte[] bArr, int i) {
        int i2 = -1;
        AppMethodBeat.i(55757);
        synchronized (this.cqe) {
            try {
                if (this.cqc != null) {
                    com.tencent.mm.compatible.b.b bVar = this.cqc;
                    if (i > 0 && i <= bVar.KH() && bArr != null) {
                        if (bVar.eoM != bVar.eoN) {
                            if (bVar.eoO) {
                                bVar.eoP.lock();
                            }
                            if (bVar.eoM < bVar.eoN) {
                                System.arraycopy(bVar.eoL, bVar.eoM, bArr, 0, i);
                                bVar.eoM += i;
                            } else if (i <= bVar.eoJ - bVar.eoM) {
                                System.arraycopy(bVar.eoL, bVar.eoM, bArr, 0, i);
                                bVar.eoM += i;
                            } else {
                                System.arraycopy(bVar.eoL, bVar.eoM, bArr, 0, bVar.eoJ - bVar.eoM);
                                System.arraycopy(bVar.eoL, 0, bArr, bVar.eoJ - bVar.eoM, i - (bVar.eoJ - bVar.eoM));
                                bVar.eoM = i - (bVar.eoJ - bVar.eoM);
                            }
                            if (bVar.eoO) {
                                bVar.eoP.unlock();
                            }
                            i2 = 0;
                        }
                    }
                } else {
                    AppMethodBeat.o(55757);
                }
            } finally {
                AppMethodBeat.o(55757);
            }
        }
        return i2;
    }

    public final void bs(boolean z) {
        this.mIsMute = z;
    }
}
