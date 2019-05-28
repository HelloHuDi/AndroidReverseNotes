package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C12542a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43303c.C28499b;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.mmsight.model.a.h */
public class C21294h implements C43303c {
    private final int TIMEOUT_USEC = Downloads.MIN_WAIT_FOR_NETWORK;
    int audioSampleRate;
    volatile C1292c coZ = null;
    boolean eVK = false;
    final Object eVL = new Object();
    MediaCodec eVq;
    private int fXX;
    private int fzS;
    int ils;
    private MediaFormat ovL;
    private BufferInfo ovM;
    long ovN = 0;
    int ovO;
    int ovP;
    long ovQ;
    long ovR;
    boolean ovS = false;
    boolean ovT = false;
    public C12542a ovU = null;
    C34545o ovV;
    boolean ovW = true;
    C7306ak ovX = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(76573);
            if (C21294h.this.ovU != null) {
                C21294h.this.ovU.mo14867WU();
                C21294h.this.ovU = null;
            }
            AppMethodBeat.m2505o(76573);
        }
    };
    protected boolean ovY;
    boolean ovZ;
    final Object owa = new byte[0];
    C28499b owb;
    boolean owc = false;
    C7306ak owd;
    Runnable owe = new C212982();
    private C1293a owf = new C212963();
    private long startTime = 0;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.h$4 */
    class C212954 implements Runnable {
        C212954() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76577);
            try {
                C21294h.m32672a(C21294h.this);
                if (!(C21294h.this.coZ == null || C21294h.this.ovT)) {
                    C21294h.this.coZ.mo4590EB();
                    C21294h.this.coZ = null;
                }
                AppMethodBeat.m2505o(76577);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", e.getMessage());
                AppMethodBeat.m2505o(76577);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.h$3 */
    class C212963 implements C1293a {
        C212963() {
        }

        /* JADX WARNING: Missing block: B:10:0x0032, code skipped:
            if (r9.eVK != false) goto L_0x0034;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            boolean z;
            int i2 = 0;
            AppMethodBeat.m2504i(76575);
            C21294h.this.ovX.sendEmptyMessage(0);
            if (C21294h.this.ovS) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                C21294h.this.ils += 128;
            }
            boolean z2 = C21294h.this.ovY;
            if (!z) {
                C21294h c21294h = C21294h.this;
                if (!c21294h.ovW) {
                    synchronized (c21294h.eVL) {
                        try {
                            if (c21294h.eVK) {
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(76575);
                        }
                    }
                }
                if (0 == c21294h.ovN) {
                    c21294h.ovN = System.nanoTime();
                }
                if (c21294h.ovV != null && c21294h.ovV.owQ <= 0) {
                    c21294h.ovV.owQ = System.nanoTime();
                }
                if (c21294h.eVq != null) {
                    if (c21294h.eVq == null) {
                        C4990ab.m7420w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(z2)));
                    } else {
                        try {
                            ByteBuffer[] inputBuffers = c21294h.eVq.getInputBuffers();
                            int dequeueInputBuffer = c21294h.eVq.dequeueInputBuffer(10000);
                            c21294h.ovO = dequeueInputBuffer;
                            if (dequeueInputBuffer < 0) {
                                C4990ab.m7410d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                                while (i2 < 5) {
                                    c21294h.drainEncoder(false);
                                    c21294h.ovO = c21294h.eVq.dequeueInputBuffer(10000);
                                    if (c21294h.ovO >= 0) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            if (c21294h.eVq == null) {
                                C4990ab.m7420w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(z2)));
                            } else if (c21294h.ovO >= 0) {
                                long j;
                                ByteBuffer byteBuffer = inputBuffers[c21294h.ovO];
                                byteBuffer.clear();
                                byteBuffer.put(bArr);
                                byteBuffer.position(0);
                                c21294h.ovP = bArr.length;
                                c21294h.ovQ = System.nanoTime();
                                c21294h.ovQ -= (long) ((c21294h.ovP / c21294h.audioSampleRate) / 1000000000);
                                if (c21294h.ovP == -3) {
                                    C4990ab.m7412e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                                }
                                long j2 = c21294h.ovQ;
                                if (c21294h.ovV != null) {
                                    j = c21294h.ovV.owQ;
                                } else {
                                    j = c21294h.ovN;
                                }
                                c21294h.ovR = (j2 - j) / 1000;
                                C4990ab.m7418v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + c21294h.ovP + " audio bytes with pts " + c21294h.ovR + ", end:" + z2 + ", enqueue:" + c21294h.ovO);
                                if (z2) {
                                    C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                    c21294h.eVq.queueInputBuffer(c21294h.ovO, 0, c21294h.ovP, c21294h.ovR, 4);
                                } else {
                                    c21294h.eVq.queueInputBuffer(c21294h.ovO, 0, c21294h.ovP, c21294h.ovR, 0);
                                }
                            }
                        } catch (Throwable th2) {
                            C4990ab.m7412e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th2.getMessage());
                        }
                    }
                    c21294h.drainEncoder(z2);
                }
            }
            if (z2 && !C21294h.this.owc) {
                synchronized (C21294h.this.owa) {
                    try {
                        if (C21294h.this.owb != null) {
                            C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                            C21294h.this.owb.mo14866WT();
                            C21294h.this.owb = null;
                        } else {
                            C4990ab.m7420w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                        }
                        C21294h.this.ovZ = true;
                    } catch (Throwable th3) {
                        AppMethodBeat.m2505o(76575);
                    }
                }
                C21294h.this.owc = true;
                C21294h.this.owd.removeCallbacks(C21294h.this.owe);
                C21294h.this.owd.post(C21294h.this.owe);
            }
            AppMethodBeat.m2505o(76575);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
            AppMethodBeat.m2504i(76576);
            C4990ab.m7421w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(76576);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.h$2 */
    class C212982 implements Runnable {
        C212982() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76574);
            if (C21294h.this.coZ == null) {
                AppMethodBeat.m2505o(76574);
                return;
            }
            C21294h.this.owc = true;
            C21294h.this.coZ.mo4590EB();
            AppMethodBeat.m2505o(76574);
        }
    }

    public C21294h(int i, int i2) {
        AppMethodBeat.m2504i(76578);
        this.fzS = i2;
        this.audioSampleRate = i;
        this.ovV = null;
        this.ovW = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_ignore_mediacodec_lock, true);
        C4990ab.m7417i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", Integer.valueOf(this.fzS), Integer.valueOf(this.audioSampleRate));
        AppMethodBeat.m2505o(76578);
    }

    /* renamed from: q */
    public int mo20926q(int i, String str) {
        String str2;
        String str3;
        Object[] objArr;
        boolean z;
        AppMethodBeat.m2504i(76579);
        if (!(this.ovT || this.coZ == null)) {
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.owb == null);
            C4990ab.m7413e(str2, str3, objArr);
            this.coZ.mo4590EB();
        }
        if (this.eVq != null) {
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.owb == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7413e(str2, str3, objArr);
            m32671UO();
            if (this.owb != null) {
                this.owb.mo14866WT();
                this.owb = null;
            }
        }
        this.ils = 0;
        this.ovY = false;
        synchronized (this.owa) {
            try {
                this.ovZ = false;
                this.owb = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(76579);
                }
            }
        }
        if (!this.ovT) {
            this.coZ = new C1292c(this.audioSampleRate, 1, 5);
            this.coZ.mo4598gG(128);
            this.coZ.mo4595bq(false);
            this.coZ.cpM = this.owf;
        }
        if (this.owd == null) {
            C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.owd = new C7306ak();
        } else if (this.owd.getLooper() != Looper.myLooper()) {
            C4990ab.m7421w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", this.owd.getLooper(), Looper.myLooper());
            this.owd = new C7306ak();
        }
        C4990ab.m7417i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.fzS));
        try {
            this.ovM = new BufferInfo();
            this.ovL = new MediaFormat();
            this.ovL.setString("mime", "audio/mp4a-latm");
            this.ovL.setInteger("aac-profile", 2);
            this.ovL.setInteger("sample-rate", this.audioSampleRate);
            this.ovL.setInteger("channel-count", 1);
            this.ovL.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.fzS);
            this.ovL.setInteger("max-input-size", 16384);
            this.eVq = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.eVq.configure(this.ovL, null, null, 1);
            this.eVq.start();
            z = this.ovW;
            if (z) {
                this.eVK = z;
                this.startTime = System.currentTimeMillis();
                this.ovS = false;
                AppMethodBeat.m2505o(76579);
                return 0;
            }
            synchronized (this.eVL) {
                this.eVK = false;
                this.startTime = System.currentTimeMillis();
            }
            this.ovS = false;
            AppMethodBeat.m2505o(76579);
            return 0;
        } catch (Throwable th2) {
            z = th2;
            try {
                String str4 = "MicroMsg.MMSightAACMediaCodecRecorder";
                str2 = "start aac encoder error: %s";
                this.ovS = false;
                AppMethodBeat.m2505o(76579);
                return -1;
            } catch (Throwable th3) {
                this.ovS = false;
                AppMethodBeat.m2505o(76579);
            }
        } finally {
            AppMethodBeat.m2505o(76579);
        }
    }

    /* renamed from: a */
    public final int mo36708a(C12542a c12542a) {
        int i = 0;
        AppMethodBeat.m2504i(76580);
        C4990ab.m7417i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", c12542a);
        this.ovU = c12542a;
        if (this.ovT) {
            this.ovX.sendEmptyMessage(0);
        } else if (this.coZ == null) {
            C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
            AppMethodBeat.m2505o(76580);
            return -1;
        } else if (!this.coZ.mo4592EL()) {
            i = -1;
        }
        AppMethodBeat.m2505o(76580);
        return i;
    }

    /* renamed from: a */
    public final int mo36709a(C28499b c28499b) {
        boolean z;
        AppMethodBeat.m2504i(76581);
        String str = "MicroMsg.MMSightAACMediaCodecRecorder";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.coZ == null);
        if (this.owb == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(c28499b == null);
        objArr[3] = Boolean.valueOf(this.ovY);
        C4990ab.m7417i(str, str2, objArr);
        if (this.coZ != null || this.ovT) {
            this.ovY = true;
            synchronized (this.owa) {
                try {
                    this.owb = c28499b;
                    if (this.ovZ && c28499b != null) {
                        C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                        c28499b.mo14866WT();
                        this.owb = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(76581);
                }
            }
            C5004al.m7442n(new C212954(), 500);
            return 0;
        }
        AppMethodBeat.m2505o(76581);
        return -1;
    }

    public final void clear() {
        AppMethodBeat.m2504i(76582);
        C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        m32671UO();
        if (!(this.coZ == null || this.ovT)) {
            C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
            this.coZ.mo4590EB();
            this.coZ = null;
        }
        AppMethodBeat.m2505o(76582);
    }

    /* renamed from: UO */
    private void m32671UO() {
        AppMethodBeat.m2504i(138317);
        if (this.ovW) {
            bPQ();
            AppMethodBeat.m2505o(138317);
            return;
        }
        synchronized (this.eVL) {
            try {
                bPQ();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(138317);
            }
        }
    }

    private void bPQ() {
        AppMethodBeat.m2504i(138318);
        if (this.eVK || 0 == this.startTime) {
            AppMethodBeat.m2505o(138318);
            return;
        }
        this.eVK = true;
        try {
            if (this.eVq != null) {
                C4990ab.m7416i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.eVq.stop();
                this.eVq.release();
                this.eVq = null;
            }
            this.eVq = null;
            AppMethodBeat.m2505o(138318);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", e.getMessage());
            this.eVq = null;
            AppMethodBeat.m2505o(138318);
        } catch (Throwable th) {
            this.eVq = null;
            AppMethodBeat.m2505o(138318);
            throw th;
        }
    }

    public final void bPM() {
        this.ovS = true;
    }

    public final C1293a bPN() {
        return this.owf;
    }

    /* renamed from: iW */
    public final void mo36714iW(boolean z) {
        this.ovT = z;
    }

    /* Access modifiers changed, original: final */
    public final void drainEncoder(boolean z) {
        AppMethodBeat.m2504i(76583);
        if (this.eVq == null) {
            C4990ab.m7420w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(76583);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.eVq.getOutputBuffers();
            while (true) {
                this.fXX = this.eVq.dequeueOutputBuffer(this.ovM, 10000);
                C4990ab.m7419v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", Integer.valueOf(this.fXX));
                if (this.fXX == -1) {
                    C4990ab.m7410d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    AppMethodBeat.m2505o(76583);
                    return;
                } else if (this.fXX == -3) {
                    outputBuffers = this.eVq.getOutputBuffers();
                } else if (this.fXX == -2) {
                    MediaFormat outputFormat = this.eVq.getOutputFormat();
                    C4990ab.m7410d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(outputFormat)));
                    if (this.ovV != null) {
                        this.ovV.mo55074e(outputFormat);
                    }
                } else if (this.fXX < 0) {
                    C4990ab.m7419v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(this.fXX));
                } else {
                    C4990ab.m7418v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.fXX];
                    if (byteBuffer == null) {
                        RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                        AppMethodBeat.m2505o(76583);
                        throw runtimeException;
                    }
                    if ((this.ovM.flags & 2) != 0) {
                        C4990ab.m7419v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(this.ovM.size), Boolean.valueOf(mo20924WF()));
                        if (mo20924WF()) {
                            this.ovM.size = 0;
                        }
                    }
                    if (this.ovM.size != 0) {
                        if (!(this.ovV == null || this.ovV.cFy)) {
                            this.ovV.mo55074e(this.eVq.getOutputFormat());
                        }
                        byteBuffer.position(this.ovM.offset);
                        byteBuffer.limit(this.ovM.offset + this.ovM.size);
                        mo20925g(byteBuffer, this.ovM);
                    }
                    this.eVq.releaseOutputBuffer(this.fXX, false);
                    if ((this.ovM.flags & 4) != 0) {
                        if (z) {
                            C4990ab.m7420w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                            m32671UO();
                            AppMethodBeat.m2505o(76583);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
                        AppMethodBeat.m2505o(76583);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", e.getMessage());
            AppMethodBeat.m2505o(76583);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo20925g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(76584);
        if (this.ovV != null && (bufferInfo.flags & 4) == 0) {
            C34545o c34545o = this.ovV;
            try {
                if (!(c34545o.owN == null || c34545o.owP == -1 || !c34545o.cFy || byteBuffer == null || bufferInfo == null)) {
                    long j = bufferInfo.presentationTimeUs;
                    bufferInfo.presentationTimeUs = (System.nanoTime() - c34545o.owQ) / 1000;
                    long yz = C5046bo.m7588yz();
                    c34545o.owN.writeSampleData(c34545o.owP, byteBuffer, bufferInfo);
                    C4990ab.m7419v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", Integer.valueOf(bufferInfo.size), Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs));
                }
                AppMethodBeat.m2505o(76584);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76584);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: WF */
    public boolean mo20924WF() {
        return false;
    }
}
