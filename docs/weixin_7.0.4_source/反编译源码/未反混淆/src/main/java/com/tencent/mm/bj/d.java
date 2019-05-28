package com.tencent.mm.bj;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class d implements a {
    protected long bqO;
    protected MediaExtractor clX;
    protected long eTA;
    protected int eTJ;
    private int eTl = -1;
    protected MediaCodec eTq;
    protected BufferInfo eTy = new BufferInfo();
    protected int eWc;
    protected String fUM = null;
    protected a fYb;
    protected MediaFormat fYc;
    private byte[] fYd;
    private int frameCount = 0;
    protected int sampleSize;

    public d(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        AppMethodBeat.i(50908);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", mediaExtractor, mediaFormat, Integer.valueOf(i));
        this.clX = mediaExtractor;
        this.fYc = mediaFormat;
        this.eWc = i;
        AppMethodBeat.o(50908);
    }

    public final int i(String str, long j, long j2) {
        AppMethodBeat.i(50909);
        this.fUM = str;
        this.bqO = j;
        this.eTA = j2;
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.fYc + "]");
        try {
            String string = this.fYc.getString("mime");
            this.eTq = MediaCodec.createDecoderByType(string);
            MediaCodecInfo selectCodec = selectCodec(string);
            ab.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", selectCodec);
            if (selectCodec != null) {
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", selectCodec.getName());
                this.eTl = a(selectCodec, string);
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", Integer.valueOf(this.eTl));
                this.fYc.setInteger("color-format", this.eTl);
            }
            this.eTq.configure(this.fYc, null, null, 0);
            this.eTq.start();
            AppMethodBeat.o(50909);
            return 0;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "Init decoder failed : %s", e.getMessage());
            AppMethodBeat.o(50909);
            return -1;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.i(50910);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(50910);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(50910);
        return null;
    }

    private static int a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(50911);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long yz = bo.yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", Long.valueOf(bo.az(yz)));
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            int i3;
            ab.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
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
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        AppMethodBeat.o(50911);
        return i;
    }

    private boolean UF() {
        AppMethodBeat.i(50912);
        if (this.eTq == null) {
            ab.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
            AppMethodBeat.o(50912);
            return true;
        }
        ByteBuffer[] outputBuffers = this.eTq.getOutputBuffers();
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", Integer.valueOf(outputBuffers.length));
        int dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer >= 0) {
                        ab.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.eTy.presentationTimeUs;
                        if (j < this.bqO * 1000 && (this.eTy.flags & 4) == 0) {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", Long.valueOf(j), Long.valueOf(this.bqO * 1000));
                            AppMethodBeat.o(50912);
                            return false;
                        } else if (this.eTy.size != 0) {
                            byteBuffer.position(this.eTy.offset);
                            byteBuffer.limit(this.eTy.offset + this.eTy.size);
                            long yz = bo.yz();
                            BufferInfo bufferInfo = this.eTy;
                            if (byteBuffer == null) {
                                ab.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                            } else {
                                this.frameCount++;
                                if (this.eTJ <= 1 || this.frameCount % this.eTJ != 0) {
                                    if (this.fYd == null) {
                                        this.fYd = new byte[byteBuffer.remaining()];
                                    }
                                    long yz2 = bo.yz();
                                    try {
                                        this.fYc = this.eTq.getOutputFormat();
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                                    }
                                    byteBuffer.get(this.fYd, 0, byteBuffer.remaining());
                                    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(bo.az(yz2)));
                                    if (this.fYb != null) {
                                        boolean z;
                                        a aVar = this.fYb;
                                        byte[] bArr = this.fYd;
                                        if ((bufferInfo.flags & 4) != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        aVar.a(bArr, z, bufferInfo.presentationTimeUs);
                                    }
                                }
                            }
                            ab.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", Long.valueOf(bo.az(yz)));
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if (this.eTA != 1 && j >= this.eTA * 1000) {
                                ab.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
                                AppMethodBeat.o(50912);
                                return true;
                            } else if ((this.eTy.flags & 4) != 0) {
                                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
                                try {
                                    this.eTq.stop();
                                    this.eTq.release();
                                    this.eTq = null;
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", e2.getMessage());
                                }
                                AppMethodBeat.o(50912);
                                return true;
                            } else {
                                AppMethodBeat.o(50912);
                                return false;
                            }
                        } else {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    } else {
                        ab.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                    }
                } else {
                    this.fYc = this.eTq.getOutputFormat();
                    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.fYc);
                }
            } else {
                outputBuffers = this.eTq.getOutputBuffers();
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
            }
            dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
        AppMethodBeat.o(50912);
        return false;
    }

    /* JADX WARNING: Missing block: B:11:0x006e, code skipped:
            if (UF() == false) goto L_0x0070;
     */
    /* JADX WARNING: Missing block: B:32:0x0114, code skipped:
            if (r1 < 0) goto L_0x0190;
     */
    /* JADX WARNING: Missing block: B:33:0x0116, code skipped:
            r3 = r3[r1];
            r3.clear();
            r10.sampleSize = r2.readSampleData(r3, 0);
            r3.position(0);
            r4 = r2.getSampleTime();
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", java.lang.Long.valueOf(r4));
     */
    /* JADX WARNING: Missing block: B:34:0x013f, code skipped:
            if (r10.sampleSize < 0) goto L_0x014a;
     */
    /* JADX WARNING: Missing block: B:36:0x0148, code skipped:
            if (r4 < (r10.eTA * 1000)) goto L_0x01a6;
     */
    /* JADX WARNING: Missing block: B:37:0x014a, code skipped:
            r7 = true;
     */
    /* JADX WARNING: Missing block: B:38:0x014c, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", java.lang.Boolean.valueOf(r7));
            r0 = r10.eTq;
            r3 = r10.sampleSize;
     */
    /* JADX WARNING: Missing block: B:39:0x0164, code skipped:
            if (r7 == false) goto L_0x018e;
     */
    /* JADX WARNING: Missing block: B:40:0x0166, code skipped:
            r6 = 4;
     */
    /* JADX WARNING: Missing block: B:41:0x0167, code skipped:
            r0.queueInputBuffer(r1, 0, r3, r4, r6);
     */
    /* JADX WARNING: Missing block: B:42:0x016a, code skipped:
            r0 = com.tencent.mm.sdk.platformtools.bo.yz();
            r2 = UF();
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", java.lang.Long.valueOf(com.tencent.mm.sdk.platformtools.bo.az(r0)));
     */
    /* JADX WARNING: Missing block: B:43:0x0189, code skipped:
            if (r2 == false) goto L_0x0019;
     */
    /* JADX WARNING: Missing block: B:44:0x018b, code skipped:
            r7 = true;
     */
    /* JADX WARNING: Missing block: B:45:0x018e, code skipped:
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:46:0x0190, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
            r7 = false;
     */
    /* JADX WARNING: Missing block: B:48:0x01a6, code skipped:
            r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(Runnable runnable) {
        int dequeueInputBuffer;
        long yz;
        AppMethodBeat.i(50913);
        this.frameCount = 0;
        do {
            boolean z;
            MediaExtractor mediaExtractor = this.clX;
            if (this.eTq == null) {
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
                z = true;
            } else {
                ByteBuffer[] inputBuffers = this.eTq.getInputBuffers();
                if (inputBuffers == null) {
                    z = false;
                } else {
                    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", Integer.valueOf(inputBuffers.length));
                    int i = 0;
                    while (true) {
                        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
                        if (dequeueInputBuffer < 0 && i < 15) {
                            yz = bo.yz();
                            boolean UF = UF();
                            ab.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", Long.valueOf(bo.az(yz)));
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
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
        MediaExtractor mediaExtractor2 = this.clX;
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
        ByteBuffer[] inputBuffers2 = this.eTq.getInputBuffers();
        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
        if (dequeueInputBuffer < 0) {
            ab.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(0));
        }
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers2[dequeueInputBuffer];
            byteBuffer.clear();
            this.sampleSize = mediaExtractor2.readSampleData(byteBuffer, 0);
            byteBuffer.position(0);
            yz = mediaExtractor2.getSampleTime();
            if (dequeueInputBuffer >= 0) {
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", Integer.valueOf(dequeueInputBuffer));
                this.eTq.queueInputBuffer(dequeueInputBuffer, 0, 0, yz * 1000, 4);
            } else {
                ab.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
            }
        }
        UF();
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50907);
                if (d.this.eTq != null) {
                    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
                    try {
                        d.this.eTq.stop();
                        d.this.eTq.release();
                        d.this.eTq = null;
                        AppMethodBeat.o(50907);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "delay to stop decoder error: %s", e.getMessage());
                    }
                }
                AppMethodBeat.o(50907);
            }
        }, 500);
        runnable.run();
        AppMethodBeat.o(50913);
    }

    public final void a(a aVar) {
        this.fYb = aVar;
    }

    public final int alK() {
        AppMethodBeat.i(50914);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", Integer.valueOf(this.eTl));
        switch (this.eTl) {
            case 19:
                AppMethodBeat.o(50914);
                return 2;
            case 21:
            case 2130706688:
                AppMethodBeat.o(50914);
                return 1;
            default:
                AppMethodBeat.o(50914);
                return 1;
        }
    }

    public final Point alJ() {
        AppMethodBeat.i(50915);
        Point point = new Point(this.fYc.getInteger("width"), this.fYc.getInteger("height"));
        AppMethodBeat.o(50915);
        return point;
    }

    public final void stop() {
        AppMethodBeat.i(50916);
        if (this.eTq != null) {
            try {
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
                this.eTq.stop();
                this.eTq.release();
                this.eTq = null;
                AppMethodBeat.o(50916);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "stop decoder error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(50916);
    }

    public final void mp(int i) {
        AppMethodBeat.i(50917);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.eTJ = i;
        AppMethodBeat.o(50917);
    }
}
