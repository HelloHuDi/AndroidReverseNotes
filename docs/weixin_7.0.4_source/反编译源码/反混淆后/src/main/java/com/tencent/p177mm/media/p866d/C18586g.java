package com.tencent.p177mm.media.p866d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodeThread", "Ljava/lang/Thread;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.d.g */
public final class C18586g {
    public static final C18585a eVW = new C18585a();
    public final int eTa;
    public final Object eTu = new Object();
    public Thread eVR;
    public final C5004al eVS = new C5004al("X264TransEncoder_writeDataThread");
    public boolean eVT;
    private int eVU;
    public boolean eVV;
    public int frameCount;
    private final int height;
    public boolean isStop;
    public long startTime;
    private final int width;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/encoder/X264TransEncoder$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.d.g$a */
    public static final class C18585a {
        private C18585a() {
        }

        public /* synthetic */ C18585a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
    /* renamed from: com.tencent.mm.media.d.g$c */
    public static final class C18587c implements Runnable {
        final /* synthetic */ C18586g eVX;
        final /* synthetic */ int eVY;
        final /* synthetic */ int eVZ;
        final /* synthetic */ int[] eWa;

        public C18587c(C18586g c18586g, int i, int i2, int[] iArr) {
            this.eVX = c18586g;
            this.eVY = i;
            this.eVZ = i2;
            this.eWa = iArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(12965);
            if (this.eVX.isStop || this.eVX.eVT) {
                C4990ab.m7412e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
                AppMethodBeat.m2505o(12965);
                return;
            }
            long yz = C5046bo.m7588yz();
            byte[] g = C43305j.owk.mo68846g(Integer.valueOf(((this.eVY * this.eVZ) * 3) / 2));
            SightVideoJNI.rgbaToNV21(this.eWa, g, this.eVY, this.eVZ);
            C4990ab.m7416i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + C5046bo.m7525az(yz) + "ms");
            long yz2 = C5046bo.m7588yz();
            SightVideoJNI.writeYuvDataForMMSight(this.eVX.eTa, g, g.length, this.eVY, this.eVZ, false, false, this.eVY, this.eVZ);
            StringBuilder append = new StringBuilder("writeRGBData ").append(this.eVY).append(", ").append(this.eVZ).append(" cost ").append(C5046bo.m7525az(yz2)).append("ms, ");
            C18586g c18586g = this.eVX;
            int e = c18586g.frameCount;
            c18586g.frameCount = e + 1;
            C4990ab.m7416i("MicroMsg.X264TransEncoder", append.append(e).toString());
            C43305j.owk.mo68845g(g);
            if (!this.eVX.eVV) {
                Thread h = this.eVX.eVR;
                if (h != null) {
                    h.start();
                }
                this.eVX.eVV = true;
            }
            AppMethodBeat.m2505o(12965);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.d.g$b */
    public static final class C18588b implements Runnable {
        final /* synthetic */ C18586g eVX;

        public C18588b(C18586g c18586g) {
            this.eVX = c18586g;
        }

        public final void run() {
            AppMethodBeat.m2504i(12964);
            C18586g.m28932a(this.eVX);
            AppMethodBeat.m2505o(12964);
        }
    }

    static {
        AppMethodBeat.m2504i(12968);
        AppMethodBeat.m2505o(12968);
    }

    public C18586g(int i, int i2, int i3) {
        AppMethodBeat.m2504i(12967);
        this.eTa = i;
        this.width = i2;
        this.height = i3;
        C4990ab.m7416i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
        AppMethodBeat.m2505o(12967);
    }

    public final void stop(boolean z) {
        AppMethodBeat.m2504i(12966);
        C4990ab.m7416i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(z)));
        long yz = C5046bo.m7588yz();
        synchronized (this.eTu) {
            try {
                this.isStop = true;
                this.eVT = z;
                this.eVS.quit();
                Thread thread = this.eVR;
                if (thread != null) {
                    thread.join();
                }
                C4990ab.m7416i("MicroMsg.X264TransEncoder", "stop finish, cost:" + C5046bo.m7525az(yz) + "ms");
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(12966);
            }
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m28932a(C18586g c18586g) {
        long yz;
        Thread currentThread;
        AppMethodBeat.m2504i(12969);
        while (!c18586g.isStop) {
            yz = C5046bo.m7588yz();
            int triggerEncode = SightVideoJNI.triggerEncode(c18586g.eTa, Math.max(0, c18586g.eVU), false);
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(C5046bo.m7525az(yz));
            objArr[1] = Integer.valueOf(c18586g.eVU);
            objArr[2] = Integer.valueOf(triggerEncode);
            currentThread = Thread.currentThread();
            C25052j.m39375o(currentThread, "Thread.currentThread()");
            objArr[3] = Long.valueOf(currentThread.getId());
            C4990ab.m7417i("MicroMsg.X264TransEncoder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", objArr);
            if (Math.abs(triggerEncode - c18586g.eVU) <= 5) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.X264TransEncoder", "thread sleep error");
                }
            }
            c18586g.eVU = triggerEncode;
        }
        yz = C5046bo.m7588yz();
        if (!c18586g.eVT) {
            c18586g.eVU = SightVideoJNI.triggerEncode(c18586g.eTa, c18586g.eVU, true);
        }
        Object[] objArr2 = new Object[4];
        objArr2[0] = Long.valueOf(C5046bo.m7525az(yz));
        objArr2[1] = Integer.valueOf(c18586g.eVU);
        objArr2[2] = Boolean.valueOf(c18586g.eVT);
        currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "Thread.currentThread()");
        objArr2[3] = Long.valueOf(currentThread.getId());
        C4990ab.m7417i("MicroMsg.X264TransEncoder", "end: trgger encode use %dms, curEncode index %d, markCancel %s, threadId: %s", objArr2);
        AppMethodBeat.m2505o(12969);
    }
}
