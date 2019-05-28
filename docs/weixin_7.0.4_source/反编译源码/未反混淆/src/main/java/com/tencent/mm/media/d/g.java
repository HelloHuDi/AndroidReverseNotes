package com.tencent.mm.media.d;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodeThread", "Ljava/lang/Thread;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "", "Companion", "plugin-mediaeditor_release"})
public final class g {
    public static final a eVW = new a();
    public final int eTa;
    public final Object eTu = new Object();
    public Thread eVR;
    public final al eVS = new al("X264TransEncoder_writeDataThread");
    public boolean eVT;
    private int eVU;
    public boolean eVV;
    public int frameCount;
    private final int height;
    public boolean isStop;
    public long startTime;
    private final int width;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/encoder/X264TransEncoder$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
    public static final class c implements Runnable {
        final /* synthetic */ g eVX;
        final /* synthetic */ int eVY;
        final /* synthetic */ int eVZ;
        final /* synthetic */ int[] eWa;

        public c(g gVar, int i, int i2, int[] iArr) {
            this.eVX = gVar;
            this.eVY = i;
            this.eVZ = i2;
            this.eWa = iArr;
        }

        public final void run() {
            AppMethodBeat.i(12965);
            if (this.eVX.isStop || this.eVX.eVT) {
                ab.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
                AppMethodBeat.o(12965);
                return;
            }
            long yz = bo.yz();
            byte[] g = j.owk.g(Integer.valueOf(((this.eVY * this.eVZ) * 3) / 2));
            SightVideoJNI.rgbaToNV21(this.eWa, g, this.eVY, this.eVZ);
            ab.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + bo.az(yz) + "ms");
            long yz2 = bo.yz();
            SightVideoJNI.writeYuvDataForMMSight(this.eVX.eTa, g, g.length, this.eVY, this.eVZ, false, false, this.eVY, this.eVZ);
            StringBuilder append = new StringBuilder("writeRGBData ").append(this.eVY).append(", ").append(this.eVZ).append(" cost ").append(bo.az(yz2)).append("ms, ");
            g gVar = this.eVX;
            int e = gVar.frameCount;
            gVar.frameCount = e + 1;
            ab.i("MicroMsg.X264TransEncoder", append.append(e).toString());
            j.owk.g(g);
            if (!this.eVX.eVV) {
                Thread h = this.eVX.eVR;
                if (h != null) {
                    h.start();
                }
                this.eVX.eVV = true;
            }
            AppMethodBeat.o(12965);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ g eVX;

        public b(g gVar) {
            this.eVX = gVar;
        }

        public final void run() {
            AppMethodBeat.i(12964);
            g.a(this.eVX);
            AppMethodBeat.o(12964);
        }
    }

    static {
        AppMethodBeat.i(12968);
        AppMethodBeat.o(12968);
    }

    public g(int i, int i2, int i3) {
        AppMethodBeat.i(12967);
        this.eTa = i;
        this.width = i2;
        this.height = i3;
        ab.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
        AppMethodBeat.o(12967);
    }

    public final void stop(boolean z) {
        AppMethodBeat.i(12966);
        ab.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(z)));
        long yz = bo.yz();
        synchronized (this.eTu) {
            try {
                this.isStop = true;
                this.eVT = z;
                this.eVS.quit();
                Thread thread = this.eVR;
                if (thread != null) {
                    thread.join();
                }
                ab.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + bo.az(yz) + "ms");
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(12966);
            }
        }
    }

    public static final /* synthetic */ void a(g gVar) {
        long yz;
        Thread currentThread;
        AppMethodBeat.i(12969);
        while (!gVar.isStop) {
            yz = bo.yz();
            int triggerEncode = SightVideoJNI.triggerEncode(gVar.eTa, Math.max(0, gVar.eVU), false);
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(bo.az(yz));
            objArr[1] = Integer.valueOf(gVar.eVU);
            objArr[2] = Integer.valueOf(triggerEncode);
            currentThread = Thread.currentThread();
            a.f.b.j.o(currentThread, "Thread.currentThread()");
            objArr[3] = Long.valueOf(currentThread.getId());
            ab.i("MicroMsg.X264TransEncoder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", objArr);
            if (Math.abs(triggerEncode - gVar.eVU) <= 5) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    ab.e("MicroMsg.X264TransEncoder", "thread sleep error");
                }
            }
            gVar.eVU = triggerEncode;
        }
        yz = bo.yz();
        if (!gVar.eVT) {
            gVar.eVU = SightVideoJNI.triggerEncode(gVar.eTa, gVar.eVU, true);
        }
        Object[] objArr2 = new Object[4];
        objArr2[0] = Long.valueOf(bo.az(yz));
        objArr2[1] = Integer.valueOf(gVar.eVU);
        objArr2[2] = Boolean.valueOf(gVar.eVT);
        currentThread = Thread.currentThread();
        a.f.b.j.o(currentThread, "Thread.currentThread()");
        objArr2[3] = Long.valueOf(currentThread.getId());
        ab.i("MicroMsg.X264TransEncoder", "end: trgger encode use %dms, curEncode index %d, markCancel %s, threadId: %s", objArr2);
        AppMethodBeat.o(12969);
    }
}
