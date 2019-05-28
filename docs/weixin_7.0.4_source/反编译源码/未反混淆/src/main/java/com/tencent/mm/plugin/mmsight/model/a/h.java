package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h implements c {
    private final int TIMEOUT_USEC = Downloads.MIN_WAIT_FOR_NETWORK;
    int audioSampleRate;
    volatile c coZ = null;
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
    public a ovU = null;
    o ovV;
    boolean ovW = true;
    ak ovX = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(76573);
            if (h.this.ovU != null) {
                h.this.ovU.WU();
                h.this.ovU = null;
            }
            AppMethodBeat.o(76573);
        }
    };
    protected boolean ovY;
    boolean ovZ;
    final Object owa = new byte[0];
    b owb;
    boolean owc = false;
    ak owd;
    Runnable owe = new Runnable() {
        public final void run() {
            AppMethodBeat.i(76574);
            if (h.this.coZ == null) {
                AppMethodBeat.o(76574);
                return;
            }
            h.this.owc = true;
            h.this.coZ.EB();
            AppMethodBeat.o(76574);
        }
    };
    private c.a owf = new c.a() {
        /* JADX WARNING: Missing block: B:10:0x0032, code skipped:
            if (r9.eVK != false) goto L_0x0034;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void u(byte[] bArr, int i) {
            boolean z;
            int i2 = 0;
            AppMethodBeat.i(76575);
            h.this.ovX.sendEmptyMessage(0);
            if (h.this.ovS) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                h.this.ils += 128;
            }
            boolean z2 = h.this.ovY;
            if (!z) {
                h hVar = h.this;
                if (!hVar.ovW) {
                    synchronized (hVar.eVL) {
                        try {
                            if (hVar.eVK) {
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(76575);
                        }
                    }
                }
                if (0 == hVar.ovN) {
                    hVar.ovN = System.nanoTime();
                }
                if (hVar.ovV != null && hVar.ovV.owQ <= 0) {
                    hVar.ovV.owQ = System.nanoTime();
                }
                if (hVar.eVq != null) {
                    if (hVar.eVq == null) {
                        ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(z2)));
                    } else {
                        try {
                            ByteBuffer[] inputBuffers = hVar.eVq.getInputBuffers();
                            int dequeueInputBuffer = hVar.eVq.dequeueInputBuffer(10000);
                            hVar.ovO = dequeueInputBuffer;
                            if (dequeueInputBuffer < 0) {
                                ab.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                                while (i2 < 5) {
                                    hVar.drainEncoder(false);
                                    hVar.ovO = hVar.eVq.dequeueInputBuffer(10000);
                                    if (hVar.ovO >= 0) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            if (hVar.eVq == null) {
                                ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(z2)));
                            } else if (hVar.ovO >= 0) {
                                long j;
                                ByteBuffer byteBuffer = inputBuffers[hVar.ovO];
                                byteBuffer.clear();
                                byteBuffer.put(bArr);
                                byteBuffer.position(0);
                                hVar.ovP = bArr.length;
                                hVar.ovQ = System.nanoTime();
                                hVar.ovQ -= (long) ((hVar.ovP / hVar.audioSampleRate) / 1000000000);
                                if (hVar.ovP == -3) {
                                    ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                                }
                                long j2 = hVar.ovQ;
                                if (hVar.ovV != null) {
                                    j = hVar.ovV.owQ;
                                } else {
                                    j = hVar.ovN;
                                }
                                hVar.ovR = (j2 - j) / 1000;
                                ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + hVar.ovP + " audio bytes with pts " + hVar.ovR + ", end:" + z2 + ", enqueue:" + hVar.ovO);
                                if (z2) {
                                    ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                    hVar.eVq.queueInputBuffer(hVar.ovO, 0, hVar.ovP, hVar.ovR, 4);
                                } else {
                                    hVar.eVq.queueInputBuffer(hVar.ovO, 0, hVar.ovP, hVar.ovR, 0);
                                }
                            }
                        } catch (Throwable th2) {
                            ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th2.getMessage());
                        }
                    }
                    hVar.drainEncoder(z2);
                }
            }
            if (z2 && !h.this.owc) {
                synchronized (h.this.owa) {
                    try {
                        if (h.this.owb != null) {
                            ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                            h.this.owb.WT();
                            h.this.owb = null;
                        } else {
                            ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                        }
                        h.this.ovZ = true;
                    } catch (Throwable th3) {
                        AppMethodBeat.o(76575);
                    }
                }
                h.this.owc = true;
                h.this.owd.removeCallbacks(h.this.owe);
                h.this.owd.post(h.this.owe);
            }
            AppMethodBeat.o(76575);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(76576);
            ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(76576);
        }
    };
    private long startTime = 0;

    public h(int i, int i2) {
        AppMethodBeat.i(76578);
        this.fzS = i2;
        this.audioSampleRate = i;
        this.ovV = null;
        this.ovW = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_ignore_mediacodec_lock, true);
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", Integer.valueOf(this.fzS), Integer.valueOf(this.audioSampleRate));
        AppMethodBeat.o(76578);
    }

    public int q(int i, String str) {
        String str2;
        String str3;
        Object[] objArr;
        boolean z;
        AppMethodBeat.i(76579);
        if (!(this.ovT || this.coZ == null)) {
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.owb == null);
            ab.e(str2, str3, objArr);
            this.coZ.EB();
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
            ab.e(str2, str3, objArr);
            UO();
            if (this.owb != null) {
                this.owb.WT();
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
                    AppMethodBeat.o(76579);
                }
            }
        }
        if (!this.ovT) {
            this.coZ = new c(this.audioSampleRate, 1, 5);
            this.coZ.gG(128);
            this.coZ.bq(false);
            this.coZ.cpM = this.owf;
        }
        if (this.owd == null) {
            ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.owd = new ak();
        } else if (this.owd.getLooper() != Looper.myLooper()) {
            ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", this.owd.getLooper(), Looper.myLooper());
            this.owd = new ak();
        }
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.fzS));
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
                AppMethodBeat.o(76579);
                return 0;
            }
            synchronized (this.eVL) {
                this.eVK = false;
                this.startTime = System.currentTimeMillis();
            }
            this.ovS = false;
            AppMethodBeat.o(76579);
            return 0;
        } catch (Throwable th2) {
            z = th2;
            try {
                String str4 = "MicroMsg.MMSightAACMediaCodecRecorder";
                str2 = "start aac encoder error: %s";
                this.ovS = false;
                AppMethodBeat.o(76579);
                return -1;
            } catch (Throwable th3) {
                this.ovS = false;
                AppMethodBeat.o(76579);
            }
        } finally {
            AppMethodBeat.o(76579);
        }
    }

    public final int a(a aVar) {
        int i = 0;
        AppMethodBeat.i(76580);
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", aVar);
        this.ovU = aVar;
        if (this.ovT) {
            this.ovX.sendEmptyMessage(0);
        } else if (this.coZ == null) {
            ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
            AppMethodBeat.o(76580);
            return -1;
        } else if (!this.coZ.EL()) {
            i = -1;
        }
        AppMethodBeat.o(76580);
        return i;
    }

    public final int a(b bVar) {
        boolean z;
        AppMethodBeat.i(76581);
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
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.ovY);
        ab.i(str, str2, objArr);
        if (this.coZ != null || this.ovT) {
            this.ovY = true;
            synchronized (this.owa) {
                try {
                    this.owb = bVar;
                    if (this.ovZ && bVar != null) {
                        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                        bVar.WT();
                        this.owb = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(76581);
                }
            }
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(76577);
                    try {
                        h.a(h.this);
                        if (!(h.this.coZ == null || h.this.ovT)) {
                            h.this.coZ.EB();
                            h.this.coZ = null;
                        }
                        AppMethodBeat.o(76577);
                    } catch (Exception e) {
                        ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", e.getMessage());
                        AppMethodBeat.o(76577);
                    }
                }
            }, 500);
            return 0;
        }
        AppMethodBeat.o(76581);
        return -1;
    }

    public final void clear() {
        AppMethodBeat.i(76582);
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        UO();
        if (!(this.coZ == null || this.ovT)) {
            ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
            this.coZ.EB();
            this.coZ = null;
        }
        AppMethodBeat.o(76582);
    }

    private void UO() {
        AppMethodBeat.i(138317);
        if (this.ovW) {
            bPQ();
            AppMethodBeat.o(138317);
            return;
        }
        synchronized (this.eVL) {
            try {
                bPQ();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(138317);
            }
        }
    }

    private void bPQ() {
        AppMethodBeat.i(138318);
        if (this.eVK || 0 == this.startTime) {
            AppMethodBeat.o(138318);
            return;
        }
        this.eVK = true;
        try {
            if (this.eVq != null) {
                ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.eVq.stop();
                this.eVq.release();
                this.eVq = null;
            }
            this.eVq = null;
            AppMethodBeat.o(138318);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", e.getMessage());
            this.eVq = null;
            AppMethodBeat.o(138318);
        } catch (Throwable th) {
            this.eVq = null;
            AppMethodBeat.o(138318);
            throw th;
        }
    }

    public final void bPM() {
        this.ovS = true;
    }

    public final c.a bPN() {
        return this.owf;
    }

    public final void iW(boolean z) {
        this.ovT = z;
    }

    /* Access modifiers changed, original: final */
    public final void drainEncoder(boolean z) {
        AppMethodBeat.i(76583);
        if (this.eVq == null) {
            ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(z)));
            AppMethodBeat.o(76583);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.eVq.getOutputBuffers();
            while (true) {
                this.fXX = this.eVq.dequeueOutputBuffer(this.ovM, 10000);
                ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", Integer.valueOf(this.fXX));
                if (this.fXX == -1) {
                    ab.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    AppMethodBeat.o(76583);
                    return;
                } else if (this.fXX == -3) {
                    outputBuffers = this.eVq.getOutputBuffers();
                } else if (this.fXX == -2) {
                    MediaFormat outputFormat = this.eVq.getOutputFormat();
                    ab.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(outputFormat)));
                    if (this.ovV != null) {
                        this.ovV.e(outputFormat);
                    }
                } else if (this.fXX < 0) {
                    ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(this.fXX));
                } else {
                    ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.fXX];
                    if (byteBuffer == null) {
                        RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                        AppMethodBeat.o(76583);
                        throw runtimeException;
                    }
                    if ((this.ovM.flags & 2) != 0) {
                        ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(this.ovM.size), Boolean.valueOf(WF()));
                        if (WF()) {
                            this.ovM.size = 0;
                        }
                    }
                    if (this.ovM.size != 0) {
                        if (!(this.ovV == null || this.ovV.cFy)) {
                            this.ovV.e(this.eVq.getOutputFormat());
                        }
                        byteBuffer.position(this.ovM.offset);
                        byteBuffer.limit(this.ovM.offset + this.ovM.size);
                        g(byteBuffer, this.ovM);
                    }
                    this.eVq.releaseOutputBuffer(this.fXX, false);
                    if ((this.ovM.flags & 4) != 0) {
                        if (z) {
                            ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                            UO();
                            AppMethodBeat.o(76583);
                            return;
                        }
                        ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
                        AppMethodBeat.o(76583);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", e.getMessage());
            AppMethodBeat.o(76583);
        }
    }

    /* Access modifiers changed, original: protected */
    public void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(76584);
        if (this.ovV != null && (bufferInfo.flags & 4) == 0) {
            o oVar = this.ovV;
            try {
                if (!(oVar.owN == null || oVar.owP == -1 || !oVar.cFy || byteBuffer == null || bufferInfo == null)) {
                    long j = bufferInfo.presentationTimeUs;
                    bufferInfo.presentationTimeUs = (System.nanoTime() - oVar.owQ) / 1000;
                    long yz = bo.yz();
                    oVar.owN.writeSampleData(oVar.owP, byteBuffer, bufferInfo);
                    ab.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", Integer.valueOf(bufferInfo.size), Long.valueOf(bo.az(yz)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs));
                }
                AppMethodBeat.o(76584);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76584);
    }

    /* Access modifiers changed, original: protected */
    public boolean WF() {
        return false;
    }
}
