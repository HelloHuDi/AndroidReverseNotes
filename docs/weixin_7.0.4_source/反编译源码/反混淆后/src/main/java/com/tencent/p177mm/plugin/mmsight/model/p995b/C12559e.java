package com.tencent.p177mm.plugin.mmsight.model.p995b;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.mmsight.model.b.e */
public final class C12559e implements C46076a {
    protected long bqO;
    protected MediaExtractor clX;
    protected long eTA;
    protected int eTJ;
    protected MediaCodec eTq;
    protected BufferInfo eTy = new BufferInfo();
    protected int eWc = -1;
    protected String fUM = null;
    protected MediaFormat fYc;
    private byte[] fYd;
    private int frameCount = 0;
    protected C46077h oxp;
    private boolean oxs = false;
    protected int sampleSize;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.b.e$1 */
    class C125601 implements Runnable {
        C125601() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76704);
            if (C12559e.this.eTq != null) {
                C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
                try {
                    C12559e.this.eTq.stop();
                    C12559e.this.eTq.release();
                    C12559e.this.eTq = null;
                    AppMethodBeat.m2505o(76704);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", e, "delay to stop decoder error: %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(76704);
        }
    }

    public C12559e() {
        AppMethodBeat.m2504i(76705);
        AppMethodBeat.m2505o(76705);
    }

    /* renamed from: e */
    public final int mo24485e(String str, long j, long j2, int i) {
        AppMethodBeat.m2504i(76706);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(76706);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        try {
            int i2;
            this.clX = new MediaExtractor();
            this.clX.setDataSource(str);
            for (i2 = 0; i2 < this.clX.getTrackCount(); i2++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i2);
                if (trackFormat.getString("mime").toLowerCase().startsWith("video/")) {
                    this.eWc = i2;
                    this.fYc = trackFormat;
                    break;
                }
            }
            if (this.eWc < 0) {
                AppMethodBeat.m2505o(76706);
                return -1;
            }
            this.fUM = str;
            this.bqO = j;
            this.eTA = j2;
            this.clX.selectTrack(this.eWc);
            String string = this.fYc.getString("mime");
            this.eTq = MediaCodec.createDecoderByType(string);
            MediaCodecInfo selectCodec = C12559e.selectCodec(string);
            C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", selectCodec);
            if (selectCodec != null) {
                C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", selectCodec.getName());
                C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", Integer.valueOf(C12559e.m20493a(selectCodec, string)));
                this.fYc.setInteger("color-format", i2);
            }
            this.eTq.configure(this.fYc, null, null, 0);
            this.eTq.start();
            AppMethodBeat.m2505o(76706);
            return 0;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", e, "Init decoder failed : %s", e.getMessage());
            AppMethodBeat.m2505o(76706);
            return -1;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.m2504i(76707);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.m2505o(76707);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(76707);
        return null;
    }

    /* renamed from: a */
    private static int m20493a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.m2504i(76708);
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long yz = C5046bo.m7588yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            int i3;
            C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            switch (i2) {
                case 19:
                case 21:
                    i3 = 1;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0 && (i2 > i || i2 == 21)) {
                i = i2;
            }
        }
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        AppMethodBeat.m2505o(76708);
        return i;
    }

    /* renamed from: UF */
    private boolean m20492UF() {
        AppMethodBeat.m2504i(76709);
        if (this.eTq == null) {
            C4990ab.m7412e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
            AppMethodBeat.m2505o(76709);
            return true;
        }
        ByteBuffer[] outputBuffers = this.eTq.getOutputBuffers();
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", Integer.valueOf(outputBuffers.length));
        int dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
        C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer >= 0) {
                        C4990ab.m7418v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.eTy.presentationTimeUs;
                        if (j < this.bqO * 1000 && (this.eTy.flags & 4) == 0) {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", Long.valueOf(j), Long.valueOf(this.bqO * 1000));
                            AppMethodBeat.m2505o(76709);
                            return false;
                        } else if (this.eTy.size != 0) {
                            byteBuffer.position(this.eTy.offset);
                            byteBuffer.limit(this.eTy.offset + this.eTy.size);
                            long yz = C5046bo.m7588yz();
                            BufferInfo bufferInfo = this.eTy;
                            if (byteBuffer == null) {
                                C4990ab.m7412e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                            } else {
                                this.frameCount++;
                                if (this.eTJ <= 1 || this.frameCount % this.eTJ != 0) {
                                    if (this.fYd == null) {
                                        this.fYd = new byte[byteBuffer.remaining()];
                                    }
                                    long yz2 = C5046bo.m7588yz();
                                    try {
                                        this.fYc = this.eTq.getOutputFormat();
                                    } catch (Exception e) {
                                        C4990ab.m7412e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
                                    }
                                    byteBuffer.get(this.fYd, 0, byteBuffer.remaining());
                                    C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(C5046bo.m7525az(yz2)));
                                    if (this.oxp != null) {
                                        boolean z;
                                        Object obj = (this.eTA == 1 || bufferInfo.presentationTimeUs < this.eTA * 1000) ? null : 1;
                                        C46077h c46077h = this.oxp;
                                        byte[] bArr = this.fYd;
                                        if (this.fYd == null || this.oxs || obj != null) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        c46077h.mo46468a(bArr, z, bufferInfo.presentationTimeUs / 1000);
                                    }
                                }
                            }
                            C4990ab.m7419v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", Long.valueOf(C5046bo.m7525az(yz)));
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if (this.eTA != 1 && j >= this.eTA * 1000) {
                                C4990ab.m7412e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
                                this.oxs = true;
                                AppMethodBeat.m2505o(76709);
                                return true;
                            } else if ((this.eTy.flags & 4) != 0) {
                                C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
                                try {
                                    this.eTq.stop();
                                    this.eTq.release();
                                    this.oxs = true;
                                    this.eTq = null;
                                } catch (Exception e2) {
                                    C4990ab.m7413e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", e2.getMessage());
                                }
                                AppMethodBeat.m2505o(76709);
                                return true;
                            } else {
                                AppMethodBeat.m2505o(76709);
                                return false;
                            }
                        } else {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                    }
                } else {
                    this.fYc = this.eTq.getOutputFormat();
                    C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.fYc);
                }
            } else {
                outputBuffers = this.eTq.getOutputBuffers();
                C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
            }
            dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
        AppMethodBeat.m2505o(76709);
        return false;
    }

    /* JADX WARNING: Missing block: B:11:0x0071, code skipped:
            if (m20492UF() == false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bPZ() {
        int dequeueInputBuffer;
        long yz;
        AppMethodBeat.m2504i(76710);
        this.frameCount = 0;
        this.oxs = false;
        do {
            boolean z;
            MediaExtractor mediaExtractor = this.clX;
            if (this.eTq == null) {
                C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
                z = true;
            } else {
                ByteBuffer[] inputBuffers = this.eTq.getInputBuffers();
                if (inputBuffers == null) {
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", Integer.valueOf(inputBuffers.length));
                    int i = 0;
                    while (true) {
                        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
                        if (dequeueInputBuffer < 0 && i < 15) {
                            yz = C5046bo.m7588yz();
                            boolean UF = m20492UF();
                            C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", Long.valueOf(C5046bo.m7525az(yz)));
                            if (UF) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                        byteBuffer.clear();
                        this.sampleSize = mediaExtractor.readSampleData(byteBuffer, 0);
                        byteBuffer.position(0);
                        yz = mediaExtractor.getSampleTime();
                        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", Long.valueOf(yz));
                        if (this.sampleSize < 0 || yz >= this.eTA * 1000) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", Boolean.valueOf(z));
                        this.eTq.queueInputBuffer(dequeueInputBuffer, 0, this.sampleSize, yz, z ? 4 : 0);
                    } else {
                        C4990ab.m7420w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
                        z = false;
                    }
                    long yz2 = C5046bo.m7588yz();
                    boolean UF2 = m20492UF();
                    C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", Long.valueOf(C5046bo.m7525az(yz2)));
                    if (UF2) {
                        z = true;
                    }
                }
            }
            if (z) {
                break;
            }
            this.clX.advance();
        } while (this.clX.getSampleTrackIndex() == this.eWc);
        C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
        MediaExtractor mediaExtractor2 = this.clX;
        C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
        ByteBuffer[] inputBuffers2 = this.eTq.getInputBuffers();
        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
        if (dequeueInputBuffer < 0) {
            C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(0));
        }
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers2[dequeueInputBuffer];
            byteBuffer2.clear();
            this.sampleSize = mediaExtractor2.readSampleData(byteBuffer2, 0);
            byteBuffer2.position(0);
            yz = mediaExtractor2.getSampleTime();
            if (dequeueInputBuffer >= 0) {
                C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", Integer.valueOf(dequeueInputBuffer));
                this.eTq.queueInputBuffer(dequeueInputBuffer, 0, 0, yz * 1000, 4);
            } else {
                C4990ab.m7420w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
            }
        }
        this.oxs = true;
        m20492UF();
        C5004al.m7442n(new C125601(), 500);
        this.clX.release();
        AppMethodBeat.m2505o(76710);
    }

    /* renamed from: a */
    public final void mo24481a(C46077h c46077h) {
        this.oxp = c46077h;
    }

    public final int alK() {
        AppMethodBeat.m2504i(76711);
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", Integer.valueOf(this.fYc.getInteger("color-format")));
        switch (this.fYc.getInteger("color-format")) {
            case 19:
                AppMethodBeat.m2505o(76711);
                return 2;
            case 21:
            case 2130706688:
                AppMethodBeat.m2505o(76711);
                return 1;
            default:
                AppMethodBeat.m2505o(76711);
                return 1;
        }
    }

    public final Point alJ() {
        AppMethodBeat.m2504i(76712);
        Point point = new Point(this.fYc.getInteger("width"), this.fYc.getInteger("height"));
        AppMethodBeat.m2505o(76712);
        return point;
    }

    /* renamed from: mp */
    public final void mo24486mp(int i) {
        AppMethodBeat.m2504i(76713);
        C4990ab.m7417i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.eTJ = i;
        AppMethodBeat.m2505o(76713);
    }
}
