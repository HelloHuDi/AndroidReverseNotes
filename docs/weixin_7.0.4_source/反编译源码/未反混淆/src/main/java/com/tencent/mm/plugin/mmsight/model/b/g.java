package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g {
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
    a oxv;

    class a implements Runnable {
        volatile int eVU;
        int fYT;
        boolean fYU;
        final Object fYV;

        private a() {
            AppMethodBeat.i(76724);
            this.fYV = new Object();
            AppMethodBeat.o(76724);
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(76725);
            if (this.fYT == -1) {
                this.fYT = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                ab.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", Integer.valueOf(this.fYT));
            }
            this.eVU = 0;
            synchronized (this.fYV) {
                long yz;
                while (!this.fYU) {
                    int triggerEncodeForSegmentLock;
                    try {
                        yz = bo.yz();
                        ab.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
                        triggerEncodeForSegmentLock = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.eVU), false);
                        ab.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Integer.valueOf(triggerEncodeForSegmentLock), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegmentLock == this.eVU) {
                            Thread.sleep(10);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
                    } catch (Throwable th) {
                        AppMethodBeat.o(76725);
                    }
                    this.eVU = triggerEncodeForSegmentLock;
                }
                yz = bo.yz();
                this.eVU = MP4MuxerJNI.triggerEncodeForSegmentLock(this.eVU, true);
                ab.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(this.eVU), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.o(76725);
        }
    }

    public g(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
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
