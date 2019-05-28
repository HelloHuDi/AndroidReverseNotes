package com.tencent.p177mm.audio.mix.p831d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C37486c;
import com.tencent.p177mm.audio.mix.p1183c.C32314d;
import com.tencent.p177mm.audio.mix.p1183c.C41773a;
import com.tencent.p177mm.audio.mix.p1458g.C32318b;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.p177mm.audio.mix.p832f.C45172d;
import com.tencent.p177mm.audio.mix.p832f.C9055a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.tencent.mm.audio.mix.d.d */
public class C32315d extends C9050c {
    private MediaCodec bek;
    private byte[] buffer = new byte[this.clZ];
    private int cku = 2;
    private MediaExtractor clX;
    private String clY = null;
    private int clZ = 14144;
    private byte[] cma = new byte[3536];
    private int cmb = 3536;
    private byte[] cmc = new byte[3536];
    private long duration = 0;
    private int mSize = 0;
    private long presentationTimeUs = 0;

    public C32315d(C45172d c45172d, C32318b c32318b) {
        super(c45172d, c32318b);
        AppMethodBeat.m2504i(137051);
        AppMethodBeat.m2505o(137051);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x025d A:{Catch:{ Exception -> 0x0335, all -> 0x0375 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01cc A:{Catch:{ Exception -> 0x0335, all -> 0x0375 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: DG */
    public final void mo20507DG() {
        AppMethodBeat.m2504i(137052);
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "onDecode");
        this.clX = new MediaExtractor();
        try {
            this.clX.setDataSource(this.clO);
            try {
                int i;
                int dequeueInputBuffer;
                MediaFormat trackFormat;
                C45174b.m83210i("MicroMsg.Mix.AudioDecoderMediaCodec", "tractCount is %d", Integer.valueOf(this.clX.getTrackCount()));
                for (i = 0; i < dequeueInputBuffer; i++) {
                    trackFormat = this.clX.getTrackFormat(i);
                    this.clY = trackFormat.getString("mime");
                    if (!TextUtils.isEmpty(this.clY) && this.clY.startsWith("audio/")) {
                        break;
                    }
                }
                trackFormat = null;
                if (trackFormat == null) {
                    C45174b.m83207e("MicroMsg.Mix.AudioDecoderMediaCodec", "format is null");
                    this.clN = 703;
                    onError(this.clN);
                    m52814DO();
                    AppMethodBeat.m2505o(137052);
                    return;
                }
                C45174b.m83210i("MicroMsg.Mix.AudioDecoderMediaCodec", "format:%s", trackFormat);
                this.sampleRate = trackFormat.getInteger("sample-rate");
                this.channels = trackFormat.getInteger("channel-count");
                this.duration = trackFormat.getLong("durationUs");
                try {
                    this.bek = MediaCodec.createDecoderByType(this.clY);
                    this.bek.configure(trackFormat, null, null, 0);
                    this.bek.start();
                    ByteBuffer[] inputBuffers = this.bek.getInputBuffers();
                    ByteBuffer[] outputBuffers = this.bek.getOutputBuffers();
                    C45174b.m83210i("MicroMsg.Mix.AudioDecoderMediaCodec", "Track info: extractorFormat: %s mime: %s", trackFormat, this.clY);
                    C45174b.m83210i("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, duration:%d, audioId:%s,", Integer.valueOf(this.sampleRate), Integer.valueOf(this.channels), Integer.valueOf(this.cku), Long.valueOf(this.duration), this.clK.mo53051Ev().ckD);
                    this.clX.selectTrack(0);
                    BufferInfo bufferInfo = new BufferInfo();
                    int i2 = 0;
                    C37484c DC = mo20503DC();
                    DC.reset();
                    if (!C9055a.m16424E(this.sampleRate, this.channels, this.cku)) {
                        C45174b.m83207e("MicroMsg.Mix.AudioDecoderMediaCodec", "track param is not support config");
                        this.clM = new C32314d(DC, this.sampleRate, this.channels, this.cku, this.clO);
                    }
                    DC.duration = this.duration / 1000;
                    Object obj = null;
                    Object obj2 = null;
                    ByteBuffer[] byteBufferArr = outputBuffers;
                    while (obj == null && i2 < 50) {
                        try {
                            if (!mo20502DB()) {
                                Object obj3;
                                int dequeueOutputBuffer;
                                mo20504DD();
                                i2++;
                                if (obj2 == null) {
                                    dequeueInputBuffer = this.bek.dequeueInputBuffer(1000);
                                    if (dequeueInputBuffer >= 0) {
                                        Object obj4;
                                        int readSampleData = this.clX.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                        if (readSampleData < 0) {
                                            C45174b.m83207e("MicroMsg.Mix.AudioDecoderMediaCodec", "saw input EOS. Stopping playback");
                                            obj4 = 1;
                                            readSampleData = 0;
                                        } else {
                                            this.presentationTimeUs = this.clX.getSampleTime();
                                            obj4 = obj2;
                                        }
                                        this.bek.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.presentationTimeUs, obj4 != null ? 4 : 0);
                                        if (obj4 == null) {
                                            this.clX.advance();
                                        }
                                        obj3 = obj4;
                                        dequeueOutputBuffer = this.bek.dequeueOutputBuffer(bufferInfo, 1000);
                                        if (dequeueOutputBuffer < 0) {
                                            if (bufferInfo.size > 0) {
                                                i = 0;
                                            } else {
                                                i = i2;
                                            }
                                            ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                            int i3 = bufferInfo.size;
                                            if (i3 > 0) {
                                                mo33492a(DC, byteBuffer, i3);
                                            }
                                            byteBuffer.clear();
                                            this.bek.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            if ((bufferInfo.flags & 4) != 0) {
                                                C45174b.m83207e("MicroMsg.Mix.AudioDecoderMediaCodec", "saw output EOS.");
                                                obj = 1;
                                            }
                                            i2 = i;
                                            obj2 = obj3;
                                        } else if (dequeueOutputBuffer == -3) {
                                            ByteBuffer[] outputBuffers2 = this.bek.getOutputBuffers();
                                            C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "output buffers have changed.");
                                            obj2 = obj3;
                                            byteBufferArr = outputBuffers2;
                                        } else if (dequeueOutputBuffer == -2) {
                                            Object obj5;
                                            MediaFormat outputFormat = this.bek.getOutputFormat();
                                            C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "output format has changed to ".concat(String.valueOf(outputFormat)));
                                            this.sampleRate = outputFormat.getInteger("sample-rate");
                                            this.channels = outputFormat.getInteger("channel-count");
                                            if (outputFormat.containsKey("pcm-encoding")) {
                                                this.cku = outputFormat.getInteger("pcm-encoding");
                                            } else if (outputFormat.containsKey("bit-width")) {
                                                i = outputFormat.getInteger("bit-width");
                                                if (i == 16) {
                                                    this.cku = 2;
                                                } else if (i == 8) {
                                                    this.cku = 3;
                                                }
                                            }
                                            C45174b.m83210i("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, audioId:%s, sourcePath:%s", Integer.valueOf(this.sampleRate), Integer.valueOf(this.channels), Integer.valueOf(this.cku), this.clK.mo53051Ev().ckD, this.clO);
                                            switch (this.cku) {
                                                case 1:
                                                case 2:
                                                case 3:
                                                    obj5 = 1;
                                                    break;
                                                default:
                                                    obj5 = null;
                                                    break;
                                            }
                                            if (obj5 == null) {
                                                C45174b.m83208e("MicroMsg.Mix.AudioDecoderMediaCodec", "bitDepth:%d is not support!", Integer.valueOf(this.cku));
                                                this.clN = 709;
                                                onError(this.clN);
                                                m52814DO();
                                                m52815DP();
                                                AppMethodBeat.m2505o(137052);
                                                return;
                                            } else if (!C9055a.m16424E(this.sampleRate, this.channels, this.cku) || this.clM == null) {
                                                if (this.clM != null) {
                                                    C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "update config param");
                                                    this.clM.mo33486C(this.sampleRate, this.channels, this.cku);
                                                }
                                                obj2 = obj3;
                                            } else {
                                                C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "support audio Config");
                                                this.clM.mo33487Ds();
                                                this.clM.release();
                                                this.clM = null;
                                                obj2 = obj3;
                                            }
                                        } else {
                                            C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "dequeueOutputBuffer returned ".concat(String.valueOf(dequeueOutputBuffer)));
                                            obj2 = obj3;
                                        }
                                    } else {
                                        C45174b.m83207e("MicroMsg.Mix.AudioDecoderMediaCodec", "inputBufIndex ".concat(String.valueOf(dequeueInputBuffer)));
                                    }
                                }
                                obj3 = obj2;
                                dequeueOutputBuffer = this.bek.dequeueOutputBuffer(bufferInfo, 1000);
                                if (dequeueOutputBuffer < 0) {
                                }
                            }
                        } catch (Exception e) {
                            C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e, "onDecode", new Object[0]);
                            this.clN = 706;
                            onError(this.clN);
                            m52814DO();
                            m52815DP();
                        } catch (Throwable th) {
                            m52814DO();
                            m52815DP();
                            AppMethodBeat.m2505o(137052);
                        }
                    }
                    boolean z = (this.duration / 1000) - (this.presentationTimeUs / 1000) < FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                    if (i2 >= 50) {
                        C45174b.m83208e("MicroMsg.Mix.AudioDecoderMediaCodec", "onError, noOutputCounter:%d", Integer.valueOf(i2));
                        this.clN = 706;
                        onError(this.clN);
                    } else {
                        C45174b.m83210i("MicroMsg.Mix.AudioDecoderMediaCodec", "onStop, isComplete:%b", Boolean.valueOf(z));
                        if (z) {
                            mo33493b(DC);
                        } else {
                            DC.reset();
                        }
                    }
                    m52814DO();
                    m52815DP();
                    DC.ckA = this.clK.mo53051Ev().ckA;
                    C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "stopping...");
                    AppMethodBeat.m2505o(137052);
                } catch (Exception e2) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e2, "createDecoderByType", new Object[0]);
                    this.clN = 704;
                    onError(this.clN);
                    m52814DO();
                    m52815DP();
                    AppMethodBeat.m2505o(137052);
                }
            } catch (Exception e22) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e22, "get media format from media extractor", new Object[0]);
                this.clN = 705;
                onError(this.clN);
                m52814DO();
                AppMethodBeat.m2505o(137052);
            }
        } catch (Exception e222) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e222, "set extractor data source, sourcePath:%s", this.clO);
            this.clN = 702;
            mo20517Dz();
            AppMethodBeat.m2505o(137052);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo33492a(C37484c c37484c, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(137053);
        if (this.clM != null) {
            if (i != this.cmb) {
                this.cmb = i;
                this.cma = new byte[i];
            }
            byteBuffer.get(this.cma);
            if (this.clK.mo53051Ev().fqW) {
                C41773a.m73737a(this.cma, mo20513DM().fqN);
            }
            this.clM.mo33489F(this.cma);
            AppMethodBeat.m2505o(137053);
            return;
        }
        mo53020b(c37484c, byteBuffer, i);
        AppMethodBeat.m2505o(137053);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo53020b(C37484c c37484c, ByteBuffer byteBuffer, int i) {
        byte[] bArr;
        AppMethodBeat.m2504i(137054);
        if (3536 == i) {
            bArr = new byte[i];
            byteBuffer.get(bArr);
        } else {
            if (i != this.cmb) {
                this.cmb = i;
                this.cma = new byte[i];
            }
            Arrays.fill(this.cma, 0, this.cmb, (byte) 0);
            byteBuffer.get(this.cma, 0, this.cmb);
            bArr = this.cma;
        }
        if (this.clK.mo53051Ev().fqW) {
            C41773a.m73737a(bArr, mo20513DM().fqN);
        }
        m52816a(c37484c, bArr);
        AppMethodBeat.m2505o(137054);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo33493b(C37484c c37484c) {
        AppMethodBeat.m2504i(137055);
        if (this.clM != null) {
            this.clM.mo33487Ds();
            if (mo20502DB()) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
                this.clM.flushCache();
                AppMethodBeat.m2505o(137055);
                return;
            } else if (mo20501DA()) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
                this.clM.flushCache();
                mo20508DH();
                AppMethodBeat.m2505o(137055);
                return;
            } else {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
                mo20518a(c37484c);
                AppMethodBeat.m2505o(137055);
                return;
            }
        }
        mo53021c(c37484c);
        c37484c.complete();
        AppMethodBeat.m2505o(137055);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo53021c(C37484c c37484c) {
        AppMethodBeat.m2504i(137056);
        if (this.mSize <= 0) {
            AppMethodBeat.m2505o(137056);
            return;
        }
        if (this.mSize > 3536) {
            int i = this.mSize;
            int i2 = i / 3536;
            int i3 = i % 3536;
            for (i = 0; i < i2; i++) {
                byte[] bArr = new byte[3536];
                System.arraycopy(this.buffer, i * 3536, bArr, 0, 3536);
                m52817b(c37484c, bArr);
            }
            System.arraycopy(this.buffer, i2 * 3536, this.cmc, 0, i3);
            Arrays.fill(this.buffer, 0, this.clZ, (byte) 0);
            System.arraycopy(this.cmc, 0, this.buffer, 0, i3);
            this.mSize = i3;
        }
        if (this.mSize <= 3536) {
            byte[] bArr2 = new byte[3536];
            System.arraycopy(this.buffer, 0, bArr2, 0, this.mSize);
            m52817b(c37484c, bArr2);
            this.mSize = 0;
        }
        AppMethodBeat.m2505o(137056);
    }

    /* renamed from: a */
    private void m52816a(C37484c c37484c, byte[] bArr) {
        AppMethodBeat.m2504i(137057);
        if (bArr == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
            AppMethodBeat.m2505o(137057);
            return;
        }
        int length = bArr.length;
        if (length == 3536) {
            if (this.mSize > 0) {
                mo53021c(c37484c);
            }
            m52817b(c37484c, bArr);
            AppMethodBeat.m2505o(137057);
            return;
        }
        if (length != 3536) {
            if (length > this.clZ) {
                while (this.clZ < length) {
                    this.clZ += 3536;
                }
                byte[] bArr2 = new byte[this.clZ];
                if (this.mSize > 0) {
                    System.arraycopy(this.buffer, 0, bArr2, 0, this.mSize);
                }
                this.buffer = bArr2;
            }
            int i = this.mSize + length;
            System.arraycopy(bArr, 0, this.buffer, this.mSize, length);
            int i2 = i / 3536;
            i %= 3536;
            for (length = 0; length < i2; length++) {
                byte[] bArr3 = new byte[3536];
                System.arraycopy(this.buffer, length * 3536, bArr3, 0, 3536);
                m52817b(c37484c, bArr3);
            }
            System.arraycopy(this.buffer, i2 * 3536, this.cmc, 0, i);
            Arrays.fill(this.buffer, 0, this.clZ, (byte) 0);
            System.arraycopy(this.cmc, 0, this.buffer, 0, i);
            this.mSize = i;
        }
        AppMethodBeat.m2505o(137057);
    }

    /* renamed from: b */
    private void m52817b(C37484c c37484c, byte[] bArr) {
        AppMethodBeat.m2504i(137058);
        C45164d Dj = C37486c.m63255Dk().mo60403Dj();
        Dj.ckv = bArr;
        Dj.sampleRate = this.sampleRate;
        Dj.channels = this.channels;
        Dj.cku = this.cku;
        c37484c.mo60396a(Dj);
        mo20519a(Dj);
        AppMethodBeat.m2505o(137058);
    }

    public void onRelease() {
        AppMethodBeat.m2504i(137059);
        m52814DO();
        m52815DP();
        if (this.clM != null) {
            this.clM.mo33487Ds();
            this.clM.release();
            this.clM = null;
        }
        this.clO = null;
        this.clY = null;
        this.sampleRate = 0;
        this.channels = 0;
        this.presentationTimeUs = 0;
        this.duration = 0;
        AppMethodBeat.m2505o(137059);
    }

    /* renamed from: DO */
    private void m52814DO() {
        AppMethodBeat.m2504i(137060);
        try {
            if (this.clX != null) {
                this.clX.release();
                this.clX = null;
            }
            AppMethodBeat.m2505o(137060);
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e, "releaseMediaExtractor", new Object[0]);
            AppMethodBeat.m2505o(137060);
        }
    }

    /* renamed from: DP */
    private void m52815DP() {
        AppMethodBeat.m2504i(137061);
        try {
            if (this.bek != null) {
                this.bek.stop();
                this.bek.release();
                this.bek = null;
            }
            AppMethodBeat.m2505o(137061);
        } catch (Exception e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e, "releaseMediaCodec", new Object[0]);
            AppMethodBeat.m2505o(137061);
        }
    }
}
