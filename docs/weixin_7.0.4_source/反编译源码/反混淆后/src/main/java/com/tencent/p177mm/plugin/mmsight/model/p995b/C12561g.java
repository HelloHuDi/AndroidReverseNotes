package com.tencent.p177mm.plugin.mmsight.model.p995b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.model.b.g */
public final class C12561g {
    int bitrate;
    boolean cFy = false;
    int eTi;
    int eTj;
    int eTk;
    Thread eVR;
    int frameCount = 0;
    int fzU;
    int fzV;
    int gLw;
    int gLx;
    C12562a oxv;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.b.g$a */
    class C12562a implements Runnable {
        volatile int eVU;
        int fYT;
        boolean fYU;
        final Object fYV;

        private C12562a() {
            AppMethodBeat.m2504i(76724);
            this.fYV = new Object();
            AppMethodBeat.m2505o(76724);
        }

        /* synthetic */ C12562a(C12561g c12561g, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(76725);
            if (this.fYT == -1) {
                this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                C4990ab.m7417i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", Integer.valueOf(this.fYT));
            }
            this.eVU = 0;
            synchronized (this.fYV) {
                long yz;
                while (!this.fYU) {
                    int triggerEncodeForSegmentLock;
                    try {
                        yz = C5046bo.m7588yz();
                        C4990ab.m7416i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
                        triggerEncodeForSegmentLock = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.eVU), false);
                        C4990ab.m7417i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncodeForSegmentLock), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegmentLock == this.eVU) {
                            Thread.sleep(10);
                        }
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(76725);
                    }
                    this.eVU = triggerEncodeForSegmentLock;
                }
                yz = C5046bo.m7588yz();
                this.eVU = MP4MuxerJNI.triggerEncodeForSegmentLock(this.eVU, true);
                C4990ab.m7417i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(this.eVU), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.m2505o(76725);
        }
    }

    public C12561g(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.gLw = i;
        this.gLx = i2;
        this.eTi = i3;
        this.eTj = i4;
        this.bitrate = i5;
        this.eTk = i6;
        this.fzU = 2;
        this.fzV = i7;
    }
}
