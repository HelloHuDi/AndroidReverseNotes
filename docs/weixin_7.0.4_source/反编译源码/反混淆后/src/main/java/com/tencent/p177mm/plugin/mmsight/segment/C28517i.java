package com.tencent.p177mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.C46082e.C12578a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.i */
public class C28517i implements C46082e {
    protected long bqO;
    protected MediaExtractor clX;
    protected long eTA;
    protected int eTJ;
    protected MediaCodec eTq;
    protected BufferInfo eTy = new BufferInfo();
    protected int eWc;
    protected String fUM = null;
    protected MediaFormat fYc;
    private byte[] fYd;
    private int frameCount = 0;
    protected C12578a oxF;
    protected int sampleSize;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.i$1 */
    class C285161 implements Runnable {
        C285161() {
        }

        public final void run() {
            AppMethodBeat.m2504i(3663);
            if (C28517i.this.eTq != null) {
                C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
                try {
                    C28517i.this.eTq.stop();
                    C28517i.this.eTq.release();
                    C28517i.this.eTq = null;
                    AppMethodBeat.m2505o(3663);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "delay to stop decoder error: %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(3663);
        }
    }

    public C28517i(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        AppMethodBeat.m2504i(3664);
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", mediaExtractor, mediaFormat, Integer.valueOf(i));
        this.clX = mediaExtractor;
        this.fYc = mediaFormat;
        this.eWc = i;
        AppMethodBeat.m2505o(3664);
    }

    /* renamed from: i */
    public final int mo24498i(String str, long j, long j2) {
        AppMethodBeat.m2504i(3665);
        this.fUM = str;
        this.bqO = j;
        this.eTA = j2;
        C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.fYc + "]");
        try {
            String string = this.fYc.getString("mime");
            this.eTq = MediaCodec.createDecoderByType(string);
            MediaCodecInfo selectCodec = C28517i.selectCodec(string);
            C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", selectCodec);
            if (selectCodec != null) {
                C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", selectCodec.getName());
                C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", Integer.valueOf(mo24514a(selectCodec, string)));
                this.fYc.setInteger("color-format", r1);
            }
            this.eTq.configure(this.fYc, null, null, 0);
            this.eTq.start();
            AppMethodBeat.m2505o(3665);
            return 0;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "Init decoder failed : %s", e.getMessage());
            AppMethodBeat.m2505o(3665);
            return -1;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.m2504i(3666);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.m2505o(3666);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(3666);
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public int mo24514a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.m2504i(3667);
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long yz = C5046bo.m7588yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (mo24515mr(i2) && (i2 > i || i2 == 21)) {
                i = i2;
            }
        }
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        AppMethodBeat.m2505o(3667);
        return i;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: mr */
    public boolean mo24515mr(int i) {
        switch (i) {
            case 19:
            case 21:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: UF */
    public boolean mo24513UF() {
        AppMethodBeat.m2504i(3668);
        if (this.eTq == null) {
            C4990ab.m7412e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
            AppMethodBeat.m2505o(3668);
            return true;
        }
        ByteBuffer[] outputBuffers = this.eTq.getOutputBuffers();
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", Integer.valueOf(outputBuffers.length));
        int dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
        C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer >= 0) {
                        C4990ab.m7418v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.eTy.presentationTimeUs;
                        if (j < this.bqO * 1000 && (this.eTy.flags & 4) == 0) {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", Long.valueOf(j), Long.valueOf(this.bqO * 1000));
                            AppMethodBeat.m2505o(3668);
                            return false;
                        } else if (this.eTy.size != 0) {
                            byteBuffer.position(this.eTy.offset);
                            byteBuffer.limit(this.eTy.offset + this.eTy.size);
                            long yz = C5046bo.m7588yz();
                            BufferInfo bufferInfo = this.eTy;
                            if (byteBuffer == null) {
                                C4990ab.m7412e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
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
                                        C4990ab.m7412e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                                    }
                                    byteBuffer.get(this.fYd, 0, byteBuffer.remaining());
                                    C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(C5046bo.m7525az(yz2)));
                                    if (this.oxF != null) {
                                        this.oxF.mo24511ba(this.fYd);
                                    }
                                }
                            }
                            C4990ab.m7419v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", Long.valueOf(C5046bo.m7525az(yz)));
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if (this.eTA != 1 && j >= this.eTA * 1000) {
                                C4990ab.m7412e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
                                AppMethodBeat.m2505o(3668);
                                return true;
                            } else if ((this.eTy.flags & 4) != 0) {
                                C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
                                try {
                                    this.eTq.stop();
                                    this.eTq.release();
                                    this.eTq = null;
                                } catch (Exception e2) {
                                    C4990ab.m7413e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", e2.getMessage());
                                }
                                AppMethodBeat.m2505o(3668);
                                return true;
                            } else {
                                AppMethodBeat.m2505o(3668);
                                return false;
                            }
                        } else {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                    }
                } else {
                    this.fYc = this.eTq.getOutputFormat();
                    C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.fYc);
                }
            } else {
                outputBuffers = this.eTq.getOutputBuffers();
                C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
            }
            dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
        AppMethodBeat.m2505o(3668);
        return false;
    }

    /* JADX WARNING: Missing block: B:11:0x006d, code skipped:
            if (mo24513UF() == false) goto L_0x006f;
     */
    /* JADX WARNING: Missing block: B:32:0x0112, code skipped:
            if (r1 < 0) goto L_0x018e;
     */
    /* JADX WARNING: Missing block: B:33:0x0114, code skipped:
            r3 = r3[r1];
            r3.clear();
            r10.sampleSize = r2.readSampleData(r3, 0);
            r3.position(0);
            r4 = r2.getSampleTime();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", java.lang.Long.valueOf(r4));
     */
    /* JADX WARNING: Missing block: B:34:0x013d, code skipped:
            if (r10.sampleSize < 0) goto L_0x0148;
     */
    /* JADX WARNING: Missing block: B:36:0x0146, code skipped:
            if (r4 < (r10.eTA * 1000)) goto L_0x01a4;
     */
    /* JADX WARNING: Missing block: B:37:0x0148, code skipped:
            r7 = true;
     */
    /* JADX WARNING: Missing block: B:38:0x014a, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", java.lang.Boolean.valueOf(r7));
            r0 = r10.eTq;
            r3 = r10.sampleSize;
     */
    /* JADX WARNING: Missing block: B:39:0x0162, code skipped:
            if (r7 == false) goto L_0x018c;
     */
    /* JADX WARNING: Missing block: B:40:0x0164, code skipped:
            r6 = 4;
     */
    /* JADX WARNING: Missing block: B:41:0x0165, code skipped:
            r0.queueInputBuffer(r1, 0, r3, r4, r6);
     */
    /* JADX WARNING: Missing block: B:42:0x0168, code skipped:
            r0 = com.tencent.p177mm.sdk.platformtools.C5046bo.m7588yz();
            r2 = mo24513UF();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", java.lang.Long.valueOf(com.tencent.p177mm.sdk.platformtools.C5046bo.m7525az(r0)));
     */
    /* JADX WARNING: Missing block: B:43:0x0187, code skipped:
            if (r2 == false) goto L_0x0018;
     */
    /* JADX WARNING: Missing block: B:44:0x0189, code skipped:
            r7 = true;
     */
    /* JADX WARNING: Missing block: B:45:0x018c, code skipped:
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:46:0x018e, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
            r7 = false;
     */
    /* JADX WARNING: Missing block: B:48:0x01a4, code skipped:
            r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: z */
    public final void mo24501z(Runnable runnable) {
        int dequeueInputBuffer;
        long yz;
        AppMethodBeat.m2504i(3669);
        this.frameCount = 0;
        do {
            boolean z;
            MediaExtractor mediaExtractor = this.clX;
            if (this.eTq == null) {
                C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
                z = true;
            } else {
                ByteBuffer[] inputBuffers = this.eTq.getInputBuffers();
                if (inputBuffers == null) {
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", Integer.valueOf(inputBuffers.length));
                    int i = 0;
                    while (true) {
                        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
                        if (dequeueInputBuffer < 0 && i < 15) {
                            yz = C5046bo.m7588yz();
                            boolean UF = mo24513UF();
                            C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", Long.valueOf(C5046bo.m7525az(yz)));
                            if (UF) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            if (z) {
                break;
            }
            this.clX.advance();
        } while (this.clX.getSampleTrackIndex() == this.eWc);
        C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
        MediaExtractor mediaExtractor2 = this.clX;
        C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
        ByteBuffer[] inputBuffers2 = this.eTq.getInputBuffers();
        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
        if (dequeueInputBuffer < 0) {
            C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(0));
        }
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers2[dequeueInputBuffer];
            byteBuffer.clear();
            this.sampleSize = mediaExtractor2.readSampleData(byteBuffer, 0);
            byteBuffer.position(0);
            yz = mediaExtractor2.getSampleTime();
            if (dequeueInputBuffer >= 0) {
                C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", Integer.valueOf(dequeueInputBuffer));
                this.eTq.queueInputBuffer(dequeueInputBuffer, 0, 0, yz * 1000, 4);
            } else {
                C4990ab.m7420w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
            }
        }
        mo24513UF();
        C5004al.m7442n(new C285161(), 500);
        runnable.run();
        AppMethodBeat.m2505o(3669);
    }

    /* renamed from: a */
    public final void mo24495a(C12578a c12578a) {
        this.oxF = c12578a;
    }

    public int alK() {
        AppMethodBeat.m2504i(3670);
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", Integer.valueOf(this.fYc.getInteger("color-format")));
        switch (this.fYc.getInteger("color-format")) {
            case 19:
                AppMethodBeat.m2505o(3670);
                return 2;
            case 21:
            case 2130706688:
                AppMethodBeat.m2505o(3670);
                return 1;
            default:
                AppMethodBeat.m2505o(3670);
                return 1;
        }
    }

    public final Point alJ() {
        AppMethodBeat.m2504i(3671);
        Point point = new Point(this.fYc.getInteger("width"), this.fYc.getInteger("height"));
        AppMethodBeat.m2505o(3671);
        return point;
    }

    public final void stop() {
        AppMethodBeat.m2504i(3672);
        if (this.eTq != null) {
            try {
                C4990ab.m7416i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
                this.eTq.stop();
                this.eTq.release();
                this.eTq = null;
                AppMethodBeat.m2505o(3672);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "stop decoder error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(3672);
    }

    /* renamed from: mp */
    public final void mo24499mp(int i) {
        AppMethodBeat.m2504i(3673);
        C4990ab.m7417i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.eTJ = i;
        AppMethodBeat.m2505o(3673);
    }
}
